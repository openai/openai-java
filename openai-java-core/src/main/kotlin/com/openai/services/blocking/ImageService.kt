// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.openai.core.RequestOptions
import com.openai.models.ImageGenerateParams
import com.openai.models.ImagesResponse

interface ImageService {

    /** Creates an image given a prompt. */
    @JvmOverloads
    fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ImagesResponse
}
