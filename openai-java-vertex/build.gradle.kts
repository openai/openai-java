plugins {
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

dependencies {
    api(project(":openai-java-client-okhttp"))
    // This dependency stays isolated from the normal OpenAI client classpath.
    api("com.google.auth:google-auth-library-oauth2-http:1.43.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation(platform("com.fasterxml.jackson:jackson-bom:2.21.5"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Never reuse or store an authorized live verdict. Keep ordinary compilation/shard caches intact.
tasks.named<Test>("test") {
    val vertexLiveEnabled =
        providers.environmentVariable("VERTEX_LIVE_TEST").map { it == "1" }.orElse(false)
    inputs.property("vertexLiveTest", vertexLiveEnabled)
    outputs.upToDateWhen { !vertexLiveEnabled.get() }
    outputs.doNotCacheIf("Live acceptance must use the selected current deployment") {
        vertexLiveEnabled.get()
    }
    // Exercise the optional module as its built JAR with Gradle's resolved runtime dependencies.
    classpath = files(tasks.named("jar")) + classpath.minus(sourceSets.main.get().output)
}
