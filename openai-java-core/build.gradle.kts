plugins {
    id("java")
    id("openai.kotlin")
    id("openai.publish")
}

listOf(configurations.testCompileClasspath, configurations.testRuntimeClasspath).forEach {
    it.configure {
        attributes.attribute(
            org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE,
            17,
        )
    }
}

val jacksonCompatibilityVersion = "2.14.0"
val jacksonPublishedVersion = "2.18.9"

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
    constraints {
        testImplementation("com.google.guava:guava:33.6.0-jre") {
            because("WireMock's transitive Guava 31.1-jre has known temporary-file vulnerabilities")
        }
        testImplementation("commons-fileupload:commons-fileupload:1.6.0") {
            because("WireMock's transitive 1.4 release has known denial-of-service vulnerabilities")
        }
        testImplementation("org.xmlunit:xmlunit-core:2.11.0") {
            because("2.10.0 fixes CVE-2024-31573 in this test-only dependency")
        }
        testImplementation("commons-io:commons-io:2.22.0") {
            because("WireMock's transitive Commons IO version has a resource-exhaustion vulnerability")
        }
        testImplementation("com.jayway.jsonpath:json-path:2.10.0") {
            because("WireMock's transitive JSONPath version has a stack-overflow vulnerability")
        }
        testImplementation("org.apache.commons:commons-lang3:3.18.0") {
            because("WireMock's transitive 3.12.0 release is vulnerable to uncontrolled recursion")
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
    testImplementation(platform("org.eclipse.jetty:jetty-bom:12.0.33"))
    testImplementation(platform("org.eclipse.jetty.ee10:jetty-ee10-bom:12.0.33"))
    testImplementation("org.wiremock:wiremock-jetty12:3.13.2")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")

    constraints {
        testImplementation("com.github.jknack:handlebars:4.5.3") {
            because("WireMock's transitive 4.3.1 dependency is affected by CVE-2026-55760")
        }
    }
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
