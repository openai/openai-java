// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

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
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Control which Live events an untrusted WebRTC frontend can send and receive over its data
 * channel. These restrictions do not apply to trusted sideband connections.
 */
class DataChannelConfig
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val allowedClientEvents: JsonField<AllowedClientEvents>,
    private val allowedServerEvents: JsonField<AllowedServerEvents>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("allowed_client_events")
        @ExcludeMissing
        allowedClientEvents: JsonField<AllowedClientEvents> = JsonMissing.of(),
        @JsonProperty("allowed_server_events")
        @ExcludeMissing
        allowedServerEvents: JsonField<AllowedServerEvents> = JsonMissing.of(),
    ) : this(allowedClientEvents, allowedServerEvents, mutableMapOf())

    /**
     * Client event types that the frontend data channel may send. Use 'all' to allow every client
     * event; an empty array allows none. Omission preserves the existing allow-all behavior.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedClientEvents(): Optional<AllowedClientEvents> =
        allowedClientEvents.getOptional("allowed_client_events")

    /**
     * Server events that may be sent to the frontend data channel. Use 'all' to allow every server
     * event; an empty array allows none. Omission preserves the existing allow-all behavior.
     * Responses events use an object with type 'response.event' and a response_event selector.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedServerEvents(): Optional<AllowedServerEvents> =
        allowedServerEvents.getOptional("allowed_server_events")

    /**
     * Returns the raw JSON value of [allowedClientEvents].
     *
     * Unlike [allowedClientEvents], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allowed_client_events")
    @ExcludeMissing
    fun _allowedClientEvents(): JsonField<AllowedClientEvents> = allowedClientEvents

    /**
     * Returns the raw JSON value of [allowedServerEvents].
     *
     * Unlike [allowedServerEvents], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("allowed_server_events")
    @ExcludeMissing
    fun _allowedServerEvents(): JsonField<AllowedServerEvents> = allowedServerEvents

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

        /** Returns a mutable builder for constructing an instance of [DataChannelConfig]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [DataChannelConfig]. */
    class Builder internal constructor() {

        private var allowedClientEvents: JsonField<AllowedClientEvents> = JsonMissing.of()
        private var allowedServerEvents: JsonField<AllowedServerEvents> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(dataChannelConfig: DataChannelConfig) = apply {
            allowedClientEvents = dataChannelConfig.allowedClientEvents
            allowedServerEvents = dataChannelConfig.allowedServerEvents
            additionalProperties = dataChannelConfig.additionalProperties.toMutableMap()
        }

        /**
         * Client event types that the frontend data channel may send. Use 'all' to allow every
         * client event; an empty array allows none. Omission preserves the existing allow-all
         * behavior.
         */
        fun allowedClientEvents(allowedClientEvents: AllowedClientEvents) =
            allowedClientEvents(JsonField.of(allowedClientEvents))

        /**
         * Sets [Builder.allowedClientEvents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedClientEvents] with a well-typed
         * [AllowedClientEvents] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun allowedClientEvents(allowedClientEvents: JsonField<AllowedClientEvents>) = apply {
            this.allowedClientEvents = allowedClientEvents
        }

        /** Alias for calling [allowedClientEvents] with `AllowedClientEvents.ofAll()`. */
        fun allowedClientEventsAll() = allowedClientEvents(AllowedClientEvents.ofAll())

        /**
         * Alias for calling [allowedClientEvents] with `AllowedClientEvents.ofStrings(strings)`.
         */
        fun allowedClientEventsOfStrings(strings: List<String>) =
            allowedClientEvents(AllowedClientEvents.ofStrings(strings))

        /**
         * Server events that may be sent to the frontend data channel. Use 'all' to allow every
         * server event; an empty array allows none. Omission preserves the existing allow-all
         * behavior. Responses events use an object with type 'response.event' and a response_event
         * selector.
         */
        fun allowedServerEvents(allowedServerEvents: AllowedServerEvents) =
            allowedServerEvents(JsonField.of(allowedServerEvents))

        /**
         * Sets [Builder.allowedServerEvents] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedServerEvents] with a well-typed
         * [AllowedServerEvents] value instead. This method is primarily for setting the field to an
         * undocumented or not yet supported value.
         */
        fun allowedServerEvents(allowedServerEvents: JsonField<AllowedServerEvents>) = apply {
            this.allowedServerEvents = allowedServerEvents
        }

        /** Alias for calling [allowedServerEvents] with `AllowedServerEvents.ofAll()`. */
        fun allowedServerEventsAll() = allowedServerEvents(AllowedServerEvents.ofAll())

        /**
         * Alias for calling [allowedServerEvents] with
         * `AllowedServerEvents.ofEventSelectors(eventSelectors)`.
         */
        fun allowedServerEventsOfEventSelectors(eventSelectors: List<ServerEventSelector>) =
            allowedServerEvents(AllowedServerEvents.ofEventSelectors(eventSelectors))

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
         * Returns an immutable instance of [DataChannelConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): DataChannelConfig =
            DataChannelConfig(
                allowedClientEvents,
                allowedServerEvents,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    /**
     * Validates that the types of all values in this object match their expected types recursively.
     *
     * This method is _not_ forwards compatible with new types from the API for existing fields.
     *
     * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
     *   expected type.
     */
    fun validate(): DataChannelConfig = apply {
        if (validated) {
            return@apply
        }

        allowedClientEvents().ifPresent { it.validate() }
        allowedServerEvents().ifPresent { it.validate() }
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
        (allowedClientEvents.asKnown().getOrNull()?.validity() ?: 0) +
            (allowedServerEvents.asKnown().getOrNull()?.validity() ?: 0)

    /**
     * Client event types that the frontend data channel may send. Use 'all' to allow every client
     * event; an empty array allows none. Omission preserves the existing allow-all behavior.
     */
    @JsonDeserialize(using = AllowedClientEvents.Deserializer::class)
    @JsonSerialize(using = AllowedClientEvents.Serializer::class)
    class AllowedClientEvents
    private constructor(
        private val all: JsonValue? = null,
        private val strings: List<String>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun all(): Optional<JsonValue> = Optional.ofNullable(all)

        fun strings(): Optional<List<String>> = Optional.ofNullable(strings)

        fun isAll(): Boolean = all != null

        fun isStrings(): Boolean = strings != null

        fun asAll(): JsonValue = all.getOrThrow("all")

        fun asStrings(): List<String> = strings.getOrThrow("strings")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = allowedClientEvents.accept(new AllowedClientEvents.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitAll(JsonValue all) {
         *         return Optional.of(all.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                all != null -> visitor.visitAll(all)
                strings != null -> visitor.visitStrings(strings)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AllowedClientEvents = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAll(all: JsonValue) {
                        all.let {
                            if (it != JsonValue.from("all")) {
                                throw OpenAIInvalidDataException("'all' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitStrings(strings: List<String>) {}
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
                    override fun visitAll(all: JsonValue) =
                        all.let { if (it == JsonValue.from("all")) 1 else 0 }

                    override fun visitStrings(strings: List<String>) = strings.size

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AllowedClientEvents && all == other.all && strings == other.strings
        }

        override fun hashCode(): Int = Objects.hash(all, strings)

        override fun toString(): String =
            when {
                all != null -> "AllowedClientEvents{all=$all}"
                strings != null -> "AllowedClientEvents{strings=$strings}"
                _json != null -> "AllowedClientEvents{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AllowedClientEvents")
            }

        companion object {

            @JvmStatic fun ofAll() = AllowedClientEvents(all = JsonValue.from("all"))

            @JvmStatic
            fun ofStrings(strings: List<String>) =
                AllowedClientEvents(strings = strings.toImmutable())
        }

        /**
         * An interface that defines how to map each variant of [AllowedClientEvents] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            fun visitAll(all: JsonValue): T

            fun visitStrings(strings: List<String>): T

            /**
             * Maps an unknown variant of [AllowedClientEvents] to a value of type [T].
             *
             * An instance of [AllowedClientEvents] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown AllowedClientEvents: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<AllowedClientEvents>(AllowedClientEvents::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AllowedClientEvents {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { AllowedClientEvents(all = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<List<String>>())?.let {
                                AllowedClientEvents(strings = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> AllowedClientEvents(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer :
            BaseSerializer<AllowedClientEvents>(AllowedClientEvents::class) {

            override fun serialize(
                value: AllowedClientEvents,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.all != null -> generator.writeObject(value.all)
                    value.strings != null -> generator.writeObject(value.strings)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AllowedClientEvents")
                }
            }
        }
    }

    /**
     * Server events that may be sent to the frontend data channel. Use 'all' to allow every server
     * event; an empty array allows none. Omission preserves the existing allow-all behavior.
     * Responses events use an object with type 'response.event' and a response_event selector.
     */
    @JsonDeserialize(using = AllowedServerEvents.Deserializer::class)
    @JsonSerialize(using = AllowedServerEvents.Serializer::class)
    class AllowedServerEvents
    private constructor(
        private val all: JsonValue? = null,
        private val eventSelectors: List<ServerEventSelector>? = null,
        private val _json: JsonValue? = null,
    ) {

        fun all(): Optional<JsonValue> = Optional.ofNullable(all)

        fun eventSelectors(): Optional<List<ServerEventSelector>> =
            Optional.ofNullable(eventSelectors)

        fun isAll(): Boolean = all != null

        fun isEventSelectors(): Boolean = eventSelectors != null

        fun asAll(): JsonValue = all.getOrThrow("all")

        fun asEventSelectors(): List<ServerEventSelector> =
            eventSelectors.getOrThrow("eventSelectors")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        /**
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
         * ```java
         * import com.openai.core.JsonValue;
         * import java.util.Optional;
         *
         * Optional<String> result = allowedServerEvents.accept(new AllowedServerEvents.Visitor<Optional<String>>() {
         *     @Override
         *     public Optional<String> visitAll(JsonValue all) {
         *         return Optional.of(all.toString());
         *     }
         *
         *     // ...
         *
         *     @Override
         *     public Optional<String> unknown(JsonValue json) {
         *         // Or inspect the `json`.
         *         return Optional.empty();
         *     }
         * });
         * ```
         *
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
         */
        fun <T> accept(visitor: Visitor<T>): T =
            when {
                all != null -> visitor.visitAll(all)
                eventSelectors != null -> visitor.visitEventSelectors(eventSelectors)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): AllowedServerEvents = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitAll(all: JsonValue) {
                        all.let {
                            if (it != JsonValue.from("all")) {
                                throw OpenAIInvalidDataException("'all' is invalid, received $it")
                            }
                        }
                    }

                    override fun visitEventSelectors(eventSelectors: List<ServerEventSelector>) {
                        eventSelectors.forEach { it.validate() }
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
                    override fun visitAll(all: JsonValue) =
                        all.let { if (it == JsonValue.from("all")) 1 else 0 }

                    override fun visitEventSelectors(eventSelectors: List<ServerEventSelector>) =
                        eventSelectors.sumOf { it.validity().toInt() }

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AllowedServerEvents &&
                all == other.all &&
                eventSelectors == other.eventSelectors
        }

        override fun hashCode(): Int = Objects.hash(all, eventSelectors)

        override fun toString(): String =
            when {
                all != null -> "AllowedServerEvents{all=$all}"
                eventSelectors != null -> "AllowedServerEvents{eventSelectors=$eventSelectors}"
                _json != null -> "AllowedServerEvents{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid AllowedServerEvents")
            }

        companion object {

            @JvmStatic fun ofAll() = AllowedServerEvents(all = JsonValue.from("all"))

            @JvmStatic
            fun ofEventSelectors(eventSelectors: List<ServerEventSelector>) =
                AllowedServerEvents(eventSelectors = eventSelectors.toImmutable())
        }

        /**
         * An interface that defines how to map each variant of [AllowedServerEvents] to a value of
         * type [T].
         */
        interface Visitor<out T> {

            fun visitAll(all: JsonValue): T

            fun visitEventSelectors(eventSelectors: List<ServerEventSelector>): T

            /**
             * Maps an unknown variant of [AllowedServerEvents] to a value of type [T].
             *
             * An instance of [AllowedServerEvents] can contain an unknown variant if it was
             * deserialized from data that doesn't match any known variant. For example, if the SDK
             * is on an older version than the API, then the API may respond with new variants that
             * the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown AllowedServerEvents: $json")
            }
        }

        internal class Deserializer :
            BaseDeserializer<AllowedServerEvents>(AllowedServerEvents::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): AllowedServerEvents {
                val json = JsonValue.fromJsonNode(node)

                val bestMatches =
                    sequenceOf(
                            tryDeserialize(node, jacksonTypeRef<JsonValue>())
                                ?.let { AllowedServerEvents(all = it, _json = json) }
                                ?.takeIf { it.isValid() },
                            tryDeserialize(node, jacksonTypeRef<List<ServerEventSelector>>())?.let {
                                AllowedServerEvents(eventSelectors = it, _json = json)
                            },
                        )
                        .filterNotNull()
                        .allMaxBy { it.validity() }
                        .toList()
                return when (bestMatches.size) {
                    // This can happen if what we're deserializing is completely incompatible with
                    // all the possible variants (e.g. deserializing from boolean).
                    0 -> AllowedServerEvents(_json = json)
                    1 -> bestMatches.single()
                    // If there's more than one match with the highest validity, then use the first
                    // completely valid match, or simply the first match if none are completely
                    // valid.
                    else -> bestMatches.firstOrNull { it.isValid() } ?: bestMatches.first()
                }
            }
        }

        internal class Serializer :
            BaseSerializer<AllowedServerEvents>(AllowedServerEvents::class) {

            override fun serialize(
                value: AllowedServerEvents,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.all != null -> generator.writeObject(value.all)
                    value.eventSelectors != null -> generator.writeObject(value.eventSelectors)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid AllowedServerEvents")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is DataChannelConfig &&
            allowedClientEvents == other.allowedClientEvents &&
            allowedServerEvents == other.allowedServerEvents &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(allowedClientEvents, allowedServerEvents, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "DataChannelConfig{allowedClientEvents=$allowedClientEvents, allowedServerEvents=$allowedServerEvents, additionalProperties=$additionalProperties}"
}
