// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.CheckpointService
import com.openai.services.blocking.finetuning.CheckpointServiceImpl
import com.openai.services.blocking.finetuning.JobService
import com.openai.services.blocking.finetuning.JobServiceImpl

class FineTuningServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningService {

    private val withRawResponse: FineTuningService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val jobs: JobService by lazy { JobServiceImpl(clientOptions) }

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    override fun withRawResponse(): FineTuningService.WithRawResponse = withRawResponse

    override fun jobs(): JobService = jobs

    override fun checkpoints(): CheckpointService = checkpoints

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FineTuningService.WithRawResponse {

        private val jobs: JobService.WithRawResponse by lazy {
            JobServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val checkpoints: CheckpointService.WithRawResponse by lazy {
            CheckpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun jobs(): JobService.WithRawResponse = jobs

        override fun checkpoints(): CheckpointService.WithRawResponse = checkpoints
    }
}
