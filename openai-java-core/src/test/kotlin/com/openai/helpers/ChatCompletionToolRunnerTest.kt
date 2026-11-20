package com.openai.helpers

import com.openai.client.OpenAIClient
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.models.chat.completions.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.Answers.RETURNS_DEEP_STUBS
import org.mockito.kotlin.*

class ChatCompletionToolRunnerTest {
    class Lookup {
        @JvmField var key: String = ""
    }

    private val client = mock<OpenAIClient>(defaultAnswer = RETURNS_DEEP_STUBS)
    private val service = client.chat().completions()
    private val params =
        ChatCompletionCreateParams.builder()
            .model("test-model")
            .addUserMessage("Look up a key")
            .build()

    private fun call(
        id: String = "call-1",
        name: String = "Lookup",
        arguments: String = """{"key":"a"}""",
    ) =
        ChatCompletionMessageToolCall.ofFunction(
            ChatCompletionMessageFunctionToolCall.builder()
                .id(id)
                .function(
                    ChatCompletionMessageFunctionToolCall.Function.builder()
                        .name(name)
                        .arguments(arguments)
                        .build()
                )
                .build()
        )

    private fun completion(
        vararg calls: ChatCompletionMessageToolCall,
        finish: String = if (calls.isEmpty()) "stop" else "tool_calls",
    ) =
        ChatCompletion.builder()
            .id("completion-test")
            .created(1)
            .model("test-model")
            .addChoice(
                ChatCompletion.Choice.builder()
                    .index(0)
                    .finishReason(ChatCompletion.Choice.FinishReason.of(finish))
                    .message(
                        ChatCompletionMessage.builder()
                            .content(if (calls.isEmpty()) "Done" else null as String?)
                            .refusal(null as String?)
                            .toolCalls(calls.toList())
                            .build()
                    )
                    .build()
            )
            .build()

    private fun runner(
        maxTurns: Int = 8,
        callback: (Lookup) -> Any? = { mapOf("value" to it.key) },
    ) =
        ChatCompletionToolRunner.builder()
            .client(client)
            .maxTurns(maxTurns)
            .addTool(Lookup::class.java, callback)
            .build()

    private fun failure(block: () -> Unit): ChatCompletionToolRunner.RunException {
        try {
            block()
        } catch (e: ChatCompletionToolRunner.RunException) {
            return e
        }
        throw AssertionError("Expected RunException")
    }

    @Test
    fun runsMultipleTurnsAndKeepsSettingsAndMatchingIds() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(
                completion(call("one"), call("two", arguments = """{"key":"b"}""")),
                completion(call("three")),
                completion(),
            )
        val options = RequestOptions.builder().timeout(java.time.Duration.ofSeconds(5)).build()
        val invoked = mutableListOf<String>()
        val helper =
            ChatCompletionToolRunner.builder()
                .client(client)
                .requestOptions(options)
                .addTool(Lookup::class.java) {
                    invoked.add(it.key)
                    mapOf("value" to it.key)
                }
                .build()
        val result =
            helper.run(
                params
                    .toBuilder()
                    .temperature(0.2)
                    .putAdditionalHeader("X-Param", "retained")
                    .build()
            )
        assertThat(invoked).containsExactly("a", "b", "a")
        assertThat(result.completion().choices().single().message().content()).contains("Done")
        assertThat(result.messages()).hasSize(7)
        val captor = argumentCaptor<ChatCompletionCreateParams>()
        verify(service, times(3)).create(captor.capture(), eq(options))
        assertThat(captor.allValues.map { it.messages().size }).containsExactly(1, 4, 6)
        captor.allValues.forEach {
            assertThat(it.temperature()).contains(0.2)
            assertThat(it.tools().get().single().asFunction().function().name()).isEqualTo("Lookup")
        }
        val outputs = result.messages().filter { it.tool().isPresent }.map { it.asTool() }
        assertThat(outputs.map { it.toolCallId() }).containsExactly("one", "two", "three")
        assertThat(outputs.map { it.content().asText() })
            .containsExactly("""{"value":"a"}""", """{"value":"b"}""", """{"value":"a"}""")
        assertThatThrownBy { (result.messages() as MutableList).clear() }
            .isInstanceOf(UnsupportedOperationException::class.java)
    }

    @Test
    fun returnsFirstFinalAnswerWithoutInvokingTools() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any())).thenReturn(completion())
        val result = runner { error("Should not run") }.run(params)
        assertThat(result.messages()).hasSize(2)
        verify(service).create(any<ChatCompletionCreateParams>(), any())
    }

    @ParameterizedTest
    @ValueSource(strings = ["length", "content_filter", "future_reason", "tool_calls"])
    fun incompleteAnswerIsFailure(reason: String) {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(finish = reason))
        assertThat(failure { runner().run(params) }.lastCompletion()).isPresent
    }

    @Test
    fun preflightsAllToolNamesBeforeAnyCallbacks() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), call("two", name = "Missing")))
        var calls = 0
        val failure = failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
        assertThat(failure.toolCallId()).contains("two")
        assertThat(failure.messages()).hasSize(2)
    }

    @Test
    fun preflightsAllArgumentsBeforeAnyCallbacks() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), call("two", arguments = "{invalid")))
        var calls = 0
        failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
    }

    @ParameterizedTest
    @ValueSource(strings = ["call-1", ""])
    fun rejectsDuplicateOrEmptyIdsBeforeCallbacks(id: String) {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), call(id)))
        var calls = 0
        failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
    }

    @Test
    fun rejectsRepeatedIdsAcrossTurns() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call()), completion(call()))
        var calls = 0
        failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isEqualTo(1)
    }

    @Test
    fun turnLimitDoesNotExecuteUnreportableToolCalls() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call("one")), completion(call("two")))
        var calls = 0
        val failure = failure {
            runner(2) {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isEqualTo(1)
        assertThat(failure.messages()).hasSize(4)
        verify(service, times(2)).create(any<ChatCompletionCreateParams>(), any())
    }

    @Test
    fun callbackFailurePreservesEarlierResultsAndCause() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call("one"), call("two")))
        val cause = IllegalStateException("synthetic failure")
        var calls = 0
        val failure = failure {
            runner {
                    if (++calls == 2) throw cause
                    "result"
                }
                .run(params)
        }
        assertThat(failure.cause).isSameAs(cause)
        assertThat(failure.toolCallId()).contains("two")
        assertThat(failure.messages().last().asTool().content().asText()).isEqualTo("\"result\"")
        verify(service).create(any<ChatCompletionCreateParams>(), any())
    }

    @Test
    fun transportFailurePreservesToolResults() {
        val cause = IllegalStateException("synthetic transport failure")
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call()))
            .thenThrow(cause)
        val failure = failure { runner { null }.run(params) }
        assertThat(failure.cause).isSameAs(cause)
        assertThat(failure.messages().last().asTool().content().asText()).isEqualTo("null")
        assertThat(failure.toolCallId()).isEmpty
    }

    @Test
    fun interruptionStopsBeforeAnotherCallbackAndPreservesFlag() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call("one"), call("two")))
        var calls = 0
        try {
            val failure = failure {
                runner {
                        calls++
                        Thread.currentThread().interrupt()
                        null
                    }
                    .run(params)
            }
            assertThat(calls).isEqualTo(1)
            assertThat(failure.messages()).hasSize(3)
            assertThat(Thread.currentThread().isInterrupted).isTrue()
        } finally {
            Thread.interrupted()
        }
    }

    @Test
    fun alreadyInterruptedDoesNotSendRequest() {
        try {
            Thread.currentThread().interrupt()
            failure { runner().run(params) }
            verify(service, never()).create(any<ChatCompletionCreateParams>(), any())
        } finally {
            Thread.interrupted()
        }
    }

    @Test
    fun rejectsConflictingParamsBeforeSending() {
        val helper = runner()
        assertThatThrownBy { helper.run(params.toBuilder().n(2).build()) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { helper.run(params.toBuilder().addTool(Lookup::class.java).build()) }
            .isInstanceOf(IllegalArgumentException::class.java)
        for (key in listOf("messages", "tools", "n", "functions", "function_call", "stream")) {
            assertThatThrownBy {
                    helper.run(
                        params
                            .toBuilder()
                            .putAdditionalBodyProperty(key, JsonValue.from(true))
                            .build()
                    )
                }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
        verify(service, never()).create(any<ChatCompletionCreateParams>(), any())
    }

    @Test
    fun validatesBuilder() {
        assertThatThrownBy { ChatCompletionToolRunner.builder().maxTurns(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { ChatCompletionToolRunner.builder().client(client).build() }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy {
                ChatCompletionToolRunner.builder()
                    .addTool(Lookup::class.java) { null }
                    .addTool(Lookup::class.java) { null }
            }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun rejectsNullArgumentsBeforeAnyCallbacks() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), call("two", arguments = "null")))
        var calls = 0
        failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
    }

    @Test
    fun rejectsUnsupportedCallsBeforeAnyCallbacks() {
        val custom =
            ChatCompletionMessageToolCall.ofCustom(
                ChatCompletionMessageCustomToolCall.builder()
                    .id("custom")
                    .custom(
                        ChatCompletionMessageCustomToolCall.Custom.builder()
                            .name("Lookup")
                            .input("a")
                            .build()
                    )
                    .build()
            )
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), custom))
        var calls = 0
        val failure = failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
        assertThat(failure.toolCallId()).isEmpty
    }

    @Test
    fun rejectsIncompleteToolCallWithoutExecutingIt() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), finish = "length"))
        var calls = 0
        failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
    }

    @Test
    fun rejectsMultipleChoicesAndPreservesResponse() {
        val response = completion().toBuilder().addChoice(completion().choices().single()).build()
        whenever(service.create(any<ChatCompletionCreateParams>(), any())).thenReturn(response)
        assertThat(failure { runner().run(params) }.lastCompletion()).contains(response)
    }

    class Unserializable {
        fun getValue(): String = error("synthetic serialization failure")
    }

    @Test
    fun serializationFailurePreservesPreviousResults() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call("one"), call("two")))
        var calls = 0
        val failure = failure {
            runner { if (++calls == 1) "ok" else Unserializable() }.run(params)
        }
        assertThat(calls).isEqualTo(2)
        assertThat(failure.toolCallId()).contains("two")
        assertThat(failure.messages().last().asTool().toolCallId()).isEqualTo("one")
        verify(service).create(any<ChatCompletionCreateParams>(), any())
    }

    class SecondTool {
        @JvmField var value: String = ""
    }

    @Test
    fun builderChangesDoNotChangeExistingRunner() {
        val builder =
            ChatCompletionToolRunner.builder().client(client).maxTurns(1).addTool(
                Lookup::class.java
            ) {
                null
            }
        val helper = builder.build()
        builder.maxTurns(3).addTool(SecondTool::class.java) { null }
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call()))
        failure { helper.run(params) }
        val captor = argumentCaptor<ChatCompletionCreateParams>()
        verify(service).create(captor.capture(), any())
        assertThat(captor.firstValue.tools().get()).hasSize(1)
    }

    @ParameterizedTest
    @ValueSource(strings = ["{}", "null", "true", "[]", "42", "\"extra\"", "garbage", "{"])
    fun rejectsTrailingJsonBeforeAnyCallbacks(trailing: String) {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(), call("two", arguments = """{"key":"a"}""" + trailing)))
        var calls = 0
        val failure = failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
        assertThat(failure.toolCallId()).contains("two")
        assertThat(failure.messages()).hasSize(2)
        verify(service).create(any<ChatCompletionCreateParams>(), any())
    }

    @Test
    fun acceptsTrailingWhitespace() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call(arguments = "{\"key\":\"a\"} \n\t\r")), completion())
        var calls = 0
        runner {
                calls++
                it.key
            }
            .run(params)
        assertThat(calls).isEqualTo(1)
    }

    @Test
    fun defaultCallbackBudgetRejectsLargeTurnBeforeAnyCallbacks() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(*(1..33).map { call("call-$it") }.toTypedArray()))
        var calls = 0
        val failure = failure {
            runner {
                    calls++
                    null
                }
                .run(params)
        }
        assertThat(calls).isZero()
        assertThat(failure.messages()).hasSize(2)
        assertThat(failure.toolCallId()).isEmpty
    }

    @Test
    fun callbackBudgetIsCumulativeAndRejectsWholeOverBudgetTurn() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(
                completion(call("one"), call("two")),
                completion(call("three"), call("four")),
            )
        var calls = 0
        val helper =
            ChatCompletionToolRunner.builder()
                .client(client)
                .maxToolCalls(3)
                .addTool(Lookup::class.java) {
                    calls++
                    "ok"
                }
                .build()
        val failure = failure { helper.run(params) }
        assertThat(calls).isEqualTo(2)
        assertThat(
                failure.messages().filter { it.tool().isPresent }.map { it.asTool().toolCallId() }
            )
            .containsExactly("one", "two")
        assertThat(failure.toolCallId()).isEmpty
        verify(service, times(2)).create(any<ChatCompletionCreateParams>(), any())
    }

    @Test
    fun exactCallbackBudgetAllowsFinalAnswerAndResetsForNextRun() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(
                completion(call("one")),
                completion(call("two")),
                completion(),
                completion(call("one")),
                completion(),
            )
        var calls = 0
        val helper =
            ChatCompletionToolRunner.builder()
                .client(client)
                .maxToolCalls(2)
                .addTool(Lookup::class.java) {
                    calls++
                    null
                }
                .build()
        assertThat(helper.run(params).messages()).hasSize(6)
        assertThat(helper.run(params).messages()).hasSize(4)
        assertThat(calls).isEqualTo(3)
    }

    @Test
    fun zeroCallbackBudgetAllowsFinalAnswerButRejectsTools() {
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(), completion(call()))
        var calls = 0
        val helper =
            ChatCompletionToolRunner.builder()
                .client(client)
                .maxToolCalls(0)
                .addTool(Lookup::class.java) {
                    calls++
                    null
                }
                .build()
        assertThat(helper.run(params).messages()).hasSize(2)
        failure { helper.run(params) }
        assertThat(calls).isZero()
    }

    @Test
    fun validatesAndSnapshotsCallbackBudget() {
        assertThatThrownBy { ChatCompletionToolRunner.builder().maxToolCalls(-1) }
            .isInstanceOf(IllegalArgumentException::class.java)
        whenever(service.create(any<ChatCompletionCreateParams>(), any()))
            .thenReturn(completion(call()))
        var calls = 0
        val builder =
            ChatCompletionToolRunner.builder().client(client).maxToolCalls(0).addTool(
                Lookup::class.java
            ) {
                calls++
                null
            }
        val helper = builder.build()
        builder.maxToolCalls(Int.MAX_VALUE)
        failure { helper.run(params) }
        assertThat(calls).isZero()
    }
}
