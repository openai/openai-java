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
    private val auto: AutoFileChunkingStrategyParam? = null,
    private val static_: StaticFileChunkingStrategyObjectParam? = null,
    private val _json: JsonValue? = null,
) {

    /**
     * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
     * `chunk_overlap_tokens` of `400`.
     */
    fun auto(): Optional<AutoFileChunkingStrategyParam> = Optional.ofNullable(auto)

    fun static_(): Optional<StaticFileChunkingStrategyObjectParam> = Optional.ofNullable(static_)

    fun isAuto(): Boolean = auto != null

    fun isStatic(): Boolean = static_ != null

    /**
     * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
     * `chunk_overlap_tokens` of `400`.
     */
    fun asAuto(): AutoFileChunkingStrategyParam = auto.getOrThrow("auto")

    fun asStatic(): StaticFileChunkingStrategyObjectParam = static_.getOrThrow("static_")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T {
        return when {
            auto != null -> visitor.visitAuto(auto)
            static_ != null -> visitor.visitStatic(static_)
            else -> visitor.unknown(_json)
        }
    }

    private var validated: Boolean = false

    fun validate(): FileChunkingStrategyParam = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAuto(auto: AutoFileChunkingStrategyParam) {
                    auto.validate()
                }

                override fun visitStatic(static_: StaticFileChunkingStrategyObjectParam) {
                    static_.validate()
                }
            }
        )
        validated = true
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileChunkingStrategyParam && auto == other.auto && static_ == other.static_ /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(auto, static_) /* spotless:on */

    override fun toString(): String =
        when {
            auto != null -> "FileChunkingStrategyParam{auto=$auto}"
            static_ != null -> "FileChunkingStrategyParam{static_=$static_}"
            _json != null -> "FileChunkingStrategyParam{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid FileChunkingStrategyParam")
        }

    companion object {

        /**
         * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
         * `chunk_overlap_tokens` of `400`.
         */
        @JvmStatic
        fun ofAuto(auto: AutoFileChunkingStrategyParam) = FileChunkingStrategyParam(auto = auto)

        @JvmStatic
        fun ofStatic(static_: StaticFileChunkingStrategyObjectParam) =
            FileChunkingStrategyParam(static_ = static_)
    }

    interface Visitor<out T> {

        /**
         * The default strategy. This strategy currently uses a `max_chunk_size_tokens` of `800` and
         * `chunk_overlap_tokens` of `400`.
         */
        fun visitAuto(auto: AutoFileChunkingStrategyParam): T

        fun visitStatic(static_: StaticFileChunkingStrategyObjectParam): T

        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown FileChunkingStrategyParam: $json")
        }
    }

    internal class Deserializer :
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
                            return FileChunkingStrategyParam(auto = it, _json = json)
                        }
                }
                "static" -> {
                    tryDeserialize(node, jacksonTypeRef<StaticFileChunkingStrategyObjectParam>()) {
                            it.validate()
                        }
                        ?.let {
                            return FileChunkingStrategyParam(static_ = it, _json = json)
                        }
                }
            }

            return FileChunkingStrategyParam(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<FileChunkingStrategyParam>(FileChunkingStrategyParam::class) {

        override fun serialize(
            value: FileChunkingStrategyParam,
            generator: JsonGenerator,
            provider: SerializerProvider
        ) {
            when {
                value.auto != null -> generator.writeObject(value.auto)
                value.static_ != null -> generator.writeObject(value.static_)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid FileChunkingStrategyParam")
            }
        }
    }
}
