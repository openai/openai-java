// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.services.blocking.AdminService
import com.openai.services.blocking.AudioService
import com.openai.services.blocking.BatchService
import com.openai.services.blocking.BetaService
import com.openai.services.blocking.ChatService
import com.openai.services.blocking.CompletionService
import com.openai.services.blocking.ContainerService
import com.openai.services.blocking.ConversationService
import com.openai.services.blocking.EmbeddingService
import com.openai.services.blocking.EvalService
import com.openai.services.blocking.FileService
import com.openai.services.blocking.FineTuningService
import com.openai.services.blocking.GraderService
import com.openai.services.blocking.ImageService
import com.openai.services.blocking.ModelService
import com.openai.services.blocking.ModerationService
import com.openai.services.blocking.RealtimeService
import com.openai.services.blocking.ResponseService
import com.openai.services.blocking.SkillService
import com.openai.services.blocking.UploadService
import com.openai.services.blocking.VectorStoreService
import com.openai.services.blocking.VideoService
import com.openai.services.blocking.WebhookService
import java.util.function.Consumer

/**
 * A client for interacting with the OpenAI REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface OpenAIClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): OpenAIClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OpenAIClient

    /**
     * Given a prompt, the model will return one or more predicted completions, and can also return
     * the probabilities of alternative tokens at each position.
     */
    fun completions(): CompletionService

    fun chat(): ChatService

    /**
     * Get a vector representation of a given input that can be easily consumed by machine learning
     * models and algorithms.
     */
    fun embeddings(): EmbeddingService

    /**
     * Files are used to upload documents that can be used with features like Assistants and
     * Fine-tuning.
     */
    fun files(): FileService

    /** Given a prompt and/or an input image, the model will generate a new image. */
    fun images(): ImageService

    fun audio(): AudioService

    /** Given text and/or image inputs, classifies if those inputs are potentially harmful. */
    fun moderations(): ModerationService

    /** List and describe the various models available in the API. */
    fun models(): ModelService

    fun fineTuning(): FineTuningService

    fun graders(): GraderService

    fun vectorStores(): VectorStoreService

    fun webhooks(): WebhookService

    fun beta(): BetaService

    /** Create large batches of API requests to run asynchronously. */
    fun batches(): BatchService

    /** Use Uploads to upload large files in multiple parts. */
    fun uploads(): UploadService

    fun admin(): AdminService

    fun responses(): ResponseService

    fun realtime(): RealtimeService

    /** Manage conversations and conversation items. */
    fun conversations(): ConversationService

    /** Manage and run evals in the OpenAI platform. */
    fun evals(): EvalService

    fun containers(): ContainerService

    fun skills(): SkillService

    fun videos(): VideoService

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /** A view of [OpenAIClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): OpenAIClient.WithRawResponse

        /**
         * Given a prompt, the model will return one or more predicted completions, and can also
         * return the probabilities of alternative tokens at each position.
         */
        fun completions(): CompletionService.WithRawResponse

        fun chat(): ChatService.WithRawResponse

        /**
         * Get a vector representation of a given input that can be easily consumed by machine
         * learning models and algorithms.
         */
        fun embeddings(): EmbeddingService.WithRawResponse

        /**
         * Files are used to upload documents that can be used with features like Assistants and
         * Fine-tuning.
         */
        fun files(): FileService.WithRawResponse

        /** Given a prompt and/or an input image, the model will generate a new image. */
        fun images(): ImageService.WithRawResponse

        fun audio(): AudioService.WithRawResponse

        /** Given text and/or image inputs, classifies if those inputs are potentially harmful. */
        fun moderations(): ModerationService.WithRawResponse

        /** List and describe the various models available in the API. */
        fun models(): ModelService.WithRawResponse

        fun fineTuning(): FineTuningService.WithRawResponse

        fun graders(): GraderService.WithRawResponse

        fun vectorStores(): VectorStoreService.WithRawResponse

        fun webhooks(): WebhookService.WithRawResponse

        fun beta(): BetaService.WithRawResponse

        /** Create large batches of API requests to run asynchronously. */
        fun batches(): BatchService.WithRawResponse

        /** Use Uploads to upload large files in multiple parts. */
        fun uploads(): UploadService.WithRawResponse

        fun admin(): AdminService.WithRawResponse

        fun responses(): ResponseService.WithRawResponse

        fun realtime(): RealtimeService.WithRawResponse

        /** Manage conversations and conversation items. */
        fun conversations(): ConversationService.WithRawResponse

        /** Manage and run evals in the OpenAI platform. */
        fun evals(): EvalService.WithRawResponse

        fun containers(): ContainerService.WithRawResponse

        fun skills(): SkillService.WithRawResponse

        fun videos(): VideoService.WithRawResponse
    }
}
