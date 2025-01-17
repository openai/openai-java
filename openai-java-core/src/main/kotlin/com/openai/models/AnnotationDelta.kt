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
@JsonDeserialize(using = AnnotationDelta.Deserializer::class)
@JsonSerialize(using = AnnotationDelta.Serializer::class)
class AnnotationDelta
private constructor(
    private val fileCitationDeltaAnnotation: FileCitationDeltaAnnotation? = null,
    private val filePathDeltaAnnotation: FilePathDeltaAnnotation? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun fileCitationDeltaAnnotation(): Optional<FileCitationDeltaAnnotation> =
        Optional.ofNullable(fileCitationDeltaAnnotation)

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun filePathDeltaAnnotation(): Optional<FilePathDeltaAnnotation> =
        Optional.ofNullable(filePathDeltaAnnotation)

    fun isFileCitationDeltaAnnotation(): Boolean = fileCitationDeltaAnnotation != null

    fun isFilePathDeltaAnnotation(): Boolean = filePathDeltaAnnotation != null

    /**
     * A citation within the message that points to a specific quote from a specific File associated
     * with the assistant or the message. Generated when the assistant uses the "file_search" tool
     * to search files.
     */
    fun asFileCitationDeltaAnnotation(): FileCitationDeltaAnnotation =
        fileCitationDeltaAnnotation.getOrThrow("fileCitationDeltaAnnotation")

    /**
     * A URL for the file that's generated when the assistant used the `code_interpreter` tool to
     * generate a file.
     */
    fun asFilePathDeltaAnnotation(): FilePathDeltaAnnotation =
        filePathDeltaAnnotation.getOrThrow("filePathDeltaAnnotation")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            fileCitationDeltaAnnotation != null ->
                visitor.visitFileCitationDeltaAnnotation(fileCitationDeltaAnnotation)
            filePathDeltaAnnotation != null ->
                visitor.visitFilePathDeltaAnnotation(filePathDeltaAnnotation)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): AnnotationDelta = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitFileCitationDeltaAnnotation(
                    fileCitationDeltaAnnotation: FileCitationDeltaAnnotation
                ) {
                    fileCitationDeltaAnnotation.validate()
                }

                override fun visitFilePathDeltaAnnotation(
                    filePathDeltaAnnotation: FilePathDeltaAnnotation
                ) {
                    filePathDeltaAnnotation.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is AnnotationDelta && fileCitationDeltaAnnotation == other.fileCitationDeltaAnnotation && filePathDeltaAnnotation == other.filePathDeltaAnnotation /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileCitationDeltaAnnotation, filePathDeltaAnnotation) /* spotless:on */

    override fun toString(): String =
        when {
            fileCitationDeltaAnnotation != null ->
                "AnnotationDelta{fileCitationDeltaAnnotation=$fileCitationDeltaAnnotation}"
            filePathDeltaAnnotation != null ->
                "AnnotationDelta{filePathDeltaAnnotation=$filePathDeltaAnnotation}"
            _json != null -> "AnnotationDelta{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AnnotationDelta")
        }

    companion object {

        /**
         * A citation within the message that points to a specific quote from a specific File
         * associated with the assistant or the message. Generated when the assistant uses the
         * "file_search" tool to search files.
         */
        @JvmStatic
        fun ofFileCitationDeltaAnnotation(
            fileCitationDeltaAnnotation: FileCitationDeltaAnnotation
        ) = AnnotationDelta(fileCitationDeltaAnnotation = fileCitationDeltaAnnotation)

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        @JvmStatic
        fun ofFilePathDeltaAnnotation(filePathDeltaAnnotation: FilePathDeltaAnnotation) =
            AnnotationDelta(filePathDeltaAnnotation = filePathDeltaAnnotation)
    }

    interface Visitor<out T> {

        /**
         * A citation within the message that points to a specific quote from a specific File
         * associated with the assistant or the message. Generated when the assistant uses the
         * "file_search" tool to search files.
         */
        fun visitFileCitationDeltaAnnotation(
            fileCitationDeltaAnnotation: FileCitationDeltaAnnotation
        ): T

        /**
         * A URL for the file that's generated when the assistant used the `code_interpreter` tool
         * to generate a file.
         */
        fun visitFilePathDeltaAnnotation(filePathDeltaAnnotation: FilePathDeltaAnnotation): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AnnotationDelta: $json")
        }
    }

    class Deserializer : BaseDeserializer<AnnotationDelta>(AnnotationDelta::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AnnotationDelta {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "file_citation" -> {
                    tryDeserialize(node, jacksonTypeRef<FileCitationDeltaAnnotation>()) {
                            it.validate()
                        }
                        ?.let {
                            return AnnotationDelta(fileCitationDeltaAnnotation = it, _json = json)
                        }
                }
                "file_path" -> {
                    tryDeserialize(node, jacksonTypeRef<FilePathDeltaAnnotation>()) {
                            it.validate()
                        }
                        ?.let {
                            return AnnotationDelta(filePathDeltaAnnotation = it, _json = json)
                        }
                }
            }

            return AnnotationDelta(_json = json)
        }
    }

    class Serializer : BaseSerializer<AnnotationDelta>(AnnotationDelta::class) {

        override fun serialize(
            value: AnnotationDelta,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.fileCitationDeltaAnnotation != null ->
                    generator.writeObject(value.fileCitationDeltaAnnotation)
                value.filePathDeltaAnnotation != null ->
                    generator.writeObject(value.filePathDeltaAnnotation)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AnnotationDelta")
            }
        }
    }
}
