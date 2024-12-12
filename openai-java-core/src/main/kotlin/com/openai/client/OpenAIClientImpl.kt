// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.blocking.*

class OpenAIClientImpl
constructor(
    private val clientOptions: ClientOptions,
) : OpenAIClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: OpenAIClientAsync by lazy { OpenAIClientAsyncImpl(clientOptions) }

    private val completions: CompletionService by lazy {
        CompletionServiceImpl(clientOptionsWithUserAgent)
    }

    private val chat: ChatService by lazy { ChatServiceImpl(clientOptionsWithUserAgent) }

    private val embeddings: EmbeddingService by lazy {
        EmbeddingServiceImpl(clientOptionsWithUserAgent)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptionsWithUserAgent) }

    private val images: ImageService by lazy { ImageServiceImpl(clientOptionsWithUserAgent) }

    private val moderations: ModerationService by lazy {
        ModerationServiceImpl(clientOptionsWithUserAgent)
    }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptionsWithUserAgent) }

    private val fineTuning: FineTuningService by lazy {
        FineTuningServiceImpl(clientOptionsWithUserAgent)
    }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptionsWithUserAgent) }

    private val uploads: UploadService by lazy { UploadServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): OpenAIClientAsync = async

    override fun completions(): CompletionService = completions

    override fun chat(): ChatService = chat

    override fun embeddings(): EmbeddingService = embeddings

    override fun files(): FileService = files

    override fun images(): ImageService = images

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTuning(): FineTuningService = fineTuning

    override fun batches(): BatchService = batches

    override fun uploads(): UploadService = uploads
}
