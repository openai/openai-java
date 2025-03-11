package com.openai.models

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.Base64
import java.util.Optional
import kotlin.collections.MutableList

/** Represents an embedding vector returned by embedding endpoint. */
@JsonDeserialize(using = EmbeddingValueDeserializer::class)
class EmbeddingValue(
    var base64Embedding: Optional<String> = Optional.empty(),
    floatEmbedding: Optional<MutableList<Double>> = Optional.empty(),
) {

    /**
     * The embedding vector, which is a list of float32.
     * [embedding guide](https://platform.openai.com/docs/guides/embeddings).
     */
    var floatEmbedding: Optional<MutableList<Double>> = Optional.empty()
        get() {
            if (field.isPresent) {
                return field
            }
            if (base64Embedding.isPresent) {
                field = convertBase64ToFloat(base64Embedding)
            }
            return field
        }
        set(value) {
            field = value
        }

    /**
     * Converting Base64 float32 array to Optional<MutableList>
     *
     * To improve performance, requests are made in Base64 by default. However, not all developers
     * need to decode Base64. Therefore, when a request is made in Base64, the system will
     * internally convert the Base64 data to MutableList<Double> and make this converted data
     * available, allowing developers to obtain both the Base64 data and the MutableList<Double>
     * data by default.
     */
    private fun convertBase64ToFloat(
        base64Embedding: Optional<String>
    ): Optional<MutableList<Double>> {
        // The response of Embedding returns a List<Float>(float32),
        // but the Kotlin API handles MutableList<Double>.
        // If we directly convert from List<Float> to MutableList<Double>,
        // it increases the precision and changing it from float32 to double.
        //
        // Since JSON is assigned to MutableList<Double> from a String of JSON Value,
        // the precision does not increase.
        // Therefore, by first converting the Base64-decoded List<Float> to a String,
        // and then converting the String to Double,
        // we can handle it as MutableList<Double> without increasing the precision.
        return base64Embedding.map { base64String ->
            val decoded = Base64.getDecoder().decode(base64String)
            val byteBuffer = ByteBuffer.wrap(decoded).order(ByteOrder.LITTLE_ENDIAN)

            val floatList = mutableListOf<String>()
            while (byteBuffer.hasRemaining()) {
                floatList.add(byteBuffer.float.toString())
            }
            floatList.map { it.replace("f", "").toDouble() }.toMutableList()
        }
    }

    /**
     * Output the embedding vector as a string. By default, it will be output as both list of floats
     * and Base64 string. if user specifies floatEmbedding, it will be output as list of floats
     * only.
     */
    override fun toString(): String {
        return if (base64Embedding.isPresent) {
            "base64: $base64Embedding, float:  [${floatEmbedding.get().joinToString(", ")}]"
        } else {
            "float:  [${floatEmbedding.get().joinToString(", ")}]"
        }
    }
}
