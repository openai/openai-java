// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.async.*

interface OpenAIClientAsync {

    fun sync(): OpenAIClient

    fun completions(): CompletionServiceAsync

    fun chat(): ChatServiceAsync

    fun embeddings(): EmbeddingServiceAsync

    fun files(): FileServiceAsync

    fun images(): ImageServiceAsync

    fun moderations(): ModerationServiceAsync

    fun models(): ModelServiceAsync

    fun fineTuning(): FineTuningServiceAsync

    fun batches(): BatchServiceAsync

    fun uploads(): UploadServiceAsync
}
