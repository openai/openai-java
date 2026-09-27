// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.annotation.JsonCreator
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.errors.OpenAIInvalidDataException

/** A built-in voice available for Live speech. */
class BuiltInVoice @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

    /**
     * Returns this class instance's raw value.
     *
     * This is usually only useful if this instance was deserialized from data that doesn't match
     * any known member, and you want to know that value. For example, if the SDK is on an older
     * version than the API, then the API may respond with new members that the SDK is unaware of.
     */
    @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

    companion object {

        @JvmField val ALLOY = of("alloy")

        @JvmField val ASH = of("ash")

        @JvmField val BALLAD = of("ballad")

        @JvmField val BEACON = of("beacon")

        @JvmField val BOSSA = of("bossa")

        @JvmField val CEDAR = of("cedar")

        @JvmField val CINDER = of("cinder")

        @JvmField val CORAL = of("coral")

        @JvmField val DELTA = of("delta")

        @JvmField val ECHO = of("echo")

        @JvmField val GLEAM = of("gleam")

        @JvmField val MARIN = of("marin")

        @JvmField val MERIDIAN = of("meridian")

        @JvmField val QUARTZ = of("quartz")

        @JvmField val RIPPLE = of("ripple")

        @JvmField val SAGE = of("sage")

        @JvmField val SHIMMER = of("shimmer")

        @JvmField val STONE = of("stone")

        @JvmField val TEMPO = of("tempo")

        @JvmField val VERSE = of("verse")

        @JvmField val VESPER = of("vesper")

        @JvmField val WILLOW = of("willow")

        @JvmStatic fun of(value: String) = BuiltInVoice(JsonField.of(value))
    }

    /** An enum containing [BuiltInVoice]'s known values. */
    enum class Known {
        ALLOY,
        ASH,
        BALLAD,
        BEACON,
        BOSSA,
        CEDAR,
        CINDER,
        CORAL,
        DELTA,
        ECHO,
        GLEAM,
        MARIN,
        MERIDIAN,
        QUARTZ,
        RIPPLE,
        SAGE,
        SHIMMER,
        STONE,
        TEMPO,
        VERSE,
        VESPER,
        WILLOW,
    }

    /**
     * An enum containing [BuiltInVoice]'s known values, as well as an [_UNKNOWN] member.
     *
     * An instance of [BuiltInVoice] can contain an unknown value in a couple of cases:
     * - It was deserialized from data that doesn't match any known member. For example, if the SDK
     *   is on an older version than the API, then the API may respond with new members that the SDK
     *   is unaware of.
     * - It was constructed with an arbitrary value using the [of] method.
     */
    enum class Value {
        ALLOY,
        ASH,
        BALLAD,
        BEACON,
        BOSSA,
        CEDAR,
        CINDER,
        CORAL,
        DELTA,
        ECHO,
        GLEAM,
        MARIN,
        MERIDIAN,
        QUARTZ,
        RIPPLE,
        SAGE,
        SHIMMER,
        STONE,
        TEMPO,
        VERSE,
        VESPER,
        WILLOW,
        /** An enum member indicating that [BuiltInVoice] was instantiated with an unknown value. */
        _UNKNOWN,
    }

    /**
     * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN] if
     * the class was instantiated with an unknown value.
     *
     * Use the [known] method instead if you're certain the value is always known or if you want to
     * throw for the unknown case.
     */
    fun value(): Value =
        when (this) {
            ALLOY -> Value.ALLOY
            ASH -> Value.ASH
            BALLAD -> Value.BALLAD
            BEACON -> Value.BEACON
            BOSSA -> Value.BOSSA
            CEDAR -> Value.CEDAR
            CINDER -> Value.CINDER
            CORAL -> Value.CORAL
            DELTA -> Value.DELTA
            ECHO -> Value.ECHO
            GLEAM -> Value.GLEAM
            MARIN -> Value.MARIN
            MERIDIAN -> Value.MERIDIAN
            QUARTZ -> Value.QUARTZ
            RIPPLE -> Value.RIPPLE
            SAGE -> Value.SAGE
            SHIMMER -> Value.SHIMMER
            STONE -> Value.STONE
            TEMPO -> Value.TEMPO
            VERSE -> Value.VERSE
            VESPER -> Value.VESPER
            WILLOW -> Value.WILLOW
            else -> Value._UNKNOWN
        }

    /**
     * Returns an enum member corresponding to this class instance's value.
     *
     * Use the [value] method instead if you're uncertain the value is always known and don't want
     * to throw for the unknown case.
     *
     * @throws OpenAIInvalidDataException if this class instance's value is a not a known member.
     */
    fun known(): Known =
        when (this) {
            ALLOY -> Known.ALLOY
            ASH -> Known.ASH
            BALLAD -> Known.BALLAD
            BEACON -> Known.BEACON
            BOSSA -> Known.BOSSA
            CEDAR -> Known.CEDAR
            CINDER -> Known.CINDER
            CORAL -> Known.CORAL
            DELTA -> Known.DELTA
            ECHO -> Known.ECHO
            GLEAM -> Known.GLEAM
            MARIN -> Known.MARIN
            MERIDIAN -> Known.MERIDIAN
            QUARTZ -> Known.QUARTZ
            RIPPLE -> Known.RIPPLE
            SAGE -> Known.SAGE
            SHIMMER -> Known.SHIMMER
            STONE -> Known.STONE
            TEMPO -> Known.TEMPO
            VERSE -> Known.VERSE
            VESPER -> Known.VESPER
            WILLOW -> Known.WILLOW
            else -> throw OpenAIInvalidDataException("Unknown BuiltInVoice: $value")
        }

    /**
     * Returns this class instance's primitive wire representation.
     *
     * This differs from the [toString] method because that method is primarily for debugging and
     * generally doesn't throw.
     *
     * @throws OpenAIInvalidDataException if this class instance's value does not have the expected
     *   primitive type.
     */
    fun asString(): String =
        _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): BuiltInVoice = apply {
        if (validated) {
            return@apply
        }

        known()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: OpenAIInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is BuiltInVoice && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()
}
