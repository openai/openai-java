package com.openai.core.http

/**
 * A transport rejection that proves a WebSocket write was never attempted. Retrying remains an
 * explicit caller decision. Arbitrary exceptions from other transports do not provide this proof.
 */
interface WebSocketWriteNotAttempted {
    /** The message cannot be admitted. Retains the original IllegalArgumentException contract. */
    class Message(message: String) : IllegalArgumentException(message), WebSocketWriteNotAttempted

    /** The transport is busy. Retains the original IllegalStateException contract. */
    class Busy(message: String) : IllegalStateException(message), WebSocketWriteNotAttempted
}
