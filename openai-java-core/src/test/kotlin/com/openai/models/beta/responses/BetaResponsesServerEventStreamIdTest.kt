package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class BetaResponsesServerEventStreamIdTest {
    @Test
    fun websocketStreamId() {
        val betaResponsesServerEvent =
            jsonMapper()
                .readValue(
                    """{"type":"response.audio.delta","delta":"delta","sequence_number":0,"stream_id":"stream_id"}""",
                    jacksonTypeRef<BetaResponsesServerEvent>(),
                )

        assertThat(betaResponsesServerEvent.streamId()).contains("stream_id")
        assertThat(betaResponsesServerEvent.responseAudioDelta()).isPresent
        assertThat(betaResponsesServerEvent.asResponseAudioDelta().delta()).isEqualTo("delta")
        assertThat(jsonMapper().writeValueAsString(betaResponsesServerEvent)).contains("stream_id")
        assertThat(betaResponsesServerEvent.validate()).isSameAs(betaResponsesServerEvent)
        assertThat(betaResponsesServerEvent.isValid()).isTrue()
    }

    @Test
    fun websocketStreamIdRejectsMalformedValue() {
        val betaResponsesServerEvent =
            jsonMapper()
                .readValue(
                    """{"type":"response.audio.delta","delta":"delta","sequence_number":0,"stream_id":42}""",
                    jacksonTypeRef<BetaResponsesServerEvent>(),
                )

        assertThrows<OpenAIInvalidDataException> { betaResponsesServerEvent.streamId() }
        assertThrows<OpenAIInvalidDataException> { betaResponsesServerEvent.validate() }
        assertThat(betaResponsesServerEvent.isValid()).isFalse()
    }

    @Test
    fun shellCallCommandAddedPreservesStreamId() {
        val mapper = jsonMapper()
        val json =
            """{"type":"response.shell_call_command.added","sequence_number":1,"output_index":0,"command_index":0,"stream_id":"lane","command":"ls"}"""
        val event = mapper.readValue(json, BetaResponsesServerEvent::class.java)
        event.validate()
        assertThat(event.isResponseShellCallCommandAdded()).isTrue()
        assertThat(event.streamId()).contains("lane")
        val roundtrip =
            mapper.readValue(mapper.writeValueAsString(event), BetaResponsesServerEvent::class.java)
        assertThat(roundtrip).isEqualTo(event)
    }

    @Test
    fun shellCallCommandDeltaPreservesStreamId() {
        val mapper = jsonMapper()
        val json =
            """{"type":"response.shell_call_command.delta","sequence_number":1,"output_index":0,"command_index":0,"stream_id":"lane","delta":"ls"}"""
        val event = mapper.readValue(json, BetaResponsesServerEvent::class.java)
        event.validate()
        assertThat(event.isResponseShellCallCommandDelta()).isTrue()
        assertThat(event.streamId()).contains("lane")
        val roundtrip =
            mapper.readValue(mapper.writeValueAsString(event), BetaResponsesServerEvent::class.java)
        assertThat(roundtrip).isEqualTo(event)
    }

    @Test
    fun shellCallCommandDonePreservesStreamId() {
        val mapper = jsonMapper()
        val json =
            """{"type":"response.shell_call_command.done","sequence_number":1,"output_index":0,"command_index":0,"stream_id":"lane","command":"ls"}"""
        val event = mapper.readValue(json, BetaResponsesServerEvent::class.java)
        event.validate()
        assertThat(event.isResponseShellCallCommandDone()).isTrue()
        assertThat(event.streamId()).contains("lane")
        val roundtrip =
            mapper.readValue(mapper.writeValueAsString(event), BetaResponsesServerEvent::class.java)
        assertThat(roundtrip).isEqualTo(event)
    }

    @Test
    fun shellCallOutputContentDeltaPreservesStreamId() {
        val mapper = jsonMapper()
        val json =
            """{"type":"response.shell_call_output_content.delta","sequence_number":1,"output_index":0,"command_index":0,"stream_id":"lane","item_id":"item","delta":{"stdout":"ok"}}"""
        val event = mapper.readValue(json, BetaResponsesServerEvent::class.java)
        event.validate()
        assertThat(event.isResponseShellCallOutputContentDelta()).isTrue()
        assertThat(event.streamId()).contains("lane")
        val roundtrip =
            mapper.readValue(mapper.writeValueAsString(event), BetaResponsesServerEvent::class.java)
        assertThat(roundtrip).isEqualTo(event)
    }

    @Test
    fun shellCallOutputContentDonePreservesStreamId() {
        val mapper = jsonMapper()
        val json =
            """{"type":"response.shell_call_output_content.done","sequence_number":1,"output_index":0,"command_index":0,"stream_id":"lane","item_id":"item","output":[]}"""
        val event = mapper.readValue(json, BetaResponsesServerEvent::class.java)
        event.validate()
        assertThat(event.isResponseShellCallOutputContentDone()).isTrue()
        assertThat(event.streamId()).contains("lane")
        val roundtrip =
            mapper.readValue(mapper.writeValueAsString(event), BetaResponsesServerEvent::class.java)
        assertThat(roundtrip).isEqualTo(event)
    }
}
