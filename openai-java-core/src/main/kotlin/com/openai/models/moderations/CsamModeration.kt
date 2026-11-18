// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.moderations

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.checkKnown
import com.openai.core.checkRequired
import com.openai.core.collectAllProperties
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Collections
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

class CsamModeration
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val categories: JsonField<Categories>,
    private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>,
    private val categoryScores: JsonField<CategoryScores>,
    private val flagged: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("categories")
        @ExcludeMissing
        categories: JsonField<Categories> = JsonMissing.of(),
        @JsonProperty("category_applied_input_types")
        @ExcludeMissing
        categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> = JsonMissing.of(),
        @JsonProperty("category_scores")
        @ExcludeMissing
        categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
        @JsonProperty("flagged") @ExcludeMissing flagged: JsonField<Boolean> = JsonMissing.of(),
    ) : this(categories, categoryAppliedInputTypes, categoryScores, flagged, mutableMapOf())

    /**
     * Whether the image was flagged in each category.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun categories(): Categories = categories.getRequired("categories")

    /**
     * The input types evaluated for each category.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
        categoryAppliedInputTypes.getRequired("category_applied_input_types")

    /**
     * The classifier score for each category.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

    /**
     * Whether either CSAM category was flagged.
     *
     * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun flagged(): Boolean = flagged.getRequired("flagged")

    /**
     * Returns the raw JSON value of [categories].
     *
     * Unlike [categories], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("categories")
    @ExcludeMissing
    fun _categories(): JsonField<Categories> = categories

    /**
     * Returns the raw JSON value of [categoryAppliedInputTypes].
     *
     * Unlike [categoryAppliedInputTypes], this method doesn't throw if the JSON field has an
     * unexpected type.
     */
    @JsonProperty("category_applied_input_types")
    @ExcludeMissing
    fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
        categoryAppliedInputTypes

    /**
     * Returns the raw JSON value of [categoryScores].
     *
     * Unlike [categoryScores], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("category_scores")
    @ExcludeMissing
    fun _categoryScores(): JsonField<CategoryScores> = categoryScores

    /**
     * Returns the raw JSON value of [flagged].
     *
     * Unlike [flagged], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("flagged") @ExcludeMissing fun _flagged(): JsonField<Boolean> = flagged

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
            "categories" to this.categories,
            "category_applied_input_types" to this.categoryAppliedInputTypes,
            "category_scores" to this.categoryScores,
            "flagged" to this.flagged,
        )

    /**
     * Returns the legacy additional-properties view.
     *
     * @deprecated Use [_allProperties] to access both declared and additional JSON properties. This
     *   accessor retains its legacy additional-properties behavior.
     */
    @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CsamModeration].
         *
         * The following fields are required:
         * ```java
         * .categories()
         * .categoryAppliedInputTypes()
         * .categoryScores()
         * .flagged()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CsamModeration]. */
    class Builder internal constructor() {

        private var categories: JsonField<Categories>? = null
        private var categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>? = null
        private var categoryScores: JsonField<CategoryScores>? = null
        private var flagged: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(csamModeration: CsamModeration) = apply {
            categories = csamModeration.categories
            categoryAppliedInputTypes = csamModeration.categoryAppliedInputTypes
            categoryScores = csamModeration.categoryScores
            flagged = csamModeration.flagged
            additionalProperties = csamModeration.additionalProperties.toMutableMap()
        }

        /** Whether the image was flagged in each category. */
        fun categories(categories: Categories) = categories(JsonField.of(categories))

        /**
         * Sets [Builder.categories] to an arbitrary JSON value.
         *
         * You should usually call [Builder.categories] with a well-typed [Categories] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

        /** The input types evaluated for each category. */
        fun categoryAppliedInputTypes(categoryAppliedInputTypes: CategoryAppliedInputTypes) =
            categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

        /**
         * Sets [Builder.categoryAppliedInputTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.categoryAppliedInputTypes] with a well-typed
         * [CategoryAppliedInputTypes] value instead. This method is primarily for setting the field
         * to an undocumented or not yet supported value.
         */
        fun categoryAppliedInputTypes(
            categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
        ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

        /** The classifier score for each category. */
        fun categoryScores(categoryScores: CategoryScores) =
            categoryScores(JsonField.of(categoryScores))

        /**
         * Sets [Builder.categoryScores] to an arbitrary JSON value.
         *
         * You should usually call [Builder.categoryScores] with a well-typed [CategoryScores] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
            this.categoryScores = categoryScores
        }

        /** Whether either CSAM category was flagged. */
        fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

        /**
         * Sets [Builder.flagged] to an arbitrary JSON value.
         *
         * You should usually call [Builder.flagged] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun flagged(flagged: JsonField<Boolean>) = apply { this.flagged = flagged }

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
         * Returns an immutable instance of [CsamModeration].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .categories()
         * .categoryAppliedInputTypes()
         * .categoryScores()
         * .flagged()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CsamModeration =
            CsamModeration(
                checkRequired("categories", categories),
                checkRequired("categoryAppliedInputTypes", categoryAppliedInputTypes),
                checkRequired("categoryScores", categoryScores),
                checkRequired("flagged", flagged),
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
    fun validate(): CsamModeration = apply {
        if (validated) {
            return@apply
        }

        categories().validate()
        categoryAppliedInputTypes().validate()
        categoryScores().validate()
        flagged()
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
        (categories.asKnown().getOrNull()?.validity() ?: 0) +
            (categoryAppliedInputTypes.asKnown().getOrNull()?.validity() ?: 0) +
            (categoryScores.asKnown().getOrNull()?.validity() ?: 0) +
            (if (flagged.asKnown().isPresent) 1 else 0)

    /** Whether the image was flagged in each category. */
    class Categories
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val likelyCsam: JsonField<Boolean>,
        private val likelyCsamGenAi: JsonField<Boolean>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("likely-csam")
            @ExcludeMissing
            likelyCsam: JsonField<Boolean> = JsonMissing.of(),
            @JsonProperty("likely-csam/gen-ai")
            @ExcludeMissing
            likelyCsamGenAi: JsonField<Boolean> = JsonMissing.of(),
        ) : this(likelyCsam, likelyCsamGenAi, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsam(): Boolean = likelyCsam.getRequired("likely-csam")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsamGenAi(): Boolean = likelyCsamGenAi.getRequired("likely-csam/gen-ai")

        /**
         * Returns the raw JSON value of [likelyCsam].
         *
         * Unlike [likelyCsam], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likely-csam")
        @ExcludeMissing
        fun _likelyCsam(): JsonField<Boolean> = likelyCsam

        /**
         * Returns the raw JSON value of [likelyCsamGenAi].
         *
         * Unlike [likelyCsamGenAi], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("likely-csam/gen-ai")
        @ExcludeMissing
        fun _likelyCsamGenAi(): JsonField<Boolean> = likelyCsamGenAi

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
                "likely-csam" to this.likelyCsam,
                "likely-csam/gen-ai" to this.likelyCsamGenAi,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [Categories].
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Categories]. */
        class Builder internal constructor() {

            private var likelyCsam: JsonField<Boolean>? = null
            private var likelyCsamGenAi: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categories: Categories) = apply {
                likelyCsam = categories.likelyCsam
                likelyCsamGenAi = categories.likelyCsamGenAi
                additionalProperties = categories.additionalProperties.toMutableMap()
            }

            fun likelyCsam(likelyCsam: Boolean) = likelyCsam(JsonField.of(likelyCsam))

            /**
             * Sets [Builder.likelyCsam] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsam] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likelyCsam(likelyCsam: JsonField<Boolean>) = apply { this.likelyCsam = likelyCsam }

            fun likelyCsamGenAi(likelyCsamGenAi: Boolean) =
                likelyCsamGenAi(JsonField.of(likelyCsamGenAi))

            /**
             * Sets [Builder.likelyCsamGenAi] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsamGenAi] with a well-typed [Boolean] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likelyCsamGenAi(likelyCsamGenAi: JsonField<Boolean>) = apply {
                this.likelyCsamGenAi = likelyCsamGenAi
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
             * Returns an immutable instance of [Categories].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Categories =
                Categories(
                    checkRequired("likelyCsam", likelyCsam),
                    checkRequired("likelyCsamGenAi", likelyCsamGenAi),
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
        fun validate(): Categories = apply {
            if (validated) {
                return@apply
            }

            likelyCsam()
            likelyCsamGenAi()
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
            (if (likelyCsam.asKnown().isPresent) 1 else 0) +
                (if (likelyCsamGenAi.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Categories &&
                likelyCsam == other.likelyCsam &&
                likelyCsamGenAi == other.likelyCsamGenAi &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(likelyCsam, likelyCsamGenAi, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Categories{likelyCsam=$likelyCsam, likelyCsamGenAi=$likelyCsamGenAi, additionalProperties=$additionalProperties}"
    }

    /** The input types evaluated for each category. */
    class CategoryAppliedInputTypes
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val likelyCsam: JsonField<List<LikelyCsam>>,
        private val likelyCsamGenAi: JsonField<List<LikelyCsamGenAi>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("likely-csam")
            @ExcludeMissing
            likelyCsam: JsonField<List<LikelyCsam>> = JsonMissing.of(),
            @JsonProperty("likely-csam/gen-ai")
            @ExcludeMissing
            likelyCsamGenAi: JsonField<List<LikelyCsamGenAi>> = JsonMissing.of(),
        ) : this(likelyCsam, likelyCsamGenAi, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsam(): List<LikelyCsam> = likelyCsam.getRequired("likely-csam")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsamGenAi(): List<LikelyCsamGenAi> =
            likelyCsamGenAi.getRequired("likely-csam/gen-ai")

        /**
         * Returns the raw JSON value of [likelyCsam].
         *
         * Unlike [likelyCsam], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likely-csam")
        @ExcludeMissing
        fun _likelyCsam(): JsonField<List<LikelyCsam>> = likelyCsam

        /**
         * Returns the raw JSON value of [likelyCsamGenAi].
         *
         * Unlike [likelyCsamGenAi], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("likely-csam/gen-ai")
        @ExcludeMissing
        fun _likelyCsamGenAi(): JsonField<List<LikelyCsamGenAi>> = likelyCsamGenAi

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
                "likely-csam" to this.likelyCsam,
                "likely-csam/gen-ai" to this.likelyCsamGenAi,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of
             * [CategoryAppliedInputTypes].
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CategoryAppliedInputTypes]. */
        class Builder internal constructor() {

            private var likelyCsam: JsonField<MutableList<LikelyCsam>>? = null
            private var likelyCsamGenAi: JsonField<MutableList<LikelyCsamGenAi>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryAppliedInputTypes: CategoryAppliedInputTypes) = apply {
                likelyCsam = categoryAppliedInputTypes.likelyCsam.map { it.toMutableList() }
                likelyCsamGenAi =
                    categoryAppliedInputTypes.likelyCsamGenAi.map { it.toMutableList() }
                additionalProperties = categoryAppliedInputTypes.additionalProperties.toMutableMap()
            }

            fun likelyCsam(likelyCsam: List<LikelyCsam>) = likelyCsam(JsonField.of(likelyCsam))

            /**
             * Sets [Builder.likelyCsam] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsam] with a well-typed `List<LikelyCsam>`
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun likelyCsam(likelyCsam: JsonField<List<LikelyCsam>>) = apply {
                this.likelyCsam = likelyCsam.map { it.toMutableList() }
            }

            /**
             * Adds a single [LikelyCsam] to [Builder.likelyCsam].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLikelyCsam(likelyCsam: LikelyCsam) = apply {
                this.likelyCsam =
                    (this.likelyCsam ?: JsonField.of(mutableListOf())).also {
                        checkKnown("likelyCsam", it).add(likelyCsam)
                    }
            }

            fun likelyCsamGenAi(likelyCsamGenAi: List<LikelyCsamGenAi>) =
                likelyCsamGenAi(JsonField.of(likelyCsamGenAi))

            /**
             * Sets [Builder.likelyCsamGenAi] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsamGenAi] with a well-typed
             * `List<LikelyCsamGenAi>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun likelyCsamGenAi(likelyCsamGenAi: JsonField<List<LikelyCsamGenAi>>) = apply {
                this.likelyCsamGenAi = likelyCsamGenAi.map { it.toMutableList() }
            }

            /**
             * Adds a single [LikelyCsamGenAi] to [Builder.likelyCsamGenAi].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLikelyCsamGenAi(likelyCsamGenAi: LikelyCsamGenAi) = apply {
                this.likelyCsamGenAi =
                    (this.likelyCsamGenAi ?: JsonField.of(mutableListOf())).also {
                        checkKnown("likelyCsamGenAi", it).add(likelyCsamGenAi)
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
             * Returns an immutable instance of [CategoryAppliedInputTypes].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CategoryAppliedInputTypes =
                CategoryAppliedInputTypes(
                    checkRequired("likelyCsam", likelyCsam).map { it.toImmutable() },
                    checkRequired("likelyCsamGenAi", likelyCsamGenAi).map { it.toImmutable() },
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
        fun validate(): CategoryAppliedInputTypes = apply {
            if (validated) {
                return@apply
            }

            likelyCsam().forEach { it.validate() }
            likelyCsamGenAi().forEach { it.validate() }
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
            (likelyCsam.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (likelyCsamGenAi.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class LikelyCsam @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = LikelyCsam(JsonField.of(value))
            }

            /** An enum containing [LikelyCsam]'s known values. */
            enum class Known {
                IMAGE
            }

            /**
             * An enum containing [LikelyCsam]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [LikelyCsam] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IMAGE,
                /**
                 * An enum member indicating that [LikelyCsam] was instantiated with an unknown
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
            fun value(): Value =
                when (this) {
                    IMAGE -> Value.IMAGE
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
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown LikelyCsam: $value")
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
            fun validate(): LikelyCsam = apply {
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

                return other is LikelyCsam && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class LikelyCsamGenAi
        @JsonCreator
        private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = LikelyCsamGenAi(JsonField.of(value))
            }

            /** An enum containing [LikelyCsamGenAi]'s known values. */
            enum class Known {
                IMAGE
            }

            /**
             * An enum containing [LikelyCsamGenAi]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [LikelyCsamGenAi] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                IMAGE,
                /**
                 * An enum member indicating that [LikelyCsamGenAi] was instantiated with an unknown
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
            fun value(): Value =
                when (this) {
                    IMAGE -> Value.IMAGE
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
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown LikelyCsamGenAi: $value")
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
            fun validate(): LikelyCsamGenAi = apply {
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

                return other is LikelyCsamGenAi && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CategoryAppliedInputTypes &&
                likelyCsam == other.likelyCsam &&
                likelyCsamGenAi == other.likelyCsamGenAi &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(likelyCsam, likelyCsamGenAi, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CategoryAppliedInputTypes{likelyCsam=$likelyCsam, likelyCsamGenAi=$likelyCsamGenAi, additionalProperties=$additionalProperties}"
    }

    /** The classifier score for each category. */
    class CategoryScores
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val likelyCsam: JsonField<Double>,
        private val likelyCsamGenAi: JsonField<Double>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("likely-csam")
            @ExcludeMissing
            likelyCsam: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("likely-csam/gen-ai")
            @ExcludeMissing
            likelyCsamGenAi: JsonField<Double> = JsonMissing.of(),
        ) : this(likelyCsam, likelyCsamGenAi, mutableMapOf())

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsam(): Double = likelyCsam.getRequired("likely-csam")

        /**
         * @throws OpenAIInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun likelyCsamGenAi(): Double = likelyCsamGenAi.getRequired("likely-csam/gen-ai")

        /**
         * Returns the raw JSON value of [likelyCsam].
         *
         * Unlike [likelyCsam], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("likely-csam")
        @ExcludeMissing
        fun _likelyCsam(): JsonField<Double> = likelyCsam

        /**
         * Returns the raw JSON value of [likelyCsamGenAi].
         *
         * Unlike [likelyCsamGenAi], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("likely-csam/gen-ai")
        @ExcludeMissing
        fun _likelyCsamGenAi(): JsonField<Double> = likelyCsamGenAi

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
                "likely-csam" to this.likelyCsam,
                "likely-csam/gen-ai" to this.likelyCsamGenAi,
            )

        /**
         * Returns the legacy additional-properties view.
         *
         * @deprecated Use [_allProperties] to access both declared and additional JSON properties.
         *   This accessor retains its legacy additional-properties behavior.
         */
        @Deprecated("Use _allProperties() to access both declared and additional JSON properties.")
        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /**
             * Returns a mutable builder for constructing an instance of [CategoryScores].
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CategoryScores]. */
        class Builder internal constructor() {

            private var likelyCsam: JsonField<Double>? = null
            private var likelyCsamGenAi: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryScores: CategoryScores) = apply {
                likelyCsam = categoryScores.likelyCsam
                likelyCsamGenAi = categoryScores.likelyCsamGenAi
                additionalProperties = categoryScores.additionalProperties.toMutableMap()
            }

            fun likelyCsam(likelyCsam: Double) = likelyCsam(JsonField.of(likelyCsam))

            /**
             * Sets [Builder.likelyCsam] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsam] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likelyCsam(likelyCsam: JsonField<Double>) = apply { this.likelyCsam = likelyCsam }

            fun likelyCsamGenAi(likelyCsamGenAi: Double) =
                likelyCsamGenAi(JsonField.of(likelyCsamGenAi))

            /**
             * Sets [Builder.likelyCsamGenAi] to an arbitrary JSON value.
             *
             * You should usually call [Builder.likelyCsamGenAi] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun likelyCsamGenAi(likelyCsamGenAi: JsonField<Double>) = apply {
                this.likelyCsamGenAi = likelyCsamGenAi
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
             * Returns an immutable instance of [CategoryScores].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .likelyCsam()
             * .likelyCsamGenAi()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): CategoryScores =
                CategoryScores(
                    checkRequired("likelyCsam", likelyCsam),
                    checkRequired("likelyCsamGenAi", likelyCsamGenAi),
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
        fun validate(): CategoryScores = apply {
            if (validated) {
                return@apply
            }

            likelyCsam()
            likelyCsamGenAi()
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
            (if (likelyCsam.asKnown().isPresent) 1 else 0) +
                (if (likelyCsamGenAi.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CategoryScores &&
                likelyCsam == other.likelyCsam &&
                likelyCsamGenAi == other.likelyCsamGenAi &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(likelyCsam, likelyCsamGenAi, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CategoryScores{likelyCsam=$likelyCsam, likelyCsamGenAi=$likelyCsamGenAi, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CsamModeration &&
            categories == other.categories &&
            categoryAppliedInputTypes == other.categoryAppliedInputTypes &&
            categoryScores == other.categoryScores &&
            flagged == other.flagged &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            categories,
            categoryAppliedInputTypes,
            categoryScores,
            flagged,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CsamModeration{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, additionalProperties=$additionalProperties}"
}
