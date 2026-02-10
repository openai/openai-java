// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

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
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class ContainerAuto
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val type: JsonValue,
    private val fileIds: JsonField<List<String>>,
    private val memoryLimit: JsonField<MemoryLimit>,
    private val networkPolicy: JsonField<NetworkPolicy>,
    private val skills: JsonField<List<Skill>>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        @JsonProperty("file_ids")
        @ExcludeMissing
        fileIds: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("memory_limit")
        @ExcludeMissing
        memoryLimit: JsonField<MemoryLimit> = JsonMissing.of(),
        @JsonProperty("network_policy")
        @ExcludeMissing
        networkPolicy: JsonField<NetworkPolicy> = JsonMissing.of(),
        @JsonProperty("skills") @ExcludeMissing skills: JsonField<List<Skill>> = JsonMissing.of(),
    ) : this(type, fileIds, memoryLimit, networkPolicy, skills, mutableMapOf())

    /**
     * Automatically creates a container for this request
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("container_auto")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * An optional list of uploaded files to make available to your code.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileIds(): Optional<List<String>> = fileIds.getOptional("file_ids")

    /**
     * The memory limit for the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun memoryLimit(): Optional<MemoryLimit> = memoryLimit.getOptional("memory_limit")

    /**
     * Network access policy for the container.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun networkPolicy(): Optional<NetworkPolicy> = networkPolicy.getOptional("network_policy")

    /**
     * An optional list of skills referenced by id or inline data.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun skills(): Optional<List<Skill>> = skills.getOptional("skills")

    /**
     * Returns the raw JSON value of [fileIds].
     *
     * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_ids") @ExcludeMissing fun _fileIds(): JsonField<List<String>> = fileIds

    /**
     * Returns the raw JSON value of [memoryLimit].
     *
     * Unlike [memoryLimit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("memory_limit")
    @ExcludeMissing
    fun _memoryLimit(): JsonField<MemoryLimit> = memoryLimit

    /**
     * Returns the raw JSON value of [networkPolicy].
     *
     * Unlike [networkPolicy], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("network_policy")
    @ExcludeMissing
    fun _networkPolicy(): JsonField<NetworkPolicy> = networkPolicy

    /**
     * Returns the raw JSON value of [skills].
     *
     * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<Skill>> = skills

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

        /** Returns a mutable builder for constructing an instance of [ContainerAuto]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContainerAuto]. */
    class Builder internal constructor() {

        private var type: JsonValue = JsonValue.from("container_auto")
        private var fileIds: JsonField<MutableList<String>>? = null
        private var memoryLimit: JsonField<MemoryLimit> = JsonMissing.of()
        private var networkPolicy: JsonField<NetworkPolicy> = JsonMissing.of()
        private var skills: JsonField<MutableList<Skill>>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(containerAuto: ContainerAuto) = apply {
            type = containerAuto.type
            fileIds = containerAuto.fileIds.map { it.toMutableList() }
            memoryLimit = containerAuto.memoryLimit
            networkPolicy = containerAuto.networkPolicy
            skills = containerAuto.skills.map { it.toMutableList() }
            additionalProperties = containerAuto.additionalProperties.toMutableMap()
        }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("container_auto")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun type(type: JsonValue) = apply { this.type = type }

        /** An optional list of uploaded files to make available to your code. */
        fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

        /**
         * Sets [Builder.fileIds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileIds] with a well-typed `List<String>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun fileIds(fileIds: JsonField<List<String>>) = apply {
            this.fileIds = fileIds.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [fileIds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFileId(fileId: String) = apply {
            fileIds =
                (fileIds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("fileIds", it).add(fileId)
                }
        }

        /** The memory limit for the container. */
        fun memoryLimit(memoryLimit: MemoryLimit?) = memoryLimit(JsonField.ofNullable(memoryLimit))

        /** Alias for calling [Builder.memoryLimit] with `memoryLimit.orElse(null)`. */
        fun memoryLimit(memoryLimit: Optional<MemoryLimit>) = memoryLimit(memoryLimit.getOrNull())

        /**
         * Sets [Builder.memoryLimit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.memoryLimit] with a well-typed [MemoryLimit] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun memoryLimit(memoryLimit: JsonField<MemoryLimit>) = apply {
            this.memoryLimit = memoryLimit
        }

        /** Network access policy for the container. */
        fun networkPolicy(networkPolicy: NetworkPolicy) = networkPolicy(JsonField.of(networkPolicy))

        /**
         * Sets [Builder.networkPolicy] to an arbitrary JSON value.
         *
         * You should usually call [Builder.networkPolicy] with a well-typed [NetworkPolicy] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun networkPolicy(networkPolicy: JsonField<NetworkPolicy>) = apply {
            this.networkPolicy = networkPolicy
        }

        /** Alias for calling [networkPolicy] with `NetworkPolicy.ofDisabled(disabled)`. */
        fun networkPolicy(disabled: ContainerNetworkPolicyDisabled) =
            networkPolicy(NetworkPolicy.ofDisabled(disabled))

        /** Alias for calling [networkPolicy] with `NetworkPolicy.ofAllowlist(allowlist)`. */
        fun networkPolicy(allowlist: ContainerNetworkPolicyAllowlist) =
            networkPolicy(NetworkPolicy.ofAllowlist(allowlist))

        /**
         * Alias for calling [networkPolicy] with the following:
         * ```java
         * ContainerNetworkPolicyAllowlist.builder()
         *     .allowedDomains(allowedDomains)
         *     .build()
         * ```
         */
        fun allowlistNetworkPolicy(allowedDomains: List<String>) =
            networkPolicy(
                ContainerNetworkPolicyAllowlist.builder().allowedDomains(allowedDomains).build()
            )

        /** An optional list of skills referenced by id or inline data. */
        fun skills(skills: List<Skill>) = skills(JsonField.of(skills))

        /**
         * Sets [Builder.skills] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skills] with a well-typed `List<Skill>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun skills(skills: JsonField<List<Skill>>) = apply {
            this.skills = skills.map { it.toMutableList() }
        }

        /**
         * Adds a single [Skill] to [skills].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSkill(skill: Skill) = apply {
            skills =
                (skills ?: JsonField.of(mutableListOf())).also {
                    checkKnown("skills", it).add(skill)
                }
        }

        /** Alias for calling [addSkill] with `Skill.ofReference(reference)`. */
        fun addSkill(reference: SkillReference) = addSkill(Skill.ofReference(reference))

        /**
         * Alias for calling [addSkill] with the following:
         * ```java
         * SkillReference.builder()
         *     .skillId(skillId)
         *     .build()
         * ```
         */
        fun addReferenceSkill(skillId: String) =
            addSkill(SkillReference.builder().skillId(skillId).build())

        /** Alias for calling [addSkill] with `Skill.ofInline(inline)`. */
        fun addSkill(inline: InlineSkill) = addSkill(Skill.ofInline(inline))

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
         * Returns an immutable instance of [ContainerAuto].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContainerAuto =
            ContainerAuto(
                type,
                (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                memoryLimit,
                networkPolicy,
                (skills ?: JsonMissing.of()).map { it.toImmutable() },
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ContainerAuto = apply {
        if (validated) {
            return@apply
        }

        _type().let {
            if (it != JsonValue.from("container_auto")) {
                throw OpenAIInvalidDataException("'type' is invalid, received $it")
            }
        }
        fileIds()
        memoryLimit().ifPresent { it.validate() }
        networkPolicy().ifPresent { it.validate() }
        skills().ifPresent { it.forEach { it.validate() } }
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
        type.let { if (it == JsonValue.from("container_auto")) 1 else 0 } +
            (fileIds.asKnown().getOrNull()?.size ?: 0) +
            (memoryLimit.asKnown().getOrNull()?.validity() ?: 0) +
            (networkPolicy.asKnown().getOrNull()?.validity() ?: 0) +
            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

    /** The memory limit for the container. */
    class MemoryLimit @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val _1G = of("1g")

            @JvmField val _4G = of("4g")

            @JvmField val _16G = of("16g")

            @JvmField val _64G = of("64g")

            @JvmStatic fun of(value: String) = MemoryLimit(JsonField.of(value))
        }

        /** An enum containing [MemoryLimit]'s known values. */
        enum class Known {
            _1G,
            _4G,
            _16G,
            _64G,
        }

        /**
         * An enum containing [MemoryLimit]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [MemoryLimit] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            _1G,
            _4G,
            _16G,
            _64G,
            /**
             * An enum member indicating that [MemoryLimit] was instantiated with an unknown value.
             */
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
                _1G -> Value._1G
                _4G -> Value._4G
                _16G -> Value._16G
                _64G -> Value._64G
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
                _1G -> Known._1G
                _4G -> Known._4G
                _16G -> Known._16G
                _64G -> Known._64G
                else -> throw OpenAIInvalidDataException("Unknown MemoryLimit: $value")
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

        fun validate(): MemoryLimit = apply {
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

            return other is MemoryLimit && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /** Network access policy for the container. */
    @JsonDeserialize(using = NetworkPolicy.Deserializer::class)
    @JsonSerialize(using = NetworkPolicy.Serializer::class)
    class NetworkPolicy
    private constructor(
        private val disabled: ContainerNetworkPolicyDisabled? = null,
        private val allowlist: ContainerNetworkPolicyAllowlist? = null,
        private val _json: JsonValue? = null,
    ) {

        fun disabled(): Optional<ContainerNetworkPolicyDisabled> = Optional.ofNullable(disabled)

        fun allowlist(): Optional<ContainerNetworkPolicyAllowlist> = Optional.ofNullable(allowlist)

        fun isDisabled(): Boolean = disabled != null

        fun isAllowlist(): Boolean = allowlist != null

        fun asDisabled(): ContainerNetworkPolicyDisabled = disabled.getOrThrow("disabled")

        fun asAllowlist(): ContainerNetworkPolicyAllowlist = allowlist.getOrThrow("allowlist")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                disabled != null -> visitor.visitDisabled(disabled)
                allowlist != null -> visitor.visitAllowlist(allowlist)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): NetworkPolicy = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitDisabled(disabled: ContainerNetworkPolicyDisabled) {
                        disabled.validate()
                    }

                    override fun visitAllowlist(allowlist: ContainerNetworkPolicyAllowlist) {
                        allowlist.validate()
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
                    override fun visitDisabled(disabled: ContainerNetworkPolicyDisabled) =
                        disabled.validity()

                    override fun visitAllowlist(allowlist: ContainerNetworkPolicyAllowlist) =
                        allowlist.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is NetworkPolicy &&
                disabled == other.disabled &&
                allowlist == other.allowlist
        }

        override fun hashCode(): Int = Objects.hash(disabled, allowlist)

        override fun toString(): String =
            when {
                disabled != null -> "NetworkPolicy{disabled=$disabled}"
                allowlist != null -> "NetworkPolicy{allowlist=$allowlist}"
                _json != null -> "NetworkPolicy{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid NetworkPolicy")
            }

        companion object {

            @JvmStatic
            fun ofDisabled(disabled: ContainerNetworkPolicyDisabled) =
                NetworkPolicy(disabled = disabled)

            @JvmStatic
            fun ofAllowlist(allowlist: ContainerNetworkPolicyAllowlist) =
                NetworkPolicy(allowlist = allowlist)
        }

        /**
         * An interface that defines how to map each variant of [NetworkPolicy] to a value of type
         * [T].
         */
        interface Visitor<out T> {

            fun visitDisabled(disabled: ContainerNetworkPolicyDisabled): T

            fun visitAllowlist(allowlist: ContainerNetworkPolicyAllowlist): T

            /**
             * Maps an unknown variant of [NetworkPolicy] to a value of type [T].
             *
             * An instance of [NetworkPolicy] can contain an unknown variant if it was deserialized
             * from data that doesn't match any known variant. For example, if the SDK is on an
             * older version than the API, then the API may respond with new variants that the SDK
             * is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown NetworkPolicy: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<NetworkPolicy>(NetworkPolicy::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): NetworkPolicy {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "disabled" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<ContainerNetworkPolicyDisabled>(),
                            )
                            ?.let { NetworkPolicy(disabled = it, _json = json) }
                            ?: NetworkPolicy(_json = json)
                    }
                    "allowlist" -> {
                        return tryDeserialize(
                                node,
                                jacksonTypeRef<ContainerNetworkPolicyAllowlist>(),
                            )
                            ?.let { NetworkPolicy(allowlist = it, _json = json) }
                            ?: NetworkPolicy(_json = json)
                    }
                }

                return NetworkPolicy(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<NetworkPolicy>(NetworkPolicy::class) {

            override fun serialize(
                value: NetworkPolicy,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.disabled != null -> generator.writeObject(value.disabled)
                    value.allowlist != null -> generator.writeObject(value.allowlist)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid NetworkPolicy")
                }
            }
        }
    }

    @JsonDeserialize(using = Skill.Deserializer::class)
    @JsonSerialize(using = Skill.Serializer::class)
    class Skill
    private constructor(
        private val reference: SkillReference? = null,
        private val inline: InlineSkill? = null,
        private val _json: JsonValue? = null,
    ) {

        fun reference(): Optional<SkillReference> = Optional.ofNullable(reference)

        fun inline(): Optional<InlineSkill> = Optional.ofNullable(inline)

        fun isReference(): Boolean = reference != null

        fun isInline(): Boolean = inline != null

        fun asReference(): SkillReference = reference.getOrThrow("reference")

        fun asInline(): InlineSkill = inline.getOrThrow("inline")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                reference != null -> visitor.visitReference(reference)
                inline != null -> visitor.visitInline(inline)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Skill = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitReference(reference: SkillReference) {
                        reference.validate()
                    }

                    override fun visitInline(inline: InlineSkill) {
                        inline.validate()
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
                    override fun visitReference(reference: SkillReference) = reference.validity()

                    override fun visitInline(inline: InlineSkill) = inline.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Skill && reference == other.reference && inline == other.inline
        }

        override fun hashCode(): Int = Objects.hash(reference, inline)

        override fun toString(): String =
            when {
                reference != null -> "Skill{reference=$reference}"
                inline != null -> "Skill{inline=$inline}"
                _json != null -> "Skill{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Skill")
            }

        companion object {

            @JvmStatic fun ofReference(reference: SkillReference) = Skill(reference = reference)

            @JvmStatic fun ofInline(inline: InlineSkill) = Skill(inline = inline)
        }

        /** An interface that defines how to map each variant of [Skill] to a value of type [T]. */
        interface Visitor<out T> {

            fun visitReference(reference: SkillReference): T

            fun visitInline(inline: InlineSkill): T

            /**
             * Maps an unknown variant of [Skill] to a value of type [T].
             *
             * An instance of [Skill] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Skill: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Skill>(Skill::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Skill {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "skill_reference" -> {
                        return tryDeserialize(node, jacksonTypeRef<SkillReference>())?.let {
                            Skill(reference = it, _json = json)
                        } ?: Skill(_json = json)
                    }
                    "inline" -> {
                        return tryDeserialize(node, jacksonTypeRef<InlineSkill>())?.let {
                            Skill(inline = it, _json = json)
                        } ?: Skill(_json = json)
                    }
                }

                return Skill(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Skill>(Skill::class) {

            override fun serialize(
                value: Skill,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.reference != null -> generator.writeObject(value.reference)
                    value.inline != null -> generator.writeObject(value.inline)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Skill")
                }
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContainerAuto &&
            type == other.type &&
            fileIds == other.fileIds &&
            memoryLimit == other.memoryLimit &&
            networkPolicy == other.networkPolicy &&
            skills == other.skills &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(type, fileIds, memoryLimit, networkPolicy, skills, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContainerAuto{type=$type, fileIds=$fileIds, memoryLimit=$memoryLimit, networkPolicy=$networkPolicy, skills=$skills, additionalProperties=$additionalProperties}"
}
