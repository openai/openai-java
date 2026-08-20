// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AudioResponseFormatTest {

    /**
     * Regression test for [#652](https://github.com/openai/openai-java/issues/652).
     *
     * Each value of [AudioResponseFormat.Known] is enumerated explicitly so that adding a new
     * format also requires adding it to this test. That makes it impossible to introduce a new JSON
     * format without consciously deciding whether [AudioResponseFormat.isJson] should return `true`
     * for it — the bug that caused `DIARIZED_JSON` responses to be parsed as plain text and stashed
     * in `TranscriptionCreateResponse.transcription.text` instead of populating
     * `TranscriptionCreateResponse.diarized`.
     */
    @Test
    fun isJson_returnsTrue_forEveryJsonResponseFormat() {
        for (known in AudioResponseFormat.Known.values()) {
            val format = AudioResponseFormat.of(known.toString().lowercase())
            val expected =
                when (known) {
                    AudioResponseFormat.Known.JSON -> true
                    AudioResponseFormat.Known.TEXT -> false
                    AudioResponseFormat.Known.SRT -> false
                    AudioResponseFormat.Known.VERBOSE_JSON -> true
                    AudioResponseFormat.Known.VTT -> false
                    AudioResponseFormat.Known.DIARIZED_JSON -> true
                }
            assertThat(format.isJson())
                .withFailMessage(
                    "AudioResponseFormat.$known.isJson() returned %s but expected %s",
                    format.isJson(),
                    expected,
                )
                .isEqualTo(expected)
        }
    }

    /**
     * Pinning [#652](https://github.com/openai/openai-java/issues/652) directly: a SDK consumer
     * that requests `diarized_json` and feeds the value back through [AudioResponseFormat.of] must
     * see [AudioResponseFormat.isJson] return `true`, otherwise the response body is treated as
     * plain text by the transcription parser.
     */
    @Test
    fun diarizedJson_isReportedAsJson() {
        assertThat(AudioResponseFormat.DIARIZED_JSON.isJson()).isTrue()
        assertThat(AudioResponseFormat.of("diarized_json").isJson()).isTrue()
    }
}
