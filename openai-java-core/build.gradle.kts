plugins {
    id("java")
    id("openai.kotlin")
    id("openai.publish")
}

val jacksonCompatibilityVersion = "2.14.0"
val jacksonPublishedVersion = "2.18.9"

// Runtime classpath for `testJacksonPublished`: the same dependencies as `testRuntimeClasspath`,
// but exempt from the compatibility-version force below so Jackson resolves to the version that
// consumers receive by default.
val jacksonPublishedRuntime by configurations.creating {
    extendsFrom(configurations.testRuntimeClasspath.get())
    isCanBeConsumed = false
    isCanBeResolved = true
}

// Palantir and Dokka are isolated build tools with independently aligned Jackson classpaths.
configurations.matching {
    it.name != jacksonPublishedRuntime.name &&
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
    constraints {
        testImplementation("com.google.guava:guava:33.6.0-jre") {
            because("WireMock's transitive Guava 31.1-jre has known temporary-file vulnerabilities")
        }
        testImplementation("commons-fileupload:commons-fileupload:1.6.0") {
            because("WireMock's transitive 1.4 release has known denial-of-service vulnerabilities")
        }
    }

    api("com.fasterxml.jackson.core:jackson-core:$jacksonPublishedVersion")
    api("com.fasterxml.jackson.core:jackson-databind:$jacksonPublishedVersion")
    api("com.google.errorprone:error_prone_annotations:2.33.0")
    api("io.swagger.core.v3:swagger-annotations:2.2.31")

    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonPublishedVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:$jacksonPublishedVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonPublishedVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonPublishedVersion")
    implementation("com.github.victools:jsonschema-generator:4.38.0")
    implementation("com.github.victools:jsonschema-module-jackson:4.38.0")
    implementation("com.github.victools:jsonschema-module-swagger-2:4.38.0")

    testImplementation(kotlin("test"))
    testImplementation(project(":openai-java-client-okhttp"))
    testImplementation(platform("org.eclipse.jetty:jetty-bom:9.4.58.v20250814"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    constraints {
        // Keep handlebars-helpers at 4.3.1: WireMock 2 links helper classes moved in 4.5.x.
        testImplementation("com.github.jknack:handlebars:4.5.3") {
            because("WireMock's transitive 4.3.1 dependency is affected by CVE-2026-55760")
        }
    }
}

// Re-run the compiled tests against the Jackson version consumers receive by default. Service tests
// exercise HTTP plumbing and the mock server rather than Jackson compatibility, so the second pass
// focuses on the core and model tests that cover serialization behavior.
val testJacksonPublished by tasks.registering(Test::class) {
    group = "verification"
    description = "Runs tests against the published Jackson version."
    testClassesDirs = sourceSets.test.get().output.classesDirs
    classpath = sourceSets.test.get().output + sourceSets.main.get().output + jacksonPublishedRuntime
    shouldRunAfter(tasks.test)
    exclude("**/services/**")
    systemProperty("junit.jupiter.execution.parallel.enabled", false)
    systemProperty("expected.jackson.version", jacksonPublishedVersion)
}

tasks.test {
    systemProperty("expected.jackson.version", jacksonCompatibilityVersion)
}

tasks.check { dependsOn(testJacksonPublished) }

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
