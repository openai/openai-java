package com.openai.core.handlers

import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.models.audio.transcriptions.Transcription
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse

@JvmSynthetic internal fun audioTextHandler(): Handler<TranscriptionCreateResponse> = AudioTextHandler

private object AudioTextHandler : Handler<TranscriptionCreateResponse> {
    override fun handle(response: HttpResponse): TranscriptionCreateResponse {
        val c = response.body().readBytes().toString(Charsets.UTF_8)
        return TranscriptionCreateResponse.ofTranscription(Transcription.builder().text(c).build())
    }
}