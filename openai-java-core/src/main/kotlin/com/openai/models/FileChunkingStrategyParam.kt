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
 * The chunking strategy used to chunk the file(s). If not set, will use the `auto` strategy. Only
 * applicable if `file_ids` is non-empty.
 */
@JsonDeserialize(using = FileChunkingStrategyParam.Deserializer::class)
@JsonSerialize(using = FileChunkingStrategyParam.Serializer::class)
class FileChunkingStrategyParam
private constructor(
    private val autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam? = null,
    private val staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam? = null,
    private val _json: JsonValue? = null,
) {

    private var validated: Boolean = false

    /**
     * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
     * `chunk_overlap_tokens` of `400`.
     */
    fun autoFileChunkingStrategyParam(): Optional<AutoFileChunkingStrategyParam> =
        Optional.ofNullable(autoFileChunkingStrategyParam)

    fun staticFileChunkingStrategyParam(): Optional<StaticFileChunkingStrategyParam> =
        Optional.ofNullable(staticFileChunkingStrategyParam)

    fun isAutoFileChunkingStrategyParam(): Boolean = autoFileChunkingStrategyParam != null

    fun isStaticFileChunkingStrategyParam(): Boolean = staticFileChunkingStrategyParam != null

    /**
     * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
     * `chunk_overlap_tokens` of `400`.
     */
    fun asAutoFileChunkingStrategyParam(): AutoFileChunkingStrategyParam =
        autoFileChunkingStrategyParam.getOrThrow("autoFileChunkingStrategyParam")

    fun asStaticFileChunkingStrategyParam(): StaticFileChunkingStrategyParam =
        staticFileChunkingStrategyParam.getOrThrow("staticFileChunkingStrategyParam")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            autoFileChunkingStrategyParam != null ->
                visitor.visitAutoFileChunkingStrategyParam(autoFileChunkingStrategyParam)
            staticFileChunkingStrategyParam != null ->
                visitor.visitStaticFileChunkingStrategyParam(staticFileChunkingStrategyParam)
            else -> visitor.unknown(_json)
        }
    }

    fun validate(): FileChunkingStrategyParam = apply {
        if (!validated) {
            if (autoFileChunkingStrategyParam == null && staticFileChunkingStrategyParam == null) {
                throw OpenAIInvalidDataException("Unknown FileChunkingStrategyParam: $_json")
            }
            autoFileChunkingStrategyParam?.validate()
            staticFileChunkingStrategyParam?.validate()
            validated = true
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileChunkingStrategyParam && autoFileChunkingStrategyParam == other.autoFileChunkingStrategyParam && staticFileChunkingStrategyParam == other.staticFileChunkingStrategyParam /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(autoFileChunkingStrategyParam, staticFileChunkingStrategyParam) /* spotless:on */

    override fun toString(): String =
        when {
            autoFileChunkingStrategyParam != null ->
                "FileChunkingStrategyParam{autoFileChunkingStrategyParam=$autoFileChunkingStrategyParam}"
            staticFileChunkingStrategyParam != null ->
                "FileChunkingStrategyParam{staticFileChunkingStrategyParam=$staticFileChunkingStrategyParam}"
            _json != null -> "FileChunkingStrategyParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FileChunkingStrategyParam")
        }

    companion object {

        /**
         * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
         * `chunk_overlap_tokens` of `400`.
         */
        @JvmStatic
        fun ofAutoFileChunkingStrategyParam(
            autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam
        ) = FileChunkingStrategyParam(autoFileChunkingStrategyParam = autoFileChunkingStrategyParam)

        @JvmStatic
        fun ofStaticFileChunkingStrategyParam(
            staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam
        ) =
            FileChunkingStrategyParam(
                staticFileChunkingStrategyParam = staticFileChunkingStrategyParam
            )
    }

    interface Visitor<out T> {

        fun visitAutoFileChunkingStrategyParam(
            autoFileChunkingStrategyParam: AutoFileChunkingStrategyParam
        ): T

        fun visitStaticFileChunkingStrategyParam(
            staticFileChunkingStrategyParam: StaticFileChunkingStrategyParam
        ): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown FileChunkingStrategyParam: $json")
        }
    }

    class Deserializer :
        BaseDeserializer<FileChunkingStrategyParam>(FileChunkingStrategyParam::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): FileChunkingStrategyParam {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "auto" -> {
                    tryDeserialize(node, jacksonTypeRef<AutoFileChunkingStrategyParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return FileChunkingStrategyParam(
                                autoFileChunkingStrategyParam = it,
                                _json = json
                            )
                        }
                }
                "static" -> {
                    tryDeserialize(node, jacksonTypeRef<StaticFileChunkingStrategyParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return FileChunkingStrategyParam(
                                staticFileChunkingStrategyParam = it,
                                _json = json
                            )
                        }
                }
            }

            return FileChunkingStrategyParam(_json = json)
        }
    }

    class Serializer : BaseSerializer<FileChunkingStrategyParam>(FileChunkingStrategyParam::class) {

        override fun serialize(
            value: FileChunkingStrategyParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.autoFileChunkingStrategyParam != null ->
                    generator.writeObject(value.autoFileChunkingStrategyParam)
                value.staticFileChunkingStrategyParam != null ->
                    generator.writeObject(value.staticFileChunkingStrategyParam)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FileChunkingStrategyParam")
            }
        }
    }
}
