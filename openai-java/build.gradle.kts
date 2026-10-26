import org.jetbrains.dokka.gradle.AbstractDokkaLeafTask

plugins {
    id("openai.kotlin")
    id("openai.publish")
}

// Resolve provider-specific types only for documentation. They must not become
// dependencies of the umbrella SDK.
val sdkJavadocClasspath by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
}

dependencies {
    api(project(":openai-java-client-okhttp"))
    sdkJavadocClasspath(project(":openai-java-bedrock"))
    sdkJavadocClasspath(project(":openai-java-vertex"))
}

// Generate a single Javadoc index with all published APIs. The old root collector
// resolved subproject configurations while its task executed, which Gradle 9 rejects.
tasks.withType<AbstractDokkaLeafTask>().configureEach {
    dokkaSourceSets.named("main") {
        listOf(
                "openai-java-core",
                "openai-java-client-okhttp",
                "openai-java-bedrock",
                "openai-java-vertex",
            )
            .forEach { artifact ->
                sourceRoots.from(rootProject.layout.projectDirectory.dir("$artifact/src/main/kotlin"))
            }
        classpath.from(sdkJavadocClasspath)
    }
}
