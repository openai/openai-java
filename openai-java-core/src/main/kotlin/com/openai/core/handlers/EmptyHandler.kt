@file:JvmName("EmptyHandler")

package com.openai.core.handlers

import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
