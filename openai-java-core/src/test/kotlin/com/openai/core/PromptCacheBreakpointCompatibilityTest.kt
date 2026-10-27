package com.openai.core

import com.fasterxml.jackson.core.JsonToken
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.PromptCacheBreakpointTtl
import java.lang.reflect.InvocationTargetException
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

internal class PromptCacheBreakpointCompatibilityTest {
    private val mapper = jsonMapper()

    // Breakpoints do not share a Java interface. Exercise their existing public Java APIs, so this
    // includes the raw-only models without adding a new production abstraction for the tests.
    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun rawUpdatesAndBulkReplacementRemainConsistent(type: Class<*>) {
        val original =
            mapper.readValue("""{"mode":"explicit","ttl":"30m","preserved":true}""", type)
        val builder = toBuilder(original)
        put(builder, "ttl", JsonValue.from("12h"))
        assertModel(
            build(builder),
            JsonValue.from("12h"),
            mapOf("preserved" to JsonValue.from(true)),
        )
        putAll(builder, mapOf("ttl" to JsonValue.from("30m"), "merged" to JsonValue.from(1)))
        assertModel(
            build(builder),
            JsonValue.from("30m"),
            mapOf("preserved" to JsonValue.from(true), "merged" to JsonValue.from(1)),
        )
        replace(builder, mapOf("ttl" to JsonValue.from("12h"), "replacement" to JsonValue.from(2)))
        assertModel(
            build(builder),
            JsonValue.from("12h"),
            mapOf("replacement" to JsonValue.from(2)),
        )
        // This was a raw property before TTL became declared. A full raw map replacement removes
        // it.
        val copied = toBuilder(build(builder))
        replace(copied, mapOf("extra" to JsonValue.from(1)))
        assertModel(build(copied), JsonMissing.of(), mapOf("extra" to JsonValue.from(1)))

        val received = toBuilder(original)
        replace(received, emptyMap())
        assertModel(build(received), JsonMissing.of(), emptyMap())
    }

    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun rawRemovalWorksThroughBothApis(type: Class<*>) {
        val original = mapper.readValue("""{"mode":"explicit","ttl":"30m","extra":true}""", type)
        val singular = toBuilder(original)
        remove(singular, "ttl")
        assertModel(build(singular), JsonMissing.of(), mapOf("extra" to JsonValue.from(true)))
        val bulk = toBuilder(original)
        removeAll(bulk, setOf("ttl", "extra"))
        assertModel(build(bulk), JsonMissing.of(), emptyMap())
    }

    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun lastTtlWriteWinsInBothOrdersAndAcrossBuilds(type: Class<*>) {
        val builder = newBuilder(type)
        put(builder, "extra", JsonValue.from(1))
        put(builder, "ttl", JsonValue.from("30m"))
        typed(builder, "12h")
        assertModel(build(builder), JsonValue.from("12h"), mapOf("extra" to JsonValue.from(1)))
        val copied = toBuilder(build(builder))
        put(copied, "ttl", JsonValue.from("30m"))
        assertModel(build(copied), JsonValue.from("30m"), mapOf("extra" to JsonValue.from(1)))
        typed(copied, "12h")
        val declared = toBuilder(build(copied))
        replace(declared, mapOf("replacement" to JsonValue.from(true)))
        removeAll(declared, setOf("ttl"))
        assertModel(
            build(declared),
            JsonValue.from("12h"),
            mapOf("replacement" to JsonValue.from(true)),
        )
    }

    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun declaredJsonFieldSurvivesReplacingAndRemovingExtrasWhileRawValueDoesNot(type: Class<*>) {
        // The value alone cannot distinguish a documented JsonValue overload from the legacy raw
        // property API. Replacing extras must honor the origin even after build() and toBuilder().
        for (value in
            listOf(
                JsonValue.from(null),
                JsonValue.from(42),
                JsonValue.from(mapOf("future" to 1)),
            )) {
            val explicitlyDeclared = newBuilder(type)
            field(explicitlyDeclared, value)
            put(explicitlyDeclared, "before", JsonValue.from(true))
            val declaredCopy = toBuilder(build(explicitlyDeclared))
            replace(declaredCopy, mapOf("extra" to JsonValue.from(1)))
            remove(declaredCopy, "ttl")
            removeAll(declaredCopy, setOf("ttl"))
            assertModel(build(declaredCopy), value, mapOf("extra" to JsonValue.from(1)))

            val legacy = newBuilder(type)
            put(legacy, "ttl", value)
            assertModel(build(legacy), value, emptyMap())
            val rawCopy = toBuilder(build(legacy))
            replace(rawCopy, mapOf("extra" to JsonValue.from(1)))
            assertModel(build(rawCopy), JsonMissing.of(), mapOf("extra" to JsonValue.from(1)))

            val toRemove = toBuilder(build(legacy))
            removeAll(toRemove, setOf("ttl"))
            assertModel(build(toRemove), JsonMissing.of(), emptyMap())
        }
    }

    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun rawUnknownStringsNullAndMissingPreserveWireMeaning(type: Class<*>) {
        val builder = newBuilder(type)
        putAll(builder, mapOf("ttl" to JsonValue.from("24h"), "extra" to JsonValue.from(false)))
        assertModel(build(builder), JsonValue.from("24h"), mapOf("extra" to JsonValue.from(false)))
        put(builder, "ttl", JsonValue.from(null))
        assertModel(build(builder), JsonValue.from(null), mapOf("extra" to JsonValue.from(false)))
        put(builder, "ttl", JsonMissing.of())
        assertModel(build(builder), JsonMissing.of(), mapOf("extra" to JsonValue.from(false)))
    }

    @ParameterizedTest
    @MethodSource("typedBreakpoints")
    fun explicitJsonStringRemainsDeclaredAndPreservesTheJsonFieldGetterContract(type: Class<*>) {
        val builder = newBuilder(type)
        field(builder, JsonValue.from("30m"))
        val copy = toBuilder(build(builder))
        replace(copy, mapOf("extra" to JsonValue.from(true)))
        removeAll(copy, setOf("ttl"))
        assertModel(
            build(copy),
            JsonValue.from("30m"),
            mapOf("extra" to JsonValue.from(true)),
            invalidDeclaredString = true,
        )
    }

    private fun newBuilder(type: Class<*>): Any = type.getMethod("builder").invoke(null)

    private fun toBuilder(value: Any): Any = value.javaClass.getMethod("toBuilder").invoke(value)

    private fun build(builder: Any): Any = builder.javaClass.getMethod("build").invoke(builder)

    private fun put(builder: Any, key: String, value: JsonValue) {
        builder.javaClass
            .getMethod("putAdditionalProperty", String::class.java, JsonValue::class.java)
            .invoke(builder, key, value)
    }

    private fun putAll(builder: Any, values: Map<String, JsonValue>) {
        builder.javaClass
            .getMethod("putAllAdditionalProperties", Map::class.java)
            .invoke(builder, values)
    }

    private fun replace(builder: Any, values: Map<String, JsonValue>) {
        builder.javaClass.getMethod("additionalProperties", Map::class.java).invoke(builder, values)
    }

    private fun remove(builder: Any, key: String) {
        builder.javaClass
            .getMethod("removeAdditionalProperty", String::class.java)
            .invoke(builder, key)
    }

    private fun removeAll(builder: Any, keys: Set<String>) {
        builder.javaClass
            .getMethod("removeAllAdditionalProperties", Set::class.java)
            .invoke(builder, keys)
    }

    private fun field(builder: Any, value: JsonField<*>) {
        builder.javaClass.getMethod("ttl", JsonField::class.java).invoke(builder, value)
    }

    private fun typed(builder: Any, value: String) {
        builder.javaClass
            .getMethod("ttl", PromptCacheBreakpointTtl::class.java)
            .invoke(builder, PromptCacheBreakpointTtl.of(value))
    }

    // Chat already shipped typed TTL. Raw extras override its serialized value while the typed
    // getter retains the declared value. Preserve that existing behavior in this Responses change.
    @ParameterizedTest
    @MethodSource("chatBreakpoints")
    fun chatRawUpdatesPreserveReleasedAccessorAndWireBehavior(type: Class<*>) {
        val original = mapper.readValue("""{"mode":"explicit","ttl":"30m"}""", type)
        val builder = toBuilder(original)
        put(builder, "ttl", JsonValue.from("12h"))
        assertChatTtl(build(builder), "12h")
        replace(builder, mapOf("ttl" to JsonValue.from("12h")))
        assertChatTtl(build(builder), "12h")
    }

    @ParameterizedTest
    @MethodSource("chatBreakpoints")
    fun chatDeclaredTtlSurvivesRawRemoval(type: Class<*>) {
        val original = mapper.readValue("""{"mode":"explicit","ttl":"30m"}""", type)
        val builder = toBuilder(original)
        remove(builder, "ttl")
        assertChatTtl(build(builder))
        removeAll(builder, setOf("ttl"))
        replace(builder, emptyMap())
        assertChatTtl(build(builder))
    }

    private fun assertChatTtl(value: Any, serializedTtl: String = "30m") {
        assertThat(value.javaClass.getMethod("ttl").invoke(value))
            .isEqualTo(Optional.of(PromptCacheBreakpointTtl.of("30m")))
        assertThat(mapper.readTree(mapper.writeValueAsString(value)).get("ttl").asText())
            .isEqualTo(serializedTtl)
    }

    private fun assertModel(
        value: Any,
        ttl: JsonValue,
        extras: Map<String, JsonValue>,
        invalidDeclaredString: Boolean = false,
    ) {
        val expected = extras.toMutableMap()
        expected["mode"] = JsonValue.from("explicit")
        if (!ttl.isMissing()) expected["ttl"] = ttl
        val properties = value.javaClass.getMethod("_allProperties").invoke(value)
        assertThat(properties).isEqualTo(expected)
        val legacy = value.javaClass.getMethod("_additionalProperties").invoke(value)
        assertThat(legacy).isEqualTo(expected.filterKeys { it != "mode" })
        val wire = mapper.writeValueAsString(value)
        assertThat(mapper.readTree(wire)).isEqualTo(mapper.valueToTree(expected))
        var ttlKeys = 0
        mapper.factory.createParser(wire).use { parser ->
            while (parser.nextToken() != null) {
                if (
                    parser.currentToken == JsonToken.FIELD_NAME &&
                        parser.currentName == "ttl" &&
                        parser.parsingContext.parent.inRoot()
                )
                    ttlKeys++
            }
        }
        assertThat(ttlKeys).isEqualTo(if (ttl.isMissing()) 0 else 1)
        if (value.javaClass in typedBreakpoints()) {
            val raw = value.javaClass.getMethod("_ttl").invoke(value) as JsonField<*>
            assertThat(JsonValue.from(raw)).isEqualTo(ttl)
            val getter = value.javaClass.getMethod("ttl")
            when {
                ttl.isNull() || ttl.isMissing() ->
                    assertThat(getter.invoke(value)).isEqualTo(Optional.empty<Any>())
                ttl.asString().isPresent && !invalidDeclaredString -> {
                    val result = getter.invoke(value) as Optional<*>
                    assertThat(result).isPresent
                    val known = result.get()
                    assertThat(JsonValue.from(known)).isEqualTo(ttl)
                }
                else ->
                    assertThatThrownBy { getter.invoke(value) }
                        .isInstanceOf(InvocationTargetException::class.java)
                        .hasCauseInstanceOf(OpenAIInvalidDataException::class.java)
            }
        }
    }

    companion object {
        @JvmStatic
        fun typedBreakpoints(): List<Class<*>> =
            names(
                "responses.ResponseInputFileContent",
                "responses.ResponseInputImageContent",
                "responses.ResponseInputTextContent",
                "beta.responses.BetaResponseInputFileContent",
                "beta.responses.BetaResponseInputImageContent",
                "beta.responses.BetaResponseInputTextContent",
                "responses.ResponseInputFile",
                "responses.ResponseInputImage",
                "responses.ResponseInputText",
                "beta.responses.BetaResponseInputFile",
                "beta.responses.BetaResponseInputImage",
                "beta.responses.BetaResponseInputText",
                "beta.responses.BetaResponseItem\$AgentMessage\$Content\$ComputerScreenshot",
                "beta.responses.BetaResponseOutputItem\$AgentMessage\$Content\$ComputerScreenshot",
                "conversations.ComputerScreenshotContent",
            )

        @JvmStatic
        fun chatBreakpoints(): List<Class<*>> =
            names(
                "chat.completions.ChatCompletionContentPart\$File",
                "chat.completions.ChatCompletionContentPartImage",
                "chat.completions.ChatCompletionContentPartInputAudio",
                "chat.completions.ChatCompletionContentPartText",
            )

        private fun names(vararg models: String): List<Class<*>> =
            models.map { Class.forName("com.openai.models.$it\$PromptCacheBreakpoint") }
    }
}
