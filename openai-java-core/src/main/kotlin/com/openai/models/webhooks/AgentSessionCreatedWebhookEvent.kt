// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Sent when an agent session is created. */
class AgentSessionCreatedWebhookEvent
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val data: JsonField<Data>,
    private val object_: JsonValue,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, createdAt, data, object_, type, mutableMapOf())

    /**
     * The unique ID of the event. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun id(): java.util.Optional<String> = id.getOptional("id")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun idOrThrow(): String = id.getRequired("id")

    /**
     * The Unix timestamp, in seconds, when the event was created. The schema requires this
     * property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun createdAt(): java.util.Optional<Long> = createdAt.getOptional("created_at")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun createdAtOrThrow(): Long = createdAt.getRequired("created_at")

    /**
     * The schema requires this property. Returns empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun data(): java.util.Optional<Data> = data.getOptional("data")

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun dataOrThrow(): Data = data.getRequired("data")

    /**
     * The object type. Always `event`. The schema requires this property. Returns empty if the JSON
     * property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun object_(): java.util.Optional<JsonValue> {
        val raw = object_
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("event")) ->
                throw OpenAIInvalidDataException("`object` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun object_OrThrow(): JsonValue = object_().orElseGet { object_.getRequired("object") }

    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonField<JsonValue> = object_

    /**
     * The event type. Always `agent.session.created`. The schema requires this property. Returns
     * empty if the JSON property is missing or null.
     *
     * @throws OpenAIInvalidDataException if the value has an unexpected type.
     */
    fun type(): java.util.Optional<JsonValue> {
        val raw = type
        return when {
            raw.isMissing() || raw.isNull() -> java.util.Optional.empty()
            !(raw == JsonValue.from("agent.session.created")) ->
                throw OpenAIInvalidDataException("`type` is invalid")
            else -> java.util.Optional.of(raw)
        }
    }

    /**
     * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or invalid.
     */
    fun typeOrThrow(): JsonValue = type().orElseGet { type.getRequired("type") }

    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<JsonValue> = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    /**
     * Returns an immutable snapshot of all present JSON properties, including declared and
     * additional properties.
     *
     * Keys use their JSON names. Declared properties take precedence over additional properties
     * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
     * values are preserved.
     */
    fun _allProperties(): Map<String, JsonValue> =
        collectAllProperties(
            additionalProperties,
            "id" to this.id,
            "created_at" to this.createdAt,
            "data" to this.data,
            "object" to this.object_,
            "type" to this.type,
        )

    @JvmSynthetic
    internal fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    @JsonAnyGetter
    @ExcludeMissing
    private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [AgentSessionCreatedWebhookEvent].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AgentSessionCreatedWebhookEvent]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var data: JsonField<Data>? = null
        private var object_: JsonValue = JsonValue.from("event")
        private var type: JsonValue = JsonValue.from("agent.session.created")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(agentSessionCreatedWebhookEvent: AgentSessionCreatedWebhookEvent) =
            apply {
                id = agentSessionCreatedWebhookEvent.id
                createdAt = agentSessionCreatedWebhookEvent.createdAt
                data = agentSessionCreatedWebhookEvent.data
                object_ = agentSessionCreatedWebhookEvent.object_
                type = agentSessionCreatedWebhookEvent.type
                additionalProperties =
                    agentSessionCreatedWebhookEvent.additionalProperties.toMutableMap()
            }

        /** The unique ID of the event. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp, in seconds, when the event was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("event")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.session.created")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

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
         * Returns an immutable instance of [AgentSessionCreatedWebhookEvent].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .data()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AgentSessionCreatedWebhookEvent =
            AgentSessionCreatedWebhookEvent(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("data", data),
                object_,
                type,
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
    fun validate(): AgentSessionCreatedWebhookEvent = apply {
        if (validated) {
            return@apply
        }

        idOrThrow()
        createdAtOrThrow()
        dataOrThrow().validate()
        object_OrThrow()
        typeOrThrow()
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
        (if (id.asKnown().isPresent) 1 else 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (data.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("event")) 1 else 0 } +
            type.let { if (it == JsonValue.from("agent.session.created")) 1 else 0 }

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val environmentType: JsonField<String>,
        private val connect: JsonField<Connect>,
        private val environmentId: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("environment_type")
            @ExcludeMissing
            environmentType: JsonField<String> = JsonMissing.of(),
            @JsonProperty("connect") @ExcludeMissing connect: JsonField<Connect> = JsonMissing.of(),
            @JsonProperty("environment_id")
            @ExcludeMissing
            environmentId: JsonField<String> = JsonMissing.of(),
        ) : this(id, environmentType, connect, environmentId, mutableMapOf())

        /**
         * The ID of the session. The schema requires this property. Returns empty if the JSON
         * property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun id(): java.util.Optional<String> = id.getOptional("id")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun idOrThrow(): String = id.getRequired("id")

        /**
         * The environment type: `none`, `openai_hosted`, or `self_hosted`. The schema requires this
         * property. Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun environmentType(): java.util.Optional<String> =
            environmentType.getOptional("environment_type")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun environmentTypeOrThrow(): String = environmentType.getRequired("environment_type")

        /**
         * Returns empty if the JSON property is missing or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun connect(): java.util.Optional<Connect> = connect.getOptional("connect")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun connectOrThrow(): Connect = connect.getRequired("connect")

        /**
         * The ID of the environment, when one exists. Returns empty if the JSON property is missing
         * or null.
         *
         * @throws OpenAIInvalidDataException if the value has an unexpected type.
         */
        fun environmentId(): java.util.Optional<String> =
            environmentId.getOptional("environment_id")

        /**
         * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
         * invalid.
         */
        fun environmentIdOrThrow(): String = environmentId.getRequired("environment_id")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [environmentType].
         *
         * Unlike [environmentType], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("environment_type")
        @ExcludeMissing
        fun _environmentType(): JsonField<String> = environmentType

        /**
         * Returns the raw JSON value of [connect].
         *
         * Unlike [connect], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("connect") @ExcludeMissing fun _connect(): JsonField<Connect> = connect

        /**
         * Returns the raw JSON value of [environmentId].
         *
         * Unlike [environmentId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("environment_id")
        @ExcludeMissing
        fun _environmentId(): JsonField<String> = environmentId

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        /**
         * Returns an immutable snapshot of all present JSON properties, including declared and
         * additional properties.
         *
         * Keys use their JSON names. Declared properties take precedence over additional properties
         * with the same name. Missing properties are omitted, while explicit nulls and unrecognized
         * values are preserved.
         */
        fun _allProperties(): Map<String, JsonValue> =
            collectAllProperties(
                additionalProperties,
                "id" to this.id,
                "environment_type" to this.environmentType,
                "connect" to this.connect,
                "environment_id" to this.environmentId,
            )

        @JvmSynthetic
        internal fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        @JsonAnyGetter
        @ExcludeMissing
        private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Data].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .environmentType()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var environmentType: JsonField<String>? = null
            private var connect: JsonField<Connect> = JsonMissing.of()
            private var environmentId: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                id = data.id
                environmentType = data.environmentType
                connect = data.connect
                environmentId = data.environmentId
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            /** The ID of the session. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** The environment type: `none`, `openai_hosted`, or `self_hosted`. */
            fun environmentType(environmentType: String) =
                environmentType(JsonField.of(environmentType))

            /**
             * Sets [Builder.environmentType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environmentType] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun environmentType(environmentType: JsonField<String>) = apply {
                this.environmentType = environmentType
            }

            fun connect(connect: Connect) = connect(JsonField.of(connect))

            /**
             * Sets [Builder.connect] to an arbitrary JSON value.
             *
             * You should usually call [Builder.connect] with a well-typed [Connect] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun connect(connect: JsonField<Connect>) = apply { this.connect = connect }

            /** The ID of the environment, when one exists. */
            fun environmentId(environmentId: String) = environmentId(JsonField.of(environmentId))

            /**
             * Sets [Builder.environmentId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environmentId] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun environmentId(environmentId: JsonField<String>) = apply {
                this.environmentId = environmentId
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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .environmentType()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Data =
                Data(
                    checkRequired("id", id),
                    checkRequired("environmentType", environmentType),
                    connect,
                    environmentId,
                    additionalProperties.toMutableMap(),
                )
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
        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            idOrThrow()
            environmentTypeOrThrow()
            connect().ifPresent { it.validate() }
            environmentId()
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (if (environmentType.asKnown().isPresent) 1 else 0) +
                (connect.asKnown().getOrNull()?.validity() ?: 0) +
                (if (environmentId.asKnown().isPresent) 1 else 0)

        class Connect
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val remoteUrl: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("remote_url")
                @ExcludeMissing
                remoteUrl: JsonField<String> = JsonMissing.of()
            ) : this(remoteUrl, mutableMapOf())

            /**
             * The URL used to connect the self-hosted environment. The schema requires this
             * property. Returns empty if the JSON property is missing or null.
             *
             * @throws OpenAIInvalidDataException if the value has an unexpected type.
             */
            fun remoteUrl(): java.util.Optional<String> = remoteUrl.getOptional("remote_url")

            /**
             * Returns the value or throws [OpenAIInvalidDataException] if it is missing, null, or
             * invalid.
             */
            fun remoteUrlOrThrow(): String = remoteUrl.getRequired("remote_url")

            /**
             * Returns the raw JSON value of [remoteUrl].
             *
             * Unlike [remoteUrl], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("remote_url")
            @ExcludeMissing
            fun _remoteUrl(): JsonField<String> = remoteUrl

            @JsonAnySetter
            private fun putAdditionalProperty(key: String, value: JsonValue) {
                additionalProperties.put(key, value)
            }

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(additionalProperties, "remote_url" to this.remoteUrl)

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Connect].
                 *
                 * The following fields are required:
                 * ```java
                 * .remoteUrl()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Connect]. */
            class Builder internal constructor() {

                private var remoteUrl: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(connect: Connect) = apply {
                    remoteUrl = connect.remoteUrl
                    additionalProperties = connect.additionalProperties.toMutableMap()
                }

                /** The URL used to connect the self-hosted environment. */
                fun remoteUrl(remoteUrl: String) = remoteUrl(JsonField.of(remoteUrl))

                /**
                 * Sets [Builder.remoteUrl] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.remoteUrl] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun remoteUrl(remoteUrl: JsonField<String>) = apply { this.remoteUrl = remoteUrl }

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
                 * Returns an immutable instance of [Connect].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .remoteUrl()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Connect =
                    Connect(
                        checkRequired("remoteUrl", remoteUrl),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            /**
             * Validates that the types of all values in this object match their expected types
             * recursively.
             *
             * This method is _not_ forwards compatible with new types from the API for existing
             * fields.
             *
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): Connect = apply {
                if (validated) {
                    return@apply
                }

                remoteUrlOrThrow()
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
            internal fun validity(): Int = (if (remoteUrl.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Connect &&
                    remoteUrl == other.remoteUrl &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(remoteUrl, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Connect{remoteUrl=$remoteUrl, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                id == other.id &&
                environmentType == other.environmentType &&
                connect == other.connect &&
                environmentId == other.environmentId &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(id, environmentType, connect, environmentId, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{id=$id, environmentType=$environmentType, connect=$connect, environmentId=$environmentId, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentSessionCreatedWebhookEvent &&
            id == other.id &&
            createdAt == other.createdAt &&
            data == other.data &&
            object_ == other.object_ &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, data, object_, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "AgentSessionCreatedWebhookEvent{id=$id, createdAt=$createdAt, data=$data, object_=$object_, type=$type, additionalProperties=$additionalProperties}"
}
