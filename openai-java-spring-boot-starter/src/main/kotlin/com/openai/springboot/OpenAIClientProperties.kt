// File generated from our OpenAPI spec by Stainless.

package com.openai.springboot

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.bind.Name

@ConfigurationProperties(prefix = "openai")
internal data class OpenAIClientProperties
@ConstructorBinding
constructor(
    @Name("base-url") val baseUrl: String? = null,
    @Name("api-key") val apiKey: String? = null,
    @Name("org-id") val organization: String? = null,
    @Name("project-id") val project: String? = null,
    @Name("webhook-secret") val webhookSecret: String? = null,
)
