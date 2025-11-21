// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions
import com.openai.core.withCancellation
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CheckpointServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointServiceAsync {

    private val withRawResponse: CheckpointServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val permissions: PermissionServiceAsync by lazy {
        PermissionServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): CheckpointServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckpointServiceAsync =
        CheckpointServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun permissions(): PermissionServiceAsync = permissions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckpointServiceAsync.WithRawResponse {

        private val permissions: PermissionServiceAsync.WithRawResponse by lazy {
            PermissionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckpointServiceAsync.WithRawResponse =
            CheckpointServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun permissions(): PermissionServiceAsync.WithRawResponse = permissions
    }
}
