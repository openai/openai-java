// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.finetuning.CheckpointServiceAsync
import com.openai.services.async.finetuning.CheckpointServiceAsyncImpl
import com.openai.services.async.finetuning.JobServiceAsync
import com.openai.services.async.finetuning.JobServiceAsyncImpl

class FineTuningServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningServiceAsync {

    private val withRawResponse: FineTuningServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val jobs: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    private val checkpoints: CheckpointServiceAsync by lazy {
        CheckpointServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): FineTuningServiceAsync.WithRawResponse = withRawResponse

    override fun jobs(): JobServiceAsync = jobs

    override fun checkpoints(): CheckpointServiceAsync = checkpoints

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FineTuningServiceAsync.WithRawResponse {

        private val jobs: JobServiceAsync.WithRawResponse by lazy {
            JobServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val checkpoints: CheckpointServiceAsync.WithRawResponse by lazy {
            CheckpointServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun jobs(): JobServiceAsync.WithRawResponse = jobs

        override fun checkpoints(): CheckpointServiceAsync.WithRawResponse = checkpoints
    }
}
