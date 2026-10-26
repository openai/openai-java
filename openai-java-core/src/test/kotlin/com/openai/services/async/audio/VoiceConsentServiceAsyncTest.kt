// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.audio.voiceconsents.VoiceConsentCreateParams
import com.openai.models.audio.voiceconsents.VoiceConsentUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VoiceConsentServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentServiceAsync = client.audio().voiceConsents()

        val voiceConsentFuture =
            voiceConsentServiceAsync.create(
                VoiceConsentCreateParams.builder()
                    .language("language")
                    .name("name")
                    .recording("Example data".byteInputStream())
                    .build()
            )

        val voiceConsent = voiceConsentFuture.get()
        voiceConsent.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentServiceAsync = client.audio().voiceConsents()

        val voiceConsentFuture = voiceConsentServiceAsync.retrieve("consent_id")

        val voiceConsent = voiceConsentFuture.get()
        voiceConsent.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentServiceAsync = client.audio().voiceConsents()

        val voiceConsentFuture =
            voiceConsentServiceAsync.update(
                VoiceConsentUpdateParams.builder().consentId("consent_id").name("name").build()
            )

        val voiceConsent = voiceConsentFuture.get()
        voiceConsent.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentServiceAsync = client.audio().voiceConsents()

        val pageFuture = voiceConsentServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val voiceConsentServiceAsync = client.audio().voiceConsents()

        val voiceConsentDeletedFuture = voiceConsentServiceAsync.delete("consent_id")

        val voiceConsentDeleted = voiceConsentDeletedFuture.get()
        voiceConsentDeleted.validate()
    }
}
