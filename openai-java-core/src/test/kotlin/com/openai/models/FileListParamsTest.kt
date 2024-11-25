// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.openai.core.http.QueryParams
import com.openai.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileListParamsTest {

    @Test
    fun createFileListParams() {
        FileListParams.builder()
            .after("after")
            .limit(0L)
            .order(FileListParams.Order.ASC)
            .purpose("purpose")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            FileListParams.builder()
                .after("after")
                .limit(0L)
                .order(FileListParams.Order.ASC)
                .purpose("purpose")
                .build()
        val expected = QueryParams.builder()
        expected.put("after", "after")
        expected.put("limit", "0")
        expected.put("order", FileListParams.Order.ASC.toString())
        expected.put("purpose", "purpose")
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = FileListParams.builder().build()
        val expected = QueryParams.builder()
        assertThat(params.getQueryParams()).isEqualTo(expected.build())
    }
}
