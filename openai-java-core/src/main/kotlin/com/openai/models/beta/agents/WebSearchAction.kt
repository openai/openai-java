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

/** An action performed by the web search tool. */
@JsonDeserialize(using = WebSearchAction.Deserializer::class)
@JsonSerialize(using = WebSearchAction.Serializer::class)
class WebSearchAction
private constructor(
    private val search: Search? = null,
    private val openPage: OpenPage? = null,
    private val findInPage: FindInPage? = null,
    private val other: JsonValue? = null,
    private val _json: JsonValue? = null,
) {

    /** A search query or group of search queries. */
    fun search(): Optional<Search> = Optional.ofNullable(search)

    /** Opens a web page. */
    fun openPage(): Optional<OpenPage> = Optional.ofNullable(openPage)

    /** Finds text within a web page. */
    fun findInPage(): Optional<FindInPage> = Optional.ofNullable(findInPage)

    /** Another web search action. */
    fun other(): Optional<JsonValue> = Optional.ofNullable(other)

    fun isSearch(): Boolean = search != null

    fun isOpenPage(): Boolean = openPage != null

    fun isFindInPage(): Boolean = findInPage != null

    fun isOther(): Boolean = other != null

    /** A search query or group of search queries. */
    fun asSearch(): Search = search.getOrThrow("search")

    /** Opens a web page. */
    fun asOpenPage(): OpenPage = openPage.getOrThrow("openPage")

    /** Finds text within a web page. */
    fun asFindInPage(): FindInPage = findInPage.getOrThrow("findInPage")

    /** Another web search action. */
    fun asOther(): JsonValue = other.getOrThrow("other")

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
     * Optional<String> result = webSearchAction.accept(new WebSearchAction.Visitor<Optional<String>>() {
     *     @Override
     *     public Optional<String> visitSearch(Search search) {
     *         return Optional.of(search.toString());
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
            search != null -> visitor.visitSearch(search)
            openPage != null -> visitor.visitOpenPage(openPage)
            findInPage != null -> visitor.visitFindInPage(findInPage)
            other != null -> visitor.visitOther(other)
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
    fun validate(): WebSearchAction = apply {
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

                override fun visitFindInPage(findInPage: FindInPage) {
                    findInPage.validate()
                }

                override fun visitOther(other: JsonValue) {
                    other.let {
                        if (it != JsonValue.from(mapOf("type" to "other"))) {
                            throw OpenAIInvalidDataException("'other' is invalid, received $it")
                        }
                    }
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
                override fun visitSearch(search: Search) = search.validity()

                override fun visitOpenPage(openPage: OpenPage) = openPage.validity()

                override fun visitFindInPage(findInPage: FindInPage) = findInPage.validity()

                override fun visitOther(other: JsonValue) =
                    other.let { if (it == JsonValue.from(mapOf("type" to "other"))) 1 else 0 }

                override fun unknown(json: JsonValue?) = 0
            }
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebSearchAction &&
            search == other.search &&
            openPage == other.openPage &&
            findInPage == other.findInPage &&
            this.other == other.other
    }

    override fun hashCode(): Int = Objects.hash(search, openPage, findInPage, other)

    override fun toString(): String =
        when {
            search != null -> "WebSearchAction{search=$search}"
            openPage != null -> "WebSearchAction{openPage=$openPage}"
            findInPage != null -> "WebSearchAction{findInPage=$findInPage}"
            other != null -> "WebSearchAction{other=$other}"
            _json != null -> "WebSearchAction{_unknown=$_json}"
            else -> throw IllegalStateException("Invalid WebSearchAction")
        }

    companion object {

        /** A search query or group of search queries. */
        @JvmStatic fun ofSearch(search: Search) = WebSearchAction(search = search)

        /** Opens a web page. */
        @JvmStatic fun ofOpenPage(openPage: OpenPage) = WebSearchAction(openPage = openPage)

        /** Finds text within a web page. */
        @JvmStatic
        fun ofFindInPage(findInPage: FindInPage) = WebSearchAction(findInPage = findInPage)

        /** Another web search action. */
        @JvmStatic fun ofOther() = WebSearchAction(other = JsonValue.from(mapOf("type" to "other")))
    }

    /**
     * An interface that defines how to map each variant of [WebSearchAction] to a value of type
     * [T].
     */
    interface Visitor<out T> {

        /** A search query or group of search queries. */
        fun visitSearch(search: Search): T

        /** Opens a web page. */
        fun visitOpenPage(openPage: OpenPage): T

        /** Finds text within a web page. */
        fun visitFindInPage(findInPage: FindInPage): T

        /** Another web search action. */
        fun visitOther(other: JsonValue): T

        /**
         * Maps an unknown variant of [WebSearchAction] to a value of type [T].
         *
         * An instance of [WebSearchAction] can contain an unknown variant if it was deserialized
         * from data that doesn't match any known variant. For example, if the SDK is on an older
         * version than the API, then the API may respond with new variants that the SDK is unaware
         * of.
         *
         * @throws OpenAIInvalidDataException in the default implementation.
         */
        fun unknown(json: JsonValue?): T {
            throw OpenAIInvalidDataException("Unknown WebSearchAction: $json")
        }
    }

    internal class Deserializer : BaseDeserializer<WebSearchAction>(WebSearchAction::class) {

        override fun ObjectCodec.deserialize(node: JsonNode): WebSearchAction {
            val json = JsonValue.fromJsonNode(node)
            val type = json.asObject().getOrNull()?.get("type")?.asString()?.getOrNull()

            when (type) {
                "search" -> {
                    return tryDeserialize(node, jacksonTypeRef<Search>())?.let {
                        WebSearchAction(search = it, _json = json)
                    } ?: WebSearchAction(_json = json)
                }
                "open_page" -> {
                    return tryDeserialize(node, jacksonTypeRef<OpenPage>())?.let {
                        WebSearchAction(openPage = it, _json = json)
                    } ?: WebSearchAction(_json = json)
                }
                "find_in_page" -> {
                    return tryDeserialize(node, jacksonTypeRef<FindInPage>())?.let {
                        WebSearchAction(findInPage = it, _json = json)
                    } ?: WebSearchAction(_json = json)
                }
                "other" -> {
                    return tryDeserialize(node, jacksonTypeRef<JsonValue>())
                        ?.let { WebSearchAction(other = it, _json = json) }
                        ?.takeIf { it.isValid() } ?: WebSearchAction(_json = json)
                }
            }

            return WebSearchAction(_json = json)
        }
    }

    internal class Serializer : BaseSerializer<WebSearchAction>(WebSearchAction::class) {

        override fun serialize(
            value: WebSearchAction,
            generator: JsonGenerator,
            provider: SerializerProvider,
        ) {
            when {
                value.search != null -> generator.writeObject(value.search)
                value.openPage != null -> generator.writeObject(value.openPage)
                value.findInPage != null -> generator.writeObject(value.findInPage)
                value.other != null -> generator.writeObject(value.other)
                value._json != null -> generator.writeObject(value._json)
                else -> throw IllegalStateException("Invalid WebSearchAction")
            }
        }
    }

    /** A search query or group of search queries. */
    class Search
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val queries: JsonField<List<String>>,
        private val query: JsonField<String>,
        private val type: JsonValue,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("queries")
            @ExcludeMissing
            queries: JsonField<List<String>> = JsonMissing.of(),
            @JsonProperty("query") @ExcludeMissing query: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
        ) : this(queries, query, type, mutableMapOf())

        /**
         * The search queries, when multiple queries were used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun queries(): Optional<List<String>> = queries.getOptional("queries")

        /**
         * The search query, when a single query was used.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun query(): Optional<String> = query.getOptional("query")

        /**
         * The type of the object. Always `search`.
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
         * Returns the raw JSON value of [queries].
         *
         * Unlike [queries], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("queries") @ExcludeMissing fun _queries(): JsonField<List<String>> = queries

        /**
         * Returns the raw JSON value of [query].
         *
         * Unlike [query], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("query") @ExcludeMissing fun _query(): JsonField<String> = query

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
             * .queries()
             * .query()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Search]. */
        class Builder internal constructor() {

            private var queries: JsonField<MutableList<String>>? = null
            private var query: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("search")
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(search: Search) = apply {
                queries = search.queries.map { it.toMutableList() }
                query = search.query
                type = search.type
                additionalProperties = search.additionalProperties.toMutableMap()
            }

            /** The search queries, when multiple queries were used. */
            fun queries(queries: List<String>?) = queries(JsonField.ofNullable(queries))

            /** Alias for calling [Builder.queries] with `queries.orElse(null)`. */
            fun queries(queries: Optional<List<String>>) = queries(queries.getOrNull())

            /**
             * Sets [Builder.queries] to an arbitrary JSON value.
             *
             * You should usually call [Builder.queries] with a well-typed `List<String>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
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

            /** The search query, when a single query was used. */
            fun query(query: String?) = query(JsonField.ofNullable(query))

            /** Alias for calling [Builder.query] with `query.orElse(null)`. */
            fun query(query: Optional<String>) = query(query.getOrNull())

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
             * Returns an immutable instance of [Search].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .queries()
             * .query()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Search =
                Search(
                    checkRequired("queries", queries).map { it.toImmutable() },
                    checkRequired("query", query),
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
        fun validate(): Search = apply {
            if (validated) {
                return@apply
            }

            queries()
            query()
            _type().let {
                if (it != JsonValue.from("search")) {
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
            (queries.asKnown().getOrNull()?.size ?: 0) +
                (if (query.asKnown().isPresent) 1 else 0) +
                type.let { if (it == JsonValue.from("search")) 1 else 0 }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Search &&
                queries == other.queries &&
                query == other.query &&
                type == other.type &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(queries, query, type, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Search{queries=$queries, query=$query, type=$type, additionalProperties=$additionalProperties}"
    }

    /** Opens a web page. */
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
         * The type of the object. Always `open_page`.
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
         * The URL of the page that was opened.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

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

            /** The URL of the page that was opened. */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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

        /**
         * Validates that the types of all values in this object match their expected types
         * recursively.
         *
         * This method is _not_ forwards compatible with new types from the API for existing fields.
         *
         * @throws OpenAIInvalidDataException if any value type in this object doesn't match its
         *   expected type.
         */
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

    /** Finds text within a web page. */
    class FindInPage
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val pattern: JsonField<String>,
        private val type: JsonValue,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("pattern") @ExcludeMissing pattern: JsonField<String> = JsonMissing.of(),
            @JsonProperty("type") @ExcludeMissing type: JsonValue = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(pattern, type, url, mutableMapOf())

        /**
         * The text pattern that was searched for.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun pattern(): Optional<String> = pattern.getOptional("pattern")

        /**
         * The type of the object. Always `find_in_page`.
         *
         * Expected to always return the following:
         * ```java
         * JsonValue.from("find_in_page")
         * ```
         *
         * However, this method can be useful for debugging and logging (e.g. if the server
         * responded with an unexpected value).
         */
        @JsonProperty("type") @ExcludeMissing fun _type(): JsonValue = type

        /**
         * The URL of the page that was searched.
         *
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type (e.g. if the
         *   server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

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
             * Returns a mutable builder for constructing an instance of [FindInPage].
             *
             * The following fields are required:
             * ```java
             * .pattern()
             * .url()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [FindInPage]. */
        class Builder internal constructor() {

            private var pattern: JsonField<String>? = null
            private var type: JsonValue = JsonValue.from("find_in_page")
            private var url: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(findInPage: FindInPage) = apply {
                pattern = findInPage.pattern
                type = findInPage.type
                url = findInPage.url
                additionalProperties = findInPage.additionalProperties.toMutableMap()
            }

            /** The text pattern that was searched for. */
            fun pattern(pattern: String?) = pattern(JsonField.ofNullable(pattern))

            /** Alias for calling [Builder.pattern] with `pattern.orElse(null)`. */
            fun pattern(pattern: Optional<String>) = pattern(pattern.getOrNull())

            /**
             * Sets [Builder.pattern] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pattern] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pattern(pattern: JsonField<String>) = apply { this.pattern = pattern }

            /**
             * Sets the field to an arbitrary JSON value.
             *
             * It is usually unnecessary to call this method because the field defaults to the
             * following:
             * ```java
             * JsonValue.from("find_in_page")
             * ```
             *
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun type(type: JsonValue) = apply { this.type = type }

            /** The URL of the page that was searched. */
            fun url(url: String?) = url(JsonField.ofNullable(url))

            /** Alias for calling [Builder.url] with `url.orElse(null)`. */
            fun url(url: Optional<String>) = url(url.getOrNull())

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [FindInPage].
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
            fun build(): FindInPage =
                FindInPage(
                    checkRequired("pattern", pattern),
                    type,
                    checkRequired("url", url),
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
        fun validate(): FindInPage = apply {
            if (validated) {
                return@apply
            }

            pattern()
            _type().let {
                if (it != JsonValue.from("find_in_page")) {
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
                type.let { if (it == JsonValue.from("find_in_page")) 1 else 0 } +
                (if (url.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is FindInPage &&
                pattern == other.pattern &&
                type == other.type &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(pattern, type, url, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "FindInPage{pattern=$pattern, type=$type, url=$url, additionalProperties=$additionalProperties}"
    }
}
