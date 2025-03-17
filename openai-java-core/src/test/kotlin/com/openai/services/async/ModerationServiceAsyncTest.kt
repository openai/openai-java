// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.moderations.ModerationCreateParams
import com.openai.models.moderations.ModerationModel
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ModerationServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val moderationServiceAsync = client.moderations()

        val moderationFuture =
            moderationServiceAsync.create(
                ModerationCreateParams.builder()
                    .input("I want to kill them.")
                    .model(ModerationModel.OMNI_MODERATION_LATEST)
                    .build()
            )

        val moderation = moderationFuture.get()
        moderation.validate()
    }
}
