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
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
}

tasks.test {
    useJUnitPlatform()
    workingDir(layout.projectDirectory)
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
        .file(layout.projectDirectory.file("../.github/workflows/ci.yml"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
}
