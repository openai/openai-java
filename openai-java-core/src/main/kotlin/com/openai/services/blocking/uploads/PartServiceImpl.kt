// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.uploads

import com.openai.core.ClientOptions

class PartServiceImpl internal constructor(private val clientOptions: ClientOptions) : PartService {

    private val withRawResponse: PartService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): PartService.WithRawResponse = withRawResponse

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        PartService.WithRawResponse
}
