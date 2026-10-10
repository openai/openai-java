import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.gradle.plugins.signing.SigningExtension

plugins {
    id("com.vanniktech.maven.publish")
}

val stageForAuthProxy = providers.gradleProperty("stageForAuthProxy").map(String::toBoolean).orElse(false).get()
require(!(stageForAuthProxy && project.hasProperty("publishLocal"))) {
    "Signed proxy staging cannot be combined with unsigned publishLocal"
}

publishing {
  repositories {
      if (project.hasProperty("publishLocal") || stageForAuthProxy) {
          maven {
              name = if (stageForAuthProxy) "AuthProxyStaging" else "LocalFileSystem"
              val directory = if (stageForAuthProxy) "auth-proxy-staging" else "local-maven-repo"
              url = uri("${rootProject.layout.buildDirectory.get()}/$directory")
          }
      }
  }
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

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
        if (!stageForAuthProxy) {
            publishToMavenCentral()
        }
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

// Preserve Kotlin source paths when Maven Publish uses Gradle's Java sources task.
tasks.named<Jar>("sourcesJar") {
    filesMatching("**/*.kt") {
        path = "main/$path"
    }
}

tasks.withType<Zip>().configureEach {
    isZip64 = true
}
