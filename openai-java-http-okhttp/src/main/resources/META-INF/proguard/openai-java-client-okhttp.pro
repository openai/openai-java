# ProGuard 7.10.0 can narrow these return types without updating the cast before areturn.
# Keep the stream adapters verifiable while allowing unused methods to be removed or renamed.
-keepclassmembers,allowshrinking,allowobfuscation class okio.Okio__JvmOkioKt {
    public static okio.Sink sink(java.io.OutputStream);
    public static okio.Source source(java.io.InputStream);
}
