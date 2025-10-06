// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.async.AudioServiceAsync
import com.openai.services.async.AudioServiceAsyncImpl
import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.BatchServiceAsyncImpl
import com.openai.services.async.BetaServiceAsync
import com.openai.services.async.BetaServiceAsyncImpl
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.ChatServiceAsyncImpl
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.CompletionServiceAsyncImpl
import com.openai.services.async.ContainerServiceAsync
import com.openai.services.async.ContainerServiceAsyncImpl
import com.openai.services.async.ConversationServiceAsync
import com.openai.services.async.ConversationServiceAsyncImpl
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.EmbeddingServiceAsyncImpl
import com.openai.services.async.EvalServiceAsync
import com.openai.services.async.EvalServiceAsyncImpl
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FileServiceAsyncImpl
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.FineTuningServiceAsyncImpl
import com.openai.services.async.GraderServiceAsync
import com.openai.services.async.GraderServiceAsyncImpl
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ImageServiceAsyncImpl
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModelServiceAsyncImpl
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.ModerationServiceAsyncImpl
import com.openai.services.async.RealtimeServiceAsync
import com.openai.services.async.RealtimeServiceAsyncImpl
import com.openai.services.async.ResponseServiceAsync
import com.openai.services.async.ResponseServiceAsyncImpl
import com.openai.services.async.UploadServiceAsync
import com.openai.services.async.UploadServiceAsyncImpl
import com.openai.services.async.VectorStoreServiceAsync
import com.openai.services.async.VectorStoreServiceAsyncImpl
import com.openai.services.async.VideoServiceAsync
import com.openai.services.async.VideoServiceAsyncImpl
import com.openai.services.async.WebhookServiceAsync
import com.openai.services.async.WebhookServiceAsyncImpl
import java.util.function.Consumer

class OpenAIClientAsyncImpl(private val clientOptions: ClientOptions) : OpenAIClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: OpenAIClient by lazy { OpenAIClientImpl(clientOptions) }

    private val withRawResponse: OpenAIClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

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

    private val audio: AudioServiceAsync by lazy {
        AudioServiceAsyncImpl(clientOptionsWithUserAgent)
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

    private val graders: GraderServiceAsync by lazy {
        GraderServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val vectorStores: VectorStoreServiceAsync by lazy {
        VectorStoreServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val webhooks: WebhookServiceAsync by lazy {
        WebhookServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val beta: BetaServiceAsync by lazy { BetaServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val batches: BatchServiceAsync by lazy {
        BatchServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val uploads: UploadServiceAsync by lazy {
        UploadServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val responses: ResponseServiceAsync by lazy {
        ResponseServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val realtime: RealtimeServiceAsync by lazy {
        RealtimeServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val conversations: ConversationServiceAsync by lazy {
        ConversationServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val evals: EvalServiceAsync by lazy { EvalServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val containers: ContainerServiceAsync by lazy {
        ContainerServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val videos: VideoServiceAsync by lazy {
        VideoServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): OpenAIClient = sync

    override fun withRawResponse(): OpenAIClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): OpenAIClientAsync =
        OpenAIClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun completions(): CompletionServiceAsync = completions

    override fun chat(): ChatServiceAsync = chat

    override fun embeddings(): EmbeddingServiceAsync = embeddings

    override fun files(): FileServiceAsync = files

    override fun images(): ImageServiceAsync = images

    override fun audio(): AudioServiceAsync = audio

    override fun moderations(): ModerationServiceAsync = moderations

    override fun models(): ModelServiceAsync = models

    override fun fineTuning(): FineTuningServiceAsync = fineTuning

    override fun graders(): GraderServiceAsync = graders

    override fun vectorStores(): VectorStoreServiceAsync = vectorStores

    override fun webhooks(): WebhookServiceAsync = webhooks

    override fun beta(): BetaServiceAsync = beta

    override fun batches(): BatchServiceAsync = batches

    override fun uploads(): UploadServiceAsync = uploads

    override fun responses(): ResponseServiceAsync = responses

    override fun realtime(): RealtimeServiceAsync = realtime

    override fun conversations(): ConversationServiceAsync = conversations

    override fun evals(): EvalServiceAsync = evals

    override fun containers(): ContainerServiceAsync = containers

    override fun videos(): VideoServiceAsync = videos

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        OpenAIClientAsync.WithRawResponse {

        private val completions: CompletionServiceAsync.WithRawResponse by lazy {
            CompletionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val chat: ChatServiceAsync.WithRawResponse by lazy {
            ChatServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val embeddings: EmbeddingServiceAsync.WithRawResponse by lazy {
            EmbeddingServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val files: FileServiceAsync.WithRawResponse by lazy {
            FileServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val images: ImageServiceAsync.WithRawResponse by lazy {
            ImageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val audio: AudioServiceAsync.WithRawResponse by lazy {
            AudioServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val moderations: ModerationServiceAsync.WithRawResponse by lazy {
            ModerationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val models: ModelServiceAsync.WithRawResponse by lazy {
            ModelServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val fineTuning: FineTuningServiceAsync.WithRawResponse by lazy {
            FineTuningServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val graders: GraderServiceAsync.WithRawResponse by lazy {
            GraderServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val vectorStores: VectorStoreServiceAsync.WithRawResponse by lazy {
            VectorStoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val webhooks: WebhookServiceAsync.WithRawResponse by lazy {
            WebhookServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val beta: BetaServiceAsync.WithRawResponse by lazy {
            BetaServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val batches: BatchServiceAsync.WithRawResponse by lazy {
            BatchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val uploads: UploadServiceAsync.WithRawResponse by lazy {
            UploadServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val responses: ResponseServiceAsync.WithRawResponse by lazy {
            ResponseServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val realtime: RealtimeServiceAsync.WithRawResponse by lazy {
            RealtimeServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val conversations: ConversationServiceAsync.WithRawResponse by lazy {
            ConversationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val evals: EvalServiceAsync.WithRawResponse by lazy {
            EvalServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val containers: ContainerServiceAsync.WithRawResponse by lazy {
            ContainerServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val videos: VideoServiceAsync.WithRawResponse by lazy {
            VideoServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OpenAIClientAsync.WithRawResponse =
            OpenAIClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun completions(): CompletionServiceAsync.WithRawResponse = completions

        override fun chat(): ChatServiceAsync.WithRawResponse = chat

        override fun embeddings(): EmbeddingServiceAsync.WithRawResponse = embeddings

        override fun files(): FileServiceAsync.WithRawResponse = files

        override fun images(): ImageServiceAsync.WithRawResponse = images

        override fun audio(): AudioServiceAsync.WithRawResponse = audio

        override fun moderations(): ModerationServiceAsync.WithRawResponse = moderations

        override fun models(): ModelServiceAsync.WithRawResponse = models

        override fun fineTuning(): FineTuningServiceAsync.WithRawResponse = fineTuning

        override fun graders(): GraderServiceAsync.WithRawResponse = graders

        override fun vectorStores(): VectorStoreServiceAsync.WithRawResponse = vectorStores

        override fun webhooks(): WebhookServiceAsync.WithRawResponse = webhooks

        override fun beta(): BetaServiceAsync.WithRawResponse = beta

        override fun batches(): BatchServiceAsync.WithRawResponse = batches

        override fun uploads(): UploadServiceAsync.WithRawResponse = uploads

        override fun responses(): ResponseServiceAsync.WithRawResponse = responses

        override fun realtime(): RealtimeServiceAsync.WithRawResponse = realtime

        override fun conversations(): ConversationServiceAsync.WithRawResponse = conversations

        override fun evals(): EvalServiceAsync.WithRawResponse = evals

        override fun containers(): ContainerServiceAsync.WithRawResponse = containers

        override fun videos(): VideoServiceAsync.WithRawResponse = videos
    }
}
