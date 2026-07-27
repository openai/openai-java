plugins {
    id("openai.java")
}

dependencies {
    implementation(project(":openai-java"))
    implementation(project(":openai-java-bedrock"))
    implementation(project(":openai-java-spring-boot-starter"))
}

tasks.withType<JavaCompile>().configureEach {
    // JDK 21 warns that Java 8 is an old source target; this fixture intentionally compiles at the
    // SDK's minimum consumer level, and the repository otherwise promotes warnings to errors.
    options.compilerArgs.add("-Xlint:-options")
}

val runtimeJavaVersion =
    providers.gradleProperty("runtimeJavaVersion").map(String::toInt).orElse(8)

tasks.register<JavaExec>("runRuntimeCompatibility") {
    group = "verification"
    description = "Loads representative public SDK entry points on the requested consumer JVM."

    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("com.openai.compatibility.RuntimeCompatibilitySmokeTest")
    javaLauncher.set(
        javaToolchains.launcherFor {
            languageVersion.set(runtimeJavaVersion.map(JavaLanguageVersion::of))
        }
    )
}
