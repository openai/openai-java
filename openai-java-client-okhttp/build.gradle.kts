plugins {
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

val jacksonPublishedVersion = libs.versions.jacksonPublished.get()

listOf(configurations.testCompileClasspath, configurations.testRuntimeClasspath).forEach {
    it.configure {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion(jacksonPublishedVersion)
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
    testImplementation(platform(libs.jackson.bom))
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testImplementation("com.squareup.okhttp3:okhttp-tls:4.12.0")
}
