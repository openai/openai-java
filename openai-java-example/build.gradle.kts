plugins {
    id("openai.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":openai-java"))
    implementation("com.azure:azure-identity:1.15.0")
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(11)
}

application {
    // Use `./gradlew :openai-java-example:run` to run `Main`
    // Use `./gradlew :openai-java-example:run -Dexample=Something` to run `SomethingExample`
    mainClass = "com.openai.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
