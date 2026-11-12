# Remove Sora calls when upgrading to Java v5

The Videos API retired on September 24, 2026. Java v5 removes `videos()` from the blocking, asynchronous, and raw-response clients. It also removes the Videos service types, the `com.openai.models.videos` package, and `BatchCreateParams.Endpoint.V1_VIDEOS`.

Remove the corresponding imports and calls, including code that creates, edits, extends, remixes, lists, retrieves, deletes, or downloads videos, or creates and retrieves Sora characters. Remove batch requests that target `/v1/videos`. There is no one-to-one replacement for Sora video generation.

Recompile code that depends on these types. Keeping an older SDK can restore the Java symbols for compilation. The retired service remains unavailable.
