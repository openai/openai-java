"""Check Maven and Gradle metadata after publishing the SDK to a local repository."""

import argparse
import json
import os
from pathlib import Path
import subprocess
from tempfile import TemporaryDirectory
from xml.etree import ElementTree
from zipfile import ZipFile


GROUP = "com.openai"
BOM = "openai-java-bom"
BINARIES = {
    "openai-java",
    "openai-java-bedrock",
    "openai-java-client-okhttp",
    "openai-java-core",
    "openai-java-http-okhttp",
    "openai-java-responses",
    "openai-java-responses-api",
    "openai-java-runtime",
    "openai-java-vertex",
}

API = "openai-java-responses-api"
DEFAULT = "openai-java-responses"
FULL = "openai-java"
ALIGNED = "full-and-default"
NATIVE_METADATA = f"META-INF/native-image/com.openai/{API}/"

RULE_PATHS = (
    "META-INF/proguard/openai-java-core.pro",
    "META-INF/proguard/castiron-legacy-models.pro",
)
RULE_OWNER = "com.openai:openai-java-runtime"

SOURCE_OWNERS = {
    **{
        f"com/openai/http/okhttp/{name}.kt": "openai-java-http-okhttp"
        for name in (
            "BoundedWebSocket",
            "OkHttpClient",
            "OkHttpClientConfiguration",
            "X509TokenExchange",
            "X509Transport",
            "X509WorkloadIdentity",
            "X509WorkloadIdentityAuthenticator",
        )
    },
    "com/openai/responses/okhttp/OpenAIResponsesOkHttpClient.kt": DEFAULT,
    "com/openai/responses/OpenAIResponsesClient.kt": API,
}


def check_client_sources(repository, version):
    owners = {source: [] for source in SOURCE_OWNERS}
    for binary in sorted(BINARIES):
        directory = repository / "com/openai" / binary / version
        with ZipFile(directory / f"{binary}-{version}-sources.jar") as archive:
            for path in archive.namelist():
                # Count prefixed copies too, but require exactly one normalized entry.
                source = (
                    path[path.index("com/openai/") :] if "com/openai/" in path else path
                )
                if source in owners:
                    owners[source].append((binary, path))
    for source, binary in SOURCE_OWNERS.items():
        assert owners[source] == [(binary, source)], (source, owners[source])


def jar_contents(artifact, jar):
    group, name, _ = artifact.split(":", 2)
    is_sdk = group == GROUP
    owns_trace = is_sdk and name == API
    classes = set()
    with ZipFile(jar) as archive:
        mappings = []
        for entry in archive.infolist():
            name = entry.filename
            if (
                name.startswith(NATIVE_METADATA)
                and not entry.is_dir()
                and not owns_trace
            ):
                raise ValueError(f"{jar}: misplaced Responses native metadata {name}")
            if name.startswith("META-INF/") and name.endswith(".kotlin_module"):
                mappings.append(entry.file_size)
            if not name.endswith(".class"):
                continue
            if name.startswith("META-INF/versions/"):
                name = name.split("/", 3)[-1]
            if name != "module-info.class" and not name.startswith("META-INF/"):
                classes.add(name)
        if is_sdk and classes and not any(mappings):
            raise ValueError(f"{jar}: missing Kotlin module mapping")
    return classes


def check_graph(artifacts, inventories):
    coordinates = {tuple(key.split(":", 2)[:2]) for key in artifacts}
    okio = {name for group, name in coordinates if group == "com.squareup.okio"}
    has_okhttp = ("com.squareup.okhttp3", "okhttp") in coordinates
    expected_okio = {"okio-jvm"} if has_okhttp else set()
    if okio != expected_okio:
        raise ValueError(f"expected Okio artifacts {sorted(expected_okio)}, resolved {sorted(okio)}")
    classes = {}
    packages = {}
    for artifact, path in artifacts.items():
        jar = Path(path)
        if jar not in inventories:
            inventories[jar] = jar_contents(artifact, jar)
        for name in sorted(inventories[jar]):
            previous = classes.setdefault(name, artifact)
            if previous != artifact:
                raise ValueError(f"duplicate class {name} in {previous} and {artifact}")
    for name, artifact in classes.items():
        package = name.rpartition("/")[0]
        previous = packages.setdefault(package, artifact)
        if previous != artifact:
            raise ValueError(f"split package {package} in {previous} and {artifact}")


def check_consumer_rules(artifacts, expected, cache):
    owners = {name: [] for name in expected}
    for artifact, path in artifacts.items():
        jar = Path(path)
        if jar not in cache:
            with ZipFile(jar) as archive:
                # infolist preserves duplicate entries within the same JAR.
                cache[jar] = [
                    (entry.filename, archive.read(entry))
                    for entry in archive.infolist()
                    if entry.filename in expected
                ]
        for name, content in cache[jar]:
            if content != expected[name]:
                raise ValueError(
                    f"{jar}: {name} differs from the canonical consumer rules"
                )
            owners[name].append(artifact.rsplit(":", 1)[0])
    for name, found in owners.items():
        if found != [RULE_OWNER]:
            raise ValueError(f"{name}: expected one copy from {RULE_OWNER}, found {found}")


def check(repository, version):
    for name in sorted(BINARIES | {BOM}):
        directory = repository / "com/openai" / name / version
        prefix = f"{name}-{version}"
        pom = ElementTree.parse(directory / (prefix + ".pom")).getroot()
        metadata = json.loads((directory / (prefix + ".module")).read_text())
        managed = pom.findall("{*}dependencyManagement/{*}dependencies/{*}dependency")
        variants = metadata["variants"]

        if name == BOM:
            assert pom.findtext("{*}packaging") == "pom"
            assert not pom.findall("{*}dependencies/{*}dependency")
            assert not list(directory.glob("*.jar"))
            assert {
                (
                    d.findtext("{*}groupId"),
                    d.findtext("{*}artifactId"),
                    d.findtext("{*}version"),
                )
                for d in managed
            } == {(GROUP, binary, version) for binary in BINARIES}
            for variant in variants:
                assert not variant.get("files") and not variant.get(
                    "dependencies"
                ), variant
            platform = [
                v
                for v in variants
                if v["attributes"]["org.gradle.category"] == "platform"
            ]
            assert {v["attributes"]["org.gradle.usage"] for v in platform} == {
                "java-api",
                "java-runtime",
            }
            for variant in platform:
                assert {
                    (c["group"], c["module"], c["version"]["strictly"])
                    for c in variant["dependencyConstraints"]
                } == {(GROUP, binary, version) for binary in BINARIES}
        else:
            assert (directory / (prefix + ".jar")).is_file(), name
            assert any(
                d.findtext("{*}groupId") == GROUP
                and d.findtext("{*}artifactId") == BOM
                and d.findtext("{*}version") == version
                and d.findtext("{*}type") == "pom"
                and d.findtext("{*}scope") == "import"
                for d in managed
            ), name
            libraries = [
                v
                for v in variants
                if v["attributes"]["org.gradle.category"] == "library"
            ]
            assert {v["attributes"]["org.gradle.usage"] for v in libraries} == {
                "java-api",
                "java-runtime",
            }, name
            for variant in libraries:
                assert any(
                    d["version"]["requires"] == version
                    and d.get("endorseStrictVersions")
                    and d["attributes"]["org.gradle.category"] == "platform"
                    for d in variant["dependencies"]
                    if d["group"] == GROUP and d["module"] == BOM
                ), (name, variant["name"])


def resolve_consumer(repository, version):
    wrapper = Path(__file__).resolve().parents[1] / "gradlew"
    with TemporaryDirectory() as tmp:
        consumer = Path(tmp)
        roots = (API, DEFAULT, FULL, ALIGNED, "baseline")
        for root in roots:
            (consumer / root).mkdir()
        (consumer / "settings.gradle").write_text(
            "rootProject.name = 'bom-consumer'\ninclude " + ", ".join(map(repr, roots))
        )
        (consumer / "gradle.properties").write_text(
            "kotlin.stdlib.default.dependency=false\n"
        )
        source_dir = consumer / "caller"
        source_dir.mkdir()
        (source_dir / "Installed.kt").write_text(
            """
import com.openai.core.getPackageVersion
import com.openai.core.jsonMapper
import com.openai.responses.OpenAIResponsesClient
import com.openai.services.async.responses.ResponseServiceAsync
import com.openai.services.blocking.responses.ResponseService

fun sync(client: OpenAIResponsesClient): ResponseService = client.responses()
fun async(client: OpenAIResponsesClient): ResponseServiceAsync = client.async().responses()

fun main(args: Array<String>) {
    check(jsonMapper().readTree("42").asInt() == 42)
    val loader = Thread.currentThread().contextClassLoader
    check(getPackageVersion() == args[1]) { getPackageVersion() }
    val graph = args[0]
    val full = graph == "openai-java" || graph == "full-and-default"
    val default = graph == "openai-java-responses" || graph == "full-and-default"
    val okhttp = full || default
    fun expect(path: String, installed: Boolean) {
        val copies = loader.getResources("$path.class").toList()
        check(copies.size == (if (installed) 1 else 0)) { "$path: $copies" }
    }
    expect("com/openai/core/ClientOptions", true)
    expect("com/openai/responses/OpenAIResponsesClient", true)
    expect("com/openai/responses/helpers/ResponseAccumulator", true)
    expect("com/openai/helpers/ResponseAccumulator", full)
    expect("com/openai/services/blocking/ResponseService", full)
    expect("com/openai/services/async/ResponseServiceAsync", full)
    expect("com/openai/models/responses/Response", true)
    expect("com/openai/responses/okhttp/OpenAIResponsesOkHttpClient", default)
    expect("com/openai/http/okhttp/OkHttpClient", okhttp)
    expect("com/openai/client/okhttp/OkHttpClient", full)
    expect("okhttp3/OkHttpClient", okhttp)
    expect("com/openai/client/OpenAIClient", full)
    expect("com/openai/models/chat/completions/ChatCompletion", full)
}
"""
        )
        (consumer / "build.gradle").write_text(
            """
plugins {
    id 'java'
    id 'org.jetbrains.kotlin.jvm' version '2.3.0' apply false
}
configure(allprojects.findAll { it.name != 'baseline' }) {
    repositories {
        exclusiveContent {
            forRepository {
                maven {
                    url = uri(candidateRepo)
                    metadataSources {
                        if (usePom.toBoolean()) {
                            mavenPom()
                            ignoreGradleMetadataRedirection()
                        } else {
                            gradleMetadata()
                        }
                    }
                }
            }
            filter { includeGroup 'com.openai' }
        }
        mavenCentral {
            if (usePom.toBoolean()) {
                metadataSources {
                    mavenPom()
                    ignoreGradleMetadataRedirection()
                }
            }
        }
    }
}
def binaries = binaryArtifacts.split(',')
dependencies {
    implementation platform("com.openai:openai-java-bom:$sdkVersion")
    binaries.each { name ->
        // Resolve just the versionless SDK JAR from the local repository.
        testImplementation("com.openai:$name") { transitive = false }
    }
}
tasks.register('verifyBom') {
    doLast {
        [configurations.compileClasspath, configurations.runtimeClasspath].each { cp ->
            assert cp.files.empty : "$cp installed ${cp.files}"
            assert cp.incoming.resolutionResult.allComponents*.moduleVersion.findAll {
                it?.group == 'com.openai'
            }*.name == ['openai-java-bom']
        }
        assert configurations.testRuntimeClasspath.files*.name.toSet() ==
            binaries.collect { "${it}-${sdkVersion}.jar".toString() }.toSet()
    }
}

def neutral = ['openai-java-runtime', 'openai-java-responses-api']
def installed = [
    'openai-java-responses-api': neutral,
    'openai-java-responses': neutral + ['openai-java-http-okhttp', 'openai-java-responses'],
    'openai-java': neutral + ['openai-java-core', 'openai-java-http-okhttp',
                              'openai-java-client-okhttp', 'openai-java'],
]
installed['full-and-default'] = installed['openai-java'] + ['openai-java-responses']

project(':baseline') {
    apply plugin: 'java'
    repositories { mavenCentral() }
    // Freeze callers against the v4 artifacts published to Maven Central.
    def frozenVersion = '4.101.0'
    dependencies { implementation("com.openai:openai-java:$frozenVersion") }
    tasks.register('writeBaseline') {
        doLast {
            def cp = configurations.runtimeClasspath
            def original = cp.resolvedConfiguration.resolvedArtifacts*.moduleVersion*.id.findAll {
                it.group == 'com.openai'
            }
            assert original*.name.toSet() == ['openai-java', 'openai-java-core', 'openai-java-client-okhttp'].toSet()
            assert original.every { it.version == frozenVersion }
            project.file('module-path').text = cp.asPath
        }
    }
}
configure(subprojects.findAll { it.name != 'baseline' }) {
    apply plugin: 'org.jetbrains.kotlin.jvm'
    kotlin.sourceSets.main.kotlin.srcDir(rootProject.file('caller'))
    def entryPoint = project.name
    def requested = entryPoint == 'full-and-default' ? ['openai-java', 'openai-java-responses'] : [entryPoint]
    dependencies { requested.each { implementation("com.openai:$it:$sdkVersion") } }
    tasks.register('verifyInstalled', JavaExec) {
        dependsOn tasks.named('classes')
        classpath = sourceSets.main.runtimeClasspath
        mainClass.set('InstalledKt')
        doFirst { project.file('module-path').text = configurations.runtimeClasspath.asPath }
        args entryPoint, sdkVersion
        doFirst {
            [configurations.compileClasspath, configurations.runtimeClasspath].each { cp ->
                def sdk = cp.resolvedConfiguration.resolvedArtifacts*.moduleVersion*.id.findAll {
                    it.group == 'com.openai'
                }
                assert sdk*.name.toSet() == installed[entryPoint].toSet() : "$entryPoint $cp: $sdk"
                assert sdk.every { it.version == sdkVersion } : "$entryPoint $cp: $sdk"
                def jars = cp.resolvedConfiguration.resolvedArtifacts.collectEntries {
                    def owner = it.moduleVersion.id
                    [("${owner.group}:${owner.name}:${it.file.name}".toString()): it.file.absolutePath]
                }
                project.file(cp.name + '.json').text = groovy.json.JsonOutput.toJson(jars)
            }
        }
    }
}
"""
        )
        resources = wrapper.parent / "openai-java-core/src/main/resources"
        expected_rules = {name: (resources / name).read_bytes() for name in RULE_PATHS}
        rule_cache = {}
        inventories = {}
        for use_pom in ("true", "false"):
            subprocess.run(
                [
                    wrapper,
                    "-q",
                    f"-PcandidateRepo={repository.resolve()}",
                    f"-PsdkVersion={version}",
                    f"-PusePom={use_pom}",
                    f"-PbinaryArtifacts={','.join(sorted(BINARIES))}",
                    *([":baseline:writeBaseline"] if use_pom == "true" else []),
                    "verifyBom",
                    "verifyInstalled",
                ],
                cwd=consumer,
                check=True,
            )

            if use_pom == "true":
                compile_frozen(consumer)
            for graph in (API, DEFAULT, FULL, ALIGNED):
                for configuration in ("compileClasspath", "runtimeClasspath"):
                    artifacts = json.loads(
                        (consumer / graph / (configuration + ".json")).read_text()
                    )
                    check_consumer_rules(artifacts, expected_rules, rule_cache)
                    check_graph(artifacts, inventories)
                if graph in (FULL, ALIGNED):
                    run_frozen(consumer, graph)
                else:
                    run_responses_module(consumer, graph)


def run_responses_module(consumer, graph):
    fixture = Path(__file__).resolve().parents[1] / "openai-java-runtime-compatibility"
    sources = fixture / "src/main/java/com/openai/compatibility"
    neutral = graph == API
    probe = "ResponsesApiRuntimeProbe" if neutral else "ResponsesRuntimeProbe"
    inputs = ["RuntimeProbe", probe]
    if not neutral:
        inputs.append("HttpOkHttpRuntimeProbe")
    output = consumer / graph / "named"
    output.mkdir(exist_ok=True)
    descriptor = consumer / graph / "module-info.java"
    descriptor.write_text(
        "open module fixture.responses { requires "
        + graph.replace("-", ".")
        + "; requires com.fasterxml.jackson.databind;"
        + ("" if neutral else " requires jdk.httpserver;")
        + " }"
    )
    modules = module_path(consumer, graph)
    subprocess.run(
        [
            jdk("javac"),
            "--module-path",
            modules,
            "--add-modules",
            DEPENDENCY_ROOTS,
            "-d",
            output,
            descriptor,
            *(sources / (name + ".java") for name in inputs),
        ],
        check=True,
    )
    subprocess.run(
        [
            jdk("java"),
            "--module-path",
            modules + os.pathsep + str(output),
            "--add-modules",
            DEPENDENCY_ROOTS,
            "-m",
            "fixture.responses/com.openai.compatibility." + probe,
        ],
        check=True,
    )


# Third-party module roots used by the published SDK callers.
DEPENDENCY_ROOTS = (
    "kotlin.stdlib,kotlin.reflect,com.fasterxml.jackson.databind,"
    "com.fasterxml.jackson.datatype.jdk8,com.fasterxml.jackson.datatype.jsr310,"
    "com.fasterxml.jackson.kotlin"
)
FROZEN_ROOTS = "openai.java," + DEPENDENCY_ROOTS


def jdk(tool):
    return (
        Path(os.environ["JAVA_HOME"]) / "bin" / tool
        if "JAVA_HOME" in os.environ
        else tool
    )


def module_path(consumer, graph):
    return (consumer / graph / "module-path").read_text()


def compile_frozen(consumer):
    fixture = Path(__file__).resolve().parent / "jpms"
    baseline = module_path(consumer, "baseline")
    for name, directory, source in (
        ("frozen", fixture, "fixture/InstalledConsumer.java"),
        ("legacy", fixture / "transport", "example/legacy/Legacy.java"),
    ):
        output = consumer / name
        output.mkdir()
        subprocess.run(
            [
                jdk("javac"),
                "--module-path",
                baseline,
                "--add-modules",
                FROZEN_ROOTS,
                "-d",
                output,
                directory / "module-info.java",
                directory / source,
            ],
            check=True,
        )
    subprocess.run(
        [
            jdk("keytool"),
            "-genkeypair",
            "-storetype",
            "PKCS12",
            "-keystore",
            consumer / "fixture.p12",
            "-storepass",
            "fixture",
            "-keyalg",
            "RSA",
            "-dname",
            "CN=fixture",
            "-alias",
            "fixture",
            "-validity",
            "2",
        ],
        check=True,
    )
    run_frozen(consumer, "baseline")


def run_frozen(consumer, graph):
    path = module_path(consumer, graph)
    frozen = str(consumer / "frozen")
    legacy = str(consumer / "legacy")
    for modules, caller in (
        (path, ["-cp", frozen, "fixture.InstalledConsumer"]),
        (path + os.pathsep + frozen, ["-m", "fixture.sdk/fixture.InstalledConsumer"]),
        (
            path + os.pathsep + legacy,
            ["-m", "legacy.probe/example.legacy.Legacy", consumer / "fixture.p12"],
        ),
    ):
        subprocess.run(
            [
                jdk("java"),
                "--module-path",
                modules,
                "--add-modules",
                FROZEN_ROOTS,
                *caller,
            ],
            check=True,
        )


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("repository", type=Path)
    parser.add_argument("version")
    args = parser.parse_args()
    check(args.repository, args.version)
    check_client_sources(args.repository, args.version)
    resolve_consumer(args.repository, args.version)
