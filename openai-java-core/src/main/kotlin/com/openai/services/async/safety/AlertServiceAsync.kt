// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.safety

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.safety.alerts.AlertRetrieveParams
import com.openai.models.safety.alerts.SafetyAlert
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AlertServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlertServiceAsync

    /** Get a safety alert belonging to the authenticated API project. */
    fun retrieve(id: String): CompletableFuture<SafetyAlert> =
        retrieve(id, AlertRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AlertRetrieveParams = AlertRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SafetyAlert> = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AlertRetrieveParams = AlertRetrieveParams.none(),
    ): CompletableFuture<SafetyAlert> = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AlertRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SafetyAlert>

    /** @see retrieve */
    fun retrieve(params: AlertRetrieveParams): CompletableFuture<SafetyAlert> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): CompletableFuture<SafetyAlert> =
        retrieve(id, AlertRetrieveParams.none(), requestOptions)

    /** A view of [AlertServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AlertServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /safety/alerts/{id}`, but is otherwise the same as
         * [AlertServiceAsync.retrieve].
         */
        fun retrieve(id: String): CompletableFuture<HttpResponseFor<SafetyAlert>> =
            retrieve(id, AlertRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AlertRetrieveParams = AlertRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SafetyAlert>> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            id: String,
            params: AlertRetrieveParams = AlertRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<SafetyAlert>> =
            retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: AlertRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SafetyAlert>>

        /** @see retrieve */
        fun retrieve(params: AlertRetrieveParams): CompletableFuture<HttpResponseFor<SafetyAlert>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            id: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SafetyAlert>> =
            retrieve(id, AlertRetrieveParams.none(), requestOptions)
    }
}
