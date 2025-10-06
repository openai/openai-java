// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.beta.chatkit.ChatKitUploadFileParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ChatKitServiceTest {

    @Test
    fun uploadFile() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val chatkitService = client.beta().chatkit()

        val response =
            chatkitService.uploadFile(
                ChatKitUploadFileParams.builder().file("some content".byteInputStream()).build()
            )

        response.validate()
    }
}
