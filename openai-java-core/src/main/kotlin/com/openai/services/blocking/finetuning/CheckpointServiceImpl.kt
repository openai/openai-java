// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import com.openai.services.blocking.finetuning.checkpoints.PermissionServiceImpl

class CheckpointServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointService {

    private val withRawResponse: CheckpointService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val permissions: PermissionService by lazy { PermissionServiceImpl(clientOptions) }

    override fun withRawResponse(): CheckpointService.WithRawResponse = withRawResponse

    override fun permissions(): PermissionService = permissions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckpointService.WithRawResponse {

        private val permissions: PermissionService.WithRawResponse by lazy {
            PermissionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun permissions(): PermissionService.WithRawResponse = permissions
    }
}
