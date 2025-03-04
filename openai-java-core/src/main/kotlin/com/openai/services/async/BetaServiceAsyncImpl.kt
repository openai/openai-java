// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.AssistantServiceAsyncImpl
import com.openai.services.async.beta.ThreadServiceAsync
import com.openai.services.async.beta.ThreadServiceAsyncImpl
import com.openai.services.async.beta.VectorStoreServiceAsync
import com.openai.services.async.beta.VectorStoreServiceAsyncImpl

class BetaServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    BetaServiceAsync {

    private val withRawResponse: BetaServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val vectorStores: VectorStoreServiceAsync by lazy {
        VectorStoreServiceAsyncImpl(clientOptions)
    }

    private val assistants: AssistantServiceAsync by lazy {
        AssistantServiceAsyncImpl(clientOptions)
    }

    private val threads: ThreadServiceAsync by lazy { ThreadServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): BetaServiceAsync.WithRawResponse = withRawResponse

    override fun vectorStores(): VectorStoreServiceAsync = vectorStores

    override fun assistants(): AssistantServiceAsync = assistants

    override fun threads(): ThreadServiceAsync = threads

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaServiceAsync.WithRawResponse {

        private val vectorStores: VectorStoreServiceAsync.WithRawResponse by lazy {
            VectorStoreServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val assistants: AssistantServiceAsync.WithRawResponse by lazy {
            AssistantServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadServiceAsync.WithRawResponse by lazy {
            ThreadServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun vectorStores(): VectorStoreServiceAsync.WithRawResponse = vectorStores

        override fun assistants(): AssistantServiceAsync.WithRawResponse = assistants

        override fun threads(): ThreadServiceAsync.WithRawResponse = threads
    }
}
