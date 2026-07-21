// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import com.openai.client.OpenAIClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder

internal class SpringBootLoggingCompatibilityTest {

    @Test
    fun springApplicationStartsWithoutLogback() {
        val classLoader = Thread.currentThread().contextClassLoader ?: javaClass.classLoader
        assertThat(classLoader.getResource("ch/qos/logback/core/Context.class")).isNull()
        assertThat(classLoader.getResource("ch/qos/logback/classic/Logger.class")).isNull()

        SpringApplicationBuilder(TestApplication::class.java)
            .web(WebApplicationType.NONE)
            .properties("openai.api-key=test")
            .run()
            .use { context -> assertThat(context.getBean(OpenAIClient::class.java)).isNotNull() }
    }

    @SpringBootConfiguration @EnableAutoConfiguration internal open class TestApplication
}
