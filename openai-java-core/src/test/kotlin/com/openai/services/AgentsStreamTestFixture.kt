package com.openai.services

import com.github.tomakehurst.wiremock.client.WireMock.ok

// Steady's union sample can choose a genuine SSE error. Success tests need an explicit
// success fixture; the SDK must continue to propagate real errors.
internal fun agentsStreamFixture() =
    ok()
        .withHeader("Content-Type", "text/event-stream")
        .withBody(
            """
            event: agent.session.turn.output_text.delta
            data: {"type":"agent.session.turn.output_text.delta","event_id":"evt_test","session_id":"session_id","turn_id":"turn_test","item_id":"item_test","content_index":0,"output_index":0,"delta":"hello"}
            """
                .trimIndent() + "\n\n"
        )
