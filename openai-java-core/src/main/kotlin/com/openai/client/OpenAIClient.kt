// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
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
import com.openai.services.blocking.ResponseService
import com.openai.services.blocking.UploadService
import com.openai.services.blocking.VectorStoreService
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

    fun completions(): CompletionService

    fun chat(): ChatService

    fun embeddings(): EmbeddingService

    fun files(): FileService

    fun images(): ImageService

    fun audio(): AudioService

    fun moderations(): ModerationService

    fun models(): ModelService

    fun fineTuning(): FineTuningService

    fun graders(): GraderService

    fun vectorStores(): VectorStoreService

    fun webhooks(): WebhookService

    fun beta(): BetaService

    fun batches(): BatchService

    fun uploads(): UploadService

    fun responses(): ResponseService

    fun conversations(): ConversationService

    fun evals(): EvalService

    fun containers(): ContainerService

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

        fun completions(): CompletionService.WithRawResponse

        fun chat(): ChatService.WithRawResponse

        fun embeddings(): EmbeddingService.WithRawResponse

        fun files(): FileService.WithRawResponse

        fun images(): ImageService.WithRawResponse

        fun audio(): AudioService.WithRawResponse

        fun moderations(): ModerationService.WithRawResponse

        fun models(): ModelService.WithRawResponse

        fun fineTuning(): FineTuningService.WithRawResponse

        fun graders(): GraderService.WithRawResponse

        fun vectorStores(): VectorStoreService.WithRawResponse

        fun webhooks(): WebhookService.WithRawResponse

        fun beta(): BetaService.WithRawResponse

        fun batches(): BatchService.WithRawResponse

        fun uploads(): UploadService.WithRawResponse

        fun responses(): ResponseService.WithRawResponse

        fun conversations(): ConversationService.WithRawResponse

        fun evals(): EvalService.WithRawResponse

        fun containers(): ContainerService.WithRawResponse
    }
}
