@file:JvmName("JsonHandler")

package com.openai.core.handlers

import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.enhanceJacksonException
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler

@JvmSynthetic
internal inline fun <reified T> jsonHandler(jsonMapper: JsonMapper): Handler<T> =
    object : Handler<T> {
        override fun handle(response: HttpResponse): T =
            try {
                jsonMapper.readValue(response.body(), jacksonTypeRef())
            } catch (e: Exception) {
                throw enhanceJacksonException("Error reading response", e)
            }
    }
