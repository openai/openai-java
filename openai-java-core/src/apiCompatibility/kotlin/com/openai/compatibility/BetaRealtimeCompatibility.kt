package com.openai.compatibility

import com.openai.client.OpenAIClient
import com.openai.client.OpenAIClientAsync
import com.openai.services.async.beta.RealtimeServiceAsync
import com.openai.services.blocking.beta.RealtimeService

internal object BetaRealtimeCompatibility {
    fun blocking(client: OpenAIClient): RealtimeService = client.beta().realtime()

    fun blockingRaw(client: OpenAIClient.WithRawResponse): RealtimeService.WithRawResponse =
        client.beta().realtime()

    fun async(client: OpenAIClientAsync): RealtimeServiceAsync = client.beta().realtime()

    fun asyncRaw(client: OpenAIClientAsync.WithRawResponse): RealtimeServiceAsync.WithRawResponse =
        client.beta().realtime()
}
