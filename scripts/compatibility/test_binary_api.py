"""Offline javac/JVM fixtures for the declared API comparator."""

from pathlib import Path
import os
import shutil
import struct
import subprocess
import sys
import tempfile
import unittest
import zipfile
import zlib

from check_binary_api import compare, read_jar

try:
    import lzma
except ImportError:
    lzma = None


def class_header_offset(data):
    """Locate access_flags so fixtures can transform the header independently."""
    count = struct.unpack_from(">H", data, 8)[0]
    offset, index = 10, 1
    widths = {
        3: 4,
        4: 4,
        5: 8,
        6: 8,
        7: 2,
        8: 2,
        9: 4,
        10: 4,
        11: 4,
        12: 4,
        15: 3,
        16: 2,
        17: 4,
        18: 4,
        19: 2,
        20: 2,
    }
    while index < count:
        tag = data[offset]
        offset += 1
        if tag == 1:
            offset += 2 + struct.unpack_from(">H", data, offset)[0]
        else:
            offset += widths[tag]
        index += 2 if tag in (5, 6) else 1
    return offset


@unittest.skipUnless(shutil.which("javac") and shutil.which("java"), "requires a JDK")
class BinaryApiTest(unittest.TestCase):
    def setUp(self):
        self.temp = tempfile.TemporaryDirectory()
        self.addCleanup(self.temp.cleanup)
        self.root = Path(self.temp.name)
        self.sequence = 0

    def compile_jar(self, sources, release="8"):
        self.sequence += 1
        root = self.root / str(self.sequence)
        classes = root / "classes"
        classes.mkdir(parents=True)
        files = []
        for name, source in sources.items():
            path = root / name
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text(source)
            files.append(str(path))
        subprocess.run(
            ["javac", "--release", release, "-d", str(classes), *files],
            check=True,
            capture_output=True,
        )
        jar = root / "api.jar"
        with zipfile.ZipFile(jar, "w") as archive:
            for path in classes.rglob("*.class"):
                archive.write(path, path.relative_to(classes).as_posix())
        return jar

    def issues(self, before, after):
        old = self.compile_jar({"Api.java": before})
        new = self.compile_jar({"Api.java": after})
        return compare(read_jar(old), read_jar(new))

    def test_additive_methods_and_private_changes_pass(self):
        self.assertEqual(
            [],
            self.issues(
                'public class Api { private int hidden; public String value() { return "old"; } }',
                'public class Api { private long other; public String value() { return "new"; } public void added() {} }',
            ),
        )

    def test_method_return_descriptor_change(self):
        issues = self.issues(
            "public class Api { public String value() { return null; } }",
            "public class Api { public Object value() { return null; } }",
        )
        self.assertTrue(any("#value ()Ljava/lang/String;" in issue for issue in issues))

    def test_protected_members_of_hidden_ancestors_break_old_subclass(self):
        sources = {
            "api/Api.java": "package api; public class Api extends Middle {}",
            "api/Middle.java": "package api; class Middle extends Base {}",
            "api/Base.java": 'package api; class Base { protected String value() { return "ok"; } protected int number = 7; }',
        }
        old = self.compile_jar(sources)
        new = self.compile_jar(
            {**sources, "api/Base.java": "package api; class Base {}"}
        )
        client = self.root / "Consumer.java"
        client.write_text(
            'package client; public class Consumer extends api.Api { public static void main(String[] args) { Consumer value = new Consumer(); if (args[0].equals("field")) System.out.print(value.number); else System.out.print(value.value()); } }'
        )
        output = self.root / "client"
        subprocess.run(
            [
                "javac",
                "--release",
                "8",
                "-cp",
                str(old),
                "-d",
                str(output),
                str(client),
            ],
            check=True,
            capture_output=True,
        )
        for mode, text, error in [
            ("method", "ok", "NoSuchMethodError"),
            ("field", "7", "NoSuchFieldError"),
        ]:
            for replacement in (old, new):
                with self.subTest(mode=mode, replacement=replacement):
                    result = subprocess.run(
                        [
                            "java",
                            "-cp",
                            str(output) + os.pathsep + str(replacement),
                            "client.Consumer",
                            mode,
                        ],
                        capture_output=True,
                        text=True,
                    )
                    if replacement == old:
                        self.assertEqual(0, result.returncode, result.stderr)
                        self.assertEqual(text, result.stdout)
                    else:
                        self.assertNotEqual(0, result.returncode)
                        self.assertIn(error, result.stderr)
        issues = compare(read_jar(old), read_jar(new))
        for descriptor in ("api/Base#value ()Ljava/lang/String;", "api/Base#number I"):
            with self.subTest(descriptor=descriptor):
                self.assertTrue(any(descriptor in issue for issue in issues), issues)

    def test_unrelated_hidden_classes_are_not_api(self):
        sources = {
            "Api.java": "public class Api {}",
            "Hidden.java": "class Hidden { protected void removed() {} }",
        }
        old = self.compile_jar(sources)
        new = self.compile_jar({**sources, "Hidden.java": "class Hidden {}"})
        self.assertNotIn("Hidden", read_jar(old))
        self.assertEqual([], compare(read_jar(old), read_jar(new)))

    def test_hidden_interface_ancestors_are_retained(self):
        sources = {
            "Api.java": "public interface Api extends Middle {}",
            "Middle.java": "interface Middle extends Base {}",
            "Base.java": "interface Base { default void removed() {} }",
        }
        old = self.compile_jar(sources)
        new = self.compile_jar({**sources, "Base.java": "interface Base {}"})
        self.assertIn(
            "Base#removed ()V: method removed, inaccessible, or descriptor changed",
            compare(read_jar(old), read_jar(new)),
        )

    def test_constructor_field_and_class_removal(self):
        issues = self.issues(
            "public class Api { public Api(String s) {} protected int value; public static class Nested {} }",
            "public class Api { public Api() {} protected long value; }",
        )
        for expected in (
            "#<init> (Ljava/lang/String;)V",
            "#value I",
            "Api$Nested: exported class removed",
        ):
            self.assertTrue(any(expected in issue for issue in issues), issues)

    def test_flags_and_visibility(self):
        issues = self.issues(
            "public class Api { public int field; public void method() {} protected void extend() {} }",
            "public final class Api { protected static int field; public final void method() {} private void extend() {} }",
        )
        for expected in (
            "class final",
            "visibility narrowed",
            "static/instance",
            "became final",
            "#extend",
        ):
            self.assertTrue(any(expected in issue for issue in issues), issues)

    def test_interface_default_becoming_abstract_and_new_obligation(self):
        issues = self.issues(
            "public interface Api { default void run() {} }",
            "public interface Api { void run(); void added(); }",
        )
        self.assertTrue(any("#run ()V: became abstract" in issue for issue in issues))
        self.assertTrue(
            any("#added ()V: abstract method added" in issue for issue in issues)
        )

    def test_class_kind_and_hierarchy_changes(self):
        self.assertTrue(
            any(
                "kind changed" in issue
                for issue in self.issues(
                    "public interface Api {}",
                    "public class Api {}",
                )
            )
        )
        self.assertTrue(
            any(
                "superclass changed" in issue
                for issue in self.issues(
                    "public class Api implements Runnable { public void run() {} }",
                    "public class Api { public void run() {} }",
                )
            )
        )

    def test_added_superinterface_can_break_an_old_implementation(self):
        old = self.compile_jar(
            {
                "Api.java": "public interface Api {}",
                "Invoker.java": "public class Invoker { public static void run(Api value) {} }",
            }
        )
        new = self.compile_jar(
            {
                "Api.java": "public interface Api extends Requirement {}",
                "Requirement.java": "public interface Requirement { void added(); }",
                "Invoker.java": "public class Invoker { public static void run(Api value) { value.added(); } }",
            }
        )
        client = self.root / "Consumer.java"
        client.write_text(
            "public class Consumer implements Api { public static void main(String[] args) { Invoker.run(new Consumer()); } }"
        )
        output = self.root / "client"
        subprocess.run(
            [
                "javac",
                "--release",
                "8",
                "-cp",
                str(old),
                "-d",
                str(output),
                str(client),
            ],
            check=True,
            capture_output=True,
        )
        for replacement, expected_status in [(old, 0), (new, 1)]:
            result = subprocess.run(
                [
                    "java",
                    "-cp",
                    str(output) + os.pathsep + str(replacement),
                    "Consumer",
                ],
                capture_output=True,
                text=True,
            )
            self.assertEqual(expected_status, result.returncode, result.stderr)
            if expected_status:
                self.assertIn("AbstractMethodError", result.stderr)
        self.assertIn(
            "Api: direct interface added: Requirement",
            compare(read_jar(old), read_jar(new)),
        )

    def test_added_marker_interface_is_conservatively_reported(self):
        for before, after in [
            (
                "public interface Api {}",
                "public interface Api extends java.io.Serializable {}",
            ),
            (
                "public class Api {}",
                "public class Api implements java.io.Serializable {}",
            ),
        ]:
            with self.subTest(before=before):
                self.assertIn(
                    "Api: direct interface added: java/io/Serializable",
                    self.issues(before, after),
                )

    def test_protected_nested_class_access_is_counted(self):
        issues = self.issues(
            "public class Api { protected static class Nested { public void run() {} } }",
            "public class Api { private static class Nested { public void run() {} } }",
        )
        self.assertTrue(
            any("Api$Nested: exported class removed" in issue for issue in issues),
            issues,
        )

    def test_nested_class_header_modifiers_survive_stale_inner_classes(self):
        old = self.compile_jar(
            {"Api.java": "public class Api { public static class Nested {} }"}
        )
        with zipfile.ZipFile(old) as archive:
            entries = [(info, archive.read(info)) for info in archive.infolist()]
        for flag, label in [(0x0010, "final"), (0x0400, "abstract")]:
            with self.subTest(modifier=label):
                changed = self.root / f"nested-{label}.jar"
                with zipfile.ZipFile(changed, "w") as archive:
                    for info, content in entries:
                        if info.filename == "Api$Nested.class":
                            content = bytearray(content)
                            offset = class_header_offset(content)
                            flags = struct.unpack_from(">H", content, offset)[0]
                            struct.pack_into(">H", content, offset, flags | flag)
                            # Leave the original InnerClasses attribute unchanged.
                        archive.writestr(info, content)
                self.assertIn(
                    f"Api$Nested: class {label} modifier changed",
                    compare(read_jar(old), read_jar(changed)),
                )

    def test_raised_bytecode_target_is_reported(self):
        source = {"Api.java": "public class Api {}"}
        old = self.compile_jar(source)
        new = self.compile_jar(source, release="9")
        issues = compare(read_jar(old), read_jar(new))
        self.assertTrue(
            any(
                "class file version increased (52, 0) -> (53, 0)" in issue
                for issue in issues
            ),
            issues,
        )

    def test_synthetic_bridge_is_preserved(self):
        old = self.compile_jar(
            {
                "Base.java": "public class Base<T> { public T value() { return null; } }",
                "Api.java": 'public class Api extends Base<String> { public String value() { return "old"; } }',
            }
        )
        new = self.compile_jar(
            {
                "Base.java": "public class Base<T> { public T value() { return null; } }",
                "Api.java": 'public class Api extends Base<String> { public String value() { return "new"; } }',
            }
        )
        api = read_jar(old)
        self.assertIn(("value", "()Ljava/lang/Object;"), api["Api"].methods)
        self.assertEqual([], compare(api, read_jar(new)))

    def test_old_consumer_runs_without_recompilation_and_detects_real_linkage_failure(
        self,
    ):
        old = self.compile_jar(
            {"Api.java": 'public class Api { public String value() { return "ok"; } }'}
        )
        good = self.compile_jar(
            {
                "Api.java": 'public class Api { public String value() { return "ok"; } public void added() {} }'
            }
        )
        broken = self.compile_jar(
            {"Api.java": 'public class Api { public Object value() { return "ok"; } }'}
        )
        client = self.root / "Consumer.java"
        client.write_text(
            "public class Consumer { public static void main(String[] args) { System.out.print(new Api().value()); } }"
        )
        output = self.root / "client"
        subprocess.run(
            [
                "javac",
                "--release",
                "8",
                "-cp",
                str(old),
                "-d",
                str(output),
                str(client),
            ],
            check=True,
            capture_output=True,
        )
        for replacement in (old, good):
            result = subprocess.run(
                [
                    "java",
                    "-cp",
                    str(output) + os.pathsep + str(replacement),
                    "Consumer",
                ],
                capture_output=True,
                text=True,
            )
            self.assertEqual(0, result.returncode, result.stderr)
            self.assertEqual("ok", result.stdout)
        failed = subprocess.run(
            ["java", "-cp", str(output) + os.pathsep + str(broken), "Consumer"],
            capture_output=True,
            text=True,
        )
        self.assertNotEqual(0, failed.returncode)
        self.assertIn("NoSuchMethodError", failed.stderr)
        self.assertTrue(compare(read_jar(old), read_jar(broken)))

    def test_cli_exit_codes_and_bad_input(self):
        old = self.compile_jar({"Api.java": "public class Api {}"})
        script = Path(__file__).with_name("check_binary_api.py")
        self.assertEqual(
            0,
            subprocess.run(
                [sys.executable, str(script), str(old), str(old)], capture_output=True
            ).returncode,
        )
        changed = self.compile_jar(
            {"Api.java": "public class Api { private Api() {} }"}
        )
        self.assertEqual(
            1,
            subprocess.run(
                [sys.executable, str(script), str(old), str(changed)],
                capture_output=True,
            ).returncode,
        )
        bad = self.root / "bad.jar"
        bad.write_bytes(b"not a jar")
        self.assertEqual(
            2,
            subprocess.run(
                [sys.executable, str(script), str(old), str(bad)], capture_output=True
            ).returncode,
        )
        broken = self.compile_jar({"Api.java": "class Api {}"})
        self.assertEqual(
            2,
            subprocess.run(
                [sys.executable, str(script), str(old), str(broken)],
                capture_output=True,
            ).returncode,
        )

    def test_multi_release_jar_is_rejected(self):
        jar = self.compile_jar({"Api.java": "public class Api {}"})
        with zipfile.ZipFile(jar, "a") as archive:
            archive.writestr("META-INF/versions/9/Api.class", b"unsupported")
        with self.assertRaisesRegex(ValueError, "multi-release"):
            read_jar(jar)

    def test_unsupported_zip_inputs_have_input_error_exit_status(self):
        good = self.compile_jar({"Api.java": "public class Api {}"})
        script = Path(__file__).with_name("check_binary_api.py")
        for label, flags, compression in [
            ("unsupported-compression", 0, 99),
            ("encrypted", 1, zipfile.ZIP_STORED),
        ]:
            data = bytearray(good.read_bytes())
            # This single-entry ZIP has no comment or data descriptor. Patch the
            # local and central headers consistently, preserving its class data.
            end = data.rindex(b"PK\x05\x06")
            central = struct.unpack_from("<I", data, end + 16)[0]
            struct.pack_into("<HH", data, 6, flags, compression)
            struct.pack_into("<HH", data, central + 8, flags, compression)
            bad = self.root / f"{label}.jar"
            bad.write_bytes(data)
            for before, after in [(bad, good), (good, bad)]:
                with self.subTest(kind=label, input="old" if before == bad else "new"):
                    result = subprocess.run(
                        [sys.executable, str(script), str(before), str(after)],
                        capture_output=True,
                        text=True,
                    )
                    self.assertEqual(2, result.returncode, result.stderr)
                    self.assertIn("Cannot compare JARs:", result.stderr)
                    self.assertNotIn("Traceback", result.stderr)

    def test_corrupt_deflate_inputs_have_input_error_exit_status(self):
        source = self.compile_jar({"Api.java": "public class Api {}"})
        good = self.root / "deflated.jar"
        with zipfile.ZipFile(source) as original:
            with zipfile.ZipFile(
                good, "w", compression=zipfile.ZIP_DEFLATED
            ) as archive:
                archive.writestr("Api.class", original.read("Api.class"))
        self.assertEqual([], compare(read_jar(source), read_jar(good)))
        data = bytearray(good.read_bytes())
        name_size, extra_size = struct.unpack_from("<HH", data, 26)
        offset = 30 + name_size + extra_size
        # Keep the ZIP structure intact, but use DEFLATE's reserved block type.
        data[offset] = (data[offset] & ~0x07) | 0x07
        bad = self.root / "corrupt-deflate.jar"
        bad.write_bytes(data)
        with zipfile.ZipFile(bad) as archive:
            with self.assertRaises(zlib.error):
                archive.read("Api.class")
        script = Path(__file__).with_name("check_binary_api.py")
        for before, after in [(bad, good), (good, bad)]:
            with self.subTest(input="old" if before == bad else "new"):
                result = subprocess.run(
                    [sys.executable, str(script), str(before), str(after)],
                    capture_output=True,
                    text=True,
                )
                self.assertEqual(2, result.returncode, result.stderr)
                self.assertIn("Cannot compare JARs:", result.stderr)
                self.assertNotIn("Traceback", result.stderr)

    def test_truncated_class_is_rejected(self):
        jar = self.root / "truncated.jar"
        with zipfile.ZipFile(jar, "w") as archive:
            archive.writestr("Api.class", b"\xca\xfe\xba\xbe")
        with self.assertRaisesRegex(ValueError, "truncated"):
            read_jar(jar)

    @unittest.skipUnless(lzma is not None, "requires the optional lzma module")
    def test_corrupt_lzma_inputs_have_input_error_exit_status(self):
        self.assert_corrupt_compressed_input(zipfile.ZIP_LZMA, lzma.LZMAError)

    def test_corrupt_bzip2_inputs_have_input_error_exit_status(self):
        try:
            import bz2  # noqa: F401
        except ImportError:
            self.skipTest("requires the optional bz2 module")
        self.assert_corrupt_compressed_input(zipfile.ZIP_BZIP2, OSError)

    @unittest.skipUnless(lzma is not None, "requires lzma to create the fixture")
    def test_cli_keeps_lzma_optional(self):
        source = self.compile_jar({"Api.java": "public class Api {}"})
        compressed = self.root / "lzma.jar"
        with zipfile.ZipFile(source) as original:
            with zipfile.ZipFile(
                compressed, "w", compression=zipfile.ZIP_LZMA
            ) as archive:
                archive.writestr("Api.class", original.read("Api.class"))
        # Block lzma before importing either zipfile or the comparator, as on a
        # Python build without this optional standard-library module.
        launcher = """
import builtins, runpy, sys
original_import = builtins.__import__
def without_lzma(name, *args, **kwargs):
    if name == "lzma":
        raise ImportError("disabled by offline fixture")
    return original_import(name, *args, **kwargs)
builtins.__import__ = without_lzma
sys.argv = sys.argv[1:]
runpy.run_path(sys.argv[0], run_name="__main__")
"""
        script = Path(__file__).with_name("check_binary_api.py")
        for candidate, status in [(source, 0), (compressed, 2)]:
            with self.subTest(compressed=candidate == compressed):
                result = subprocess.run(
                    [
                        sys.executable,
                        "-c",
                        launcher,
                        str(script),
                        str(source),
                        str(candidate),
                    ],
                    capture_output=True,
                    text=True,
                )
                self.assertEqual(status, result.returncode, result.stderr)
                self.assertNotIn("Traceback", result.stderr)
                if status:
                    self.assertIn("Cannot compare JARs:", result.stderr)

    def assert_corrupt_compressed_input(self, compression, error):
        source = self.compile_jar({"Api.java": "public class Api {}"})
        good = self.root / "compressed.jar"
        with zipfile.ZipFile(source) as original:
            with zipfile.ZipFile(good, "w", compression=compression) as archive:
                archive.writestr("Api.class", original.read("Api.class"))
        self.assertEqual([], compare(read_jar(source), read_jar(good)))
        data = bytearray(good.read_bytes())
        name_size, extra_size = struct.unpack_from("<HH", data, 26)
        offset = 30 + name_size + extra_size
        if compression == zipfile.ZIP_LZMA:
            # Preserve the LZMA properties, but corrupt its range-coded payload.
            properties_size = struct.unpack_from("<H", data, offset + 2)[0]
            offset += 4 + properties_size
        data[offset] = 0xFF
        bad = self.root / "corrupt-compressed.jar"
        bad.write_bytes(data)
        with zipfile.ZipFile(bad) as archive:
            with self.assertRaises(error):
                archive.read("Api.class")
        script = Path(__file__).with_name("check_binary_api.py")
        for before, after in [(bad, good), (good, bad)]:
            with self.subTest(input="old" if before == bad else "new"):
                result = subprocess.run(
                    [sys.executable, str(script), str(before), str(after)],
                    capture_output=True,
                    text=True,
                )
                self.assertEqual(2, result.returncode, result.stderr)
                self.assertIn("Cannot compare JARs:", result.stderr)
                self.assertNotIn("Traceback", result.stderr)


if __name__ == "__main__":
    unittest.main()
