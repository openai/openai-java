// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.alpha.GraderService
import com.openai.services.blocking.finetuning.alpha.GraderServiceImpl
import java.util.function.Consumer

class AlphaServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AlphaService {

    private val withRawResponse: AlphaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val graders: GraderService by lazy { GraderServiceImpl(clientOptions) }

    override fun withRawResponse(): AlphaService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlphaService =
        AlphaServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun graders(): GraderService = graders

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AlphaService.WithRawResponse {

        private val graders: GraderService.WithRawResponse by lazy {
            GraderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlphaService.WithRawResponse =
            AlphaServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun graders(): GraderService.WithRawResponse = graders
    }
}
