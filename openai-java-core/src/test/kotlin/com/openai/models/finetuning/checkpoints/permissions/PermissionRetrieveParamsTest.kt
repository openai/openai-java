// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionRetrieveParamsTest {

    @Test
    fun create() {
        PermissionRetrieveParams.builder()
            .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
            .after("after")
            .limit(0L)
            .order(PermissionRetrieveParams.Order.ASCENDING)
            .projectId("project_id")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            PermissionRetrieveParams.builder()
                .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun queryParams() {
        val params =
            PermissionRetrieveParams.builder()
                .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .after("after")
                .limit(0L)
                .order(PermissionRetrieveParams.Order.ASCENDING)
                .projectId("project_id")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "ascending")
                    .put("project_id", "project_id")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params =
            PermissionRetrieveParams.builder()
                .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
