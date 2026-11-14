package com.openai.responses

import com.openai.core.ClientOptions
import com.openai.core.getPackageVersion
import com.openai.services.async.responses.ResponseServiceAsync
import com.openai.services.async.responses.ResponseServiceAsyncImpl
import com.openai.services.blocking.responses.ResponseService
import com.openai.services.blocking.responses.ResponseServiceImpl

/** Transport-neutral client for the Responses API. Closing it closes the supplied options. */
class OpenAIResponsesClient(private val clientOptions: ClientOptions) : AutoCloseable {

    init {
        checkResponsesRuntime(OpenAIResponsesClient::class.java.classLoader)
    }

    private val responses by lazy {
        ResponseServiceImpl(clientOptions.withUserAgent(javaClass.simpleName))
    }
    private val async by lazy { Async() }

    fun responses(): ResponseService = responses

    fun async(): Async = async

    inner class Async internal constructor() {
        private val responses by lazy {
            ResponseServiceAsyncImpl(clientOptions.withUserAgent("OpenAIResponsesClientAsync"))
        }

        fun responses(): ResponseServiceAsync = responses
    }

    override fun close() = clientOptions.close()
}

private fun ClientOptions.withUserAgent(clientName: String): ClientOptions =
    if (headers.values("User-Agent").isNotEmpty()) this
    else toBuilder().defaultUserAgent("$clientName/Java ${getPackageVersion()}").build()
