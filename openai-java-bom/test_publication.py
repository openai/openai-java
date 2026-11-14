from pathlib import Path
from runpy import run_path
from tempfile import TemporaryDirectory
import unittest
from zipfile import ZipFile


verify = run_path(str(Path(__file__).with_name("verify-publication.py")))


class InstalledGraphTest(unittest.TestCase):
    def test_consumer_rules_must_match_the_runtime_jar_once_per_graph(self):
        handwritten, generated = verify["RULE_PATHS"]
        expected = {handwritten: b"reviewed rules", generated: b"generated rules"}
        with TemporaryDirectory() as temp:
            root = Path(temp)

            def artifact(module, entries):
                path = root / f"{module}.jar"
                with ZipFile(path, "w") as archive:
                    for name, content in entries:
                        archive.writestr(name, content)
                return {f"com.openai:{module}:{path.name}": path}

            runtime = artifact("openai-java-runtime", expected.items())
            neutral = runtime | artifact("openai-java-responses-api", [])
            full = neutral | artifact("openai-java-core", [])
            cache = {}
            for graph in (neutral, full):
                verify["check_consumer_rules"](graph, expected, cache)

            for label, runtime_entries, core_entries, error in (
                (
                    "missing generated",
                    [(handwritten, expected[handwritten])],
                    [],
                    "expected one copy",
                ),
                ("stale", [(handwritten, b"stale")], [], "differs from the canonical"),
                ("wrong owner", [], expected.items(), "expected one copy"),
                (
                    "duplicate owner",
                    expected.items(),
                    expected.items(),
                    "expected one copy",
                ),
            ):
                with self.subTest(label=label):
                    graph = artifact("openai-java-runtime", runtime_entries) | artifact(
                        "openai-java-core", core_entries
                    )
                    with self.assertRaisesRegex(ValueError, error):
                        verify["check_consumer_rules"](graph, expected, {})

            duplicate = artifact("openai-java-runtime", expected.items())
            with self.assertWarnsRegex(UserWarning, "Duplicate name"):
                with ZipFile(next(iter(duplicate.values())), "a") as archive:
                    archive.writestr(handwritten, expected[handwritten])
            with self.assertRaisesRegex(ValueError, "expected one copy"):
                verify["check_consumer_rules"](duplicate, expected, {})

    def test_metadata_only_okio_jar_conflicts_even_without_duplicate_classes(self):
        with TemporaryDirectory() as temp:
            root = Path(temp)
            artifacts = {}
            for group, name, entry in (
                ("com.squareup.okhttp3", "okhttp", "okhttp3/OkHttpClient.class"),
                ("com.squareup.okio", "okio-jvm", "okio/Buffer.class"),
                ("com.squareup.okio", "okio", "META-INF/kotlin-project-structure-metadata.json"),
            ):
                path = root / f"{name}.jar"
                with ZipFile(path, "w") as archive:
                    archive.writestr(entry, b"fixture")
                artifacts[f"{group}:{name}:{path.name}"] = path
            with self.assertRaisesRegex(ValueError, "resolved .*'okio', 'okio-jvm'"):
                verify["check_graph"](artifacts, {})
            del artifacts["com.squareup.okio:okio:okio.jar"]
            verify["check_graph"](artifacts, {})

    def test_duplicate_classes_and_split_packages_fail_only_on_coinstallation(self):
        with TemporaryDirectory() as temp:
            root = Path(temp)

            def jar(name, *entries):
                path = root / f"{name}.jar"
                with ZipFile(path, "w") as archive:
                    archive.writestr(f"META-INF/{name}.kotlin_module", b"index")
                    for entry in entries:
                        archive.writestr(entry, b"class")
                return path

            first = jar("first", "sdk/a/A.class", "META-INF/versions/11/sdk/a/A.class")
            other = jar("other", "sdk/b/B.class")
            for entry, failure in [
                ("sdk/a/A.class", "duplicate class sdk/a/A.class"),
                ("sdk/a/B.class", "split package sdk/a"),
            ]:
                with self.subTest(entry=entry):
                    second = jar("second", entry)
                    inventories = {}
                    verify["check_graph"](
                        {
                            "com.openai:first:first.jar": first,
                            "org.example:other:other.jar": other,
                        },
                        inventories,
                    )
                    verify["check_graph"](
                        {"org.example:second:second.jar": second}, inventories
                    )
                    with self.assertRaisesRegex(ValueError, failure):
                        verify["check_graph"](
                            {
                                "com.openai:first:first.jar": first,
                                "org.example:second:second.jar": second,
                            },
                            inventories,
                        )
