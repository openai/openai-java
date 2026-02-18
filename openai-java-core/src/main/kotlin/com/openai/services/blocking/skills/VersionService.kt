// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.skills

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.skills.versions.DeletedSkillVersion
import com.openai.models.skills.versions.SkillVersion
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.skills.versions.VersionDeleteParams
import com.openai.models.skills.versions.VersionListPage
import com.openai.models.skills.versions.VersionListParams
import com.openai.models.skills.versions.VersionRetrieveParams
import com.openai.services.blocking.skills.versions.ContentService
import java.util.function.Consumer

interface VersionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionService

    fun content(): ContentService

    /** Create a new immutable skill version. */
    fun create(skillId: String): SkillVersion = create(skillId, VersionCreateParams.none())

    /** @see create */
    fun create(
        skillId: String,
        params: VersionCreateParams = VersionCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SkillVersion = create(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see create */
    fun create(
        skillId: String,
        params: VersionCreateParams = VersionCreateParams.none(),
    ): SkillVersion = create(skillId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VersionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SkillVersion

    /** @see create */
    fun create(params: VersionCreateParams): SkillVersion = create(params, RequestOptions.none())

    /** @see create */
    fun create(skillId: String, requestOptions: RequestOptions): SkillVersion =
        create(skillId, VersionCreateParams.none(), requestOptions)

    /** Get a specific skill version. */
    fun retrieve(version: String, params: VersionRetrieveParams): SkillVersion =
        retrieve(version, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        version: String,
        params: VersionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SkillVersion = retrieve(params.toBuilder().version(version).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: VersionRetrieveParams): SkillVersion =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VersionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SkillVersion

    /** List skill versions for a skill. */
    fun list(skillId: String): VersionListPage = list(skillId, VersionListParams.none())

    /** @see list */
    fun list(
        skillId: String,
        params: VersionListParams = VersionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionListPage = list(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see list */
    fun list(
        skillId: String,
        params: VersionListParams = VersionListParams.none(),
    ): VersionListPage = list(skillId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: VersionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VersionListPage

    /** @see list */
    fun list(params: VersionListParams): VersionListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(skillId: String, requestOptions: RequestOptions): VersionListPage =
        list(skillId, VersionListParams.none(), requestOptions)

    /** Delete a skill version. */
    fun delete(version: String, params: VersionDeleteParams): DeletedSkillVersion =
        delete(version, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        version: String,
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedSkillVersion = delete(params.toBuilder().version(version).build(), requestOptions)

    /** @see delete */
    fun delete(params: VersionDeleteParams): DeletedSkillVersion =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedSkillVersion

    /** A view of [VersionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionService.WithRawResponse

        fun content(): ContentService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /skills/{skill_id}/versions`, but is otherwise the
         * same as [VersionService.create].
         */
        @MustBeClosed
        fun create(skillId: String): HttpResponseFor<SkillVersion> =
            create(skillId, VersionCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            skillId: String,
            params: VersionCreateParams = VersionCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SkillVersion> =
            create(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(
            skillId: String,
            params: VersionCreateParams = VersionCreateParams.none(),
        ): HttpResponseFor<SkillVersion> = create(skillId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: VersionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SkillVersion>

        /** @see create */
        @MustBeClosed
        fun create(params: VersionCreateParams): HttpResponseFor<SkillVersion> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(skillId: String, requestOptions: RequestOptions): HttpResponseFor<SkillVersion> =
            create(skillId, VersionCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}/versions/{version}`, but is
         * otherwise the same as [VersionService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            version: String,
            params: VersionRetrieveParams,
        ): HttpResponseFor<SkillVersion> = retrieve(version, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            version: String,
            params: VersionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SkillVersion> =
            retrieve(params.toBuilder().version(version).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: VersionRetrieveParams): HttpResponseFor<SkillVersion> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: VersionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SkillVersion>

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}/versions`, but is otherwise the
         * same as [VersionService.list].
         */
        @MustBeClosed
        fun list(skillId: String): HttpResponseFor<VersionListPage> =
            list(skillId, VersionListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            skillId: String,
            params: VersionListParams = VersionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionListPage> =
            list(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            skillId: String,
            params: VersionListParams = VersionListParams.none(),
        ): HttpResponseFor<VersionListPage> = list(skillId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VersionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VersionListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: VersionListParams): HttpResponseFor<VersionListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            skillId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VersionListPage> =
            list(skillId, VersionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /skills/{skill_id}/versions/{version}`, but is
         * otherwise the same as [VersionService.delete].
         */
        @MustBeClosed
        fun delete(
            version: String,
            params: VersionDeleteParams,
        ): HttpResponseFor<DeletedSkillVersion> = delete(version, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            version: String,
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedSkillVersion> =
            delete(params.toBuilder().version(version).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: VersionDeleteParams): HttpResponseFor<DeletedSkillVersion> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedSkillVersion>
    }
}
