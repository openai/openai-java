plugins {
    id("openai.kotlin")
    id("openai.publish")
}

configurations.all {
    resolutionStrategy {
        // Compile and test against a lower Jackson version to ensure we're compatible with it.
        // We publish with a higher version (see below) to ensure users depend on a secure version by default.
        force("com.fasterxml.jackson.core:jackson-core:2.13.4")
        force("com.fasterxml.jackson.core:jackson-databind:2.13.4")
        force("com.fasterxml.jackson.core:jackson-annotations:2.13.4")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.13.4")
        force("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.4")
        force("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    }
}

dependencies {
    api("com.fasterxml.jackson.core:jackson-core:2.18.1")
    api("com.fasterxml.jackson.core:jackson-databind:2.18.1")
    api("com.google.errorprone:error_prone_annotations:2.33.0")

    implementation("com.fasterxml.jackson.core:jackson-annotations:2.18.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jdk8:2.18.1")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.18.1")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.1")
    implementation("org.apache.httpcomponents.core5:httpcore5:5.2.4")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.3.1")

    testImplementation(kotlin("test"))
    testImplementation(project(":openai-java-client-okhttp"))
    testImplementation("com.github.tomakehurst:wiremock-jre8:2.35.2")
    testImplementation("org.assertj:assertj-core:3.25.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
    testImplementation("org.junit-pioneer:junit-pioneer:1.9.1")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.1.0")
}
