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
import com.openai.core.allMaxBy
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

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            translation != null -> visitor.visitTranslation(translation)
            verbose != null -> visitor.visitVerbose(verbose)
            else -> visitor.unknown(_json)
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
                override fun visitTranslation(translation: Translation) = translation.validity()

                override fun visitVerbose(verbose: TranslationVerbose) = verbose.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

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

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<Translation>())?.let {
                            TranslationCreateResponse(translation = it, _json = json)
                        },
                        tryDeserialize(node, jacksonTypeRef<TranslationVerbose>())?.let {
                            TranslationCreateResponse(verbose = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> TranslationCreateResponse(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
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
