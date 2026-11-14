import com.openai.gradle.VersionSupportPolicy

plugins {
    `java-platform`
    id("openai.publish")
}

val sdkVersion = project.version.toString()
val binaryArtifacts = VersionSupportPolicy.load(rootProject.file("gradle/version-support.properties"))
    .artifacts.filterValues { it.lifecycle.isSupported }.keys

dependencies {
    constraints {
        binaryArtifacts.forEach { artifact ->
            api("${project.group}:$artifact") {
                version { strictly(sdkVersion) }
            }
        }
    }
}
