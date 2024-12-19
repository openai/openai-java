plugins {
    id("openai.kotlin")
    id("java")
    application
}

dependencies {
    implementation(project(":openai-java"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    mainClass = "com.openai.example.Main"
}
