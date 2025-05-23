// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat.completions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.chat().completions().messages()

        val pageFuture = messageServiceAsync.list("completion_id")

        val page = pageFuture.get()
        page.response().validate()
    }
}
