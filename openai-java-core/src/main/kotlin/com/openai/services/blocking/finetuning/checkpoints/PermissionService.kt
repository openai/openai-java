// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.checkpoints

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePage
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse

interface PermissionService {

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
    fun create(params: PermissionCreateParams): PermissionCreatePage =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: PermissionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionCreatePage

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to view all permissions for a fine-tuned model
     * checkpoint.
     */
    fun retrieve(params: PermissionRetrieveParams): PermissionRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionRetrieveResponse

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to delete a permission for a fine-tuned model
     * checkpoint.
     */
    fun delete(params: PermissionDeleteParams): PermissionDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionDeleteResponse

    /** A view of [PermissionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionService.create].
         */
        @MustBeClosed
        fun create(params: PermissionCreateParams): HttpResponseFor<PermissionCreatePage> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: PermissionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionCreatePage>

        /**
         * Returns a raw HTTP response for `get
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams
        ): HttpResponseFor<PermissionRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionRetrieveResponse>

        /**
         * Returns a raw HTTP response for `delete
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions/{permission_id}`, but
         * is otherwise the same as [PermissionService.delete].
         */
        @MustBeClosed
        fun delete(params: PermissionDeleteParams): HttpResponseFor<PermissionDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionDeleteResponse>
    }
}
