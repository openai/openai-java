plugins {
    id("openai.kotlin")
    id("java")
    application
}

dependencies {
    implementation(project(":openai-java"))
    api("com.azure:azure-identity:1.15.0")
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(11)
}

application {
    mainClass = "com.openai.example.CompletionsExample"
}
