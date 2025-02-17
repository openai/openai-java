// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.models.ImageGenerateParams
import com.openai.models.ImagesResponse
import java.util.concurrent.CompletableFuture

interface ImageServiceAsync {

    /** Creates an image given a prompt. */
    @JvmOverloads
    fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ImagesResponse>
}
