// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking

import com.openai.core.RequestOptions
import com.openai.models.ModerationCreateParams
import com.openai.models.ModerationCreateResponse

interface ModerationService {

    /**
     * Classifies if text and/or image inputs are potentially harmful. Learn more in the
     * [moderation guide](https://platform.openai.com/docs/guides/moderation).
     */
    @JvmOverloads
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModerationCreateResponse
}
