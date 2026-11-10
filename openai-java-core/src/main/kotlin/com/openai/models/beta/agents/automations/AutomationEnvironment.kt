// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

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
import com.openai.core.JsonNull
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.HostedPlugin
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Environment selection saved before an invocation creates its session. */
@JsonDeserialize(using = AutomationEnvironment.Deserializer::class)
@JsonSerialize(using = AutomationEnvironment.Serializer::class)
class AutomationEnvironment
private constructor(
    private val none: JsonValue? = null,
    private val openaiHosted: OpenAIHosted? = null,
    private val selfHosted: SelfHosted? = null,
    private val _json: JsonValue? = null,
) {

    fun none(): Optional<JsonValue> = Optional.ofNullable(none)

    /** Hosted environment selection with confidential setup commands and variables omitted. */
    fun openaiHosted(): Optional<OpenAIHosted> = Optional.ofNullable(openaiHosted)

    fun selfHosted(): Optional<SelfHosted> = Optional.ofNullable(selfHosted)

    fun isNone(): Boolean = none != null

    fun isOpenAIHosted(): Boolean = openaiHosted != null

    fun isSelfHosted(): Boolean = selfHosted != null

    fun asNone(): JsonValue = none.getOrThrow("none")

    /** Hosted environment selection with confidential setup commands and variables omitted. */
    fun asOpenAIHosted(): OpenAIHosted = openaiHosted.getOrThrow("openaiHosted")

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
     * Optional<String> result = automationEnvironment.accept(new AutomationEnvironment.Visitor<Optional<String>>() {
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
    fun validate(): AutomationEnvironment = apply {
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

        return other is AutomationEnvironment &&
            none == other.none &&
            openaiHosted == other.openaiHosted &&
            selfHosted == other.selfHosted &&
            (none != null || openaiHosted != null || selfHosted != null || _json == other._json)
    }

    override fun hashCode(): Int =
        if (none == null && openaiHosted == null && selfHosted == null) Objects.hash(_json)
        else Objects.hash(none, openaiHosted, selfHosted)

    override fun toString(): String =
        when {
            none != null -> "AutomationEnvironment{none=$none}"
            openaiHosted != null -> "AutomationEnvironment{openaiHosted=$openaiHosted}"
            selfHosted != null -> "AutomationEnvironment{selfHosted=$selfHosted}"
            _json != null -> "AutomationEnvironment{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid AutomationEnvironment")
        }

    companion object {

        @JvmStatic
        fun ofNone() = AutomationEnvironment(none = JsonValue.from(mapOf("type" to "none")))

        /** Hosted environment selection with confidential setup commands and variables omitted. */
        @JvmStatic
        fun ofOpenAIHosted(openaiHosted: OpenAIHosted) =
            AutomationEnvironment(openaiHosted = openaiHosted)

        @JvmStatic
        fun ofSelfHosted(selfHosted: SelfHosted) = AutomationEnvironment(selfHosted = selfHosted)
    }

    /**
     * An interface that defines how to map each variant of [AutomationEnvironment] to a value of
     * type [T].
     */
    interface Visitor<out T> {

        fun visitNone(none: JsonValue): T = unknown(JsonValue.from(none))

        /** Hosted environment selection with confidential setup commands and variables omitted. */
        fun visitOpenAIHosted(openaiHosted: OpenAIHosted): T = unknown(JsonValue.from(openaiHosted))

        fun visitSelfHosted(selfHosted: SelfHosted): T = unknown(JsonValue.from(selfHosted))

        /**
         * Maps an unknown variant of [AutomationEnvironment] to a value of type [T].
         *
         * An instance of [AutomationEnvironment] can contain an unknown variant if it was
         * deserialized from data that doesn't match any known variant. For example, if the SDK is
         * on an older version than the API, then the API may respond with new variants that the SDK
         * is unaware of.
         *
         * Unhandled known JSON variants reach this method as JSON values.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown AutomationEnvironment")
        }
    }

    internal class Deserializer :
        BaseDeserializer<AutomationEnvironment>(AutomationEnvironment::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): AutomationEnvironment {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "none" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { AutomationEnvironment(none = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: AutomationEnvironment(_json = json)
                }
                "openai_hosted" -> {
                    return tryDeserialize(node, jacksonTypeRef<OpenAIHosted>())?.let {
                        AutomationEnvironment(openaiHosted = it, _json = json)
                    } ?: AutomationEnvironment(_json = json)
                }
                "self_hosted" -> {
                    return tryDeserialize(node, jacksonTypeRef<SelfHosted>())?.let {
                        AutomationEnvironment(selfHosted = it, _json = json)
                    } ?: AutomationEnvironment(_json = json)
                }
            }

            return AutomationEnvironment(_json = json)
        }
    }

    internal class Serializer :
        BaseSerializer<AutomationEnvironment>(AutomationEnvironment::class) {

        override fun serialize(
            value: AutomationEnvironment,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.none != null -> generator.writeObject(value.none)
                value.openaiHosted != null -> generator.writeObject(value.openaiHosted)
                value.selfHosted != null -> generator.writeObject(value.selfHosted)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid AutomationEnvironment")
            }
        }
    }

    /** Hosted environment selection with confidential setup commands and variables omitted. */
    class OpenAIHosted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val capabilityDirectories: JsonField<List<String>>,
        private val containerSize: JsonField<ContainerSize>,
        private val desktop: JsonField<Desktop>,
        private val environmentId: JsonField<String>,
        private val environmentTemplateId: JsonField<String>,
        private val files: JsonField<List<File>>,
        private val network: JsonField<Network>,
        private val packages: JsonField<Packages>,
        private val plugins: JsonField<List<HostedPlugin>>,
        private val skills: JsonField<List<Skill>>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("capability_directories")
            @ExcludeMissing
            capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("container_size")
            @ExcludeMissing
            containerSize: JsonField<ContainerSize> = JsonMissing.of(),
            @JsonProperty("desktop") @ExcludeMissing desktop: JsonField<Desktop> = JsonMissing.of(),
            @JsonProperty("environment_id")
            @ExcludeMissing
            environmentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("environment_template_id")
            @ExcludeMissing
            environmentTemplateId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("files") @ExcludeMissing files: JsonField<List<File>> = JsonMissing.of(),
            @JsonProperty("network") @ExcludeMissing network: JsonField<Network> = JsonMissing.of(),
            @JsonProperty("packages")
            @ExcludeMissing
            packages: JsonField<Packages> = JsonMissing.of(),
            @JsonProperty("plugins")
            @ExcludeMissing
            plugins: JsonField<List<HostedPlugin>> = JsonMissing.of(),
            @JsonProperty("skills")
            @ExcludeMissing
            skills: JsonField<List<Skill>> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(
            capabilityDirectories,
            containerSize,
            desktop,
            environmentId,
            environmentTemplateId,
            files,
            network,
            packages,
            plugins,
            skills,
            type,
            mutableMapOf(),
        )

        /**
         * Directory overrides, or null to inherit the template or creation default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun capabilityDirectories(): Optional<List<String>> =
            capabilityDirectories.getOptional("capability_directories")

        /**
         * The configured container size, or null to use the creation default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun containerSize(): Optional<ContainerSize> = containerSize.getOptional("container_size")

        /**
         * Desktop overrides, or null to inherit the template or creation default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun desktop(): Optional<Desktop> = desktop.getOptional("desktop")

        /**
         * An existing environment reference, or null when provisioning a new environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun environmentId(): Optional<String> = environmentId.getOptional("environment_id")

        /**
         * A template reference, or null when no template is selected.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun environmentTemplateId(): Optional<String> =
            environmentTemplateId.getOptional("environment_template_id")

        /**
         * File overrides, excluding contents, or null to inherit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun files(): Optional<List<File>> = files.getOptional("files")

        /**
         * Network overrides, or null to inherit the template or creation default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun network(): Optional<Network> = network.getOptional("network")

        /**
         * Package overrides, or null to inherit the template or creation default.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun packages(): Optional<Packages> = packages.getOptional("packages")

        /**
         * Plugin overrides, excluding archive contents, or null to inherit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun plugins(): Optional<List<HostedPlugin>> = plugins.getOptional("plugins")

        /**
         * Skill overrides, excluding archive contents, or null to inherit.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun skills(): Optional<List<Skill>> = skills.getOptional("skills")

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
         * Returns the raw JSON value of [capabilityDirectories].
         *
         * Unlike [capabilityDirectories], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("capability_directories")
        @ExcludeMissing
        fun _capabilityDirectories(): JsonField<List<String>> = capabilityDirectories

        /**
         * Returns the raw JSON value of [containerSize].
         *
         * Unlike [containerSize], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("container_size")
        @ExcludeMissing
        fun _containerSize(): JsonField<ContainerSize> = containerSize

        /**
         * Returns the raw JSON value of [desktop].
         *
         * Unlike [desktop], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("desktop") @ExcludeMissing fun _desktop(): JsonField<Desktop> = desktop

        /**
         * Returns the raw JSON value of [environmentId].
         *
         * Unlike [environmentId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("environment_id")
        @ExcludeMissing
        fun _environmentId(): JsonField<String> = environmentId

        /**
         * Returns the raw JSON value of [environmentTemplateId].
         *
         * Unlike [environmentTemplateId], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("environment_template_id")
        @ExcludeMissing
        fun _environmentTemplateId(): JsonField<String> = environmentTemplateId

        /**
         * Returns the raw JSON value of [files].
         *
         * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<File>> = files

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
        @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<Skill>> = skills

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
                "capability_directories" to this.capabilityDirectories,
                "container_size" to this.containerSize,
                "desktop" to this.desktop,
                "environment_id" to this.environmentId,
                "environment_template_id" to this.environmentTemplateId,
                "files" to this.files,
                "network" to this.network,
                "packages" to this.packages,
                "plugins" to this.plugins,
                "skills" to this.skills,
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

            /** Returns a mutable builder for constructing an instance of [OpenAIHosted]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [OpenAIHosted]. */
        class Builder internal constructor() {

            private var capabilityDirectories: JsonField<MutableList<String>>? = null
            private var containerSize: JsonField<ContainerSize>? = JsonNull.of()
            private var desktop: JsonField<Desktop>? = JsonNull.of()
            private var environmentId: JsonField<String>? = JsonNull.of()
            private var environmentTemplateId: JsonField<String>? = JsonNull.of()
            private var files: JsonField<MutableList<File>>? = null
            private var network: JsonField<Network>? = JsonNull.of()
            private var packages: JsonField<Packages>? = JsonNull.of()
            private var plugins: JsonField<MutableList<HostedPlugin>>? = null
            private var skills: JsonField<MutableList<Skill>>? = null
            private var type: JsonValue = JsonValue.from("openai_hosted")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(openaiHosted: OpenAIHosted) = apply {
                capabilityDirectories =
                    openaiHosted.capabilityDirectories.map { it.toMutableList() }
                containerSize = openaiHosted.containerSize
                desktop = openaiHosted.desktop
                environmentId = openaiHosted.environmentId
                environmentTemplateId = openaiHosted.environmentTemplateId
                files = openaiHosted.files.map { it.toMutableList() }
                network = openaiHosted.network
                packages = openaiHosted.packages
                plugins = openaiHosted.plugins.map { it.toMutableList() }
                skills = openaiHosted.skills.map { it.toMutableList() }
                type = openaiHosted.type
                additionalProperties = openaiHosted.additionalProperties.toMutableMap()
            }

            /** Directory overrides, or null to inherit the template or creation default. */
            fun capabilityDirectories(capabilityDirectories: List<String>?) =
                capabilityDirectories(JsonField.ofNullable(capabilityDirectories))

            /**
             * Alias for calling [Builder.capabilityDirectories] with
             * `capabilityDirectories.orElse(null)`.
             */
            fun capabilityDirectories(capabilityDirectories: Optional<List<String>>) =
                capabilityDirectories(capabilityDirectories.getOrNull())

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

            /** The configured container size, or null to use the creation default. */
            fun containerSize(containerSize: ContainerSize?) =
                containerSize(JsonField.ofNullable(containerSize))

            /** Alias for calling [Builder.containerSize] with `containerSize.orElse(null)`. */
            fun containerSize(containerSize: Optional<ContainerSize>) =
                containerSize(containerSize.getOrNull())

            /**
             * Sets [Builder.containerSize] to an arbitrary JSON value.
             *
             * You should usually call [Builder.containerSize] with a well-typed [ContainerSize]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun containerSize(containerSize: JsonField<ContainerSize>) = apply {
                this.containerSize = containerSize
            }

            /** Desktop overrides, or null to inherit the template or creation default. */
            fun desktop(desktop: Desktop?) = desktop(JsonField.ofNullable(desktop))

            /** Alias for calling [Builder.desktop] with `desktop.orElse(null)`. */
            fun desktop(desktop: Optional<Desktop>) = desktop(desktop.getOrNull())

            /**
             * Sets [Builder.desktop] to an arbitrary JSON value.
             *
             * You should usually call [Builder.desktop] with a well-typed [Desktop] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun desktop(desktop: JsonField<Desktop>) = apply { this.desktop = desktop }

            /** An existing environment reference, or null when provisioning a new environment. */
            fun environmentId(environmentId: String?) =
                environmentId(JsonField.ofNullable(environmentId))

            /** Alias for calling [Builder.environmentId] with `environmentId.orElse(null)`. */
            fun environmentId(environmentId: Optional<String>) =
                environmentId(environmentId.getOrNull())

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

            /** A template reference, or null when no template is selected. */
            fun environmentTemplateId(environmentTemplateId: String?) =
                environmentTemplateId(JsonField.ofNullable(environmentTemplateId))

            /**
             * Alias for calling [Builder.environmentTemplateId] with
             * `environmentTemplateId.orElse(null)`.
             */
            fun environmentTemplateId(environmentTemplateId: Optional<String>) =
                environmentTemplateId(environmentTemplateId.getOrNull())

            /**
             * Sets [Builder.environmentTemplateId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.environmentTemplateId] with a well-typed [String]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun environmentTemplateId(environmentTemplateId: JsonField<String>) = apply {
                this.environmentTemplateId = environmentTemplateId
            }

            /** File overrides, excluding contents, or null to inherit. */
            fun files(files: List<File>?) = files(JsonField.ofNullable(files))

            /** Alias for calling [Builder.files] with `files.orElse(null)`. */
            fun files(files: Optional<List<File>>) = files(files.getOrNull())

            /**
             * Sets [Builder.files] to an arbitrary JSON value.
             *
             * You should usually call [Builder.files] with a well-typed `List<File>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun files(files: JsonField<List<File>>) = apply {
                this.files = files.map { it.toMutableList() }
            }

            /**
             * Adds a single [File] to [files].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFile(file: File) = apply {
                files =
                    (files ?: JsonField.of(mutableListOf())).also {
                        checkKnown("files", it).add(file)
                    }
            }

            /** Alias for calling [addFile] with `File.ofId(id)`. */
            fun addFile(id: File.FileId) = addFile(File.ofId(id))

            /** Alias for calling [addFile] with `File.ofInline(inline)`. */
            fun addFile(inline: File.Inline) = addFile(File.ofInline(inline))

            /** Network overrides, or null to inherit the template or creation default. */
            fun network(network: Network?) = network(JsonField.ofNullable(network))

            /** Alias for calling [Builder.network] with `network.orElse(null)`. */
            fun network(network: Optional<Network>) = network(network.getOrNull())

            /**
             * Sets [Builder.network] to an arbitrary JSON value.
             *
             * You should usually call [Builder.network] with a well-typed [Network] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun network(network: JsonField<Network>) = apply { this.network = network }

            /** Package overrides, or null to inherit the template or creation default. */
            fun packages(packages: Packages?) = packages(JsonField.ofNullable(packages))

            /** Alias for calling [Builder.packages] with `packages.orElse(null)`. */
            fun packages(packages: Optional<Packages>) = packages(packages.getOrNull())

            /**
             * Sets [Builder.packages] to an arbitrary JSON value.
             *
             * You should usually call [Builder.packages] with a well-typed [Packages] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun packages(packages: JsonField<Packages>) = apply { this.packages = packages }

            /** Plugin overrides, excluding archive contents, or null to inherit. */
            fun plugins(plugins: List<HostedPlugin>?) = plugins(JsonField.ofNullable(plugins))

            /** Alias for calling [Builder.plugins] with `plugins.orElse(null)`. */
            fun plugins(plugins: Optional<List<HostedPlugin>>) = plugins(plugins.getOrNull())

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

            /** Skill overrides, excluding archive contents, or null to inherit. */
            fun skills(skills: List<Skill>?) = skills(JsonField.ofNullable(skills))

            /** Alias for calling [Builder.skills] with `skills.orElse(null)`. */
            fun skills(skills: Optional<List<Skill>>) = skills(skills.getOrNull())

            /**
             * Sets [Builder.skills] to an arbitrary JSON value.
             *
             * You should usually call [Builder.skills] with a well-typed `List<Skill>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
            fun addSkill(reference: Skill.SkillReference) = addSkill(Skill.ofReference(reference))

            /** Alias for calling [addSkill] with `Skill.ofInline(inline)`. */
            fun addSkill(inline: Skill.Inline) = addSkill(Skill.ofInline(inline))

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
             */
            fun build(): OpenAIHosted =
                OpenAIHosted(
                    checkRequired("capabilityDirectories", capabilityDirectories ?: JsonNull.of())
                        .map { it.toImmutable() },
                    checkRequired("containerSize", containerSize),
                    checkRequired("desktop", desktop),
                    checkRequired("environmentId", environmentId),
                    checkRequired("environmentTemplateId", environmentTemplateId),
                    checkRequired("files", files ?: JsonNull.of()).map { it.toImmutable() },
                    checkRequired("network", network),
                    checkRequired("packages", packages),
                    checkRequired("plugins", plugins ?: JsonNull.of()).map { it.toImmutable() },
                    checkRequired("skills", skills ?: JsonNull.of()).map { it.toImmutable() },
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

            capabilityDirectories()
            containerSize().ifPresent { it.validate() }
            desktop().ifPresent { it.validate() }
            environmentId()
            environmentTemplateId()
            files().ifPresent { it.forEach { it.validate() } }
            network().ifPresent { it.validate() }
            packages().ifPresent { it.validate() }
            plugins().ifPresent { it.forEach { it.validate() } }
            skills().ifPresent { it.forEach { it.validate() } }
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
            (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
                (containerSize.asKnown().getOrNull()?.validity() ?: 0) +
                (desktop.asKnown().getOrNull()?.validity() ?: 0) +
                (if (environmentId.asKnown().isPresent) 1 else 0) +
                (if (environmentTemplateId.asKnown().isPresent) 1 else 0) +
                (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (network.asKnown().getOrNull()?.validity() ?: 0) +
                (packages.asKnown().getOrNull()?.validity() ?: 0) +
                (plugins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                type.let { if (it == JsonValue.from("openai_hosted")) 1 else 0 }

        /** The configured container size, or null to use the creation default. */
        class ContainerSize @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val SMALL = of("small")

                @JvmField val MEDIUM = of("medium")

                @JvmField val LARGE = of("large")

                @JvmStatic fun of(value: String) = ContainerSize(JsonField.of(value))
            }

            /** An enum containing [ContainerSize]'s known values. */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Known {
                SMALL,
                MEDIUM,
                LARGE,
            }

            /**
             * An enum containing [ContainerSize]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ContainerSize] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            enum class Value {
                SMALL,
                MEDIUM,
                LARGE,
                /**
                 * An enum member indicating that [ContainerSize] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun value(): Value =
                when (this) {
                    SMALL -> Value.SMALL
                    MEDIUM -> Value.MEDIUM
                    LARGE -> Value.LARGE
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            @Deprecated("Use asString() for string values or _value() for raw JSON.")
            fun known(): Known =
                when (this) {
                    SMALL -> Known.SMALL
                    MEDIUM -> Known.MEDIUM
                    LARGE -> Known.LARGE
                    else -> throw OpenAIInvalidDataException("Unknown ContainerSize: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws OpenAIInvalidDataException if this class instance's value does not have the
             *   expected primitive type.
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
             */
            fun validate(): ContainerSize = apply {
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

                return other is ContainerSize && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        /** Desktop overrides, or null to inherit the template or creation default. */
        class Desktop
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val enabled: JsonField<Boolean>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("enabled")
                @ExcludeMissing
                enabled: JsonField<Boolean> = JsonMissing.of()
            ) : this(enabled, mutableMapOf())

            /**
             * Whether the environment provisions a desktop and browser proxy.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun enabled(): Boolean = enabled.getRequired("enabled")

            /**
             * Returns the raw JSON value of [enabled].
             *
             * Unlike [enabled], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("enabled") @ExcludeMissing fun _enabled(): JsonField<Boolean> = enabled

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
                collectAllProperties(additionalProperties, "enabled" to this.enabled)

            @JvmSynthetic
            internal fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

            @JsonAnyGetter
            @ExcludeMissing
            private fun additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                /**
                 * Returns a mutable builder for constructing an instance of [Desktop].
                 *
                 * The following fields are required:
                 * ```java
                 * .enabled()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Desktop]. */
            class Builder internal constructor() {

                private var enabled: JsonField<Boolean>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(desktop: Desktop) = apply {
                    enabled = desktop.enabled
                    additionalProperties = desktop.additionalProperties.toMutableMap()
                }

                /** Whether the environment provisions a desktop and browser proxy. */
                fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

                /**
                 * Sets [Builder.enabled] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.enabled] with a well-typed [Boolean] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
                 * Returns an immutable instance of [Desktop].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .enabled()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Desktop =
                    Desktop(checkRequired("enabled", enabled), additionalProperties.toMutableMap())
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
            fun validate(): Desktop = apply {
                if (validated) {
                    return@apply
                }

                enabled()
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
            @JvmSynthetic internal fun validity(): Int = (if (enabled.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Desktop &&
                    enabled == other.enabled &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Desktop{enabled=$enabled, additionalProperties=$additionalProperties}"
        }

        /** Safe metadata for a file configured by an environment template. */
        @JsonDeserialize(using = File.Deserializer::class)
        @JsonSerialize(using = File.Serializer::class)
        class File
        private constructor(
            private val id: FileId? = null,
            private val inline: Inline? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A project-scoped Files API reference resolved separately for each session. */
            fun id(): Optional<FileId> = Optional.ofNullable(id)

            /** Metadata for confidential inline file contents. */
            fun inline(): Optional<Inline> = Optional.ofNullable(inline)

            fun isId(): Boolean = id != null

            fun isInline(): Boolean = inline != null

            /** A project-scoped Files API reference resolved separately for each session. */
            fun asId(): FileId = id.getOrThrow("id")

            /** Metadata for confidential inline file contents. */
            fun asInline(): Inline = inline.getOrThrow("inline")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = file.accept(new File.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitId(FileId id) {
             *         return Optional.of(id.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    id != null -> visitor.visitId(id)
                    inline != null -> visitor.visitInline(inline)
                    else -> visitor.unknown(_json)
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
            fun validate(): File = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitId(id: FileId) {
                            id.validate()
                        }

                        override fun visitInline(inline: Inline) {
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
                        override fun visitId(id: FileId) = id.validity()

                        override fun visitInline(inline: Inline) = inline.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is File &&
                    id == other.id &&
                    inline == other.inline &&
                    (id != null || inline != null || _json == other._json)
            }

            override fun hashCode(): Int =
                if (id == null && inline == null) Objects.hash(_json) else Objects.hash(id, inline)

            override fun toString(): String =
                when {
                    id != null -> "File{id=$id}"
                    inline != null -> "File{inline=$inline}"
                    _json != null -> "File{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid File")
                }

            companion object {

                /** A project-scoped Files API reference resolved separately for each session. */
                @JvmStatic fun ofId(id: FileId) = File(id = id)

                /** Metadata for confidential inline file contents. */
                @JvmStatic fun ofInline(inline: Inline) = File(inline = inline)
            }

            /**
             * An interface that defines how to map each variant of [File] to a value of type [T].
             */
            interface Visitor<out T> {

                /** A project-scoped Files API reference resolved separately for each session. */
                fun visitId(id: FileId): T = unknown(JsonValue.from(id))

                /** Metadata for confidential inline file contents. */
                fun visitInline(inline: Inline): T = unknown(JsonValue.from(inline))

                /**
                 * Maps an unknown variant of [File] to a value of type [T].
                 *
                 * An instance of [File] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * Unhandled known JSON variants reach this method as JSON values.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown File")
                }
            }

            internal class Deserializer : BaseDeserializer<File>(File::class) {

                override fun ObjectCodec.deserialize(node: JsonNode): File {
                    val json = JsonValue.fromJsonNode(node)
                    val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                    when (type) {
                        "file_id" -> {
                            return tryDeserialize(node, jacksonTypeRef<FileId>())?.let {
                                File(id = it, _json = json)
                            } ?: File(_json = json)
                        }
                        "inline" -> {
                            return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
                                File(inline = it, _json = json)
                            } ?: File(_json = json)
                        }
                    }

                    return File(_json = json)
                }
            }

            internal class Serializer : BaseSerializer<File>(File::class) {

                override fun serialize(
                    value: File,
                    generator: JsonGenerator,
                    provider: SerializerProvider,
                ) {
                    when {
                        value.id != null -> generator.writeObject(value.id)
                        value.inline != null -> generator.writeObject(value.inline)
                        value._json != null -> generator.writeObject(value._json)
                        else -> throw IllegalStateException("Invalid File")
                    }
                }
            }

            /** A project-scoped Files API reference resolved separately for each session. */
            class FileId
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val fileId: JsonField<String>,
                private val path: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("file_id")
                    @ExcludeMissing
                    fileId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("path")
                    @ExcludeMissing
                    path: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(fileId, path, type, mutableMapOf())

                /**
                 * The ID of the uploaded file.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun fileId(): String = fileId.getRequired("file_id")

                /**
                 * The file's absolute path inside the environment.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun path(): String = path.getRequired("path")

                /**
                 * The type of the object. Always `file_id`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("file_id")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [fileId].
                 *
                 * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

                /**
                 * Returns the raw JSON value of [path].
                 *
                 * Unlike [path], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "file_id" to this.fileId,
                        "path" to this.path,
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
                     * Returns a mutable builder for constructing an instance of [FileId].
                     *
                     * The following fields are required:
                     * ```java
                     * .fileId()
                     * .path()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [FileId]. */
                class Builder internal constructor() {

                    private var fileId: JsonField<String>? = null
                    private var path: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("file_id")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(fileId: FileId) = apply {
                        this.fileId = fileId.fileId
                        path = fileId.path
                        type = fileId.type
                        additionalProperties = fileId.additionalProperties.toMutableMap()
                    }

                    /** The ID of the uploaded file. */
                    fun fileId(fileId: String) = fileId(JsonField.of(fileId))

                    /**
                     * Sets [Builder.fileId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.fileId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                    /** The file's absolute path inside the environment. */
                    fun path(path: String) = path(JsonField.of(path))

                    /**
                     * Sets [Builder.path] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.path] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun path(path: JsonField<String>) = apply { this.path = path }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("file_id")
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
                     * Returns an immutable instance of [FileId].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .fileId()
                     * .path()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): FileId =
                        FileId(
                            checkRequired("fileId", fileId),
                            checkRequired("path", path),
                            type,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): FileId = apply {
                    if (validated) {
                        return@apply
                    }

                    fileId()
                    path()
                    _type().let {
                        if (it != JsonValue.from("file_id")) {
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
                    (if (fileId.asKnown().isPresent) 1 else 0) +
                        (if (path.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("file_id")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is FileId &&
                        fileId == other.fileId &&
                        path == other.path &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(fileId, path, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "FileId{fileId=$fileId, path=$path, type=$type, additionalProperties=$additionalProperties}"
            }

            /** Metadata for confidential inline file contents. */
            class Inline
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val path: JsonField<String>,
                private val sizeBytes: JsonField<Long>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("path")
                    @ExcludeMissing
                    path: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("size_bytes")
                    @ExcludeMissing
                    sizeBytes: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(path, sizeBytes, type, mutableMapOf())

                /**
                 * The file's absolute path inside the environment.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun path(): String = path.getRequired("path")

                /**
                 * The decoded size of the inline file in bytes.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun sizeBytes(): Long = sizeBytes.getRequired("size_bytes")

                /**
                 * The type of the object. Always `inline`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("inline")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [path].
                 *
                 * Unlike [path], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

                /**
                 * Returns the raw JSON value of [sizeBytes].
                 *
                 * Unlike [sizeBytes], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("size_bytes")
                @ExcludeMissing
                fun _sizeBytes(): JsonField<Long> = sizeBytes

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "path" to this.path,
                        "size_bytes" to this.sizeBytes,
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
                     * Returns a mutable builder for constructing an instance of [Inline].
                     *
                     * The following fields are required:
                     * ```java
                     * .path()
                     * .sizeBytes()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Inline]. */
                class Builder internal constructor() {

                    private var path: JsonField<String>? = null
                    private var sizeBytes: JsonField<Long>? = null
                    private var type: JsonValue = JsonValue.from("inline")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(inline: Inline) = apply {
                        path = inline.path
                        sizeBytes = inline.sizeBytes
                        type = inline.type
                        additionalProperties = inline.additionalProperties.toMutableMap()
                    }

                    /** The file's absolute path inside the environment. */
                    fun path(path: String) = path(JsonField.of(path))

                    /**
                     * Sets [Builder.path] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.path] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun path(path: JsonField<String>) = apply { this.path = path }

                    /** The decoded size of the inline file in bytes. */
                    fun sizeBytes(sizeBytes: Long) = sizeBytes(JsonField.of(sizeBytes))

                    /**
                     * Sets [Builder.sizeBytes] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.sizeBytes] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun sizeBytes(sizeBytes: JsonField<Long>) = apply { this.sizeBytes = sizeBytes }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("inline")
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
                     * Returns an immutable instance of [Inline].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .path()
                     * .sizeBytes()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Inline =
                        Inline(
                            checkRequired("path", path),
                            checkRequired("sizeBytes", sizeBytes),
                            type,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Inline = apply {
                    if (validated) {
                        return@apply
                    }

                    path()
                    sizeBytes()
                    _type().let {
                        if (it != JsonValue.from("inline")) {
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
                    (if (path.asKnown().isPresent) 1 else 0) +
                        (if (sizeBytes.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("inline")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Inline &&
                        path == other.path &&
                        sizeBytes == other.sizeBytes &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(path, sizeBytes, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Inline{path=$path, sizeBytes=$sizeBytes, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        /** Network overrides, or null to inherit the template or creation default. */
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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "access" to this.access,
                    "allowed_domains" to this.allowedDomains,
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

                    /** Applies the configured domain restrictions. */
                    @JvmField val RESTRICTED = of("restricted")

                    @JvmStatic fun of(value: String) = Access(JsonField.of(value))
                }

                /** An enum containing [Access]'s known values. */
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Known {
                    /** Allows unrestricted network access. */
                    ENABLED,
                    /** Disables network access. */
                    DISABLED,
                    /** Applies the configured domain restrictions. */
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
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
                enum class Value {
                    /** Allows unrestricted network access. */
                    ENABLED,
                    /** Disables network access. */
                    DISABLED,
                    /** Applies the configured domain restrictions. */
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
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
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
                @Deprecated("Use asString() for string values or _value() for raw JSON.")
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

        /** Package overrides, or null to inherit the template or creation default. */
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

            /**
             * Returns an immutable snapshot of all present JSON properties, including declared and
             * additional properties.
             *
             * Keys use their JSON names. Declared properties take precedence over additional
             * properties with the same name. Missing properties are omitted, while explicit nulls
             * and unrecognized values are preserved.
             */
            fun _allProperties(): Map<String, JsonValue> =
                collectAllProperties(
                    additionalProperties,
                    "npm" to this.npm,
                    "python" to this.python,
                    "system" to this.system,
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

        /** Safe metadata for a skill configured by an environment template. */
        @JsonDeserialize(using = Skill.Deserializer::class)
        @JsonSerialize(using = Skill.Serializer::class)
        class Skill
        private constructor(
            private val reference: SkillReference? = null,
            private val inline: Inline? = null,
            private val _json: JsonValue? = null,
        ) {

            /** A skill resolved afresh from the Skills API whenever a session starts. */
            fun reference(): Optional<SkillReference> = Optional.ofNullable(reference)

            /** Safe metadata for an inline skill archive. */
            fun inline(): Optional<Inline> = Optional.ofNullable(inline)

            fun isReference(): Boolean = reference != null

            fun isInline(): Boolean = inline != null

            /** A skill resolved afresh from the Skills API whenever a session starts. */
            fun asReference(): SkillReference = reference.getOrThrow("reference")

            /** Safe metadata for an inline skill archive. */
            fun asInline(): Inline = inline.getOrThrow("inline")

            fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

            /**
             * Maps this instance's current variant to a value of type [T] using the given
             * [visitor].
             *
             * Note that this method is _not_ forwards compatible with new variants from the API,
             * unless [visitor] overrides [Visitor.unknown]. To handle variants not known to this
             * version of the SDK gracefully, consider overriding [Visitor.unknown]:
             * ```java
             * import com.openai.core.JsonValue;
             * import java.util.Optional;
             *
             * Optional<String> result = skill.accept(new Skill.Visitor<Optional<String>>() {
             *     @Override
             *     public Optional<String> visitReference(SkillReference reference) {
             *         return Optional.of(reference.toString());
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
             * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in
             *   [visitor] and the current variant is unknown.
             */
            fun <T> accept(visitor: Visitor<T>): T =
                when {
                    reference != null -> visitor.visitReference(reference)
                    inline != null -> visitor.visitInline(inline)
                    else -> visitor.unknown(_json)
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
            fun validate(): Skill = apply {
                if (validated) {
                    return@apply
                }

                accept(
                    object : Visitor<Unit> {
                        override fun visitReference(reference: SkillReference) {
                            reference.validate()
                        }

                        override fun visitInline(inline: Inline) {
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
                        override fun visitReference(reference: SkillReference) =
                            reference.validity()

                        override fun visitInline(inline: Inline) = inline.validity()

                        override fun unknown(json: JsonValue?) = 0
                    }
                )

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Skill &&
                    reference == other.reference &&
                    inline == other.inline &&
                    (reference != null || inline != null || _json == other._json)
            }

            override fun hashCode(): Int =
                if (reference == null && inline == null) Objects.hash(_json)
                else Objects.hash(reference, inline)

            override fun toString(): String =
                when {
                    reference != null -> "Skill{reference=$reference}"
                    inline != null -> "Skill{inline=$inline}"
                    _json != null -> "Skill{_unknown=$_json}"
                    else -> throw IllegalStateException("Invalid Skill")
                }

            companion object {

                /** A skill resolved afresh from the Skills API whenever a session starts. */
                @JvmStatic fun ofReference(reference: SkillReference) = Skill(reference = reference)

                /** Safe metadata for an inline skill archive. */
                @JvmStatic fun ofInline(inline: Inline) = Skill(inline = inline)
            }

            /**
             * An interface that defines how to map each variant of [Skill] to a value of type [T].
             */
            interface Visitor<out T> {

                /** A skill resolved afresh from the Skills API whenever a session starts. */
                fun visitReference(reference: SkillReference): T =
                    unknown(JsonValue.from(reference))

                /** Safe metadata for an inline skill archive. */
                fun visitInline(inline: Inline): T = unknown(JsonValue.from(inline))

                /**
                 * Maps an unknown variant of [Skill] to a value of type [T].
                 *
                 * An instance of [Skill] can contain an unknown variant if it was deserialized from
                 * data that doesn't match any known variant. For example, if the SDK is on an older
                 * version than the API, then the API may respond with new variants that the SDK is
                 * unaware of.
                 *
                 * Unhandled known JSON variants reach this method as JSON values.
                 *
                 * @throws OpenAIInvalidDataException in the default implementation.
                 */
                fun unknown(json: JsonValue?): T {
                    throw OpenAIInvalidDataException("Unknown Skill")
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
                            return tryDeserialize(node, jacksonTypeRef<Inline>())?.let {
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

            /** A skill resolved afresh from the Skills API whenever a session starts. */
            class SkillReference
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val skillId: JsonField<String>,
                private val type: JsonValue,
                private val version: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("skill_id")
                    @ExcludeMissing
                    skillId: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("version")
                    @ExcludeMissing
                    version: JsonField<String> = JsonMissing.of(),
                ) : this(skillId, type, version, mutableMapOf())

                /**
                 * The referenced skill ID.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun skillId(): String = skillId.getRequired("skill_id")

                /**
                 * The type of the object. Always `skill_reference`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("skill_reference")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * The requested version selector, including `latest`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g.
                 *   if the server responded with an unexpected value).
                 */
                fun version(): Optional<String> = version.getOptional("version")

                /**
                 * Returns the raw JSON value of [skillId].
                 *
                 * Unlike [skillId], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("skill_id")
                @ExcludeMissing
                fun _skillId(): JsonField<String> = skillId

                /**
                 * Returns the raw JSON value of [version].
                 *
                 * Unlike [version], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "skill_id" to this.skillId,
                        "type" to this.type,
                        "version" to this.version,
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
                     * Returns a mutable builder for constructing an instance of [SkillReference].
                     *
                     * The following fields are required:
                     * ```java
                     * .skillId()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [SkillReference]. */
                class Builder internal constructor() {

                    private var skillId: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("skill_reference")
                    private var version: JsonField<String>? = JsonNull.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(skillReference: SkillReference) = apply {
                        skillId = skillReference.skillId
                        type = skillReference.type
                        version = skillReference.version
                        additionalProperties = skillReference.additionalProperties.toMutableMap()
                    }

                    /** The referenced skill ID. */
                    fun skillId(skillId: String) = skillId(JsonField.of(skillId))

                    /**
                     * Sets [Builder.skillId] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.skillId] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun skillId(skillId: JsonField<String>) = apply { this.skillId = skillId }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("skill_reference")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /** The requested version selector, including `latest`. */
                    fun version(version: String?) = version(JsonField.ofNullable(version))

                    /** Alias for calling [Builder.version] with `version.orElse(null)`. */
                    fun version(version: Optional<String>) = version(version.getOrNull())

                    /**
                     * Sets [Builder.version] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.version] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun version(version: JsonField<String>) = apply { this.version = version }

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
                     * Returns an immutable instance of [SkillReference].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .skillId()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): SkillReference =
                        SkillReference(
                            checkRequired("skillId", skillId),
                            type,
                            checkRequired("version", version),
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): SkillReference = apply {
                    if (validated) {
                        return@apply
                    }

                    skillId()
                    _type().let {
                        if (it != JsonValue.from("skill_reference")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    version()
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
                    (if (skillId.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("skill_reference")) 1 else 0 } +
                        (if (version.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is SkillReference &&
                        skillId == other.skillId &&
                        type == other.type &&
                        version == other.version &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(skillId, type, version, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "SkillReference{skillId=$skillId, type=$type, version=$version, additionalProperties=$additionalProperties}"
            }

            /** Safe metadata for an inline skill archive. */
            class Inline
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val description: JsonField<String>,
                private val name: JsonField<String>,
                private val type: JsonValue,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                ) : this(description, name, type, mutableMapOf())

                /**
                 * The skill description declared in `SKILL.md`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun description(): String = description.getRequired("description")

                /**
                 * The skill name declared in `SKILL.md`.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun name(): String = name.getRequired("name")

                /**
                 * The type of the object. Always `inline`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("inline")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                @JsonAnySetter
                private fun putAdditionalProperty(key: String, value: JsonValue) {
                    additionalProperties.put(key, value)
                }

                /**
                 * Returns an immutable snapshot of all present JSON properties, including declared
                 * and additional properties.
                 *
                 * Keys use their JSON names. Declared properties take precedence over additional
                 * properties with the same name. Missing properties are omitted, while explicit
                 * nulls and unrecognized values are preserved.
                 */
                fun _allProperties(): Map<String, JsonValue> =
                    collectAllProperties(
                        additionalProperties,
                        "description" to this.description,
                        "name" to this.name,
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
                     * Returns a mutable builder for constructing an instance of [Inline].
                     *
                     * The following fields are required:
                     * ```java
                     * .description()
                     * .name()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Inline]. */
                class Builder internal constructor() {

                    private var description: JsonField<String>? = null
                    private var name: JsonField<String>? = null
                    private var type: JsonValue = JsonValue.from("inline")
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(inline: Inline) = apply {
                        description = inline.description
                        name = inline.name
                        type = inline.type
                        additionalProperties = inline.additionalProperties.toMutableMap()
                    }

                    /** The skill description declared in `SKILL.md`. */
                    fun description(description: String) = description(JsonField.of(description))

                    /**
                     * Sets [Builder.description] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.description] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
                    }

                    /** The skill name declared in `SKILL.md`. */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("inline")
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
                     * Returns an immutable instance of [Inline].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .description()
                     * .name()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Inline =
                        Inline(
                            checkRequired("description", description),
                            checkRequired("name", name),
                            type,
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
                 * @throws OpenAIInvalidDataException if any value type in this object doesn't match
                 *   its expected type.
                 */
                fun validate(): Inline = apply {
                    if (validated) {
                        return@apply
                    }

                    description()
                    name()
                    _type().let {
                        if (it != JsonValue.from("inline")) {
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
                    (if (description.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        type.let { if (it == JsonValue.from("inline")) 1 else 0 }

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Inline &&
                        description == other.description &&
                        name == other.name &&
                        type == other.type &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(description, name, type, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Inline{description=$description, name=$name, type=$type, additionalProperties=$additionalProperties}"
            }
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is OpenAIHosted &&
                capabilityDirectories == other.capabilityDirectories &&
                containerSize == other.containerSize &&
                desktop == other.desktop &&
                environmentId == other.environmentId &&
                environmentTemplateId == other.environmentTemplateId &&
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
                capabilityDirectories,
                containerSize,
                desktop,
                environmentId,
                environmentTemplateId,
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
            "OpenAIHosted{capabilityDirectories=$capabilityDirectories, containerSize=$containerSize, desktop=$desktop, environmentId=$environmentId, environmentTemplateId=$environmentTemplateId, files=$files, network=$network, packages=$packages, plugins=$plugins, skills=$skills, type=$type, additionalProperties=$additionalProperties}"
    }

    class SelfHosted
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val capabilityDirectories: JsonField<List<String>>,
        private val environmentId: JsonField<String>,
        private val type: JsonValue,
        private val workspaceDirectory: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("capability_directories")
            @ExcludeMissing
            capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("environment_id")
            @ExcludeMissing
            environmentId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("workspace_directory")
            @ExcludeMissing
            workspaceDirectory: JsonField<String> = JsonMissing.of(),
        ) : this(capabilityDirectories, environmentId, type, workspaceDirectory, mutableMapOf())

        /**
         * Directories that expose capabilities to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun capabilityDirectories(): List<String> =
            capabilityDirectories.getRequired("capability_directories")

        /**
         * An existing registration, or null to create a session-owned environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun environmentId(): Optional<String> = environmentId.getOptional("environment_id")

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
         * The absolute project directory in the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun workspaceDirectory(): String = workspaceDirectory.getRequired("workspace_directory")

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
         * Returns the raw JSON value of [environmentId].
         *
         * Unlike [environmentId], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("environment_id")
        @ExcludeMissing
        fun _environmentId(): JsonField<String> = environmentId

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
                "capability_directories" to this.capabilityDirectories,
                "environment_id" to this.environmentId,
                "type" to this.type,
                "workspace_directory" to this.workspaceDirectory,
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
             * Returns a mutable builder for constructing an instance of [SelfHosted].
             *
             * The following fields are required:
             * ```java
             * .capabilityDirectories()
             * .workspaceDirectory()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [SelfHosted]. */
        class Builder internal constructor() {

            private var capabilityDirectories: JsonField<MutableList<String>>? = null
            private var environmentId: JsonField<String>? = JsonNull.of()
            private var type: JsonValue = JsonValue.from("self_hosted")
            private var workspaceDirectory: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(selfHosted: SelfHosted) = apply {
                capabilityDirectories = selfHosted.capabilityDirectories.map { it.toMutableList() }
                environmentId = selfHosted.environmentId
                type = selfHosted.type
                workspaceDirectory = selfHosted.workspaceDirectory
                additionalProperties = selfHosted.additionalProperties.toMutableMap()
            }

            /** Directories that expose capabilities to the agent. */
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

            /** An existing registration, or null to create a session-owned environment. */
            fun environmentId(environmentId: String?) =
                environmentId(JsonField.ofNullable(environmentId))

            /** Alias for calling [Builder.environmentId] with `environmentId.orElse(null)`. */
            fun environmentId(environmentId: Optional<String>) =
                environmentId(environmentId.getOrNull())

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

            /** The absolute project directory in the environment. */
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
             * .capabilityDirectories()
             * .workspaceDirectory()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): SelfHosted =
                SelfHosted(
                    checkRequired("capabilityDirectories", capabilityDirectories).map {
                        it.toImmutable()
                    },
                    checkRequired("environmentId", environmentId),
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

            capabilityDirectories()
            environmentId()
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
            (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
                (if (environmentId.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("self_hosted")) 1 else 0 } +
                (if (workspaceDirectory.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SelfHosted &&
                capabilityDirectories == other.capabilityDirectories &&
                environmentId == other.environmentId &&
                type == other.type &&
                workspaceDirectory == other.workspaceDirectory &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                capabilityDirectories,
                environmentId,
                type,
                workspaceDirectory,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "SelfHosted{capabilityDirectories=$capabilityDirectories, environmentId=$environmentId, type=$type, workspaceDirectory=$workspaceDirectory, additionalProperties=$additionalProperties}"
    }
}
