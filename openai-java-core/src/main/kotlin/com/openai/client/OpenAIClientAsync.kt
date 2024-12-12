// File generated from our OpenAPI spec by Stainless.

package com.openai.client

import com.openai.services.async.BatchServiceAsync
import com.openai.services.async.ChatServiceAsync
import com.openai.services.async.CompletionServiceAsync
import com.openai.services.async.EmbeddingServiceAsync
import com.openai.services.async.FileServiceAsync
import com.openai.services.async.FineTuningServiceAsync
import com.openai.services.async.ImageServiceAsync
import com.openai.services.async.ModelServiceAsync
import com.openai.services.async.ModerationServiceAsync
import com.openai.services.async.UploadServiceAsync

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
