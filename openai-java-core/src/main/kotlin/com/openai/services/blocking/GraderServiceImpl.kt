// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.graders.GraderModelService
import com.openai.services.blocking.graders.GraderModelServiceImpl
import java.util.function.Consumer

class GraderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderService {

    private val withRawResponse: GraderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val graderModels: GraderModelService by lazy { GraderModelServiceImpl(clientOptions) }

    override fun withRawResponse(): GraderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService =
        GraderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun graderModels(): GraderModelService = graderModels

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderService.WithRawResponse {

        private val graderModels: GraderModelService.WithRawResponse by lazy {
            GraderModelServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderService.WithRawResponse =
            GraderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun graderModels(): GraderModelService.WithRawResponse = graderModels
    }
}
