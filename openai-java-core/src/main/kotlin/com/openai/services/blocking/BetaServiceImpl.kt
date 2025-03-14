// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.AssistantServiceImpl
import com.openai.services.blocking.beta.ThreadService
import com.openai.services.blocking.beta.ThreadServiceImpl
import com.openai.services.blocking.beta.VectorStoreService
import com.openai.services.blocking.beta.VectorStoreServiceImpl

class BetaServiceImpl internal constructor(private val clientOptions: ClientOptions) : BetaService {

    private val withRawResponse: BetaService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val vectorStores: VectorStoreService by lazy { VectorStoreServiceImpl(clientOptions) }

    private val assistants: AssistantService by lazy { AssistantServiceImpl(clientOptions) }

    private val threads: ThreadService by lazy { ThreadServiceImpl(clientOptions) }

    override fun withRawResponse(): BetaService.WithRawResponse = withRawResponse

    override fun vectorStores(): VectorStoreService = vectorStores

    override fun assistants(): AssistantService = assistants

    override fun threads(): ThreadService = threads

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        BetaService.WithRawResponse {

        private val vectorStores: VectorStoreService.WithRawResponse by lazy {
            VectorStoreServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val assistants: AssistantService.WithRawResponse by lazy {
            AssistantServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val threads: ThreadService.WithRawResponse by lazy {
            ThreadServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun vectorStores(): VectorStoreService.WithRawResponse = vectorStores

        override fun assistants(): AssistantService.WithRawResponse = assistants

        override fun threads(): ThreadService.WithRawResponse = threads
    }
}
