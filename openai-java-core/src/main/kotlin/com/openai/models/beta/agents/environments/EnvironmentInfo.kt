// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.HostedEnvironmentFile
import com.openai.models.beta.agents.HostedEnvironmentFileId
import com.openai.models.beta.agents.HostedPlugin
import com.openai.models.beta.agents.HostedSkill
import com.openai.models.beta.agents.HostedSkillReference
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Safe metadata for a first-class execution environment. */
class EnvironmentInfo
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val files: JsonField<List<HostedEnvironmentFile>>,
    private val object_: JsonValue,
    private val plugins: JsonField<List<HostedPlugin>>,
    private val skills: JsonField<List<HostedSkill>>,
    private val status: JsonField<Status>,
    private val type: JsonField<Type>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("files")
        @ExcludeMissing
        files: JsonField<List<HostedEnvironmentFile>> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("plugins")
        @ExcludeMissing
        plugins: JsonField<List<HostedPlugin>> = JsonMissing.of(),
        @JsonProperty("skills")
        @ExcludeMissing
        skills: JsonField<List<HostedSkill>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
    ) : this(id, files, object_, plugins, skills, status, type, mutableMapOf())

    /**
     * The ID of the environment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Files installed in the environment, without their contents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun files(): List<HostedEnvironmentFile> = files.getRequired("files")

    /**
     * The object type. Always `agent.environment`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("agent.environment")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Plugins installed in the environment, without their archive contents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun plugins(): List<HostedPlugin> = plugins.getRequired("plugins")

    /**
     * Skills installed in the environment, without their archive contents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun skills(): List<HostedSkill> = skills.getRequired("skills")

    /**
     * The current environment connection status.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * Whether the environment is hosted by OpenAI or by the application.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun type(): Type = type.getRequired("type")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("files")
    @ExcludeMissing
    fun _files(): JsonField<List<HostedEnvironmentFile>> = files

    /**
     * Returns the raw JSON value of [plugins].
     *
     * Unlike [plugins], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("plugins") @ExcludeMissing fun _plugins(): JsonField<List<HostedPlugin>> = plugins

    /**
     * Returns the raw JSON value of [skills].
     *
     * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<HostedSkill>> = skills

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

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
         * Returns a mutable builder for constructing an instance of [EnvironmentInfo].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .files()
         * .plugins()
         * .skills()
         * .status()
         * .type()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EnvironmentInfo]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var files: JsonField<MutableList<HostedEnvironmentFile>>? = null
        private var object_: JsonValue = JsonValue.from("agent.environment")
        private var plugins: JsonField<MutableList<HostedPlugin>>? = null
        private var skills: JsonField<MutableList<HostedSkill>>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonField<Type>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(environmentInfo: EnvironmentInfo) = apply {
            id = environmentInfo.id
            files = environmentInfo.files.map { it.toMutableList() }
            object_ = environmentInfo.object_
            plugins = environmentInfo.plugins.map { it.toMutableList() }
            skills = environmentInfo.skills.map { it.toMutableList() }
            status = environmentInfo.status
            type = environmentInfo.type
            additionalProperties = environmentInfo.additionalProperties.toMutableMap()
        }

        /** The ID of the environment. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Files installed in the environment, without their contents. */
        fun files(files: List<HostedEnvironmentFile>) = files(JsonField.of(files))

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed `List<HostedEnvironmentFile>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun files(files: JsonField<List<HostedEnvironmentFile>>) = apply {
            this.files = files.map { it.toMutableList() }
        }

        /**
         * Adds a single [HostedEnvironmentFile] to [files].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFile(file: HostedEnvironmentFile) = apply {
            files =
                (files ?: JsonField.of(mutableListOf())).also { checkKnown("files", it).add(file) }
        }

        /** Alias for calling [addFile] with `HostedEnvironmentFile.ofFileId(fileId)`. */
        fun addFile(fileId: HostedEnvironmentFileId) =
            addFile(HostedEnvironmentFile.ofFileId(fileId))

        /** Alias for calling [addFile] with `HostedEnvironmentFile.ofInline(inline)`. */
        fun addFile(inline: HostedEnvironmentFile.Inline) =
            addFile(HostedEnvironmentFile.ofInline(inline))

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.environment")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Plugins installed in the environment, without their archive contents. */
        fun plugins(plugins: List<HostedPlugin>) = plugins(JsonField.of(plugins))

        /**
         * Sets [Builder.plugins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.plugins] with a well-typed `List<HostedPlugin>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun plugins(plugins: JsonField<List<HostedPlugin>>) = apply {
            this.plugins = plugins.map { it.toMutableList() }
        }

        /**
         * Adds a single [HostedPlugin] to [plugins].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPlugin(plugin: HostedPlugin) = apply {
            plugins =
                (plugins ?: JsonField.of(mutableListOf())).also {
                    checkKnown("plugins", it).add(plugin)
                }
        }

        /** Skills installed in the environment, without their archive contents. */
        fun skills(skills: List<HostedSkill>) = skills(JsonField.of(skills))

        /**
         * Sets [Builder.skills] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skills] with a well-typed `List<HostedSkill>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun skills(skills: JsonField<List<HostedSkill>>) = apply {
            this.skills = skills.map { it.toMutableList() }
        }

        /**
         * Adds a single [HostedSkill] to [skills].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSkill(skill: HostedSkill) = apply {
            skills =
                (skills ?: JsonField.of(mutableListOf())).also {
                    checkKnown("skills", it).add(skill)
                }
        }

        /** Alias for calling [addSkill] with `HostedSkill.ofSkillReference(skillReference)`. */
        fun addSkill(skillReference: HostedSkillReference) =
            addSkill(HostedSkill.ofSkillReference(skillReference))

        /** Alias for calling [addSkill] with `HostedSkill.ofInline(inline)`. */
        fun addSkill(inline: HostedSkill.Inline) = addSkill(HostedSkill.ofInline(inline))

        /** The current environment connection status. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /** Whether the environment is hosted by OpenAI or by the application. */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

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
         * Returns an immutable instance of [EnvironmentInfo].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .files()
         * .plugins()
         * .skills()
         * .status()
         * .type()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EnvironmentInfo =
            EnvironmentInfo(
                checkRequired("id", id),
                checkRequired("files", files).map { it.toImmutable() },
                object_,
                checkRequired("plugins", plugins).map { it.toImmutable() },
                checkRequired("skills", skills).map { it.toImmutable() },
                checkRequired("status", status),
                checkRequired("type", type),
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
    fun validate(): EnvironmentInfo = apply {
        if (validated) {
            return@apply
        }

        id()
        files().forEach { it.validate() }
        _object_().let {
            if (it != JsonValue.from("agent.environment")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        plugins().forEach { it.validate() }
        skills().forEach { it.validate() }
        status().validate()
        type().validate()
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
            (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            object_.let { if (it == JsonValue.from("agent.environment")) 1 else 0 } +
            (plugins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0)

    /** The current environment connection status. */
    class Status @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val PENDING = of("pending")

            @JvmField val CONNECTED = of("connected")

            @JvmField val DISCONNECTED = of("disconnected")

            @JvmField val EXPIRED = of("expired")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            PENDING,
            CONNECTED,
            DISCONNECTED,
            EXPIRED,
            FAILED,
        }

        /**
         * An enum containing [Status]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Status] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PENDING,
            CONNECTED,
            DISCONNECTED,
            EXPIRED,
            FAILED,
            /** An enum member indicating that [Status] was instantiated with an unknown value. */
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
                PENDING -> Value.PENDING
                CONNECTED -> Value.CONNECTED
                DISCONNECTED -> Value.DISCONNECTED
                EXPIRED -> Value.EXPIRED
                FAILED -> Value.FAILED
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
                PENDING -> Known.PENDING
                CONNECTED -> Known.CONNECTED
                DISCONNECTED -> Known.DISCONNECTED
                EXPIRED -> Known.EXPIRED
                FAILED -> Known.FAILED
                else -> throw OpenAIInvalidDataException("Unknown Status: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Status = apply {
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

            return other is Status && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Whether the environment is hosted by OpenAI or by the application. */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

            @JvmField val OPENAI_HOSTED = of("openai_hosted")

            @JvmField val SELF_HOSTED = of("self_hosted")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            OPENAI_HOSTED,
            SELF_HOSTED,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            OPENAI_HOSTED,
            SELF_HOSTED,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
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
                OPENAI_HOSTED -> Value.OPENAI_HOSTED
                SELF_HOSTED -> Value.SELF_HOSTED
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
                OPENAI_HOSTED -> Known.OPENAI_HOSTED
                SELF_HOSTED -> Known.SELF_HOSTED
                else -> throw OpenAIInvalidDataException("Unknown Type: $value")
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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
        fun validate(): Type = apply {
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

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EnvironmentInfo &&
            id == other.id &&
            files == other.files &&
            object_ == other.object_ &&
            plugins == other.plugins &&
            skills == other.skills &&
            status == other.status &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, files, object_, plugins, skills, status, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EnvironmentInfo{id=$id, files=$files, object_=$object_, plugins=$plugins, skills=$skills, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
