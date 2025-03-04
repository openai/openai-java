// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.blocking.AudioService
import com.openai.services.blocking.AudioServiceImpl
import com.openai.services.blocking.BatchService
import com.openai.services.blocking.BatchServiceImpl
import com.openai.services.blocking.BetaService
import com.openai.services.blocking.BetaServiceImpl
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

class OpenAIClientImpl(private val clientOptions: ClientOptions) : OpenAIClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: OpenAIClientAsync by lazy { OpenAIClientAsyncImpl(clientOptions) }

    private val withRawResponse: OpenAIClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val completions: CompletionService by lazy {
        CompletionServiceImpl(clientOptionsWithUserAgent)
    }

    private val chat: ChatService by lazy { ChatServiceImpl(clientOptionsWithUserAgent) }

    private val embeddings: EmbeddingService by lazy {
        EmbeddingServiceImpl(clientOptionsWithUserAgent)
    }

    private val files: FileService by lazy { FileServiceImpl(clientOptionsWithUserAgent) }

    private val images: ImageService by lazy { ImageServiceImpl(clientOptionsWithUserAgent) }

    private val audio: AudioService by lazy { AudioServiceImpl(clientOptionsWithUserAgent) }

    private val moderations: ModerationService by lazy {
        ModerationServiceImpl(clientOptionsWithUserAgent)
    }

    private val models: ModelService by lazy { ModelServiceImpl(clientOptionsWithUserAgent) }

    private val fineTuning: FineTuningService by lazy {
        FineTuningServiceImpl(clientOptionsWithUserAgent)
    }

    private val beta: BetaService by lazy { BetaServiceImpl(clientOptionsWithUserAgent) }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptionsWithUserAgent) }

    private val uploads: UploadService by lazy { UploadServiceImpl(clientOptionsWithUserAgent) }

    override fun async(): OpenAIClientAsync = async

    override fun withRawResponse(): OpenAIClient.WithRawResponse = withRawResponse

    override fun completions(): CompletionService = completions

    override fun chat(): ChatService = chat

    override fun embeddings(): EmbeddingService = embeddings

    override fun files(): FileService = files

    override fun images(): ImageService = images

    override fun audio(): AudioService = audio

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTuning(): FineTuningService = fineTuning

    override fun beta(): BetaService = beta

    override fun batches(): BatchService = batches

    override fun uploads(): UploadService = uploads

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OpenAIClient.WithRawResponse {

        private val completions: CompletionService.WithRawResponse by lazy {
            CompletionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val chat: ChatService.WithRawResponse by lazy {
            ChatServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val embeddings: EmbeddingService.WithRawResponse by lazy {
            EmbeddingServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileService.WithRawResponse by lazy {
            FileServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val images: ImageService.WithRawResponse by lazy {
            ImageServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val audio: AudioService.WithRawResponse by lazy {
            AudioServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val moderations: ModerationService.WithRawResponse by lazy {
            ModerationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val models: ModelService.WithRawResponse by lazy {
            ModelServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val fineTuning: FineTuningService.WithRawResponse by lazy {
            FineTuningServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val beta: BetaService.WithRawResponse by lazy {
            BetaServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val batches: BatchService.WithRawResponse by lazy {
            BatchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val uploads: UploadService.WithRawResponse by lazy {
            UploadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun completions(): CompletionService.WithRawResponse = completions

        override fun chat(): ChatService.WithRawResponse = chat

        override fun embeddings(): EmbeddingService.WithRawResponse = embeddings

        override fun files(): FileService.WithRawResponse = files

        override fun images(): ImageService.WithRawResponse = images

        override fun audio(): AudioService.WithRawResponse = audio

        override fun moderations(): ModerationService.WithRawResponse = moderations

        override fun models(): ModelService.WithRawResponse = models

        override fun fineTuning(): FineTuningService.WithRawResponse = fineTuning

        override fun beta(): BetaService.WithRawResponse = beta

        override fun batches(): BatchService.WithRawResponse = batches

        override fun uploads(): UploadService.WithRawResponse = uploads
    }
}
