// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.voiceconsents.VoiceConsent
import com.openai.models.audio.voiceconsents.VoiceConsentCreateParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleteParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleted
import com.openai.models.audio.voiceconsents.VoiceConsentListPage
import com.openai.models.audio.voiceconsents.VoiceConsentListParams
import com.openai.models.audio.voiceconsents.VoiceConsentRetrieveParams
import com.openai.models.audio.voiceconsents.VoiceConsentUpdateParams
import java.util.function.Consumer

/** Turn audio into text or text into audio. */
interface VoiceConsentService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceConsentService

    /** Upload a voice consent recording. */
    fun create(params: VoiceConsentCreateParams): VoiceConsent =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VoiceConsentCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsent

    /** Retrieves a voice consent recording. */
    fun retrieve(consentId: String): VoiceConsent =
        retrieve(consentId, VoiceConsentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        consentId: String,
        params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsent = retrieve(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        consentId: String,
        params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
    ): VoiceConsent = retrieve(consentId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VoiceConsentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsent

    /** @see retrieve */
    fun retrieve(params: VoiceConsentRetrieveParams): VoiceConsent =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(consentId: String, requestOptions: RequestOptions): VoiceConsent =
        retrieve(consentId, VoiceConsentRetrieveParams.none(), requestOptions)

    /** Updates a voice consent recording (metadata only). */
    fun update(consentId: String, params: VoiceConsentUpdateParams): VoiceConsent =
        update(consentId, params, RequestOptions.none())

    /** @see update */
    fun update(
        consentId: String,
        params: VoiceConsentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsent = update(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see update */
    fun update(params: VoiceConsentUpdateParams): VoiceConsent =
        update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: VoiceConsentUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsent

    /** Returns a list of voice consent recordings. */
    fun list(): VoiceConsentListPage = list(VoiceConsentListParams.none())

    /** @see list */
    fun list(
        params: VoiceConsentListParams = VoiceConsentListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsentListPage

    /** @see list */
    fun list(params: VoiceConsentListParams = VoiceConsentListParams.none()): VoiceConsentListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): VoiceConsentListPage =
        list(VoiceConsentListParams.none(), requestOptions)

    /** Deletes a voice consent recording. */
    fun delete(consentId: String): VoiceConsentDeleted =
        delete(consentId, VoiceConsentDeleteParams.none())

    /** @see delete */
    fun delete(
        consentId: String,
        params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsentDeleted = delete(params.toBuilder().consentId(consentId).build(), requestOptions)

    /** @see delete */
    fun delete(
        consentId: String,
        params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
    ): VoiceConsentDeleted = delete(consentId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VoiceConsentDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VoiceConsentDeleted

    /** @see delete */
    fun delete(params: VoiceConsentDeleteParams): VoiceConsentDeleted =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(consentId: String, requestOptions: RequestOptions): VoiceConsentDeleted =
        delete(consentId, VoiceConsentDeleteParams.none(), requestOptions)

    /**
     * A view of [VoiceConsentService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceConsentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/voice_consents`, but is otherwise the same
         * as [VoiceConsentService.create].
         */
        @MustBeClosed
        fun create(params: VoiceConsentCreateParams): HttpResponseFor<VoiceConsent> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: VoiceConsentCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsent>

        /**
         * Returns a raw HTTP response for `get /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentService.retrieve].
         */
        @MustBeClosed
        fun retrieve(consentId: String): HttpResponseFor<VoiceConsent> =
            retrieve(consentId, VoiceConsentRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            consentId: String,
            params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsent> =
            retrieve(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            consentId: String,
            params: VoiceConsentRetrieveParams = VoiceConsentRetrieveParams.none(),
        ): HttpResponseFor<VoiceConsent> = retrieve(consentId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: VoiceConsentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsent>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: VoiceConsentRetrieveParams): HttpResponseFor<VoiceConsent> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            consentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VoiceConsent> =
            retrieve(consentId, VoiceConsentRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentService.update].
         */
        @MustBeClosed
        fun update(
            consentId: String,
            params: VoiceConsentUpdateParams,
        ): HttpResponseFor<VoiceConsent> = update(consentId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            consentId: String,
            params: VoiceConsentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsent> =
            update(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: VoiceConsentUpdateParams): HttpResponseFor<VoiceConsent> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: VoiceConsentUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsent>

        /**
         * Returns a raw HTTP response for `get /audio/voice_consents`, but is otherwise the same as
         * [VoiceConsentService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<VoiceConsentListPage> = list(VoiceConsentListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VoiceConsentListParams = VoiceConsentListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsentListPage>

        /** @see list */
        @MustBeClosed
        fun list(
            params: VoiceConsentListParams = VoiceConsentListParams.none()
        ): HttpResponseFor<VoiceConsentListPage> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<VoiceConsentListPage> =
            list(VoiceConsentListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /audio/voice_consents/{consent_id}`, but is
         * otherwise the same as [VoiceConsentService.delete].
         */
        @MustBeClosed
        fun delete(consentId: String): HttpResponseFor<VoiceConsentDeleted> =
            delete(consentId, VoiceConsentDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            consentId: String,
            params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsentDeleted> =
            delete(params.toBuilder().consentId(consentId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            consentId: String,
            params: VoiceConsentDeleteParams = VoiceConsentDeleteParams.none(),
        ): HttpResponseFor<VoiceConsentDeleted> = delete(consentId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: VoiceConsentDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VoiceConsentDeleted>

        /** @see delete */
        @MustBeClosed
        fun delete(params: VoiceConsentDeleteParams): HttpResponseFor<VoiceConsentDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            consentId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VoiceConsentDeleted> =
            delete(consentId, VoiceConsentDeleteParams.none(), requestOptions)
    }
}
