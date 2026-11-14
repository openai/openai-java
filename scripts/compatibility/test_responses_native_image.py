import json
from pathlib import Path
from tempfile import TemporaryDirectory
import unittest
from zipfile import ZipFile

from responses_native_image import NAMESPACE, check_archive


class ResponsesMetadataTest(unittest.TestCase):
    def test_jar_must_contain_the_exact_neutral_trace_under_its_namespace(self):
        with TemporaryDirectory() as temp:
            root = Path(temp)
            metadata = root / "trace"
            metadata.mkdir()
            reflection = json.dumps([{"name": "com.openai.models.responses.Response"}])
            (metadata / "reflect-config.json").write_text(reflection)
            (metadata / "resource-config.json").write_text("{}")
            jar = root / "api.jar"
            for prefix, resources in [
                (NAMESPACE, "{}"),
                ("META-INF/native-image/", "{}"),
                (NAMESPACE, None),
                (NAMESPACE, "stale"),
            ]:
                with self.subTest(prefix=prefix, resources=resources):
                    with ZipFile(jar, "w") as archive:
                        archive.writestr(prefix + "reflect-config.json", reflection)
                        if resources is not None:
                            archive.writestr(prefix + "resource-config.json", resources)
                    if prefix == NAMESPACE and resources == "{}":
                        peer = root / "runtime.jar"
                        with ZipFile(peer, "w") as archive:
                            archive.writestr(
                                "META-INF/native-image/full/reflect-config.json", "[]"
                            )
                        check_archive(metadata, jar, [peer])
                        with ZipFile(peer, "a") as archive:
                            archive.writestr(
                                NAMESPACE + "resource-config.json", resources
                            )
                        with self.assertRaisesRegex(ValueError, "runtime.jar"):
                            check_archive(metadata, jar, [peer])
                    else:
                        with self.assertRaises(ValueError):
                            check_archive(metadata, jar)

    def test_matching_archives_with_no_responses_reflection_fail(self):
        with TemporaryDirectory() as temp:
            root = Path(temp)
            metadata = root / "trace"
            metadata.mkdir()
            (metadata / "reflect-config.json").write_text("[]")
            jar = root / "api.jar"
            with ZipFile(jar, "w") as archive:
                archive.writestr(NAMESPACE + "reflect-config.json", "[]")
            with self.assertRaisesRegex(ValueError, "Responses models"):
                check_archive(metadata, jar)
