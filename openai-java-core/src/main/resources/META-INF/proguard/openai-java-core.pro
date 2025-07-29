# Jackson uses reflection and depends heavily on runtime attributes.
-keepattributes

# Jackson uses Kotlin reflection utilities, which themselves use reflection to access things.
-keep class kotlin.reflect.** { *; }
-keep class kotlin.Metadata { *; }

# Jackson uses reflection to access enum members (e.g. via `java.lang.Class.getEnumConstants()`).
-keepclassmembers class com.fasterxml.jackson.** extends java.lang.Enum {
    <fields>;
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Jackson uses reflection to access annotation members.
-keepclassmembers @interface com.fasterxml.jackson.annotation.** {
    *;
}

# Jackson uses reflection to access the default constructors of serializers and deserializers.
-keepclassmembers class * extends com.openai.core.BaseSerializer {
    <init>();
}
-keepclassmembers class * extends com.openai.core.BaseDeserializer {
    <init>();
}

# Jackson uses reflection to serialize and deserialize our classes based on their constructors and annotated members.
-keepclassmembers class com.openai.** {
    <init>(...);
    @com.fasterxml.jackson.annotation.* *;
}