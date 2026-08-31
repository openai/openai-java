plugins {
    `kotlin-dsl`
    kotlin("jvm") version "1.9.20"
    id("com.vanniktech.maven.publish") version "0.28.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.28.0")

    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.2")
    testImplementation("org.yaml:snakeyaml:2.6")
}

tasks.test {
    useJUnitPlatform()
    workingDir(layout.projectDirectory)
    inputs
        .file(layout.projectDirectory.file("../scripts/gradle"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .files(
            fileTree(layout.projectDirectory.dir("../openai-java-core/src/main/kotlin")) {
                include("**/*.kt")
            }
        )
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../scripts/detect-breaking-changes"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(
            layout.projectDirectory.file(
                "../openai-java-core/src/apiCompatibility/" +
                    "structured-output-public-api.txt"
            )
        )
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../.github/workflows/ci.yml"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../.github/workflows/create-releases.yml"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../SECURITY.md"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
}
