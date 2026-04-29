// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.auditlogs

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AuditLogListParamsTest {

    @Test
    fun create() {
        AuditLogListParams.builder()
            .addActorEmail("string")
            .addActorId("string")
            .after("after")
            .before("before")
            .effectiveAt(
                AuditLogListParams.EffectiveAt.builder().gt(0L).gte(0L).lt(0L).lte(0L).build()
            )
            .addEventType(AuditLogListParams.EventType.API_KEY_CREATED)
            .limit(0L)
            .addProjectId("string")
            .addResourceId("string")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            AuditLogListParams.builder()
                .addActorEmail("string")
                .addActorId("string")
                .after("after")
                .before("before")
                .effectiveAt(
                    AuditLogListParams.EffectiveAt.builder().gt(0L).gte(0L).lt(0L).lte(0L).build()
                )
                .addEventType(AuditLogListParams.EventType.API_KEY_CREATED)
                .limit(0L)
                .addProjectId("string")
                .addResourceId("string")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("actor_emails[]", "string")
                    .put("actor_ids[]", "string")
                    .put("after", "after")
                    .put("before", "before")
                    .put("effective_at[gt]", "0")
                    .put("effective_at[gte]", "0")
                    .put("effective_at[lt]", "0")
                    .put("effective_at[lte]", "0")
                    .put("event_types[]", "api_key.created")
                    .put("limit", "0")
                    .put("project_ids[]", "string")
                    .put("resource_ids[]", "string")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = AuditLogListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
