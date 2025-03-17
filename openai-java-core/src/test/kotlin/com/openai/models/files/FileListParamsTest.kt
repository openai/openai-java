// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import com.openai.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileListParamsTest {

    @Test
    fun create() {
        FileListParams.builder()
            .after("after")
            .limit(0L)
            .order(FileListParams.Order.ASC)
            .purpose("purpose")
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            FileListParams.builder()
                .after("after")
                .limit(0L)
                .order(FileListParams.Order.ASC)
                .purpose("purpose")
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("after", "after")
                    .put("limit", "0")
                    .put("order", "asc")
                    .put("purpose", "purpose")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
