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

/** The strategy used to chunk the file. */
@JsonDeserialize(using = FileChunkingStrategy.Deserializer::class)
@JsonSerialize(using = FileChunkingStrategy.Serializer::class)
class FileChunkingStrategy
private constructor(
    private val staticFileChunkingStrategyObject: StaticFileChunkingStrategyObject? = null,
    private val otherFileChunkingStrategyObject: OtherFileChunkingStrategyObject? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    fun staticFileChunkingStrategyObject(): Optional<StaticFileChunkingStrategyObject> =
        Optional.ofNullable(staticFileChunkingStrategyObject)

    /**
     * This is returned when the chunking strategy is unknown. Typically, this is because the file
     * was indexed before the `chunking_strategy` concept was introduced in the API.
     */
    fun otherFileChunkingStrategyObject(): Optional<OtherFileChunkingStrategyObject> =
        Optional.ofNullable(otherFileChunkingStrategyObject)

    fun isStaticFileChunkingStrategyObject(): Boolean = staticFileChunkingStrategyObject != null

    fun isOtherFileChunkingStrategyObject(): Boolean = otherFileChunkingStrategyObject != null

    fun asStaticFileChunkingStrategyObject(): StaticFileChunkingStrategyObject =
        staticFileChunkingStrategyObject.getOrThrow("staticFileChunkingStrategyObject")

    /**
     * This is returned when the chunking strategy is unknown. Typically, this is because the file
     * was indexed before the `chunking_strategy` concept was introduced in the API.
     */
    fun asOtherFileChunkingStrategyObject(): OtherFileChunkingStrategyObject =
        otherFileChunkingStrategyObject.getOrThrow("otherFileChunkingStrategyObject")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            staticFileChunkingStrategyObject != null ->
                visitor.visitStaticFileChunkingStrategyObject(staticFileChunkingStrategyObject)
            otherFileChunkingStrategyObject != null ->
                visitor.visitOtherFileChunkingStrategyObject(otherFileChunkingStrategyObject)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): FileChunkingStrategy = apply {
        if (!validated) {
            if (
                staticFileChunkingStrategyObject == null && otherFileChunkingStrategyObject == null
            ) {
                throw OpenAIInvalidDataException("Unknown FileChunkingStrategy: $_json")
            }
            staticFileChunkingStrategyObject?.validate()
            otherFileChunkingStrategyObject?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileChunkingStrategy && staticFileChunkingStrategyObject == other.staticFileChunkingStrategyObject && otherFileChunkingStrategyObject == other.otherFileChunkingStrategyObject /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(staticFileChunkingStrategyObject, otherFileChunkingStrategyObject) /* spotless:on */

    override fun toString(): String =
        when {
            staticFileChunkingStrategyObject != null ->
                "FileChunkingStrategy{staticFileChunkingStrategyObject=$staticFileChunkingStrategyObject}"
            otherFileChunkingStrategyObject != null ->
                "FileChunkingStrategy{otherFileChunkingStrategyObject=$otherFileChunkingStrategyObject}"
            _json != null -> "FileChunkingStrategy{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FileChunkingStrategy")
        }

    companion object {

        @JvmStatic
        fun ofStaticFileChunkingStrategyObject(
            staticFileChunkingStrategyObject: StaticFileChunkingStrategyObject
        ) =
            FileChunkingStrategy(
                staticFileChunkingStrategyObject = staticFileChunkingStrategyObject
            )

        /**
         * This is returned when the chunking strategy is unknown. Typically, this is because the
         * file was indexed before the `chunking_strategy` concept was introduced in the API.
         */
        @JvmStatic
        fun ofOtherFileChunkingStrategyObject(
            otherFileChunkingStrategyObject: OtherFileChunkingStrategyObject
        ) = FileChunkingStrategy(otherFileChunkingStrategyObject = otherFileChunkingStrategyObject)
    }

    interface Visitor<out T> {

        fun visitStaticFileChunkingStrategyObject(
            staticFileChunkingStrategyObject: StaticFileChunkingStrategyObject
        ): T

        fun visitOtherFileChunkingStrategyObject(
            otherFileChunkingStrategyObject: OtherFileChunkingStrategyObject
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown FileChunkingStrategy: $json")
        }
    }

    class Deserializer : BaseDeserializer<FileChunkingStrategy>(FileChunkingStrategy::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): FileChunkingStrategy {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "static" -> {
                    tryDeserialize(node, jacksonTypeRef<StaticFileChunkingStrategyObject>()) {
                            it.validate()
                        }
                        ?.let {
                            return FileChunkingStrategy(
                                staticFileChunkingStrategyObject = it,
                                _json = json
                            )
                        }
                }
                "other" -> {
                    tryDeserialize(node, jacksonTypeRef<OtherFileChunkingStrategyObject>()) {
                            it.validate()
                        }
                        ?.let {
                            return FileChunkingStrategy(
                                otherFileChunkingStrategyObject = it,
                                _json = json
                            )
                        }
                }
            }

            return FileChunkingStrategy(_json = json)
        }
    }

    class Serializer : BaseSerializer<FileChunkingStrategy>(FileChunkingStrategy::class) {

        override fun serialize(
            value: FileChunkingStrategy,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.staticFileChunkingStrategyObject != null ->
                    generator.writeObject(value.staticFileChunkingStrategyObject)
                value.otherFileChunkingStrategyObject != null ->
                    generator.writeObject(value.otherFileChunkingStrategyObject)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FileChunkingStrategy")
            }
        }
    }
}
