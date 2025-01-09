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
    private val fileCitationAnnotation: FileCitationAnnotation? = null,
    private val filePathAnnotation: FilePathAnnotation? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun fileCitationAnnotation(): Optional<FileCitationAnnotation> =
        Optional.ofNullable(fileCitationAnnotation)

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun filePathAnnotation(): Optional<FilePathAnnotation> = Optional.ofNullable(filePathAnnotation)

    fun isFileCitationAnnotation(): Boolean = fileCitationAnnotation != null

    fun isFilePathAnnotation(): Boolean = filePathAnnotation != null

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun asFileCitationAnnotation(): FileCitationAnnotation =
        fileCitationAnnotation.getOrThrow("fileCitationAnnotation")

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun asFilePathAnnotation(): FilePathAnnotation =
        filePathAnnotation.getOrThrow("filePathAnnotation")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            fileCitationAnnotation != null ->
                visitor.visitFileCitationAnnotation(fileCitationAnnotation)
            filePathAnnotation != null -> visitor.visitFilePathAnnotation(filePathAnnotation)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): Annotation = apply {
        if (!validated) {
            if (fileCitationAnnotation == null && filePathAnnotation == null) {
                throw OpenAIInvalidDataException("Unknown Annotation: $_json")
            }
            fileCitationAnnotation?.validate()
            filePathAnnotation?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Annotation && fileCitationAnnotation == other.fileCitationAnnotation && filePathAnnotation == other.filePathAnnotation /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileCitationAnnotation, filePathAnnotation) /* spotless:on */

    override fun toString(): String =
        when {
            fileCitationAnnotation != null ->
                "Annotation{fileCitationAnnotation=$fileCitationAnnotation}"
            filePathAnnotation != null -> "Annotation{filePathAnnotation=$filePathAnnotation}"
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
        fun ofFileCitationAnnotation(fileCitationAnnotation: FileCitationAnnotation) =
            Annotation(fileCitationAnnotation = fileCitationAnnotation)

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        @JvmStatic
        fun ofFilePathAnnotation(filePathAnnotation: FilePathAnnotation) =
            Annotation(filePathAnnotation = filePathAnnotation)
    }

    interface Visitor<out T> {

        fun visitFileCitationAnnotation(fileCitationAnnotation: FileCitationAnnotation): T

        fun visitFilePathAnnotation(filePathAnnotation: FilePathAnnotation): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown Annotation: $json")
        }
    }

    class Deserializer : BaseDeserializer<Annotation>(Annotation::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Annotation {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file_citation" -> {
                    tryDeserialize(node, jacksonTypeRef<FileCitationAnnotation>()) { it.validate() }
                        ?.let {
                            return Annotation(fileCitationAnnotation = it, _json = json)
                        }
                }
                "file_path" -> {
                    tryDeserialize(node, jacksonTypeRef<FilePathAnnotation>()) { it.validate() }
                        ?.let {
                            return Annotation(filePathAnnotation = it, _json = json)
                        }
                }
            }

            return Annotation(_json = json)
        }
    }

    class Serializer : BaseSerializer<Annotation>(Annotation::class) {

        override fun serialize(
            value: Annotation,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.fileCitationAnnotation != null ->
                    generator.writeObject(value.fileCitationAnnotation)
                value.filePathAnnotation != null -> generator.writeObject(value.filePathAnnotation)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Annotation")
            }
        }
    }
}
