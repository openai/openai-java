plugins {
    id("org.jetbrains.dokka") version "2.1.0"
}

val dokkaJacksonVersion = "2.18.9"

repositories {
    mavenCentral()
}

allprojects {
    group = "com.openai"
    version = "4.44.0" // x-release-please-version

    // Dokka 2.1.0 depends on Jackson 2.15.3. Keep its isolated build-tool classpaths on a
    // secure, internally aligned Jackson release without changing the SDK's published or
    // compatibility-test dependency versions.
    configurations.matching { it.name.startsWith("dokka") }.configureEach {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion(dokkaJacksonVersion)
                because("Dokka's build-only Jackson classpath must use a secure aligned release")
            }
        }
    }
}

subprojects {
    // These are populated with dependencies by `buildSrc` scripts.
    tasks.register("format") {
        group = "Verification"
        description = "Formats all source files."
    }
    tasks.register("lint") {
        group = "Verification"
        description = "Verifies all source files are formatted."
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

// Avoid race conditions between `dokkaJavadocCollector` and `dokkaJavadocJar` tasks
tasks.named("dokkaJavadocCollector").configure {
    subprojects.flatMap { it.tasks }
        .filter { it.project.name != "openai-java" && it.name == "dokkaJavadocJar" }
        .forEach { mustRunAfter(it) }
}
