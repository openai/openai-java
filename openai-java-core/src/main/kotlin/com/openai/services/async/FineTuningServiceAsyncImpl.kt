// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.finetuning.AlphaServiceAsync
import com.openai.services.async.finetuning.AlphaServiceAsyncImpl
import com.openai.services.async.finetuning.CheckpointServiceAsync
import com.openai.services.async.finetuning.CheckpointServiceAsyncImpl
import com.openai.services.async.finetuning.JobServiceAsync
import com.openai.services.async.finetuning.JobServiceAsyncImpl
import com.openai.services.async.finetuning.MethodServiceAsync
import com.openai.services.async.finetuning.MethodServiceAsyncImpl
import java.util.function.Consumer

class FineTuningServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningServiceAsync {

    private val withRawResponse: FineTuningServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val methods: MethodServiceAsync by lazy { MethodServiceAsyncImpl(clientOptions) }

    private val jobs: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    private val checkpoints: CheckpointServiceAsync by lazy {
        CheckpointServiceAsyncImpl(clientOptions)
    }

    private val alpha: AlphaServiceAsync by lazy { AlphaServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): FineTuningServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FineTuningServiceAsync =
        FineTuningServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun methods(): MethodServiceAsync = methods

    override fun jobs(): JobServiceAsync = jobs

    override fun checkpoints(): CheckpointServiceAsync = checkpoints

    override fun alpha(): AlphaServiceAsync = alpha

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FineTuningServiceAsync.WithRawResponse {

        private val methods: MethodServiceAsync.WithRawResponse by lazy {
            MethodServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val jobs: JobServiceAsync.WithRawResponse by lazy {
            JobServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val checkpoints: CheckpointServiceAsync.WithRawResponse by lazy {
            CheckpointServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val alpha: AlphaServiceAsync.WithRawResponse by lazy {
            AlphaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FineTuningServiceAsync.WithRawResponse =
            FineTuningServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun methods(): MethodServiceAsync.WithRawResponse = methods

        override fun jobs(): JobServiceAsync.WithRawResponse = jobs

        override fun checkpoints(): CheckpointServiceAsync.WithRawResponse = checkpoints

        override fun alpha(): AlphaServiceAsync.WithRawResponse = alpha
    }
}
