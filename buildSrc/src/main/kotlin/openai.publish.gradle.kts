import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.JavaPlatform
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.plugins.signing.SigningExtension

plugins {
    // All publication settings (including the Javadoc task) are configured below. The full
    // plugin also auto-detects Dokka after evaluation and assumes V2, even when configured.
    id("com.vanniktech.maven.publish.base")
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

val isPlatform = plugins.hasPlugin("java-platform")

configure<MavenPublishBaseExtension> {
    if (!project.hasProperty("publishLocal")) {
        signAllPublications()
        configure<SigningExtension> {
            useInMemoryPgpKeys(
                System.getenv("GPG_SIGNING_KEY_ID"),
                System.getenv("GPG_SIGNING_KEY"),
                System.getenv("GPG_SIGNING_PASSWORD"),
            )
        }
        publishToMavenCentral()
    }

    coordinates(project.group.toString(), project.name, project.version.toString())
    if (isPlatform) {
        configure(JavaPlatform())
    } else {
        configure(
            KotlinJvm(
                javadocJar = JavadocJar.Dokka("dokkaJavadoc"),
                sourcesJar = true,
            )
        )
    }

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

if (!isPlatform) {
    dependencies {
        add("api", platform(project(":openai-java-bom")))
    }

    // Installed consumers resolve each published project dependency from the same local repository.
    val localPublish = "publishMavenPublicationToLocalFileSystemRepository"
    val publishedDependencies = configurations.named("runtimeElements")
    tasks.matching { it.name == localPublish }.configureEach {
        dependsOn(publishedDependencies.map { elements ->
            elements.allDependencies.withType<ProjectDependency>().map { "${it.path}:$localPublish" }
        })
    }

    val packageRelativeSources = project.name in setOf("openai-java-http-okhttp", "openai-java-responses")
    tasks.named<Jar>("sourcesJar") {
        filesMatching("**/*.kt") {
            // Eclipse looks up split client sources by their package path.
            path = if (packageRelativeSources) path.removePrefix("main/") else "main/$path"
        }
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
