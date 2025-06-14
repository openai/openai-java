// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.graders

import com.openai.core.ClientOptions
import java.util.function.Consumer

class GraderModelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderModelService {

    private val withRawResponse: GraderModelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderModelService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderModelService =
        GraderModelServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderModelService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderModelService.WithRawResponse =
            GraderModelServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
