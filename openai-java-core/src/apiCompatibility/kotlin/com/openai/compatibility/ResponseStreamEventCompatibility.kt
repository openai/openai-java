package com.openai.compatibility

import com.openai.models.responses.ResponseStreamEvent

internal object ResponseStreamEventCompatibility {
    fun outputTextDelta(event: ResponseStreamEvent): String? =
        if (event.isOutputTextDelta()) event.asOutputTextDelta().delta() else null
}
