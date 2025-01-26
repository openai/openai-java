// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.Enum
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

/**
 * Controls which (if any) tool is called by the model. `none` means the model will not call any
 * tools and instead generates a message. `auto` is the default value and means the model can pick
 * between generating a message or calling one or more tools. `required` means the model must call
 * one or more tools before responding to the user. Specifying a particular tool like `{"type":
 * "file_search"}` or `{"type": "function", "function": {"name": "my_function"}}` forces the model
 * to call that tool.
 */
@JsonDeserialize(using = AssistantToolChoiceOption.Deserializer::class)
@JsonSerialize(using = AssistantToolChoiceOption.Serializer::class)
class AssistantToolChoiceOption
private constructor(
    private val auto: Auto? = null,
    private val assistantToolChoice: AssistantToolChoice? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * `none` means the model will not call any tools and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools before responding to the user.
     */
    fun auto(): Optional<Auto> = Optional.ofNullable(auto)

    /** Specifies a tool the model should use. Use to force the model to call a specific tool. */
    fun assistantToolChoice(): Optional<AssistantToolChoice> =
        Optional.ofNullable(assistantToolChoice)

    fun isAuto(): Boolean = auto != null

    fun isAssistantToolChoice(): Boolean = assistantToolChoice != null

    /**
     * `none` means the model will not call any tools and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools before responding to the user.
     */
    fun asAuto(): Auto = auto.getOrThrow("auto")

    /** Specifies a tool the model should use. Use to force the model to call a specific tool. */
    fun asAssistantToolChoice(): AssistantToolChoice =
        assistantToolChoice.getOrThrow("assistantToolChoice")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            auto != null -> visitor.visitAuto(auto)
            assistantToolChoice != null -> visitor.visitAssistantToolChoice(assistantToolChoice)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AssistantToolChoiceOption = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAuto(auto: Auto) {}

                override fun visitAssistantToolChoice(assistantToolChoice: AssistantToolChoice) {
                    assistantToolChoice.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AssistantToolChoiceOption && auto == other.auto && assistantToolChoice == other.assistantToolChoice /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, assistantToolChoice) /* spotless:on */

    override fun toString(): String =
        when {
            auto != null -> "AssistantToolChoiceOption{auto=$auto}"
            assistantToolChoice != null ->
                "AssistantToolChoiceOption{assistantToolChoice=$assistantToolChoice}"
            _json != null -> "AssistantToolChoiceOption{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AssistantToolChoiceOption")
        }

    companion object {

        /**
         * `none` means the model will not call any tools and instead generates a message. `auto`
         * means the model can pick between generating a message or calling one or more tools.
         * `required` means the model must call one or more tools before responding to the user.
         */
        @JvmStatic fun ofAuto(auto: Auto) = AssistantToolChoiceOption(auto = auto)

        /**
         * Specifies a tool the model should use. Use to force the model to call a specific tool.
         */
        @JvmStatic
        fun ofAssistantToolChoice(assistantToolChoice: AssistantToolChoice) =
            AssistantToolChoiceOption(assistantToolChoice = assistantToolChoice)
    }

    interface Visitor<out T> {

        /**
         * `none` means the model will not call any tools and instead generates a message. `auto`
         * means the model can pick between generating a message or calling one or more tools.
         * `required` means the model must call one or more tools before responding to the user.
         */
        fun visitAuto(auto: Auto): T

        /**
         * Specifies a tool the model should use. Use to force the model to call a specific tool.
         */
        fun visitAssistantToolChoice(assistantToolChoice: AssistantToolChoice): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AssistantToolChoiceOption: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AssistantToolChoiceOption>(AssistantToolChoiceOption::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AssistantToolChoiceOption {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Auto>())?.let {
                return AssistantToolChoiceOption(auto = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<AssistantToolChoice>()) { it.validate() }
                ?.let {
                    return AssistantToolChoiceOption(assistantToolChoice = it, _json = json)
                }

            return AssistantToolChoiceOption(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AssistantToolChoiceOption>(AssistantToolChoiceOption::class) {

        override fun serialize(
            value: AssistantToolChoiceOption,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.auto != null -> generator.writeObject(value.auto)
                value.assistantToolChoice != null ->
                    generator.writeObject(value.assistantToolChoice)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AssistantToolChoiceOption")
            }
        }
    }

    /**
     * `none` means the model will not call any tools and instead generates a message. `auto` means
     * the model can pick between generating a message or calling one or more tools. `required`
     * means the model must call one or more tools before responding to the user.
     */
    class Auto
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) : Enum {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val NONE = of("none")

            @JvmField val AUTO = of("auto")

            @JvmField val REQUIRED = of("required")

            @JvmStatic fun of(value: String) = Auto(JsonField.of(value))
        }

        enum class Known {
            NONE,
            AUTO,
            REQUIRED,
        }

        enum class Value {
            NONE,
            AUTO,
            REQUIRED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                NONE -> Value.NONE
                AUTO -> Value.AUTO
                REQUIRED -> Value.REQUIRED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                NONE -> Known.NONE
                AUTO -> Known.AUTO
                REQUIRED -> Known.REQUIRED
                else -> throw OpenAIInvalidDataException("Unknown Auto: $value")
            }

        fun asString(): String = _value().asStringOrThrow()

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Auto && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
