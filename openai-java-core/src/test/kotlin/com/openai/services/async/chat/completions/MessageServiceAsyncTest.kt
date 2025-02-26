// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat.completions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.ChatCompletionMessageListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MessageServiceAsyncTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageServiceAsync = client.chat().completions().messages()

        val pageFuture =
            messageServiceAsync.list(
                ChatCompletionMessageListParams.builder().completionId("completion_id").build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }
}
