// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat.completions

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class MessageServiceTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val messageService = client.chat().completions().messages()

        val page = messageService.list("completion_id")

        page.response().validate()
    }
}
