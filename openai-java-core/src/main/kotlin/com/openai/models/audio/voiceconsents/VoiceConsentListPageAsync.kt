// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.audio.VoiceConsentServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see VoiceConsentServiceAsync.list */
class VoiceConsentListPageAsync
private constructor(
    private val service: VoiceConsentServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: VoiceConsentListParams,
    private val response: VoiceConsentListPageResponse,
) : PageAsync<VoiceConsent> {

    /** @see VoiceConsentListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<VoiceConsent> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see VoiceConsentListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<VoiceConsent> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): VoiceConsentListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<VoiceConsentListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<VoiceConsent> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): VoiceConsentListParams = params

    /** The response that this page was parsed from. */
    fun response(): VoiceConsentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VoiceConsentListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceConsentListPageAsync]. */
    class Builder internal constructor() {

        private var service: VoiceConsentServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: VoiceConsentListParams? = null
        private var response: VoiceConsentListPageResponse? = null

        @JvmSynthetic
        internal fun from(voiceConsentListPageAsync: VoiceConsentListPageAsync) = apply {
            service = voiceConsentListPageAsync.service
            streamHandlerExecutor = voiceConsentListPageAsync.streamHandlerExecutor
            params = voiceConsentListPageAsync.params
            response = voiceConsentListPageAsync.response
        }

        fun service(service: VoiceConsentServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: VoiceConsentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VoiceConsentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VoiceConsentListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VoiceConsentListPageAsync =
            VoiceConsentListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceConsentListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "VoiceConsentListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
