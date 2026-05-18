// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.hostedtoolpermissions

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** Represents hosted tool permissions for a project. */
class ProjectHostedToolPermissions
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val codeInterpreter: JsonField<CodeInterpreter>,
    private val fileSearch: JsonField<FileSearch>,
    private val imageGeneration: JsonField<ImageGeneration>,
    private val mcp: JsonField<Mcp>,
    private val webSearch: JsonField<WebSearch>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("code_interpreter")
        @ExcludeMissing
        codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of(),
        @JsonProperty("file_search")
        @ExcludeMissing
        fileSearch: JsonField<FileSearch> = JsonMissing.of(),
        @JsonProperty("image_generation")
        @ExcludeMissing
        imageGeneration: JsonField<ImageGeneration> = JsonMissing.of(),
        @JsonProperty("mcp") @ExcludeMissing mcp: JsonField<Mcp> = JsonMissing.of(),
        @JsonProperty("web_search")
        @ExcludeMissing
        webSearch: JsonField<WebSearch> = JsonMissing.of(),
    ) : this(codeInterpreter, fileSearch, imageGeneration, mcp, webSearch, mutableMapOf())

    /**
     * Permission state for a single hosted tool on a project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun codeInterpreter(): CodeInterpreter = codeInterpreter.getRequired("code_interpreter")

    /**
     * Permission state for a single hosted tool on a project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fileSearch(): FileSearch = fileSearch.getRequired("file_search")

    /**
     * Permission state for a single hosted tool on a project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun imageGeneration(): ImageGeneration = imageGeneration.getRequired("image_generation")

    /**
     * Permission state for a single hosted tool on a project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun mcp(): Mcp = mcp.getRequired("mcp")

    /**
     * Permission state for a single hosted tool on a project.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun webSearch(): WebSearch = webSearch.getRequired("web_search")

    /**
     * Returns the raw JSON value of [codeInterpreter].
     *
     * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("code_interpreter")
    @ExcludeMissing
    fun _codeInterpreter(): JsonField<CodeInterpreter> = codeInterpreter

    /**
     * Returns the raw JSON value of [fileSearch].
     *
     * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("file_search")
    @ExcludeMissing
    fun _fileSearch(): JsonField<FileSearch> = fileSearch

    /**
     * Returns the raw JSON value of [imageGeneration].
     *
     * Unlike [imageGeneration], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("image_generation")
    @ExcludeMissing
    fun _imageGeneration(): JsonField<ImageGeneration> = imageGeneration

    /**
     * Returns the raw JSON value of [mcp].
     *
     * Unlike [mcp], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mcp") @ExcludeMissing fun _mcp(): JsonField<Mcp> = mcp

    /**
     * Returns the raw JSON value of [webSearch].
     *
     * Unlike [webSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("web_search") @ExcludeMissing fun _webSearch(): JsonField<WebSearch> = webSearch

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
         * Returns a mutable builder for constructing an instance of [ProjectHostedToolPermissions].
         *
         * The following fields are required:
         * ```java
         * .codeInterpreter()
         * .fileSearch()
         * .imageGeneration()
         * .mcp()
         * .webSearch()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ProjectHostedToolPermissions]. */
    class Builder internal constructor() {

        private var codeInterpreter: JsonField<CodeInterpreter>? = null
        private var fileSearch: JsonField<FileSearch>? = null
        private var imageGeneration: JsonField<ImageGeneration>? = null
        private var mcp: JsonField<Mcp>? = null
        private var webSearch: JsonField<WebSearch>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(projectHostedToolPermissions: ProjectHostedToolPermissions) = apply {
            codeInterpreter = projectHostedToolPermissions.codeInterpreter
            fileSearch = projectHostedToolPermissions.fileSearch
            imageGeneration = projectHostedToolPermissions.imageGeneration
            mcp = projectHostedToolPermissions.mcp
            webSearch = projectHostedToolPermissions.webSearch
            additionalProperties = projectHostedToolPermissions.additionalProperties.toMutableMap()
        }

        /** Permission state for a single hosted tool on a project. */
        fun codeInterpreter(codeInterpreter: CodeInterpreter) =
            codeInterpreter(JsonField.of(codeInterpreter))

        /**
         * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
            this.codeInterpreter = codeInterpreter
        }

        /** Permission state for a single hosted tool on a project. */
        fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

        /**
         * Sets [Builder.fileSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileSearch(fileSearch: JsonField<FileSearch>) = apply { this.fileSearch = fileSearch }

        /** Permission state for a single hosted tool on a project. */
        fun imageGeneration(imageGeneration: ImageGeneration) =
            imageGeneration(JsonField.of(imageGeneration))

        /**
         * Sets [Builder.imageGeneration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageGeneration] with a well-typed [ImageGeneration]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun imageGeneration(imageGeneration: JsonField<ImageGeneration>) = apply {
            this.imageGeneration = imageGeneration
        }

        /** Permission state for a single hosted tool on a project. */
        fun mcp(mcp: Mcp) = mcp(JsonField.of(mcp))

        /**
         * Sets [Builder.mcp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mcp] with a well-typed [Mcp] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mcp(mcp: JsonField<Mcp>) = apply { this.mcp = mcp }

        /** Permission state for a single hosted tool on a project. */
        fun webSearch(webSearch: WebSearch) = webSearch(JsonField.of(webSearch))

        /**
         * Sets [Builder.webSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webSearch] with a well-typed [WebSearch] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun webSearch(webSearch: JsonField<WebSearch>) = apply { this.webSearch = webSearch }

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
         * Returns an immutable instance of [ProjectHostedToolPermissions].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .codeInterpreter()
         * .fileSearch()
         * .imageGeneration()
         * .mcp()
         * .webSearch()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ProjectHostedToolPermissions =
            ProjectHostedToolPermissions(
                checkRequired("codeInterpreter", codeInterpreter),
                checkRequired("fileSearch", fileSearch),
                checkRequired("imageGeneration", imageGeneration),
                checkRequired("mcp", mcp),
                checkRequired("webSearch", webSearch),
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
    fun validate(): ProjectHostedToolPermissions = apply {
        if (validated) {
            return@apply
        }

        codeInterpreter().validate()
        fileSearch().validate()
        imageGeneration().validate()
        mcp().validate()
        webSearch().validate()
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
        (codeInterpreter.asKnown().getOrNull()?.validity() ?: 0) +
            (fileSearch.asKnown().getOrNull()?.validity() ?: 0) +
            (imageGeneration.asKnown().getOrNull()?.validity() ?: 0) +
            (mcp.asKnown().getOrNull()?.validity() ?: 0) +
            (webSearch.asKnown().getOrNull()?.validity() ?: 0)

    /** Permission state for a single hosted tool on a project. */
    class CodeInterpreter
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether the hosted tool is enabled for the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [CodeInterpreter].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CodeInterpreter]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(codeInterpreter: CodeInterpreter) = apply {
                enabled = codeInterpreter.enabled
                additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
            }

            /** Whether the hosted tool is enabled for the project. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [CodeInterpreter].
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
            fun build(): CodeInterpreter =
                CodeInterpreter(
                    checkRequired("enabled", enabled),
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
        fun validate(): CodeInterpreter = apply {
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

            return other is CodeInterpreter &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CodeInterpreter{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /** Permission state for a single hosted tool on a project. */
    class FileSearch
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether the hosted tool is enabled for the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [FileSearch].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FileSearch]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(fileSearch: FileSearch) = apply {
                enabled = fileSearch.enabled
                additionalProperties = fileSearch.additionalProperties.toMutableMap()
            }

            /** Whether the hosted tool is enabled for the project. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [FileSearch].
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
            fun build(): FileSearch =
                FileSearch(checkRequired("enabled", enabled), additionalProperties.toMutableMap())
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
        fun validate(): FileSearch = apply {
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

            return other is FileSearch &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FileSearch{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /** Permission state for a single hosted tool on a project. */
    class ImageGeneration
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether the hosted tool is enabled for the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [ImageGeneration].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ImageGeneration]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(imageGeneration: ImageGeneration) = apply {
                enabled = imageGeneration.enabled
                additionalProperties = imageGeneration.additionalProperties.toMutableMap()
            }

            /** Whether the hosted tool is enabled for the project. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [ImageGeneration].
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
            fun build(): ImageGeneration =
                ImageGeneration(
                    checkRequired("enabled", enabled),
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
        fun validate(): ImageGeneration = apply {
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

            return other is ImageGeneration &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ImageGeneration{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /** Permission state for a single hosted tool on a project. */
    class Mcp
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether the hosted tool is enabled for the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Mcp].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Mcp]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mcp: Mcp) = apply {
                enabled = mcp.enabled
                additionalProperties = mcp.additionalProperties.toMutableMap()
            }

            /** Whether the hosted tool is enabled for the project. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [Mcp].
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
            fun build(): Mcp =
                Mcp(checkRequired("enabled", enabled), additionalProperties.toMutableMap())
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
        fun validate(): Mcp = apply {
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

            return other is Mcp &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Mcp{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    /** Permission state for a single hosted tool on a project. */
    class WebSearch
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val enabled: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("enabled") @ExcludeMissing enabled: JsonField<Boolean> = JsonMissing.of()
        ) : this(enabled, mutableMapOf())

        /**
         * Whether the hosted tool is enabled for the project.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
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

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [WebSearch].
             *
             * The following fields are required:
             * ```java
             * .enabled()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [WebSearch]. */
        class Builder internal constructor() {

            private var enabled: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(webSearch: WebSearch) = apply {
                enabled = webSearch.enabled
                additionalProperties = webSearch.additionalProperties.toMutableMap()
            }

            /** Whether the hosted tool is enabled for the project. */
            fun enabled(enabled: Boolean) = enabled(JsonField.of(enabled))

            /**
             * Sets [Builder.enabled] to an arbitrary JSON value.
             *
             * You should usually call [Builder.enabled] with a well-typed [Boolean] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun enabled(enabled: JsonField<Boolean>) = apply { this.enabled = enabled }

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
             * Returns an immutable instance of [WebSearch].
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
            fun build(): WebSearch =
                WebSearch(checkRequired("enabled", enabled), additionalProperties.toMutableMap())
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
        fun validate(): WebSearch = apply {
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

            return other is WebSearch &&
                enabled == other.enabled &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(enabled, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "WebSearch{enabled=$enabled, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ProjectHostedToolPermissions &&
            codeInterpreter == other.codeInterpreter &&
            fileSearch == other.fileSearch &&
            imageGeneration == other.imageGeneration &&
            mcp == other.mcp &&
            webSearch == other.webSearch &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            codeInterpreter,
            fileSearch,
            imageGeneration,
            mcp,
            webSearch,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ProjectHostedToolPermissions{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, imageGeneration=$imageGeneration, mcp=$mcp, webSearch=$webSearch, additionalProperties=$additionalProperties}"
}
