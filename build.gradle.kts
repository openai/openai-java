import com.openai.gradle.VerifyVersionSupportPolicyTask
import java.util.Properties
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.SourceSetContainer

buildscript {
    dependencies {
        constraints {
            classpath("com.fasterxml.jackson.core:jackson-annotations:2.18.9")
            classpath("com.fasterxml.jackson.core:jackson-core:2.18.9")
            classpath("com.fasterxml.jackson.core:jackson-databind:2.18.9")
            classpath("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.9")
            classpath("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.9")
        }
    }
}

plugins {
    id("org.jetbrains.dokka") version "2.1.0"
}

val dokkaJacksonVersion = "2.18.9"

repositories {
    mavenCentral()
}

allprojects {
    group = "com.openai"
    version = "4.45.0" // x-release-please-version

    // Dokka 2.1.0 depends on Jackson 2.15.3. Keep its isolated build-tool classpaths on a
    // secure, internally aligned Jackson release without changing the SDK's published or
    // compatibility-test dependency versions.
    configurations.matching { it.name.startsWith("dokka") }.configureEach {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion(dokkaJacksonVersion)
                because("Dokka's build-only Jackson classpath must use a secure aligned release")
            }
        }
    }
}

subprojects {
    // These are populated with dependencies by `buildSrc` scripts.
    tasks.register("format") {
        group = "Verification"
        description = "Formats all source files."
    }
    tasks.register("lint") {
        group = "Verification"
        description = "Verifies all source files are formatted."
    }
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}

val versionSupportFile = layout.projectDirectory.file("gradle/version-support.properties")
val versionSupport =
    Properties().apply { versionSupportFile.asFile.inputStream().use(::load) }
val artifactRuntimeFloors =
    versionSupport
        .stringPropertyNames()
        .filter { it.startsWith("artifact.") && it.endsWith(".runtime") }
        .associate { property ->
            property.removePrefix("artifact.").removeSuffix(".runtime") to
                versionSupport.getProperty(property).toInt()
        }

tasks.register("verifyVersionSupportPolicy") {
    group = "verification"
    description = "Verifies published artifact runtime floors and lifecycle declarations."

    inputs.file(versionSupportFile)
    dependsOn(artifactRuntimeFloors.keys.map { ":$it:verifyVersionSupportPolicy" })
}

subprojects {
    val artifactName = name

    pluginManager.withPlugin("openai.publish") {
        val runtimeFloor =
            artifactRuntimeFloors[artifactName]
                ?: error(
                    "$artifactName is published but missing from ${versionSupportFile.asFile}"
                )
        val lifecycle =
            versionSupport.getProperty("artifact.$artifactName.lifecycle")
                ?: error(
                    "$artifactName is missing a lifecycle in ${versionSupportFile.asFile}"
                )

        pluginManager.withPlugin("java") {
            val java = extensions.getByType(JavaPluginExtension::class.java)
            val mainSourceSet = extensions.getByType(SourceSetContainer::class.java).getByName("main")

            tasks.register<VerifyVersionSupportPolicyTask>("verifyVersionSupportPolicy") {
                group = "verification"
                description =
                    "Verifies $artifactName against its declared version support policy."

                this.artifactName.set(artifactName)
                this.runtimeFloor.set(runtimeFloor)
                this.lifecycle.set(lifecycle)
                requiredBuildJdk.set(versionSupport.getProperty("build.jdk").toInt())
                configuredBuildJdk.set(java.toolchain.languageVersion.map { it.asInt() })
                sourceCompatibility.set(java.sourceCompatibility.majorVersion.toInt())
                targetCompatibility.set(java.targetCompatibility.majorVersion.toInt())
                classFiles.from(mainSourceSet.output.classesDirs)

                dependsOn(tasks.named("classes"))
            }
        }
    }
}

// Avoid race conditions between `dokkaJavadocCollector` and `dokkaJavadocJar` tasks
tasks.named("dokkaJavadocCollector").configure {
    subprojects.flatMap { it.tasks }
        .filter { it.project.name != "openai-java" && it.name == "dokkaJavadocJar" }
        .forEach { mustRunAfter(it) }
}
