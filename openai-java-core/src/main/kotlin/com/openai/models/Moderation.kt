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
import com.openai.core.immutableEmptyMap
import com.openai.core.toImmutable
import com.openai.errors.OpenAIInvalidDataException
import java.util.Objects

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
    @JsonProperty("categories") @ExcludeMissing fun _categories() = categories

    /** A list of the categories along with the input type(s) that the score applies to. */
    @JsonProperty("category_applied_input_types")
    @ExcludeMissing
    fun _categoryAppliedInputTypes() = categoryAppliedInputTypes

    /** A list of the categories along with their scores as predicted by model. */
    @JsonProperty("category_scores") @ExcludeMissing fun _categoryScores() = categoryScores

    /** Whether any of the below categories are flagged. */
    @JsonProperty("flagged") @ExcludeMissing fun _flagged() = flagged

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    private var validated: Boolean = false

    fun validate(): Moderation = apply {
        if (!validated) {
            categories().validate()
            categoryAppliedInputTypes().validate()
            categoryScores().validate()
            flagged()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var categories: JsonField<Categories> = JsonMissing.of()
        private var categoryAppliedInputTypes: JsonField<CategoryAppliedInputTypes> =
            JsonMissing.of()
        private var categoryScores: JsonField<CategoryScores> = JsonMissing.of()
        private var flagged: JsonField<Boolean> = JsonMissing.of()
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
                categories,
                categoryAppliedInputTypes,
                categoryScores,
                flagged,
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
        fun illicit(): Boolean = illicit.getRequired("illicit")

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing that also includes violence, or that gives advice or instruction on the
         * procurement of any weapon.
         */
        fun illicitViolent(): Boolean = illicitViolent.getRequired("illicit/violent")

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
        @JsonProperty("harassment") @ExcludeMissing fun _harassment() = harassment

        /** Harassment content that also includes violence or serious harm towards any target. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening() = harassmentThreatening

        /**
         * Content that expresses, incites, or promotes hate based on race, gender, ethnicity,
         * religion, nationality, sexual orientation, disability status, or caste. Hateful content
         * aimed at non-protected groups (e.g., chess players) is harassment.
         */
        @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

        /**
         * Hateful content that also includes violence or serious harm towards the targeted group
         * based on race, gender, ethnicity, religion, nationality, sexual orientation, disability
         * status, or caste.
         */
        @JsonProperty("hate/threatening") @ExcludeMissing fun _hateThreatening() = hateThreatening

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing, or that gives advice or instruction on how to commit illicit acts. For
         * example, "how to shoplift" would fit this category.
         */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit() = illicit

        /**
         * Content that includes instructions or advice that facilitate the planning or execution of
         * wrongdoing that also includes violence, or that gives advice or instruction on the
         * procurement of any weapon.
         */
        @JsonProperty("illicit/violent") @ExcludeMissing fun _illicitViolent() = illicitViolent

        /**
         * Content that promotes, encourages, or depicts acts of self-harm, such as suicide,
         * cutting, and eating disorders.
         */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

        /**
         * Content that encourages performing acts of self-harm, such as suicide, cutting, and
         * eating disorders, or that gives instructions or advice on how to commit such acts.
         */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions() = selfHarmInstructions

        /**
         * Content where the speaker expresses that they are engaging or intend to engage in acts of
         * self-harm, such as suicide, cutting, and eating disorders.
         */
        @JsonProperty("self-harm/intent") @ExcludeMissing fun _selfHarmIntent() = selfHarmIntent

        /**
         * Content meant to arouse sexual excitement, such as the description of sexual activity, or
         * that promotes sexual services (excluding sex education and wellness).
         */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

        /** Sexual content that includes an individual who is under 18 years old. */
        @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

        /** Content that depicts death, violence, or physical injury. */
        @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

        /** Content that depicts death, violence, or physical injury in graphic detail. */
        @JsonProperty("violence/graphic") @ExcludeMissing fun _violenceGraphic() = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): Categories = apply {
            if (!validated) {
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
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var harassment: JsonField<Boolean> = JsonMissing.of()
            private var harassmentThreatening: JsonField<Boolean> = JsonMissing.of()
            private var hate: JsonField<Boolean> = JsonMissing.of()
            private var hateThreatening: JsonField<Boolean> = JsonMissing.of()
            private var illicit: JsonField<Boolean> = JsonMissing.of()
            private var illicitViolent: JsonField<Boolean> = JsonMissing.of()
            private var selfHarm: JsonField<Boolean> = JsonMissing.of()
            private var selfHarmInstructions: JsonField<Boolean> = JsonMissing.of()
            private var selfHarmIntent: JsonField<Boolean> = JsonMissing.of()
            private var sexual: JsonField<Boolean> = JsonMissing.of()
            private var sexualMinors: JsonField<Boolean> = JsonMissing.of()
            private var violence: JsonField<Boolean> = JsonMissing.of()
            private var violenceGraphic: JsonField<Boolean> = JsonMissing.of()
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
            fun illicit(illicit: Boolean) = illicit(JsonField.of(illicit))

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
            fun illicitViolent(illicitViolent: Boolean) =
                illicitViolent(JsonField.of(illicitViolent))

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
                    harassment,
                    harassmentThreatening,
                    hate,
                    hateThreatening,
                    illicit,
                    illicitViolent,
                    selfHarm,
                    selfHarmInstructions,
                    selfHarmIntent,
                    sexual,
                    sexualMinors,
                    violence,
                    violenceGraphic,
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
        @JsonProperty("harassment") @ExcludeMissing fun _harassment() = harassment

        /** The applied input type(s) for the category 'harassment/threatening'. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening() = harassmentThreatening

        /** The applied input type(s) for the category 'hate'. */
        @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

        /** The applied input type(s) for the category 'hate/threatening'. */
        @JsonProperty("hate/threatening") @ExcludeMissing fun _hateThreatening() = hateThreatening

        /** The applied input type(s) for the category 'illicit'. */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit() = illicit

        /** The applied input type(s) for the category 'illicit/violent'. */
        @JsonProperty("illicit/violent") @ExcludeMissing fun _illicitViolent() = illicitViolent

        /** The applied input type(s) for the category 'self-harm'. */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

        /** The applied input type(s) for the category 'self-harm/instructions'. */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions() = selfHarmInstructions

        /** The applied input type(s) for the category 'self-harm/intent'. */
        @JsonProperty("self-harm/intent") @ExcludeMissing fun _selfHarmIntent() = selfHarmIntent

        /** The applied input type(s) for the category 'sexual'. */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

        /** The applied input type(s) for the category 'sexual/minors'. */
        @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

        /** The applied input type(s) for the category 'violence'. */
        @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

        /** The applied input type(s) for the category 'violence/graphic'. */
        @JsonProperty("violence/graphic") @ExcludeMissing fun _violenceGraphic() = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CategoryAppliedInputTypes = apply {
            if (!validated) {
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
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var harassment: JsonField<List<Harassment>> = JsonMissing.of()
            private var harassmentThreatening: JsonField<List<HarassmentThreatening>> =
                JsonMissing.of()
            private var hate: JsonField<List<Hate>> = JsonMissing.of()
            private var hateThreatening: JsonField<List<HateThreatening>> = JsonMissing.of()
            private var illicit: JsonField<List<Illicit>> = JsonMissing.of()
            private var illicitViolent: JsonField<List<IllicitViolent>> = JsonMissing.of()
            private var selfHarm: JsonField<List<SelfHarm>> = JsonMissing.of()
            private var selfHarmInstructions: JsonField<List<SelfHarmInstruction>> =
                JsonMissing.of()
            private var selfHarmIntent: JsonField<List<SelfHarmIntent>> = JsonMissing.of()
            private var sexual: JsonField<List<Sexual>> = JsonMissing.of()
            private var sexualMinors: JsonField<List<SexualMinor>> = JsonMissing.of()
            private var violence: JsonField<List<Violence>> = JsonMissing.of()
            private var violenceGraphic: JsonField<List<ViolenceGraphic>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(categoryAppliedInputTypes: CategoryAppliedInputTypes) = apply {
                harassment = categoryAppliedInputTypes.harassment
                harassmentThreatening = categoryAppliedInputTypes.harassmentThreatening
                hate = categoryAppliedInputTypes.hate
                hateThreatening = categoryAppliedInputTypes.hateThreatening
                illicit = categoryAppliedInputTypes.illicit
                illicitViolent = categoryAppliedInputTypes.illicitViolent
                selfHarm = categoryAppliedInputTypes.selfHarm
                selfHarmInstructions = categoryAppliedInputTypes.selfHarmInstructions
                selfHarmIntent = categoryAppliedInputTypes.selfHarmIntent
                sexual = categoryAppliedInputTypes.sexual
                sexualMinors = categoryAppliedInputTypes.sexualMinors
                violence = categoryAppliedInputTypes.violence
                violenceGraphic = categoryAppliedInputTypes.violenceGraphic
                additionalProperties = categoryAppliedInputTypes.additionalProperties.toMutableMap()
            }

            /** The applied input type(s) for the category 'harassment'. */
            fun harassment(harassment: List<Harassment>) = harassment(JsonField.of(harassment))

            /** The applied input type(s) for the category 'harassment'. */
            fun harassment(harassment: JsonField<List<Harassment>>) = apply {
                this.harassment = harassment
            }

            /** The applied input type(s) for the category 'harassment/threatening'. */
            fun harassmentThreatening(harassmentThreatening: List<HarassmentThreatening>) =
                harassmentThreatening(JsonField.of(harassmentThreatening))

            /** The applied input type(s) for the category 'harassment/threatening'. */
            fun harassmentThreatening(
                harassmentThreatening: JsonField<List<HarassmentThreatening>>
            ) = apply { this.harassmentThreatening = harassmentThreatening }

            /** The applied input type(s) for the category 'hate'. */
            fun hate(hate: List<Hate>) = hate(JsonField.of(hate))

            /** The applied input type(s) for the category 'hate'. */
            fun hate(hate: JsonField<List<Hate>>) = apply { this.hate = hate }

            /** The applied input type(s) for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: List<HateThreatening>) =
                hateThreatening(JsonField.of(hateThreatening))

            /** The applied input type(s) for the category 'hate/threatening'. */
            fun hateThreatening(hateThreatening: JsonField<List<HateThreatening>>) = apply {
                this.hateThreatening = hateThreatening
            }

            /** The applied input type(s) for the category 'illicit'. */
            fun illicit(illicit: List<Illicit>) = illicit(JsonField.of(illicit))

            /** The applied input type(s) for the category 'illicit'. */
            fun illicit(illicit: JsonField<List<Illicit>>) = apply { this.illicit = illicit }

            /** The applied input type(s) for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: List<IllicitViolent>) =
                illicitViolent(JsonField.of(illicitViolent))

            /** The applied input type(s) for the category 'illicit/violent'. */
            fun illicitViolent(illicitViolent: JsonField<List<IllicitViolent>>) = apply {
                this.illicitViolent = illicitViolent
            }

            /** The applied input type(s) for the category 'self-harm'. */
            fun selfHarm(selfHarm: List<SelfHarm>) = selfHarm(JsonField.of(selfHarm))

            /** The applied input type(s) for the category 'self-harm'. */
            fun selfHarm(selfHarm: JsonField<List<SelfHarm>>) = apply { this.selfHarm = selfHarm }

            /** The applied input type(s) for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: List<SelfHarmInstruction>) =
                selfHarmInstructions(JsonField.of(selfHarmInstructions))

            /** The applied input type(s) for the category 'self-harm/instructions'. */
            fun selfHarmInstructions(selfHarmInstructions: JsonField<List<SelfHarmInstruction>>) =
                apply {
                    this.selfHarmInstructions = selfHarmInstructions
                }

            /** The applied input type(s) for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: List<SelfHarmIntent>) =
                selfHarmIntent(JsonField.of(selfHarmIntent))

            /** The applied input type(s) for the category 'self-harm/intent'. */
            fun selfHarmIntent(selfHarmIntent: JsonField<List<SelfHarmIntent>>) = apply {
                this.selfHarmIntent = selfHarmIntent
            }

            /** The applied input type(s) for the category 'sexual'. */
            fun sexual(sexual: List<Sexual>) = sexual(JsonField.of(sexual))

            /** The applied input type(s) for the category 'sexual'. */
            fun sexual(sexual: JsonField<List<Sexual>>) = apply { this.sexual = sexual }

            /** The applied input type(s) for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: List<SexualMinor>) =
                sexualMinors(JsonField.of(sexualMinors))

            /** The applied input type(s) for the category 'sexual/minors'. */
            fun sexualMinors(sexualMinors: JsonField<List<SexualMinor>>) = apply {
                this.sexualMinors = sexualMinors
            }

            /** The applied input type(s) for the category 'violence'. */
            fun violence(violence: List<Violence>) = violence(JsonField.of(violence))

            /** The applied input type(s) for the category 'violence'. */
            fun violence(violence: JsonField<List<Violence>>) = apply { this.violence = violence }

            /** The applied input type(s) for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: List<ViolenceGraphic>) =
                violenceGraphic(JsonField.of(violenceGraphic))

            /** The applied input type(s) for the category 'violence/graphic'. */
            fun violenceGraphic(violenceGraphic: JsonField<List<ViolenceGraphic>>) = apply {
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

            fun build(): CategoryAppliedInputTypes =
                CategoryAppliedInputTypes(
                    harassment.map { it.toImmutable() },
                    harassmentThreatening.map { it.toImmutable() },
                    hate.map { it.toImmutable() },
                    hateThreatening.map { it.toImmutable() },
                    illicit.map { it.toImmutable() },
                    illicitViolent.map { it.toImmutable() },
                    selfHarm.map { it.toImmutable() },
                    selfHarmInstructions.map { it.toImmutable() },
                    selfHarmIntent.map { it.toImmutable() },
                    sexual.map { it.toImmutable() },
                    sexualMinors.map { it.toImmutable() },
                    violence.map { it.toImmutable() },
                    violenceGraphic.map { it.toImmutable() },
                    additionalProperties.toImmutable(),
                )
        }

        class Harassment
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Harassment(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = HarassmentThreatening(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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

        class Hate
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Hate(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = HateThreatening(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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

        class Illicit
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = Illicit(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = IllicitViolent(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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

        class SelfHarm
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarm(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarmInstruction(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = SelfHarmIntent(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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

        class Sexual
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = Sexual(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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

        class SexualMinor
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmStatic fun of(value: String) = SexualMinor(JsonField.of(value))
            }

            enum class Known {
                TEXT,
            }

            enum class Value {
                TEXT,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    else -> Value._UNKNOWN
                }

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

        class Violence
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = Violence(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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
        private constructor(
            private val value: JsonField<String>,
        ) : Enum {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val TEXT = of("text")

                @JvmField val IMAGE = of("image")

                @JvmStatic fun of(value: String) = ViolenceGraphic(JsonField.of(value))
            }

            enum class Known {
                TEXT,
                IMAGE,
            }

            enum class Value {
                TEXT,
                IMAGE,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    TEXT -> Value.TEXT
                    IMAGE -> Value.IMAGE
                    else -> Value._UNKNOWN
                }

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
        @JsonProperty("harassment") @ExcludeMissing fun _harassment() = harassment

        /** The score for the category 'harassment/threatening'. */
        @JsonProperty("harassment/threatening")
        @ExcludeMissing
        fun _harassmentThreatening() = harassmentThreatening

        /** The score for the category 'hate'. */
        @JsonProperty("hate") @ExcludeMissing fun _hate() = hate

        /** The score for the category 'hate/threatening'. */
        @JsonProperty("hate/threatening") @ExcludeMissing fun _hateThreatening() = hateThreatening

        /** The score for the category 'illicit'. */
        @JsonProperty("illicit") @ExcludeMissing fun _illicit() = illicit

        /** The score for the category 'illicit/violent'. */
        @JsonProperty("illicit/violent") @ExcludeMissing fun _illicitViolent() = illicitViolent

        /** The score for the category 'self-harm'. */
        @JsonProperty("self-harm") @ExcludeMissing fun _selfHarm() = selfHarm

        /** The score for the category 'self-harm/instructions'. */
        @JsonProperty("self-harm/instructions")
        @ExcludeMissing
        fun _selfHarmInstructions() = selfHarmInstructions

        /** The score for the category 'self-harm/intent'. */
        @JsonProperty("self-harm/intent") @ExcludeMissing fun _selfHarmIntent() = selfHarmIntent

        /** The score for the category 'sexual'. */
        @JsonProperty("sexual") @ExcludeMissing fun _sexual() = sexual

        /** The score for the category 'sexual/minors'. */
        @JsonProperty("sexual/minors") @ExcludeMissing fun _sexualMinors() = sexualMinors

        /** The score for the category 'violence'. */
        @JsonProperty("violence") @ExcludeMissing fun _violence() = violence

        /** The score for the category 'violence/graphic'. */
        @JsonProperty("violence/graphic") @ExcludeMissing fun _violenceGraphic() = violenceGraphic

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        private var validated: Boolean = false

        fun validate(): CategoryScores = apply {
            if (!validated) {
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
        }

        fun toBuilder() = Builder().from(this)

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var harassment: JsonField<Double> = JsonMissing.of()
            private var harassmentThreatening: JsonField<Double> = JsonMissing.of()
            private var hate: JsonField<Double> = JsonMissing.of()
            private var hateThreatening: JsonField<Double> = JsonMissing.of()
            private var illicit: JsonField<Double> = JsonMissing.of()
            private var illicitViolent: JsonField<Double> = JsonMissing.of()
            private var selfHarm: JsonField<Double> = JsonMissing.of()
            private var selfHarmInstructions: JsonField<Double> = JsonMissing.of()
            private var selfHarmIntent: JsonField<Double> = JsonMissing.of()
            private var sexual: JsonField<Double> = JsonMissing.of()
            private var sexualMinors: JsonField<Double> = JsonMissing.of()
            private var violence: JsonField<Double> = JsonMissing.of()
            private var violenceGraphic: JsonField<Double> = JsonMissing.of()
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
                    harassment,
                    harassmentThreatening,
                    hate,
                    hateThreatening,
                    illicit,
                    illicitViolent,
                    selfHarm,
                    selfHarmInstructions,
                    selfHarmIntent,
                    sexual,
                    sexualMinors,
                    violence,
                    violenceGraphic,
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
