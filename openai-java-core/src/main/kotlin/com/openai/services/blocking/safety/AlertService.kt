// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.safety

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.safety.alerts.AlertRetrieveParams
import com.openai.models.safety.alerts.SafetyAlert
import java.util.function.Consumer

interface AlertService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlertService

    /** Get a safety alert belonging to the authenticated API project. */
    fun retrieve(id: String): SafetyAlert = retrieve(id, AlertRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AlertRetrieveParams = AlertRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SafetyAlert = retrieve(params.toBuilder().id(id).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        id: String,
        params: AlertRetrieveParams = AlertRetrieveParams.none(),
    ): SafetyAlert = retrieve(id, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: AlertRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SafetyAlert

    /** @see retrieve */
    fun retrieve(params: AlertRetrieveParams): SafetyAlert = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(id: String, requestOptions: RequestOptions): SafetyAlert =
        retrieve(id, AlertRetrieveParams.none(), requestOptions)

    /** A view of [AlertService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlertService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /safety/alerts/{id}`, but is otherwise the same as
         * [AlertService.retrieve].
         */
        @MustBeClosed
        fun retrieve(id: String): HttpResponseFor<SafetyAlert> =
            retrieve(id, AlertRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AlertRetrieveParams = AlertRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SafetyAlert> =
            retrieve(params.toBuilder().id(id).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            id: String,
            params: AlertRetrieveParams = AlertRetrieveParams.none(),
        ): HttpResponseFor<SafetyAlert> = retrieve(id, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: AlertRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SafetyAlert>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: AlertRetrieveParams): HttpResponseFor<SafetyAlert> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(id: String, requestOptions: RequestOptions): HttpResponseFor<SafetyAlert> =
            retrieve(id, AlertRetrieveParams.none(), requestOptions)
    }
}
