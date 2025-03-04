// File generated from our OpenAPI spec by Stainless.

package com.openai.models

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

@JsonDeserialize(using = AudioTranslationCreateResponse.Deserializer::class)
@JsonSerialize(using = AudioTranslationCreateResponse.Serializer::class)
class AudioTranslationCreateResponse
private constructor(
    private val translation: Translation? = null,
    private val translationVerbose: TranslationVerbose? = null,
    private val _json: JsonValue? = null,
) {

    fun translation(): Optional<Translation> = Optional.ofNullable(translation)

    fun translationVerbose(): Optional<TranslationVerbose> = Optional.ofNullable(translationVerbose)

    fun isTranslation(): Boolean = translation != null

    fun isTranslationVerbose(): Boolean = translationVerbose != null

    fun asTranslation(): Translation = translation.getOrThrow("translation")

    fun asTranslationVerbose(): TranslationVerbose =
        translationVerbose.getOrThrow("translationVerbose")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            translation != null -> visitor.visitTranslation(translation)
            translationVerbose != null -> visitor.visitTranslationVerbose(translationVerbose)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AudioTranslationCreateResponse = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitTranslation(translation: Translation) {
                    translation.validate()
                }

                override fun visitTranslationVerbose(translationVerbose: TranslationVerbose) {
                    translationVerbose.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AudioTranslationCreateResponse && translation == other.translation && translationVerbose == other.translationVerbose /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(translation, translationVerbose) /* spotless:on */

    override fun toString(): String =
        when {
            translation != null -> "AudioTranslationCreateResponse{translation=$translation}"
            translationVerbose != null ->
                "AudioTranslationCreateResponse{translationVerbose=$translationVerbose}"
            _json != null -> "AudioTranslationCreateResponse{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AudioTranslationCreateResponse")
        }

    companion object {

        @JvmStatic
        fun ofTranslation(translation: Translation) =
            AudioTranslationCreateResponse(translation = translation)

        @JvmStatic
        fun ofTranslationVerbose(translationVerbose: TranslationVerbose) =
            AudioTranslationCreateResponse(translationVerbose = translationVerbose)
    }

    /**
     * An interface that defines how to map each variant of [AudioTranslationCreateResponse] to a
     * value of type [T].
     */
    interface Visitor<out T> {

        fun visitTranslation(translation: Translation): T

        fun visitTranslationVerbose(translationVerbose: TranslationVerbose): T

        /**
         * Maps an unknown variant of [AudioTranslationCreateResponse] to a value of type [T].
         *
         * An instance of [AudioTranslationCreateResponse] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AudioTranslationCreateResponse: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AudioTranslationCreateResponse>(AudioTranslationCreateResponse::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AudioTranslationCreateResponse {
            val json = JsonValue.fromJsonNode(node)

            tryDeserialize(node, jacksonTypeRef<Translation>()) { it.validate() }
                ?.let {
                    return AudioTranslationCreateResponse(translation = it, _json = json)
                }
            tryDeserialize(node, jacksonTypeRef<TranslationVerbose>()) { it.validate() }
                ?.let {
                    return AudioTranslationCreateResponse(translationVerbose = it, _json = json)
                }

            return AudioTranslationCreateResponse(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AudioTranslationCreateResponse>(AudioTranslationCreateResponse::class) {

        override fun serialize(
            value: AudioTranslationCreateResponse,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.translation != null -> generator.writeObject(value.translation)
                value.translationVerbose != null -> generator.writeObject(value.translationVerbose)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AudioTranslationCreateResponse")
            }
        }
    }
}
