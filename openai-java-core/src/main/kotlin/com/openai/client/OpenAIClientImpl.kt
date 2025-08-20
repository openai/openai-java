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
import com.openai.services.blocking.ContainerService
import com.openai.services.blocking.ContainerServiceImpl
import com.openai.services.blocking.EmbeddingService
import com.openai.services.blocking.EmbeddingServiceImpl
import com.openai.services.blocking.EvalService
import com.openai.services.blocking.EvalServiceImpl
import com.openai.services.blocking.FileService
import com.openai.services.blocking.FileServiceImpl
import com.openai.services.blocking.FineTuningService
import com.openai.services.blocking.FineTuningServiceImpl
import com.openai.services.blocking.GraderService
import com.openai.services.blocking.GraderServiceImpl
import com.openai.services.blocking.ImageService
import com.openai.services.blocking.ImageServiceImpl
import com.openai.services.blocking.ModelService
import com.openai.services.blocking.ModelServiceImpl
import com.openai.services.blocking.ModerationService
import com.openai.services.blocking.ModerationServiceImpl
import com.openai.services.blocking.ResponseService
import com.openai.services.blocking.ResponseServiceImpl
import com.openai.services.blocking.UploadService
import com.openai.services.blocking.UploadServiceImpl
import com.openai.services.blocking.VectorStoreService
import com.openai.services.blocking.VectorStoreServiceImpl
import com.openai.services.blocking.WebhookService
import com.openai.services.blocking.WebhookServiceImpl
import java.util.function.Consumer

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

    private val graders: GraderService by lazy { GraderServiceImpl(clientOptionsWithUserAgent) }

    private val vectorStores: VectorStoreService by lazy {
        VectorStoreServiceImpl(clientOptionsWithUserAgent)
    }

    private val webhooks: WebhookService by lazy { WebhookServiceImpl(clientOptionsWithUserAgent) }

    private val beta: BetaService by lazy { BetaServiceImpl(clientOptionsWithUserAgent) }

    private val batches: BatchService by lazy { BatchServiceImpl(clientOptionsWithUserAgent) }

    private val uploads: UploadService by lazy { UploadServiceImpl(clientOptionsWithUserAgent) }

    private val responses: ResponseService by lazy {
        ResponseServiceImpl(clientOptionsWithUserAgent)
    }

    private val evals: EvalService by lazy { EvalServiceImpl(clientOptionsWithUserAgent) }

    private val containers: ContainerService by lazy {
        ContainerServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): OpenAIClientAsync = async

    override fun withRawResponse(): OpenAIClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OpenAIClient =
        OpenAIClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun completions(): CompletionService = completions

    override fun chat(): ChatService = chat

    override fun embeddings(): EmbeddingService = embeddings

    override fun files(): FileService = files

    override fun images(): ImageService = images

    override fun audio(): AudioService = audio

    override fun moderations(): ModerationService = moderations

    override fun models(): ModelService = models

    override fun fineTuning(): FineTuningService = fineTuning

    override fun graders(): GraderService = graders

    override fun vectorStores(): VectorStoreService = vectorStores

    override fun webhooks(): WebhookService = webhooks

    override fun beta(): BetaService = beta

    override fun batches(): BatchService = batches

    override fun uploads(): UploadService = uploads

    override fun responses(): ResponseService = responses

    override fun evals(): EvalService = evals

    override fun containers(): ContainerService = containers

    override fun close() = clientOptions.close()

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

        private val graders: GraderService.WithRawResponse by lazy {
            GraderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val vectorStores: VectorStoreService.WithRawResponse by lazy {
            VectorStoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookService.WithRawResponse by lazy {
            WebhookServiceImpl.WithRawResponseImpl(clientOptions)
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

        private val responses: ResponseService.WithRawResponse by lazy {
            ResponseServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val evals: EvalService.WithRawResponse by lazy {
            EvalServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val containers: ContainerService.WithRawResponse by lazy {
            ContainerServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OpenAIClient.WithRawResponse =
            OpenAIClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun completions(): CompletionService.WithRawResponse = completions

        override fun chat(): ChatService.WithRawResponse = chat

        override fun embeddings(): EmbeddingService.WithRawResponse = embeddings

        override fun files(): FileService.WithRawResponse = files

        override fun images(): ImageService.WithRawResponse = images

        override fun audio(): AudioService.WithRawResponse = audio

        override fun moderations(): ModerationService.WithRawResponse = moderations

        override fun models(): ModelService.WithRawResponse = models

        override fun fineTuning(): FineTuningService.WithRawResponse = fineTuning

        override fun graders(): GraderService.WithRawResponse = graders

        override fun vectorStores(): VectorStoreService.WithRawResponse = vectorStores

        override fun webhooks(): WebhookService.WithRawResponse = webhooks

        override fun beta(): BetaService.WithRawResponse = beta

        override fun batches(): BatchService.WithRawResponse = batches

        override fun uploads(): UploadService.WithRawResponse = uploads

        override fun responses(): ResponseService.WithRawResponse = responses

        override fun evals(): EvalService.WithRawResponse = evals

        override fun containers(): ContainerService.WithRawResponse = containers
    }
}
