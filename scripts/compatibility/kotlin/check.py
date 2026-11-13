"""Exercise an installed Java SDK using Maven and Gradle dependency resolution.

Run with JDK 21 in JAVA_HOME:
    python3 check.py STAGED_REPO VERSION WORK_DIR JAVA8_HOME [ADDITIONAL_JAVA_HOME ...]
Use a new work directory for each build. Stage core, client-okhttp and openai-java first.
"""

import hashlib
import json
import os
import re
from pathlib import Path
import shutil
import subprocess
import sys
from zipfile import ZipFile

HERE = Path(__file__).resolve().parent
ROOT = HERE.parents[2]
JAVA_PROBES = (
    ROOT / "openai-java-runtime-compatibility/src/main/java/com/openai/compatibility"
)
MAVEN_RESOLVE = "org.apache.maven.plugins:maven-dependency-plugin:3.8.1:build-classpath"
OLDER_COMPILERS = ("1.8.20", "2.2.21")
COMPILERS = (*OLDER_COMPILERS, "2.3.0", "2.4.21")


def run(repo, version, work, runtimes):
    for home, expected in (
        (runtimes[0], 8),
        (Path(os.environ["JAVA_HOME"]), 21),
    ):
        reported = subprocess.check_output(
            [home / "bin/java", "-version"], stderr=subprocess.STDOUT, text=True
        )
        version_line = re.search(
            r'^(?:java|openjdk) version "(?:1\.)?(\d+)', reported, re.MULTILINE
        )
        if not version_line or int(version_line[1]) != expected:
            raise ValueError(f"Unexpected Java version at {home}: {reported}")
    work.mkdir(parents=True, exist_ok=False)
    jdk = Path(os.environ["JAVA_HOME"])
    maven = ["mvn", "-B", "-q", f"-Dmaven.repo.local={work / 'm2'}"]
    for artifact in ("openai-java", "openai-java-client-okhttp", "openai-java-core"):
        base = repo / "com/openai" / artifact / version
        module = json.loads((base / f"{artifact}-{version}.module").read_text())
        for usage in ("java-api", "java-runtime"):
            variants = [
                v
                for v in module["variants"]
                if v["attributes"].get("org.gradle.category") == "library"
                and v["attributes"].get("org.gradle.usage") == usage
            ]
            if not variants or any(
                v["attributes"].get("org.gradle.jvm.version") != 8 for v in variants
            ):
                raise AssertionError(f"{artifact} missing Java 8 {usage} variant")
    core = (
        repo
        / "com/openai/openai-java-core"
        / version
        / f"openai-java-core-{version}.jar"
    )
    with ZipFile(core) as jar:
        for name in jar.namelist():
            if name.endswith(".class") and not name.startswith("META-INF/versions/"):
                with jar.open(name) as entry:
                    header = entry.read(8)
                if int.from_bytes(header[6:], "big") > 52:
                    raise AssertionError(f"{name} exceeds Java 8")
    compiler_paths = {}
    for compiler in COMPILERS:
        output = work / f"compiler-{compiler}.cp"
        subprocess.run(
            [
                *maven,
                "-f",
                HERE / "compiler.xml",
                f"-Dcompiler={compiler}",
                MAVEN_RESOLVE,
                f"-Dmdep.outputFile={output}",
            ],
            check=True,
        )
        compiler_paths[compiler] = output.read_text().strip()

    for manager in ("maven", "gradle"):
        directory = work / manager
        directory.mkdir()
        if manager == "maven":
            for scope in ("compile", "runtime"):
                subprocess.run(
                    [
                        *maven,
                        "-f",
                        HERE / "pom.xml",
                        f"-DcandidateRepo={repo.as_uri()}",
                        f"-DcandidateVersion={version}",
                        MAVEN_RESOLVE,
                        f"-DincludeScope={scope}",
                        f"-Dmdep.outputFile={directory / (scope + '.cp')}",
                    ],
                    check=True,
                )
        else:
            for name in ("settings.gradle", "build.gradle"):
                shutil.copy(HERE / name, directory)
            subprocess.run(
                [
                    ROOT / "gradlew",
                    "--max-workers=2",
                    "-q",
                    f"-PcandidateRepo={repo.as_uri()}",
                    f"-PcandidateVersion={version}",
                    "resolve",
                ],
                cwd=directory,
                check=True,
            )

        compile_cp = (directory / "compile.cp").read_text().strip()
        runtime_cp = (directory / "runtime.cp").read_text().strip()
        resolved = [Path(p) for p in runtime_cp.split(os.pathsep)]
        for artifact in (
            "openai-java",
            "openai-java-client-okhttp",
            "openai-java-core",
        ):
            name = f"{artifact}-{version}.jar"
            (actual,) = [p for p in resolved if p.name == name]
            staged = repo / "com/openai" / artifact / version / name
            if (
                hashlib.sha256(actual.read_bytes()).digest()
                != hashlib.sha256(staged.read_bytes()).digest()
            ):
                raise AssertionError(f"{manager} resolved a different {artifact}")
            if manager == "maven":
                published_pom = staged.with_suffix(".pom")
                if published_pom.read_bytes() != actual.with_suffix(".pom").read_bytes():
                    raise AssertionError(f"Maven resolved a different {artifact} POM")
        for artifact in ("kotlin-stdlib", "kotlin-reflect"):
            (jar,) = [
                p for p in resolved if re.fullmatch(rf"{artifact}-[0-9].*\.jar", p.name)
            ]
            if jar.name != f"{artifact}-2.4.21.jar":
                raise AssertionError(f"{manager} resolved {jar}")

        subprocess.run(
            [
                jdk / "bin/javac",
                "--release",
                "8",
                "-cp",
                compile_cp,
                "-d",
                directory,
                JAVA_PROBES / "CoreRuntimeProbe.java",
                JAVA_PROBES / "OkHttpRuntimeProbe.java",
                JAVA_PROBES / "ResponseStreamEvolutionProbe.java",
            ],
            check=True,
        )
        for runtime in runtimes:
            for probe in ("CoreRuntimeProbe", "OkHttpRuntimeProbe"):
                subprocess.run(
                    [
                        runtime / "bin/java",
                        "-cp",
                        f"{directory}{os.pathsep}{runtime_cp}",
                        f"com.openai.compatibility.{probe}",
                    ],
                    check=True,
                )

        for compiler, path in compiler_paths.items():
            caller = directory / f"consumer-{compiler}.jar"
            result = subprocess.run(
                [
                    jdk / "bin/java",
                    "-cp",
                    path,
                    "org.jetbrains.kotlin.cli.jvm.K2JVMCompiler",
                    "-no-stdlib",
                    "-no-reflect",
                    "-jvm-target",
                    "1.8",
                    "-classpath",
                    compile_cp,
                    "-d",
                    caller,
                    HERE / "Consumer.kt",
                ],
                text=True,
                capture_output=True,
            )
            (directory / f"compiler-{compiler}.log").write_text(
                result.stderr + result.stdout
            )
            if compiler in OLDER_COMPILERS:
                if (
                    result.returncode == 0
                    or "incompatible version of Kotlin" not in result.stderr
                ):
                    raise AssertionError(
                        f"Unexpected result for {compiler}: {result.stderr}"
                    )
                continue
            if result.returncode:
                raise RuntimeError(result.stderr)
            for runtime in runtimes:
                subprocess.run(
                    [
                        runtime / "bin/java",
                        "-cp",
                        f"{caller}{os.pathsep}{runtime_cp}",
                        "ConsumerKt",
                    ],
                    check=True,
                )
            print(f"{manager} Kotlin {compiler} passed", flush=True)


if __name__ == "__main__":
    repo, version, work, *runtimes = sys.argv[1:]
    if not runtimes:
        raise SystemExit(__doc__)
    run(
        Path(repo).resolve(),
        version,
        Path(work).resolve(),
        [Path(runtime).resolve() for runtime in runtimes]
        + [Path(os.environ["JAVA_HOME"])],
    )
