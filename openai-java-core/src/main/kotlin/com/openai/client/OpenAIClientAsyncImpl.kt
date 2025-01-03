// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.BatchServiceAsyncImpl
import com.openai.services.async.BetaServiceAsync
import com.openai.services.async.BetaServiceAsyncImpl
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.ChatServiceAsyncImpl
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.CompletionServiceAsyncImpl
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.EmbeddingServiceAsyncImpl
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FileServiceAsyncImpl
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.FineTuningServiceAsyncImpl
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ImageServiceAsyncImpl
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModelServiceAsyncImpl
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.ModerationServiceAsyncImpl
import com.openai.services.async.UploadServiceAsync
import com.openai.services.async.UploadServiceAsyncImpl

class OpenAIClientAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: OpenAIClient by lazy { OpenAIClientImpl(clientOptions) }

    private val completions: CompletionServiceAsync by lazy {
        CompletionServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val chat: ChatServiceAsync by lazy { ChatServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val embeddings: EmbeddingServiceAsync by lazy {
        EmbeddingServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val files: FileServiceAsync by lazy { FileServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val images: ImageServiceAsync by lazy {
        ImageServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val moderations: ModerationServiceAsync by lazy {
        ModerationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val models: ModelServiceAsync by lazy {
        ModelServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val fineTuning: FineTuningServiceAsync by lazy {
        FineTuningServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val beta: BetaServiceAsync by lazy { BetaServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val batches: BatchServiceAsync by lazy {
        BatchServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val uploads: UploadServiceAsync by lazy {
        UploadServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): OpenAIClient = sync

    override fun completions(): CompletionServiceAsync = completions

    override fun chat(): ChatServiceAsync = chat

    override fun embeddings(): EmbeddingServiceAsync = embeddings

    override fun files(): FileServiceAsync = files

    override fun images(): ImageServiceAsync = images

    override fun moderations(): ModerationServiceAsync = moderations

    override fun models(): ModelServiceAsync = models

    override fun fineTuning(): FineTuningServiceAsync = fineTuning

    override fun beta(): BetaServiceAsync = beta

    override fun batches(): BatchServiceAsync = batches

    override fun uploads(): UploadServiceAsync = uploads
}
