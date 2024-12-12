// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.blocking.BatchService
import com.openai.services.blocking.BatchServiceImpl
import com.openai.services.blocking.ChatService
import com.openai.services.blocking.ChatServiceImpl
import com.openai.services.blocking.CompletionService
import com.openai.services.blocking.CompletionServiceImpl
import com.openai.services.blocking.EmbeddingService
import com.openai.services.blocking.EmbeddingServiceImpl
import com.openai.services.blocking.FileService
import com.openai.services.blocking.FileServiceImpl
import com.openai.services.blocking.FineTuningService
import com.openai.services.blocking.FineTuningServiceImpl
import com.openai.services.blocking.ImageService
import com.openai.services.blocking.ImageServiceImpl
import com.openai.services.blocking.ModelService
import com.openai.services.blocking.ModelServiceImpl
import com.openai.services.blocking.ModerationService
import com.openai.services.blocking.ModerationServiceImpl
import com.openai.services.blocking.UploadService
import com.openai.services.blocking.UploadServiceImpl

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
