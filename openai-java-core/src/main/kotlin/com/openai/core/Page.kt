// File generated from our OpenAPI spec by Stainless.

package com.openai.core

/**
 * An interface representing a single page, with items of type [T], from a paginated endpoint
 * response.
 *
 * Implementations of this interface are expected to request additional pages synchronously. For
 * asynchronous pagination, see the [PageAsync] interface.
 */
interface Page<T> {

    /**
     * Returns whether there's another page after this one.
     *
     * The method generally doesn't make requests so the result depends entirely on the data in this
     * page. If a significant amount of time has passed between requesting this page and calling
     * this method, then the result could be stale.
     */
    fun hasNextPage(): Boolean

    /**
     * Returns the page after this one by making another request.
     *
     * @throws IllegalStateException if it's impossible to get the next page. This exception is
     *   avoidable by calling [hasNextPage] first.
     */
    fun nextPage(): Page<T>

    /** Returns the items in this page. */
    fun items(): List<T>
}
