// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.async.AudioServiceAsync
import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.BetaServiceAsync
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.UploadServiceAsync

/**
 * A client for interacting with the OpenAI REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
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

    fun completions(): CompletionServiceAsync

    fun chat(): ChatServiceAsync

    fun embeddings(): EmbeddingServiceAsync

    fun files(): FileServiceAsync

    fun images(): ImageServiceAsync

    fun audio(): AudioServiceAsync

    fun moderations(): ModerationServiceAsync

    fun models(): ModelServiceAsync

    fun fineTuning(): FineTuningServiceAsync

    fun beta(): BetaServiceAsync

    fun batches(): BatchServiceAsync

    fun uploads(): UploadServiceAsync

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

        fun completions(): CompletionServiceAsync.WithRawResponse

        fun chat(): ChatServiceAsync.WithRawResponse

        fun embeddings(): EmbeddingServiceAsync.WithRawResponse

        fun files(): FileServiceAsync.WithRawResponse

        fun images(): ImageServiceAsync.WithRawResponse

        fun audio(): AudioServiceAsync.WithRawResponse

        fun moderations(): ModerationServiceAsync.WithRawResponse

        fun models(): ModelServiceAsync.WithRawResponse

        fun fineTuning(): FineTuningServiceAsync.WithRawResponse

        fun beta(): BetaServiceAsync.WithRawResponse

        fun batches(): BatchServiceAsync.WithRawResponse

        fun uploads(): UploadServiceAsync.WithRawResponse
    }
}
