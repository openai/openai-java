import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish")
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal")) {
          maven {
              name = "LocalFileSystem"
              url = uri("${rootProject.layout.buildDirectory.get()}/local-maven-repo")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

// Stable JPMS module names for the published artifacts, derived from the `com.openai` group ID and
// the packages each artifact ships. Without them, consumers on the module path get a name derived
// from the JAR file name, which is neither namespaced nor stable across renames. Treat these as
// public API: once released, changing a name breaks every consumer that `requires` it.
val automaticModuleNames =
    mapOf(
        // Aggregator artifact: ships no packages of its own, so it takes the group's root name.
        "openai-java" to "com.openai",
        // Ships `com.openai.core` along with the rest of the `com.openai` namespace.
        "openai-java-core" to "com.openai.core",
        "openai-java-client-okhttp" to "com.openai.client.okhttp",
        "openai-java-bedrock" to "com.openai.bedrock",
    )

val automaticModuleName =
    checkNotNull(automaticModuleNames[project.name]) {
        "${project.name} is published but has no automatic module name"
    }

pluginManager.withPlugin("java") {
    tasks.named<Jar>("jar") {
        manifest { attributes("Automatic-Module-Name" to automaticModuleName) }
    }
}

extra["signingInMemoryKey"] = System.getenv("GPG_SIGNING_KEY")
extra["signingInMemoryKeyId"] = System.getenv("GPG_SIGNING_KEY_ID")
extra["signingInMemoryKeyPassword"] = System.getenv("GPG_SIGNING_PASSWORD")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    configure(
        KotlinJvm(
            javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
            sourcesJar = true,
        )
    )

    pom {
        name.set("OpenAI API")
        description.set("The OpenAI REST API. Please see https://platform.openai.com/docs/api-reference\nfor more details.")
        url.set("https://platform.openai.com/docs")

        licenses {
            license {
                name.set("Apache-2.0")
            }
        }

        developers {
            developer {
                name.set("OpenAI")
                email.set("support@openai.com")
            }
        }

        scm {
            connection.set("scm:git:git://github.com/openai/openai-java.git")
            developerConnection.set("scm:git:git://github.com/openai/openai-java.git")
            url.set("https://github.com/openai/openai-java")
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
