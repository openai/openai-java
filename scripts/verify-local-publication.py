"""Check the actual Maven artifacts produced by CI, without release credentials."""

from pathlib import Path
import xml.etree.ElementTree as ET
from zipfile import ZipFile

repo = Path(__file__).resolve().parents[1] / "build/local-maven-repo/com/openai"
maven = {"m": "http://maven.apache.org/POM/4.0.0"}
# The umbrella Javadoc must retain both core and OkHttp APIs. Core must include
# models compiled in internal shards as well as its client layer.
documented_classes = {
    "openai-java": {"OpenAIClient.html", "OpenAIOkHttpClient.html"},
    "openai-java-core": {"OpenAIClient.html", "ChatCompletion.html"},
    "openai-java-client-okhttp": {"OpenAIOkHttpClient.html"},
    "openai-java-bedrock": {"BedrockOpenAIOkHttpClient.html"},
}

for artifact, expected_docs in documented_classes.items():
    poms = list((repo / artifact).glob("*/*.pom"))
    assert len(poms) == 1, f"{artifact}: expected exactly one published POM, found {poms}"
    pom = poms[0]
    root = ET.parse(pom).getroot()
    assert root.findtext("m:groupId", namespaces=maven) == "com.openai", pom
    assert root.findtext("m:artifactId", namespaces=maven) == artifact, pom
    deps = root.findall(".//m:dependency/m:artifactId", maven)
    assert not any(d.text.startswith("openai-java-core-") for d in deps), (
        f"{pom}: internal compilation shard leaked into consumer dependencies"
    )
    assert pom.with_suffix(".module").is_file(), f"{pom}: missing Gradle module metadata"
    assert pom.with_suffix(".jar").is_file(), f"{pom}: missing binary JAR"
    sources = pom.with_name(f"{pom.stem}-sources.jar")
    with ZipFile(sources) as jar:
        # openai-java is an umbrella with no source of its own.
        if artifact != "openai-java":
            assert any(n.endswith(".kt") for n in jar.namelist()), f"{sources}: no Kotlin sources"
    docs = pom.with_name(f"{pom.stem}-javadoc.jar")
    with ZipFile(docs) as jar:
        names = {Path(n).name for n in jar.namelist()}
        missing = expected_docs - names
        assert not missing, f"{docs}: missing documented APIs {sorted(missing)}"
    print(f"{artifact}: Maven POM, module metadata, binary, sources and Javadoc OK")
