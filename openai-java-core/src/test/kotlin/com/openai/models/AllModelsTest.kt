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
        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember4()).isEmpty
    }

    @Test
    fun ofChatModel() {
        val chatModel = ChatModel.O3_MINI

        val allModels = AllModels.ofChatModel(chatModel)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).contains(chatModel)
        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember4()).isEmpty
    }

    @Test
    fun ofString() {
        val string = "string"

        val allModels = AllModels.ofString(string)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.string()).contains(string)
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember4()).isEmpty
    }

    @Test
    fun ofChatModel() {
        val chatModel = ChatModel.O3_MINI

        val allModels = AllModels.ofChatModel(chatModel)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).contains(chatModel)
        assertThat(allModels.unionMember4()).isEmpty
    }

    @Test
    fun ofUnionMember4() {
        val unionMember4 = AllModels.UnionMember4.O1_PRO

        val allModels = AllModels.ofUnionMember4(unionMember4)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember4()).contains(unionMember4)
    }
}
