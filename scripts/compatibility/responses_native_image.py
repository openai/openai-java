"""Trace the neutral Responses caller, check its packaged metadata, or run both native callers."""

import argparse
import json
import os
from pathlib import Path
import subprocess
from tempfile import TemporaryDirectory
from zipfile import ZipFile


# Run from the selected release checkout, including when the trusted workflow copies this helper.
ROOT = Path.cwd()
FIXTURE = ROOT / "openai-java-runtime-compatibility"
SOURCES = FIXTURE / "src/main/java/com/openai/compatibility"
API = "openai-java-responses-api"
DEFAULT = "openai-java-responses"
NAMESPACE = f"META-INF/native-image/com.openai/{API}/"


def check_trace(metadata):
    legacy = metadata / "reflect-config.json"
    if legacy.is_file():
        reflection = json.loads(legacy.read_text())
    else:
        reflection = json.loads((metadata / "reachability-metadata.json").read_text())[
            "reflection"
        ]
    if not any(
        str(entry.get("name", entry.get("type", ""))).startswith(
            "com.openai.models.responses."
        )
        for entry in reflection
    ):
        raise ValueError("The agent recorded no reflection on Responses models")


def check_archive(metadata, jar, peers=()):
    check_trace(metadata)
    files = {
        NAMESPACE + p.relative_to(metadata).as_posix(): p
        for p in metadata.rglob("*")
        if p.is_file()
    }
    with ZipFile(jar) as archive:
        entries = [
            i.filename
            for i in archive.infolist()
            if not i.is_dir() and i.filename.startswith(NAMESPACE)
        ]
        if sorted(entries) != sorted(files):
            raise ValueError(
                f"{jar}: packaged Responses metadata inventory differs from the trace"
            )
        for name, source in files.items():
            if archive.read(name) != source.read_bytes():
                raise ValueError(f"{jar}: packaged {name} differs from the trace")

    for peer in peers:
        with ZipFile(peer) as archive:
            if any(
                entry.filename.startswith(NAMESPACE) and not entry.is_dir()
                for entry in archive.infolist()
            ):
                raise ValueError(f"{peer}: Responses native metadata belongs in {jar}")


def run_probe(artifact, metadata, work, trace):
    neutral = artifact == API
    task = (
        "stageOpenaiJavaResponsesApiNativeClasspath"
        if neutral
        else "stageOpenaiJavaResponsesNativeClasspath"
    )
    gradle = [ROOT / "gradlew", f":openai-java-runtime-compatibility:{task}"]
    if not trace:
        gradle.append(f"-PresponsesGraalMetadataDir={metadata}")
    subprocess.run(gradle, cwd=ROOT, check=True)
    jars = sorted((FIXTURE / "build/native-classpaths" / artifact).glob("*.jar"))
    if not trace:
        (api_jar,) = [jar for jar in jars if jar.name.startswith(API + "-")]
        check_archive(metadata, api_jar, [jar for jar in jars if jar != api_jar])

    bin_dir = Path(os.environ["JAVA_HOME"]) / "bin"
    classes = work / artifact
    classes.mkdir()
    probe = "ResponsesApiRuntimeProbe" if neutral else "ResponsesRuntimeProbe"
    sources = ["RuntimeProbe", probe]
    if not neutral:
        sources.append("HttpOkHttpRuntimeProbe")  # owns the loopback HTTP server
    classpath = os.pathsep.join(map(str, jars))
    subprocess.run(
        [
            bin_dir / "javac",
            "--release",
            "8",
            "-cp",
            classpath,
            "-d",
            classes,
            *(SOURCES / (name + ".java") for name in sources),
        ],
        check=True,
    )
    caller = [
        "-cp",
        str(classes) + os.pathsep + classpath,
        "com.openai.compatibility." + probe,
    ]
    if trace:
        subprocess.run(
            [
                bin_dir / "java",
                f"-agentlib:native-image-agent=config-output-dir={metadata}",
                *caller,
            ],
            check=True,
        )
        check_trace(metadata)
    else:
        image = work / probe
        subprocess.run(
            [bin_dir / "native-image", "--no-fallback", "-o", image, *caller],
            check=True,
        )
        subprocess.run([image], check=True)


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    commands = parser.add_subparsers(dest="command", required=True)
    for name in ("trace", "check-archive", "smoke"):
        command = commands.add_parser(name)
        command.add_argument("metadata", type=Path)
        if name == "check-archive":
            command.add_argument("jar", type=Path)
            command.add_argument("peers", nargs="*", type=Path)
    args = parser.parse_args()
    metadata = args.metadata.resolve()
    if args.command == "check-archive":
        check_archive(metadata, args.jar, args.peers)
        return
    with TemporaryDirectory() as temp:
        work = Path(temp)
        if args.command == "trace":
            metadata.mkdir(parents=True, exist_ok=True)
            if any(metadata.iterdir()):
                parser.error("trace requires an empty output directory")
            run_probe(API, metadata, work, trace=True)
        else:
            check_trace(metadata)
            for artifact in (API, DEFAULT):
                run_probe(artifact, metadata, work, trace=False)


if __name__ == "__main__":
    main()
