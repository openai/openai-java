// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.voiceconsents.VoiceConsent
import com.openai.models.audio.voiceconsents.VoiceConsentCreateParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleteParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleted
import com.openai.models.audio.voiceconsents.VoiceConsentListPageAsync
import com.openai.models.audio.voiceconsents.VoiceConsentListParams
import com.openai.models.audio.voiceconsents.VoiceConsentRetrieveParams
import com.openai.models.audio.voiceconsents.VoiceConsentUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Turn audio into text or text into audio. */
interface VoiceConsentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceConsentServiceAsync

    /** Upload a voice consent recording. */
    fun create(params: VoiceConsentCreateParams): CompletableFuture<VoiceConsent> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VoiceConsentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsent>

    /** Retrieves a voice consent recording. */
    fun retrieve(consentId: String): CompletableFuture<VoiceConsent> =
        retrieve(consentId, VoiceConsentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        consentId: String,
        params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsent> =
        retrieve(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        consentId: String,
        params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
    ): CompletableFuture<VoiceConsent> = retrieve(consentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VoiceConsentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsent>

    /** @see retrieve */
    fun retrieve(params: VoiceConsentRetrieveParams): CompletableFuture<VoiceConsent> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        consentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsent> =
        retrieve(consentId, VoiceConsentRetrieveParams.none(), requestOptions)

    /** Updates a voice consent recording (metadata only). */
    fun update(
        consentId: String,
        params: VoiceConsentUpdateParams,
    ): CompletableFuture<VoiceConsent> = update(consentId, params, RequestOptions.none())

    /** @see update */
    fun update(
        consentId: String,
        params: VoiceConsentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsent> =
        update(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see update */
    fun update(params: VoiceConsentUpdateParams): CompletableFuture<VoiceConsent> =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: VoiceConsentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsent>

    /** Returns a list of voice consent recordings. */
    fun list(): CompletableFuture<VoiceConsentListPageAsync> = list(VoiceConsentListParams.none())

    /** @see list */
    fun list(
        params: VoiceConsentListParams = VoiceConsentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsentListPageAsync>

    /** @see list */
    fun list(
        params: VoiceConsentListParams = VoiceConsentListParams.none()
    ): CompletableFuture<VoiceConsentListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<VoiceConsentListPageAsync> =
        list(VoiceConsentListParams.none(), requestOptions)

    /** Deletes a voice consent recording. */
    fun delete(consentId: String): CompletableFuture<VoiceConsentDeleted> =
        delete(consentId, VoiceConsentDeleteParams.none())

    /** @see delete */
    fun delete(
        consentId: String,
        params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsentDeleted> =
        delete(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see delete */
    fun delete(
        consentId: String,
        params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
    ): CompletableFuture<VoiceConsentDeleted> = delete(consentId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VoiceConsentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceConsentDeleted>

    /** @see delete */
    fun delete(params: VoiceConsentDeleteParams): CompletableFuture<VoiceConsentDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        consentId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsentDeleted> =
        delete(consentId, VoiceConsentDeleteParams.none(), requestOptions)

    /**
     * A view of [VoiceConsentServiceAsync] that provides access to raw HTTP responses for each
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
        ): VoiceConsentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/voice_consents`, but is otherwise the same
         * as [VoiceConsentServiceAsync.create].
         */
        fun create(
            params: VoiceConsentCreateParams
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: VoiceConsentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>>

        /**
         * Returns a raw HTTP response for `get /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentServiceAsync.retrieve].
         */
        fun retrieve(consentId: String): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            retrieve(consentId, VoiceConsentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            consentId: String,
            params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            retrieve(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            consentId: String,
            params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            retrieve(consentId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: VoiceConsentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>>

        /** @see retrieve */
        fun retrieve(
            params: VoiceConsentRetrieveParams
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            consentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            retrieve(consentId, VoiceConsentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentServiceAsync.update].
         */
        fun update(
            consentId: String,
            params: VoiceConsentUpdateParams,
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            update(consentId, params, RequestOptions.none())

        /** @see update */
        fun update(
            consentId: String,
            params: VoiceConsentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> =
            update(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see update */
        fun update(
            params: VoiceConsentUpdateParams
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> = update(params, RequestOptions.none())

        /** @see update */
        fun update(
            params: VoiceConsentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsent>>

        /**
         * Returns a raw HTTP response for `get /audio/voice_consents`, but is otherwise the same as
         * [VoiceConsentServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<VoiceConsentListPageAsync>> =
            list(VoiceConsentListParams.none())

        /** @see list */
        fun list(
            params: VoiceConsentListParams = VoiceConsentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsentListPageAsync>>

        /** @see list */
        fun list(
            params: VoiceConsentListParams = VoiceConsentListParams.none()
        ): CompletableFuture<HttpResponseFor<VoiceConsentListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VoiceConsentListPageAsync>> =
            list(VoiceConsentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentServiceAsync.delete].
         */
        fun delete(consentId: String): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> =
            delete(consentId, VoiceConsentDeleteParams.none())

        /** @see delete */
        fun delete(
            consentId: String,
            params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> =
            delete(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see delete */
        fun delete(
            consentId: String,
            params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> =
            delete(consentId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VoiceConsentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>>

        /** @see delete */
        fun delete(
            params: VoiceConsentDeleteParams
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            consentId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> =
            delete(consentId, VoiceConsentDeleteParams.none(), requestOptions)
    }
}
