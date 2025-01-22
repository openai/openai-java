plugins {
    id("org.jetbrains.dokka") version "2.0.0"
    id("org.jetbrains.kotlinx.binary-compatibility-validator") version "0.17.0"
}

repositories {
    mavenCentral()
}

allprojects {
    group = "com.openai"
    version = "0.13.0" // x-release-please-version
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

apiValidation {
    ignoredProjects += setOf(
        "openai-java-example",
        "openai-azure-java-example",
    )
}
