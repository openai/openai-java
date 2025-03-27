// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Represents a thread that contains
 * [messages](https://platform.openai.com/docs/api-reference/messages).
 */
class Thread
private constructor(
    private val id: JsonField<String>,
    private val createdAt: JsonField<Long>,
    private val metadata: JsonField<Metadata>,
    private val object_: JsonValue,
    private val toolResources: JsonField<ToolResources>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("created_at") @ExcludeMissing createdAt: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("metadata") @ExcludeMissing metadata: JsonField<Metadata> = JsonMissing.of(),
        @JsonProperty("object") @ExcludeMissing object_: JsonValue = JsonMissing.of(),
        @JsonProperty("tool_resources")
        @ExcludeMissing
        toolResources: JsonField<ToolResources> = JsonMissing.of(),
    ) : this(id, createdAt, metadata, object_, toolResources, mutableMapOf())

    /**
     * The identifier, which can be referenced in API endpoints.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * The Unix timestamp (in seconds) for when the thread was created.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun createdAt(): Long = createdAt.getRequired("created_at")

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = Optional.ofNullable(metadata.getNullable("metadata"))

    /**
     * The object type, which is always `thread`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("thread")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("object") @ExcludeMissing fun _object_(): JsonValue = object_

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun toolResources(): Optional<ToolResources> =
        Optional.ofNullable(toolResources.getNullable("tool_resources"))

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
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

    /**
     * Returns the raw JSON value of [toolResources].
     *
     * Unlike [toolResources], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("tool_resources")
    @ExcludeMissing
    fun _toolResources(): JsonField<ToolResources> = toolResources

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
         * Returns a mutable builder for constructing an instance of [Thread].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .metadata()
         * .toolResources()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Thread]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var createdAt: JsonField<Long>? = null
        private var metadata: JsonField<Metadata>? = null
        private var object_: JsonValue = JsonValue.from("thread")
        private var toolResources: JsonField<ToolResources>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(thread: Thread) = apply {
            id = thread.id
            createdAt = thread.createdAt
            metadata = thread.metadata
            object_ = thread.object_
            toolResources = thread.toolResources
            additionalProperties = thread.additionalProperties.toMutableMap()
        }

        /** The identifier, which can be referenced in API endpoints. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The Unix timestamp (in seconds) for when the thread was created. */
        fun createdAt(createdAt: Long) = createdAt(JsonField.of(createdAt))

        /**
         * Sets [Builder.createdAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.createdAt] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun createdAt(createdAt: JsonField<Long>) = apply { this.createdAt = createdAt }

        /**
         * Set of 16 key-value pairs that can be attached to an object. This can be useful for
         * storing additional information about the object in a structured format, and querying for
         * objects via API or the dashboard.
         *
         * Keys are strings with a maximum length of 64 characters. Values are strings with a
         * maximum length of 512 characters.
         */
        fun metadata(metadata: Metadata?) = metadata(JsonField.ofNullable(metadata))

        /** Alias for calling [Builder.metadata] with `metadata.orElse(null)`. */
        fun metadata(metadata: Optional<Metadata>) = metadata(metadata.getOrNull())

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("thread")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun object_(object_: JsonValue) = apply { this.object_ = object_ }

        /**
         * A set of resources that are made available to the assistant's tools in this thread. The
         * resources are specific to the type of tool. For example, the `code_interpreter` tool
         * requires a list of file IDs, while the `file_search` tool requires a list of vector store
         * IDs.
         */
        fun toolResources(toolResources: ToolResources?) =
            toolResources(JsonField.ofNullable(toolResources))

        /** Alias for calling [Builder.toolResources] with `toolResources.orElse(null)`. */
        fun toolResources(toolResources: Optional<ToolResources>) =
            toolResources(toolResources.getOrNull())

        /**
         * Sets [Builder.toolResources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toolResources] with a well-typed [ToolResources] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun toolResources(toolResources: JsonField<ToolResources>) = apply {
            this.toolResources = toolResources
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
         * Returns an immutable instance of [Thread].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .createdAt()
         * .metadata()
         * .toolResources()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): Thread =
            Thread(
                checkRequired("id", id),
                checkRequired("createdAt", createdAt),
                checkRequired("metadata", metadata),
                object_,
                checkRequired("toolResources", toolResources),
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Thread = apply {
        if (validated) {
            return@apply
        }

        id()
        createdAt()
        metadata().ifPresent { it.validate() }
        _object_().let {
            if (it != JsonValue.from("thread")) {
                throw OpenAIInvalidDataException("'object_' is invalid, received $it")
            }
        }
        toolResources().ifPresent { it.validate() }
        validated = true
    }

    /**
     * Set of 16 key-value pairs that can be attached to an object. This can be useful for storing
     * additional information about the object in a structured format, and querying for objects via
     * API or the dashboard.
     *
     * Keys are strings with a maximum length of 64 characters. Values are strings with a maximum
     * length of 512 characters.
     */
    class Metadata
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

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Metadata && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    /**
     * A set of resources that are made available to the assistant's tools in this thread. The
     * resources are specific to the type of tool. For example, the `code_interpreter` tool requires
     * a list of file IDs, while the `file_search` tool requires a list of vector store IDs.
     */
    class ToolResources
    private constructor(
        private val codeInterpreter: JsonField<CodeInterpreter>,
        private val fileSearch: JsonField<FileSearch>,
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
        ) : this(codeInterpreter, fileSearch, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun codeInterpreter(): Optional<CodeInterpreter> =
            Optional.ofNullable(codeInterpreter.getNullable("code_interpreter"))

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun fileSearch(): Optional<FileSearch> =
            Optional.ofNullable(fileSearch.getNullable("file_search"))

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

            /** Returns a mutable builder for constructing an instance of [ToolResources]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [ToolResources]. */
        class Builder internal constructor() {

            private var codeInterpreter: JsonField<CodeInterpreter> = JsonMissing.of()
            private var fileSearch: JsonField<FileSearch> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(toolResources: ToolResources) = apply {
                codeInterpreter = toolResources.codeInterpreter
                fileSearch = toolResources.fileSearch
                additionalProperties = toolResources.additionalProperties.toMutableMap()
            }

            fun codeInterpreter(codeInterpreter: CodeInterpreter) =
                codeInterpreter(JsonField.of(codeInterpreter))

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

            fun fileSearch(fileSearch: FileSearch) = fileSearch(JsonField.of(fileSearch))

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
             * Returns an immutable instance of [ToolResources].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): ToolResources =
                ToolResources(codeInterpreter, fileSearch, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): ToolResources = apply {
            if (validated) {
                return@apply
            }

            codeInterpreter().ifPresent { it.validate() }
            fileSearch().ifPresent { it.validate() }
            validated = true
        }

        class CodeInterpreter
        private constructor(
            private val fileIds: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("file_ids")
                @ExcludeMissing
                fileIds: JsonField<List<String>> = JsonMissing.of()
            ) : this(fileIds, mutableMapOf())

            /**
             * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
             * available to the `code_interpreter` tool. There can be a maximum of 20 files
             * associated with the tool.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun fileIds(): Optional<List<String>> =
                Optional.ofNullable(fileIds.getNullable("file_ids"))

            /**
             * Returns the raw JSON value of [fileIds].
             *
             * Unlike [fileIds], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("file_ids")
            @ExcludeMissing
            fun _fileIds(): JsonField<List<String>> = fileIds

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

                /** Returns a mutable builder for constructing an instance of [CodeInterpreter]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [CodeInterpreter]. */
            class Builder internal constructor() {

                private var fileIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(codeInterpreter: CodeInterpreter) = apply {
                    fileIds = codeInterpreter.fileIds.map { it.toMutableList() }
                    additionalProperties = codeInterpreter.additionalProperties.toMutableMap()
                }

                /**
                 * A list of [file](https://platform.openai.com/docs/api-reference/files) IDs made
                 * available to the `code_interpreter` tool. There can be a maximum of 20 files
                 * associated with the tool.
                 */
                fun fileIds(fileIds: List<String>) = fileIds(JsonField.of(fileIds))

                /**
                 * Sets [Builder.fileIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.fileIds] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
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
                 * Returns an immutable instance of [CodeInterpreter].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): CodeInterpreter =
                    CodeInterpreter(
                        (fileIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): CodeInterpreter = apply {
                if (validated) {
                    return@apply
                }

                fileIds()
                validated = true
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

        class FileSearch
        private constructor(
            private val vectorStoreIds: JsonField<List<String>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("vector_store_ids")
                @ExcludeMissing
                vectorStoreIds: JsonField<List<String>> = JsonMissing.of()
            ) : this(vectorStoreIds, mutableMapOf())

            /**
             * The
             * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
             * attached to this thread. There can be a maximum of 1 vector store attached to the
             * thread.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun vectorStoreIds(): Optional<List<String>> =
                Optional.ofNullable(vectorStoreIds.getNullable("vector_store_ids"))

            /**
             * Returns the raw JSON value of [vectorStoreIds].
             *
             * Unlike [vectorStoreIds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("vector_store_ids")
            @ExcludeMissing
            fun _vectorStoreIds(): JsonField<List<String>> = vectorStoreIds

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

                /** Returns a mutable builder for constructing an instance of [FileSearch]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [FileSearch]. */
            class Builder internal constructor() {

                private var vectorStoreIds: JsonField<MutableList<String>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(fileSearch: FileSearch) = apply {
                    vectorStoreIds = fileSearch.vectorStoreIds.map { it.toMutableList() }
                    additionalProperties = fileSearch.additionalProperties.toMutableMap()
                }

                /**
                 * The
                 * [vector store](https://platform.openai.com/docs/api-reference/vector-stores/object)
                 * attached to this thread. There can be a maximum of 1 vector store attached to the
                 * thread.
                 */
                fun vectorStoreIds(vectorStoreIds: List<String>) =
                    vectorStoreIds(JsonField.of(vectorStoreIds))

                /**
                 * Sets [Builder.vectorStoreIds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.vectorStoreIds] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun vectorStoreIds(vectorStoreIds: JsonField<List<String>>) = apply {
                    this.vectorStoreIds = vectorStoreIds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [vectorStoreIds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addVectorStoreId(vectorStoreId: String) = apply {
                    vectorStoreIds =
                        (vectorStoreIds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("vectorStoreIds", it).add(vectorStoreId)
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
                 * Returns an immutable instance of [FileSearch].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): FileSearch =
                    FileSearch(
                        (vectorStoreIds ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): FileSearch = apply {
                if (validated) {
                    return@apply
                }

                vectorStoreIds()
                validated = true
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

        return /* spotless:off */ other is Thread && id == other.id && createdAt == other.createdAt && metadata == other.metadata && object_ == other.object_ && toolResources == other.toolResources && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, createdAt, metadata, object_, toolResources, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Thread{id=$id, createdAt=$createdAt, metadata=$metadata, object_=$object_, toolResources=$toolResources, additionalProperties=$additionalProperties}"
}
