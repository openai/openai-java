// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.graders

import com.openai.core.ClientOptions

class GraderModelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderModelService {

    private val withRawResponse: GraderModelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderModelService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderModelService.WithRawResponse
}
