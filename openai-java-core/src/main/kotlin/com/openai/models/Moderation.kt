// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.openai.core.Enum
import com.openai.core.ExcludeMissing
import com.openai.core.JsonField
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.NoAutoDetect
import com.openai.core.checkRequired
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects
import java.util.Optional

@NoAutoDetect
class Moderation
@JsonCreator
private constructor(
    @JsonProperty("categories")
    @ExcludeMissing
    private val categories: JsonField<Categories> = JsonMissing.of(),
    @JsonProperty("category_applied_input_types")
    @ExcludeMissing
    private val categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> = JsonMissing.of(),
    @JsonProperty("category_scores")
    @ExcludeMissing
    private val categoryScores: JsonField<CategoryScores> = JsonMissing.of(),
    @JsonProperty("flagged")
    @ExcludeMissing
    private val flagged: JsonField<Boolean> = JsonMissing.of(),
    @JsonAnySetter private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
) {

    /** A list of the categories, and whether they are flagged or not. */
    fun categories(): Categories = categories.getRequired("categories")

    /** A list of the categories along with the input type(s) that the score applies to. */
    fun categoryAppliedInputTypes(): CategoryAppliedInputTypes =
        categoryAppliedInputTypes.getRequired("category_applied_input_types")

    /** A list of the categories along with their scores as predicted by model. */
    fun categoryScores(): CategoryScores = categoryScores.getRequired("category_scores")

    /** Whether any of the below categories are flagged. */
    fun flagged(): Boolean = flagged.getRequired("flagged")

    /** A list of the categories, and whether they are flagged or not. */
    @JsonProperty("categories")
    @ExcludeMissing
    fun _categories(): JsonField<Categories> = categories

    /** A list of the categories along with the input type(s) that the score applies to. */
    @JsonProperty("category_applied_input_types")
    @ExcludeMissing
    fun _categoryAppliedInputTypes(): JsonField<CategoryAppliedInputTypes> =
        categoryAppliedInputTypes

    /** A list of the categories along with their scores as predicted by model. */
    @JsonProperty("category_scores")
    @ExcludeMissing
    fun _categoryScores(): JsonField<CategoryScores> = categoryScores

    /** Whether any of the below categories are flagged. */
    @JsonProperty("flagged") @ExcludeMissing fun _flagged(): JsonField<Boolean> = flagged

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Moderation = apply {
        if (validated) {
            return@apply
        }

        categories().validate()
        categoryAppliedInputTypes().validate()
        categoryScores().validate()
        flagged()
        validated = true
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Moderation]. */
    class Builder internal constructor() {

        private var categories: JsonField<Categories>? = null
        private var categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>? = null
        private var categoryScores: JsonField<CategoryScores>? = null
        private var flagged: JsonField<Boolean>? = null
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(moderation: Moderation) = apply {
            categories = moderation.categories
            categoryAppliedInputTypes = moderation.categoryAppliedInputTypes
            categoryScores = moderation.categoryScores
            flagged = moderation.flagged
            additionalProperties = moderation.additionalProperties.toMutableMap()
        }

        /** A list of the categories, and whether they are flagged or not. */
        fun categories(categories: Categories) = categories(JsonField.of(categories))

        /** A list of the categories, and whether they are flagged or not. */
        fun categories(categories: JsonField<Categories>) = apply { this.categories = categories }

        /** A list of the categories along with the input type(s) that the score applies to. */
        fun categoryAppliedInputTypes(categoryAppliedInputTypes: CategoryAppliedInputTypes) =
            categoryAppliedInputTypes(JsonField.of(categoryAppliedInputTypes))

        /** A list of the categories along with the input type(s) that the score applies to. */
        fun categoryAppliedInputTypes(
            categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes>
        ) = apply { this.categoryAppliedInputTypes = categoryAppliedInputTypes }

        /** A list of the categories along with their scores as predicted by model. */
        fun categoryScores(categoryScores: CategoryScores) =
            categoryScores(JsonField.of(categoryScores))

        /** A list of the categories along with their scores as predicted by model. */
        fun categoryScores(categoryScores: JsonField<CategoryScores>) = apply {
            this.categoryScores = categoryScores
        }

        /** Whether any of the below categories are flagged. */
        fun flagged(flagged: Boolean) = flagged(JsonField.of(flagged))

        /** Whether any of the below categories are flagged. */
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

        fun build(): Moderation =
            Moderation(
                checkRequired("categories", categories),
                checkRequired("categoryAppliedInputTypes", categoryAppliedInputTypes),
                checkRequired("categoryScores", categoryScores),
                checkRequired("flagged", flagged),
                additionalProperties.toImmutable(),
            )
    }

    /** A list of the categories, and whether they are flagged or not. */
    @NoAutoDetect
    class Categories
    @JsonCreator
    private constructor(
        @JsonProperty("harassment")
        @ExcludeMissing
        private val harassment: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        private val harassmentThreatening: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("hate")
        @ExcludeMissing
        private val hate: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        private val hateThreatening: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("illicit")
        @ExcludeMissing
        private val illicit: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        private val illicitViolent: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("self-harm")
        @ExcludeMissing
        private val selfHarm: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        private val selfHarmInstructions: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        private val selfHarmIntent: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("sexual")
        @ExcludeMissing
        private val sexual: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        private val sexualMinors: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("violence")
        @ExcludeMissing
        private val violence: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        private val violenceGraphic: JsonField<Boolean> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** Content that expresses, incites, or promotes harassing language towards any target. */
        fun harassment(): Boolean = harassment.getRequired("harassment")

        /** Harassment content that also includes violence or serious harm towards any target. */
        fun harassmentThreatening(): Boolean =
            harassmentThreatening.getRequired("harassment/threatening")

        /**
         * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
         * religion, nationality, sexual orientation, disability status, or caste. Hateful content
         * aimed at non-protected groups (e.g., chess players) is harassment.
         */
        fun hate(): Boolean = hate.getRequired("hate")

        /**
         * Hateful content that also includes violence or serious harm towards the targeted group
         * based on race, gender, ethnicity, religion, nationality, sexual orientation, disability
         * status, or caste.
         */
        fun hateThreatening(): Boolean = hateThreatening.getRequired("hate/threatening")

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing, or that gives advice or instruction on how to commit illicit acts. For
         * example, "how to shoplift" would fit this category.
         */
        fun illicit(): Optional<Boolean> = Optional.ofNullable(illicit.getNullable("illicit"))

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing that also includes violence, or that gives advice or instruction on the
         * procurement of any weapon.
         */
        fun illicitViolent(): Optional<Boolean> =
            Optional.ofNullable(illicitViolent.getNullable("illicit/violent"))

        /**
         * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
         * cutting, and eating disorders.
         */
        fun selfHarm(): Boolean = selfHarm.getRequired("self-harm")

        /**
         * Content that encourages performing acts of self-harm, such as suicide, cutting, and
         * eating disorders, or that gives instructions or advice on how to commit such acts.
         */
        fun selfHarmInstructions(): Boolean =
            selfHarmInstructions.getRequired("self-harm/instructions")

        /**
         * Content where the speaker expresses that they are engaging or intend to engage in acts of
         * self-harm, such as suicide, cutting, and eating disorders.
         */
        fun selfHarmIntent(): Boolean = selfHarmIntent.getRequired("self-harm/intent")

        /**
         * Content meant to arouse sexual excitement, such as the description of sexual activity, or
         * that promotes sexual services (excluding sex education and wellness).
         */
        fun sexual(): Boolean = sexual.getRequired("sexual")

        /** Sexual content that includes an individual who is under 18 years old. */
        fun sexualMinors(): Boolean = sexualMinors.getRequired("sexual/minors")

        /** Content that depicts death, violence, or physical injury. */
        fun violence(): Boolean = violence.getRequired("violence")

        /** Content that depicts death, violence, or physical injury in graphic detail. */
        fun violenceGraphic(): Boolean = violenceGraphic.getRequired("violence/graphic")

        /** Content that expresses, incites, or promotes harassing language towards any target. */
        @JsonProperty("harassment")
        @ExcludeMissing
        fun _harassment(): JsonField<Boolean> = harassment

        /** Harassment content that also includes violence or serious harm towards any target. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening(): JsonField<Boolean> = harassmentThreatening

        /**
         * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
         * religion, nationality, sexual orientation, disability status, or caste. Hateful content
         * aimed at non-protected groups (e.g., chess players) is harassment.
         */
        @JsonProperty("hate") @ExcludeMissing fun _hate(): JsonField<Boolean> = hate

        /**
         * Hateful content that also includes violence or serious harm towards the targeted group
         * based on race, gender, ethnicity, religion, nationality, sexual orientation, disability
         * status, or caste.
         */
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        fun _hateThreatening(): JsonField<Boolean> = hateThreatening

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing, or that gives advice or instruction on how to commit illicit acts. For
         * example, "how to shoplift" would fit this category.
         */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit(): JsonField<Boolean> = illicit

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing that also includes violence, or that gives advice or instruction on the
         * procurement of any weapon.
         */
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        fun _illicitViolent(): JsonField<Boolean> = illicitViolent

        /**
         * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
         * cutting, and eating disorders.
         */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm(): JsonField<Boolean> = selfHarm

        /**
         * Content that encourages performing acts of self-harm, such as suicide, cutting, and
         * eating disorders, or that gives instructions or advice on how to commit such acts.
         */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions(): JsonField<Boolean> = selfHarmInstructions

        /**
         * Content where the speaker expresses that they are engaging or intend to engage in acts of
         * self-harm, such as suicide, cutting, and eating disorders.
         */
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        fun _selfHarmIntent(): JsonField<Boolean> = selfHarmIntent

        /**
         * Content meant to arouse sexual excitement, such as the description of sexual activity, or
         * that promotes sexual services (excluding sex education and wellness).
         */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual(): JsonField<Boolean> = sexual

        /** Sexual content that includes an individual who is under 18 years old. */
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        fun _sexualMinors(): JsonField<Boolean> = sexualMinors

        /** Content that depicts death, violence, or physical injury. */
        @JsonProperty("violence") @ExcludeMissing fun _violence(): JsonField<Boolean> = violence

        /** Content that depicts death, violence, or physical injury in graphic detail. */
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        fun _violenceGraphic(): JsonField<Boolean> = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Categories = apply {
            if (validated) {
                return@apply
            }

            harassment()
            harassmentThreatening()
            hate()
            hateThreatening()
            illicit()
            illicitViolent()
            selfHarm()
            selfHarmInstructions()
            selfHarmIntent()
            sexual()
            sexualMinors()
            violence()
            violenceGraphic()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Categories]. */
        class Builder internal constructor() {

            private var harassment: JsonField<Boolean>? = null
            private var harassmentThreatening: JsonField<Boolean>? = null
            private var hate: JsonField<Boolean>? = null
            private var hateThreatening: JsonField<Boolean>? = null
            private var illicit: JsonField<Boolean>? = null
            private var illicitViolent: JsonField<Boolean>? = null
            private var selfHarm: JsonField<Boolean>? = null
            private var selfHarmInstructions: JsonField<Boolean>? = null
            private var selfHarmIntent: JsonField<Boolean>? = null
            private var sexual: JsonField<Boolean>? = null
            private var sexualMinors: JsonField<Boolean>? = null
            private var violence: JsonField<Boolean>? = null
            private var violenceGraphic: JsonField<Boolean>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categories: Categories) = apply {
                harassment = categories.harassment
                harassmentThreatening = categories.harassmentThreatening
                hate = categories.hate
                hateThreatening = categories.hateThreatening
                illicit = categories.illicit
                illicitViolent = categories.illicitViolent
                selfHarm = categories.selfHarm
                selfHarmInstructions = categories.selfHarmInstructions
                selfHarmIntent = categories.selfHarmIntent
                sexual = categories.sexual
                sexualMinors = categories.sexualMinors
                violence = categories.violence
                violenceGraphic = categories.violenceGraphic
                additionalProperties = categories.additionalProperties.toMutableMap()
            }

            /**
             * Content that expresses, incites, or promotes harassing language towards any target.
             */
            fun harassment(harassment: Boolean) = harassment(JsonField.of(harassment))

            /**
             * Content that expresses, incites, or promotes harassing language towards any target.
             */
            fun harassment(harassment: JsonField<Boolean>) = apply { this.harassment = harassment }

            /**
             * Harassment content that also includes violence or serious harm towards any target.
             */
            fun harassmentThreatening(harassmentThreatening: Boolean) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /**
             * Harassment content that also includes violence or serious harm towards any target.
             */
            fun harassmentThreatening(harassmentThreatening: JsonField<Boolean>) = apply {
                this.harassmentThreatening = harassmentThreatening
            }

            /**
             * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
             * religion, nationality, sexual orientation, disability status, or caste. Hateful
             * content aimed at non-protected groups (e.g., chess players) is harassment.
             */
            fun hate(hate: Boolean) = hate(JsonField.of(hate))

            /**
             * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
             * religion, nationality, sexual orientation, disability status, or caste. Hateful
             * content aimed at non-protected groups (e.g., chess players) is harassment.
             */
            fun hate(hate: JsonField<Boolean>) = apply { this.hate = hate }

            /**
             * Hateful content that also includes violence or serious harm towards the targeted
             * group based on race, gender, ethnicity, religion, nationality, sexual orientation,
             * disability status, or caste.
             */
            fun hateThreatening(hateThreatening: Boolean) =
                hateThreatening(JsonField.of(hateThreatening))

            /**
             * Hateful content that also includes violence or serious harm towards the targeted
             * group based on race, gender, ethnicity, religion, nationality, sexual orientation,
             * disability status, or caste.
             */
            fun hateThreatening(hateThreatening: JsonField<Boolean>) = apply {
                this.hateThreatening = hateThreatening
            }

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing, or that gives advice or instruction on how to commit illicit
             * acts. For example, "how to shoplift" would fit this category.
             */
            fun illicit(illicit: Boolean?) = illicit(JsonField.ofNullable(illicit))

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing, or that gives advice or instruction on how to commit illicit
             * acts. For example, "how to shoplift" would fit this category.
             */
            fun illicit(illicit: Boolean) = illicit(illicit as Boolean?)

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing, or that gives advice or instruction on how to commit illicit
             * acts. For example, "how to shoplift" would fit this category.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun illicit(illicit: Optional<Boolean>) = illicit(illicit.orElse(null) as Boolean?)

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing, or that gives advice or instruction on how to commit illicit
             * acts. For example, "how to shoplift" would fit this category.
             */
            fun illicit(illicit: JsonField<Boolean>) = apply { this.illicit = illicit }

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing that also includes violence, or that gives advice or
             * instruction on the procurement of any weapon.
             */
            fun illicitViolent(illicitViolent: Boolean?) =
                illicitViolent(JsonField.ofNullable(illicitViolent))

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing that also includes violence, or that gives advice or
             * instruction on the procurement of any weapon.
             */
            fun illicitViolent(illicitViolent: Boolean) = illicitViolent(illicitViolent as Boolean?)

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing that also includes violence, or that gives advice or
             * instruction on the procurement of any weapon.
             */
            @Suppress("USELESS_CAST") // See https://youtrack.jetbrains.com/issue/KT-74228
            fun illicitViolent(illicitViolent: Optional<Boolean>) =
                illicitViolent(illicitViolent.orElse(null) as Boolean?)

            /**
             * Content that includes instructions or advice that facilitate the planning or
             * execution of wrongdoing that also includes violence, or that gives advice or
             * instruction on the procurement of any weapon.
             */
            fun illicitViolent(illicitViolent: JsonField<Boolean>) = apply {
                this.illicitViolent = illicitViolent
            }

            /**
             * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
             * cutting, and eating disorders.
             */
            fun selfHarm(selfHarm: Boolean) = selfHarm(JsonField.of(selfHarm))

            /**
             * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
             * cutting, and eating disorders.
             */
            fun selfHarm(selfHarm: JsonField<Boolean>) = apply { this.selfHarm = selfHarm }

            /**
             * Content that encourages performing acts of self-harm, such as suicide, cutting, and
             * eating disorders, or that gives instructions or advice on how to commit such acts.
             */
            fun selfHarmInstructions(selfHarmInstructions: Boolean) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /**
             * Content that encourages performing acts of self-harm, such as suicide, cutting, and
             * eating disorders, or that gives instructions or advice on how to commit such acts.
             */
            fun selfHarmInstructions(selfHarmInstructions: JsonField<Boolean>) = apply {
                this.selfHarmInstructions = selfHarmInstructions
            }

            /**
             * Content where the speaker expresses that they are engaging or intend to engage in
             * acts of self-harm, such as suicide, cutting, and eating disorders.
             */
            fun selfHarmIntent(selfHarmIntent: Boolean) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /**
             * Content where the speaker expresses that they are engaging or intend to engage in
             * acts of self-harm, such as suicide, cutting, and eating disorders.
             */
            fun selfHarmIntent(selfHarmIntent: JsonField<Boolean>) = apply {
                this.selfHarmIntent = selfHarmIntent
            }

            /**
             * Content meant to arouse sexual excitement, such as the description of sexual
             * activity, or that promotes sexual services (excluding sex education and wellness).
             */
            fun sexual(sexual: Boolean) = sexual(JsonField.of(sexual))

            /**
             * Content meant to arouse sexual excitement, such as the description of sexual
             * activity, or that promotes sexual services (excluding sex education and wellness).
             */
            fun sexual(sexual: JsonField<Boolean>) = apply { this.sexual = sexual }

            /** Sexual content that includes an individual who is under 18 years old. */
            fun sexualMinors(sexualMinors: Boolean) = sexualMinors(JsonField.of(sexualMinors))

            /** Sexual content that includes an individual who is under 18 years old. */
            fun sexualMinors(sexualMinors: JsonField<Boolean>) = apply {
                this.sexualMinors = sexualMinors
            }

            /** Content that depicts death, violence, or physical injury. */
            fun violence(violence: Boolean) = violence(JsonField.of(violence))

            /** Content that depicts death, violence, or physical injury. */
            fun violence(violence: JsonField<Boolean>) = apply { this.violence = violence }

            /** Content that depicts death, violence, or physical injury in graphic detail. */
            fun violenceGraphic(violenceGraphic: Boolean) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** Content that depicts death, violence, or physical injury in graphic detail. */
            fun violenceGraphic(violenceGraphic: JsonField<Boolean>) = apply {
                this.violenceGraphic = violenceGraphic
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

            fun build(): Categories =
                Categories(
                    checkRequired("harassment", harassment),
                    checkRequired("harassmentThreatening", harassmentThreatening),
                    checkRequired("hate", hate),
                    checkRequired("hateThreatening", hateThreatening),
                    checkRequired("illicit", illicit),
                    checkRequired("illicitViolent", illicitViolent),
                    checkRequired("selfHarm", selfHarm),
                    checkRequired("selfHarmInstructions", selfHarmInstructions),
                    checkRequired("selfHarmIntent", selfHarmIntent),
                    checkRequired("sexual", sexual),
                    checkRequired("sexualMinors", sexualMinors),
                    checkRequired("violence", violence),
                    checkRequired("violenceGraphic", violenceGraphic),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Categories && harassment == other.harassment && harassmentThreatening == other.harassmentThreatening && hate == other.hate && hateThreatening == other.hateThreatening && illicit == other.illicit && illicitViolent == other.illicitViolent && selfHarm == other.selfHarm && selfHarmInstructions == other.selfHarmInstructions && selfHarmIntent == other.selfHarmIntent && sexual == other.sexual && sexualMinors == other.sexualMinors && violence == other.violence && violenceGraphic == other.violenceGraphic && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(harassment, harassmentThreatening, hate, hateThreatening, illicit, illicitViolent, selfHarm, selfHarmInstructions, selfHarmIntent, sexual, sexualMinors, violence, violenceGraphic, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Categories{harassment=$harassment, harassmentThreatening=$harassmentThreatening, hate=$hate, hateThreatening=$hateThreatening, illicit=$illicit, illicitViolent=$illicitViolent, selfHarm=$selfHarm, selfHarmInstructions=$selfHarmInstructions, selfHarmIntent=$selfHarmIntent, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"
    }

    /** A list of the categories along with the input type(s) that the score applies to. */
    @NoAutoDetect
    class CategoryAppliedInputTypes
    @JsonCreator
    private constructor(
        @JsonProperty("harassment")
        @ExcludeMissing
        private val harassment: JsonField<List<Harassment>> = JsonMissing.of(),
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        private val harassmentThreatening: JsonField<List<HarassmentThreatening>> =
            JsonMissing.of(),
        @JsonProperty("hate")
        @ExcludeMissing
        private val hate: JsonField<List<Hate>> = JsonMissing.of(),
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        private val hateThreatening: JsonField<List<HateThreatening>> = JsonMissing.of(),
        @JsonProperty("illicit")
        @ExcludeMissing
        private val illicit: JsonField<List<Illicit>> = JsonMissing.of(),
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        private val illicitViolent: JsonField<List<IllicitViolent>> = JsonMissing.of(),
        @JsonProperty("self-harm")
        @ExcludeMissing
        private val selfHarm: JsonField<List<SelfHarm>> = JsonMissing.of(),
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        private val selfHarmInstructions: JsonField<List<SelfHarmInstruction>> = JsonMissing.of(),
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        private val selfHarmIntent: JsonField<List<SelfHarmIntent>> = JsonMissing.of(),
        @JsonProperty("sexual")
        @ExcludeMissing
        private val sexual: JsonField<List<Sexual>> = JsonMissing.of(),
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        private val sexualMinors: JsonField<List<SexualMinor>> = JsonMissing.of(),
        @JsonProperty("violence")
        @ExcludeMissing
        private val violence: JsonField<List<Violence>> = JsonMissing.of(),
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        private val violenceGraphic: JsonField<List<ViolenceGraphic>> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The applied input type(s) for the category 'harassment'. */
        fun harassment(): List<Harassment> = harassment.getRequired("harassment")

        /** The applied input type(s) for the category 'harassment/threatening'. */
        fun harassmentThreatening(): List<HarassmentThreatening> =
            harassmentThreatening.getRequired("harassment/threatening")

        /** The applied input type(s) for the category 'hate'. */
        fun hate(): List<Hate> = hate.getRequired("hate")

        /** The applied input type(s) for the category 'hate/threatening'. */
        fun hateThreatening(): List<HateThreatening> =
            hateThreatening.getRequired("hate/threatening")

        /** The applied input type(s) for the category 'illicit'. */
        fun illicit(): List<Illicit> = illicit.getRequired("illicit")

        /** The applied input type(s) for the category 'illicit/violent'. */
        fun illicitViolent(): List<IllicitViolent> = illicitViolent.getRequired("illicit/violent")

        /** The applied input type(s) for the category 'self-harm'. */
        fun selfHarm(): List<SelfHarm> = selfHarm.getRequired("self-harm")

        /** The applied input type(s) for the category 'self-harm/instructions'. */
        fun selfHarmInstructions(): List<SelfHarmInstruction> =
            selfHarmInstructions.getRequired("self-harm/instructions")

        /** The applied input type(s) for the category 'self-harm/intent'. */
        fun selfHarmIntent(): List<SelfHarmIntent> = selfHarmIntent.getRequired("self-harm/intent")

        /** The applied input type(s) for the category 'sexual'. */
        fun sexual(): List<Sexual> = sexual.getRequired("sexual")

        /** The applied input type(s) for the category 'sexual/minors'. */
        fun sexualMinors(): List<SexualMinor> = sexualMinors.getRequired("sexual/minors")

        /** The applied input type(s) for the category 'violence'. */
        fun violence(): List<Violence> = violence.getRequired("violence")

        /** The applied input type(s) for the category 'violence/graphic'. */
        fun violenceGraphic(): List<ViolenceGraphic> =
            violenceGraphic.getRequired("violence/graphic")

        /** The applied input type(s) for the category 'harassment'. */
        @JsonProperty("harassment")
        @ExcludeMissing
        fun _harassment(): JsonField<List<Harassment>> = harassment

        /** The applied input type(s) for the category 'harassment/threatening'. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening(): JsonField<List<HarassmentThreatening>> = harassmentThreatening

        /** The applied input type(s) for the category 'hate'. */
        @JsonProperty("hate") @ExcludeMissing fun _hate(): JsonField<List<Hate>> = hate

        /** The applied input type(s) for the category 'hate/threatening'. */
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        fun _hateThreatening(): JsonField<List<HateThreatening>> = hateThreatening

        /** The applied input type(s) for the category 'illicit'. */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit(): JsonField<List<Illicit>> = illicit

        /** The applied input type(s) for the category 'illicit/violent'. */
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        fun _illicitViolent(): JsonField<List<IllicitViolent>> = illicitViolent

        /** The applied input type(s) for the category 'self-harm'. */
        @JsonProperty("self-harm")
        @ExcludeMissing
        fun _selfHarm(): JsonField<List<SelfHarm>> = selfHarm

        /** The applied input type(s) for the category 'self-harm/instructions'. */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions(): JsonField<List<SelfHarmInstruction>> = selfHarmInstructions

        /** The applied input type(s) for the category 'self-harm/intent'. */
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        fun _selfHarmIntent(): JsonField<List<SelfHarmIntent>> = selfHarmIntent

        /** The applied input type(s) for the category 'sexual'. */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual(): JsonField<List<Sexual>> = sexual

        /** The applied input type(s) for the category 'sexual/minors'. */
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        fun _sexualMinors(): JsonField<List<SexualMinor>> = sexualMinors

        /** The applied input type(s) for the category 'violence'. */
        @JsonProperty("violence")
        @ExcludeMissing
        fun _violence(): JsonField<List<Violence>> = violence

        /** The applied input type(s) for the category 'violence/graphic'. */
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        fun _violenceGraphic(): JsonField<List<ViolenceGraphic>> = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CategoryAppliedInputTypes = apply {
            if (validated) {
                return@apply
            }

            harassment()
            harassmentThreatening()
            hate()
            hateThreatening()
            illicit()
            illicitViolent()
            selfHarm()
            selfHarmInstructions()
            selfHarmIntent()
            sexual()
            sexualMinors()
            violence()
            violenceGraphic()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CategoryAppliedInputTypes]. */
        class Builder internal constructor() {

            private var harassment: JsonField<MutableList<Harassment>>? = null
            private var harassmentThreatening: JsonField<MutableList<HarassmentThreatening>>? = null
            private var hate: JsonField<MutableList<Hate>>? = null
            private var hateThreatening: JsonField<MutableList<HateThreatening>>? = null
            private var illicit: JsonField<MutableList<Illicit>>? = null
            private var illicitViolent: JsonField<MutableList<IllicitViolent>>? = null
            private var selfHarm: JsonField<MutableList<SelfHarm>>? = null
            private var selfHarmInstructions: JsonField<MutableList<SelfHarmInstruction>>? = null
            private var selfHarmIntent: JsonField<MutableList<SelfHarmIntent>>? = null
            private var sexual: JsonField<MutableList<Sexual>>? = null
            private var sexualMinors: JsonField<MutableList<SexualMinor>>? = null
            private var violence: JsonField<MutableList<Violence>>? = null
            private var violenceGraphic: JsonField<MutableList<ViolenceGraphic>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryAppliedInputTypes: CategoryAppliedInputTypes) = apply {
                harassment = categoryAppliedInputTypes.harassment.map { it.toMutableList() }
                harassmentThreatening =
                    categoryAppliedInputTypes.harassmentThreatening.map { it.toMutableList() }
                hate = categoryAppliedInputTypes.hate.map { it.toMutableList() }
                hateThreatening =
                    categoryAppliedInputTypes.hateThreatening.map { it.toMutableList() }
                illicit = categoryAppliedInputTypes.illicit.map { it.toMutableList() }
                illicitViolent = categoryAppliedInputTypes.illicitViolent.map { it.toMutableList() }
                selfHarm = categoryAppliedInputTypes.selfHarm.map { it.toMutableList() }
                selfHarmInstructions =
                    categoryAppliedInputTypes.selfHarmInstructions.map { it.toMutableList() }
                selfHarmIntent = categoryAppliedInputTypes.selfHarmIntent.map { it.toMutableList() }
                sexual = categoryAppliedInputTypes.sexual.map { it.toMutableList() }
                sexualMinors = categoryAppliedInputTypes.sexualMinors.map { it.toMutableList() }
                violence = categoryAppliedInputTypes.violence.map { it.toMutableList() }
                violenceGraphic =
                    categoryAppliedInputTypes.violenceGraphic.map { it.toMutableList() }
                additionalProperties = categoryAppliedInputTypes.additionalProperties.toMutableMap()
            }

            /** The applied input type(s) for the category 'harassment'. */
            fun harassment(harassment: List<Harassment>) = harassment(JsonField.of(harassment))

            /** The applied input type(s) for the category 'harassment'. */
            fun harassment(harassment: JsonField<List<Harassment>>) = apply {
                this.harassment = harassment.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'harassment'. */
            fun addHarassment(harassment: Harassment) = apply {
                this.harassment =
                    (this.harassment ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(harassment)
                    }
            }

            /** The applied input type(s) for the category 'harassment/threatening'. */
            fun harassmentThreatening(harassmentThreatening: List<HarassmentThreatening>) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /** The applied input type(s) for the category 'harassment/threatening'. */
            fun harassmentThreatening(
                harassmentThreatening: JsonField<List<HarassmentThreatening>>
            ) = apply {
                this.harassmentThreatening = harassmentThreatening.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'harassment/threatening'. */
            fun addHarassmentThreatening(harassmentThreatening: HarassmentThreatening) = apply {
                this.harassmentThreatening =
                    (this.harassmentThreatening ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(harassmentThreatening)
                    }
            }

            /** The applied input type(s) for the category 'hate'. */
            fun hate(hate: List<Hate>) = hate(JsonField.of(hate))

            /** The applied input type(s) for the category 'hate'. */
            fun hate(hate: JsonField<List<Hate>>) = apply {
                this.hate = hate.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'hate'. */
            fun addHate(hate: Hate) = apply {
                this.hate =
                    (this.hate ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(hate)
                    }
            }

            /** The applied input type(s) for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: List<HateThreatening>) =
                hateThreatening(JsonField.of(hateThreatening))

            /** The applied input type(s) for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: JsonField<List<HateThreatening>>) = apply {
                this.hateThreatening = hateThreatening.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'hate/threatening'. */
            fun addHateThreatening(hateThreatening: HateThreatening) = apply {
                this.hateThreatening =
                    (this.hateThreatening ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(hateThreatening)
                    }
            }

            /** The applied input type(s) for the category 'illicit'. */
            fun illicit(illicit: List<Illicit>) = illicit(JsonField.of(illicit))

            /** The applied input type(s) for the category 'illicit'. */
            fun illicit(illicit: JsonField<List<Illicit>>) = apply {
                this.illicit = illicit.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'illicit'. */
            fun addIllicit(illicit: Illicit) = apply {
                this.illicit =
                    (this.illicit ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(illicit)
                    }
            }

            /** The applied input type(s) for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: List<IllicitViolent>) =
                illicitViolent(JsonField.of(illicitViolent))

            /** The applied input type(s) for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: JsonField<List<IllicitViolent>>) = apply {
                this.illicitViolent = illicitViolent.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'illicit/violent'. */
            fun addIllicitViolent(illicitViolent: IllicitViolent) = apply {
                this.illicitViolent =
                    (this.illicitViolent ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(illicitViolent)
                    }
            }

            /** The applied input type(s) for the category 'self-harm'. */
            fun selfHarm(selfHarm: List<SelfHarm>) = selfHarm(JsonField.of(selfHarm))

            /** The applied input type(s) for the category 'self-harm'. */
            fun selfHarm(selfHarm: JsonField<List<SelfHarm>>) = apply {
                this.selfHarm = selfHarm.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'self-harm'. */
            fun addSelfHarm(selfHarm: SelfHarm) = apply {
                this.selfHarm =
                    (this.selfHarm ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(selfHarm)
                    }
            }

            /** The applied input type(s) for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: List<SelfHarmInstruction>) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /** The applied input type(s) for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: JsonField<List<SelfHarmInstruction>>) =
                apply {
                    this.selfHarmInstructions = selfHarmInstructions.map { it.toMutableList() }
                }

            /** The applied input type(s) for the category 'self-harm/instructions'. */
            fun addSelfHarmInstruction(selfHarmInstruction: SelfHarmInstruction) = apply {
                selfHarmInstructions =
                    (selfHarmInstructions ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(selfHarmInstruction)
                    }
            }

            /** The applied input type(s) for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: List<SelfHarmIntent>) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /** The applied input type(s) for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: JsonField<List<SelfHarmIntent>>) = apply {
                this.selfHarmIntent = selfHarmIntent.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'self-harm/intent'. */
            fun addSelfHarmIntent(selfHarmIntent: SelfHarmIntent) = apply {
                this.selfHarmIntent =
                    (this.selfHarmIntent ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(selfHarmIntent)
                    }
            }

            /** The applied input type(s) for the category 'sexual'. */
            fun sexual(sexual: List<Sexual>) = sexual(JsonField.of(sexual))

            /** The applied input type(s) for the category 'sexual'. */
            fun sexual(sexual: JsonField<List<Sexual>>) = apply {
                this.sexual = sexual.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'sexual'. */
            fun addSexual(sexual: Sexual) = apply {
                this.sexual =
                    (this.sexual ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(sexual)
                    }
            }

            /** The applied input type(s) for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: List<SexualMinor>) =
                sexualMinors(JsonField.of(sexualMinors))

            /** The applied input type(s) for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: JsonField<List<SexualMinor>>) = apply {
                this.sexualMinors = sexualMinors.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'sexual/minors'. */
            fun addSexualMinor(sexualMinor: SexualMinor) = apply {
                sexualMinors =
                    (sexualMinors ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(sexualMinor)
                    }
            }

            /** The applied input type(s) for the category 'violence'. */
            fun violence(violence: List<Violence>) = violence(JsonField.of(violence))

            /** The applied input type(s) for the category 'violence'. */
            fun violence(violence: JsonField<List<Violence>>) = apply {
                this.violence = violence.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'violence'. */
            fun addViolence(violence: Violence) = apply {
                this.violence =
                    (this.violence ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(violence)
                    }
            }

            /** The applied input type(s) for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: List<ViolenceGraphic>) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** The applied input type(s) for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: JsonField<List<ViolenceGraphic>>) = apply {
                this.violenceGraphic = violenceGraphic.map { it.toMutableList() }
            }

            /** The applied input type(s) for the category 'violence/graphic'. */
            fun addViolenceGraphic(violenceGraphic: ViolenceGraphic) = apply {
                this.violenceGraphic =
                    (this.violenceGraphic ?: JsonField.of(mutableListOf())).apply {
                        asKnown()
                            .orElseThrow {
                                IllegalStateException(
                                    "Field was set to non-list type: ${javaClass.simpleName}"
                                )
                            }
                            .add(violenceGraphic)
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

            fun build(): CategoryAppliedInputTypes =
                CategoryAppliedInputTypes(
                    checkRequired("harassment", harassment).map { it.toImmutable() },
                    checkRequired("harassmentThreatening", harassmentThreatening).map {
                        it.toImmutable()
                    },
                    checkRequired("hate", hate).map { it.toImmutable() },
                    checkRequired("hateThreatening", hateThreatening).map { it.toImmutable() },
                    checkRequired("illicit", illicit).map { it.toImmutable() },
                    checkRequired("illicitViolent", illicitViolent).map { it.toImmutable() },
                    checkRequired("selfHarm", selfHarm).map { it.toImmutable() },
                    checkRequired("selfHarmInstructions", selfHarmInstructions).map {
                        it.toImmutable()
                    },
                    checkRequired("selfHarmIntent", selfHarmIntent).map { it.toImmutable() },
                    checkRequired("sexual", sexual).map { it.toImmutable() },
                    checkRequired("sexualMinors", sexualMinors).map { it.toImmutable() },
                    checkRequired("violence", violence).map { it.toImmutable() },
                    checkRequired("violenceGraphic", violenceGraphic).map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        class Harassment @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Harassment(JsonField.of(value))
            }

            /** An enum containing [Harassment]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [Harassment]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Harassment] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [Harassment] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown Harassment: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Harassment && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class HarassmentThreatening
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = HarassmentThreatening(JsonField.of(value))
            }

            /** An enum containing [HarassmentThreatening]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [HarassmentThreatening]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [HarassmentThreatening] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [HarassmentThreatening] was instantiated with an
                 * unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else ->
                        throw OpenAIInvalidDataException("Unknown HarassmentThreatening: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is HarassmentThreatening && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Hate @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Hate(JsonField.of(value))
            }

            /** An enum containing [Hate]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [Hate]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Hate] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /** An enum member indicating that [Hate] was instantiated with an unknown value. */
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown Hate: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Hate && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class HateThreatening
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = HateThreatening(JsonField.of(value))
            }

            /** An enum containing [HateThreatening]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [HateThreatening]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [HateThreatening] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [HateThreatening] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown HateThreatening: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is HateThreatening && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Illicit @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Illicit(JsonField.of(value))
            }

            /** An enum containing [Illicit]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [Illicit]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Illicit] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [Illicit] was instantiated with an unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown Illicit: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Illicit && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class IllicitViolent
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = IllicitViolent(JsonField.of(value))
            }

            /** An enum containing [IllicitViolent]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [IllicitViolent]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [IllicitViolent] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [IllicitViolent] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown IllicitViolent: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is IllicitViolent && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class SelfHarm @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarm(JsonField.of(value))
            }

            /** An enum containing [SelfHarm]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [SelfHarm]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [SelfHarm] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [SelfHarm] was instantiated with an unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown SelfHarm: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SelfHarm && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class SelfHarmInstruction
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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarmInstruction(JsonField.of(value))
            }

            /** An enum containing [SelfHarmInstruction]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [SelfHarmInstruction]'s known values, as well as an [_UNKNOWN]
             * member.
             *
             * An instance of [SelfHarmInstruction] can contain an unknown value in a couple of
             * cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [SelfHarmInstruction] was instantiated with an
                 * unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown SelfHarmInstruction: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SelfHarmInstruction && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class SelfHarmIntent
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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarmIntent(JsonField.of(value))
            }

            /** An enum containing [SelfHarmIntent]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [SelfHarmIntent]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [SelfHarmIntent] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [SelfHarmIntent] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown SelfHarmIntent: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SelfHarmIntent && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Sexual @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = Sexual(JsonField.of(value))
            }

            /** An enum containing [Sexual]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [Sexual]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Sexual] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [Sexual] was instantiated with an unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown Sexual: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Sexual && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class SexualMinor @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = SexualMinor(JsonField.of(value))
            }

            /** An enum containing [SexualMinor]'s known values. */
            enum class Known {
                TEXT
            }

            /**
             * An enum containing [SexualMinor]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [SexualMinor] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                /**
                 * An enum member indicating that [SexualMinor] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    else -> throw OpenAIInvalidDataException("Unknown SexualMinor: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is SexualMinor && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Violence @JsonCreator private constructor(private val value: JsonField<String>) :
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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = Violence(JsonField.of(value))
            }

            /** An enum containing [Violence]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [Violence]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [Violence] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [Violence] was instantiated with an unknown value.
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown Violence: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is Violence && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class ViolenceGraphic
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

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = ViolenceGraphic(JsonField.of(value))
            }

            /** An enum containing [ViolenceGraphic]'s known values. */
            enum class Known {
                TEXT,
                IMAGE,
            }

            /**
             * An enum containing [ViolenceGraphic]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [ViolenceGraphic] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                TEXT,
                IMAGE,
                /**
                 * An enum member indicating that [ViolenceGraphic] was instantiated with an unknown
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
                    TEXT -> Value.TEXT
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
                    TEXT -> Known.TEXT
                    IMAGE -> Known.IMAGE
                    else -> throw OpenAIInvalidDataException("Unknown ViolenceGraphic: $value")
                }

            fun asString(): String = _value().asStringOrThrow()

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return /* spotless:off */ other is ViolenceGraphic && value == other.value /* spotless:on */
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CategoryAppliedInputTypes && harassment == other.harassment && harassmentThreatening == other.harassmentThreatening && hate == other.hate && hateThreatening == other.hateThreatening && illicit == other.illicit && illicitViolent == other.illicitViolent && selfHarm == other.selfHarm && selfHarmInstructions == other.selfHarmInstructions && selfHarmIntent == other.selfHarmIntent && sexual == other.sexual && sexualMinors == other.sexualMinors && violence == other.violence && violenceGraphic == other.violenceGraphic && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(harassment, harassmentThreatening, hate, hateThreatening, illicit, illicitViolent, selfHarm, selfHarmInstructions, selfHarmIntent, sexual, sexualMinors, violence, violenceGraphic, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CategoryAppliedInputTypes{harassment=$harassment, harassmentThreatening=$harassmentThreatening, hate=$hate, hateThreatening=$hateThreatening, illicit=$illicit, illicitViolent=$illicitViolent, selfHarm=$selfHarm, selfHarmInstructions=$selfHarmInstructions, selfHarmIntent=$selfHarmIntent, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"
    }

    /** A list of the categories along with their scores as predicted by model. */
    @NoAutoDetect
    class CategoryScores
    @JsonCreator
    private constructor(
        @JsonProperty("harassment")
        @ExcludeMissing
        private val harassment: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        private val harassmentThreatening: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("hate")
        @ExcludeMissing
        private val hate: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        private val hateThreatening: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("illicit")
        @ExcludeMissing
        private val illicit: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        private val illicitViolent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("self-harm")
        @ExcludeMissing
        private val selfHarm: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        private val selfHarmInstructions: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        private val selfHarmIntent: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("sexual")
        @ExcludeMissing
        private val sexual: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        private val sexualMinors: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("violence")
        @ExcludeMissing
        private val violence: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        private val violenceGraphic: JsonField<Double> = JsonMissing.of(),
        @JsonAnySetter
        private val additionalProperties: Map<String, JsonValue> = immutableEmptyMap(),
    ) {

        /** The score for the category 'harassment'. */
        fun harassment(): Double = harassment.getRequired("harassment")

        /** The score for the category 'harassment/threatening'. */
        fun harassmentThreatening(): Double =
            harassmentThreatening.getRequired("harassment/threatening")

        /** The score for the category 'hate'. */
        fun hate(): Double = hate.getRequired("hate")

        /** The score for the category 'hate/threatening'. */
        fun hateThreatening(): Double = hateThreatening.getRequired("hate/threatening")

        /** The score for the category 'illicit'. */
        fun illicit(): Double = illicit.getRequired("illicit")

        /** The score for the category 'illicit/violent'. */
        fun illicitViolent(): Double = illicitViolent.getRequired("illicit/violent")

        /** The score for the category 'self-harm'. */
        fun selfHarm(): Double = selfHarm.getRequired("self-harm")

        /** The score for the category 'self-harm/instructions'. */
        fun selfHarmInstructions(): Double =
            selfHarmInstructions.getRequired("self-harm/instructions")

        /** The score for the category 'self-harm/intent'. */
        fun selfHarmIntent(): Double = selfHarmIntent.getRequired("self-harm/intent")

        /** The score for the category 'sexual'. */
        fun sexual(): Double = sexual.getRequired("sexual")

        /** The score for the category 'sexual/minors'. */
        fun sexualMinors(): Double = sexualMinors.getRequired("sexual/minors")

        /** The score for the category 'violence'. */
        fun violence(): Double = violence.getRequired("violence")

        /** The score for the category 'violence/graphic'. */
        fun violenceGraphic(): Double = violenceGraphic.getRequired("violence/graphic")

        /** The score for the category 'harassment'. */
        @JsonProperty("harassment")
        @ExcludeMissing
        fun _harassment(): JsonField<Double> = harassment

        /** The score for the category 'harassment/threatening'. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening(): JsonField<Double> = harassmentThreatening

        /** The score for the category 'hate'. */
        @JsonProperty("hate") @ExcludeMissing fun _hate(): JsonField<Double> = hate

        /** The score for the category 'hate/threatening'. */
        @JsonProperty("hate/threatening")
        @ExcludeMissing
        fun _hateThreatening(): JsonField<Double> = hateThreatening

        /** The score for the category 'illicit'. */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit(): JsonField<Double> = illicit

        /** The score for the category 'illicit/violent'. */
        @JsonProperty("illicit/violent")
        @ExcludeMissing
        fun _illicitViolent(): JsonField<Double> = illicitViolent

        /** The score for the category 'self-harm'. */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm(): JsonField<Double> = selfHarm

        /** The score for the category 'self-harm/instructions'. */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions(): JsonField<Double> = selfHarmInstructions

        /** The score for the category 'self-harm/intent'. */
        @JsonProperty("self-harm/intent")
        @ExcludeMissing
        fun _selfHarmIntent(): JsonField<Double> = selfHarmIntent

        /** The score for the category 'sexual'. */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual(): JsonField<Double> = sexual

        /** The score for the category 'sexual/minors'. */
        @JsonProperty("sexual/minors")
        @ExcludeMissing
        fun _sexualMinors(): JsonField<Double> = sexualMinors

        /** The score for the category 'violence'. */
        @JsonProperty("violence") @ExcludeMissing fun _violence(): JsonField<Double> = violence

        /** The score for the category 'violence/graphic'. */
        @JsonProperty("violence/graphic")
        @ExcludeMissing
        fun _violenceGraphic(): JsonField<Double> = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CategoryScores = apply {
            if (validated) {
                return@apply
            }

            harassment()
            harassmentThreatening()
            hate()
            hateThreatening()
            illicit()
            illicitViolent()
            selfHarm()
            selfHarmInstructions()
            selfHarmIntent()
            sexual()
            sexualMinors()
            violence()
            violenceGraphic()
            validated = true
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [CategoryScores]. */
        class Builder internal constructor() {

            private var harassment: JsonField<Double>? = null
            private var harassmentThreatening: JsonField<Double>? = null
            private var hate: JsonField<Double>? = null
            private var hateThreatening: JsonField<Double>? = null
            private var illicit: JsonField<Double>? = null
            private var illicitViolent: JsonField<Double>? = null
            private var selfHarm: JsonField<Double>? = null
            private var selfHarmInstructions: JsonField<Double>? = null
            private var selfHarmIntent: JsonField<Double>? = null
            private var sexual: JsonField<Double>? = null
            private var sexualMinors: JsonField<Double>? = null
            private var violence: JsonField<Double>? = null
            private var violenceGraphic: JsonField<Double>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryScores: CategoryScores) = apply {
                harassment = categoryScores.harassment
                harassmentThreatening = categoryScores.harassmentThreatening
                hate = categoryScores.hate
                hateThreatening = categoryScores.hateThreatening
                illicit = categoryScores.illicit
                illicitViolent = categoryScores.illicitViolent
                selfHarm = categoryScores.selfHarm
                selfHarmInstructions = categoryScores.selfHarmInstructions
                selfHarmIntent = categoryScores.selfHarmIntent
                sexual = categoryScores.sexual
                sexualMinors = categoryScores.sexualMinors
                violence = categoryScores.violence
                violenceGraphic = categoryScores.violenceGraphic
                additionalProperties = categoryScores.additionalProperties.toMutableMap()
            }

            /** The score for the category 'harassment'. */
            fun harassment(harassment: Double) = harassment(JsonField.of(harassment))

            /** The score for the category 'harassment'. */
            fun harassment(harassment: JsonField<Double>) = apply { this.harassment = harassment }

            /** The score for the category 'harassment/threatening'. */
            fun harassmentThreatening(harassmentThreatening: Double) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /** The score for the category 'harassment/threatening'. */
            fun harassmentThreatening(harassmentThreatening: JsonField<Double>) = apply {
                this.harassmentThreatening = harassmentThreatening
            }

            /** The score for the category 'hate'. */
            fun hate(hate: Double) = hate(JsonField.of(hate))

            /** The score for the category 'hate'. */
            fun hate(hate: JsonField<Double>) = apply { this.hate = hate }

            /** The score for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: Double) =
                hateThreatening(JsonField.of(hateThreatening))

            /** The score for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: JsonField<Double>) = apply {
                this.hateThreatening = hateThreatening
            }

            /** The score for the category 'illicit'. */
            fun illicit(illicit: Double) = illicit(JsonField.of(illicit))

            /** The score for the category 'illicit'. */
            fun illicit(illicit: JsonField<Double>) = apply { this.illicit = illicit }

            /** The score for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: Double) =
                illicitViolent(JsonField.of(illicitViolent))

            /** The score for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: JsonField<Double>) = apply {
                this.illicitViolent = illicitViolent
            }

            /** The score for the category 'self-harm'. */
            fun selfHarm(selfHarm: Double) = selfHarm(JsonField.of(selfHarm))

            /** The score for the category 'self-harm'. */
            fun selfHarm(selfHarm: JsonField<Double>) = apply { this.selfHarm = selfHarm }

            /** The score for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: Double) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /** The score for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: JsonField<Double>) = apply {
                this.selfHarmInstructions = selfHarmInstructions
            }

            /** The score for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: Double) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /** The score for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: JsonField<Double>) = apply {
                this.selfHarmIntent = selfHarmIntent
            }

            /** The score for the category 'sexual'. */
            fun sexual(sexual: Double) = sexual(JsonField.of(sexual))

            /** The score for the category 'sexual'. */
            fun sexual(sexual: JsonField<Double>) = apply { this.sexual = sexual }

            /** The score for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: Double) = sexualMinors(JsonField.of(sexualMinors))

            /** The score for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: JsonField<Double>) = apply {
                this.sexualMinors = sexualMinors
            }

            /** The score for the category 'violence'. */
            fun violence(violence: Double) = violence(JsonField.of(violence))

            /** The score for the category 'violence'. */
            fun violence(violence: JsonField<Double>) = apply { this.violence = violence }

            /** The score for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: Double) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** The score for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: JsonField<Double>) = apply {
                this.violenceGraphic = violenceGraphic
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

            fun build(): CategoryScores =
                CategoryScores(
                    checkRequired("harassment", harassment),
                    checkRequired("harassmentThreatening", harassmentThreatening),
                    checkRequired("hate", hate),
                    checkRequired("hateThreatening", hateThreatening),
                    checkRequired("illicit", illicit),
                    checkRequired("illicitViolent", illicitViolent),
                    checkRequired("selfHarm", selfHarm),
                    checkRequired("selfHarmInstructions", selfHarmInstructions),
                    checkRequired("selfHarmIntent", selfHarmIntent),
                    checkRequired("sexual", sexual),
                    checkRequired("sexualMinors", sexualMinors),
                    checkRequired("violence", violence),
                    checkRequired("violenceGraphic", violenceGraphic),
                    additionalProperties.toImmutable(),
                )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is CategoryScores && harassment == other.harassment && harassmentThreatening == other.harassmentThreatening && hate == other.hate && hateThreatening == other.hateThreatening && illicit == other.illicit && illicitViolent == other.illicitViolent && selfHarm == other.selfHarm && selfHarmInstructions == other.selfHarmInstructions && selfHarmIntent == other.selfHarmIntent && sexual == other.sexual && sexualMinors == other.sexualMinors && violence == other.violence && violenceGraphic == other.violenceGraphic && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(harassment, harassmentThreatening, hate, hateThreatening, illicit, illicitViolent, selfHarm, selfHarmInstructions, selfHarmIntent, sexual, sexualMinors, violence, violenceGraphic, additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "CategoryScores{harassment=$harassment, harassmentThreatening=$harassmentThreatening, hate=$hate, hateThreatening=$hateThreatening, illicit=$illicit, illicitViolent=$illicitViolent, selfHarm=$selfHarm, selfHarmInstructions=$selfHarmInstructions, selfHarmIntent=$selfHarmIntent, sexual=$sexual, sexualMinors=$sexualMinors, violence=$violence, violenceGraphic=$violenceGraphic, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is Moderation && categories == other.categories && categoryAppliedInputTypes == other.categoryAppliedInputTypes && categoryScores == other.categoryScores && flagged == other.flagged && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(categories, categoryAppliedInputTypes, categoryScores, flagged, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Moderation{categories=$categories, categoryAppliedInputTypes=$categoryAppliedInputTypes, categoryScores=$categoryScores, flagged=$flagged, additionalProperties=$additionalProperties}"
}
