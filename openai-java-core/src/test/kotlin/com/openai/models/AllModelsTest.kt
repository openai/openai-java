// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AllModelsTest {

    @Test
    fun ofString() {
        val string = "string"

        val allModels = AllModels.ofString(string)

        assertThat(allModels.string()).contains(string)
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember2()).isEmpty
    }

    @Test
    fun ofChatModel() {
        val chatModel = ChatModel.O3_MINI

        val allModels = AllModels.ofChatModel(chatModel)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).contains(chatModel)
        assertThat(allModels.unionMember2()).isEmpty
    }

    @Test
    fun ofUnionMember2() {
        val unionMember2 = AllModels.UnionMember2.O1_PRO

        val allModels = AllModels.ofUnionMember2(unionMember2)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember2()).contains(unionMember2)
    }
}
