// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.http.Headers
import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.AssistantServiceAsyncImpl
import com.openai.services.async.beta.ThreadServiceAsync
import com.openai.services.async.beta.ThreadServiceAsyncImpl
import com.openai.services.async.beta.VectorStoreServiceAsync
import com.openai.services.async.beta.VectorStoreServiceAsyncImpl

class BetaServiceAsyncImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : BetaServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val vectorStores: VectorStoreServiceAsync by lazy {
        VectorStoreServiceAsyncImpl(clientOptions)
    }

    private val assistants: AssistantServiceAsync by lazy {
        AssistantServiceAsyncImpl(clientOptions)
    }

    private val threads: ThreadServiceAsync by lazy { ThreadServiceAsyncImpl(clientOptions) }

    override fun vectorStores(): VectorStoreServiceAsync = vectorStores

    override fun assistants(): AssistantServiceAsync = assistants

    override fun threads(): ThreadServiceAsync = threads
}
