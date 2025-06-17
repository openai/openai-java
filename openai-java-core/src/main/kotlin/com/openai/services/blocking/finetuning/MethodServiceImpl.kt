// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions
import java.util.function.Consumer

class MethodServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    MethodService {

    private val withRawResponse: MethodService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): MethodService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): MethodService =
        MethodServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        MethodService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): MethodService.WithRawResponse =
            MethodServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
