import com.openai.gradle.VersionSupportPolicy
import org.gradle.api.attributes.Bundling
import org.gradle.api.attributes.Category
import org.gradle.api.attributes.LibraryElements
import org.gradle.api.attributes.Usage
import org.gradle.api.attributes.java.TargetJvmVersion

plugins {
    id("openai.java")
}

val versionSupportPolicy =
    VersionSupportPolicy.load(rootProject.file("gradle/version-support.properties"))
val runtimeProbes =
    mapOf(
        "openai-java-core" to "com.openai.compatibility.CoreRuntimeProbe",
        "openai-java-client-okhttp" to "com.openai.compatibility.OkHttpRuntimeProbe",
        "openai-java" to "com.openai.compatibility.OkHttpRuntimeProbe",
        "openai-java-bedrock" to "com.openai.compatibility.BedrockRuntimeProbe",
    )
val supportedArtifacts =
    versionSupportPolicy.artifacts.filterValues { it.lifecycle.isSupported }.keys

check(runtimeProbes.keys == supportedArtifacts) {
    "Runtime probes must exactly cover supported artifacts. " +
        "Missing: ${supportedArtifacts - runtimeProbes.keys}; " +
        "unexpected: ${runtimeProbes.keys - supportedArtifacts}"
}

dependencies {
    runtimeProbes.keys.forEach { compileOnly(project(":$it")) }
}

tasks.withType<JavaCompile>().configureEach {
    // This fixture intentionally compiles at the SDK's minimum consumer level.
    options.compilerArgs.add("-Xlint:-options")
}

val runtimeJavaVersion =
    providers
        .gradleProperty("runtimeJavaVersion")
        .map(String::toInt)
        .orElse(versionSupportPolicy.minimumSupportedRuntime)
val runtimeLauncher =
    javaToolchains.launcherFor {
        languageVersion.set(runtimeJavaVersion.map(JavaLanguageVersion::of))
    }

fun String.toTaskSegment(): String =
    split('-').joinToString("") { segment ->
        segment.replaceFirstChar { firstCharacter -> firstCharacter.uppercase() }
    }

val artifactProbeTasks =
    runtimeProbes.mapValues { (artifactName, probeMainClass) ->
        val artifactSupport = versionSupportPolicy.artifacts.getValue(artifactName)
        val runtimeClasspath =
            configurations.create("${artifactName.toTaskSegment()}RuntimeCompatibilityClasspath") {
                isCanBeConsumed = false
                isCanBeResolved = true
                attributes {
                    attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
                    attribute(Category.CATEGORY_ATTRIBUTE, objects.named(Category.LIBRARY))
                    attribute(
                        LibraryElements.LIBRARY_ELEMENTS_ATTRIBUTE,
                        objects.named(LibraryElements.JAR),
                    )
                    attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
                    attribute(
                        TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE,
                        artifactSupport.runtime,
                    )
                }
            }
        dependencies.add(runtimeClasspath.name, project(":$artifactName"))

        tasks.register<JavaExec>("run${artifactName.toTaskSegment()}RuntimeCompatibility") {
            group = "verification"
            description =
                "Exercises $artifactName on its isolated consumer runtime classpath."

            classpath = sourceSets.main.get().output + runtimeClasspath
            mainClass.set(probeMainClass)
            javaLauncher.set(runtimeLauncher)
        }
    }

tasks.register("runRuntimeCompatibility") {
    group = "verification"
    description = "Exercises every supported artifact compatible with the requested consumer JVM."

    dependsOn(
        artifactProbeTasks
            .filterKeys { artifactName ->
                versionSupportPolicy.artifacts.getValue(artifactName).runtime <=
                    runtimeJavaVersion.get()
            }
            .values
    )
}
