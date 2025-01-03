// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.ThreadService
import com.openai.services.blocking.beta.VectorStoreService

interface BetaService {

    fun vectorStores(): VectorStoreService

    fun assistants(): AssistantService

    fun threads(): ThreadService
}
