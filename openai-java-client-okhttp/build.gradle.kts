plugins {
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

listOf(configurations.testCompileClasspath, configurations.testRuntimeClasspath).forEach {
    it.configure {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion("2.18.9")
                because("test classpaths must use the SDK's secure published Jackson release")
            }
        }
    }
}

dependencies {
    api(project(":openai-java-core"))

    api("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(platform("com.fasterxml.jackson:jackson-bom:2.21.5"))
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testImplementation("com.squareup.okhttp3:okhttp-tls:4.12.0")
}
