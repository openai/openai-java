// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ChatKitServiceAsyncTest {

    @Test
    fun uploadFile() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatkitServiceAsync = client.beta().chatkit()

        val responseFuture =
            chatkitServiceAsync.uploadFile(
                ChatKitUploadFileParams.builder().file("some content".byteInputStream()).build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
