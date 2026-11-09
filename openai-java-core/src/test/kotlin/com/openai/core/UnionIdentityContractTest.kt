package com.openai.core

import com.openai.models.ComparisonFilter
import com.openai.models.beta.realtime.ConversationItemInputAudioTranscriptionCompletedEvent.Usage
import com.openai.models.beta.realtime.InputAudioBufferClearEvent
import com.openai.models.beta.realtime.InputAudioBufferClearedEvent
import com.openai.models.beta.realtime.RealtimeClientEvent
import com.openai.models.beta.realtime.RealtimeResponse
import com.openai.models.beta.realtime.RealtimeServerEvent
import com.openai.models.beta.realtime.ResponseCreateEvent
import com.openai.models.beta.realtime.SessionUpdateEvent
import com.openai.models.beta.realtime.sessions.Session
import com.openai.models.beta.realtime.sessions.SessionCreateParams
import com.openai.models.beta.realtime.sessions.SessionCreateResponse
import com.openai.models.embeddings.EmbeddingValue
import com.openai.models.vectorstores.FileChunkingStrategy
import com.openai.models.vectorstores.OtherFileChunkingStrategyObject
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class UnionIdentityContractTest {
    private val mapper = jsonMapper()

    @Test
    fun unknownTopLevelValuesRemainDistinct() {
        val values =
            assertUnknownIdentity(
                FileChunkingStrategy::class.java,
                listOf(
                    """{"type":"future-a","key":"alpha"}""",
                    """{"type":"future-a","key":"beta"}""",
                    """{"type":"future-b","key":"alpha"}""",
                ),
            )
        for (value in values) {
            assertThat(value.isStatic()).isFalse()
            assertThat(value.isOther()).isFalse()
        }
        assertKnownRoundTrip(
            FileChunkingStrategy.ofOther(OtherFileChunkingStrategyObject.builder().build())
        )
    }

    @Test
    fun unknownNestedValuesRemainDistinct() {
        val values =
            assertUnknownIdentity(
                ComparisonFilter.Value::class.java,
                listOf(
                    """{"provider":"future-a","key":"alpha"}""",
                    """{"provider":"future-a","key":"beta"}""",
                    """{"provider":"future-b","key":"alpha"}""",
                ),
            )
        for (value in values) {
            assertThat(value.isString()).isFalse()
            assertThat(value.isNumber()).isFalse()
            assertThat(value.isBool()).isFalse()
            assertThat(value.isComparisonFilterValueItems()).isFalse()
        }
        assertKnownRoundTrip(ComparisonFilter.Value.ofString("known-value"))
    }

    @Test
    fun unknownNestedChildValuesRemainDistinct() {
        val values =
            assertUnknownIdentity(
                ComparisonFilter.Value.ComparisonFilterValueItem::class.java,
                listOf("true", "false"),
            )
        for (value in values) {
            assertThat(value.isString()).isFalse()
            assertThat(value.isNumber()).isFalse()
        }
        assertKnownRoundTrip(
            ComparisonFilter.Value.ComparisonFilterValueItem.ofString("known-value")
        )
    }

    @ParameterizedTest
    @MethodSource("handwrittenKnownValues")
    fun handwrittenUnionsPreserveIdentity(known: Any) {
        val values = assertUnknownIdentity(known.javaClass, listOf("true", "false"))
        for (value in values) {
            assertThat(value.toString()).startsWith("${known.javaClass.simpleName}{_unknown=")
        }
        assertKnownRoundTrip(known)
    }

    companion object {
        @JvmStatic
        fun handwrittenKnownValues(): Stream<Any> =
            Stream.of(
                EmbeddingValue.ofFloats(listOf(1.5f, 2.5f)),
                EmbeddingValue.ofBase64("AAAgQA=="),
                Usage.ofTranscriptTextUsageDuration(
                    Usage.TranscriptTextUsageDuration.builder().seconds(0.0).build()
                ),
                RealtimeClientEvent.ofInputAudioBufferClear(
                    InputAudioBufferClearEvent.builder().build()
                ),
                RealtimeServerEvent.ofInputAudioBufferCleared(
                    InputAudioBufferClearedEvent.builder().eventId("event_test").build()
                ),
                RealtimeResponse.MaxOutputTokens.ofInteger(0L),
                ResponseCreateEvent.Response.MaxResponseOutputTokens.ofInteger(0L),
                SessionUpdateEvent.Session.MaxResponseOutputTokens.ofInteger(0L),
                SessionUpdateEvent.Session.Tracing.ofAuto(),
                Session.MaxResponseOutputTokens.ofInteger(0L),
                Session.Tracing.ofAuto(),
                SessionCreateParams.MaxResponseOutputTokens.ofInteger(0L),
                SessionCreateParams.Tracing.ofAuto(),
                SessionCreateResponse.MaxResponseOutputTokens.ofInteger(0L),
                SessionCreateResponse.Tracing.ofAuto(),
            )
    }

    private fun <T : Any> assertUnknownIdentity(type: Class<T>, jsonValues: List<String>): List<T> {
        val values = jsonValues.map { mapper.readValue(it, type) }
        assertThat(values.toSet()).hasSize(jsonValues.size)

        val copy = mapper.readValue(jsonValues.first(), type)
        assertThat(copy).isEqualTo(values.first())
        assertThat(copy.hashCode()).isEqualTo(values.first().hashCode())

        val indexed = values.mapIndexed { index, value -> value to index }.toMap()
        assertThat(indexed).hasSize(jsonValues.size)
        assertThat(indexed[copy]).isEqualTo(0)

        for ((value, json) in values.zip(jsonValues)) {
            assertThat(mapper.readTree(mapper.writeValueAsBytes(value)))
                .isEqualTo(mapper.readTree(json))
        }
        return values
    }

    private fun <T : Any> assertKnownRoundTrip(value: T) {
        val copy = mapper.readValue(mapper.writeValueAsBytes(value), value.javaClass)
        assertThat(value).isEqualTo(copy)
        assertThat(copy).isEqualTo(value)
        assertThat(value.hashCode()).isEqualTo(copy.hashCode())
    }
}
