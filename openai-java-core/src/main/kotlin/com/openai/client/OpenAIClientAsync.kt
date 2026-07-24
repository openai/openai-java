// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.core.ClientOptions
import com.openai.services.async.AdminServiceAsync
import com.openai.services.async.AudioServiceAsync
import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.BetaServiceAsync
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.ContainerServiceAsync
import com.openai.services.async.ConversationServiceAsync
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.EvalServiceAsync
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.GraderServiceAsync
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.RealtimeServiceAsync
import com.openai.services.async.ResponseServiceAsync
import com.openai.services.async.SkillServiceAsync
import com.openai.services.async.UploadServiceAsync
import com.openai.services.async.VectorStoreServiceAsync
import com.openai.services.async.VideoServiceAsync
import com.openai.services.async.WebhookServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the OpenAI REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. Reusing a single client also
 * centralizes retries and connection reuse in one place, but it does not proactively coordinate
 * rate limiting across multiple client instances.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface OpenAIClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): OpenAIClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OpenAIClientAsync

    /**
     * Given a prompt, the model will return one or more predicted completions, and can also return
     * the probabilities of alternative tokens at each position.
     */
    fun completions(): CompletionServiceAsync

    fun chat(): ChatServiceAsync

    /**
     * Get a vector representation of a given input that can be easily consumed by machine learning
     * models and algorithms.
     */
    fun embeddings(): EmbeddingServiceAsync

    /**
     * Files are used to upload documents that can be used with features like Assistants and
     * Fine-tuning.
     */
    fun files(): FileServiceAsync

    /** Given a prompt and/or an input image, the model will generate a new image. */
    fun images(): ImageServiceAsync

    fun audio(): AudioServiceAsync

    /** Given text and/or image inputs, classifies if those inputs are potentially harmful. */
    fun moderations(): ModerationServiceAsync

    /** List and describe the various models available in the API. */
    fun models(): ModelServiceAsync

    fun fineTuning(): FineTuningServiceAsync

    fun graders(): GraderServiceAsync

    fun vectorStores(): VectorStoreServiceAsync

    fun webhooks(): WebhookServiceAsync

    fun beta(): BetaServiceAsync

    /** Create large batches of API requests to run asynchronously. */
    fun batches(): BatchServiceAsync

    /** Use Uploads to upload large files in multiple parts. */
    fun uploads(): UploadServiceAsync

    fun admin(): AdminServiceAsync

    fun responses(): ResponseServiceAsync

    fun realtime(): RealtimeServiceAsync

    /** Manage conversations and conversation items. */
    fun conversations(): ConversationServiceAsync

    /** Manage and run evals in the OpenAI platform. */
    fun evals(): EvalServiceAsync

    fun containers(): ContainerServiceAsync

    fun skills(): SkillServiceAsync

    fun videos(): VideoServiceAsync

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

    /** A view of [OpenAIClientAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OpenAIClientAsync.WithRawResponse

        /**
         * Given a prompt, the model will return one or more predicted completions, and can also
         * return the probabilities of alternative tokens at each position.
         */
        fun completions(): CompletionServiceAsync.WithRawResponse

        fun chat(): ChatServiceAsync.WithRawResponse

        /**
         * Get a vector representation of a given input that can be easily consumed by machine
         * learning models and algorithms.
         */
        fun embeddings(): EmbeddingServiceAsync.WithRawResponse

        /**
         * Files are used to upload documents that can be used with features like Assistants and
         * Fine-tuning.
         */
        fun files(): FileServiceAsync.WithRawResponse

        /** Given a prompt and/or an input image, the model will generate a new image. */
        fun images(): ImageServiceAsync.WithRawResponse

        fun audio(): AudioServiceAsync.WithRawResponse

        /** Given text and/or image inputs, classifies if those inputs are potentially harmful. */
        fun moderations(): ModerationServiceAsync.WithRawResponse

        /** List and describe the various models available in the API. */
        fun models(): ModelServiceAsync.WithRawResponse

        fun fineTuning(): FineTuningServiceAsync.WithRawResponse

        fun graders(): GraderServiceAsync.WithRawResponse

        fun vectorStores(): VectorStoreServiceAsync.WithRawResponse

        fun webhooks(): WebhookServiceAsync.WithRawResponse

        fun beta(): BetaServiceAsync.WithRawResponse

        /** Create large batches of API requests to run asynchronously. */
        fun batches(): BatchServiceAsync.WithRawResponse

        /** Use Uploads to upload large files in multiple parts. */
        fun uploads(): UploadServiceAsync.WithRawResponse

        fun admin(): AdminServiceAsync.WithRawResponse

        fun responses(): ResponseServiceAsync.WithRawResponse

        fun realtime(): RealtimeServiceAsync.WithRawResponse

        /** Manage conversations and conversation items. */
        fun conversations(): ConversationServiceAsync.WithRawResponse

        /** Manage and run evals in the OpenAI platform. */
        fun evals(): EvalServiceAsync.WithRawResponse

        fun containers(): ContainerServiceAsync.WithRawResponse

        fun skills(): SkillServiceAsync.WithRawResponse

        fun videos(): VideoServiceAsync.WithRawResponse
    }
}
