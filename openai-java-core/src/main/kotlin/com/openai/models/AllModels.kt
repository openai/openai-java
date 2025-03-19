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

@JsonDeserialize(using = AllModels.Deserializer::class)
@JsonSerialize(using = AllModels.Serializer::class)
class AllModels
private constructor(
    private val string: String? = null,
    private val chatModel: ChatModel? = null,
    private val string: String? = null,
    private val chatModel: ChatModel? = null,
    private val unionMember4: UnionMember4? = null,
    private val _json: JsonValue? = null,
) {

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun chatModel(): Optional<ChatModel> = Optional.ofNullable(chatModel)

    fun string(): Optional<String> = Optional.ofNullable(string)

    fun chatModel(): Optional<ChatModel> = Optional.ofNullable(chatModel)

    fun unionMember4(): Optional<UnionMember4> = Optional.ofNullable(unionMember4)

    fun isString(): Boolean = string != null

    fun isChatModel(): Boolean = chatModel != null

    fun isString(): Boolean = string != null

    fun isChatModel(): Boolean = chatModel != null

    fun isUnionMember4(): Boolean = unionMember4 != null

    fun asString(): String = string.getOrThrow("string")

    fun asChatModel(): ChatModel = chatModel.getOrThrow("chatModel")

    fun asString(): String = string.getOrThrow("string")

    fun asChatModel(): ChatModel = chatModel.getOrThrow("chatModel")

    fun asUnionMember4(): UnionMember4 = unionMember4.getOrThrow("unionMember4")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            string != null -> visitor.visitString(string)
            chatModel != null -> visitor.visitChatModel(chatModel)
            string != null -> visitor.visitString(string)
            chatModel != null -> visitor.visitChatModel(chatModel)
            unionMember4 != null -> visitor.visitUnionMember4(unionMember4)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AllModels = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitString(string: String) {}

                override fun visitChatModel(chatModel: ChatModel) {}

                override fun visitString(string: String) {}

                override fun visitChatModel(chatModel: ChatModel) {}

                override fun visitUnionMember4(unionMember4: UnionMember4) {}
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AllModels && string == other.string && chatModel == other.chatModel && string == other.string && chatModel == other.chatModel && unionMember4 == other.unionMember4 /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(string, chatModel, string, chatModel, unionMember4) /* spotless:on */

    override fun toString(): String =
        when {
            string != null -> "AllModels{string=$string}"
            chatModel != null -> "AllModels{chatModel=$chatModel}"
            string != null -> "AllModels{string=$string}"
            chatModel != null -> "AllModels{chatModel=$chatModel}"
            unionMember4 != null -> "AllModels{unionMember4=$unionMember4}"
            _json != null -> "AllModels{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AllModels")
        }

    companion object {

        @JvmStatic fun ofString(string: String) = AllModels(string = string)

        @JvmStatic fun ofChatModel(chatModel: ChatModel) = AllModels(chatModel = chatModel)

        @JvmStatic fun ofString(string: String) = AllModels(string = string)

        @JvmStatic fun ofChatModel(chatModel: ChatModel) = AllModels(chatModel = chatModel)

        @JvmStatic
        fun ofUnionMember4(unionMember4: UnionMember4) = AllModels(unionMember4 = unionMember4)
    }

    /** An interface that defines how to map each variant of [AllModels] to a value of type [T]. */
    interface Visitor<out T> {

        fun visitString(string: String): T

        fun visitChatModel(chatModel: ChatModel): T

        fun visitString(string: String): T

        fun visitChatModel(chatModel: ChatModel): T

        fun visitUnionMember4(unionMember4: UnionMember4): T

        /**
         * Maps an unknown variant of [AllModels] to a value of type [T].
         *
         * An instance of [AllModels] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AllModels: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<AllModels>(AllModels::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AllModels {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                return AllModels(string = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ChatModel>())?.let {
                return AllModels(chatModel = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<String>())?.let {
                return AllModels(string = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<ChatModel>())?.let {
                return AllModels(chatModel = it, _json = json)
            }
            tryDeserialize(node, jacksonTypeRef<UnionMember4>())?.let {
                return AllModels(unionMember4 = it, _json = json)
            }

            return AllModels(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<AllModels>(AllModels::class) {

        override fun serialize(
            value: AllModels,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.string != null -> generator.writeObject(value.string)
                value.chatModel != null -> generator.writeObject(value.chatModel)
                value.string != null -> generator.writeObject(value.string)
                value.chatModel != null -> generator.writeObject(value.chatModel)
                value.unionMember4 != null -> generator.writeObject(value.unionMember4)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AllModels")
            }
        }
    }

    class UnionMember4 @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmStatic fun of(value: String) = UnionMember4(JsonField.of(value))
        }

        /** An enum containing [UnionMember4]'s known values. */
        enum class Known {
            O1_PRO,
            O1_PRO_2025_03_19,
            COMPUTER_USE_PREVIEW,
            COMPUTER_USE_PREVIEW_2025_03_11,
        }

        /**
         * An enum containing [UnionMember4]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [UnionMember4] can contain an unknown value in a couple of cases:
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
             * An enum member indicating that [UnionMember4] was instantiated with an unknown value.
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
                else -> throw OpenAIInvalidDataException("Unknown UnionMember4: $value")
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

            return /* spotless:off */ other is UnionMember4 && value == other.value /* spotless:on */
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }
}
