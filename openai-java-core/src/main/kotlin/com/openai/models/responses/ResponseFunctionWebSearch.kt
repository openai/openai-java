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
import com.openai.core.checkRequired
import com.openai.core.getOrThrow
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * The results of a web search tool call. See the
 * [web search guide](https://platform.openai.com/docs/guides/tools-web-search) for more
 * information.
 */
class ResponseFunctionWebSearch
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val id: JsonField<String>,
    private val action: JsonField<Action>,
    private val status: JsonField<Status>,
    private val type: JsonValue,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("action") @ExcludeMissing action: JsonField<Action> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<Status> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
    ) : this(id, action, status, type, mutableMapOf())

    /**
     * The unique ID of the web search tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun id(): String = id.getRequired("id")

    /**
     * An object describing the specific action taken in this web search call. Includes details on
     * how the model used the web (search, open_page, find).
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun action(): Action = action.getRequired("action")

    /**
     * The status of the web search tool call.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun status(): Status = status.getRequired("status")

    /**
     * The type of the web search tool call. Always `web_search_call`.
     *
     * Expected to always return the following:
     * ```java
     * JsonValue.from("web_search_call")
     * ```
     *
     * However, this method can be useful for debugging and logging (e.g. if the server responded
     * with an unexpected value).
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [action].
     *
     * Unlike [action], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("action") @ExcludeMissing fun _action(): JsonField<Action> = action

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<Status> = status

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
         * Returns a mutable builder for constructing an instance of [ResponseFunctionWebSearch].
         *
         * The following fields are required:
         * ```java
         * .id()
         * .action()
         * .status()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ResponseFunctionWebSearch]. */
    class Builder internal constructor() {

        private var id: JsonField<String>? = null
        private var action: JsonField<Action>? = null
        private var status: JsonField<Status>? = null
        private var type: JsonValue = JsonValue.from("web_search_call")
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(responseFunctionWebSearch: ResponseFunctionWebSearch) = apply {
            id = responseFunctionWebSearch.id
            action = responseFunctionWebSearch.action
            status = responseFunctionWebSearch.status
            type = responseFunctionWebSearch.type
            additionalProperties = responseFunctionWebSearch.additionalProperties.toMutableMap()
        }

        /** The unique ID of the web search tool call. */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /**
         * An object describing the specific action taken in this web search call. Includes details
         * on how the model used the web (search, open_page, find).
         */
        fun action(action: Action) = action(JsonField.of(action))

        /**
         * Sets [Builder.action] to an arbitrary JSON value.
         *
         * You should usually call [Builder.action] with a well-typed [Action] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun action(action: JsonField<Action>) = apply { this.action = action }

        /** Alias for calling [action] with `Action.ofSearch(search)`. */
        fun action(search: Action.Search) = action(Action.ofSearch(search))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * Action.Search.builder()
         *     .query(query)
         *     .build()
         * ```
         */
        fun searchAction(query: String) = action(Action.Search.builder().query(query).build())

        /** Alias for calling [action] with `Action.ofOpenPage(openPage)`. */
        fun action(openPage: Action.OpenPage) = action(Action.ofOpenPage(openPage))

        /**
         * Alias for calling [action] with the following:
         * ```java
         * Action.OpenPage.builder()
         *     .url(url)
         *     .build()
         * ```
         */
        fun openPageAction(url: String) = action(Action.OpenPage.builder().url(url).build())

        /** Alias for calling [action] with `Action.ofFind(find)`. */
        fun action(find: Action.Find) = action(Action.ofFind(find))

        /** The status of the web search tool call. */
        fun status(status: Status) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [Status] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<Status>) = apply { this.status = status }

        /**
         * Sets the field to an arbitrary JSON value.
         *
         * It is usually unnecessary to call this method because the field defaults to the
         * following:
         * ```java
         * JsonValue.from("web_search_call")
         * ```
         *
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
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
         * Returns an immutable instance of [ResponseFunctionWebSearch].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .id()
         * .action()
         * .status()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): ResponseFunctionWebSearch =
            ResponseFunctionWebSearch(
                checkRequired("id", id),
                checkRequired("action", action),
                checkRequired("status", status),
                type,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): ResponseFunctionWebSearch = apply {
        if (validated) {
            return@apply
        }

        id()
        action().validate()
        status().validate()
        _type().let {
            if (it != JsonValue.from("web_search_call")) {
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (action.asKnown().getOrNull()?.validity() ?: 0) +
            (status.asKnown().getOrNull()?.validity() ?: 0) +
            type.let { if (it == JsonValue.from("web_search_call")) 1 else 0 }

    /**
     * An object describing the specific action taken in this web search call. Includes details on
     * how the model used the web (search, open_page, find).
     */
    @JsonDeserialize(using = Action.Deserializer::class)
    @JsonSerialize(using = Action.Serializer::class)
    class Action
    private constructor(
        private val search: Search? = null,
        private val openPage: OpenPage? = null,
        private val find: Find? = null,
        private val _json: JsonValue? = null,
    ) {

        /** Action type "search" - Performs a web search query. */
        fun search(): Optional<Search> = Optional.ofNullable(search)

        /** Action type "open_page" - Opens a specific URL from search results. */
        fun openPage(): Optional<OpenPage> = Optional.ofNullable(openPage)

        /** Action type "find": Searches for a pattern within a loaded page. */
        fun find(): Optional<Find> = Optional.ofNullable(find)

        fun isSearch(): Boolean = search != null

        fun isOpenPage(): Boolean = openPage != null

        fun isFind(): Boolean = find != null

        /** Action type "search" - Performs a web search query. */
        fun asSearch(): Search = search.getOrThrow("search")

        /** Action type "open_page" - Opens a specific URL from search results. */
        fun asOpenPage(): OpenPage = openPage.getOrThrow("openPage")

        /** Action type "find": Searches for a pattern within a loaded page. */
        fun asFind(): Find = find.getOrThrow("find")

        fun _json(): Optional<JsonValue> = Optional.ofNullable(_json)

        fun <T> accept(visitor: Visitor<T>): T =
            when {
                search != null -> visitor.visitSearch(search)
                openPage != null -> visitor.visitOpenPage(openPage)
                find != null -> visitor.visitFind(find)
                else -> visitor.unknown(_json)
            }

        private var validated: Boolean = false

        fun validate(): Action = apply {
            if (validated) {
                return@apply
            }

            accept(
                object : Visitor<Unit> {
                    override fun visitSearch(search: Search) {
                        search.validate()
                    }

                    override fun visitOpenPage(openPage: OpenPage) {
                        openPage.validate()
                    }

                    override fun visitFind(find: Find) {
                        find.validate()
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
                    override fun visitSearch(search: Search) = search.validity()

                    override fun visitOpenPage(openPage: OpenPage) = openPage.validity()

                    override fun visitFind(find: Find) = find.validity()

                    override fun unknown(json: JsonValue?) = 0
                }
            )

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Action &&
                search == other.search &&
                openPage == other.openPage &&
                find == other.find
        }

        override fun hashCode(): Int = Objects.hash(search, openPage, find)

        override fun toString(): String =
            when {
                search != null -> "Action{search=$search}"
                openPage != null -> "Action{openPage=$openPage}"
                find != null -> "Action{find=$find}"
                _json != null -> "Action{_unknown=$_json}"
                else -> throw IllegalStateException("Invalid Action")
            }

        companion object {

            /** Action type "search" - Performs a web search query. */
            @JvmStatic fun ofSearch(search: Search) = Action(search = search)

            /** Action type "open_page" - Opens a specific URL from search results. */
            @JvmStatic fun ofOpenPage(openPage: OpenPage) = Action(openPage = openPage)

            /** Action type "find": Searches for a pattern within a loaded page. */
            @JvmStatic fun ofFind(find: Find) = Action(find = find)
        }

        /** An interface that defines how to map each variant of [Action] to a value of type [T]. */
        interface Visitor<out T> {

            /** Action type "search" - Performs a web search query. */
            fun visitSearch(search: Search): T

            /** Action type "open_page" - Opens a specific URL from search results. */
            fun visitOpenPage(openPage: OpenPage): T

            /** Action type "find": Searches for a pattern within a loaded page. */
            fun visitFind(find: Find): T

            /**
             * Maps an unknown variant of [Action] to a value of type [T].
             *
             * An instance of [Action] can contain an unknown variant if it was deserialized from
             * data that doesn't match any known variant. For example, if the SDK is on an older
             * version than the API, then the API may respond with new variants that the SDK is
             * unaware of.
             *
             * @throws OpenAIInvalidDataException in the default implementation.
             */
            fun unknown(json: JsonValue?): T {
                throw OpenAIInvalidDataException("Unknown Action: $json")
            }
        }

        internal class Deserializer : BaseDeserializer<Action>(Action::class) {

            override fun ObjectCodec.deserialize(node: JsonNode): Action {
                val json = JsonValue.fromJsonNode(node)
                val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

                when (type) {
                    "search" -> {
                        return tryDeserialize(node, jacksonTypeRef<Search>())?.let {
                            Action(search = it, _json = json)
                        } ?: Action(_json = json)
                    }
                    "open_page" -> {
                        return tryDeserialize(node, jacksonTypeRef<OpenPage>())?.let {
                            Action(openPage = it, _json = json)
                        } ?: Action(_json = json)
                    }
                    "find" -> {
                        return tryDeserialize(node, jacksonTypeRef<Find>())?.let {
                            Action(find = it, _json = json)
                        } ?: Action(_json = json)
                    }
                }

                return Action(_json = json)
            }
        }

        internal class Serializer : BaseSerializer<Action>(Action::class) {

            override fun serialize(
                value: Action,
                generator: JsonGenerator,
                provider: SerializerProvider,
            ) {
                when {
                    value.search != null -> generator.writeObject(value.search)
                    value.openPage != null -> generator.writeObject(value.openPage)
                    value.find != null -> generator.writeObject(value.find)
                    value._json != null -> generator.writeObject(value._json)
                    else -> throw IllegalStateException("Invalid Action")
                }
            }
        }

        /** Action type "search" - Performs a web search query. */
        class Search
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val query: JsonField<String>,
            private val type: JsonValue,
            private val queries: JsonField<List<String>>,
            private val sources: JsonField<List<Source>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("queries")
                @ExcludeMissing
                queries: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("sources")
                @ExcludeMissing
                sources: JsonField<List<Source>> = JsonMissing.of(),
            ) : this(query, type, queries, sources, mutableMapOf())

            /**
             * [DEPRECATED] The search query.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun query(): String = query.getRequired("query")

            /**
             * The action type.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("search")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The search queries.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun queries(): Optional<List<String>> = queries.getOptional("queries")

            /**
             * The sources used in the search.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if
             *   the server responded with an unexpected value).
             */
            fun sources(): Optional<List<Source>> = sources.getOptional("sources")

            /**
             * Returns the raw JSON value of [query].
             *
             * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

            /**
             * Returns the raw JSON value of [queries].
             *
             * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("queries")
            @ExcludeMissing
            fun _queries(): JsonField<List<String>> = queries

            /**
             * Returns the raw JSON value of [sources].
             *
             * Unlike [sources], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sources")
            @ExcludeMissing
            fun _sources(): JsonField<List<Source>> = sources

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
                 * Returns a mutable builder for constructing an instance of [Search].
                 *
                 * The following fields are required:
                 * ```java
                 * .query()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Search]. */
            class Builder internal constructor() {

                private var query: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("search")
                private var queries: JsonField<MutableList<String>>? = null
                private var sources: JsonField<MutableList<Source>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(search: Search) = apply {
                    query = search.query
                    type = search.type
                    queries = search.queries.map { it.toMutableList() }
                    sources = search.sources.map { it.toMutableList() }
                    additionalProperties = search.additionalProperties.toMutableMap()
                }

                /** [DEPRECATED] The search query. */
                fun query(query: String) = query(JsonField.of(query))

                /**
                 * Sets [Builder.query] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.query] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun query(query: JsonField<String>) = apply { this.query = query }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("search")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The search queries. */
                fun queries(queries: List<String>) = queries(JsonField.of(queries))

                /**
                 * Sets [Builder.queries] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.queries] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun queries(queries: JsonField<List<String>>) = apply {
                    this.queries = queries.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [queries].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addQuery(query: String) = apply {
                    queries =
                        (queries ?: JsonField.of(mutableListOf())).also {
                            checkKnown("queries", it).add(query)
                        }
                }

                /** The sources used in the search. */
                fun sources(sources: List<Source>) = sources(JsonField.of(sources))

                /**
                 * Sets [Builder.sources] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sources] with a well-typed `List<Source>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sources(sources: JsonField<List<Source>>) = apply {
                    this.sources = sources.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Source] to [sources].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addSource(source: Source) = apply {
                    sources =
                        (sources ?: JsonField.of(mutableListOf())).also {
                            checkKnown("sources", it).add(source)
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
                 * Returns an immutable instance of [Search].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .query()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Search =
                    Search(
                        checkRequired("query", query),
                        type,
                        (queries ?: JsonMissing.of()).map { it.toImmutable() },
                        (sources ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Search = apply {
                if (validated) {
                    return@apply
                }

                query()
                _type().let {
                    if (it != JsonValue.from("search")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                queries()
                sources().ifPresent { it.forEach { it.validate() } }
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
                (if (query.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("search")) 1 else 0 } +
                    (queries.asKnown().getOrNull()?.size ?: 0) +
                    (sources.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

            /** A source used in the search. */
            class Source
            @JsonCreator(mode = JsonCreator.Mode.DISABLED)
            private constructor(
                private val type: JsonValue,
                private val url: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                    @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
                ) : this(type, url, mutableMapOf())

                /**
                 * The type of source. Always `url`.
                 *
                 * Expected to always return the following:
                 * ```java
                 * JsonValue.from("url")
                 * ```
                 *
                 * However, this method can be useful for debugging and logging (e.g. if the server
                 * responded with an unexpected value).
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

                /**
                 * The URL of the source.
                 *
                 * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
                 *   unexpectedly missing or null (e.g. if the server responded with an unexpected
                 *   value).
                 */
                fun url(): String = url.getRequired("url")

                /**
                 * Returns the raw JSON value of [url].
                 *
                 * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
                 */
                @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                     * Returns a mutable builder for constructing an instance of [Source].
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Source]. */
                class Builder internal constructor() {

                    private var type: JsonValue = JsonValue.from("url")
                    private var url: JsonField<String>? = null
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(source: Source) = apply {
                        type = source.type
                        url = source.url
                        additionalProperties = source.additionalProperties.toMutableMap()
                    }

                    /**
                     * Sets the field to an arbitrary JSON value.
                     *
                     * It is usually unnecessary to call this method because the field defaults to
                     * the following:
                     * ```java
                     * JsonValue.from("url")
                     * ```
                     *
                     * This method is primarily for setting the field to an undocumented or not yet
                     * supported value.
                     */
                    fun type(type: JsonValue) = apply { this.type = type }

                    /** The URL of the source. */
                    fun url(url: String) = url(JsonField.of(url))

                    /**
                     * Sets [Builder.url] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.url] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun url(url: JsonField<String>) = apply { this.url = url }

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
                     * Returns an immutable instance of [Source].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     *
                     * The following fields are required:
                     * ```java
                     * .url()
                     * ```
                     *
                     * @throws IllegalStateException if any required field is unset.
                     */
                    fun build(): Source =
                        Source(type, checkRequired("url", url), additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Source = apply {
                    if (validated) {
                        return@apply
                    }

                    _type().let {
                        if (it != JsonValue.from("url")) {
                            throw OpenAIInvalidDataException("'type' is invalid, received $it")
                        }
                    }
                    url()
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
                    type.let { if (it == JsonValue.from("url")) 1 else 0 } +
                        (if (url.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Source &&
                        type == other.type &&
                        url == other.url &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy { Objects.hash(type, url, additionalProperties) }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Source{type=$type, url=$url, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Search &&
                    query == other.query &&
                    type == other.type &&
                    queries == other.queries &&
                    sources == other.sources &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(query, type, queries, sources, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Search{query=$query, type=$type, queries=$queries, sources=$sources, additionalProperties=$additionalProperties}"
        }

        /** Action type "open_page" - Opens a specific URL from search results. */
        class OpenPage
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val type: JsonValue,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(type, url, mutableMapOf())

            /**
             * The action type.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("open_page")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The URL opened by the model.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [OpenPage].
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [OpenPage]. */
            class Builder internal constructor() {

                private var type: JsonValue = JsonValue.from("open_page")
                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(openPage: OpenPage) = apply {
                    type = openPage.type
                    url = openPage.url
                    additionalProperties = openPage.additionalProperties.toMutableMap()
                }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("open_page")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The URL opened by the model. */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [OpenPage].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): OpenPage =
                    OpenPage(type, checkRequired("url", url), additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): OpenPage = apply {
                if (validated) {
                    return@apply
                }

                _type().let {
                    if (it != JsonValue.from("open_page")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                url()
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
                type.let { if (it == JsonValue.from("open_page")) 1 else 0 } +
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is OpenPage &&
                    type == other.type &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(type, url, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "OpenPage{type=$type, url=$url, additionalProperties=$additionalProperties}"
        }

        /** Action type "find": Searches for a pattern within a loaded page. */
        class Find
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val pattern: JsonField<String>,
            private val type: JsonValue,
            private val url: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("pattern")
                @ExcludeMissing
                pattern: JsonField<String> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
                @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
            ) : this(pattern, type, url, mutableMapOf())

            /**
             * The pattern or text to search for within the page.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun pattern(): String = pattern.getRequired("pattern")

            /**
             * The action type.
             *
             * Expected to always return the following:
             * ```java
             * JsonValue.from("find")
             * ```
             *
             * However, this method can be useful for debugging and logging (e.g. if the server
             * responded with an unexpected value).
             */
            @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

            /**
             * The URL of the page searched for the pattern.
             *
             * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
             *   unexpectedly missing or null (e.g. if the server responded with an unexpected
             *   value).
             */
            fun url(): String = url.getRequired("url")

            /**
             * Returns the raw JSON value of [pattern].
             *
             * Unlike [pattern], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("pattern") @ExcludeMissing fun _pattern(): JsonField<String> = pattern

            /**
             * Returns the raw JSON value of [url].
             *
             * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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
                 * Returns a mutable builder for constructing an instance of [Find].
                 *
                 * The following fields are required:
                 * ```java
                 * .pattern()
                 * .url()
                 * ```
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Find]. */
            class Builder internal constructor() {

                private var pattern: JsonField<String>? = null
                private var type: JsonValue = JsonValue.from("find")
                private var url: JsonField<String>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(find: Find) = apply {
                    pattern = find.pattern
                    type = find.type
                    url = find.url
                    additionalProperties = find.additionalProperties.toMutableMap()
                }

                /** The pattern or text to search for within the page. */
                fun pattern(pattern: String) = pattern(JsonField.of(pattern))

                /**
                 * Sets [Builder.pattern] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pattern] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pattern(pattern: JsonField<String>) = apply { this.pattern = pattern }

                /**
                 * Sets the field to an arbitrary JSON value.
                 *
                 * It is usually unnecessary to call this method because the field defaults to the
                 * following:
                 * ```java
                 * JsonValue.from("find")
                 * ```
                 *
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonValue) = apply { this.type = type }

                /** The URL of the page searched for the pattern. */
                fun url(url: String) = url(JsonField.of(url))

                /**
                 * Sets [Builder.url] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.url] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun url(url: JsonField<String>) = apply { this.url = url }

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
                 * Returns an immutable instance of [Find].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 *
                 * The following fields are required:
                 * ```java
                 * .pattern()
                 * .url()
                 * ```
                 *
                 * @throws IllegalStateException if any required field is unset.
                 */
                fun build(): Find =
                    Find(
                        checkRequired("pattern", pattern),
                        type,
                        checkRequired("url", url),
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Find = apply {
                if (validated) {
                    return@apply
                }

                pattern()
                _type().let {
                    if (it != JsonValue.from("find")) {
                        throw OpenAIInvalidDataException("'type' is invalid, received $it")
                    }
                }
                url()
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
                (if (pattern.asKnown().isPresent) 1 else 0) +
                    type.let { if (it == JsonValue.from("find")) 1 else 0 } +
                    (if (url.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Find &&
                    pattern == other.pattern &&
                    type == other.type &&
                    url == other.url &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(pattern, type, url, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Find{pattern=$pattern, type=$type, url=$url, additionalProperties=$additionalProperties}"
        }
    }

    /** The status of the web search tool call. */
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

            @JvmField val IN_PROGRESS = of("in_progress")

            @JvmField val SEARCHING = of("searching")

            @JvmField val COMPLETED = of("completed")

            @JvmField val FAILED = of("failed")

            @JvmStatic fun of(value: String) = Status(JsonField.of(value))
        }

        /** An enum containing [Status]'s known values. */
        enum class Known {
            IN_PROGRESS,
            SEARCHING,
            COMPLETED,
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
            IN_PROGRESS,
            SEARCHING,
            COMPLETED,
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
                IN_PROGRESS -> Value.IN_PROGRESS
                SEARCHING -> Value.SEARCHING
                COMPLETED -> Value.COMPLETED
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
                IN_PROGRESS -> Known.IN_PROGRESS
                SEARCHING -> Known.SEARCHING
                COMPLETED -> Known.COMPLETED
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ResponseFunctionWebSearch &&
            id == other.id &&
            action == other.action &&
            status == other.status &&
            type == other.type &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(id, action, status, type, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ResponseFunctionWebSearch{id=$id, action=$action, status=$status, type=$type, additionalProperties=$additionalProperties}"
}
