// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import com.openai.client.OpenAIClient
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.boot.autoconfigure.AutoConfigurations
import org.springframework.boot.test.context.runner.ApplicationContextRunner

internal class OpenAIClientAutoConfigurationTest {

    private val contextRunner =
        ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(OpenAIClientAutoConfiguration::class.java))

    @Test
    fun properties() {
        contextRunner
            .withPropertyValues(
                "openai.base-url=https://api.openai.com/v1",
                "openai.api-key=My API Key",
                "openai.org-id=My Organization",
                "openai.project-id=My Project",
                "openai.webhook-secret=My Webhook Secret",
            )
            .run { context ->
                val properties = context.getBean<OpenAIClientProperties>()
                assertThat(properties.baseUrl).isEqualTo("https://api.openai.com/v1")
                assertThat(properties.apiKey).isEqualTo("My API Key")
                assertThat(properties.organization).isEqualTo("My Organization")
                assertThat(properties.project).isEqualTo("My Project")
                assertThat(properties.webhookSecret).isEqualTo("My Webhook Secret")
            }
    }

    @Test
    fun client() {
        contextRunner
            .withPropertyValues(
                "openai.base-url=https://api.openai.com/v1",
                "openai.api-key=My API Key",
                "openai.org-id=My Organization",
                "openai.project-id=My Project",
                "openai.webhook-secret=My Webhook Secret",
            )
            .run { it.getBean<OpenAIClient>() }
    }

    @Test
    fun clientWithoutRequiredProperties() {
        val throwable = catchThrowable {
            contextRunner
                .withPropertyValues(
                    "openai.base-url=https://api.openai.com/v1",
                    "openai.org-id=My Organization",
                    "openai.project-id=My Project",
                    "openai.webhook-secret=My Webhook Secret",
                )
                .run { it.getBean<OpenAIClient>() }
        }

        assertThat(throwable).isInstanceOf(IllegalStateException::class.java)
    }

    @Test
    fun clientWithCustomizers() {
        var customized = false
        contextRunner
            .withPropertyValues(
                "openai.base-url=https://api.openai.com/v1",
                "openai.api-key=My API Key",
                "openai.org-id=My Organization",
                "openai.project-id=My Project",
                "openai.webhook-secret=My Webhook Secret",
            )
            .withBean(
                OpenAIClientCustomizer::class.java,
                { OpenAIClientCustomizer { customized = true } },
            )
            .run {
                it.getBean<OpenAIClient>()
                assertThat(customized).isTrue()
            }
    }
}
