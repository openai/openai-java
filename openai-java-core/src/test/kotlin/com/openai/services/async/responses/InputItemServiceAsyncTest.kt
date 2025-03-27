// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.responses.inputitems.InputItemListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InputItemServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inputItemServiceAsync = client.responses().inputItems()

        val pageFuture =
            inputItemServiceAsync.list(
                InputItemListParams.builder().responseId("response_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
