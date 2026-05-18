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
import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Updates hosted tool permissions for a project. */
class HostedToolPermissionUpdateParams
private constructor(
    private val projectId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun projectId(): Optional<String> = Optional.ofNullable(projectId)

    /**
     * The code interpreter permission update.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun codeInterpreter(): Optional<CodeInterpreter> = body.codeInterpreter()

    /**
     * The file search permission update.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun fileSearch(): Optional<FileSearch> = body.fileSearch()

    /**
     * The image generation permission update.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun imageGeneration(): Optional<ImageGeneration> = body.imageGeneration()

    /**
     * The MCP permission update.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mcp(): Optional<Mcp> = body.mcp()

    /**
     * The web search permission update.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun webSearch(): Optional<WebSearch> = body.webSearch()

    /**
     * Returns the raw JSON value of [codeInterpreter].
     *
     * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _codeInterpreter(): JsonField<CodeInterpreter> = body._codeInterpreter()

    /**
     * Returns the raw JSON value of [fileSearch].
     *
     * Unlike [fileSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fileSearch(): JsonField<FileSearch> = body._fileSearch()

    /**
     * Returns the raw JSON value of [imageGeneration].
     *
     * Unlike [imageGeneration], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _imageGeneration(): JsonField<ImageGeneration> = body._imageGeneration()

    /**
     * Returns the raw JSON value of [mcp].
     *
     * Unlike [mcp], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _mcp(): JsonField<Mcp> = body._mcp()

    /**
     * Returns the raw JSON value of [webSearch].
     *
     * Unlike [webSearch], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _webSearch(): JsonField<WebSearch> = body._webSearch()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): HostedToolPermissionUpdateParams = builder().build()

        /**
         * Returns a mutable builder for constructing an instance of
         * [HostedToolPermissionUpdateParams].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [HostedToolPermissionUpdateParams]. */
    class Builder internal constructor() {

        private var projectId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(hostedToolPermissionUpdateParams: HostedToolPermissionUpdateParams) =
            apply {
                projectId = hostedToolPermissionUpdateParams.projectId
                body = hostedToolPermissionUpdateParams.body.toBuilder()
                additionalHeaders = hostedToolPermissionUpdateParams.additionalHeaders.toBuilder()
                additionalQueryParams =
                    hostedToolPermissionUpdateParams.additionalQueryParams.toBuilder()
            }

        fun projectId(projectId: String?) = apply { this.projectId = projectId }

        /** Alias for calling [Builder.projectId] with `projectId.orElse(null)`. */
        fun projectId(projectId: Optional<String>) = projectId(projectId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [codeInterpreter]
         * - [fileSearch]
         * - [imageGeneration]
         * - [mcp]
         * - [webSearch]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** The code interpreter permission update. */
        fun codeInterpreter(codeInterpreter: CodeInterpreter?) = apply {
            body.codeInterpreter(codeInterpreter)
        }

        /** Alias for calling [Builder.codeInterpreter] with `codeInterpreter.orElse(null)`. */
        fun codeInterpreter(codeInterpreter: Optional<CodeInterpreter>) =
            codeInterpreter(codeInterpreter.getOrNull())

        /**
         * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
         *
         * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
            body.codeInterpreter(codeInterpreter)
        }

        /** The file search permission update. */
        fun fileSearch(fileSearch: FileSearch?) = apply { body.fileSearch(fileSearch) }

        /** Alias for calling [Builder.fileSearch] with `fileSearch.orElse(null)`. */
        fun fileSearch(fileSearch: Optional<FileSearch>) = fileSearch(fileSearch.getOrNull())

        /**
         * Sets [Builder.fileSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun fileSearch(fileSearch: JsonField<FileSearch>) = apply { body.fileSearch(fileSearch) }

        /** The image generation permission update. */
        fun imageGeneration(imageGeneration: ImageGeneration?) = apply {
            body.imageGeneration(imageGeneration)
        }

        /** Alias for calling [Builder.imageGeneration] with `imageGeneration.orElse(null)`. */
        fun imageGeneration(imageGeneration: Optional<ImageGeneration>) =
            imageGeneration(imageGeneration.getOrNull())

        /**
         * Sets [Builder.imageGeneration] to an arbitrary JSON value.
         *
         * You should usually call [Builder.imageGeneration] with a well-typed [ImageGeneration]
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun imageGeneration(imageGeneration: JsonField<ImageGeneration>) = apply {
            body.imageGeneration(imageGeneration)
        }

        /** The MCP permission update. */
        fun mcp(mcp: Mcp?) = apply { body.mcp(mcp) }

        /** Alias for calling [Builder.mcp] with `mcp.orElse(null)`. */
        fun mcp(mcp: Optional<Mcp>) = mcp(mcp.getOrNull())

        /**
         * Sets [Builder.mcp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mcp] with a well-typed [Mcp] value instead. This method
         * is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun mcp(mcp: JsonField<Mcp>) = apply { body.mcp(mcp) }

        /** The web search permission update. */
        fun webSearch(webSearch: WebSearch?) = apply { body.webSearch(webSearch) }

        /** Alias for calling [Builder.webSearch] with `webSearch.orElse(null)`. */
        fun webSearch(webSearch: Optional<WebSearch>) = webSearch(webSearch.getOrNull())

        /**
         * Sets [Builder.webSearch] to an arbitrary JSON value.
         *
         * You should usually call [Builder.webSearch] with a well-typed [WebSearch] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun webSearch(webSearch: JsonField<WebSearch>) = apply { body.webSearch(webSearch) }

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
         * Returns an immutable instance of [HostedToolPermissionUpdateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): HostedToolPermissionUpdateParams =
            HostedToolPermissionUpdateParams(
                projectId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> projectId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
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
         * The code interpreter permission update.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeInterpreter(): Optional<CodeInterpreter> =
            codeInterpreter.getOptional("code_interpreter")

        /**
         * The file search permission update.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> = fileSearch.getOptional("file_search")

        /**
         * The image generation permission update.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun imageGeneration(): Optional<ImageGeneration> =
            imageGeneration.getOptional("image_generation")

        /**
         * The MCP permission update.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun mcp(): Optional<Mcp> = mcp.getOptional("mcp")

        /**
         * The web search permission update.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun webSearch(): Optional<WebSearch> = webSearch.getOptional("web_search")

        /**
         * Returns the raw JSON value of [codeInterpreter].
         *
         * Unlike [codeInterpreter], this method doesn't throw if the JSON field has an unexpected
         * type.
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
         * Unlike [imageGeneration], this method doesn't throw if the JSON field has an unexpected
         * type.
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
        @JsonProperty("web_search")
        @ExcludeMissing
        fun _webSearch(): JsonField<WebSearch> = webSearch

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

            private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
            private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
            private var imageGeneration: JsonField<ImageGeneration> = JsonMissing.of()
            private var mcp: JsonField<Mcp> = JsonMissing.of()
            private var webSearch: JsonField<WebSearch> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                codeInterpreter = body.codeInterpreter
                fileSearch = body.fileSearch
                imageGeneration = body.imageGeneration
                mcp = body.mcp
                webSearch = body.webSearch
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** The code interpreter permission update. */
            fun codeInterpreter(codeInterpreter: CodeInterpreter?) =
                codeInterpreter(JsonField.ofNullable(codeInterpreter))

            /** Alias for calling [Builder.codeInterpreter] with `codeInterpreter.orElse(null)`. */
            fun codeInterpreter(codeInterpreter: Optional<CodeInterpreter>) =
                codeInterpreter(codeInterpreter.getOrNull())

            /**
             * Sets [Builder.codeInterpreter] to an arbitrary JSON value.
             *
             * You should usually call [Builder.codeInterpreter] with a well-typed [CodeInterpreter]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun codeInterpreter(codeInterpreter: JsonField<CodeInterpreter>) = apply {
                this.codeInterpreter = codeInterpreter
            }

            /** The file search permission update. */
            fun fileSearch(fileSearch: FileSearch?) = fileSearch(JsonField.ofNullable(fileSearch))

            /** Alias for calling [Builder.fileSearch] with `fileSearch.orElse(null)`. */
            fun fileSearch(fileSearch: Optional<FileSearch>) = fileSearch(fileSearch.getOrNull())

            /**
             * Sets [Builder.fileSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fileSearch] with a well-typed [FileSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fileSearch(fileSearch: JsonField<FileSearch>) = apply {
                this.fileSearch = fileSearch
            }

            /** The image generation permission update. */
            fun imageGeneration(imageGeneration: ImageGeneration?) =
                imageGeneration(JsonField.ofNullable(imageGeneration))

            /** Alias for calling [Builder.imageGeneration] with `imageGeneration.orElse(null)`. */
            fun imageGeneration(imageGeneration: Optional<ImageGeneration>) =
                imageGeneration(imageGeneration.getOrNull())

            /**
             * Sets [Builder.imageGeneration] to an arbitrary JSON value.
             *
             * You should usually call [Builder.imageGeneration] with a well-typed [ImageGeneration]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun imageGeneration(imageGeneration: JsonField<ImageGeneration>) = apply {
                this.imageGeneration = imageGeneration
            }

            /** The MCP permission update. */
            fun mcp(mcp: Mcp?) = mcp(JsonField.ofNullable(mcp))

            /** Alias for calling [Builder.mcp] with `mcp.orElse(null)`. */
            fun mcp(mcp: Optional<Mcp>) = mcp(mcp.getOrNull())

            /**
             * Sets [Builder.mcp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mcp] with a well-typed [Mcp] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun mcp(mcp: JsonField<Mcp>) = apply { this.mcp = mcp }

            /** The web search permission update. */
            fun webSearch(webSearch: WebSearch?) = webSearch(JsonField.ofNullable(webSearch))

            /** Alias for calling [Builder.webSearch] with `webSearch.orElse(null)`. */
            fun webSearch(webSearch: Optional<WebSearch>) = webSearch(webSearch.getOrNull())

            /**
             * Sets [Builder.webSearch] to an arbitrary JSON value.
             *
             * You should usually call [Builder.webSearch] with a well-typed [WebSearch] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Body =
                Body(
                    codeInterpreter,
                    fileSearch,
                    imageGeneration,
                    mcp,
                    webSearch,
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

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            imageGeneration().ifPresent { it.validate() }
            mcp().ifPresent { it.validate() }
            webSearch().ifPresent { it.validate() }
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
            (codeInterpreter.asKnown().getOrNull()?.validity() ?: 0) +
                (fileSearch.asKnown().getOrNull()?.validity() ?: 0) +
                (imageGeneration.asKnown().getOrNull()?.validity() ?: 0) +
                (mcp.asKnown().getOrNull()?.validity() ?: 0) +
                (webSearch.asKnown().getOrNull()?.validity() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
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
            "Body{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, imageGeneration=$imageGeneration, mcp=$mcp, webSearch=$webSearch, additionalProperties=$additionalProperties}"
    }

    /** The code interpreter permission update. */
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
         * Whether to enable the hosted tool for the project.
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

            /** Whether to enable the hosted tool for the project. */
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

    /** The file search permission update. */
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
         * Whether to enable the hosted tool for the project.
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

            /** Whether to enable the hosted tool for the project. */
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

    /** The image generation permission update. */
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
         * Whether to enable the hosted tool for the project.
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

            /** Whether to enable the hosted tool for the project. */
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

    /** The MCP permission update. */
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
         * Whether to enable the hosted tool for the project.
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

            /** Whether to enable the hosted tool for the project. */
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

    /** The web search permission update. */
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
         * Whether to enable the hosted tool for the project.
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

            /** Whether to enable the hosted tool for the project. */
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

        return other is HostedToolPermissionUpdateParams &&
            projectId == other.projectId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(projectId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "HostedToolPermissionUpdateParams{projectId=$projectId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
