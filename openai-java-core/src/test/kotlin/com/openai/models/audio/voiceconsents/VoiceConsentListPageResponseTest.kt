// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VoiceConsentListPageResponseTest {

    @Test
    fun createAndRoundtrip() {
        val voiceConsentListPageResponse =
            VoiceConsentListPageResponse.builder()
                .addData(
                    VoiceConsent.builder()
                        .id("cons_1234")
                        .createdAt(0L)
                        .language("language")
                        .name("name")
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(voiceConsentListPageResponse.data())
            .containsExactly(
                VoiceConsent.builder()
                    .id("cons_1234")
                    .createdAt(0L)
                    .language("language")
                    .name("name")
                    .build()
            )
        assertThat(voiceConsentListPageResponse.hasMore()).isEqualTo(true)
        assertThat(voiceConsentListPageResponse.firstId()).contains("first_id")
        assertThat(voiceConsentListPageResponse.lastId()).contains("last_id")

        val jsonMapper = jsonMapper()

        val roundtrippedVoiceConsentListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(voiceConsentListPageResponse),
                jacksonTypeRef<VoiceConsentListPageResponse>(),
            )

        assertThat(roundtrippedVoiceConsentListPageResponse).isEqualTo(voiceConsentListPageResponse)
    }
}
