// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import java.util.Objects
import java.util.Optional

class BetaThreadUpdateParams
constructor(
    private val threadId: String,
    private val body: BetaThreadUpdateBody,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) {

    fun threadId(): String = threadId

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format. Keys can be a maximum of 64
     * characters long and values can be a maximum of 512 characters long.
     */
    fun metadata(): Optional<JsonValue> = body.metadata()

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    fun toolResources(): Optional<ToolResources> = body.toolResources()

    fun _additionalHeaders(): Headers = additionalHeaders

    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    @JvmSynthetic internal fun getBody(): BetaThreadUpdateBody = body

    @JvmSynthetic internal fun getHeaders(): Headers = additionalHeaders

    @JvmSynthetic internal fun getQueryParams(): QueryParams = additionalQueryParams

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> threadId
            else -> ""
        }
    }

    @NoAutoDetect
    class BetaThreadUpdateBody
    @JsonCreator
    internal constructor(
        @JsonProperty("metadata") private val metadata: JsonValue?,
        @JsonProperty("tool_resources") private val toolResources: ToolResources?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        @JsonProperty("metadata")
        fun metadata(): Optional<JsonValue> = Optional.ofNullable(metadata)

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        @JsonProperty("tool_resources")
        fun toolResources(): Optional<ToolResources> = Optional.ofNullable(toolResources)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var metadata: JsonValue? = null
            private var toolResources: ToolResources? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(betaThreadUpdateBody: BetaThreadUpdateBody) = apply {
                metadata = betaThreadUpdateBody.metadata
                toolResources = betaThreadUpdateBody.toolResources
                additionalProperties = betaThreadUpdateBody.additionalProperties.toMutableMap()
            }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: JsonValue?) = apply { this.metadata = metadata }

            /**
             * Set of 16 key-value pairs that can be attached to an object. This can be useful for
             * storing additional information about the object in a structured format. Keys can be a
             * maximum of 64 characters long and values can be a maximum of 512 characters long.
             */
            fun metadata(metadata: Optional<JsonValue>) = metadata(metadata.orElse(null))

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: ToolResources?) = apply {
                this.toolResources = toolResources
            }

            /**
             * A set of resources that are made available to the assistant's tools in this thread.
             * The resources are specific to the type of tool. For example, the `code_interpreter`
             * tool requires a list of file IDs, while the `file_search` tool requires a list of
             * vector store IDs.
             */
            fun toolResources(toolResources: Optional<ToolResources>) =
                toolResources(toolResources.orElse(null))

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

            fun build(): BetaThreadUpdateBody =
                BetaThreadUpdateBody(
                    metadata,
                    toolResources,
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is BetaThreadUpdateBody && metadata == other.metadata && toolResources == other.toolResources && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(metadata, toolResources, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "BetaThreadUpdateBody{metadata=$metadata, toolResources=$toolResources, additionalProperties=$additionalProperties}"
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var threadId: String? = null
        private var body: BetaThreadUpdateBody.Builder = BetaThreadUpdateBody.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(betaThreadUpdateParams: BetaThreadUpdateParams) = apply {
            threadId = betaThreadUpdateParams.threadId
            body = betaThreadUpdateParams.body.toBuilder()
            additionalHeaders = betaThreadUpdateParams.additionalHeaders.toBuilder()
            additionalQueryParams = betaThreadUpdateParams.additionalQueryParams.toBuilder()
        }

        fun threadId(threadId: String) = apply { this.threadId = threadId }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: JsonValue?) = apply { body.metadata(metadata) }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format. Keys can be a
         * maximum of 64 characters long and values can be a maximum of 512 characters long.
         */
        fun metadata(metadata: Optional<JsonValue>) = metadata(metadata.orElse(null))

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: ToolResources?) = apply {
            body.toolResources(toolResources)
        }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.orElse(null))

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

        fun build(): BetaThreadUpdateParams =
            BetaThreadUpdateParams(
                checkNotNull(threadId) { "`threadId` is required but was not set" },
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    @NoAutoDetect
    class ToolResources
    @JsonCreator
    private constructor(
        @JsonProperty("code_interpreter") private val codeInterpreter: CodeInterpreter?,
        @JsonProperty("file_search") private val fileSearch: FileSearch?,
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        @JsonProperty("code_interpreter")
        fun codeInterpreter(): Optional<CodeInterpreter> = Optional.ofNullable(codeInterpreter)

        @JsonProperty("file_search")
        fun fileSearch(): Optional<FileSearch> = Optional.ofNullable(fileSearch)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var codeInterpreter: CodeInterpreter? = null
            private var fileSearch: FileSearch? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter?) = apply {
                this.codeInterpreter = codeInterpreter
            }

            fun codeInterpreter(codeInterpreter: Optional<CodeInterpreter>) =
                codeInterpreter(codeInterpreter.orElse(null))

            fun fileSearch(fileSearch: FileSearch?) = apply { this.fileSearch = fileSearch }

            fun fileSearch(fileSearch: Optional<FileSearch>) = fileSearch(fileSearch.orElse(null))

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

            fun build(): ToolResources =
                ToolResources(
                    codeInterpreter,
                    fileSearch,
                    additionalProperties.toImmutable(),
                )
        }

        @NoAutoDetect
        class CodeInterpreter
        @JsonCreator
        private constructor(
            @JsonProperty("file_ids") private val fileIds: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             */
            @JsonProperty("file_ids")
            fun fileIds(): Optional<List<String>> = Optional.ofNullable(fileIds)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var fileIds: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds?.toMutableList()
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>?) = apply {
                    this.fileIds = fileIds?.toMutableList()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: Optional<List<String>>) = fileIds(fileIds.orElse(null))

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun addFileId(fileId: String) = apply {
                    fileIds = (fileIds ?: mutableListOf()).apply { add(fileId) }
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

                fun build(): CodeInterpreter =
                    CodeInterpreter(fileIds?.toImmutable(), additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is CodeInterpreter && fileIds == other.fileIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(fileIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "CodeInterpreter{fileIds=$fileIds, additionalProperties=$additionalProperties}"
        }

        @NoAutoDetect
        class FileSearch
        @JsonCreator
        private constructor(
            @JsonProperty("vector_store_ids") private val vectorStoreIds: List<String>?,
            @JsonAnySetter
            private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
        ) {

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             */
            @JsonProperty("vector_store_ids")
            fun vectorStoreIds(): Optional<List<String>> = Optional.ofNullable(vectorStoreIds)

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var vectorStoreIds: MutableList<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds?.toMutableList()
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>?) = apply {
                    this.vectorStoreIds = vectorStoreIds?.toMutableList()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: Optional<List<String>>) =
                    vectorStoreIds(vectorStoreIds.orElse(null))

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: mutableListOf()).apply { add(vectorStoreId) }
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

                fun build(): FileSearch =
                    FileSearch(vectorStoreIds?.toImmutable(), additionalProperties.toImmutable())
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is FileSearch && vectorStoreIds == other.vectorStoreIds && additionalProperties == other.additionalProperties /* spotless:on */
            }

            /* spotless:off */
            private val hashCode: Int by lazy { Objects.hash(vectorStoreIds, additionalProperties) }
            /* spotless:on */

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "FileSearch{vectorStoreIds=$vectorStoreIds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is ToolResources && codeInterpreter == other.codeInterpreter && fileSearch == other.fileSearch && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(codeInterpreter, fileSearch, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "ToolResources{codeInterpreter=$codeInterpreter, fileSearch=$fileSearch, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BetaThreadUpdateParams && threadId == other.threadId && body == other.body && additionalHeaders == other.additionalHeaders && additionalQueryParams == other.additionalQueryParams /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(threadId, body, additionalHeaders, additionalQueryParams) /* spotless:on */

    override fun toString() =
        "BetaThreadUpdateParams{threadId=$threadId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
