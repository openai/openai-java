package com.openai.responses.helpers

import com.openai.core.jsonMapper
import com.openai.models.responses.ResponseStreamEvent
import com.openai.models.responses.ResponsesServerEvent
import kotlin.test.assertEquals
import kotlin.test.assertSame
import org.junit.jupiter.api.Test

internal class ResponseAccumulatorTest {
    @Test
    fun snapshotAndTerminalResponseUseTheSameAccumulator() {
        val accumulator = ResponseAccumulator.createWithSnapshots()
        val mapper = jsonMapper()
        val created =
            mapper.readValue(
                """{"type":"response.created","sequence_number":0,"response":{"id":"resp_start"}}""",
                ResponseStreamEvent::class.java,
            )
        val completed =
            mapper.readValue(
                """{"type":"response.completed","sequence_number":1,"response":{"id":"resp_final","output":[]}}""",
                ResponsesServerEvent::class.java,
            )

        assertSame(created, accumulator.accumulate(created))
        assertEquals("resp_start", accumulator.snapshot().get().idOrThrow())
        assertSame(completed, accumulator.accumulate(completed))
        assertEquals("resp_final", accumulator.response().idOrThrow())
        assertSame(accumulator.response(), accumulator.reconstructedResponse())
    }
}
