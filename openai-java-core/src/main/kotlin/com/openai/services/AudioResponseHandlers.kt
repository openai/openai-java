package com.openai.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.stringHandler
import com.openai.core.http.HttpResponse
import com.openai.models.audio.transcriptions.Transcription
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import com.openai.models.audio.transcriptions.TranscriptionDiarized
import com.openai.models.audio.transcriptions.TranscriptionVerbose
import com.openai.models.audio.translations.Translation
import com.openai.models.audio.translations.TranslationCreateResponse

internal class TranscriptionResponseHandler(jsonMapper: JsonMapper) {
    private val json = jsonHandler<TranscriptionCreateResponse>(jsonMapper)
    private val diarized = jsonHandler<TranscriptionDiarized>(jsonMapper)
    private val verbose = jsonHandler<TranscriptionVerbose>(jsonMapper)

    fun handle(response: HttpResponse, format: String?): TranscriptionCreateResponse =
        when (format) {
            "diarized_json" -> TranscriptionCreateResponse.ofDiarized(diarized.handle(response))
            "verbose_json" -> TranscriptionCreateResponse.ofVerbose(verbose.handle(response))
            null,
            "json" -> json.handle(response)
            else ->
                TranscriptionCreateResponse.ofTranscription(
                    Transcription.builder().text(stringHandler().handle(response)).build()
                )
        }
}

internal class TranslationResponseHandler(jsonMapper: JsonMapper) {
    private val json = jsonHandler<TranslationCreateResponse>(jsonMapper)

    fun handle(response: HttpResponse, format: String?): TranslationCreateResponse =
        when (format) {
            "text",
            "srt",
            "vtt" ->
                TranslationCreateResponse.ofTranslation(
                    Translation.builder().text(stringHandler().handle(response)).build()
                )
            else -> json.handle(response)
        }
}
