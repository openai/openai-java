// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.skills

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.skills.versions.DeletedSkillVersion
import com.openai.models.skills.versions.SkillVersion
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.skills.versions.VersionDeleteParams
import com.openai.models.skills.versions.VersionListPageAsync
import com.openai.models.skills.versions.VersionListParams
import com.openai.models.skills.versions.VersionRetrieveParams
import com.openai.services.async.skills.versions.ContentServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface VersionServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VersionServiceAsync

    fun content(): ContentServiceAsync

    /** Create a new immutable skill version. */
    fun create(skillId: String): CompletableFuture<SkillVersion> =
        create(skillId, VersionCreateParams.none())

    /** @see create */
    fun create(
        skillId: String,
        params: VersionCreateParams = VersionCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SkillVersion> =
        create(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see create */
    fun create(
        skillId: String,
        params: VersionCreateParams = VersionCreateParams.none(),
    ): CompletableFuture<SkillVersion> = create(skillId, params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VersionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SkillVersion>

    /** @see create */
    fun create(params: VersionCreateParams): CompletableFuture<SkillVersion> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(skillId: String, requestOptions: RequestOptions): CompletableFuture<SkillVersion> =
        create(skillId, VersionCreateParams.none(), requestOptions)

    /** Get a specific skill version. */
    fun retrieve(version: String, params: VersionRetrieveParams): CompletableFuture<SkillVersion> =
        retrieve(version, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        version: String,
        params: VersionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SkillVersion> =
        retrieve(params.toBuilder().version(version).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: VersionRetrieveParams): CompletableFuture<SkillVersion> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VersionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<SkillVersion>

    /** List skill versions for a skill. */
    fun list(skillId: String): CompletableFuture<VersionListPageAsync> =
        list(skillId, VersionListParams.none())

    /** @see list */
    fun list(
        skillId: String,
        params: VersionListParams = VersionListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionListPageAsync> =
        list(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see list */
    fun list(
        skillId: String,
        params: VersionListParams = VersionListParams.none(),
    ): CompletableFuture<VersionListPageAsync> = list(skillId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: VersionListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VersionListPageAsync>

    /** @see list */
    fun list(params: VersionListParams): CompletableFuture<VersionListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        skillId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VersionListPageAsync> =
        list(skillId, VersionListParams.none(), requestOptions)

    /** Delete a skill version. */
    fun delete(
        version: String,
        params: VersionDeleteParams,
    ): CompletableFuture<DeletedSkillVersion> = delete(version, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        version: String,
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DeletedSkillVersion> =
        delete(params.toBuilder().version(version).build(), requestOptions)

    /** @see delete */
    fun delete(params: VersionDeleteParams): CompletableFuture<DeletedSkillVersion> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VersionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<DeletedSkillVersion>

    /**
     * A view of [VersionServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VersionServiceAsync.WithRawResponse

        fun content(): ContentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /skills/{skill_id}/versions`, but is otherwise the
         * same as [VersionServiceAsync.create].
         */
        fun create(skillId: String): CompletableFuture<HttpResponseFor<SkillVersion>> =
            create(skillId, VersionCreateParams.none())

        /** @see create */
        fun create(
            skillId: String,
            params: VersionCreateParams = VersionCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            create(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see create */
        fun create(
            skillId: String,
            params: VersionCreateParams = VersionCreateParams.none(),
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            create(skillId, params, RequestOptions.none())

        /** @see create */
        fun create(
            params: VersionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SkillVersion>>

        /** @see create */
        fun create(params: VersionCreateParams): CompletableFuture<HttpResponseFor<SkillVersion>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            skillId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            create(skillId, VersionCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}/versions/{version}`, but is
         * otherwise the same as [VersionServiceAsync.retrieve].
         */
        fun retrieve(
            version: String,
            params: VersionRetrieveParams,
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            retrieve(version, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            version: String,
            params: VersionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            retrieve(params.toBuilder().version(version).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: VersionRetrieveParams
        ): CompletableFuture<HttpResponseFor<SkillVersion>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: VersionRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<SkillVersion>>

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}/versions`, but is otherwise the
         * same as [VersionServiceAsync.list].
         */
        fun list(skillId: String): CompletableFuture<HttpResponseFor<VersionListPageAsync>> =
            list(skillId, VersionListParams.none())

        /** @see list */
        fun list(
            skillId: String,
            params: VersionListParams = VersionListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionListPageAsync>> =
            list(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see list */
        fun list(
            skillId: String,
            params: VersionListParams = VersionListParams.none(),
        ): CompletableFuture<HttpResponseFor<VersionListPageAsync>> =
            list(skillId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: VersionListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VersionListPageAsync>>

        /** @see list */
        fun list(
            params: VersionListParams
        ): CompletableFuture<HttpResponseFor<VersionListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            skillId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VersionListPageAsync>> =
            list(skillId, VersionListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /skills/{skill_id}/versions/{version}`, but is
         * otherwise the same as [VersionServiceAsync.delete].
         */
        fun delete(
            version: String,
            params: VersionDeleteParams,
        ): CompletableFuture<HttpResponseFor<DeletedSkillVersion>> =
            delete(version, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            version: String,
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DeletedSkillVersion>> =
            delete(params.toBuilder().version(version).build(), requestOptions)

        /** @see delete */
        fun delete(
            params: VersionDeleteParams
        ): CompletableFuture<HttpResponseFor<DeletedSkillVersion>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VersionDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<DeletedSkillVersion>>
    }
}
