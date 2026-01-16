// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

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
import com.openai.core.allMaxBy
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * Realtime API can write session traces to the [Traces Dashboard](/logs?api=traces). Set to null to
 * disable tracing. Once tracing is enabled for a session, the configuration cannot be modified.
 *
 * `auto` will create a trace for the session with default values for the workflow name, group id,
 * and metadata.
 */
@JsonDeserialize(using = RealtimeTracingConfig.Deserializer::class)
@JsonSerialize(using = RealtimeTracingConfig.Serializer::class)
class RealtimeTracingConfig
private constructor(
    private val auto: JsonValue? = null,
    private val tracingConfiguration: TracingConfiguration? = null,
    private val _json: JsonValue? = null,
) {

    /** Enables tracing and sets default values for tracing configuration options. Always `auto`. */
    fun auto(): Optional<JsonValue> = Optional.ofNullable(auto)

    /** Granular configuration for tracing. */
    fun tracingConfiguration(): Optional<TracingConfiguration> =
        Optional.ofNullable(tracingConfiguration)

    fun isAuto(): Boolean = auto != null

    fun isTracingConfiguration(): Boolean = tracingConfiguration != null

    /** Enables tracing and sets default values for tracing configuration options. Always `auto`. */
    fun asAuto(): JsonValue = auto.getOrThrow("auto")

    /** Granular configuration for tracing. */
    fun asTracingConfiguration(): TracingConfiguration =
        tracingConfiguration.getOrThrow("tracingConfiguration")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    fun <T> accept(visitor: Visitor<T>): T =
        when {
            auto != null -> visitor.visitAuto(auto)
            tracingConfiguration != null -> visitor.visitTracingConfiguration(tracingConfiguration)
            else -> visitor.unknown(_json)
        }

    private var validated: Boolean = false

    fun validate(): RealtimeTracingConfig = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitAuto(auto: JsonValue) {
                    auto.let {
                        if (it != JsonValue.from("auto")) {
                            throw OpenAIInvalidDataException("'auto' is invalid, received $it")
                        }
                    }
                }

                override fun visitTracingConfiguration(tracingConfiguration: TracingConfiguration) {
                    tracingConfiguration.validate()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        accept(
            object : Visitor<Int> {
                override fun visitAuto(auto: JsonValue) =
                    auto.let { if (it == JsonValue.from("auto")) 1 else 0 }

                override fun visitTracingConfiguration(tracingConfiguration: TracingConfiguration) =
                    tracingConfiguration.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RealtimeTracingConfig &&
            auto == other.auto &&
            tracingConfiguration == other.tracingConfiguration
    }

    override fun hashCode(): Int = Objects.hash(auto, tracingConfiguration)

    override fun toString(): String =
        when {
            auto != null -> "RealtimeTracingConfig{auto=$auto}"
            tracingConfiguration != null ->
                "RealtimeTracingConfig{tracingConfiguration=$tracingConfiguration}"
            _json != null -> "RealtimeTracingConfig{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid RealtimeTracingConfig")
        }

    companion object {

        /**
         * Enables tracing and sets default values for tracing configuration options. Always `auto`.
         */
        @JvmStatic fun ofAuto() = RealtimeTracingConfig(auto = JsonValue.from("auto"))

        /** Granular configuration for tracing. */
        @JvmStatic
        fun ofTracingConfiguration(tracingConfiguration: TracingConfiguration) =
            RealtimeTracingConfig(tracingConfiguration = tracingConfiguration)
    }

    /**
     * An interface that defines how to map each variant of [RealtimeTracingConfig] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        /**
         * Enables tracing and sets default values for tracing configuration options. Always `auto`.
         */
        fun visitAuto(auto: JsonValue): T

        /** Granular configuration for tracing. */
        fun visitTracingConfiguration(tracingConfiguration: TracingConfiguration): T

        /**
         * Maps an unknown variant of [RealtimeTracingConfig] to a value of type [T].
         *
         * An instance of [RealtimeTracingConfig] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown RealtimeTracingConfig: $json")
        }
    }

    internal class Deserializer :
        BaseDeserializer<RealtimeTracingConfig>(RealtimeTracingConfig::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): RealtimeTracingConfig {
            val json = JsonValue.fromJsonNode(node)

            val bestMatches =
                sequenceOf(
                        tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { RealtimeTracingConfig(auto = it, _json = json) }
                            ?.takeIf { it.isValid() },
                        tryDeserialize(node, jacksonTypeRef<TracingConfiguration>())?.let {
                            RealtimeTracingConfig(tracingConfiguration = it, _json = json)
                        },
                    )
                    .filterNotNull()
                    .allMaxBy { it.validity() }
                    .toList()
            return when (bestMatches.size) {
                // This can happen if what we're deserializing is completely incompatible with all
                // the possible variants (e.g. deserializing from boolean).
                0 -> RealtimeTracingConfig(_json = json)
                1 -> bestMatches.single()
                // If there's more than one match with the highest validity, then use the first
                // completely valid match, or simply the first match if none are completely valid.
                else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
            }
        }
    }

    internal class Serializer :
        BaseSerializer<RealtimeTracingConfig>(RealtimeTracingConfig::class) {

        override fun serialize(
            value: RealtimeTracingConfig,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.auto != null -> generator.writeObject(value.auto)
                value.tracingConfiguration != null ->
                    generator.writeObject(value.tracingConfiguration)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid RealtimeTracingConfig")
            }
        }
    }

    /** Granular configuration for tracing. */
    class TracingConfiguration
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val groupId: JsonField<String>,
        private val metadata: JsonValue,
        private val workflowName: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("group_id") @ExcludeMissing groupId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("metadata") @ExcludeMissing metadata: JsonValue = JsonMissing.of(),
            @JsonProperty("workflow_name")
            @ExcludeMissing
            workflowName: JsonField<String> = JsonMissing.of(),
        ) : this(groupId, metadata, workflowName, mutableMapOf())

        /**
         * The group id to attach to this trace to enable filtering and grouping in the Traces
         * Dashboard.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun groupId(): Optional<String> = groupId.getOptional("group_id")

        /**
         * The arbitrary metadata to attach to this trace to enable filtering in the Traces
         * Dashboard.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonValue = metadata

        /**
         * The name of the workflow to attach to this trace. This is used to name the trace in the
         * Traces Dashboard.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun workflowName(): Optional<String> = workflowName.getOptional("workflow_name")

        /**
         * Returns the raw JSON value of [groupId].
         *
         * Unlike [groupId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("group_id") @ExcludeMissing fun _groupId(): JsonField<String> = groupId

        /**
         * Returns the raw JSON value of [workflowName].
         *
         * Unlike [workflowName], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("workflow_name")
        @ExcludeMissing
        fun _workflowName(): JsonField<String> = workflowName

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

            /** Returns a mutable builder for constructing an instance of [TracingConfiguration]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [TracingConfiguration]. */
        class Builder internal constructor() {

            private var groupId: JsonField<String> = JsonMissing.of()
            private var metadata: JsonValue = JsonMissing.of()
            private var workflowName: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(tracingConfiguration: TracingConfiguration) = apply {
                groupId = tracingConfiguration.groupId
                metadata = tracingConfiguration.metadata
                workflowName = tracingConfiguration.workflowName
                additionalProperties = tracingConfiguration.additionalProperties.toMutableMap()
            }

            /**
             * The group id to attach to this trace to enable filtering and grouping in the Traces
             * Dashboard.
             */
            fun groupId(groupId: String) = groupId(JsonField.of(groupId))

            /**
             * Sets [Builder.groupId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.groupId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun groupId(groupId: JsonField<String>) = apply { this.groupId = groupId }

            /**
             * The arbitrary metadata to attach to this trace to enable filtering in the Traces
             * Dashboard.
             */
            fun metadata(metadata: JsonValue) = apply { this.metadata = metadata }

            /**
             * The name of the workflow to attach to this trace. This is used to name the trace in
             * the Traces Dashboard.
             */
            fun workflowName(workflowName: String) = workflowName(JsonField.of(workflowName))

            /**
             * Sets [Builder.workflowName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workflowName] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workflowName(workflowName: JsonField<String>) = apply {
                this.workflowName = workflowName
            }

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
             * Returns an immutable instance of [TracingConfiguration].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): TracingConfiguration =
                TracingConfiguration(
                    groupId,
                    metadata,
                    workflowName,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): TracingConfiguration = apply {
            if (validated) {
                return@apply
            }

            groupId()
            workflowName()
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
            (if (groupId.asKnown().isPresent) 1 else 0) +
                (if (workflowName.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is TracingConfiguration &&
                groupId == other.groupId &&
                metadata == other.metadata &&
                workflowName == other.workflowName &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(groupId, metadata, workflowName, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "TracingConfiguration{groupId=$groupId, metadata=$metadata, workflowName=$workflowName, additionalProperties=$additionalProperties}"
    }
}
