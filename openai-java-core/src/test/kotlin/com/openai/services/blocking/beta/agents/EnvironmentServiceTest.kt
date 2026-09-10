// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class EnvironmentServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val environmentService = client.beta().agents().environments()

        val environmentInfo = environmentService.retrieve("environment_id")

        environmentInfo.validate()
    }
}
