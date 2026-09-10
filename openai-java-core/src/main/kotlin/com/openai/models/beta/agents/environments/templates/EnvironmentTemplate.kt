// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

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
import com.openai.models.beta.agents.HostedPlugin
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Reusable configuration that provisions a fresh OpenAI-hosted environment for each session. */
class EnvironmentTemplate
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val capabilityDirectories: JsonField<List<String>>,
    private val createdAt: JsonField<Long>,
    private val files: JsonField<List<File>>,
    private val name: JsonField<String>,
    private val network: JsonField<Network>,
    private val object_: JsonValue,
    private val packages: JsonField<Packages>,
    private val plugins: JsonField<List<HostedPlugin>>,
    private val skills: JsonField<List<Skill>>,
    private val updatedAt: JsonField<Long>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("capability_directories")
        @ExcludeMissing
        capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("files") @ExcludeMissing files: JsonField<List<File>> = JsonMissing.of(),
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("network") @ExcludeMissing network: JsonField<Network> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("packages") @ExcludeMissing packages: JsonField<Packages> = JsonMissing.of(),
        @JsonProperty("plugins")
        @ExcludeMissing
        plugins: JsonField<List<HostedPlugin>> = JsonMissing.of(),
        @JsonProperty("skills") @ExcludeMissing skills: JsonField<List<Skill>> = JsonMissing.of(),
        @JsonProperty("updated_at") @ExcludeMissing updatedAt: JsonField<Long> = JsonMissing.of(),
    ) : this(
        id,
        capabilityDirectories,
        createdAt,
        files,
        name,
        network,
        object_,
        packages,
        plugins,
        skills,
        updatedAt,
        mutableMapOf(),
    )

    /**
     * The ID of the reusable environment template.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * Directories that expose capabilities to the agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun capabilityDirectories(): List<String> =
        capabilityDirectories.getRequired("capability_directories")

    /**
     * The Unix timestamp, in seconds, when the template was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Safe file metadata, excluding contents and session-scoped file IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun files(): List<File> = files.getRequired("files")

    /**
     * An optional human-readable display name for the template.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * Runtime network access for each OpenAI-hosted environment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun network(): Network = network.getRequired("network")

    /**
     * The object type. Always `agent.environment.template`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("agent.environment.template")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * Packages installed in each fresh OpenAI-hosted environment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun packages(): Packages = packages.getRequired("packages")

    /**
     * Safe plugin metadata, excluding inline archive contents.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun plugins(): List<HostedPlugin> = plugins.getRequired("plugins")

    /**
     * Safe skill metadata, preserving unresolved version selectors.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun skills(): List<Skill> = skills.getRequired("skills")

    /**
     * The Unix timestamp, in seconds, when the template was last updated.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun updatedAt(): Long = updatedAt.getRequired("updated_at")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [capabilityDirectories].
     *
     * Unlike [capabilityDirectories], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    @JsonProperty("capability_directories")
    @ExcludeMissing
    fun _capabilityDirectories(): JsonField<List<String>> = capabilityDirectories

    /**
     * Returns the raw JSON value of [createdAt].
     *
     * Unlike [createdAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("created_at") @ExcludeMissing fun _createdAt(): JsonField<Long> = createdAt

    /**
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<File>> = files

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
    @JsonProperty("plugins") @ExcludeMissing fun _plugins(): JsonField<List<HostedPlugin>> = plugins

    /**
     * Returns the raw JSON value of [skills].
     *
     * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("skills") @ExcludeMissing fun _skills(): JsonField<List<Skill>> = skills

    /**
     * Returns the raw JSON value of [updatedAt].
     *
     * Unlike [updatedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("updated_at") @ExcludeMissing fun _updatedAt(): JsonField<Long> = updatedAt

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
         * Returns a mutable builder for constructing an instance of [EnvironmentTemplate].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .capabilityDirectories()
         * .createdAt()
         * .files()
         * .name()
         * .network()
         * .packages()
         * .plugins()
         * .skills()
         * .updatedAt()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [EnvironmentTemplate]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var capabilityDirectories: JsonField<MutableList<String>>? = null
        private var createdAt: JsonField<Long>? = null
        private var files: JsonField<MutableList<File>>? = null
        private var name: JsonField<String>? = null
        private var network: JsonField<Network>? = null
        private var object_: JsonValue = JsonValue.from("agent.environment.template")
        private var packages: JsonField<Packages>? = null
        private var plugins: JsonField<MutableList<HostedPlugin>>? = null
        private var skills: JsonField<MutableList<Skill>>? = null
        private var updatedAt: JsonField<Long>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(environmentTemplate: EnvironmentTemplate) = apply {
            id = environmentTemplate.id
            capabilityDirectories =
                environmentTemplate.capabilityDirectories.map { it.toMutableList() }
            createdAt = environmentTemplate.createdAt
            files = environmentTemplate.files.map { it.toMutableList() }
            name = environmentTemplate.name
            network = environmentTemplate.network
            object_ = environmentTemplate.object_
            packages = environmentTemplate.packages
            plugins = environmentTemplate.plugins.map { it.toMutableList() }
            skills = environmentTemplate.skills.map { it.toMutableList() }
            updatedAt = environmentTemplate.updatedAt
            additionalProperties = environmentTemplate.additionalProperties.toMutableMap()
        }

        /** The ID of the reusable environment template. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** Directories that expose capabilities to the agent. */
        fun capabilityDirectories(capabilityDirectories: List<String>) =
            capabilityDirectories(JsonField.of(capabilityDirectories))

        /**
         * Sets [Builder.capabilityDirectories] to an arbitrary JSON value.
         *
         * You should usually call [Builder.capabilityDirectories] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
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

        /** The Unix timestamp, in seconds, when the template was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /** Safe file metadata, excluding contents and session-scoped file IDs. */
        fun files(files: List<File>) = files(JsonField.of(files))

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed `List<File>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
                (files ?: JsonField.of(mutableListOf())).also { checkKnown("files", it).add(file) }
        }

        /** Alias for calling [addFile] with `File.ofId(id)`. */
        fun addFile(id: File.FileId) = addFile(File.ofId(id))

        /** Alias for calling [addFile] with `File.ofInline(inline)`. */
        fun addFile(inline: File.Inline) = addFile(File.ofInline(inline))

        /** An optional human-readable display name for the template. */
        fun name(name: String?) = name(JsonField.ofNullable(name))

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** Runtime network access for each OpenAI-hosted environment. */
        fun network(network: Network) = network(JsonField.of(network))

        /**
         * Sets [Builder.network] to an arbitrary JSON value.
         *
         * You should usually call [Builder.network] with a well-typed [Network] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun network(network: JsonField<Network>) = apply { this.network = network }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("agent.environment.template")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /** Packages installed in each fresh OpenAI-hosted environment. */
        fun packages(packages: Packages) = packages(JsonField.of(packages))

        /**
         * Sets [Builder.packages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.packages] with a well-typed [Packages] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun packages(packages: JsonField<Packages>) = apply { this.packages = packages }

        /** Safe plugin metadata, excluding inline archive contents. */
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

        /** Safe skill metadata, preserving unresolved version selectors. */
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
        fun addSkill(reference: Skill.SkillReference) = addSkill(Skill.ofReference(reference))

        /** Alias for calling [addSkill] with `Skill.ofInline(inline)`. */
        fun addSkill(inline: Skill.Inline) = addSkill(Skill.ofInline(inline))

        /** The Unix timestamp, in seconds, when the template was last updated. */
        fun updatedAt(updatedAt: Long) = updatedAt(JsonField.of(updatedAt))

        /**
         * Sets [Builder.updatedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.updatedAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun updatedAt(updatedAt: JsonField<Long>) = apply { this.updatedAt = updatedAt }

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
         * Returns an immutable instance of [EnvironmentTemplate].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .capabilityDirectories()
         * .createdAt()
         * .files()
         * .name()
         * .network()
         * .packages()
         * .plugins()
         * .skills()
         * .updatedAt()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): EnvironmentTemplate =
            EnvironmentTemplate(
                checkRequired("id", id),
                checkRequired("capabilityDirectories", capabilityDirectories).map {
                    it.toImmutable()
                },
                checkRequired("createdAt", createdAt),
                checkRequired("files", files).map { it.toImmutable() },
                checkRequired("name", name),
                checkRequired("network", network),
                object_,
                checkRequired("packages", packages),
                checkRequired("plugins", plugins).map { it.toImmutable() },
                checkRequired("skills", skills).map { it.toImmutable() },
                checkRequired("updatedAt", updatedAt),
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
    fun validate(): EnvironmentTemplate = apply {
        if (validated) {
            return@apply
        }

        id()
        capabilityDirectories()
        createdAt()
        files().forEach { it.validate() }
        name()
        network().validate()
        _object_().let {
            if (it != JsonValue.from("agent.environment.template")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        packages().validate()
        plugins().forEach { it.validate() }
        skills().forEach { it.validate() }
        updatedAt()
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
            (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
            (if (createdAt.asKnown().isPresent) 1 else 0) +
            (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (name.asKnown().isPresent) 1 else 0) +
            (network.asKnown().getOrNull()?.validity() ?: 0) +
            object_.let { if (it == JsonValue.from("agent.environment.template")) 1 else 0 } +
            (packages.asKnown().getOrNull()?.validity() ?: 0) +
            (plugins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (updatedAt.asKnown().isPresent) 1 else 0)

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
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
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

            return other is File && id == other.id && inline == other.inline
        }

        override fun hashCode(): Int = Objects.hash(id, inline)

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

        /** An interface that defines how to map each variant of [File] to a value of type [T]. */
        interface Visitor<out T> {

            /** A project-scoped Files API reference resolved separately for each session. */
            fun visitId(id: FileId): T

            /** Metadata for confidential inline file contents. */
            fun visitInline(inline: Inline): T

            /**
             * Maps an unknown variant of [File] to a value of type [T].
             *
             * An instance of [File] can contain an unknown variant if it was deserialized from data
             * that doesn't match any known variant. For example, if the SDK is on an older version
             * than the API, then the API may respond with new variants that the SDK is unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown File: $json")
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
                @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
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
             * Unlike [fileId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_id") @ExcludeMissing fun _fileId(): JsonField<String> = fileId

            /**
             * Returns the raw JSON value of [path].
             *
             * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

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
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun fileId(fileId: JsonField<String>) = apply { this.fileId = fileId }

                /** The file's absolute path inside the environment. */
                fun path(path: String) = path(JsonField.of(path))

                /**
                 * Sets [Builder.path] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.path] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun path(path: JsonField<String>) = apply { this.path = path }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
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
                @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
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
             * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
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

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> =
                Collections.unmodifiableMap(additionalProperties)

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
                 * You should usually call [Builder.path] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun path(path: JsonField<String>) = apply { this.path = path }

                /** The decoded size of the inline file in bytes. */
                fun sizeBytes(sizeBytes: Long) = sizeBytes(JsonField.of(sizeBytes))

                /**
                 * Sets [Builder.sizeBytes] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sizeBytes] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sizeBytes(sizeBytes: JsonField<Long>) = apply { this.sizeBytes = sizeBytes }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
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

    /** Runtime network access for each OpenAI-hosted environment. */
    class Network
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val access: JsonField<Access>,
        private val allowedDomains: JsonField<List<String>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("access") @ExcludeMissing access: JsonField<Access> = JsonMissing.of(),
            @JsonProperty("allowed_domains")
            @ExcludeMissing
            allowedDomains: JsonField<List<String>> = JsonMissing.of(),
        ) : this(access, allowedDomains, mutableMapOf())

        /**
         * The environment's network access mode.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun access(): Access = access.getRequired("access")

        /**
         * Domains the environment may access when network access is restricted.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
         * Unlike [allowedDomains], this method doesn't throw if the JSON field has an unexpected
         * type.
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
             * You should usually call [Builder.access] with a well-typed [Access] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun access(access: JsonField<Access>) = apply { this.access = access }

            /** Domains the environment may access when network access is restricted. */
            fun allowedDomains(allowedDomains: List<String>) =
                allowedDomains(JsonField.of(allowedDomains))

            /**
             * Sets [Builder.allowedDomains] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedDomains] with a well-typed `List<String>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
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
        class Access @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
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
                 * An enum member indicating that [Access] was instantiated with an unknown value.
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
             * @throws OpenAIInvalidDataException if this class instance's value is a not a known
             *   member.
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

    /** Packages installed in each fresh OpenAI-hosted environment. */
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
            @JsonProperty("npm") @ExcludeMissing npm: JsonField<List<String>> = JsonMissing.of(),
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
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun npm(): List<String> = npm.getRequired("npm")

        /**
         * Python packages installed in the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun python(): List<String> = python.getRequired("python")

        /**
         * System packages installed in the environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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
             * You should usually call [Builder.npm] with a well-typed `List<String>` value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
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
         * Maps this instance's current variant to a value of type [T] using the given [visitor].
         *
         * Note that this method is _not_ forwards compatible with new variants from the API, unless
         * [visitor] overrides [Visitor.unknown]. To handle variants not known to this version of
         * the SDK gracefully, consider overriding [Visitor.unknown]:
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
         * @throws OpenAIInvalidDataException if [Visitor.unknown] is not overridden in [visitor]
         *   and the current variant is unknown.
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
         * This method is _not_ forwards compatible with new types from the API for existing fields.
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
                    override fun visitReference(reference: SkillReference) = reference.validity()

                    override fun visitInline(inline: Inline) = inline.validity()

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

            /** A skill resolved afresh from the Skills API whenever a session starts. */
            @JvmStatic fun ofReference(reference: SkillReference) = Skill(reference = reference)

            /** Safe metadata for an inline skill archive. */
            @JvmStatic fun ofInline(inline: Inline) = Skill(inline = inline)
        }

        /** An interface that defines how to map each variant of [Skill] to a value of type [T]. */
        interface Visitor<out T> {

            /** A skill resolved afresh from the Skills API whenever a session starts. */
            fun visitReference(reference: SkillReference): T

            /** Safe metadata for an inline skill archive. */
            fun visitInline(inline: Inline): T

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
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun version(): Optional<String> = version.getOptional("version")

            /**
             * Returns the raw JSON value of [skillId].
             *
             * Unlike [skillId], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("skill_id") @ExcludeMissing fun _skillId(): JsonField<String> = skillId

            /**
             * Returns the raw JSON value of [version].
             *
             * Unlike [version], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("version") @ExcludeMissing fun _version(): JsonField<String> = version

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
                 * Returns a mutable builder for constructing an instance of [SkillReference].
                 *
                 * The following fields are required:
                 * ```java
                 * .skillId()
                 * .version()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [SkillReference]. */
            class Builder internal constructor() {

                private var skillId: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("skill_reference")
                private var version: JsonField<String>? = null
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
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun skillId(skillId: JsonField<String>) = apply { this.skillId = skillId }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
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
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
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
                 * .version()
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
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
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
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
             * Unlike [description], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("description")
            @ExcludeMissing
            fun _description(): JsonField<String> = description

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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
                 * You should usually call [Builder.description] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun description(description: JsonField<String>) = apply {
                    this.description = description
                }

                /** The skill name declared in `SKILL.md`. */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
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
             * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
             *   expected type.
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

        return other is EnvironmentTemplate &&
            id == other.id &&
            capabilityDirectories == other.capabilityDirectories &&
            createdAt == other.createdAt &&
            files == other.files &&
            name == other.name &&
            network == other.network &&
            object_ == other.object_ &&
            packages == other.packages &&
            plugins == other.plugins &&
            skills == other.skills &&
            updatedAt == other.updatedAt &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            id,
            capabilityDirectories,
            createdAt,
            files,
            name,
            network,
            object_,
            packages,
            plugins,
            skills,
            updatedAt,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "EnvironmentTemplate{id=$id, capabilityDirectories=$capabilityDirectories, createdAt=$createdAt, files=$files, name=$name, network=$network, object_=$object_, packages=$packages, plugins=$plugins, skills=$skills, updatedAt=$updatedAt, additionalProperties=$additionalProperties}"
}
