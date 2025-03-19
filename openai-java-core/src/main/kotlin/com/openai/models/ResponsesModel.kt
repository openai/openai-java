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

@JsonDeserialize(using = ResponsesModel.Deserializer::class)
@JsonSerialize(using = ResponsesModel.Serializer::class)
class ResponsesModel
private constructor(
    private val string: String? = null,
    private val chat: ChatModel? = null,
    private val unionMember2: UnionMember2? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun chat(): Optional<ChatModel> = Optional.ofNullable(chat)

    fun unionMember2(): Optional<UnionMember2> = Optional.ofNullable(unionMember2)

    fun isString(): Boolean = string != null

    fun isChat(): Boolean = chat != null

    fun isUnionMember2(): Boolean = unionMember2 != null

    fun asString(): String = string.getOrThrow("string")

    fun asChat(): ChatModel = chat.getOrThrow("chat")

    fun asUnionMember2(): UnionMember2 = unionMember2.getOrThrow("unionMember2")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            string != null -> visitor.visitString(string)
            chat != null -> visitor.visitChat(chat)
            unionMember2 != null -> visitor.visitUnionMember2(unionMember2)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): ResponsesModel = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitChat(chat: ChatModel) {}

                override fun visitUnionMember2(unionMember2: UnionMember2) {}
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ResponsesModel && string == other.string && chat == other.chat && unionMember2 == other.unionMember2 /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, chat, unionMember2) /* spotless:on */

    override fun toString(): String =
        when {
            string != null -> "ResponsesModel{string=$string}"
            chat != null -> "ResponsesModel{chat=$chat}"
            unionMember2 != null -> "ResponsesModel{unionMember2=$unionMember2}"
            _json != null -> "ResponsesModel{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid ResponsesModel")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = ResponsesModel(string = string)

        @JvmStatic fun ofChat(chat: ChatModel) = ResponsesModel(chat = chat)

        @JvmStatic
        fun ofUnionMember2(unionMember2: UnionMember2) = ResponsesModel(unionMember2 = unionMember2)
    }

    /**
     * An interface that defines how to map each variant of [ResponsesModel] to a value of type [T].
     */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitChat(chat: ChatModel): T

        fun visitUnionMember2(unionMember2: UnionMember2): T

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

            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                return ResponsesModel(string = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ChatModel>())?.let {
                return ResponsesModel(chat = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<UnionMember2>())?.let {
                return ResponsesModel(unionMember2 = it, _json = json)
            }

            return ResponsesModel(_json = json)
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
                value.unionMember2 != null -> generator.writeObject(value.unionMember2)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid ResponsesModel")
            }
        }
    }

    class UnionMember2 @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val COMPUTER_USE_PREVIEW = of("computer-use-preview")

            @JvmField val COMPUTER_USE_PREVIEW_2025_03_11 = of("computer-use-preview-2025-03-11")

            @JvmStatic fun of(value: String) = UnionMember2(JsonField.of(value))
        }

        /** An enum containing [UnionMember2]'s known values. */
        enum class Known {
            O1_PRO,
            O1_PRO_2025_03_19,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
        }

        /**
         * An enum containing [UnionMember2]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UnionMember2] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            O1_PRO,
            O1_PRO_2025_03_19,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
            /**
             * An enum member indicating that [UnionMember2] was instantiated with an unknown value.
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
                COMPUTER_USE_PREVIEW -> Known.COMPUTER_USE_PREVIEW
                COMPUTER_USE_PREVIEW_2025_03_11 -> Known.COMPUTER_USE_PREVIEW_2025_03_11
                else -> throw OpenAIInvalidDataException("Unknown UnionMember2: $value")
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

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is UnionMember2 && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
