// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.chatkit.threads

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Represents a ChatKit thread and its current status. */
class ChatKitThread
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val object_: JsonValue,
    private val status: JsonField<Status>,
    private val title: JsonField<String>,
    private val user: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("title") @ExcludeMissing title: JsonField<String> = JsonMissing.of(),
        @JsonProperty("user") @ExcludeMissing user: JsonField<String> = JsonMissing.of(),
    ) : this(id, createdAt, object_, status, title, user, mutableMapOf())

    /**
     * Identifier of the thread.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Unix timestamp (in seconds) for when the thread was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Type discriminator that is always `chatkit.thread`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("chatkit.thread")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Current status for the thread. Defaults to `active` for newly created threads.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Optional human-readable title for the thread. Defaults to null when no title has been
     * generated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun title(): Optional<String> = title.getOptional("title")

    /**
     * Free-form string that identifies your end user who owns the thread.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun user(): String = user.getRequired("user")

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
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [title].
     *
     * Unlike [title], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("title") @ExcludeMissing fun _title(): JsonField<String> = title

    /**
     * Returns the raw JSON value of [user].
     *
     * Unlike [user], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("user") @ExcludeMissing fun _user(): JsonField<String> = user

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
         * Returns a mutable builder for constructing an instance of [ChatKitThread].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .status()
         * .title()
         * .user()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ChatKitThread]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var object_: JsonValue = JsonValue.from("chatkit.thread")
        private var status: JsonField<Status>? = null
        private var title: JsonField<String>? = null
        private var user: JsonField<String>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(chatkitThread: ChatKitThread) = apply {
            id = chatkitThread.id
            createdAt = chatkitThread.createdAt
            object_ = chatkitThread.object_
            status = chatkitThread.status
            title = chatkitThread.title
            user = chatkitThread.user
            additionalProperties = chatkitThread.additionalProperties.toMutableMap()
        }

        /** Identifier of the thread. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Unix timestamp (in seconds) for when the thread was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("chatkit.thread")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Current status for the thread. Defaults to `active` for newly created threads. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Alias for calling [status] with `Status.ofActive()`. */
        fun statusActive() = status(Status.ofActive())

        /** Alias for calling [status] with `Status.ofLocked(locked)`. */
        fun status(locked: Status.Locked) = status(Status.ofLocked(locked))

        /**
         * Alias for calling [status] with the following:
         * ```java
         * Status.Locked.builder()
         *     .reason(reason)
         *     .build()
         * ```
         */
        fun lockedStatus(reason: String?) = status(Status.Locked.builder().reason(reason).build())

        /** Alias for calling [lockedStatus] with `reason.orElse(null)`. */
        fun lockedStatus(reason: Optional<String>) = lockedStatus(reason.getOrNull())

        /** Alias for calling [status] with `Status.ofClosed(closed)`. */
        fun status(closed: Status.Closed) = status(Status.ofClosed(closed))

        /**
         * Alias for calling [status] with the following:
         * ```java
         * Status.Closed.builder()
         *     .reason(reason)
         *     .build()
         * ```
         */
        fun closedStatus(reason: String?) = status(Status.Closed.builder().reason(reason).build())

        /** Alias for calling [closedStatus] with `reason.orElse(null)`. */
        fun closedStatus(reason: Optional<String>) = closedStatus(reason.getOrNull())

        /**
         * Optional human-readable title for the thread. Defaults to null when no title has been
         * generated.
         */
        fun title(title: String?) = title(JsonField.ofNullable(title))

        /** Alias for calling [Builder.title] with `title.orElse(null)`. */
        fun title(title: Optional<String>) = title(title.getOrNull())

        /**
         * Sets [Builder.title] to an arbitrary JSON value.
         *
         * You should usually call [Builder.title] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun title(title: JsonField<String>) = apply { this.title = title }

        /** Free-form string that identifies your end user who owns the thread. */
        fun user(user: String) = user(JsonField.of(user))

        /**
         * Sets [Builder.user] to an arbitrary JSON value.
         *
         * You should usually call [Builder.user] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun user(user: JsonField<String>) = apply { this.user = user }

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
         * Returns an immutable instance of [ChatKitThread].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .status()
         * .title()
         * .user()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ChatKitThread =
            ChatKitThread(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                object_,
                checkRequired("status", status),
                checkRequired("title", title),
                checkRequired("user", user),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ChatKitThread = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        _object_().let {
            if (it != JsonValue.from("chatkit.thread")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        status().validate()
        title()
        user()
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
            object_.let { if (it == JsonValue.from("chatkit.thread")) 1 else 0 } +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (if (title.asKnown().isPresent) 1 else 0) +
            (if (user.asKnown().isPresent) 1 else 0)

    /** Current status for the thread. Defaults to `active` for newly created threads. */
    @JsonDeserialize(using = Status.Deserializer::class)
    @JsonSerialize(using = Status.Serializer::class)
    class Status
    private constructor(
        private val active: JsonValue? = null,
        private val locked: Locked? = null,
        private val closed: Closed? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Indicates that a thread is active. */
        fun active(): Optional<JsonValue> = Optional.ofNullable(active)

        /** Indicates that a thread is locked and cannot accept new input. */
        fun locked(): Optional<Locked> = Optional.ofNullable(locked)

        /** Indicates that a thread has been closed. */
        fun closed(): Optional<Closed> = Optional.ofNullable(closed)

        fun isActive(): Boolean = active != null

        fun isLocked(): Boolean = locked != null

        fun isClosed(): Boolean = closed != null

        /** Indicates that a thread is active. */
        fun asActive(): JsonValue = active.getOrThrow("active")

        /** Indicates that a thread is locked and cannot accept new input. */
        fun asLocked(): Locked = locked.getOrThrow("locked")

        /** Indicates that a thread has been closed. */
        fun asClosed(): Closed = closed.getOrThrow("closed")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                active != null -> visitor.visitActive(active)
                locked != null -> visitor.visitLocked(locked)
                closed != null -> visitor.visitClosed(closed)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Status = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitActive(active: JsonValue) {
                        active.let {
                            if (it != JsonValue.from(mapOf("type" to "active"))) {
                                throw OpenAIInvalidDataException(
                                    "'active' is invalid, received $it"
                                )
                            }
                        }
                    }

                    override fun visitLocked(locked: Locked) {
                        locked.validate()
                    }

                    override fun visitClosed(closed: Closed) {
                        closed.validate()
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
                    override fun visitActive(active: JsonValue) =
                        active.let { if (it == JsonValue.from(mapOf("type" to "active"))) 1 else 0 }

                    override fun visitLocked(locked: Locked) = locked.validity()

                    override fun visitClosed(closed: Closed) = closed.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Status &&
                active == other.active &&
                locked == other.locked &&
                closed == other.closed
        }

        override fun hashCode(): Int = Objects.hash(active, locked, closed)

        override fun toString(): String =
            when {
                active != null -> "Status{active=$active}"
                locked != null -> "Status{locked=$locked}"
                closed != null -> "Status{closed=$closed}"
                _json != null -> "Status{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Status")
            }

        companion object {

            /** Indicates that a thread is active. */
            @JvmStatic fun ofActive() = Status(active = JsonValue.from(mapOf("type" to "active")))

            /** Indicates that a thread is locked and cannot accept new input. */
            @JvmStatic fun ofLocked(locked: Locked) = Status(locked = locked)

            /** Indicates that a thread has been closed. */
            @JvmStatic fun ofClosed(closed: Closed) = Status(closed = closed)
        }

        /** An interface that defines how to map each variant of [Status] to a value of type [T]. */
        interface Visitor<out T> {

            /** Indicates that a thread is active. */
            fun visitActive(active: JsonValue): T

            /** Indicates that a thread is locked and cannot accept new input. */
            fun visitLocked(locked: Locked): T

            /** Indicates that a thread has been closed. */
            fun visitClosed(closed: Closed): T

            /**
             * Maps an unknown variant of [Status] to a value of type [T].
             *
             * An instance of [Status] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Status: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Status>(Status::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Status {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "active" -> {
                        return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                            ?.let { Status(active = it, _json = json) }
                            ?.takeIf { it.isValid() } ?: Status(_json = json)
                    }
                    "locked" -> {
                        return tryDeserialize(node, jacksonTypeRef<Locked>())?.let {
                            Status(locked = it, _json = json)
                        } ?: Status(_json = json)
                    }
                    "closed" -> {
                        return tryDeserialize(node, jacksonTypeRef<Closed>())?.let {
                            Status(closed = it, _json = json)
                        } ?: Status(_json = json)
                    }
                }

                return Status(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Status>(Status::class) {

            override fun serialize(
                value: Status,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.active != null -> generator.writeObject(value.active)
                    value.locked != null -> generator.writeObject(value.locked)
                    value.closed != null -> generator.writeObject(value.closed)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Status")
                }
            }
        }

        /** Indicates that a thread is locked and cannot accept new input. */
        class Locked
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val reason: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(reason, type, mutableMapOf())

            /**
             * Reason that the thread was locked. Defaults to null when no reason is recorded.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun reason(): Optional<String> = reason.getOptional("reason")

            /**
             * Status discriminator that is always `locked`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("locked")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
                 * Returns a mutable builder for constructing an instance of [Locked].
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Locked]. */
            class Builder internal constructor() {

                private var reason: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("locked")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(locked: Locked) = apply {
                    reason = locked.reason
                    type = locked.type
                    additionalProperties = locked.additionalProperties.toMutableMap()
                }

                /**
                 * Reason that the thread was locked. Defaults to null when no reason is recorded.
                 */
                fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("locked")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Locked].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Locked =
                    Locked(
                        checkRequired("reason", reason),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Locked = apply {
                if (validated) {
                    return@apply
                }

                reason()
                _type().let {
                    if (it != JsonValue.from("locked")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (if (reason.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("locked")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Locked &&
                    reason == other.reason &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(reason, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Locked{reason=$reason, type=$type, additionalProperties=$additionalProperties}"
        }

        /** Indicates that a thread has been closed. */
        class Closed
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val reason: JsonField<String>,
            private val type: JsonValue,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("reason")
                @ExcludeMissing
                reason: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            ) : this(reason, type, mutableMapOf())

            /**
             * Reason that the thread was closed. Defaults to null when no reason is recorded.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun reason(): Optional<String> = reason.getOptional("reason")

            /**
             * Status discriminator that is always `closed`.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("closed")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * Returns the raw JSON value of [reason].
             *
             * Unlike [reason], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("reason") @ExcludeMissing fun _reason(): JsonField<String> = reason

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
                 * Returns a mutable builder for constructing an instance of [Closed].
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Closed]. */
            class Builder internal constructor() {

                private var reason: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("closed")
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(closed: Closed) = apply {
                    reason = closed.reason
                    type = closed.type
                    additionalProperties = closed.additionalProperties.toMutableMap()
                }

                /**
                 * Reason that the thread was closed. Defaults to null when no reason is recorded.
                 */
                fun reason(reason: String?) = reason(JsonField.ofNullable(reason))

                /** Alias for calling [Builder.reason] with `reason.orElse(null)`. */
                fun reason(reason: Optional<String>) = reason(reason.getOrNull())

                /**
                 * Sets [Builder.reason] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.reason] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun reason(reason: JsonField<String>) = apply { this.reason = reason }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("closed")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

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
                 * Returns an immutable instance of [Closed].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .reason()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Closed =
                    Closed(
                        checkRequired("reason", reason),
                        type,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Closed = apply {
                if (validated) {
                    return@apply
                }

                reason()
                _type().let {
                    if (it != JsonValue.from("closed")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
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
                (if (reason.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("closed")) 1 else 0 }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Closed &&
                    reason == other.reason &&
                    type == other.type &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(reason, type, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Closed{reason=$reason, type=$type, additionalProperties=$additionalProperties}"
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ChatKitThread &&
            id == other.id &&
            createdAt == other.createdAt &&
            object_ == other.object_ &&
            status == other.status &&
            title == other.title &&
            user == other.user &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, createdAt, object_, status, title, user, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ChatKitThread{id=$id, createdAt=$createdAt, object_=$object_, status=$status, title=$title, user=$user, additionalProperties=$additionalProperties}"
}
