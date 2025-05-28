// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.AlphaService
import com.openai.services.blocking.finetuning.AlphaServiceImpl
import com.openai.services.blocking.finetuning.CheckpointService
import com.openai.services.blocking.finetuning.CheckpointServiceImpl
import com.openai.services.blocking.finetuning.JobService
import com.openai.services.blocking.finetuning.JobServiceImpl
import com.openai.services.blocking.finetuning.MethodService
import com.openai.services.blocking.finetuning.MethodServiceImpl

class FineTuningServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningService {

    private val withRawResponse: FineTuningService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val methods: MethodService by lazy { MethodServiceImpl(clientOptions) }

    private val jobs: JobService by lazy { JobServiceImpl(clientOptions) }

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    private val alpha: AlphaService by lazy { AlphaServiceImpl(clientOptions) }

    override fun withRawResponse(): FineTuningService.WithRawResponse = withRawResponse

    override fun methods(): MethodService = methods

    override fun jobs(): JobService = jobs

    override fun checkpoints(): CheckpointService = checkpoints

    override fun alpha(): AlphaService = alpha

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FineTuningService.WithRawResponse {

        private val methods: MethodService.WithRawResponse by lazy {
            MethodServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val jobs: JobService.WithRawResponse by lazy {
            JobServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val checkpoints: CheckpointService.WithRawResponse by lazy {
            CheckpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val alpha: AlphaService.WithRawResponse by lazy {
            AlphaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun methods(): MethodService.WithRawResponse = methods

        override fun jobs(): JobService.WithRawResponse = jobs

        override fun checkpoints(): CheckpointService.WithRawResponse = checkpoints

        override fun alpha(): AlphaService.WithRawResponse = alpha
    }
}
