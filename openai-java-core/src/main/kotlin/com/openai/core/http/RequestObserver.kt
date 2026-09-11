package com.openai.core.http

/** Observes request preparation for one invocation of [HttpClient]. */
fun interface RequestObserver {

    /**
     * Called before dispatch, once per attempt, after the transport prepares its request.
     *
     * [url] is the URL from that prepared request, or `null` if the transport cannot report it. It
     * does not include changes made later by interceptors or redirects. The callback may run on a
     * different thread when executing asynchronously.
     *
     * Implementations should return promptly and must not throw. SDK transports ignore runtime
     * exceptions from observers so observation cannot prevent dispatch.
     */
    fun onRequestStart(method: HttpMethod, url: String?)
}
