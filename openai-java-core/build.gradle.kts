import com.openai.gradle.CoreCompilationClaimedSourceIncludeSpec
import com.openai.gradle.CoreCompilationClaimedSourceSpec
import com.openai.gradle.CoreCompilationDependencies
import com.openai.gradle.CoreCompilationShards
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.tasks.Classpath
import org.gradle.jvm.tasks.Jar
import org.gradle.process.CommandLineArgumentProvider
import org.jetbrains.dokka.gradle.AbstractDokkaLeafTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

abstract class JavaAgentArgumentProvider : CommandLineArgumentProvider {
    @get:Classpath abstract val classpath: ConfigurableFileCollection

    override fun asArguments(): Iterable<String> =
        listOf("-javaagent:${classpath.singleFile.absolutePath}")
}

plugins {
    id("java")
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

val jacksonCompatibilityVersion = CoreCompilationDependencies.JACKSON_COMPATIBILITY_VERSION
val jacksonPublishedVersion = CoreCompilationDependencies.JACKSON_PUBLISHED_VERSION
val mockitoVersion = "5.14.2"
val mockitoAgent by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    isVisible = false
}

val coreCompilationShardProjects =
    CoreCompilationShards.projectNames.map { project(":$it") }

kotlin.sourceSets.named("main") {
    kotlin.exclude(CoreCompilationClaimedSourceSpec())
}

tasks.named<KotlinCompile>("compileKotlin") {
    friendPaths.from(
        coreCompilationShardProjects.map {
            it.layout.buildDirectory.dir("classes/kotlin/main")
        }
    )
}

val coreCompilationShardOutputs =
    coreCompilationShardProjects.map {
        it.layout.buildDirectory.dir("classes/kotlin/main")
    }

// Add the embedded shard outputs to the main classes variant. Downstream project dependencies use
// this variant, while the published jar still contains one cohesive openai-java-core artifact.
(sourceSets.main.get().output.classesDirs as ConfigurableFileCollection).from(
    coreCompilationShardOutputs
)

tasks.named<Jar>("kotlinSourcesJar") {
    from(
        fileTree("src/main/kotlin").matching {
            include(CoreCompilationClaimedSourceIncludeSpec())
        }
    ) {
        into("main")
    }
}

tasks.withType<AbstractDokkaLeafTask>().configureEach {
    dokkaSourceSets.configureEach {
        sourceRoots.from(layout.projectDirectory.dir("src/main/kotlin"))
    }
}

// Runtime classpath for `testJacksonCompatibility`: the same dependencies as
// `testRuntimeClasspath`, but forced to the older Jackson version that the SDK supports.
val jacksonCompatibilityRuntime by configurations.creating {
    extendsFrom(configurations.testRuntimeClasspath.get())
    isCanBeConsumed = false
    isCanBeResolved = true
    attributes.attribute(
        org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE,
        17,
    )
}

// Keep the normal test runtime on the same secure Jackson release that consumers receive. WireMock
// 3 requires newer Jackson APIs, so compatibility testing runs separately below.
configurations.testRuntimeClasspath.configure {
    resolutionStrategy.eachDependency {
        if (
            requested.group == "com.fasterxml.jackson" ||
                requested.group.startsWith("com.fasterxml.jackson.")
        ) {
            useVersion(jacksonPublishedVersion)
            because("tests must exercise the SDK's secure published Jackson release")
        }
    }
}

// Palantir, Dokka, and the normal test runtime have independently aligned Jackson classpaths.
configurations.matching {
    it.name != configurations.testRuntimeClasspath.get().name &&
        it.name != "palantir" &&
        !it.name.startsWith("dokka")
}.configureEach {
    resolutionStrategy {
        // Compile and test against a lower Jackson version to ensure we're compatible with it. Note that
        // we generally support 2.13.4, but test against 2.14.0 because 2.13.4 has some annoying (but
        // niche) bugs (users should upgrade if they encounter them). We publish with a higher version
        // (see below) to ensure users depend on a secure version by default.
        force("com.fasterxml.jackson.core:jackson-core:$jacksonCompatibilityVersion")
        force("com.fasterxml.jackson.core:jackson-databind:$jacksonCompatibilityVersion")
        force("com.fasterxml.jackson.core:jackson-annotations:$jacksonCompatibilityVersion")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonCompatibilityVersion")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonCompatibilityVersion")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonCompatibilityVersion")
    }
}

dependencies {
    coreCompilationShardProjects.forEach { compileOnly(it) }

    CoreCompilationDependencies.publishedApiDependencies.forEach { api(it) }
    CoreCompilationDependencies.publishedImplementationDependencies.forEach {
        implementation(it)
    }

    testImplementation(kotlin("test"))
    testImplementation(project(":openai-java-client-okhttp"))
    testImplementation(platform("com.fasterxml.jackson:jackson-bom:2.21.5"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
    testRuntimeOnly("org.slf4j:slf4j-nop:2.0.17") {
        because("prevent SLF4J provider diagnostics from racing stderr assertions")
    }
    mockitoAgent("org.mockito:mockito-core:$mockitoVersion") { isTransitive = false }
}

// Re-run the core and model tests against the older supported Jackson version. Service and
// WireMock-specific tests exercise HTTP plumbing and the mock server rather than Jackson
// compatibility, and WireMock 3 requires newer Jackson APIs.
val testJacksonCompatibility by tasks.registering(Test::class) {
    group = "verification"
    description = "Runs core and model tests against the older supported Jackson version."
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath =
        sourceSets.test.get().output + sourceSets.main.get().output + jacksonCompatibilityRuntime
    shouldRunAfter(tasks.test)
    exclude("**/services/**")
    exclude("**/RetryingHttpClientTest*")
    exclude("**/WireMockHandlebarsCompatibilityTest*")
    systemProperty("junit.jupiter.execution.parallel.enabled", false)
    systemProperty("expected.jackson.version", jacksonCompatibilityVersion)
}

tasks.withType<Test>().configureEach {
    jvmArgumentProviders.add(
        objects.newInstance<JavaAgentArgumentProvider>().apply {
            classpath.from(mockitoAgent)
        }
    )
}

tasks.test {
    systemProperty("expected.jackson.version", jacksonPublishedVersion)
}

tasks.check { dependsOn(testJacksonCompatibility) }

if (project.hasProperty("graalvmAgent")) {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
            vendor.set(JvmVendorSpec.GRAAL_VM)
        }
    }

    tasks.test {
        maxParallelForks = 1
        forkEvery = 0
        jvmArgs(
            "-agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image"
        )
    }
}
