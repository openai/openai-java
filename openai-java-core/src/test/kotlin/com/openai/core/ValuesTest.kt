package com.openai.core

import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class ValuesTest {
    companion object {
        private val NON_JSON = Any()
    }

    enum class TestCase(
        val value: JsonField<*>,
        val expectedIsMissing: Boolean = false,
        val expectedIsNull: Boolean = false,
        val expectedAsKnown: Optional<*> = Optional.empty<Nothing>(),
        val expectedAsBoolean: Optional<Boolean> = Optional.empty(),
        val expectedAsNumber: Optional<Number> = Optional.empty(),
        val expectedAsString: Optional<String> = Optional.empty(),
        val expectedAsArray: Optional<List<JsonValue>> = Optional.empty(),
        val expectedAsObject: Optional<Map<String, JsonValue>> = Optional.empty(),
    ) {
        MISSING(JsonMissing.of(), expectedIsMissing = true),
        NULL(JsonNull.of(), expectedIsNull = true),
        KNOWN(KnownValue.of(NON_JSON), expectedAsKnown = Optional.of(NON_JSON)),
        KNOWN_BOOLEAN(
            KnownValue.of(true),
            expectedAsKnown = Optional.of(true),
            expectedAsBoolean = Optional.of(true),
        ),
        BOOLEAN(JsonBoolean.of(true), expectedAsBoolean = Optional.of(true)),
        KNOWN_NUMBER(
            KnownValue.of(42),
            expectedAsKnown = Optional.of(42),
            expectedAsNumber = Optional.of(42),
        ),
        NUMBER(JsonNumber.of(42), expectedAsNumber = Optional.of(42)),
        KNOWN_STRING(
            KnownValue.of("hello"),
            expectedAsKnown = Optional.of("hello"),
            expectedAsString = Optional.of("hello"),
        ),
        STRING(JsonString.of("hello"), expectedAsString = Optional.of("hello")),
        KNOWN_ARRAY_NOT_ALL_JSON(
            KnownValue.of(listOf("a", "b", NON_JSON)),
            expectedAsKnown = Optional.of(listOf("a", "b", NON_JSON)),
        ),
        KNOWN_ARRAY(
            KnownValue.of(listOf("a", "b", "c")),
            expectedAsKnown = Optional.of(listOf("a", "b", "c")),
            expectedAsArray =
                Optional.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
        ),
        ARRAY(
            JsonArray.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
            expectedAsArray =
                Optional.of(listOf(JsonString.of("a"), JsonString.of("b"), JsonString.of("c"))),
        ),
        KNOWN_OBJECT_NOT_ALL_STRING_KEYS(
            KnownValue.of(mapOf("a" to "b", 42 to "c")),
            expectedAsKnown = Optional.of(mapOf("a" to "b", 42 to "c")),
        ),
        KNOWN_OBJECT_NOT_ALL_JSON(
            KnownValue.of(mapOf("a" to "b", "b" to NON_JSON)),
            expectedAsKnown = Optional.of(mapOf("a" to "b", "b" to NON_JSON)),
        ),
        KNOWN_OBJECT(
            KnownValue.of(mapOf("a" to "b", "b" to "c")),
            expectedAsKnown = Optional.of(mapOf("a" to "b", "b" to "c")),
            expectedAsObject =
                Optional.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
        ),
        OBJECT(
            JsonObject.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
            expectedAsObject =
                Optional.of(mapOf("a" to JsonString.of("b"), "b" to JsonString.of("c"))),
        ),
    }

    @ParameterizedTest
    @EnumSource
    fun isMissing(testCase: TestCase) {
        val isMissing = testCase.value.isMissing()

        assertThat(isMissing).isEqualTo(testCase.expectedIsMissing)
    }

    @ParameterizedTest
    @EnumSource
    fun isNull(testCase: TestCase) {
        val isNull = testCase.value.isNull()

        assertThat(isNull).isEqualTo(testCase.expectedIsNull)
    }

    @ParameterizedTest
    @EnumSource
    fun asKnown(testCase: TestCase) {
        val known = testCase.value.asKnown()

        assertThat(known).isEqualTo(testCase.expectedAsKnown)
    }

    @ParameterizedTest
    @EnumSource
    fun asBoolean(testCase: TestCase) {
        val boolean = testCase.value.asBoolean()

        assertThat(boolean).isEqualTo(testCase.expectedAsBoolean)
    }

    @ParameterizedTest
    @EnumSource
    fun asNumber(testCase: TestCase) {
        val number = testCase.value.asNumber()

        assertThat(number).isEqualTo(testCase.expectedAsNumber)
    }

    @ParameterizedTest
    @EnumSource
    fun asString(testCase: TestCase) {
        val string = testCase.value.asString()

        assertThat(string).isEqualTo(testCase.expectedAsString)
    }

    @ParameterizedTest
    @EnumSource
    fun asArray(testCase: TestCase) {
        val array = testCase.value.asArray()

        assertThat(array).isEqualTo(testCase.expectedAsArray)
    }

    @ParameterizedTest
    @EnumSource
    fun asObject(testCase: TestCase) {
        val obj = testCase.value.asObject()

        assertThat(obj).isEqualTo(testCase.expectedAsObject)
    }
}
