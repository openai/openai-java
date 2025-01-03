// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta.threads

import com.openai.core.RequestOptions
import com.openai.models.BetaThreadMessageCreateParams
import com.openai.models.BetaThreadMessageDeleteParams
import com.openai.models.BetaThreadMessageListPageAsync
import com.openai.models.BetaThreadMessageListParams
import com.openai.models.BetaThreadMessageRetrieveParams
import com.openai.models.BetaThreadMessageUpdateParams
import com.openai.models.Message
import com.openai.models.MessageDeleted
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /** Create a message. */
    @JvmOverloads
    fun create(
        params: BetaThreadMessageCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Message>

    /** Retrieve a message. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadMessageRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Message>

    /** Modifies a message. */
    @JvmOverloads
    fun update(
        params: BetaThreadMessageUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<Message>

    /** Returns a list of messages for a given thread. */
    @JvmOverloads
    fun list(
        params: BetaThreadMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<BetaThreadMessageListPageAsync>

    /** Deletes a message. */
    @JvmOverloads
    fun delete(
        params: BetaThreadMessageDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<MessageDeleted>
}
