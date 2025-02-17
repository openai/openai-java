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
import kotlin.jvm.optionals.getOrNull

/**
 * A citation within the message that points to a specific quote from a specific File associated
 * with the assistant or the message. Generated when the assistant uses the "file_search" tool to
 * search files.
 */
@JsonDeserialize(using = Annotation.Deserializer::class)
@JsonSerialize(using = Annotation.Serializer::class)
class Annotation
private constructor(
    private val fileCitation: FileCitationAnnotation? = null,
    private val filePath: FilePathAnnotation? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun fileCitation(): Optional<FileCitationAnnotation> = Optional.ofNullable(fileCitation)

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun filePath(): Optional<FilePathAnnotation> = Optional.ofNullable(filePath)

    fun isFileCitation(): Boolean = fileCitation != null

    fun isFilePath(): Boolean = filePath != null

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun asFileCitation(): FileCitationAnnotation = fileCitation.getOrThrow("fileCitation")

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun asFilePath(): FilePathAnnotation = filePath.getOrThrow("filePath")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            fileCitation != null -> visitor.visitFileCitation(fileCitation)
            filePath != null -> visitor.visitFilePath(filePath)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): Annotation = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileCitation(fileCitation: FileCitationAnnotation) {
                    fileCitation.validate()
                }

                override fun visitFilePath(filePath: FilePathAnnotation) {
                    filePath.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Annotation && fileCitation == other.fileCitation && filePath == other.filePath /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileCitation, filePath) /* spotless:on */

    override fun toString(): String =
        when {
            fileCitation != null -> "Annotation{fileCitation=$fileCitation}"
            filePath != null -> "Annotation{filePath=$filePath}"
            _json != null -> "Annotation{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Annotation")
        }

    companion object {

        /**
         * A citation within the message that points to a specific quote from a specific File
         * associated with the assistant or the message. Generated when the assistant uses the
         * "file_search" tool to search files.
         */
        @JvmStatic
        fun ofFileCitation(fileCitation: FileCitationAnnotation) =
            Annotation(fileCitation = fileCitation)

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        @JvmStatic fun ofFilePath(filePath: FilePathAnnotation) = Annotation(filePath = filePath)
    }

    /** An interface that defines how to map each variant of [Annotation] to a value of type [T]. */
    interface Visitor<out T> {

        /**
         * A citation within the message that points to a specific quote from a specific File
         * associated with the assistant or the message. Generated when the assistant uses the
         * "file_search" tool to search files.
         */
        fun visitFileCitation(fileCitation: FileCitationAnnotation): T

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        fun visitFilePath(filePath: FilePathAnnotation): T

        /**
         * Maps an unknown variant of [Annotation] to a value of type [T].
         *
         * An instance of [Annotation] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown Annotation: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Annotation>(Annotation::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Annotation {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file_citation" -> {
                    tryDeserialize(node, jacksonTypeRef<FileCitationAnnotation>()) { it.validate() }
                        ?.let {
                            return Annotation(fileCitation = it, _json = json)
                        }
                }
                "file_path" -> {
                    tryDeserialize(node, jacksonTypeRef<FilePathAnnotation>()) { it.validate() }
                        ?.let {
                            return Annotation(filePath = it, _json = json)
                        }
                }
            }

            return Annotation(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Annotation>(Annotation::class) {

        override fun serialize(
            value: Annotation,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.fileCitation != null -> generator.writeObject(value.fileCitation)
                value.filePath != null -> generator.writeObject(value.filePath)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Annotation")
            }
        }
    }
}
