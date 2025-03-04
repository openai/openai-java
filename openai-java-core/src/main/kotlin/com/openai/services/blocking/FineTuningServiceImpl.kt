// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.fineTuning.JobService
import com.openai.services.blocking.fineTuning.JobServiceImpl

class FineTuningServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningService {

    private val withRawResponse: FineTuningService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val jobs: JobService by lazy { JobServiceImpl(clientOptions) }

    override fun withRawResponse(): FineTuningService.WithRawResponse = withRawResponse

    override fun jobs(): JobService = jobs

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FineTuningService.WithRawResponse {

        private val jobs: JobService.WithRawResponse by lazy {
            JobServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun jobs(): JobService.WithRawResponse = jobs
    }
}
