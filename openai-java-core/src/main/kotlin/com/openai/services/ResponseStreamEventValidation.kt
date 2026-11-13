package com.openai.services

import com.openai.models.responses.ResponseStreamEvent
import com.openai.responses.internal.validateForStream as validateResponsesStreamEvent

@JvmSynthetic
internal fun ResponseStreamEvent.validateForStream(): ResponseStreamEvent =
    validateResponsesStreamEvent()
