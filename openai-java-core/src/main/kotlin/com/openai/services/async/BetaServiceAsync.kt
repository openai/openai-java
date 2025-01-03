// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.ThreadServiceAsync
import com.openai.services.async.beta.VectorStoreServiceAsync

interface BetaServiceAsync {

    fun vectorStores(): VectorStoreServiceAsync

    fun assistants(): AssistantServiceAsync

    fun threads(): ThreadServiceAsync
}
