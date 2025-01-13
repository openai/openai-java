plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

allprojects {
    group = "com.openai"
    version = "0.11.2" // x-release-please-version
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
    archiveClassifier.set("javadoc")
}
