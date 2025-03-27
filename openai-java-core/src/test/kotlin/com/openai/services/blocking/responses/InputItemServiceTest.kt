// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.responses.inputitems.InputItemListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InputItemServiceTest {

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inputItemService = client.responses().inputItems()

        val page =
            inputItemService.list(InputItemListParams.builder().responseId("response_id").build())

        page.response().validate()
    }
}
