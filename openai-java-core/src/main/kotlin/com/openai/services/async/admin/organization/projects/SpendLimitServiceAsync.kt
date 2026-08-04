// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.admin.organization.projects.spendlimit.ProjectSpendLimit
import com.openai.models.admin.organization.projects.spendlimit.ProjectSpendLimitDeleted
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitDeleteParams
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitRetrieveParams
import com.openai.models.admin.organization.projects.spendlimit.SpendLimitUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SpendLimitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpendLimitServiceAsync

    /** Get a project's hard spend limit. */
    fun retrieve(projectId: String): CompletableFuture<ProjectSpendLimit> =
        retrieve(projectId, SpendLimitRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimit> =
        retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
    ): CompletableFuture<ProjectSpendLimit> = retrieve(projectId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SpendLimitRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimit>

    /** @see retrieve */
    fun retrieve(params: SpendLimitRetrieveParams): CompletableFuture<ProjectSpendLimit> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectSpendLimit> =
        retrieve(projectId, SpendLimitRetrieveParams.none(), requestOptions)

    /** Create or replace a project's hard spend limit. */
    fun update(
        projectId: String,
        params: SpendLimitUpdateParams,
    ): CompletableFuture<ProjectSpendLimit> = update(projectId, params, RequestOptions.none())

    /** @see update */
    fun update(
        projectId: String,
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimit> =
        update(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see update */
    fun update(params: SpendLimitUpdateParams): CompletableFuture<ProjectSpendLimit> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SpendLimitUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimit>

    /** Delete a project's hard spend limit. */
    fun delete(projectId: String): CompletableFuture<ProjectSpendLimitDeleted> =
        delete(projectId, SpendLimitDeleteParams.none())

    /** @see delete */
    fun delete(
        projectId: String,
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimitDeleted> =
        delete(params.toBuilder().projectId(projectId).build(), requestOptions)

    /** @see delete */
    fun delete(
        projectId: String,
        params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
    ): CompletableFuture<ProjectSpendLimitDeleted> =
        delete(projectId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SpendLimitDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ProjectSpendLimitDeleted>

    /** @see delete */
    fun delete(params: SpendLimitDeleteParams): CompletableFuture<ProjectSpendLimitDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        projectId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<ProjectSpendLimitDeleted> =
        delete(projectId, SpendLimitDeleteParams.none(), requestOptions)

    /**
     * A view of [SpendLimitServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpendLimitServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitServiceAsync.retrieve].
         */
        fun retrieve(projectId: String): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            retrieve(projectId, SpendLimitRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            retrieve(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            params: SpendLimitRetrieveParams = SpendLimitRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            retrieve(projectId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: SpendLimitRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>>

        /** @see retrieve */
        fun retrieve(
            params: SpendLimitRetrieveParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            retrieve(projectId, SpendLimitRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitServiceAsync.update].
         */
        fun update(
            projectId: String,
            params: SpendLimitUpdateParams,
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            update(projectId, params, RequestOptions.none())

        /** @see update */
        fun update(
            projectId: String,
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            update(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see update */
        fun update(
            params: SpendLimitUpdateParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>> =
            update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: SpendLimitUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimit>>

        /**
         * Returns a raw HTTP response for `delete /organization/projects/{project_id}/spend_limit`,
         * but is otherwise the same as [SpendLimitServiceAsync.delete].
         */
        fun delete(
            projectId: String
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>> =
            delete(projectId, SpendLimitDeleteParams.none())

        /** @see delete */
        fun delete(
            projectId: String,
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>> =
            delete(params.toBuilder().projectId(projectId).build(), requestOptions)

        /** @see delete */
        fun delete(
            projectId: String,
            params: SpendLimitDeleteParams = SpendLimitDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>> =
            delete(projectId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: SpendLimitDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>>

        /** @see delete */
        fun delete(
            params: SpendLimitDeleteParams
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            projectId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ProjectSpendLimitDeleted>> =
            delete(projectId, SpendLimitDeleteParams.none(), requestOptions)
    }
}
