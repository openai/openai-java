// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.templates

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.Params
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.HostedEnvironmentFileParam
import com.openai.models.beta.agents.HostedPluginParam
import com.openai.models.beta.agents.HostedSkillParam
import com.openai.models.beta.agents.SetupCommandParam
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Creates reusable environment configuration without returning confidential setup commands or
 * environment values. See
 * [reusing a hosted setup](https://developers.openai.com/api/docs/guides/agents-api/tools#reuse-a-hosted-plugin-setup).
 */
class TemplateCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Directories that contain capabilities exposed to the agent. Defaults to an empty list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun capabilityDirectories(): Optional<List<String>> = body.capabilityDirectories()

    /**
     * Environment variables made available to the agent.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun env(): Optional<Env> = body.env()

    /**
     * Files available before the agent starts. Defaults to an empty list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun files(): Optional<List<HostedEnvironmentFileParam>> = body.files()

    /**
     * An optional human-readable display name for the template.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = body.name()

    /**
     * Network access for an OpenAI-hosted environment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun network(): Optional<Network> = body.network()

    /**
     * Packages to install in an OpenAI-hosted environment.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun packages(): Optional<Packages> = body.packages()

    /**
     * Plugins provided as inline ZIP archives. Defaults to an empty list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun plugins(): Optional<List<HostedPluginParam>> = body.plugins()

    /**
     * Ordered, confidential setup commands. Command bodies are never returned.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun setupCommands(): Optional<List<SetupCommandParam>> = body.setupCommands()

    /**
     * Skills referenced by ID or provided as inline ZIP archives. Defaults to an empty list.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun skills(): Optional<List<HostedSkillParam>> = body.skills()

    /**
     * Returns the raw JSON value of [capabilityDirectories].
     *
     * Unlike [capabilityDirectories], this method doesn't throw if the JSON field has an unexpected
     * type.
     */
    fun _capabilityDirectories(): JsonField<List<String>> = body._capabilityDirectories()

    /**
     * Returns the raw JSON value of [env].
     *
     * Unlike [env], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _env(): JsonField<Env> = body._env()

    /**
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _files(): JsonField<List<HostedEnvironmentFileParam>> = body._files()

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _name(): JsonField<String> = body._name()

    /**
     * Returns the raw JSON value of [network].
     *
     * Unlike [network], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _network(): JsonField<Network> = body._network()

    /**
     * Returns the raw JSON value of [packages].
     *
     * Unlike [packages], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _packages(): JsonField<Packages> = body._packages()

    /**
     * Returns the raw JSON value of [plugins].
     *
     * Unlike [plugins], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _plugins(): JsonField<List<HostedPluginParam>> = body._plugins()

    /**
     * Returns the raw JSON value of [setupCommands].
     *
     * Unlike [setupCommands], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _setupCommands(): JsonField<List<SetupCommandParam>> = body._setupCommands()

    /**
     * Returns the raw JSON value of [skills].
     *
     * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _skills(): JsonField<List<HostedSkillParam>> = body._skills()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): TemplateCreateParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [TemplateCreateParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [TemplateCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(templateCreateParams: TemplateCreateParams) = apply {
            body = templateCreateParams.body.toBuilder()
            additionalHeaders = templateCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = templateCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [capabilityDirectories]
         * - [env]
         * - [files]
         * - [name]
         * - [network]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Directories that contain capabilities exposed to the agent. Defaults to an empty list.
         */
        fun capabilityDirectories(capabilityDirectories: List<String>?) = apply {
            body.capabilityDirectories(capabilityDirectories)
        }

        /**
         * Alias for calling [Builder.capabilityDirectories] with
         * `capabilityDirectories.orElse(null)`.
         */
        fun capabilityDirectories(capabilityDirectories: Optional<List<String>>) =
            capabilityDirectories(capabilityDirectories.getOrNull())

        /**
         * Sets [Builder.capabilityDirectories] to an arbitrary JSON value.
         *
         * You should usually call [Builder.capabilityDirectories] with a well-typed `List<String>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun capabilityDirectories(capabilityDirectories: JsonField<List<String>>) = apply {
            body.capabilityDirectories(capabilityDirectories)
        }

        /**
         * Adds a single [String] to [capabilityDirectories].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCapabilityDirectory(capabilityDirectory: String) = apply {
            body.addCapabilityDirectory(capabilityDirectory)
        }

        /** Environment variables made available to the agent. */
        fun env(env: Env?) = apply { body.env(env) }

        /** Alias for calling [Builder.env] with `env.orElse(null)`. */
        fun env(env: Optional<Env>) = env(env.getOrNull())

        /**
         * Sets [Builder.env] to an arbitrary JSON value.
         *
         * You should usually call [Builder.env] with a well-typed [Env] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun env(env: JsonField<Env>) = apply { body.env(env) }

        /** Files available before the agent starts. Defaults to an empty list. */
        fun files(files: List<HostedEnvironmentFileParam>?) = apply { body.files(files) }

        /** Alias for calling [Builder.files] with `files.orElse(null)`. */
        fun files(files: Optional<List<HostedEnvironmentFileParam>>) = files(files.getOrNull())

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed
         * `List<HostedEnvironmentFileParam>` value instead. This method is primarily for setting
         * the field to an undocumented or not yet supported value.
         */
        fun files(files: JsonField<List<HostedEnvironmentFileParam>>) = apply { body.files(files) }

        /**
         * Adds a single [HostedEnvironmentFileParam] to [files].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFile(file: HostedEnvironmentFileParam) = apply { body.addFile(file) }

        /** Alias for calling [addFile] with `HostedEnvironmentFileParam.ofFileId(fileId)`. */
        fun addFile(fileId: HostedEnvironmentFileParam.FileId) = apply { body.addFile(fileId) }

        /** Alias for calling [addFile] with `HostedEnvironmentFileParam.ofInline(inline)`. */
        fun addFile(inline: HostedEnvironmentFileParam.Inline) = apply { body.addFile(inline) }

        /** An optional human-readable display name for the template. */
        fun name(name: String?) = apply { body.name(name) }

        /** Alias for calling [Builder.name] with `name.orElse(null)`. */
        fun name(name: Optional<String>) = name(name.getOrNull())

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { body.name(name) }

        /** Network access for an OpenAI-hosted environment. */
        fun network(network: Network?) = apply { body.network(network) }

        /** Alias for calling [Builder.network] with `network.orElse(null)`. */
        fun network(network: Optional<Network>) = network(network.getOrNull())

        /**
         * Sets [Builder.network] to an arbitrary JSON value.
         *
         * You should usually call [Builder.network] with a well-typed [Network] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun network(network: JsonField<Network>) = apply { body.network(network) }

        /** Packages to install in an OpenAI-hosted environment. */
        fun packages(packages: Packages?) = apply { body.packages(packages) }

        /** Alias for calling [Builder.packages] with `packages.orElse(null)`. */
        fun packages(packages: Optional<Packages>) = packages(packages.getOrNull())

        /**
         * Sets [Builder.packages] to an arbitrary JSON value.
         *
         * You should usually call [Builder.packages] with a well-typed [Packages] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun packages(packages: JsonField<Packages>) = apply { body.packages(packages) }

        /** Plugins provided as inline ZIP archives. Defaults to an empty list. */
        fun plugins(plugins: List<HostedPluginParam>?) = apply { body.plugins(plugins) }

        /** Alias for calling [Builder.plugins] with `plugins.orElse(null)`. */
        fun plugins(plugins: Optional<List<HostedPluginParam>>) = plugins(plugins.getOrNull())

        /**
         * Sets [Builder.plugins] to an arbitrary JSON value.
         *
         * You should usually call [Builder.plugins] with a well-typed `List<HostedPluginParam>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun plugins(plugins: JsonField<List<HostedPluginParam>>) = apply { body.plugins(plugins) }

        /**
         * Adds a single [HostedPluginParam] to [plugins].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addPlugin(plugin: HostedPluginParam) = apply { body.addPlugin(plugin) }

        /** Ordered, confidential setup commands. Command bodies are never returned. */
        fun setupCommands(setupCommands: List<SetupCommandParam>?) = apply {
            body.setupCommands(setupCommands)
        }

        /** Alias for calling [Builder.setupCommands] with `setupCommands.orElse(null)`. */
        fun setupCommands(setupCommands: Optional<List<SetupCommandParam>>) =
            setupCommands(setupCommands.getOrNull())

        /**
         * Sets [Builder.setupCommands] to an arbitrary JSON value.
         *
         * You should usually call [Builder.setupCommands] with a well-typed
         * `List<SetupCommandParam>` value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun setupCommands(setupCommands: JsonField<List<SetupCommandParam>>) = apply {
            body.setupCommands(setupCommands)
        }

        /**
         * Adds a single [SetupCommandParam] to [setupCommands].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSetupCommand(setupCommand: SetupCommandParam) = apply {
            body.addSetupCommand(setupCommand)
        }

        /**
         * Skills referenced by ID or provided as inline ZIP archives. Defaults to an empty list.
         */
        fun skills(skills: List<HostedSkillParam>?) = apply { body.skills(skills) }

        /** Alias for calling [Builder.skills] with `skills.orElse(null)`. */
        fun skills(skills: Optional<List<HostedSkillParam>>) = skills(skills.getOrNull())

        /**
         * Sets [Builder.skills] to an arbitrary JSON value.
         *
         * You should usually call [Builder.skills] with a well-typed `List<HostedSkillParam>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun skills(skills: JsonField<List<HostedSkillParam>>) = apply { body.skills(skills) }

        /**
         * Adds a single [HostedSkillParam] to [skills].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addSkill(skill: HostedSkillParam) = apply { body.addSkill(skill) }

        /**
         * Alias for calling [addSkill] with `HostedSkillParam.ofSkillReference(skillReference)`.
         */
        fun addSkill(skillReference: HostedSkillParam.SkillReference) = apply {
            body.addSkill(skillReference)
        }

        /**
         * Alias for calling [addSkill] with the following:
         * ```java
         * HostedSkillParam.SkillReference.builder()
         *     .skillId(skillId)
         *     .build()
         * ```
         */
        fun addSkillReferenceSkill(skillId: String) = apply { body.addSkillReferenceSkill(skillId) }

        /** Alias for calling [addSkill] with `HostedSkillParam.ofInline(inline)`. */
        fun addSkill(inline: HostedSkillParam.Inline) = apply { body.addSkill(inline) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [TemplateCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): TemplateCreateParams =
            TemplateCreateParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    /** Parameters for creating a reusable, project-scoped OpenAI-hosted environment template. */
    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val capabilityDirectories: JsonField<List<String>>,
        private val env: JsonField<Env>,
        private val files: JsonField<List<HostedEnvironmentFileParam>>,
        private val name: JsonField<String>,
        private val network: JsonField<Network>,
        private val packages: JsonField<Packages>,
        private val plugins: JsonField<List<HostedPluginParam>>,
        private val setupCommands: JsonField<List<SetupCommandParam>>,
        private val skills: JsonField<List<HostedSkillParam>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("capability_directories")
            @ExcludeMissing
            capabilityDirectories: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("env") @ExcludeMissing env: JsonField<Env> = JsonMissing.of(),
            @JsonProperty("files")
            @ExcludeMissing
            files: JsonField<List<HostedEnvironmentFileParam>> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("network") @ExcludeMissing network: JsonField<Network> = JsonMissing.of(),
            @JsonProperty("packages")
            @ExcludeMissing
            packages: JsonField<Packages> = JsonMissing.of(),
            @JsonProperty("plugins")
            @ExcludeMissing
            plugins: JsonField<List<HostedPluginParam>> = JsonMissing.of(),
            @JsonProperty("setup_commands")
            @ExcludeMissing
            setupCommands: JsonField<List<SetupCommandParam>> = JsonMissing.of(),
            @JsonProperty("skills")
            @ExcludeMissing
            skills: JsonField<List<HostedSkillParam>> = JsonMissing.of(),
        ) : this(
            capabilityDirectories,
            env,
            files,
            name,
            network,
            packages,
            plugins,
            setupCommands,
            skills,
            mutableMapOf(),
        )

        /**
         * Directories that contain capabilities exposed to the agent. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun capabilityDirectories(): Optional<List<String>> =
            capabilityDirectories.getOptional("capability_directories")

        /**
         * Environment variables made available to the agent.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun env(): Optional<Env> = env.getOptional("env")

        /**
         * Files available before the agent starts. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun files(): Optional<List<HostedEnvironmentFileParam>> = files.getOptional("files")

        /**
         * An optional human-readable display name for the template.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * Network access for an OpenAI-hosted environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun network(): Optional<Network> = network.getOptional("network")

        /**
         * Packages to install in an OpenAI-hosted environment.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun packages(): Optional<Packages> = packages.getOptional("packages")

        /**
         * Plugins provided as inline ZIP archives. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun plugins(): Optional<List<HostedPluginParam>> = plugins.getOptional("plugins")

        /**
         * Ordered, confidential setup commands. Command bodies are never returned.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun setupCommands(): Optional<List<SetupCommandParam>> =
            setupCommands.getOptional("setup_commands")

        /**
         * Skills referenced by ID or provided as inline ZIP archives. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun skills(): Optional<List<HostedSkillParam>> = skills.getOptional("skills")

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
         * Returns the raw JSON value of [env].
         *
         * Unlike [env], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("env") @ExcludeMissing fun _env(): JsonField<Env> = env

        /**
         * Returns the raw JSON value of [files].
         *
         * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("files")
        @ExcludeMissing
        fun _files(): JsonField<List<HostedEnvironmentFileParam>> = files

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
        @JsonProperty("plugins")
        @ExcludeMissing
        fun _plugins(): JsonField<List<HostedPluginParam>> = plugins

        /**
         * Returns the raw JSON value of [setupCommands].
         *
         * Unlike [setupCommands], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("setup_commands")
        @ExcludeMissing
        fun _setupCommands(): JsonField<List<SetupCommandParam>> = setupCommands

        /**
         * Returns the raw JSON value of [skills].
         *
         * Unlike [skills], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("skills")
        @ExcludeMissing
        fun _skills(): JsonField<List<HostedSkillParam>> = skills

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var capabilityDirectories: JsonField<MutableList<String>>? = null
            private var env: JsonField<Env> = JsonMissing.of()
            private var files: JsonField<MutableList<HostedEnvironmentFileParam>>? = null
            private var name: JsonField<String> = JsonMissing.of()
            private var network: JsonField<Network> = JsonMissing.of()
            private var packages: JsonField<Packages> = JsonMissing.of()
            private var plugins: JsonField<MutableList<HostedPluginParam>>? = null
            private var setupCommands: JsonField<MutableList<SetupCommandParam>>? = null
            private var skills: JsonField<MutableList<HostedSkillParam>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                capabilityDirectories = body.capabilityDirectories.map { it.toMutableList() }
                env = body.env
                files = body.files.map { it.toMutableList() }
                name = body.name
                network = body.network
                packages = body.packages
                plugins = body.plugins.map { it.toMutableList() }
                setupCommands = body.setupCommands.map { it.toMutableList() }
                skills = body.skills.map { it.toMutableList() }
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Directories that contain capabilities exposed to the agent. Defaults to an empty
             * list.
             */
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

            /** Environment variables made available to the agent. */
            fun env(env: Env?) = env(JsonField.ofNullable(env))

            /** Alias for calling [Builder.env] with `env.orElse(null)`. */
            fun env(env: Optional<Env>) = env(env.getOrNull())

            /**
             * Sets [Builder.env] to an arbitrary JSON value.
             *
             * You should usually call [Builder.env] with a well-typed [Env] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun env(env: JsonField<Env>) = apply { this.env = env }

            /** Files available before the agent starts. Defaults to an empty list. */
            fun files(files: List<HostedEnvironmentFileParam>?) = files(JsonField.ofNullable(files))

            /** Alias for calling [Builder.files] with `files.orElse(null)`. */
            fun files(files: Optional<List<HostedEnvironmentFileParam>>) = files(files.getOrNull())

            /**
             * Sets [Builder.files] to an arbitrary JSON value.
             *
             * You should usually call [Builder.files] with a well-typed
             * `List<HostedEnvironmentFileParam>` value instead. This method is primarily for
             * setting the field to an undocumented or not yet supported value.
             */
            fun files(files: JsonField<List<HostedEnvironmentFileParam>>) = apply {
                this.files = files.map { it.toMutableList() }
            }

            /**
             * Adds a single [HostedEnvironmentFileParam] to [files].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addFile(file: HostedEnvironmentFileParam) = apply {
                files =
                    (files ?: JsonField.of(mutableListOf())).also {
                        checkKnown("files", it).add(file)
                    }
            }

            /** Alias for calling [addFile] with `HostedEnvironmentFileParam.ofFileId(fileId)`. */
            fun addFile(fileId: HostedEnvironmentFileParam.FileId) =
                addFile(HostedEnvironmentFileParam.ofFileId(fileId))

            /** Alias for calling [addFile] with `HostedEnvironmentFileParam.ofInline(inline)`. */
            fun addFile(inline: HostedEnvironmentFileParam.Inline) =
                addFile(HostedEnvironmentFileParam.ofInline(inline))

            /** An optional human-readable display name for the template. */
            fun name(name: String?) = name(JsonField.ofNullable(name))

            /** Alias for calling [Builder.name] with `name.orElse(null)`. */
            fun name(name: Optional<String>) = name(name.getOrNull())

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** Network access for an OpenAI-hosted environment. */
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

            /** Packages to install in an OpenAI-hosted environment. */
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

            /** Plugins provided as inline ZIP archives. Defaults to an empty list. */
            fun plugins(plugins: List<HostedPluginParam>?) = plugins(JsonField.ofNullable(plugins))

            /** Alias for calling [Builder.plugins] with `plugins.orElse(null)`. */
            fun plugins(plugins: Optional<List<HostedPluginParam>>) = plugins(plugins.getOrNull())

            /**
             * Sets [Builder.plugins] to an arbitrary JSON value.
             *
             * You should usually call [Builder.plugins] with a well-typed `List<HostedPluginParam>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun plugins(plugins: JsonField<List<HostedPluginParam>>) = apply {
                this.plugins = plugins.map { it.toMutableList() }
            }

            /**
             * Adds a single [HostedPluginParam] to [plugins].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addPlugin(plugin: HostedPluginParam) = apply {
                plugins =
                    (plugins ?: JsonField.of(mutableListOf())).also {
                        checkKnown("plugins", it).add(plugin)
                    }
            }

            /** Ordered, confidential setup commands. Command bodies are never returned. */
            fun setupCommands(setupCommands: List<SetupCommandParam>?) =
                setupCommands(JsonField.ofNullable(setupCommands))

            /** Alias for calling [Builder.setupCommands] with `setupCommands.orElse(null)`. */
            fun setupCommands(setupCommands: Optional<List<SetupCommandParam>>) =
                setupCommands(setupCommands.getOrNull())

            /**
             * Sets [Builder.setupCommands] to an arbitrary JSON value.
             *
             * You should usually call [Builder.setupCommands] with a well-typed
             * `List<SetupCommandParam>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun setupCommands(setupCommands: JsonField<List<SetupCommandParam>>) = apply {
                this.setupCommands = setupCommands.map { it.toMutableList() }
            }

            /**
             * Adds a single [SetupCommandParam] to [setupCommands].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSetupCommand(setupCommand: SetupCommandParam) = apply {
                setupCommands =
                    (setupCommands ?: JsonField.of(mutableListOf())).also {
                        checkKnown("setupCommands", it).add(setupCommand)
                    }
            }

            /**
             * Skills referenced by ID or provided as inline ZIP archives. Defaults to an empty
             * list.
             */
            fun skills(skills: List<HostedSkillParam>?) = skills(JsonField.ofNullable(skills))

            /** Alias for calling [Builder.skills] with `skills.orElse(null)`. */
            fun skills(skills: Optional<List<HostedSkillParam>>) = skills(skills.getOrNull())

            /**
             * Sets [Builder.skills] to an arbitrary JSON value.
             *
             * You should usually call [Builder.skills] with a well-typed `List<HostedSkillParam>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun skills(skills: JsonField<List<HostedSkillParam>>) = apply {
                this.skills = skills.map { it.toMutableList() }
            }

            /**
             * Adds a single [HostedSkillParam] to [skills].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addSkill(skill: HostedSkillParam) = apply {
                skills =
                    (skills ?: JsonField.of(mutableListOf())).also {
                        checkKnown("skills", it).add(skill)
                    }
            }

            /**
             * Alias for calling [addSkill] with
             * `HostedSkillParam.ofSkillReference(skillReference)`.
             */
            fun addSkill(skillReference: HostedSkillParam.SkillReference) =
                addSkill(HostedSkillParam.ofSkillReference(skillReference))

            /**
             * Alias for calling [addSkill] with the following:
             * ```java
             * HostedSkillParam.SkillReference.builder()
             *     .skillId(skillId)
             *     .build()
             * ```
             */
            fun addSkillReferenceSkill(skillId: String) =
                addSkill(HostedSkillParam.SkillReference.builder().skillId(skillId).build())

            /** Alias for calling [addSkill] with `HostedSkillParam.ofInline(inline)`. */
            fun addSkill(inline: HostedSkillParam.Inline) =
                addSkill(HostedSkillParam.ofInline(inline))

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    (capabilityDirectories ?: JsonMissing.of()).map { it.toImmutable() },
                    env,
                    (files ?: JsonMissing.of()).map { it.toImmutable() },
                    name,
                    network,
                    packages,
                    (plugins ?: JsonMissing.of()).map { it.toImmutable() },
                    (setupCommands ?: JsonMissing.of()).map { it.toImmutable() },
                    (skills ?: JsonMissing.of()).map { it.toImmutable() },
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
        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            capabilityDirectories()
            env().ifPresent { it.validate() }
            files().ifPresent { it.forEach { it.validate() } }
            name()
            network().ifPresent { it.validate() }
            packages().ifPresent { it.validate() }
            plugins().ifPresent { it.forEach { it.validate() } }
            setupCommands().ifPresent { it.forEach { it.validate() } }
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (capabilityDirectories.asKnown().getOrNull()?.size ?: 0) +
                (env.asKnown().getOrNull()?.validity() ?: 0) +
                (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (network.asKnown().getOrNull()?.validity() ?: 0) +
                (packages.asKnown().getOrNull()?.validity() ?: 0) +
                (plugins.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (setupCommands.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (skills.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                capabilityDirectories == other.capabilityDirectories &&
                env == other.env &&
                files == other.files &&
                name == other.name &&
                network == other.network &&
                packages == other.packages &&
                plugins == other.plugins &&
                setupCommands == other.setupCommands &&
                skills == other.skills &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                capabilityDirectories,
                env,
                files,
                name,
                network,
                packages,
                plugins,
                setupCommands,
                skills,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{capabilityDirectories=$capabilityDirectories, env=$env, files=$files, name=$name, network=$network, packages=$packages, plugins=$plugins, setupCommands=$setupCommands, skills=$skills, additionalProperties=$additionalProperties}"
    }

    /** Environment variables made available to the agent. */
    class Env
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Env]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Env]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(env: Env) = apply {
                additionalProperties = env.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Env].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Env = Env(additionalProperties.toImmutable())
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
        fun validate(): Env = apply {
            if (validated) {
                return@apply
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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Env && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Env{additionalProperties=$additionalProperties}"
    }

    /** Network access for an OpenAI-hosted environment. */
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
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun allowedDomains(): Optional<List<String>> = allowedDomains.getOptional("allowed_domains")

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
            fun allowedDomains(allowedDomains: List<String>?) =
                allowedDomains(JsonField.ofNullable(allowedDomains))

            /** Alias for calling [Builder.allowedDomains] with `allowedDomains.orElse(null)`. */
            fun allowedDomains(allowedDomains: Optional<List<String>>) =
                allowedDomains(allowedDomains.getOrNull())

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
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Network =
                Network(
                    checkRequired("access", access),
                    (allowedDomains ?: JsonMissing.of()).map { it.toImmutable() },
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

                /** Allows unrestricted network access, matching an omitted network policy. */
                @JvmField val ENABLED = of("enabled")

                /** Disables network access. */
                @JvmField val DISABLED = of("disabled")

                /** Allows access only to configured domains. */
                @JvmField val RESTRICTED = of("restricted")

                @JvmStatic fun of(value: String) = Access(JsonField.of(value))
            }

            /** An enum containing [Access]'s known values. */
            enum class Known {
                /** Allows unrestricted network access, matching an omitted network policy. */
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
                /** Allows unrestricted network access, matching an omitted network policy. */
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

    /** Packages to install in an OpenAI-hosted environment. */
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
         * npm packages to install globally. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun npm(): Optional<List<String>> = npm.getOptional("npm")

        /**
         * Python packages to install. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun python(): Optional<List<String>> = python.getOptional("python")

        /**
         * System packages to install. Defaults to an empty list.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun system(): Optional<List<String>> = system.getOptional("system")

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

            /** Returns a mutable builder for constructing an instance of [Packages]. */
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

            /** npm packages to install globally. Defaults to an empty list. */
            fun npm(npm: List<String>?) = npm(JsonField.ofNullable(npm))

            /** Alias for calling [Builder.npm] with `npm.orElse(null)`. */
            fun npm(npm: Optional<List<String>>) = npm(npm.getOrNull())

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

            /** Python packages to install. Defaults to an empty list. */
            fun python(python: List<String>?) = python(JsonField.ofNullable(python))

            /** Alias for calling [Builder.python] with `python.orElse(null)`. */
            fun python(python: Optional<List<String>>) = python(python.getOrNull())

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

            /** System packages to install. Defaults to an empty list. */
            fun system(system: List<String>?) = system(JsonField.ofNullable(system))

            /** Alias for calling [Builder.system] with `system.orElse(null)`. */
            fun system(system: Optional<List<String>>) = system(system.getOrNull())

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
             */
            fun build(): Packages =
                Packages(
                    (npm ?: JsonMissing.of()).map { it.toImmutable() },
                    (python ?: JsonMissing.of()).map { it.toImmutable() },
                    (system ?: JsonMissing.of()).map { it.toImmutable() },
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TemplateCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "TemplateCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
