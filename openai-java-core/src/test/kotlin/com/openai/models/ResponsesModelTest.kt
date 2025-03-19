// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponsesModelTest {

    @Test
    fun ofString() {
        val string = "string"

        val responsesModel = ResponsesModel.ofString(string)

        assertThat(responsesModel.string()).contains(string)
        assertThat(responsesModel.chat()).isEmpty
        assertThat(responsesModel.unionMember2()).isEmpty
    }

    @Test
    fun ofChat() {
        val chat = ChatModel.O3_MINI

        val responsesModel = ResponsesModel.ofChat(chat)

        assertThat(responsesModel.string()).isEmpty
        assertThat(responsesModel.chat()).contains(chat)
        assertThat(responsesModel.unionMember2()).isEmpty
    }

    @Test
    fun ofUnionMember2() {
        val unionMember2 = ResponsesModel.UnionMember2.O1_PRO

        val responsesModel = ResponsesModel.ofUnionMember2(unionMember2)

        assertThat(responsesModel.string()).isEmpty
        assertThat(responsesModel.chat()).isEmpty
        assertThat(responsesModel.unionMember2()).contains(unionMember2)
    }
}
