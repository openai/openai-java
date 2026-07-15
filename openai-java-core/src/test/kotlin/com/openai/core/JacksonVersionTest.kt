package com.openai.core

import com.fasterxml.jackson.annotation.JacksonAnnotation
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class JacksonVersionTest {

    @Test
    fun runtimeJacksonVersionsMatchExpectedVersion() {
        val expectedVersion = checkNotNull(System.getProperty("expected.jackson.version"))
        val runtimeVersions =
            mapOf(
                "jackson-annotations" to
                    JacksonAnnotation::class.java.`package`.implementationVersion,
                "jackson-core" to com.fasterxml.jackson.core.json.PackageVersion.VERSION.toString(),
                "jackson-databind" to
                    com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION.toString(),
                "jackson-datatype-jdk8" to
                    com.fasterxml.jackson.datatype.jdk8.PackageVersion.VERSION.toString(),
                "jackson-datatype-jsr310" to
                    com.fasterxml.jackson.datatype.jsr310.PackageVersion.VERSION.toString(),
                "jackson-module-kotlin" to
                    com.fasterxml.jackson.module.kotlin.PackageVersion.VERSION.toString(),
            )

        runtimeVersions.forEach { (module, runtimeVersion) ->
            assertThat(runtimeVersion)
                .describedAs("%s runtime version", module)
                .isEqualTo(expectedVersion)
        }
    }
}
