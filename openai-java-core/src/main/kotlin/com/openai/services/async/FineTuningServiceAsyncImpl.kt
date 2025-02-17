// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.fineTuning.JobServiceAsync
import com.openai.services.async.fineTuning.JobServiceAsyncImpl

class FineTuningServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    FineTuningServiceAsync {

    private val jobs: JobServiceAsync by lazy { JobServiceAsyncImpl(clientOptions) }

    override fun jobs(): JobServiceAsync = jobs
}
