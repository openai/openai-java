// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.skills.DeletedSkill
import com.openai.models.skills.Skill
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.SkillDeleteParams
import com.openai.models.skills.SkillListPage
import com.openai.models.skills.SkillListParams
import com.openai.models.skills.SkillRetrieveParams
import com.openai.models.skills.SkillUpdateParams
import com.openai.services.blocking.skills.ContentService
import com.openai.services.blocking.skills.VersionService
import java.util.function.Consumer

interface SkillService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SkillService

    fun content(): ContentService

    fun versions(): VersionService

    /** Create Skill */
    fun create(): Skill = create(SkillCreateParams.none())

    /** @see create */
    fun create(
        params: SkillCreateParams = SkillCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Skill

    /** @see create */
    fun create(params: SkillCreateParams = SkillCreateParams.none()): Skill =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): Skill =
        create(SkillCreateParams.none(), requestOptions)

    /** Get Skill */
    fun retrieve(skillId: String): Skill = retrieve(skillId, SkillRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        skillId: String,
        params: SkillRetrieveParams = SkillRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Skill = retrieve(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(skillId: String, params: SkillRetrieveParams = SkillRetrieveParams.none()): Skill =
        retrieve(skillId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: SkillRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Skill

    /** @see retrieve */
    fun retrieve(params: SkillRetrieveParams): Skill = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(skillId: String, requestOptions: RequestOptions): Skill =
        retrieve(skillId, SkillRetrieveParams.none(), requestOptions)

    /** Update Skill Default Version */
    fun update(skillId: String, params: SkillUpdateParams): Skill =
        update(skillId, params, RequestOptions.none())

    /** @see update */
    fun update(
        skillId: String,
        params: SkillUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Skill = update(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see update */
    fun update(params: SkillUpdateParams): Skill = update(params, RequestOptions.none())

    /** @see update */
    fun update(
        params: SkillUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Skill

    /** List Skills */
    fun list(): SkillListPage = list(SkillListParams.none())

    /** @see list */
    fun list(
        params: SkillListParams = SkillListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): SkillListPage

    /** @see list */
    fun list(params: SkillListParams = SkillListParams.none()): SkillListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): SkillListPage =
        list(SkillListParams.none(), requestOptions)

    /** Delete Skill */
    fun delete(skillId: String): DeletedSkill = delete(skillId, SkillDeleteParams.none())

    /** @see delete */
    fun delete(
        skillId: String,
        params: SkillDeleteParams = SkillDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedSkill = delete(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see delete */
    fun delete(
        skillId: String,
        params: SkillDeleteParams = SkillDeleteParams.none(),
    ): DeletedSkill = delete(skillId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: SkillDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): DeletedSkill

    /** @see delete */
    fun delete(params: SkillDeleteParams): DeletedSkill = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(skillId: String, requestOptions: RequestOptions): DeletedSkill =
        delete(skillId, SkillDeleteParams.none(), requestOptions)

    /** A view of [SkillService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SkillService.WithRawResponse

        fun content(): ContentService.WithRawResponse

        fun versions(): VersionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /skills`, but is otherwise the same as
         * [SkillService.create].
         */
        @MustBeClosed fun create(): HttpResponseFor<Skill> = create(SkillCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: SkillCreateParams = SkillCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Skill>

        /** @see create */
        @MustBeClosed
        fun create(params: SkillCreateParams = SkillCreateParams.none()): HttpResponseFor<Skill> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Skill> =
            create(SkillCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}`, but is otherwise the same as
         * [SkillService.retrieve].
         */
        @MustBeClosed
        fun retrieve(skillId: String): HttpResponseFor<Skill> =
            retrieve(skillId, SkillRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            skillId: String,
            params: SkillRetrieveParams = SkillRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Skill> =
            retrieve(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            skillId: String,
            params: SkillRetrieveParams = SkillRetrieveParams.none(),
        ): HttpResponseFor<Skill> = retrieve(skillId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: SkillRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Skill>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: SkillRetrieveParams): HttpResponseFor<Skill> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(skillId: String, requestOptions: RequestOptions): HttpResponseFor<Skill> =
            retrieve(skillId, SkillRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /skills/{skill_id}`, but is otherwise the same as
         * [SkillService.update].
         */
        @MustBeClosed
        fun update(skillId: String, params: SkillUpdateParams): HttpResponseFor<Skill> =
            update(skillId, params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            skillId: String,
            params: SkillUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Skill> =
            update(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see update */
        @MustBeClosed
        fun update(params: SkillUpdateParams): HttpResponseFor<Skill> =
            update(params, RequestOptions.none())

        /** @see update */
        @MustBeClosed
        fun update(
            params: SkillUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Skill>

        /**
         * Returns a raw HTTP response for `get /skills`, but is otherwise the same as
         * [SkillService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<SkillListPage> = list(SkillListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: SkillListParams = SkillListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<SkillListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: SkillListParams = SkillListParams.none()): HttpResponseFor<SkillListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<SkillListPage> =
            list(SkillListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /skills/{skill_id}`, but is otherwise the same as
         * [SkillService.delete].
         */
        @MustBeClosed
        fun delete(skillId: String): HttpResponseFor<DeletedSkill> =
            delete(skillId, SkillDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            skillId: String,
            params: SkillDeleteParams = SkillDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedSkill> =
            delete(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            skillId: String,
            params: SkillDeleteParams = SkillDeleteParams.none(),
        ): HttpResponseFor<DeletedSkill> = delete(skillId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: SkillDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<DeletedSkill>

        /** @see delete */
        @MustBeClosed
        fun delete(params: SkillDeleteParams): HttpResponseFor<DeletedSkill> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(skillId: String, requestOptions: RequestOptions): HttpResponseFor<DeletedSkill> =
            delete(skillId, SkillDeleteParams.none(), requestOptions)
    }
}
