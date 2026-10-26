// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.audio.voiceconsents.VoiceConsentCreateParams
import com.openai.models.audio.voiceconsents.VoiceConsentUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VoiceConsentServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentService = client.audio().voiceConsents()

        val voiceConsent =
            voiceConsentService.create(
                VoiceConsentCreateParams.builder()
                    .language("language")
                    .name("name")
                    .recording("Example data".byteInputStream())
                    .build()
            )

        voiceConsent.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentService = client.audio().voiceConsents()

        val voiceConsent = voiceConsentService.retrieve("consent_id")

        voiceConsent.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentService = client.audio().voiceConsents()

        val voiceConsent =
            voiceConsentService.update(
                VoiceConsentUpdateParams.builder().consentId("consent_id").name("name").build()
            )

        voiceConsent.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentService = client.audio().voiceConsents()

        val page = voiceConsentService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentService = client.audio().voiceConsents()

        val voiceConsentDeleted = voiceConsentService.delete("consent_id")

        voiceConsentDeleted.validate()
    }
}
