plugins {
    id("openai.kotlin")
    id("com.gradleup.shadow") version "8.3.8"
}

buildscript {
    dependencies {
        classpath("com.guardsquare:proguard-gradle:7.4.2")
    }
}

dependencies {
    testImplementation(project(":openai-java"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    testImplementation("org.junit.platform:junit-platform-console:1.10.1")
}

tasks.shadowJar {
    from(sourceSets.test.get().output)
    configurations = listOf(project.configurations.testRuntimeClasspath.get())
}

val proguardJarPath = "${layout.buildDirectory.get()}/libs/${project.name}-${project.version}-proguard.jar"
val proguardJar by tasks.registering(proguard.gradle.ProGuardTask::class) {
    group = "verification"
    dependsOn(tasks.shadowJar)
    notCompatibleWithConfigurationCache("ProGuard")

    injars(tasks.shadowJar)
    outjars(proguardJarPath)
    printmapping("${layout.buildDirectory.get()}/proguard-mapping.txt")

    verbose()
    dontwarn()

    val javaHome = System.getProperty("java.home")
    if (System.getProperty("java.version").startsWith("1.")) {
        // Before Java 9, the runtime classes were packaged in a single jar file.
        libraryjars("$javaHome/lib/rt.jar")
    } else {
        // As of Java 9, the runtime classes are packaged in modular jmod files.
        libraryjars(
            // Filters must be specified first, as a map.
            mapOf("jarfilter" to "!**.jar", "filter" to "!module-info.class"),
            "$javaHome/jmods/java.base.jmod"
        )
    }

    configuration("./test.pro")
    configuration("../openai-java-core/src/main/resources/META-INF/proguard/openai-java-core.pro")
}

val testProGuard by tasks.registering(JavaExec::class) {
    group = "verification"
    dependsOn(proguardJar)
    notCompatibleWithConfigurationCache("ProGuard")

    mainClass.set("org.junit.platform.console.ConsoleLauncher")
    classpath = files(proguardJarPath)
    args = listOf(
        "--classpath", proguardJarPath,
        "--scan-classpath",
        "--details", "verbose",
    )
}

tasks.test {
    dependsOn(testProGuard)
    // We defer to the tests run via the ProGuard JAR.
    enabled = false
}
