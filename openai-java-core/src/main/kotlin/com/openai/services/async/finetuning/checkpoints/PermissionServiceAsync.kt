// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.checkpoints

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePageAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse
import java.util.concurrent.CompletableFuture

interface PermissionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
     *
     * This enables organization owners to share fine-tuned models with other projects in their
     * organization.
     */
    fun create(params: PermissionCreateParams): CompletableFuture<PermissionCreatePageAsync> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: PermissionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionCreatePageAsync>

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to view all permissions for a fine-tuned model
     * checkpoint.
     */
    fun retrieve(params: PermissionRetrieveParams): CompletableFuture<PermissionRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionRetrieveResponse>

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to delete a permission for a fine-tuned model
     * checkpoint.
     */
    fun delete(params: PermissionDeleteParams): CompletableFuture<PermissionDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<PermissionDeleteResponse>

    /**
     * A view of [PermissionServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: PermissionCreateParams
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: PermissionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionCreatePageAsync>>

        /**
         * Returns a raw HTTP response for `get
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `delete
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions/{permission_id}`, but
         * is otherwise the same as [PermissionServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: PermissionDeleteParams
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<PermissionDeleteResponse>>
    }
}
