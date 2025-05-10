// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.jobs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CheckpointServiceTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkpointService = client.fineTuning().jobs().checkpoints()

        val page = checkpointService.list("ft-AF1WoRqd3aJAHsqc9NY7iL8F")

        page.response().validate()
    }
}
