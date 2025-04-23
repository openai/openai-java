// File generated from our OpenAPI spec by Stainless.

package com.openai.models.images

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The response from the image generation endpoint. */
class ImagesResponse
private constructor(
    private val created: JsonField<Long>,
    private val data: JsonField<List<Image>>,
    private val usage: JsonField<Usage>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("created") @ExcludeMissing created: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<List<Image>> = JsonMissing.of(),
        @JsonProperty("usage") @ExcludeMissing usage: JsonField<Usage> = JsonMissing.of(),
    ) : this(created, data, usage, mutableMapOf())

    /**
     * The Unix timestamp (in seconds) of when the image was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun created(): Long = created.getRequired("created")

    /**
     * The list of generated images.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<List<Image>> = data.getOptional("data")

    /**
     * For `gpt-image-1` only, the token usage information for the image generation.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun usage(): Optional<Usage> = usage.getOptional("usage")

    /**
     * Returns the raw JSON value of [created].
     *
     * Unlike [created], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created") @ExcludeMissing fun _created(): JsonField<Long> = created

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<List<Image>> = data

    /**
     * Returns the raw JSON value of [usage].
     *
     * Unlike [usage], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("usage") @ExcludeMissing fun _usage(): JsonField<Usage> = usage

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

        /**
         * Returns a mutable builder for constructing an instance of [ImagesResponse].
         *
         * The following fields are required:
         * ```java
         * .created()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ImagesResponse]. */
    class Builder internal constructor() {

        private var created: JsonField<Long>? = null
        private var data: JsonField<MutableList<Image>>? = null
        private var usage: JsonField<Usage> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(imagesResponse: ImagesResponse) = apply {
            created = imagesResponse.created
            data = imagesResponse.data.map { it.toMutableList() }
            usage = imagesResponse.usage
            additionalProperties = imagesResponse.additionalProperties.toMutableMap()
        }

        /** The Unix timestamp (in seconds) of when the image was created. */
        fun created(created: Long) = created(JsonField.of(created))

        /**
         * Sets [Builder.created] to an arbitrary JSON value.
         *
         * You should usually call [Builder.created] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun created(created: JsonField<Long>) = apply { this.created = created }

        /** The list of generated images. */
        fun data(data: List<Image>) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed `List<Image>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun data(data: JsonField<List<Image>>) = apply {
            this.data = data.map { it.toMutableList() }
        }

        /**
         * Adds a single [Image] to [Builder.data].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addData(data: Image) = apply {
            this.data =
                (this.data ?: JsonField.of(mutableListOf())).also {
                    checkKnown("data", it).add(data)
                }
        }

        /** For `gpt-image-1` only, the token usage information for the image generation. */
        fun usage(usage: Usage) = usage(JsonField.of(usage))

        /**
         * Sets [Builder.usage] to an arbitrary JSON value.
         *
         * You should usually call [Builder.usage] with a well-typed [Usage] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun usage(usage: JsonField<Usage>) = apply { this.usage = usage }

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
         * Returns an immutable instance of [ImagesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .created()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ImagesResponse =
            ImagesResponse(
                checkRequired("created", created),
                (data ?: JsonMissing.of()).map { it.toImmutable() },
                usage,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ImagesResponse = apply {
        if (validated) {
            return@apply
        }

        created()
        data().ifPresent { it.forEach { it.validate() } }
        usage().ifPresent { it.validate() }
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
        (if (created.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (usage.asKnown().getOrNull()?.validity() ?: 0)

    /** For `gpt-image-1` only, the token usage information for the image generation. */
    class Usage
    private constructor(
        private val inputTokens: JsonField<Long>,
        private val inputTokensDetails: JsonField<InputTokensDetails>,
        private val outputTokens: JsonField<Long>,
        private val totalTokens: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("input_tokens")
            @ExcludeMissing
            inputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("input_tokens_details")
            @ExcludeMissing
            inputTokensDetails: JsonField<InputTokensDetails> = JsonMissing.of(),
            @JsonProperty("output_tokens")
            @ExcludeMissing
            outputTokens: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("total_tokens")
            @ExcludeMissing
            totalTokens: JsonField<Long> = JsonMissing.of(),
        ) : this(inputTokens, inputTokensDetails, outputTokens, totalTokens, mutableMapOf())

        /**
         * The number of tokens (images and text) in the input prompt.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokens(): Long = inputTokens.getRequired("input_tokens")

        /**
         * The input tokens detailed information for the image generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun inputTokensDetails(): InputTokensDetails =
            inputTokensDetails.getRequired("input_tokens_details")

        /**
         * The number of image tokens in the output image.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun outputTokens(): Long = outputTokens.getRequired("output_tokens")

        /**
         * The total number of tokens (images and text) used for the image generation.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun totalTokens(): Long = totalTokens.getRequired("total_tokens")

        /**
         * Returns the raw JSON value of [inputTokens].
         *
         * Unlike [inputTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("input_tokens")
        @ExcludeMissing
        fun _inputTokens(): JsonField<Long> = inputTokens

        /**
         * Returns the raw JSON value of [inputTokensDetails].
         *
         * Unlike [inputTokensDetails], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("input_tokens_details")
        @ExcludeMissing
        fun _inputTokensDetails(): JsonField<InputTokensDetails> = inputTokensDetails

        /**
         * Returns the raw JSON value of [outputTokens].
         *
         * Unlike [outputTokens], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("output_tokens")
        @ExcludeMissing
        fun _outputTokens(): JsonField<Long> = outputTokens

        /**
         * Returns the raw JSON value of [totalTokens].
         *
         * Unlike [totalTokens], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_tokens")
        @ExcludeMissing
        fun _totalTokens(): JsonField<Long> = totalTokens

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

            /**
             * Returns a mutable builder for constructing an instance of [Usage].
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .totalTokens()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Usage]. */
        class Builder internal constructor() {

            private var inputTokens: JsonField<Long>? = null
            private var inputTokensDetails: JsonField<InputTokensDetails>? = null
            private var outputTokens: JsonField<Long>? = null
            private var totalTokens: JsonField<Long>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(usage: Usage) = apply {
                inputTokens = usage.inputTokens
                inputTokensDetails = usage.inputTokensDetails
                outputTokens = usage.outputTokens
                totalTokens = usage.totalTokens
                additionalProperties = usage.additionalProperties.toMutableMap()
            }

            /** The number of tokens (images and text) in the input prompt. */
            fun inputTokens(inputTokens: Long) = inputTokens(JsonField.of(inputTokens))

            /**
             * Sets [Builder.inputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun inputTokens(inputTokens: JsonField<Long>) = apply { this.inputTokens = inputTokens }

            /** The input tokens detailed information for the image generation. */
            fun inputTokensDetails(inputTokensDetails: InputTokensDetails) =
                inputTokensDetails(JsonField.of(inputTokensDetails))

            /**
             * Sets [Builder.inputTokensDetails] to an arbitrary JSON value.
             *
             * You should usually call [Builder.inputTokensDetails] with a well-typed
             * [InputTokensDetails] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun inputTokensDetails(inputTokensDetails: JsonField<InputTokensDetails>) = apply {
                this.inputTokensDetails = inputTokensDetails
            }

            /** The number of image tokens in the output image. */
            fun outputTokens(outputTokens: Long) = outputTokens(JsonField.of(outputTokens))

            /**
             * Sets [Builder.outputTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.outputTokens] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun outputTokens(outputTokens: JsonField<Long>) = apply {
                this.outputTokens = outputTokens
            }

            /** The total number of tokens (images and text) used for the image generation. */
            fun totalTokens(totalTokens: Long) = totalTokens(JsonField.of(totalTokens))

            /**
             * Sets [Builder.totalTokens] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalTokens] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalTokens(totalTokens: JsonField<Long>) = apply { this.totalTokens = totalTokens }

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
             * Returns an immutable instance of [Usage].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .inputTokens()
             * .inputTokensDetails()
             * .outputTokens()
             * .totalTokens()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Usage =
                Usage(
                    checkRequired("inputTokens", inputTokens),
                    checkRequired("inputTokensDetails", inputTokensDetails),
                    checkRequired("outputTokens", outputTokens),
                    checkRequired("totalTokens", totalTokens),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Usage = apply {
            if (validated) {
                return@apply
            }

            inputTokens()
            inputTokensDetails().validate()
            outputTokens()
            totalTokens()
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
        @JvmSynthetic
        internal fun validity(): Int =
            (if (inputTokens.asKnown().isPresent) 1 else 0) +
                (inputTokensDetails.asKnown().getOrNull()?.validity() ?: 0) +
                (if (outputTokens.asKnown().isPresent) 1 else 0) +
                (if (totalTokens.asKnown().isPresent) 1 else 0)

        /** The input tokens detailed information for the image generation. */
        class InputTokensDetails
        private constructor(
            private val imageTokens: JsonField<Long>,
            private val textTokens: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("image_tokens")
                @ExcludeMissing
                imageTokens: JsonField<Long> = JsonMissing.of(),
                @JsonProperty("text_tokens")
                @ExcludeMissing
                textTokens: JsonField<Long> = JsonMissing.of(),
            ) : this(imageTokens, textTokens, mutableMapOf())

            /**
             * The number of image tokens in the input prompt.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun imageTokens(): Long = imageTokens.getRequired("image_tokens")

            /**
             * The number of text tokens in the input prompt.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun textTokens(): Long = textTokens.getRequired("text_tokens")

            /**
             * Returns the raw JSON value of [imageTokens].
             *
             * Unlike [imageTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("image_tokens")
            @ExcludeMissing
            fun _imageTokens(): JsonField<Long> = imageTokens

            /**
             * Returns the raw JSON value of [textTokens].
             *
             * Unlike [textTokens], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("text_tokens")
            @ExcludeMissing
            fun _textTokens(): JsonField<Long> = textTokens

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

                /**
                 * Returns a mutable builder for constructing an instance of [InputTokensDetails].
                 *
                 * The following fields are required:
                 * ```java
                 * .imageTokens()
                 * .textTokens()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [InputTokensDetails]. */
            class Builder internal constructor() {

                private var imageTokens: JsonField<Long>? = null
                private var textTokens: JsonField<Long>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(inputTokensDetails: InputTokensDetails) = apply {
                    imageTokens = inputTokensDetails.imageTokens
                    textTokens = inputTokensDetails.textTokens
                    additionalProperties = inputTokensDetails.additionalProperties.toMutableMap()
                }

                /** The number of image tokens in the input prompt. */
                fun imageTokens(imageTokens: Long) = imageTokens(JsonField.of(imageTokens))

                /**
                 * Sets [Builder.imageTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.imageTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun imageTokens(imageTokens: JsonField<Long>) = apply {
                    this.imageTokens = imageTokens
                }

                /** The number of text tokens in the input prompt. */
                fun textTokens(textTokens: Long) = textTokens(JsonField.of(textTokens))

                /**
                 * Sets [Builder.textTokens] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.textTokens] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun textTokens(textTokens: JsonField<Long>) = apply { this.textTokens = textTokens }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [InputTokensDetails].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .imageTokens()
                 * .textTokens()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): InputTokensDetails =
                    InputTokensDetails(
                        checkRequired("imageTokens", imageTokens),
                        checkRequired("textTokens", textTokens),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): InputTokensDetails = apply {
                if (validated) {
                    return@apply
                }

                imageTokens()
                textTokens()
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
            @JvmSynthetic
            internal fun validity(): Int =
                (if (imageTokens.asKnown().isPresent) 1 else 0) +
                    (if (textTokens.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is InputTokensDetails && imageTokens == other.imageTokens && textTokens == other.textTokens && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(imageTokens, textTokens, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "InputTokensDetails{imageTokens=$imageTokens, textTokens=$textTokens, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Usage && inputTokens == other.inputTokens && inputTokensDetails == other.inputTokensDetails && outputTokens == other.outputTokens && totalTokens == other.totalTokens && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(inputTokens, inputTokensDetails, outputTokens, totalTokens, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Usage{inputTokens=$inputTokens, inputTokensDetails=$inputTokensDetails, outputTokens=$outputTokens, totalTokens=$totalTokens, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ImagesResponse && created == other.created && data == other.data && usage == other.usage && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(created, data, usage, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ImagesResponse{created=$created, data=$data, usage=$usage, additionalProperties=$additionalProperties}"
}
