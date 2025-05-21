// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.jobs

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CheckpointServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val checkpointServiceAsync = client.fineTuning().jobs().checkpoints()

        val pageFuture = checkpointServiceAsync.list("ft-AF1WoRqd3aJAHsqc9NY7iL8F")

        val page = pageFuture.get()
        page.response().validate()
    }
}
