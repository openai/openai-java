package com.openai.core

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JavaType
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.node.JsonNodeType.ARRAY
import com.fasterxml.jackson.databind.node.JsonNodeType.BINARY
import com.fasterxml.jackson.databind.node.JsonNodeType.BOOLEAN
import com.fasterxml.jackson.databind.node.JsonNodeType.MISSING
import com.fasterxml.jackson.databind.node.JsonNodeType.NULL
import com.fasterxml.jackson.databind.node.JsonNodeType.NUMBER
import com.fasterxml.jackson.databind.node.JsonNodeType.OBJECT
import com.fasterxml.jackson.databind.node.JsonNodeType.POJO
import com.fasterxml.jackson.databind.node.JsonNodeType.STRING
import com.fasterxml.jackson.databind.ser.std.NullSerializer
import com.openai.errors.OpenAIInvalidDataException
import java.io.InputStream
import java.util.Objects
import java.util.Optional

@JsonDeserialize(using = JsonField.Deserializer::class)
sealed class JsonField<out T : Any> {

    fun isMissing(): Boolean = this is JsonMissing

    fun isNull(): Boolean = this is JsonNull

    fun asKnown(): Optional<out T> =
        when (this) {
            is KnownValue -> Optional.of(value)
            else -> Optional.empty()
        }

    /**
     * If the "known" value (i.e. matching the type that the SDK expects) is returned by the API
     * then this method will return an empty `Optional`, otherwise the returned `Optional` is given
     * a `JsonValue`.
     */
    fun asUnknown(): Optional<out JsonValue> =
        when (this) {
            is JsonValue -> Optional.of(this)
            else -> Optional.empty()
        }

    fun asBoolean(): Optional<Boolean> =
        when (this) {
            is JsonBoolean -> Optional.of(value)
            is KnownValue -> Optional.ofNullable(value as? Boolean)
            else -> Optional.empty()
        }

    fun asNumber(): Optional<Number> =
        when (this) {
            is JsonNumber -> Optional.of(value)
            is KnownValue -> Optional.ofNullable(value as? Number)
            else -> Optional.empty()
        }

    fun asString(): Optional<String> =
        when (this) {
            is JsonString -> Optional.of(value)
            is KnownValue -> Optional.ofNullable(value as? String)
            else -> Optional.empty()
        }

    fun asStringOrThrow(): String =
        asString().orElseThrow { OpenAIInvalidDataException("Value is not a string") }

    fun asArray(): Optional<List<JsonValue>> =
        when (this) {
            is JsonArray -> Optional.of(values)
            is KnownValue ->
                Optional.ofNullable(
                    (value as? List<*>)?.map {
                        try {
                            JsonValue.from(it)
                        } catch (e: IllegalArgumentException) {
                            // The known value is a list, but not all values are convertible to
                            // `JsonValue`.
                            return Optional.empty()
                        }
                    }
                )
            else -> Optional.empty()
        }

    fun asObject(): Optional<Map<String, JsonValue>> =
        when (this) {
            is JsonObject -> Optional.of(values)
            is KnownValue ->
                Optional.ofNullable(
                    (value as? Map<*, *>)
                        ?.map { (key, value) ->
                            if (key !is String) {
                                return Optional.empty()
                            }

                            val jsonValue =
                                try {
                                    JsonValue.from(value)
                                } catch (e: IllegalArgumentException) {
                                    // The known value is a map, but not all items are convertible
                                    // to `JsonValue`.
                                    return Optional.empty()
                                }

                            key to jsonValue
                        }
                        ?.toMap()
                )
            else -> Optional.empty()
        }

    @JvmSynthetic
    internal fun getRequired(name: String): T =
        when (this) {
            is KnownValue -> value
            is JsonMissing -> throw OpenAIInvalidDataException("`$name` is not set")
            is JsonNull -> throw OpenAIInvalidDataException("`$name` is null")
            else -> throw OpenAIInvalidDataException("`$name` is invalid, received $this")
        }

    @JvmSynthetic
    internal fun getOptional(name: String): Optional<@UnsafeVariance T> =
        when (this) {
            is KnownValue -> Optional.of(value)
            is JsonMissing,
            is JsonNull -> Optional.empty()
            else -> throw OpenAIInvalidDataException("`$name` is invalid, received $this")
        }

    @JvmSynthetic
    internal fun <R : Any> map(transform: (T) -> R): JsonField<R> =
        when (this) {
            is KnownValue -> KnownValue.of(transform(value))
            is JsonValue -> this
        }

    @JvmSynthetic fun accept(consume: (T) -> Unit) = asKnown().ifPresent(consume)

    fun <R> accept(visitor: Visitor<T, R>): R =
        when (this) {
            is KnownValue -> visitor.visitKnown(value)
            is JsonValue -> accept(visitor as JsonValue.Visitor<R>)
        }

    interface Visitor<in T, out R> : JsonValue.Visitor<R> {
        fun visitKnown(value: T): R = visitDefault()
    }

    companion object {
        @JvmStatic fun <T : Any> of(value: T): JsonField<T> = KnownValue.of(value)

        @JvmStatic
        fun <T : Any> ofNullable(value: T?): JsonField<T> =
            when (value) {
                null -> JsonNull.of()
                else -> KnownValue.of(value)
            }
    }

    /**
     * This class is a Jackson filter that can be used to exclude missing properties from objects.
     * This filter should not be used directly and should instead use the @ExcludeMissing
     * annotation.
     */
    class IsMissing {
        override fun equals(other: Any?): Boolean = other is JsonMissing

        override fun hashCode(): Int = Objects.hash()
    }

    class Deserializer(private val type: JavaType? = null) :
        BaseDeserializer<JsonField<*>>(JsonField::class) {

        override fun createContextual(
            context: DeserializationContext,
            property: BeanProperty?,
        ): JsonDeserializer<JsonField<*>> = Deserializer(context.contextualType?.containedType(0))

        override fun ObjectCodec.deserialize(node: JsonNode): JsonField<*> =
            type?.let { tryDeserialize<Any>(node, type) }?.let { of(it) }
                ?: JsonValue.fromJsonNode(node)

        override fun getNullValue(context: DeserializationContext): JsonField<*> = JsonNull.of()
    }
}

@JsonDeserialize(using = JsonValue.Deserializer::class)
sealed class JsonValue : JsonField<Nothing>() {

    fun <R : Any> convert(type: TypeReference<R>): R? = JSON_MAPPER.convertValue(this, type)

    fun <R : Any> convert(type: Class<R>): R? = JSON_MAPPER.convertValue(this, type)

    fun <R> accept(visitor: Visitor<R>): R =
        when (this) {
            is JsonMissing -> visitor.visitMissing()
            is JsonNull -> visitor.visitNull()
            is JsonBoolean -> visitor.visitBoolean(value)
            is JsonNumber -> visitor.visitNumber(value)
            is JsonString -> visitor.visitString(value)
            is JsonArray -> visitor.visitArray(values)
            is JsonObject -> visitor.visitObject(values)
        }

    interface Visitor<out R> {
        fun visitNull(): R = visitDefault()

        fun visitMissing(): R = visitDefault()

        fun visitBoolean(value: Boolean): R = visitDefault()

        fun visitNumber(value: Number): R = visitDefault()

        fun visitString(value: String): R = visitDefault()

        fun visitArray(values: List<JsonValue>): R = visitDefault()

        fun visitObject(values: Map<String, JsonValue>): R = visitDefault()

        fun visitDefault(): R {
            throw RuntimeException("Unexpected value")
        }
    }

    companion object {

        private val JSON_MAPPER = jsonMapper()

        @JvmStatic
        fun from(value: Any?): JsonValue =
            when (value) {
                null -> JsonNull.of()
                is JsonValue -> value
                else -> JSON_MAPPER.convertValue(value, JsonValue::class.java)
            }

        @JvmStatic
        fun fromJsonNode(node: JsonNode): JsonValue =
            when (node.nodeType) {
                MISSING -> JsonMissing.of()
                NULL -> JsonNull.of()
                BOOLEAN -> JsonBoolean.of(node.booleanValue())
                NUMBER -> JsonNumber.of(node.numberValue())
                STRING -> JsonString.of(node.textValue())
                ARRAY ->
                    JsonArray.of(node.elements().asSequence().map { fromJsonNode(it) }.toList())
                OBJECT ->
                    JsonObject.of(
                        node.fields().asSequence().map { it.key to fromJsonNode(it.value) }.toMap()
                    )
                BINARY,
                POJO,
                null -> throw IllegalStateException("Unexpected JsonNode type: ${node.nodeType}")
            }
    }

    class Deserializer : BaseDeserializer<JsonValue>(JsonValue::class) {
        override fun ObjectCodec.deserialize(node: JsonNode): JsonValue = fromJsonNode(node)

        override fun getNullValue(context: DeserializationContext?): JsonValue = JsonNull.of()
    }
}

class KnownValue<T : Any>
private constructor(
    @com.fasterxml.jackson.annotation.JsonValue @get:JvmName("value") val value: T
) : JsonField<T>() {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is KnownValue<*> && value contentEquals other.value
    }

    override fun hashCode() = contentHash(value)

    override fun toString() = value.contentToString()

    companion object {
        @JsonCreator @JvmStatic fun <T : Any> of(value: T) = KnownValue(value)
    }
}

@JsonSerialize(using = JsonMissing.Serializer::class)
class JsonMissing : JsonValue() {

    override fun toString() = ""

    companion object {
        private val INSTANCE: JsonMissing = JsonMissing()

        @JvmStatic fun of() = INSTANCE
    }

    class Serializer : BaseSerializer<JsonMissing>(JsonMissing::class) {
        override fun serialize(
            value: JsonMissing,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            throw RuntimeException("JsonMissing cannot be serialized")
        }
    }
}

@JsonSerialize(using = NullSerializer::class)
class JsonNull : JsonValue() {

    override fun toString() = "null"

    companion object {
        private val INSTANCE: JsonNull = JsonNull()

        @JsonCreator @JvmStatic fun of() = INSTANCE
    }
}

class JsonBoolean
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue @get:JvmName("value") val value: Boolean
) : JsonValue() {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonBoolean && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {
        @JsonCreator @JvmStatic fun of(value: Boolean) = JsonBoolean(value)
    }
}

class JsonNumber
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue @get:JvmName("value") val value: Number
) : JsonValue() {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonNumber && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value.toString()

    companion object {
        @JsonCreator @JvmStatic fun of(value: Number) = JsonNumber(value)
    }
}

class JsonString
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue @get:JvmName("value") val value: String
) : JsonValue() {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonString && value == other.value
    }

    override fun hashCode() = value.hashCode()

    override fun toString() = value

    companion object {
        @JsonCreator @JvmStatic fun of(value: String) = JsonString(value)
    }
}

class JsonArray
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue
    @get:JvmName("values")
    val values: List<JsonValue>
) : JsonValue() {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonArray && values == other.values
    }

    override fun hashCode() = values.hashCode()

    override fun toString() = values.toString()

    companion object {
        @JsonCreator @JvmStatic fun of(values: List<JsonValue>) = JsonArray(values.toImmutable())
    }
}

class JsonObject
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue
    @get:JvmName("values")
    val values: Map<String, JsonValue>
) : JsonValue() {

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JsonObject && values == other.values
    }

    override fun hashCode() = values.hashCode()

    override fun toString() = values.toString()

    companion object {
        @JsonCreator
        @JvmStatic
        fun of(values: Map<String, JsonValue>) = JsonObject(values.toImmutable())
    }
}

@JacksonAnnotationsInside
@JsonInclude(JsonInclude.Include.CUSTOM, valueFilter = JsonField.IsMissing::class)
annotation class ExcludeMissing

class MultipartField<T : Any>
private constructor(
    @get:com.fasterxml.jackson.annotation.JsonValue @get:JvmName("value") val value: JsonField<T>,
    @get:JvmName("contentType") val contentType: String,
    private val filename: String?,
) {

    companion object {

        @JvmStatic fun <T : Any> of(value: T?) = builder<T>().value(value).build()

        @JvmStatic fun <T : Any> of(value: JsonField<T>) = builder<T>().value(value).build()

        @JvmStatic fun <T : Any> builder() = Builder<T>()
    }

    fun filename(): Optional<String> = Optional.ofNullable(filename)

    @JvmSynthetic
    internal fun <R : Any> map(transform: (T) -> R): MultipartField<R> =
        builder<R>().value(value.map(transform)).contentType(contentType).filename(filename).build()

    /** A builder for [MultipartField]. */
    class Builder<T : Any> internal constructor() {

        private var value: JsonField<T>? = null
        private var contentType: String? = null
        private var filename: String? = null

        fun value(value: JsonField<T>) = apply { this.value = value }

        fun value(value: T?) = value(JsonField.ofNullable(value))

        fun contentType(contentType: String) = apply { this.contentType = contentType }

        fun filename(filename: String?) = apply { this.filename = filename }

        fun filename(filename: Optional<String>) = filename(filename.orElse(null))

        fun build(): MultipartField<T> {
            val value = checkRequired("value", value)
            return MultipartField(
                value,
                contentType
                    ?: if (
                        value is KnownValue &&
                            (value.value is InputStream || value.value is ByteArray)
                    )
                        "application/octet-stream"
                    else "text/plain; charset=utf-8",
                filename,
            )
        }
    }

    private val hashCode: Int by lazy { contentHash(value, contentType, filename) }

    override fun hashCode(): Int = hashCode

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is MultipartField<*> &&
            value == other.value &&
            contentType == other.contentType &&
            filename == other.filename
    }

    override fun toString(): String =
        "MultipartField{value=$value, contentType=$contentType, filename=$filename}"
}
