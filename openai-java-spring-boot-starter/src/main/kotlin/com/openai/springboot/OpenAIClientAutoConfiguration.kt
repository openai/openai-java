// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import com.openai.client.OpenAIClient
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.springframework.beans.factory.ObjectProvider
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@AutoConfiguration
@ConditionalOnClass(OpenAIClient::class)
@EnableConfigurationProperties(OpenAIClientProperties::class)
class OpenAIClientAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    internal fun client(
        properties: OpenAIClientProperties,
        customizers: ObjectProvider<OpenAIClientCustomizer>,
    ): OpenAIClient =
        OpenAIOkHttpClient.builder()
            .apply {
                properties.baseUrl?.let { baseUrl(it) }
                properties.apiKey?.let { apiKey(it) }
                properties.organization?.let { organization(it) }
                properties.project?.let { project(it) }
                properties.webhookSecret?.let { webhookSecret(it) }
                customizers.orderedStream().forEach { it.customize(this) }
            }
            .build()
}
