// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** A file input to the model. */
class ResponseInputFile
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val detail: JsonField<Detail>,
    private val fileData: JsonField<String>,
    private val fileId: JsonField<String>,
    private val fileUrl: JsonField<String>,
    private val filename: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("detail") @ExcludeMissing detail: JsonField<Detail> = JsonMissing.of(),
        @JsonProperty("file_data") @ExcludeMissing fileData: JsonField<String> = JsonMissing.of(),
        @JsonProperty("file_id") @ExcludeMissing fileId: JsonField<String> = JsonMissing.of(),
        @JsonProperty("file_url") @ExcludeMissing fileUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("filename") @ExcludeMissing filename: JsonField<String> = JsonMissing.of(),
    ) : this(type, detail, fileData, fileId, fileUrl, filename, mutableMapOf())

    /**
     * The type of the input item. Always `input_file`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("input_file")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * The detail level of the file to be sent to the model. Use `low` for the default rendering
     * behavior, or `high` to render the file at higher quality. Defaults to `low`.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun detail(): Optional<Detail> = detail.getOptional("detail")

    /**
     * The content of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileData(): Optional<String> = fileData.getOptional("file_data")

    /**
     * The ID of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileId(): Optional<String> = fileId.getOptional("file_id")

    /**
     * The URL of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileUrl(): Optional<String> = fileUrl.getOptional("file_url")

    /**
     * The name of the file to be sent to the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun filename(): Optional<String> = filename.getOptional("filename")

    /**
     * Returns the raw JSON value of [detail].
     *
     * Unlike [detail], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("detail") @ExcludeMissing fun _detail(): JsonField<Detail> = detail

    /**
     * Returns the raw JSON value of [fileData].
     *
     * Unlike [fileData], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_data") @ExcludeMissing fun _fileData(): JsonField<String> = fileData

    /**
     * Returns the raw JSON value of [fileId].
     *
     * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

    /**
     * Returns the raw JSON value of [fileUrl].
     *
     * Unlike [fileUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_url") @ExcludeMissing fun _fileUrl(): JsonField<String> = fileUrl

    /**
     * Returns the raw JSON value of [filename].
     *
     * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [ResponseInputFile]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseInputFile]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("input_file")
        private var detail: JsonField<Detail> = JsonMissing.of()
        private var fileData: JsonField<String> = JsonMissing.of()
        private var fileId: JsonField<String> = JsonMissing.of()
        private var fileUrl: JsonField<String> = JsonMissing.of()
        private var filename: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseInputFile: ResponseInputFile) = apply {
            type = responseInputFile.type
            detail = responseInputFile.detail
            fileData = responseInputFile.fileData
            fileId = responseInputFile.fileId
            fileUrl = responseInputFile.fileUrl
            filename = responseInputFile.filename
            additionalProperties = responseInputFile.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("input_file")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /**
         * The detail level of the file to be sent to the model. Use `low` for the default rendering
         * behavior, or `high` to render the file at higher quality. Defaults to `low`.
         */
        fun detail(detail: Detail) = detail(JsonField.of(detail))

        /**
         * Sets [Builder.detail] to an arbitrary JSON value.
         *
         * You should usually call [Builder.detail] with a well-typed [Detail] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun detail(detail: JsonField<Detail>) = apply { this.detail = detail }

        /** The content of the file to be sent to the model. */
        fun fileData(fileData: String) = fileData(JsonField.of(fileData))

        /**
         * Sets [Builder.fileData] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileData] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileData(fileData: JsonField<String>) = apply { this.fileData = fileData }

        /** The ID of the file to be sent to the model. */
        fun fileId(fileId: String?) = fileId(JsonField.ofNullable(fileId))

        /** Alias for calling [Builder.fileId] with `fileId.orElse(null)`. */
        fun fileId(fileId: Optional<String>) = fileId(fileId.getOrNull())

        /**
         * Sets [Builder.fileId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

        /** The URL of the file to be sent to the model. */
        fun fileUrl(fileUrl: String) = fileUrl(JsonField.of(fileUrl))

        /**
         * Sets [Builder.fileUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fileUrl(fileUrl: JsonField<String>) = apply { this.fileUrl = fileUrl }

        /** The name of the file to be sent to the model. */
        fun filename(filename: String) = filename(JsonField.of(filename))

        /**
         * Sets [Builder.filename] to an arbitrary JSON value.
         *
         * You should usually call [Builder.filename] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun filename(filename: JsonField<String>) = apply { this.filename = filename }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [ResponseInputFile].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ResponseInputFile =
            ResponseInputFile(
                type,
                detail,
                fileData,
                fileId,
                fileUrl,
                filename,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseInputFile = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("input_file")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        detail().ifPresent { it.validate() }
        fileData()
        fileId()
        fileUrl()
        filename()
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
        type.let { if (it == JsonValue.from("input_file")) 1 else 0 } +
            (detail.asKnown().getOrNull()?.validity() ?: 0) +
            (if (fileData.asKnown().isPresent) 1 else 0) +
            (if (fileId.asKnown().isPresent) 1 else 0) +
            (if (fileUrl.asKnown().isPresent) 1 else 0) +
            (if (filename.asKnown().isPresent) 1 else 0)

    /**
     * The detail level of the file to be sent to the model. Use `low` for the default rendering
     * behavior, or `high` to render the file at higher quality. Defaults to `low`.
     */
    class Detail @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val LOW = of("low")

            @JvmField val HIGH = of("high")

            @JvmStatic fun of(value: String) = Detail(JsonField.of(value))
        }

        /** An enum containing [Detail]'s known values. */
        enum class Known {
            LOW,
            HIGH,
        }

        /**
         * An enum containing [Detail]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Detail] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            LOW,
            HIGH,
            /** An enum member indicating that [Detail] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                LOW -> Value.LOW
                HIGH -> Value.HIGH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws OpenAIInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                LOW -> Known.LOW
                HIGH -> Known.HIGH
                else -> throw OpenAIInvalidDataException("Unknown Detail: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws OpenAIInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow { OpenAIInvalidDataException("Value is not a String") }

        private var validated: Boolean = false

        fun validate(): Detail = apply {
            if (validated) {
                return@apply
            }

            known()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Detail && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseInputFile &&
            type == other.type &&
            detail == other.detail &&
            fileData == other.fileData &&
            fileId == other.fileId &&
            fileUrl == other.fileUrl &&
            filename == other.filename &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, detail, fileData, fileId, fileUrl, filename, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseInputFile{type=$type, detail=$detail, fileData=$fileData, fileId=$fileId, fileUrl=$fileUrl, filename=$filename, additionalProperties=$additionalProperties}"
}
