// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.translations

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.JsonValue
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = TranslationCreateResponse.Deserializer::class)
@JsonSerialize(using = TranslationCreateResponse.Serializer::class)
class TranslationCreateResponse
private constructor(
    private val translation: Translation? = null,
    private val verbose: TranslationVerbose? = null,
    private val _json: JsonValue? = null,
) {

    fun translation(): Optional<Translation> = Optional.ofNullable(translation)

    fun verbose(): Optional<TranslationVerbose> = Optional.ofNullable(verbose)

    fun isTranslation(): Boolean = translation != null

    fun isVerbose(): Boolean = verbose != null

    fun asTranslation(): Translation = translation.getOrThrow("translation")

    fun asVerbose(): TranslationVerbose = verbose.getOrThrow("verbose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            translation != null -> visitor.visitTranslation(translation)
            verbose != null -> visitor.visitVerbose(verbose)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): TranslationCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTranslation(translation: Translation) {
                    translation.validate()
                }

                override fun visitVerbose(verbose: TranslationVerbose) {
                    verbose.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is TranslationCreateResponse && translation == other.translation && verbose == other.verbose /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(translation, verbose) /* spotless:on */

    override fun toString(): String =
        when {
            translation != null -> "TranslationCreateResponse{translation=$translation}"
            verbose != null -> "TranslationCreateResponse{verbose=$verbose}"
            _json != null -> "TranslationCreateResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid TranslationCreateResponse")
        }

    companion object {

        @JvmStatic
        fun ofTranslation(translation: Translation) =
            TranslationCreateResponse(translation = translation)

        @JvmStatic
        fun ofVerbose(verbose: TranslationVerbose) = TranslationCreateResponse(verbose = verbose)
    }

    /**
     * An interface that defines how to map each variant of [TranslationCreateResponse] to a value
     * of type [T].
     */
    interface Visitor<out T> {

        fun visitTranslation(translation: Translation): T

        fun visitVerbose(verbose: TranslationVerbose): T

        /**
         * Maps an unknown variant of [TranslationCreateResponse] to a value of type [T].
         *
         * An instance of [TranslationCreateResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown TranslationCreateResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<TranslationCreateResponse>(TranslationCreateResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): TranslationCreateResponse {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Translation>()) { it.validate() }
                ?.let {
                    return TranslationCreateResponse(translation = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<TranslationVerbose>()) { it.validate() }
                ?.let {
                    return TranslationCreateResponse(verbose = it, _json = json)
                }

            return TranslationCreateResponse(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<TranslationCreateResponse>(TranslationCreateResponse::class) {

        override fun serialize(
            value: TranslationCreateResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.translation != null -> generator.writeObject(value.translation)
                value.verbose != null -> generator.writeObject(value.verbose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid TranslationCreateResponse")
            }
        }
    }
}
