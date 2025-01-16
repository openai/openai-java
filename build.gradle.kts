plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

allprojects {
    group = "com.openai"
    version = "0.11.4" // x-release-please-version
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}
