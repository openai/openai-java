import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins { id("openai.core-distribution") }

// The release agent runs against an already assembled neutral classpath.
// A second invocation packages that trace before provenance is recorded.
providers.gradleProperty("responsesGraalMetadataDir").orNull?.let { metadata ->
    tasks.named<Jar>("jar") {
        from(metadata) { into("META-INF/native-image/com.openai/openai-java-responses-api") }
    }
}

dependencies {
    api(project(":openai-java-runtime"))
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
tasks.withType<KotlinCompile>().configureEach {
    friendPaths.from(project(":openai-java-runtime").layout.buildDirectory.dir("classes/kotlin/main"))
}
