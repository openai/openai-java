// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.async.*

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

    override fun batches(): BatchServiceAsync = batches

    override fun uploads(): UploadServiceAsync = uploads
}
