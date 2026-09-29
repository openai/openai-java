plugins {
    id("openai.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":openai-java"))
    implementation(project(":openai-java-bedrock"))
    // Keep Azure Identity's Netty runtime aligned on a secure release.
    implementation(platform("io.netty:netty-bom:4.1.137.Final"))
    implementation("com.azure:azure-identity:1.18.4")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(11)
}

application {
    // Use `./gradlew :openai-java-example:run` to run `Main`
    // Use `./gradlew :openai-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.openai.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
