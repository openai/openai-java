package com.openai.helpers

import com.openai.core.jsonMapper
import com.openai.models.chat.completions.ChatCompletionChunk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ChatCompletionAccumulatorLegacyFunctionCallTest {
    @Test
    fun accumulatesArgumentFragmentsWithoutLosingTheName() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(0, call("legacy_probe", """{"a":"""))))
        accumulator.accumulate(chunk(choice(0, call(arguments = "1}"))))
        accumulator.accumulate(chunk(choice(0, finish = true)))

        val function = accumulator.chatCompletion().choices()[0].message().functionCall().get()
        assertThat(function.name()).isEqualTo("legacy_probe")
        assertThat(function.arguments()).isEqualTo("""{"a":1}""")
    }

    @Test
    fun accumulatesNameFragmentsInOrder() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(0, call("legacy_", "{"))))
        accumulator.accumulate(chunk(choice(0, call("probe", "}"))))
        accumulator.accumulate(chunk(choice(0, finish = true)))

        val function = accumulator.chatCompletion().choices()[0].message().functionCall().get()
        assertThat(function.name()).isEqualTo("legacy_probe")
        assertThat(function.arguments()).isEqualTo("{}")
    }

    @Test
    fun emptyFragmentsPreserveEarlierFields() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(0, call("legacy_probe", "{}"))))
        accumulator.accumulate(chunk(choice(0, call("", ""))))
        accumulator.accumulate(chunk(choice(0, finish = true)))

        val function = accumulator.chatCompletion().choices()[0].message().functionCall().get()
        assertThat(function.name()).isEqualTo("legacy_probe")
        assertThat(function.arguments()).isEqualTo("{}")
    }

    @Test
    fun finalArgumentFragmentAndFinishReasonCanShareAChunk() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(0, call("legacy_probe", "["))))
        accumulator.accumulate(chunk(choice(0, call(arguments = "1]"), finish = true)))

        val completion = accumulator.chatCompletion()
        assertThat(completion.choices()[0].finishReason().asString()).isEqualTo("function_call")
        assertThat(completion.choices()[0].message().functionCall().get().name())
            .isEqualTo("legacy_probe")
        assertThat(completion.choices()[0].message().functionCall().get().arguments())
            .isEqualTo("[1]")
    }

    @Test
    fun interleavedChoicesKeepTheirOwnFunctionCalls() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(1, call("second", "[")), choice(0, call("first", "{"))))
        accumulator.accumulate(chunk(choice(0, call(arguments = "}"), finish = true)))
        accumulator.accumulate(chunk(choice(1, call(arguments = "]"), finish = true)))

        val choices = accumulator.chatCompletion().choices()
        assertThat(choices.map { it.index() }).containsExactly(0L, 1L)
        assertThat(choices[0].message().functionCall().get().name()).isEqualTo("first")
        assertThat(choices[0].message().functionCall().get().arguments()).isEqualTo("{}")
        assertThat(choices[1].message().functionCall().get().name()).isEqualTo("second")
        assertThat(choices[1].message().functionCall().get().arguments()).isEqualTo("[]")
    }

    @Test
    fun retainsMergedExtensionsAndFunctionCallAfterFinalUsage() {
        val accumulator = ChatCompletionAccumulator.create()
        accumulator.accumulate(chunk(choice(0, call("legacy_probe", "{", mapOf("first" to 1)))))
        accumulator.accumulate(
            chunk(choice(0, call(arguments = "}", extensions = mapOf("last" to 2)), finish = true))
        )
        val beforeUsage = accumulator.chatCompletion()
        accumulator.accumulate(
            jsonMapper()
                .readValue(
                    """{"id":"legacy-test","object":"chat.completion.chunk","created":1,"model":"synthetic-model","choices":[],"usage":{"prompt_tokens":1,"completion_tokens":2,"total_tokens":3}}""",
                    ChatCompletionChunk::class.java,
                )
        )

        val completion = accumulator.chatCompletion()
        assertThat(completion).isNotSameAs(beforeUsage)
        assertThat(completion.usage().get().totalTokens()).isEqualTo(3L)
        val function = completion.choices()[0].message().functionCall().get()
        assertThat(function.name()).isEqualTo("legacy_probe")
        assertThat(function.arguments()).isEqualTo("{}")
        assertThat(function._additionalProperties().keys).containsExactlyInAnyOrder("first", "last")
        assertThat(beforeUsage.choices()[0].message().functionCall().get()).isEqualTo(function)
    }

    private fun call(
        name: String? = null,
        arguments: String? = null,
        extensions: Map<String, Any> = emptyMap(),
    ): Map<String, Any> =
        extensions.toMutableMap().apply {
            name?.let { put("name", it) }
            arguments?.let { put("arguments", it) }
        }

    private fun choice(
        index: Int,
        functionCall: Map<String, Any>? = null,
        finish: Boolean = false,
    ): Map<String, Any?> =
        mapOf(
            "index" to index,
            "delta" to (functionCall?.let { mapOf("function_call" to it) } ?: emptyMap()),
            "finish_reason" to if (finish) "function_call" else null,
        )

    private fun chunk(vararg choices: Map<String, Any?>): ChatCompletionChunk =
        jsonMapper()
            .readValue(
                jsonMapper()
                    .writeValueAsString(
                        mapOf(
                            "id" to "legacy-test",
                            "object" to "chat.completion.chunk",
                            "created" to 1,
                            "model" to "synthetic-model",
                            "choices" to choices.toList(),
                        )
                    ),
                ChatCompletionChunk::class.java,
            )
}
