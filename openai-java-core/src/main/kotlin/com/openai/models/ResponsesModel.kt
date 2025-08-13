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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = ResponsesModel.Deserializer::class)
@JsonSerialize(using = ResponsesModel.Serializer::class)
class ResponsesModel
private constructor(
    private val string: String? = null,
    private val chat: ChatModel? = null,
    private val only: ResponsesOnlyModel? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun chat(): Optional<ChatModel> = Optional.ofNullable(chat)

    fun only(): Optional<ResponsesOnlyModel> = Optional.ofNullable(only)

    fun isString(): Boolean = string != null

    fun isChat(): Boolean = chat != null

    fun isOnly(): Boolean = only != null

    fun asString(): String = string.getOrThrow("string")

    fun asChat(): ChatModel = chat.getOrThrow("chat")

    fun asOnly(): ResponsesOnlyModel = only.getOrThrow("only")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            string != null -> visitor.visitString(string)
            chat != null -> visitor.visitChat(chat)
            only != null -> visitor.visitOnly(only)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): ResponsesModel = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitChat(chat: ChatModel) {
                    chat.validate()
                }

                override fun visitOnly(only: ResponsesOnlyModel) {
                    only.validate()
                }
            }
        )
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
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitString(string: String) = 1

                override fun visitChat(chat: ChatModel) = chat.validity()

                override fun visitOnly(only: ResponsesOnlyModel) = only.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponsesModel &&
            string == other.string &&
            chat == other.chat &&
            only == other.only
    }

    override fun hashCode(): Int = Objects.hash(string, chat, only)

    override fun toString(): String =
        when {
            string != null -> "ResponsesModel{string=$string}"
            chat != null -> "ResponsesModel{chat=$chat}"
            only != null -> "ResponsesModel{only=$only}"
            _json != null -> "ResponsesModel{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponsesModel")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = ResponsesModel(string = string)

        @JvmStatic fun ofChat(chat: ChatModel) = ResponsesModel(chat = chat)

        @JvmStatic fun ofOnly(only: ResponsesOnlyModel) = ResponsesModel(only = only)
    }

    /**
     * An interface that defines how to map each variant of [ResponsesModel] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitChat(chat: ChatModel): T

        fun visitOnly(only: ResponsesOnlyModel): T

        /**
         * Maps an unknown variant of [ResponsesModel] to a value of type [T].
         *
         * An instance of [ResponsesModel] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown ResponsesModel: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<ResponsesModel>(ResponsesModel::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): ResponsesModel {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<ChatModel>())?.let {
                            ResponsesModel(chat = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<ResponsesOnlyModel>())?.let {
                            ResponsesModel(only = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<String>())?.let {
                            ResponsesModel(string = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from object).
                0 -> ResponsesModel(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer : BaseSerializer<ResponsesModel>(ResponsesModel::class) {

        override fun serialize(
            value: ResponsesModel,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.chat != null -> generator.writeObject(value.chat)
                value.only != null -> generator.writeObject(value.only)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponsesModel")
            }
        }
    }

    class ResponsesOnlyModel
    @JsonCreator
    private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val O1_PRO = of("o1-pro")

            @JvmField val O1_PRO_2025_03_19 = of("o1-pro-2025-03-19")

            @JvmField val O3_PRO = of("o3-pro")

            @JvmField val O3_PRO_2025_06_10 = of("o3-pro-2025-06-10")

            @JvmField val O3_DEEP_RESEARCH = of("o3-deep-research")

            @JvmField val O3_DEEP_RESEARCH_2025_06_26 = of("o3-deep-research-2025-06-26")

            @JvmField val O4_MINI_DEEP_RESEARCH = of("o4-mini-deep-research")

            @JvmField val O4_MINI_DEEP_RESEARCH_2025_06_26 = of("o4-mini-deep-research-2025-06-26")

            @JvmField val COMPUTER_USE_PREVIEW = of("computer-use-preview")

            @JvmField val COMPUTER_USE_PREVIEW_2025_03_11 = of("computer-use-preview-2025-03-11")

            @JvmStatic fun of(value: String) = ResponsesOnlyModel(JsonField.of(value))
        }

        /** An enum containing [ResponsesOnlyModel]'s known values. */
        enum class Known {
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
        }

        /**
         * An enum containing [ResponsesOnlyModel]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [ResponsesOnlyModel] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            O1_PRO,
            O1_PRO_2025_03_19,
            O3_PRO,
            O3_PRO_2025_06_10,
            O3_DEEP_RESEARCH,
            O3_DEEP_RESEARCH_2025_06_26,
            O4_MINI_DEEP_RESEARCH,
            O4_MINI_DEEP_RESEARCH_2025_06_26,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            /**
             * An enum member indicating that [ResponsesOnlyModel] was instantiated with an unknown
             * value.
             */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                O1_PRO -> Value.O1_PRO
                O1_PRO_2025_03_19 -> Value.O1_PRO_2025_03_19
                O3_PRO -> Value.O3_PRO
                O3_PRO_2025_06_10 -> Value.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Value.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Value.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Value.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Value.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Value.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Value.COMPUTER_USE_PREVIEW_2025_03_11
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                O1_PRO -> Known.O1_PRO
                O1_PRO_2025_03_19 -> Known.O1_PRO_2025_03_19
                O3_PRO -> Known.O3_PRO
                O3_PRO_2025_06_10 -> Known.O3_PRO_2025_06_10
                O3_DEEP_RESEARCH -> Known.O3_DEEP_RESEARCH
                O3_DEEP_RESEARCH_2025_06_26 -> Known.O3_DEEP_RESEARCH_2025_06_26
                O4_MINI_DEEP_RESEARCH -> Known.O4_MINI_DEEP_RESEARCH
                O4_MINI_DEEP_RESEARCH_2025_06_26 -> Known.O4_MINI_DEEP_RESEARCH_2025_06_26
                COMPUTER_USE_PREVIEW -> Known.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Known.COMPUTER_USE_PREVIEW_2025_03_11
                else -> throw OpenAIInvalidDataException("Unknown ResponsesOnlyModel: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): ResponsesOnlyModel = apply {
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is ResponsesOnlyModel && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
