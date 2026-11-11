import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.core.http.HttpRequestBody
import com.openai.models.chat.completions.ChatCompletionCreateParams
import java.io.OutputStream
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

data class Answer(val value: String)

fun main() {
    val params =
        ChatCompletionCreateParams.builder()
            .model("test")
            .addUserMessage("return an answer")
            .responseFormat(Answer::class.java)
            .build()
    check(params.rawParams.responseFormat().isPresent)
    val response =
        """{"id":"test","object":"chat.completion","created":0,"model":"test","choices":[
           {"index":0,"finish_reason":"stop","message":{"role":"assistant","content":"{\"value\":\"ok\"}"}}]}"""
    val client =
        OpenAIOkHttpClient.builder()
            .apiKey("fixture")
            .addInterceptor { chain ->
                Response.Builder()
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_1)
                    .code(200)
                    .message("OK")
                    .body(response.toResponseBody("application/json".toMediaType()))
                    .build()
            }
            .build()
    try {
        val answer = client.chat().completions().create(params).choicesOrThrow().single().messageOrThrow().content()
        check(answer.get() == Answer("ok"))
    } finally {
        client.close()
    }

    val body =
        object : HttpRequestBody {
            override fun writeTo(outputStream: OutputStream) = outputStream.write(42)

            override fun close() = Unit

            override fun contentType(): String? = null

            override fun contentLength() = 1L

            override fun repeatable() = true
        }
    val type: String? = body.contentType()
    check(type == null)
    body.content().use { check(it.read() == 42) }
}
