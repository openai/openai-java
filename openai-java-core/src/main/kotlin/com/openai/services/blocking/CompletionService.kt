// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.StreamResponse
import com.openai.models.Completion
import com.openai.models.CompletionCreateParams

interface CompletionService {

    /** Creates a completion for the provided prompt and parameters. */
    @JvmOverloads
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Completion

    /** Creates a completion for the provided prompt and parameters. */
    @JvmOverloads
    @MustBeClosed
    fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<Completion>
}
