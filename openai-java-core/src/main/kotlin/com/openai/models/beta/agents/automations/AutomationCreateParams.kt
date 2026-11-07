// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.openai.core.Params
import com.openai.core.checkRequired
import com.openai.core.http.Headers
import com.openai.core.http.QueryParams
import java.util.Objects

/** Saves an active automation without invoking it immediately. */
class AutomationCreateParams
private constructor(
    private val automationScheduleParam: AutomationScheduleParam,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /** Creates an automation without invoking it immediately. */
    fun automationScheduleParam(): AutomationScheduleParam = automationScheduleParam

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AutomationCreateParams].
         *
         * The following fields are required:
         * ```java
         * .automationScheduleParam()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [AutomationCreateParams]. */
    class Builder internal constructor() {

        private var automationScheduleParam: AutomationScheduleParam? = null
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(automationCreateParams: AutomationCreateParams) = apply {
            automationScheduleParam = automationCreateParams.automationScheduleParam
            additionalHeaders = automationCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = automationCreateParams.additionalQueryParams.toBuilder()
        }

        /** Creates an automation without invoking it immediately. */
        fun automationScheduleParam(automationScheduleParam: AutomationScheduleParam) = apply {
            this.automationScheduleParam = automationScheduleParam
        }

        /**
         * Alias for calling [automationScheduleParam] with
         * `AutomationScheduleParam.ofPeriodic(periodic)`.
         */
        fun automationScheduleParam(periodic: AutomationScheduleParam.Periodic) =
            automationScheduleParam(AutomationScheduleParam.ofPeriodic(periodic))

        /**
         * Alias for calling [automationScheduleParam] with `AutomationScheduleParam.ofOnce(once)`.
         */
        fun automationScheduleParam(once: AutomationScheduleParam.Once) =
            automationScheduleParam(AutomationScheduleParam.ofOnce(once))

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
         * Returns an immutable instance of [AutomationCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .automationScheduleParam()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): AutomationCreateParams =
            AutomationCreateParams(
                checkRequired("automationScheduleParam", automationScheduleParam),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): AutomationScheduleParam = automationScheduleParam

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AutomationCreateParams &&
            automationScheduleParam == other.automationScheduleParam &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(automationScheduleParam, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "AutomationCreateParams{automationScheduleParam=$automationScheduleParam, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
