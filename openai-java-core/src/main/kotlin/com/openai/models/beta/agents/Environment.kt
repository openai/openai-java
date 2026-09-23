// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** The execution environment for a session. */
@JsonDeserialize(using = Environment.Deserializer::class)
@JsonSerialize(using = Environment.Serializer::class)
class Environment
private constructor(
    private val none: JsonValue? = null,
    private val openaiHosted: OpenAIHosted? = null,
    private val selfHosted: SelfHosted? = null,
    private val _json: JsonValue? = null,
) {

    /** The session talks to CCA without selecting or provisioning an execution environment. */
    fun none(): Optional<JsonValue> = Optional.ofNullable(none)

    /** An environment hosted by OpenAI. */
    fun openaiHosted(): Optional<OpenAIHosted> = Optional.ofNullable(openaiHosted)

    /** An environment hosted by the application. */
    fun selfHosted(): Optional<SelfHosted> = Optional.ofNullable(selfHosted)

    fun isNone(): Boolean = none != null

    fun isOpenAIHosted(): Boolean = openaiHosted != null

    fun isSelfHosted(): Boolean = selfHosted != null

    /** The session talks to CCA without selecting or provisioning an execution environment. */
    fun asNone(): JsonValue = none.getOrThrow("none")

    /** An environment hosted by OpenAI. */
    fun asOpenAIHosted(): OpenAIHosted = openaiHosted.getOrThrow("openaiHosted")

    /** An environment hosted by the application. */
    fun asSelfHosted(): SelfHosted = selfHosted.getOrThrow("selfHosted")

    fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

    /**
     * Maps this instance's current variant to a value of type [T] using the given [visitor].
     *
     * Note that this method is _not_ forwards compatible with new variants from the API, unless
     * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of the
     * SDK gracefully, consider overriding [Visitor.unknown]:
     * ```java
     * import com.openai.core.JsonValue;
     * import java.util.Optional;
     *
     * Optional<String> result = environment.accept(new Environment.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitNone(JsonValue none) {
     *         return Optional.of(none.toString());
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
     * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor] and
     *   the current variant is unknown.
     */
    fun <T> accept(visitor: Visitor<T>): T =
        when {
            none != null -> visitor.visitNone(none)
            openaiHosted != null -> visitor.visitOpenAIHosted(openaiHosted)
            selfHosted != null -> visitor.visitSelfHosted(selfHosted)
            else -> visitor.unknown(_json)
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
    fun validate(): Environment = apply {
        if (validated) {
            return@apply
        }

        accept(
            object : Visitor<Unit> {
                override fun visitNone(none: JsonValue) {
                    none.let {
                        if (it != JsonValue.from(mapOf("type" to "none"))) {
                            throw OpenAIInvalidDataException("'none' is invalid, received $it")
                        }
                    }
                }

                override fun visitOpenAIHosted(openaiHosted: OpenAIHosted) {
                    openaiHosted.validate()
                }

                override fun visitSelfHosted(selfHosted: SelfHosted) {
                    selfHosted.validate()
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
                override fun visitNone(none: JsonValue) =
                    none.let { if (it == JsonValue.from(mapOf("type" to "none"))) 1 else 0 }

                override fun visitOpenAIHosted(openaiHosted: OpenAIHosted) = openaiHosted.validity()

                override fun visitSelfHosted(selfHosted: SelfHosted) = selfHosted.validity()

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Environment &&
            none == other.none &&
            openaiHosted == other.openaiHosted &&
            selfHosted == other.selfHosted
    }

    override fun hashCode(): Int = Objects.hash(none, openaiHosted, selfHosted)

    override fun toString(): String =
        when {
            none != null -> "Environment{none=$none}"
            openaiHosted != null -> "Environment{openaiHosted=$openaiHosted}"
            selfHosted != null -> "Environment{selfHosted=$selfHosted}"
            _json != null -> "Environment{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid Environment")
        }

    companion object {

        /** The session talks to CCA without selecting or provisioning an execution environment. */
        @JvmStatic fun ofNone() = Environment(none = JsonValue.from(mapOf("type" to "none")))

        /** An environment hosted by OpenAI. */
        @JvmStatic
        fun ofOpenAIHosted(openaiHosted: OpenAIHosted) = Environment(openaiHosted = openaiHosted)

        /** An environment hosted by the application. */
        @JvmStatic fun ofSelfHosted(selfHosted: SelfHosted) = Environment(selfHosted = selfHosted)
    }

    /**
     * An interface that defines how to map each variant of [Environment] to a value of type [T].
     */
    interface Visitor<out T> {

        /** The session talks to CCA without selecting or provisioning an execution environment. */
        fun visitNone(none: JsonValue): T

        /** An environment hosted by OpenAI. */
        fun visitOpenAIHosted(openaiHosted: OpenAIHosted): T

        /** An environment hosted by the application. */
        fun visitSelfHosted(selfHosted: SelfHosted): T

        /**
         * Maps an unknown variant of [Environment] to a value of type [T].
         *
         * An instance of [Environment] can contain an unknown variant if it was deserialized from
         * data that doesn't match any known variant. For example, if the SDK is on an older version
         * than the API, then the API may respond with new variants that the SDK is unaware of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown Environment: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<Environment>(Environment::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): Environment {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "none" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { Environment(none = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: Environment(_json = json)
                }
                "openai_hosted" -> {
                    return tryDeserialize(node, jacksonTypeRef<OpenAIHosted>())?.let {
                        Environment(openaiHosted = it, _json = json)
                    } ?: Environment(_json = json)
                }
                "self_hosted" -> {
                    return tryDeserialize(node, jacksonTypeRef<SelfHosted>())?.let {
                        Environment(selfHosted = it, _json = json)
                    } ?: Environment(_json = json)
                }
            }

            return Environment(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<Environment>(Environment::class) {

        override fun serialize(
            value: Environment,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.none != null -> generator.writeObject(value.none)
                value.openaiHosted != null -> generator.writeObject(value.openaiHosted)
                value.selfHosted != null -> generator.writeObject(value.selfHosted)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid Environment")
            }
        }
    }

    /** An environment hosted by OpenAI. */
    class OpenAIHosted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val capabilityDirectories: JsonField<List<String>>,
        private val files: JsonField<List<HostedEnvironmentFile>>,
        private val network: JsonField<Network>,
        private val packages: JsonField<Packages>,
        private val plugins: JsonField<List<HostedPlugin>>,
        private val skills: JsonField<List<HostedSkill>>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("capability_directories")
            @ExcludeMissing
            capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("files")
            @ExcludeMissing
            files: JsonField<List<HostedEnvironmentFile>> = JsonMissing.of(),
            @JsonProperty("network") @ExcludeMissing network: JsonField<Network> = JsonMissing.of(),
            @JsonProperty("packages")
            @ExcludeMissing
            packages: JsonField<Packages> = JsonMissing.of(),
            @JsonProperty("plugins")
            @ExcludeMissing
            plugins: JsonField<List<HostedPlugin>> = JsonMissing.of(),
            @JsonProperty("skills")
            @ExcludeMissing
            skills: JsonField<List<HostedSkill>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(
            id,
            capabilityDirectories,
            files,
            network,
            packages,
            plugins,
            skills,
            type,
            mutableMapOf(),
        )

        /**
         * The public ID of the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Directories that contain capabilities exposed to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun capabilityDirectories(): List<String> =
            capabilityDirectories.getRequired("capability_directories")

        /**
         * Files available in the environment, excluding their contents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun files(): List<HostedEnvironmentFile> = files.getRequired("files")

        /**
         * The effective network access policy for the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun network(): Network = network.getRequired("network")

        /**
         * Packages installed in the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun packages(): Packages = packages.getRequired("packages")

        /**
         * Plugins installed in the environment, excluding their archive contents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun plugins(): List<HostedPlugin> = plugins.getRequired("plugins")

        /**
         * Skills installed in the environment, excluding their archive contents.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun skills(): List<HostedSkill> = skills.getRequired("skills")

        /**
         * The type of the object. Always `openai_hosted`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("openai_hosted")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [capabilityDirectories].
         *
         * Unlike [capabilityDirectories], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("capability_directories")
        @ExcludeMissing
        fun _capabilityDirectories(): JsonField<List<String>> = capabilityDirectories

        /**
         * Returns the raw JSON value of [files].
         *
         * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("files")
        @ExcludeMissing
        fun _files(): JsonField<List<HostedEnvironmentFile>> = files

        /**
         * Returns the raw JSON value of [network].
         *
         * Unlike [network], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("network") @ExcludeMissing fun _network(): JsonField<Network> = network

        /**
         * Returns the raw JSON value of [packages].
         *
         * Unlike [packages], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("packages") @ExcludeMissing fun _packages(): JsonField<Packages> = packages

        /**
         * Returns the raw JSON value of [plugins].
         *
         * Unlike [plugins], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("plugins")
        @ExcludeMissing
        fun _plugins(): JsonField<List<HostedPlugin>> = plugins

        /**
         * Returns the raw JSON value of [skills].
         *
         * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<HostedSkill>> = skills

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
             * Returns a mutable builder for constructing an instance of [OpenAIHosted].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .capabilityDirectories()
             * .files()
             * .network()
             * .packages()
             * .plugins()
             * .skills()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OpenAIHosted]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var capabilityDirectories: JsonField<MutableList<String>>? = null
            private var files: JsonField<MutableList<HostedEnvironmentFile>>? = null
            private var network: JsonField<Network>? = null
            private var packages: JsonField<Packages>? = null
            private var plugins: JsonField<MutableList<HostedPlugin>>? = null
            private var skills: JsonField<MutableList<HostedSkill>>? = null
            private var type: JsonValue = JsonValue.from("openai_hosted")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(openaiHosted: OpenAIHosted) = apply {
                id = openaiHosted.id
                capabilityDirectories =
                    openaiHosted.capabilityDirectories.map { it.toMutableList() }
                files = openaiHosted.files.map { it.toMutableList() }
                network = openaiHosted.network
                packages = openaiHosted.packages
                plugins = openaiHosted.plugins.map { it.toMutableList() }
                skills = openaiHosted.skills.map { it.toMutableList() }
                type = openaiHosted.type
                additionalProperties = openaiHosted.additionalProperties.toMutableMap()
            }

            /** The public ID of the environment. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Directories that contain capabilities exposed to the agent. */
            fun capabilityDirectories(capabilityDirectories: List<String>) =
                capabilityDirectories(JsonField.of(capabilityDirectories))

            /**
             * Sets [Builder.capabilityDirectories] to an arbitrary JSON value.
             *
             * You should usually call [Builder.capabilityDirectories] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun capabilityDirectories(capabilityDirectories: JsonField<List<String>>) = apply {
                this.capabilityDirectories = capabilityDirectories.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [capabilityDirectories].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCapabilityDirectory(capabilityDirectory: String) = apply {
                capabilityDirectories =
                    (capabilityDirectories ?: JsonField.of(mutableListOf())).also {
                        checkKnown("capabilityDirectories", it).add(capabilityDirectory)
                    }
            }

            /** Files available in the environment, excluding their contents. */
            fun files(files: List<HostedEnvironmentFile>) = files(JsonField.of(files))

            /**
             * Sets [Builder.files] to an arbitrary JSON value.
             *
             * You should usually call [Builder.files] with a well-typed
             * `List<HostedEnvironmentFile>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
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
                    (files ?: JsonField.of(mutableListOf())).also {
                        checkKnown("files", it).add(file)
                    }
            }

            /** Alias for calling [addFile] with `HostedEnvironmentFile.ofFileId(fileId)`. */
            fun addFile(fileId: HostedEnvironmentFileId) =
                addFile(HostedEnvironmentFile.ofFileId(fileId))

            /** Alias for calling [addFile] with `HostedEnvironmentFile.ofInline(inline)`. */
            fun addFile(inline: HostedEnvironmentFile.Inline) =
                addFile(HostedEnvironmentFile.ofInline(inline))

            /** The effective network access policy for the environment. */
            fun network(network: Network) = network(JsonField.of(network))

            /**
             * Sets [Builder.network] to an arbitrary JSON value.
             *
             * You should usually call [Builder.network] with a well-typed [Network] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun network(network: JsonField<Network>) = apply { this.network = network }

            /** Packages installed in the environment. */
            fun packages(packages: Packages) = packages(JsonField.of(packages))

            /**
             * Sets [Builder.packages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.packages] with a well-typed [Packages] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun packages(packages: JsonField<Packages>) = apply { this.packages = packages }

            /** Plugins installed in the environment, excluding their archive contents. */
            fun plugins(plugins: List<HostedPlugin>) = plugins(JsonField.of(plugins))

            /**
             * Sets [Builder.plugins] to an arbitrary JSON value.
             *
             * You should usually call [Builder.plugins] with a well-typed `List<HostedPlugin>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            /** Skills installed in the environment, excluding their archive contents. */
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

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("openai_hosted")
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [OpenAIHosted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .capabilityDirectories()
             * .files()
             * .network()
             * .packages()
             * .plugins()
             * .skills()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): OpenAIHosted =
                OpenAIHosted(
                    checkRequired("id", id),
                    checkRequired("capabilityDirectories", capabilityDirectories).map {
                        it.toImmutable()
                    },
                    checkRequired("files", files).map { it.toImmutable() },
                    checkRequired("network", network),
                    checkRequired("packages", packages),
                    checkRequired("plugins", plugins).map { it.toImmutable() },
                    checkRequired("skills", skills).map { it.toImmutable() },
                    type,
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
        fun validate(): OpenAIHosted = apply {
            if (validated) {
                return@apply
            }

            id()
            capabilityDirectories()
            files().forEach { it.validate() }
            network().validate()
            packages().validate()
            plugins().forEach { it.validate() }
            skills().forEach { it.validate() }
            _type().let {
                if (it != JsonValue.from("openai_hosted")) {
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
            (if (id.asKnown().isPresent) 1 else 0) +
                (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
                (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (network.asKnown().getOrNull()?.validity() ?: 0) +
                (packages.asKnown().getOrNull()?.validity() ?: 0) +
                (plugins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("openai_hosted")) 1 else 0 }

        /** The effective network access policy for the environment. */
        class Network
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val access: JsonField<Access>,
            private val allowedDomains: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("access")
                @ExcludeMissing
                access: JsonField<Access> = JsonMissing.of(),
                @JsonProperty("allowed_domains")
                @ExcludeMissing
                allowedDomains: JsonField<List<String>> = JsonMissing.of(),
            ) : this(access, allowedDomains, mutableMapOf())

            /**
             * The environment's network access mode.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun access(): Access = access.getRequired("access")

            /**
             * Domains the environment may access when network access is restricted.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun allowedDomains(): List<String> = allowedDomains.getRequired("allowed_domains")

            /**
             * Returns the raw JSON value of [access].
             *
             * Unlike [access], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("access") @ExcludeMissing fun _access(): JsonField<Access> = access

            /**
             * Returns the raw JSON value of [allowedDomains].
             *
             * Unlike [allowedDomains], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("allowed_domains")
            @ExcludeMissing
            fun _allowedDomains(): JsonField<List<String>> = allowedDomains

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
                 * Returns a mutable builder for constructing an instance of [Network].
                 *
                 * The following fields are required:
                 * ```java
                 * .access()
                 * .allowedDomains()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Network]. */
            class Builder internal constructor() {

                private var access: JsonField<Access>? = null
                private var allowedDomains: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(network: Network) = apply {
                    access = network.access
                    allowedDomains = network.allowedDomains.map { it.toMutableList() }
                    additionalProperties = network.additionalProperties.toMutableMap()
                }

                /** The environment's network access mode. */
                fun access(access: Access) = access(JsonField.of(access))

                /**
                 * Sets [Builder.access] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.access] with a well-typed [Access] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun access(access: JsonField<Access>) = apply { this.access = access }

                /** Domains the environment may access when network access is restricted. */
                fun allowedDomains(allowedDomains: List<String>) =
                    allowedDomains(JsonField.of(allowedDomains))

                /**
                 * Sets [Builder.allowedDomains] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.allowedDomains] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun allowedDomains(allowedDomains: JsonField<List<String>>) = apply {
                    this.allowedDomains = allowedDomains.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [allowedDomains].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAllowedDomain(allowedDomain: String) = apply {
                    allowedDomains =
                        (allowedDomains ?: JsonField.of(mutableListOf())).also {
                            checkKnown("allowedDomains", it).add(allowedDomain)
                        }
                }

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
                 * Returns an immutable instance of [Network].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .access()
                 * .allowedDomains()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Network =
                    Network(
                        checkRequired("access", access),
                        checkRequired("allowedDomains", allowedDomains).map { it.toImmutable() },
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
            fun validate(): Network = apply {
                if (validated) {
                    return@apply
                }

                access().validate()
                allowedDomains()
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
                (access.asKnown().getOrNull()?.validity() ?: 0) +
                    (allowedDomains.asKnown().getOrNull()?.size ?: 0)

            /** The environment's network access mode. */
            class Access @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    /** Allows unrestricted network access. */
                    @JvmField val ENABLED = of("enabled")

                    /** Disables network access. */
                    @JvmField val DISABLED = of("disabled")

                    /** Allows access only to configured domains. */
                    @JvmField val RESTRICTED = of("restricted")

                    @JvmStatic fun of(value: String) = Access(JsonField.of(value))
                }

                /** An enum containing [Access]'s known values. */
                enum class Known {
                    /** Allows unrestricted network access. */
                    ENABLED,
                    /** Disables network access. */
                    DISABLED,
                    /** Allows access only to configured domains. */
                    RESTRICTED,
                }

                /**
                 * An enum containing [Access]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Access] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    /** Allows unrestricted network access. */
                    ENABLED,
                    /** Disables network access. */
                    DISABLED,
                    /** Allows access only to configured domains. */
                    RESTRICTED,
                    /**
                     * An enum member indicating that [Access] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ENABLED -> Value.ENABLED
                        DISABLED -> Value.DISABLED
                        RESTRICTED -> Value.RESTRICTED
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        ENABLED -> Known.ENABLED
                        DISABLED -> Known.DISABLED
                        RESTRICTED -> Known.RESTRICTED
                        else -> throw OpenAIInvalidDataException("Unknown Access: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws OpenAIInvalidDataException if this class instance's value does not have
                 *   the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        OpenAIInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                /**
                 * Validates that the types of all values in this object match their expected types
                 * recursively.
                 *
                 * This method is _not_ forwards compatible with new types from the API for existing
                 * fields.
                 *
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Access = apply {
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

                    return other is Access && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Network &&
                    access == other.access &&
                    allowedDomains == other.allowedDomains &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(access, allowedDomains, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Network{access=$access, allowedDomains=$allowedDomains, additionalProperties=$additionalProperties}"
        }

        /** Packages installed in the environment. */
        class Packages
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val npm: JsonField<List<String>>,
            private val python: JsonField<List<String>>,
            private val system: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("npm")
                @ExcludeMissing
                npm: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("python")
                @ExcludeMissing
                python: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("system")
                @ExcludeMissing
                system: JsonField<List<String>> = JsonMissing.of(),
            ) : this(npm, python, system, mutableMapOf())

            /**
             * npm packages installed globally in the environment.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun npm(): List<String> = npm.getRequired("npm")

            /**
             * Python packages installed in the environment.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun python(): List<String> = python.getRequired("python")

            /**
             * System packages installed in the environment.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun system(): List<String> = system.getRequired("system")

            /**
             * Returns the raw JSON value of [npm].
             *
             * Unlike [npm], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("npm") @ExcludeMissing fun _npm(): JsonField<List<String>> = npm

            /**
             * Returns the raw JSON value of [python].
             *
             * Unlike [python], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("python") @ExcludeMissing fun _python(): JsonField<List<String>> = python

            /**
             * Returns the raw JSON value of [system].
             *
             * Unlike [system], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("system") @ExcludeMissing fun _system(): JsonField<List<String>> = system

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
                 * Returns a mutable builder for constructing an instance of [Packages].
                 *
                 * The following fields are required:
                 * ```java
                 * .npm()
                 * .python()
                 * .system()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Packages]. */
            class Builder internal constructor() {

                private var npm: JsonField<MutableList<String>>? = null
                private var python: JsonField<MutableList<String>>? = null
                private var system: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(packages: Packages) = apply {
                    npm = packages.npm.map { it.toMutableList() }
                    python = packages.python.map { it.toMutableList() }
                    system = packages.system.map { it.toMutableList() }
                    additionalProperties = packages.additionalProperties.toMutableMap()
                }

                /** npm packages installed globally in the environment. */
                fun npm(npm: List<String>) = npm(JsonField.of(npm))

                /**
                 * Sets [Builder.npm] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.npm] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun npm(npm: JsonField<List<String>>) = apply {
                    this.npm = npm.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.npm].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addNpm(npm: String) = apply {
                    this.npm =
                        (this.npm ?: JsonField.of(mutableListOf())).also {
                            checkKnown("npm", it).add(npm)
                        }
                }

                /** Python packages installed in the environment. */
                fun python(python: List<String>) = python(JsonField.of(python))

                /**
                 * Sets [Builder.python] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.python] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun python(python: JsonField<List<String>>) = apply {
                    this.python = python.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.python].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addPython(python: String) = apply {
                    this.python =
                        (this.python ?: JsonField.of(mutableListOf())).also {
                            checkKnown("python", it).add(python)
                        }
                }

                /** System packages installed in the environment. */
                fun system(system: List<String>) = system(JsonField.of(system))

                /**
                 * Sets [Builder.system] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.system] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun system(system: JsonField<List<String>>) = apply {
                    this.system = system.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [Builder.system].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSystem(system: String) = apply {
                    this.system =
                        (this.system ?: JsonField.of(mutableListOf())).also {
                            checkKnown("system", it).add(system)
                        }
                }

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
                 * Returns an immutable instance of [Packages].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .npm()
                 * .python()
                 * .system()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Packages =
                    Packages(
                        checkRequired("npm", npm).map { it.toImmutable() },
                        checkRequired("python", python).map { it.toImmutable() },
                        checkRequired("system", system).map { it.toImmutable() },
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
            fun validate(): Packages = apply {
                if (validated) {
                    return@apply
                }

                npm()
                python()
                system()
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
                (npm.asKnown().getOrNull()?.size ?: 0) +
                    (python.asKnown().getOrNull()?.size ?: 0) +
                    (system.asKnown().getOrNull()?.size ?: 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Packages &&
                    npm == other.npm &&
                    python == other.python &&
                    system == other.system &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(npm, python, system, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Packages{npm=$npm, python=$python, system=$system, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OpenAIHosted &&
                id == other.id &&
                capabilityDirectories == other.capabilityDirectories &&
                files == other.files &&
                network == other.network &&
                packages == other.packages &&
                plugins == other.plugins &&
                skills == other.skills &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                capabilityDirectories,
                files,
                network,
                packages,
                plugins,
                skills,
                type,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "OpenAIHosted{id=$id, capabilityDirectories=$capabilityDirectories, files=$files, network=$network, packages=$packages, plugins=$plugins, skills=$skills, type=$type, additionalProperties=$additionalProperties}"
    }

    /** An environment hosted by the application. */
    class SelfHosted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val id: JsonField<String>,
        private val capabilityDirectories: JsonField<List<String>>,
        private val remoteUrl: JsonField<String>,
        private val type: JsonValue,
        private val workspaceDirectory: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
            @JsonProperty("capability_directories")
            @ExcludeMissing
            capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("remote_url")
            @ExcludeMissing
            remoteUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("workspace_directory")
            @ExcludeMissing
            workspaceDirectory: JsonField<String> = JsonMissing.of(),
        ) : this(id, capabilityDirectories, remoteUrl, type, workspaceDirectory, mutableMapOf())

        /**
         * The public ID of the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun id(): String = id.getRequired("id")

        /**
         * Directories that contain capabilities exposed to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun capabilityDirectories(): List<String> =
            capabilityDirectories.getRequired("capability_directories")

        /**
         * Pass this URL unchanged to `codex exec-server --remote` when connecting this environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun remoteUrl(): String = remoteUrl.getRequired("remote_url")

        /**
         * The type of the object. Always `self_hosted`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("self_hosted")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The absolute project directory inside the environment. Defaults to `/workspace`.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun workspaceDirectory(): String = workspaceDirectory.getRequired("workspace_directory")

        /**
         * Returns the raw JSON value of [id].
         *
         * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

        /**
         * Returns the raw JSON value of [capabilityDirectories].
         *
         * Unlike [capabilityDirectories], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("capability_directories")
        @ExcludeMissing
        fun _capabilityDirectories(): JsonField<List<String>> = capabilityDirectories

        /**
         * Returns the raw JSON value of [remoteUrl].
         *
         * Unlike [remoteUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("remote_url") @ExcludeMissing fun _remoteUrl(): JsonField<String> = remoteUrl

        /**
         * Returns the raw JSON value of [workspaceDirectory].
         *
         * Unlike [workspaceDirectory], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("workspace_directory")
        @ExcludeMissing
        fun _workspaceDirectory(): JsonField<String> = workspaceDirectory

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
             * Returns a mutable builder for constructing an instance of [SelfHosted].
             *
             * The following fields are required:
             * ```java
             * .id()
             * .capabilityDirectories()
             * .remoteUrl()
             * .workspaceDirectory()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SelfHosted]. */
        class Builder internal constructor() {

            private var id: JsonField<String>? = null
            private var capabilityDirectories: JsonField<MutableList<String>>? = null
            private var remoteUrl: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("self_hosted")
            private var workspaceDirectory: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(selfHosted: SelfHosted) = apply {
                id = selfHosted.id
                capabilityDirectories = selfHosted.capabilityDirectories.map { it.toMutableList() }
                remoteUrl = selfHosted.remoteUrl
                type = selfHosted.type
                workspaceDirectory = selfHosted.workspaceDirectory
                additionalProperties = selfHosted.additionalProperties.toMutableMap()
            }

            /** The public ID of the environment. */
            fun id(id: String) = id(JsonField.of(id))

            /**
             * Sets [Builder.id] to an arbitrary JSON value.
             *
             * You should usually call [Builder.id] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun id(id: JsonField<String>) = apply { this.id = id }

            /** Directories that contain capabilities exposed to the agent. */
            fun capabilityDirectories(capabilityDirectories: List<String>) =
                capabilityDirectories(JsonField.of(capabilityDirectories))

            /**
             * Sets [Builder.capabilityDirectories] to an arbitrary JSON value.
             *
             * You should usually call [Builder.capabilityDirectories] with a well-typed
             * `List<String>` value instead. This method is primarily for setting the field to an
             * undocumented or not yet supported value.
             */
            fun capabilityDirectories(capabilityDirectories: JsonField<List<String>>) = apply {
                this.capabilityDirectories = capabilityDirectories.map { it.toMutableList() }
            }

            /**
             * Adds a single [String] to [capabilityDirectories].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCapabilityDirectory(capabilityDirectory: String) = apply {
                capabilityDirectories =
                    (capabilityDirectories ?: JsonField.of(mutableListOf())).also {
                        checkKnown("capabilityDirectories", it).add(capabilityDirectory)
                    }
            }

            /**
             * Pass this URL unchanged to `codex exec-server --remote` when connecting this
             * environment.
             */
            fun remoteUrl(remoteUrl: String) = remoteUrl(JsonField.of(remoteUrl))

            /**
             * Sets [Builder.remoteUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.remoteUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun remoteUrl(remoteUrl: JsonField<String>) = apply { this.remoteUrl = remoteUrl }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("self_hosted")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The absolute project directory inside the environment. Defaults to `/workspace`. */
            fun workspaceDirectory(workspaceDirectory: String) =
                workspaceDirectory(JsonField.of(workspaceDirectory))

            /**
             * Sets [Builder.workspaceDirectory] to an arbitrary JSON value.
             *
             * You should usually call [Builder.workspaceDirectory] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun workspaceDirectory(workspaceDirectory: JsonField<String>) = apply {
                this.workspaceDirectory = workspaceDirectory
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
             * Returns an immutable instance of [SelfHosted].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .id()
             * .capabilityDirectories()
             * .remoteUrl()
             * .workspaceDirectory()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SelfHosted =
                SelfHosted(
                    checkRequired("id", id),
                    checkRequired("capabilityDirectories", capabilityDirectories).map {
                        it.toImmutable()
                    },
                    checkRequired("remoteUrl", remoteUrl),
                    type,
                    checkRequired("workspaceDirectory", workspaceDirectory),
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
        fun validate(): SelfHosted = apply {
            if (validated) {
                return@apply
            }

            id()
            capabilityDirectories()
            remoteUrl()
            _type().let {
                if (it != JsonValue.from("self_hosted")) {
                    throw OpenAIInvalidDataException("'type' is invalid, received $it")
                }
            }
            workspaceDirectory()
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
                (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
                (if (remoteUrl.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("self_hosted")) 1 else 0 } +
                (if (workspaceDirectory.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SelfHosted &&
                id == other.id &&
                capabilityDirectories == other.capabilityDirectories &&
                remoteUrl == other.remoteUrl &&
                type == other.type &&
                workspaceDirectory == other.workspaceDirectory &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                id,
                capabilityDirectories,
                remoteUrl,
                type,
                workspaceDirectory,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SelfHosted{id=$id, capabilityDirectories=$capabilityDirectories, remoteUrl=$remoteUrl, type=$type, workspaceDirectory=$workspaceDirectory, additionalProperties=$additionalProperties}"
    }
}
