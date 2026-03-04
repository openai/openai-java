// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.checkpoints

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreatePage
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteResponse
import com.openai.models.finetuning.checkpoints.permissions.PermissionListPage
import com.openai.models.finetuning.checkpoints.permissions.PermissionListParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveResponse
import java.util.function.Consumer

/** Manage fine-tuning jobs to tailor a model to your specific training data. */
interface PermissionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): PermissionService

    /**
     * **NOTE:** Calling this endpoint requires an [admin API key](../admin-api-keys).
     *
     * This enables organization owners to share fine-tuned models with other projects in their
     * organization.
     */
    fun create(
        fineTunedModelCheckpoint: String,
        params: PermissionCreateParams,
    ): PermissionCreatePage = create(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see create */
    fun create(
        fineTunedModelCheckpoint: String,
        params: PermissionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionCreatePage =
        create(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see create */
    fun create(params: PermissionCreateParams): PermissionCreatePage =
        create(params, RequestOptions.none())

    /** @see create */
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
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(fineTunedModelCheckpoint: String): PermissionRetrieveResponse =
        retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionRetrieveResponse =
        retrieve(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
    ): PermissionRetrieveResponse =
        retrieve(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        params: PermissionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionRetrieveResponse

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(params: PermissionRetrieveParams): PermissionRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
    fun retrieve(
        fineTunedModelCheckpoint: String,
        requestOptions: RequestOptions,
    ): PermissionRetrieveResponse =
        retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none(), requestOptions)

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to view all permissions for a fine-tuned model
     * checkpoint.
     */
    fun list(fineTunedModelCheckpoint: String): PermissionListPage =
        list(fineTunedModelCheckpoint, PermissionListParams.none())

    /** @see list */
    fun list(
        fineTunedModelCheckpoint: String,
        params: PermissionListParams = PermissionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionListPage =
        list(
            params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
            requestOptions,
        )

    /** @see list */
    fun list(
        fineTunedModelCheckpoint: String,
        params: PermissionListParams = PermissionListParams.none(),
    ): PermissionListPage = list(fineTunedModelCheckpoint, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: PermissionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionListPage

    /** @see list */
    fun list(params: PermissionListParams): PermissionListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(fineTunedModelCheckpoint: String, requestOptions: RequestOptions): PermissionListPage =
        list(fineTunedModelCheckpoint, PermissionListParams.none(), requestOptions)

    /**
     * **NOTE:** This endpoint requires an [admin API key](../admin-api-keys).
     *
     * Organization owners can use this endpoint to delete a permission for a fine-tuned model
     * checkpoint.
     */
    fun delete(permissionId: String, params: PermissionDeleteParams): PermissionDeleteResponse =
        delete(permissionId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        permissionId: String,
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionDeleteResponse =
        delete(params.toBuilder().permissionId(permissionId).build(), requestOptions)

    /** @see delete */
    fun delete(params: PermissionDeleteParams): PermissionDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: PermissionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): PermissionDeleteResponse

    /** A view of [PermissionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): PermissionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionService.create].
         */
        @MustBeClosed
        fun create(
            fineTunedModelCheckpoint: String,
            params: PermissionCreateParams,
        ): HttpResponseFor<PermissionCreatePage> =
            create(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            fineTunedModelCheckpoint: String,
            params: PermissionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionCreatePage> =
            create(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see create */
        @MustBeClosed
        fun create(params: PermissionCreateParams): HttpResponseFor<PermissionCreatePage> =
            create(params, RequestOptions.none())

        /** @see create */
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
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            fineTunedModelCheckpoint: String
        ): HttpResponseFor<PermissionRetrieveResponse> =
            retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            fineTunedModelCheckpoint: String,
            params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionRetrieveResponse> =
            retrieve(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            fineTunedModelCheckpoint: String,
            params: PermissionRetrieveParams = PermissionRetrieveParams.none(),
        ): HttpResponseFor<PermissionRetrieveResponse> =
            retrieve(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionRetrieveResponse>

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            params: PermissionRetrieveParams
        ): HttpResponseFor<PermissionRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("Retrieve is deprecated. Please swap to the paginated list method instead.")
        @MustBeClosed
        fun retrieve(
            fineTunedModelCheckpoint: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PermissionRetrieveResponse> =
            retrieve(fineTunedModelCheckpoint, PermissionRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions`, but is otherwise the
         * same as [PermissionService.list].
         */
        @MustBeClosed
        fun list(fineTunedModelCheckpoint: String): HttpResponseFor<PermissionListPage> =
            list(fineTunedModelCheckpoint, PermissionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            fineTunedModelCheckpoint: String,
            params: PermissionListParams = PermissionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionListPage> =
            list(
                params.toBuilder().fineTunedModelCheckpoint(fineTunedModelCheckpoint).build(),
                requestOptions,
            )

        /** @see list */
        @MustBeClosed
        fun list(
            fineTunedModelCheckpoint: String,
            params: PermissionListParams = PermissionListParams.none(),
        ): HttpResponseFor<PermissionListPage> =
            list(fineTunedModelCheckpoint, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: PermissionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: PermissionListParams): HttpResponseFor<PermissionListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            fineTunedModelCheckpoint: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<PermissionListPage> =
            list(fineTunedModelCheckpoint, PermissionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete
         * /fine_tuning/checkpoints/{fine_tuned_model_checkpoint}/permissions/{permission_id}`, but
         * is otherwise the same as [PermissionService.delete].
         */
        @MustBeClosed
        fun delete(
            permissionId: String,
            params: PermissionDeleteParams,
        ): HttpResponseFor<PermissionDeleteResponse> =
            delete(permissionId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            permissionId: String,
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionDeleteResponse> =
            delete(params.toBuilder().permissionId(permissionId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: PermissionDeleteParams): HttpResponseFor<PermissionDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: PermissionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<PermissionDeleteResponse>
    }
}
