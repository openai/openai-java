plugins {
    `kotlin-dsl`
    kotlin("jvm") version "2.2.21"
    id("com.vanniktech.maven.publish") version "0.37.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.2.21")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.37.0")

    // Resolve the compiler fixture's standard library before its offline TestKit invocation.
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-stdlib:2.2.21")
    testImplementation(gradleTestKit())
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:6.1.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.yaml:snakeyaml:2.7")
}

tasks.test {
    useJUnitPlatform()
    // TestKit uses an isolated Gradle home. Reuse already-resolved build dependencies read-only
    // so its compiler fixture remains offline on fresh CI runners.
    environment(
        "GRADLE_RO_DEP_CACHE",
        providers.environmentVariable("GRADLE_RO_DEP_CACHE")
            .orElse(gradle.gradleUserHomeDir.resolve("caches").absolutePath).get(),
    )
    testLogging { exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL }
    workingDir(layout.projectDirectory)
    inputs
        .file(layout.projectDirectory.file("../scripts/gradle"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .files(
            layout.projectDirectory.file("../scripts/java-format"),
            layout.projectDirectory.file("../scripts/lint"),
            layout.projectDirectory.file("../scripts/format"),
            layout.projectDirectory.file("../scripts/collect-gradle-build-cache"),
        )
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
        .file(layout.projectDirectory.file("../.github/scripts/run-graalvm-tests.sh"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../SECURITY.md"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
    inputs
        .file(layout.projectDirectory.file("../docs/architecture/security-model.md"))
        .withPathSensitivity(PathSensitivity.RELATIVE)
}
