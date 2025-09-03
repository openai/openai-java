// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.openai.core.JsonField
import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.core.jsonSchemaFromClass
import java.util.Objects
import java.util.Optional

/**
 * A wrapper for [ResponseTextConfig] that provides a type-safe [Builder] that can record the
 * [responseType] used to derive a JSON schema from an arbitrary class when using the _Structured
 * Outputs_ feature. When a JSON response is received, it is deserialized to an instance of that
 * type. See the SDK documentation for more details on _Structured Outputs_.
 *
 * @param T The type of the class that will be used to derive the JSON schema in the request and to
 *   which the JSON response will be deserialized.
 */
class StructuredResponseTextConfig<T : Any>
private constructor(
    @get:JvmName("responseType") val responseType: Class<T>,
    /**
     * The raw, underlying response text configuration wrapped by this structured instance of the
     * configuration.
     */
    @get:JvmName("rawConfig") val rawConfig: ResponseTextConfig,
) {
    companion object {
        /**
         * Returns a mutable builder for constructing an instance of [StructuredResponseTextConfig].
         */
        @JvmStatic fun <T : Any> builder() = Builder<T>()
    }

    /** A builder for [StructuredResponseTextConfig]. */
    class Builder<T : Any> internal constructor() {
        private var responseType: Class<T>? = null
        private var configBuilder = ResponseTextConfig.builder()

        @JvmSynthetic
        internal fun wrap(
            responseType: Class<T>,
            configBuilder: ResponseTextConfig.Builder,
            localValidation: JsonSchemaLocalValidation,
        ) = apply {
            this.responseType = responseType
            this.configBuilder = configBuilder
            format(responseType, localValidation)
        }

        /** Injects a given `ResponseTextConfig.Builder`. For use only when testing. */
        @JvmSynthetic
        internal fun inject(configBuilder: ResponseTextConfig.Builder) = apply {
            this.configBuilder = configBuilder
        }

        /**
         * Sets the text configuration's format to a JSON schema derived from the structure of the
         * given class.
         *
         * @see ResponseTextConfig.Builder.format
         */
        @JvmOverloads
        fun format(
            responseType: Class<T>,
            localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
        ) = apply {
            this.responseType = responseType
            configBuilder.format(jsonSchemaFromClass(responseType, localValidation))
        }

        /** @see ResponseTextConfig.Builder.verbosity */
        fun verbosity(verbosity: ResponseTextConfig.Verbosity?) = apply {
            configBuilder.verbosity(verbosity)
        }

        /** @see ResponseTextConfig.Builder.verbosity */
        fun verbosity(verbosity: Optional<ResponseTextConfig.Verbosity>) = apply {
            configBuilder.verbosity(verbosity)
        }

        /** @see ResponseTextConfig.Builder.verbosity */
        fun verbosity(verbosity: JsonField<ResponseTextConfig.Verbosity>) = apply {
            configBuilder.verbosity(verbosity)
        }

        /** @see ResponseTextConfig.Builder.additionalProperties */
        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            configBuilder.additionalProperties(additionalProperties)
        }

        /** @see ResponseTextConfig.Builder.putAdditionalProperty */
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            configBuilder.putAdditionalProperty(key, value)
        }

        /** @see ResponseTextConfig.Builder.putAllAdditionalProperties */
        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            configBuilder.putAllAdditionalProperties(additionalProperties)
        }

        /** @see ResponseTextConfig.Builder.removeAdditionalProperty */
        fun removeAdditionalProperty(key: String) = apply {
            configBuilder.removeAdditionalProperty(key)
        }

        /** @see ResponseTextConfig.Builder.removeAllAdditionalProperties */
        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            configBuilder.removeAllAdditionalProperties(keys)
        }

        /**
         * Returns an immutable instance of [StructuredResponseTextConfig].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): StructuredResponseTextConfig<T> =
            StructuredResponseTextConfig<T>(
                checkRequired("responseType", responseType),
                configBuilder.build(),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is StructuredResponseTextConfig<*> &&
            responseType == other.responseType &&
            rawConfig == other.rawConfig
    }

    private val hashCode: Int by lazy { Objects.hash(responseType, rawConfig) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "${javaClass.simpleName}{responseType=$responseType, rawConfig=$rawConfig}"
}
