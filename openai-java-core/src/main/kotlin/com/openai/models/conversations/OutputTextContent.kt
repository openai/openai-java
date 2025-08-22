// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.ObjectCodec
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.BaseDeserializer
import com.openai.core.BaseSerializer
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class OutputTextContent
private constructor(
    private val annotations: JsonField<List<Annotation>>,
    private val text: JsonField<String>,
    private val type: JsonValue,
    private val logprobs: JsonField<List<LobProb>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("annotations")
        @ExcludeMissing
        annotations: JsonField<List<Annotation>> = JsonMissing.of(),
        @JsonProperty("text") @ExcludeMissing text: JsonField<String> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("logprobs")
        @ExcludeMissing
        logprobs: JsonField<List<LobProb>> = JsonMissing.of(),
    ) : this(annotations, text, type, logprobs, mutableMapOf())

    /**
     * The annotations of the text output.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun annotations(): List<Annotation> = annotations.getRequired("annotations")

    /**
     * The text output from the model.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun text(): String = text.getRequired("text")

    /**
     * The type of the output text. Always `output_text`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("output_text")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logprobs(): Optional<List<LobProb>> = logprobs.getOptional("logprobs")

    /**
     * Returns the raw JSON value of [annotations].
     *
     * Unlike [annotations], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("annotations")
    @ExcludeMissing
    fun _annotations(): JsonField<List<Annotation>> = annotations

    /**
     * Returns the raw JSON value of [text].
     *
     * Unlike [text], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("text") @ExcludeMissing fun _text(): JsonField<String> = text

    /**
     * Returns the raw JSON value of [logprobs].
     *
     * Unlike [logprobs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logprobs") @ExcludeMissing fun _logprobs(): JsonField<List<LobProb>> = logprobs

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
         * Returns a mutable builder for constructing an instance of [OutputTextContent].
         *
         * The following fields are required:
         * ```java
         * .annotations()
         * .text()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [OutputTextContent]. */
    class Builder internal constructor() {

        private var annotations: JsonField<MutableList<Annotation>>? = null
        private var text: JsonField<String>? = null
        private var type: JsonValue = JsonValue.from("output_text")
        private var logprobs: JsonField<MutableList<LobProb>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(outputTextContent: OutputTextContent) = apply {
            annotations = outputTextContent.annotations.map { it.toMutableList() }
            text = outputTextContent.text
            type = outputTextContent.type
            logprobs = outputTextContent.logprobs.map { it.toMutableList() }
            additionalProperties = outputTextContent.additionalProperties.toMutableMap()
        }

        /** The annotations of the text output. */
        fun annotations(annotations: List<Annotation>) = annotations(JsonField.of(annotations))

        /**
         * Sets [Builder.annotations] to an arbitrary JSON value.
         *
         * You should usually call [Builder.annotations] with a well-typed `List<Annotation>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun annotations(annotations: JsonField<List<Annotation>>) = apply {
            this.annotations = annotations.map { it.toMutableList() }
        }

        /**
         * Adds a single [Annotation] to [annotations].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAnnotation(annotation: Annotation) = apply {
            annotations =
                (annotations ?: JsonField.of(mutableListOf())).also {
                    checkKnown("annotations", it).add(annotation)
                }
        }

        /** Alias for calling [addAnnotation] with `Annotation.ofFileCitation(fileCitation)`. */
        fun addAnnotation(fileCitation: FileCitationBody) =
            addAnnotation(Annotation.ofFileCitation(fileCitation))

        /** Alias for calling [addAnnotation] with `Annotation.ofUrlCitation(urlCitation)`. */
        fun addAnnotation(urlCitation: UrlCitationBody) =
            addAnnotation(Annotation.ofUrlCitation(urlCitation))

        /**
         * Alias for calling [addAnnotation] with
         * `Annotation.ofContainerFileCitation(containerFileCitation)`.
         */
        fun addAnnotation(containerFileCitation: ContainerFileCitationBody) =
            addAnnotation(Annotation.ofContainerFileCitation(containerFileCitation))

        /** The text output from the model. */
        fun text(text: String) = text(JsonField.of(text))

        /**
         * Sets [Builder.text] to an arbitrary JSON value.
         *
         * You should usually call [Builder.text] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun text(text: JsonField<String>) = apply { this.text = text }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("output_text")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        fun logprobs(logprobs: List<LobProb>) = logprobs(JsonField.of(logprobs))

        /**
         * Sets [Builder.logprobs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logprobs] with a well-typed `List<LobProb>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun logprobs(logprobs: JsonField<List<LobProb>>) = apply {
            this.logprobs = logprobs.map { it.toMutableList() }
        }

        /**
         * Adds a single [LobProb] to [logprobs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLogprob(logprob: LobProb) = apply {
            logprobs =
                (logprobs ?: JsonField.of(mutableListOf())).also {
                    checkKnown("logprobs", it).add(logprob)
                }
        }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAlladditional_properties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAlladditional_properties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAlladditional_properties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [OutputTextContent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .annotations()
         * .text()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): OutputTextContent =
            OutputTextContent(
                checkRequired("annotations", annotations).map { it.toImmutable() },
                checkRequired("text", text),
                type,
                (logprobs ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): OutputTextContent = apply {
        if (validated) {
            return@apply
        }

        annotations().forEach { it.validate() }
        text()
        _type().let {
            if (it != JsonValue.from("output_text")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        logprobs().ifPresent { it.forEach { it.validate() } }
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
        (annotations.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (text.asKnown().isPresent) 1 else 0) +
            type.let { if (it == JsonValue.from("output_text")) 1 else 0 } +
            (logprobs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    @JsonDeserialize(using = Annotation.Deserializer::class)
    @JsonSerialize(using = Annotation.Serializer::class)
    class Annotation
    private constructor(
        private val fileCitation: FileCitationBody? = null,
        private val urlCitation: UrlCitationBody? = null,
        private val containerFileCitation: ContainerFileCitationBody? = null,
        private val _json: JsonValue? = null,
    ) {

        fun fileCitation(): Optional<FileCitationBody> = Optional.ofNullable(fileCitation)

        fun urlCitation(): Optional<UrlCitationBody> = Optional.ofNullable(urlCitation)

        fun containerFileCitation(): Optional<ContainerFileCitationBody> =
            Optional.ofNullable(containerFileCitation)

        fun isFileCitation(): Boolean = fileCitation != null

        fun isUrlCitation(): Boolean = urlCitation != null

        fun isContainerFileCitation(): Boolean = containerFileCitation != null

        fun asFileCitation(): FileCitationBody = fileCitation.getOrThrow("fileCitation")

        fun asUrlCitation(): UrlCitationBody = urlCitation.getOrThrow("urlCitation")

        fun asContainerFileCitation(): ContainerFileCitationBody =
            containerFileCitation.getOrThrow("containerFileCitation")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                fileCitation != null -> visitor.visitFileCitation(fileCitation)
                urlCitation != null -> visitor.visitUrlCitation(urlCitation)
                containerFileCitation != null ->
                    visitor.visitContainerFileCitation(containerFileCitation)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Annotation = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitFileCitation(fileCitation: FileCitationBody) {
                        fileCitation.validate()
                    }

                    override fun visitUrlCitation(urlCitation: UrlCitationBody) {
                        urlCitation.validate()
                    }

                    override fun visitContainerFileCitation(
                        containerFileCitation: ContainerFileCitationBody
                    ) {
                        containerFileCitation.validate()
                    }
                }
            )
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
            accept(
                object : Visitor<Int> {
                    override fun visitFileCitation(fileCitation: FileCitationBody) =
                        fileCitation.validity()

                    override fun visitUrlCitation(urlCitation: UrlCitationBody) =
                        urlCitation.validity()

                    override fun visitContainerFileCitation(
                        containerFileCitation: ContainerFileCitationBody
                    ) = containerFileCitation.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Annotation &&
                fileCitation == other.fileCitation &&
                urlCitation == other.urlCitation &&
                containerFileCitation == other.containerFileCitation
        }

        override fun hashCode(): Int =
            Objects.hash(fileCitation, urlCitation, containerFileCitation)

        override fun toString(): String =
            when {
                fileCitation != null -> "Annotation{fileCitation=$fileCitation}"
                urlCitation != null -> "Annotation{urlCitation=$urlCitation}"
                containerFileCitation != null ->
                    "Annotation{containerFileCitation=$containerFileCitation}"
                _json != null -> "Annotation{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Annotation")
            }

        companion object {

            @JvmStatic
            fun ofFileCitation(fileCitation: FileCitationBody) =
                Annotation(fileCitation = fileCitation)

            @JvmStatic
            fun ofUrlCitation(urlCitation: UrlCitationBody) = Annotation(urlCitation = urlCitation)

            @JvmStatic
            fun ofContainerFileCitation(containerFileCitation: ContainerFileCitationBody) =
                Annotation(containerFileCitation = containerFileCitation)
        }

        /**
         * An interface that defines how to map each variant of [Annotation] to a value of type [T].
         */
        interface Visitor<out T> {

            fun visitFileCitation(fileCitation: FileCitationBody): T

            fun visitUrlCitation(urlCitation: UrlCitationBody): T

            fun visitContainerFileCitation(containerFileCitation: ContainerFileCitationBody): T

            /**
             * Maps an unknown variant of [Annotation] to a value of type [T].
             *
             * An instance of [Annotation] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
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
                        return tryDeserialize(node, jacksonTypeRef<FileCitationBody>())?.let {
                            Annotation(fileCitation = it, _json = json)
                        } ?: Annotation(_json = json)
                    }
                    "url_citation" -> {
                        return tryDeserialize(node, jacksonTypeRef<UrlCitationBody>())?.let {
                            Annotation(urlCitation = it, _json = json)
                        } ?: Annotation(_json = json)
                    }
                    "container_file_citation" -> {
                        return tryDeserialize(node, jacksonTypeRef<ContainerFileCitationBody>())
                            ?.let { Annotation(containerFileCitation = it, _json = json) }
                            ?: Annotation(_json = json)
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
                    value.urlCitation != null -> generator.writeObject(value.urlCitation)
                    value.containerFileCitation != null ->
                        generator.writeObject(value.containerFileCitation)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Annotation")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OutputTextContent &&
            annotations == other.annotations &&
            text == other.text &&
            type == other.type &&
            logprobs == other.logprobs &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(annotations, text, type, logprobs, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "OutputTextContent{annotations=$annotations, text=$text, type=$type, logprobs=$logprobs, additionalProperties=$additionalProperties}"
}
