"""Test a locally published core artifact using Maven and Gradle on Java 8 and 21.

Run with: python3 check.py LOCAL_REPO SDK_VERSION JAVA8_HOME JAVA21_HOME
Publish core first with -PpublishLocal :openai-java-core:publish.
"""

import hashlib
import json
import os
from pathlib import Path
import subprocess
import sys
import tempfile
import xml.etree.ElementTree as ET

HERE = Path(__file__).resolve().parent
ROOT = HERE.parents[2]
SWAGGER = "io.swagger.core.v3"
CORE = "openai-java-core"


def check_publication(dependencies):
    for group, artifact in dependencies:
        if (group == SWAGGER and artifact.startswith("swagger-annotations")) or (
            group == "com.openai" and artifact.startswith(CORE + "-")
        ):
            raise AssertionError(
                f"Published compiler-only dependency: {group}:{artifact}"
            )


def run(repo, version, java8, java21, work):
    jar = repo / "com/openai" / CORE / version / f"{CORE}-{version}.jar"
    pom = ET.parse(jar.with_suffix(".pom"))
    check_publication(
        (d.findtext("{*}groupId"), d.findtext("{*}artifactId"))
        for d in pom.findall(".//{*}dependency")
    )
    published_jackson = next(
        d.findtext("{*}version")
        for d in pom.findall(".//{*}dependency")
        if d.findtext("{*}artifactId") == "jackson-databind"
    )
    module = json.loads(jar.with_suffix(".module").read_text())
    for variant in module["variants"]:
        check_publication(
            (d["group"], d["module"]) for d in variant.get("dependencies", [])
        )

    java = [Path(home) / "bin/java" for home in (java8, java21)]
    for executable, expected in zip(java, ('"1.8.', '"21.')):
        actual = subprocess.check_output(
            [executable, "-version"], stderr=subprocess.STDOUT, text=True
        )
        print(actual, flush=True)
        if expected not in actual.splitlines()[0]:
            raise ValueError(f"Expected {expected} from {executable}")

    for manager in ("maven", "gradle"):
        for mode, annotation, boot, jackson2, jackson3 in (
            ("none", None, None, published_jackson, None),
            ("standard", "swagger-annotations", None, published_jackson, None),
            ("jakarta", "swagger-annotations-jakarta", None, published_jackson, None),
            ("boot3", None, "3.5.16", "2.21.4", None),
            ("boot4", None, "4.1.2", "2.21.7", "3.1.7"),
        ):
            directory = work / manager / mode
            directory.mkdir(parents=True)
            coordinates = [("com.openai", CORE, version)]
            if annotation:
                coordinates.append((SWAGGER, annotation, "2.2.31"))
            if manager == "maven":
                deps = "".join(
                    f"<dependency><groupId>{g}</groupId><artifactId>{a}</artifactId>"
                    f"<version>{v}</version></dependency>"
                    for g, a, v in coordinates
                )
                management = ""
                if boot:
                    management = f"""<dependencyManagement><dependencies><dependency>
<groupId>org.springframework.boot</groupId><artifactId>spring-boot-dependencies</artifactId>
<version>{boot}</version><type>pom</type><scope>import</scope>
</dependency></dependencies></dependencyManagement>"""
                if jackson3:
                    deps += "<dependency><groupId>tools.jackson.core</groupId><artifactId>jackson-databind</artifactId></dependency>"
                (directory / "pom.xml").write_text(
                    f"""<project><modelVersion>4.0.0</modelVersion>
<groupId>test</groupId><artifactId>consumer</artifactId><version>1</version>
<repositories><repository><id>candidate</id><url>{repo.as_uri()}</url></repository></repositories>
{management}<dependencies>{deps}</dependencies></project>"""
                )
                subprocess.run(
                    [
                        "mvn",
                        "-B",
                        f"-Dmaven.repo.local={work / 'm2'}",
                        "org.apache.maven.plugins:maven-dependency-plugin:3.8.1:build-classpath",
                        "-Dmdep.outputFile=classpath",
                    ],
                    cwd=directory,
                    check=True,
                )
            else:
                deps = "\n".join(
                    f"implementation '{g}:{a}:{v}'" for g, a, v in coordinates
                )
                if boot:
                    deps += f"\nimplementation enforcedPlatform('org.springframework.boot:spring-boot-dependencies:{boot}')"
                if jackson3:
                    deps += "\nimplementation 'tools.jackson.core:jackson-databind'"
                (directory / "settings.gradle").write_text(
                    "rootProject.name = 'consumer'\n"
                )
                (directory / "build.gradle").write_text(
                    """
plugins { id 'java' }
java.targetCompatibility = JavaVersion.toVersion(consumerJava)
repositories {
    exclusiveContent {
        forRepository { maven { url = uri(candidateRepo); metadataSources { gradleMetadata() } } }
        filter { includeGroup 'com.openai' }
    }
    mavenCentral()
}
dependencies {
"""
                    + deps
                    + """
}
tasks.register('resolve') {
    doLast { file('classpath').text = configurations.runtimeClasspath.asPath }
}
"""
                )
                subprocess.run(
                    [
                        ROOT / "gradlew",
                        "--max-workers=2",
                        "-q",
                        f"-PcandidateRepo={repo}",
                        f"-PconsumerJava={17 if boot else 8}",
                        "resolve",
                    ],
                    cwd=directory,
                    check=True,
                )
            cp = (directory / "classpath").read_text().strip()
            files = [Path(f) for f in cp.split(os.pathsep)]
            print(manager, mode, [f.name for f in files], flush=True)
            (core,) = [f for f in files if f.name == jar.name]
            if (
                hashlib.sha256(core.read_bytes()).digest()
                != hashlib.sha256(jar.read_bytes()).digest()
            ):
                raise AssertionError(f"{manager} resolved the wrong core JAR")
            providers = [
                f.name for f in files if f.name.startswith("swagger-annotations")
            ]
            if providers != ([f"{annotation}-2.2.31.jar"] if annotation else []):
                raise AssertionError(f"{manager} {mode}: resolved {providers}")
            subprocess.run(
                [
                    Path(java21) / "bin/javac",
                    "--release",
                    "8",
                    "-cp",
                    cp,
                    "-d",
                    directory,
                    HERE / "Consumer.java",
                    HERE / "ClientDecoding.java",
                    HERE / ("Annotated.java" if annotation else "Plain.java"),
                ],
                check=True,
            )
            for executable in java[1:] if boot else java:
                subprocess.run(
                    [
                        executable,
                        "-cp",
                        str(directory) + os.pathsep + cp,
                        "Consumer",
                        "standard" if annotation else "none",
                        jackson2,
                    ],
                    check=True,
                )

            if jackson3:
                subprocess.run(
                    [
                        Path(java21) / "bin/javac",
                        "--release",
                        "17",
                        "-cp",
                        cp,
                        "-d",
                        directory,
                        HERE / "Jackson3Application.java",
                    ],
                    check=True,
                )
                subprocess.run(
                    [
                        java[1],
                        "-cp",
                        str(directory) + os.pathsep + cp,
                        "Jackson3Application",
                        jackson3,
                    ],
                    check=True,
                )


if __name__ == "__main__":
    repo, version, java8, java21 = sys.argv[1:]
    with tempfile.TemporaryDirectory() as work:
        run(Path(repo).resolve(), version, java8, java21, Path(work))
