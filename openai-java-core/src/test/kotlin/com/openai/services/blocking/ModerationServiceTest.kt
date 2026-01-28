// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.moderations.ModerationCreateParams
import com.openai.models.moderations.ModerationModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModerationServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val moderationService = client.moderations()

        val moderation =
            moderationService.create(
                ModerationCreateParams.builder()
                    .input("I want to kill them.")
                    .model(ModerationModel.OMNI_MODERATION_LATEST)
                    .build()
            )

        moderation.validate()
    }
}
