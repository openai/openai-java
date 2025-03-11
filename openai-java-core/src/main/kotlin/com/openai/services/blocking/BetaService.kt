// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.ThreadService

interface BetaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun assistants(): AssistantService

    fun threads(): ThreadService

    /** A view of [BetaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun assistants(): AssistantService.WithRawResponse

        fun threads(): ThreadService.WithRawResponse
    }
}
