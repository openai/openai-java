// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.audio.voiceconsents

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.audio.VoiceConsentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see VoiceConsentService.list */
class VoiceConsentListPage
private constructor(
    private val service: VoiceConsentService,
    private val params: VoiceConsentListParams,
    private val response: VoiceConsentListPageResponse,
) : Page<VoiceConsent> {

    /**
     * Delegates to [VoiceConsentListPageResponse], but gracefully handles missing data.
     *
     * @see VoiceConsentListPageResponse.data
     */
    fun data(): List<VoiceConsent> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VoiceConsentListPageResponse], but gracefully handles missing data.
     *
     * @see VoiceConsentListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<VoiceConsent> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): VoiceConsentListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): VoiceConsentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<VoiceConsent> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): VoiceConsentListParams = params

    /** The response that this page was parsed from. */
    fun response(): VoiceConsentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VoiceConsentListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VoiceConsentListPage]. */
    class Builder internal constructor() {

        private var service: VoiceConsentService? = null
        private var params: VoiceConsentListParams? = null
        private var response: VoiceConsentListPageResponse? = null

        @JvmSynthetic
        internal fun from(voiceConsentListPage: VoiceConsentListPage) = apply {
            service = voiceConsentListPage.service
            params = voiceConsentListPage.params
            response = voiceConsentListPage.response
        }

        fun service(service: VoiceConsentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VoiceConsentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VoiceConsentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VoiceConsentListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): VoiceConsentListPage =
            VoiceConsentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VoiceConsentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "VoiceConsentListPage{service=$service, params=$params, response=$response}"
}
