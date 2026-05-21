// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.dataretention

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DataRetentionUpdateParamsTest {

    @Test
    fun create() {
        DataRetentionUpdateParams.builder()
            .retentionType(DataRetentionUpdateParams.RetentionType.ZERO_DATA_RETENTION)
            .build()
    }

    @Test
    fun body() {
        val params =
            DataRetentionUpdateParams.builder()
                .retentionType(DataRetentionUpdateParams.RetentionType.ZERO_DATA_RETENTION)
                .build()

        val body = params._body()

        assertThat(body.retentionType())
            .isEqualTo(DataRetentionUpdateParams.RetentionType.ZERO_DATA_RETENTION)
    }
}
