package com.openai.core

import com.fasterxml.jackson.annotation.JsonClassDescription
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyDescription
import com.fasterxml.jackson.annotation.JsonTypeName
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.node.ObjectNode
import com.openai.errors.OpenAIInvalidDataException
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatNoException
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.AfterTestExecutionCallback
import org.junit.jupiter.api.extension.RegisterExtension

/** Tests for the `StructuredOutputs` functions and the [JsonSchemaValidator]. */
internal class StructuredOutputsTest {
    companion object {
        private const val SCHEMA = "\$schema"
        private const val SCHEMA_VER = "https://json-schema.org/draft/2020-12/schema"
        private const val DEFS = "\$defs"
        private const val REF = "\$ref"

        /**
         * `true` to print the schema and validation errors for all executed tests, or `false` to
         * print them only for failed tests.
         */
        private const val VERBOSE_MODE = false

        private fun parseJson(schemaString: String) = ObjectMapper().readTree(schemaString)
    }

    /**
     * A validator that can be used by each unit test. A new validation instance is created for each
     * test, as each test is run from its own instance of the test class. If a test fails, any
     * validation errors are automatically printed to standard output to aid diagnosis.
     */
    val validator = JsonSchemaValidator.create()

    /**
     * The schema that was created by the unit test. This may be printed out after a test fails to
     * aid in diagnosing the cause of the failure. In that case, this property must be set, or an
     * error will occur. However, it will only be printed if the failed test method has the name
     * prefix `schemaTest_`, so only test methods with that naming pattern need to set this field.
     */
    lateinit var schema: JsonNode

    /**
     * An extension to JUnit that prints the [schema] and the validation status (including any
     * errors) when a test fails. This applies only to test methods whose names are prefixed with
     * `schemaTest_`. An error will occur if [schema] was not set, but this can be avoided by only
     * using the method name prefix for test methods that set [schema]. This reporting is intended
     * as an aid to diagnosing test failures.
     */
    @Suppress("unused")
    @RegisterExtension
    val printValidationErrorsOnFailure: AfterTestExecutionCallback =
        AfterTestExecutionCallback { context ->
            if (
                context.displayName.startsWith("schemaTest_") &&
                    (VERBOSE_MODE || context.executionException.isPresent)
            ) {
                // Test failed.
                println("Schema: ${schema.toPrettyString()}\n")
                println("$validator\n")
            }
        }

    // NOTE: In most of these tests, it is assumed that the schema is generated as expected; it is
    // not examined in fine detail if the validator succeeds or fails with the expected errors.

    @Test
    fun schemaTest_minimalSchema() {
        class X()

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Expect a failure. If a class has no properties, then the schema is meaningless to the
        // AI. It can only reply with values to _named_ properties, so there must be at least one.
        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .startsWith("#: 'properties' field is missing, empty or not an object.")
    }

    @Test
    fun schemaTest_mapHasNoNamedProperties() {
        @Suppress("unused") class X(val m: Map<String, Integer>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // A map results in a schema that declares an "object" sub-schema, but that sub-schema has
        // no named `"properties"` and no `"required"` array. Only the first problem is reported.
        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .startsWith("#/properties/m: 'properties' field is missing, empty or not an object.")

        // Do this check of `toString()` once for a validation failure, but do not repeat it in
        // other tests.
        assertThat(validator.toString())
            .startsWith(
                "JsonSchemaValidator{isValidationComplete=true, totalStringLength=1, " +
                    "totalObjectProperties=1, totalEnumValues=0, errors=[" +
                    "#/properties/m: 'properties' field is missing, empty or not an object."
            )
    }

    @Test
    fun schemaTest_minimalListSchema() {
        val s: List<String> = listOf()

        schema = extractSchema(s.javaClass)
        validator.validate(schema)

        // Currently, the generated schema looks like this:
        //
        //     {
        //         "$schema" : "https://json-schema.org/draft/2020-12/schema",
        //         "type" : "array",
        //         "items" : { }
        //     }
        //
        // That causes an error, as the `"items"` object is empty when it should be a valid
        // sub-schema. Something like this is what would be valid:
        //
        //     {
        //         "$schema" : "https://json-schema.org/draft/2020-12/schema",
        //         "type" : "array",
        //         "items" : {
        //             "type" : "string"
        //         }
        //     }
        //
        // The reason for the failure is that generic type information is erased for scopes like
        // local variables, but generic type information for fields is retained as part of the class
        // metadata. This is the expected behavior in Java, so this test expects an invalid schema.
        //
        // The `extractSchema` function could be defined to accept type parameters and these could
        // be passed to the schema generator (which accepts them) and the above would work. However,
        // there would be no simple way to deserialize the JSON response back to a parameterized
        // type like `List<String>` without again providing the type parameters.
        assertThat(validator.isValid()).isFalse
        assertThat(validator.errors()).hasSize(2)
        assertThat(validator.errors()[0]).isEqualTo("#/items: Schema or sub-schema is empty.")
        assertThat(validator.errors()[1])
            .isEqualTo("#/items: Expected exactly one of 'type' or 'anyOf' or '$REF'.")
    }

    @Test
    fun schemaTest_listFieldSchema() {
        @Suppress("unused") class X(val s: List<String>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    // This gives a root schema with `"type" : "string"` and `"const" : "HELLO"`
    // Unfortunately, an "enum class" cannot be defined within a function or within a class within
    // a function.
    @Suppress("unused")
    enum class MinimalEnum1 {
        HELLO
    }

    @Test
    fun schemaTest_minimalEnumSchema1() {
        schema = extractSchema(MinimalEnum1::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    // This gives a root schema with `"type" : "string"` and `"enum" : [ "HELLO", "WORLD" ]`
    @Suppress("unused")
    enum class MinimalEnum2 {
        HELLO,
        WORLD,
    }

    @Test
    fun schemaTest_minimalEnumSchema2() {
        schema = extractSchema(MinimalEnum2::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue

        // Do this check of `toString()` once for a validation success, but do not repeat it in
        // other tests.
        assertThat(validator.toString())
            .isEqualTo(
                "JsonSchemaValidator{isValidationComplete=true, totalStringLength=10, " +
                    "totalObjectProperties=0, totalEnumValues=2, errors=[]}"
            )
    }

    @Test
    fun schemaTest_nonStringEnum() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "integer",
                    "enum" : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinySchema() {
        @Suppress("unused") class X(val s: String)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinySchemaFromOptionalString() {
        // Using an `Optional<String>` will result in this JSON: `"type" : [ "string", "null" ]`.
        // That is supported by the OpenAI Structured Outputs API spec, as long as the field is also
        // marked as required. Though required, it is still allowed for the field to be explicitly
        // set to `"null"`.
        @Suppress("unused") class X(val s: Optional<String>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinySchemaFromOptionalBoolean() {
        @Suppress("unused") class X(val b: Optional<Boolean>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinySchemaFromOptionalInteger() {
        @Suppress("unused") class X(val i: Optional<Long>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinySchemaFromOptionalNumber() {
        @Suppress("unused") class X(val n: Optional<Double>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_arraySchemaFromOptional() {
        @Suppress("unused") class X(val s: Optional<List<String>>)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_arrayTypeMissingItems() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "array"
                }
                """
            )
        validator.validate(schema)

        // Check once here that "validator.isValid()" returns "false" when there is an error. In
        // the other tests, there is no need to repeat this assertion, as it would be redundant.
        assertThat(validator.isValid()).isFalse
        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'items' field is missing or is not an object.")
    }

    @Test
    fun schemaTest_arrayTypeWithWrongItemsType() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "array",
                    "items" : [ "should_not_be_an_array" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'items' field is missing or is not an object.")
    }

    @Test
    @Suppress("unused")
    fun schemaTest_objectSubSchemaFromOptional() {
        class X(val s: Optional<String>)
        class Y(val x: Optional<X>)

        schema = extractSchema(Y::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_badOptionalTypeNotArray() {
        // Testing more for code coverage than for anything expected to go wrong in practice.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : { "type" : "string" }
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'type' field is not a type name or array of type names.")
    }

    @Test
    fun schemaTest_badOptionalTypeNoNull1() {
        // Testing more for code coverage than for anything expected to go wrong in practice.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "string" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/type: Expected exactly two types, both strings.")
    }

    @Test
    fun schemaTest_badOptionalTypeNoNull2() {
        // If "type" is an array, one of the two "type" values must be "null".
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "string", "number" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/type: Expected one type name and one \"null\".")
    }

    @Test
    fun schemaTest_badOptionalTypeNoNull3() {
        // If "type" is an array, there must be two type values only, one of them "null".
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "string", "number", "null" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/type: Expected exactly two types, both strings.")
    }

    @Test
    fun schemaTest_badOptionalTypeNoStringTypeNames() {
        // If "type" is an array, there must be two type values only, one of them "null".
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "string", null ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/type: Expected exactly two types, both strings.")
    }

    @Test
    fun schemaTest_badOptionalTypeAllNull() {
        // If "type" is an array, there must be two type values only, and only one of them "null".
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "null", "null" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/type: Expected one type name and one \"null\".")
    }

    @Test
    fun schemaTest_badOptionalTypeUnknown() {
        // If "type" is an array, there must be two type values only, and only one of them "null".
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "unknown", "null" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0]).isEqualTo("#/type: Unsupported 'type' value: 'unknown'.")
    }

    @Test
    fun schemaTest_goodOptionalTypeNullFirst() {
        // The validator should be lenient about the order of the null/not-null types in the array.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : [ "null", "string" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_tinyRecursiveSchema() {
        @Suppress("unused") class X(val s: String, val x: X?)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_unsupportedKeywords() {
        // OpenAI lists a set of keywords that are not allowed, but the set is not exhaustive. Check
        // that everything named in that set is identified as not allowed, as that is the minimum
        // level of validation expected. Check at the root schema and a sub-schema. There is no need
        // to match the keywords to their expected schema types or be concerned about the values of
        // the keyword fields, which makes testing easier.
        val keywordsNotAllowed =
            listOf(
                "minLength",
                "maxLength",
                "pattern",
                "format",
                "minimum",
                "maximum",
                "multipleOf",
                "patternProperties",
                "unevaluatedProperties",
                "propertyNames",
                "minProperties",
                "maxProperties",
                "unevaluatedItems",
                "contains",
                "minContains",
                "maxContains",
                "minItems",
                "maxItems",
                "uniqueItems",
            )
        val notAllowedUses = keywordsNotAllowed.joinToString(", ") { "\"$it\" : \"\"" }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                         "x" : {
                              "type" : "string",
                              $notAllowedUses
                         }
                    },
                    $notAllowedUses,
                    "additionalProperties" : false,
                    "required" : [ "x" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(keywordsNotAllowed.size * 2)
        keywordsNotAllowed.forEachIndexed { index, keyword ->
            assertThat(validator.errors()[index])
                .isEqualTo("#: Use of '$keyword' is not supported here.")
            assertThat(validator.errors()[index + keywordsNotAllowed.size])
                .isEqualTo("#/properties/x: Use of '$keyword' is not supported here.")
        }
    }

    @Test
    fun schemaTest_propertyNotMarkedRequired() {
        // Use two properties, so the `"required"` array is not empty, but is still not listing
        // _all_ of the properties.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "name" : { "type" : "string" }, 
                        "address" : { "type" : "string" } 
                    },
                    "additionalProperties" : false,
                    "required" : [ "name" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/required: 'properties' field 'address' is not listed as 'required'.")
    }

    @Test
    fun schemaTest_requiredArrayEmpty() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { "name" : { "type" : "string" } },
                    "additionalProperties" : false,
                    "required" : [ ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'required' field is missing, empty or not an array.")
    }

    @Test
    fun schemaTest_requiredArrayNull() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { "name" : { "type" : "string" } },
                    "additionalProperties" : false,
                    "required" : null
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'required' field is missing, empty or not an array.")
    }

    @Test
    fun schemaTest_requiredArrayMissing() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { "name" : { "type" : "string" } },
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'required' field is missing, empty or not an array.")
    }

    @Test
    fun schemaTest_additionalPropertiesMissing() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { "name" : { "type" : "string" } },
                    "required" : [ "name" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'additionalProperties' field is missing or is not set to 'false'.")
    }

    @Test
    fun schemaTest_additionalPropertiesTrue() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { "name" : { "type" : "string" } },
                    "additionalProperties" : true,
                    "required" : [ "name" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: 'additionalProperties' field is missing or is not set to 'false'.")
    }

    @Test
    fun schemaTest_objectPropertiesMissing() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "additionalProperties" : false,
                    "required" : [ ]
                }
                """
            )
        validator.validate(schema)

        // An object must explicitly declare some properties, as no `"additionalProperties"` will
        // be allowed and the AI model will have nothing it can populate.
        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .startsWith("#: 'properties' field is missing, empty or not an object.")
    }

    @Test
    fun schemaTest_objectPropertiesNotObject() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : [ "name", "age" ],
                    "additionalProperties" : false,
                    "required" : [ "name", "age" ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .startsWith("#: 'properties' field is missing, empty or not an object.")
    }

    @Test
    fun schemaTest_objectPropertiesEmpty() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : { },
                    "additionalProperties" : false,
                    "required" : [ ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .startsWith("#: 'properties' field is missing, empty or not an object.")
    }

    @Test
    fun schemaTest_anyOfInRootSchema() {
        // OpenAI does not allow `"anyOf"` to appear at the root level of a schema.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "anyOf" : [ {
                        "type" : "object",
                        "properties" : { "name" : { "type" : "string" } },
                        "additionalProperties" : false,
                        "required" : ["name"]
                    }, {
                        "type" : "array",
                        "items" : {
                            "type" : "object",
                            "properties" : { "name" : { "type" : "string" } },
                            "additionalProperties" : false,
                            "required" : ["name"]
                        }
                    } ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0]).isEqualTo("#: Root schema contains 'anyOf' field.")
    }

    @Test
    fun schemaTest_anyOfNotArray() {
        // Unlikely that this can occur in a generated schema, so this is more about code coverage.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "name" : {
                            "anyOf" : {
                                 "type" : "string"
                            }
                        }
                    },
                    "additionalProperties" : false,
                    "required" : ["name"]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/properties/name: 'anyOf' field is not a non-empty array.")
    }

    @Test
    fun schemaTest_anyOfIsEmptyArray() {
        // Unlikely that this can occur in a generated schema, so this is more about code coverage.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "name" : {
                            "anyOf" : [ ]
                        }
                    },
                    "additionalProperties" : false,
                    "required" : ["name"]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/properties/name: 'anyOf' field is not a non-empty array.")
    }

    @Test
    fun schemaTest_anyOfInSubSchemaArray() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "value" : {
                            "anyOf" : [
                                { "type" : "string" },
                                { "type" : "number" }
                            ]
                        }
                    },
                    "additionalProperties" : false,
                    "required" : ["value"]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_noSchemaFieldRootSchema() {
        @Suppress("unused") class X(val s: String)

        schema = extractSchema(X::class.java)
        (schema as ObjectNode).remove(SCHEMA)
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0]).isEqualTo("#: Root schema missing '$SCHEMA' field.")
    }

    @Test
    @Suppress("unused")
    fun schemaTest_deepNestingAtLimit() {
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)

        schema = extractSchema(Y::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    @Suppress("unused")
    fun schemaTest_deepNestingBeyondLimit() {
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        schema = extractSchema(Z::class.java)
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0]).contains("Current nesting depth is 6, but maximum is 5.")
    }

    @Test
    fun schemaTest_stringEnum250ValueOverSizeLimit() {
        // OpenAI specification: "For a single enum property with string values, the total string
        // length of all enum values cannot exceed 7,500 characters when there are more than 250
        // enum values."

        // This test creates an enum with exactly 250 string values with more than 7,500 characters
        // in total (31 characters per value for a total of 7,750 characters). No error is expected.
        val values = (1..250).joinToString(", ") { "\"%s%03d\"".format("x".repeat(28), it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "string",
                    "enum" : [ $values ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_stringEnum251ValueUnderSizeLimit() {
        // This test creates an enum with exactly 251 string values with fewer than 7,500 characters
        // in total (29 characters per value for a total of 7,279 characters). No error is expected.
        val values = (1..251).joinToString(", ") { "\"%s%03d\"".format("x".repeat(26), it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "string",
                    "enum" : [ $values ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_stringEnum251ValueOverSizeLimit() {
        // This test creates an enum with exactly 251 string values with fewer than 7,500 characters
        // in total (30 characters per value for a total of 7,530 characters). An error is expected.
        val values = (1..251).joinToString(", ") { "\"%s%03d\"".format("x".repeat(27), it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "string",
                    "enum" : [ $values ]
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo(
                "#/enum: Total string length (7530) of values of an enum " +
                    "with 251 values exceeds limit of 7500."
            )
    }

    @Test
    fun schemaTest_totalEnumValuesAtLimit() {
        // OpenAI specification: "A schema may have up to 500 enum values across all enum
        // properties."

        // This test creates two enums with a total of 500 values. The total string length of the
        // values is well within the limits (2,000 characters).
        val valuesA = (1..250).joinToString(", ") { "\"a%03d\"".format(it) }
        val valuesB = (1..250).joinToString(", ") { "\"b%03d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "a" : {
                            "type" : "string",
                            "enum" : [ $valuesA ]
                        },
                        "b" : {
                            "type" : "string",
                            "enum" : [ $valuesB ]
                        }
                    },
                    "required" : [ "a", "b" ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_totalEnumValuesOverLimit() {
        // This test creates two enums with a total of 501 values. The total string length of the
        // values is well within the limits (2,004 characters).
        val valuesA = (1..250).joinToString(", ") { "\"a%03d\"".format(it) }
        val valuesB = (1..251).joinToString(", ") { "\"b%03d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "a" : {
                            "type" : "string",
                            "enum" : [ $valuesA ]
                        },
                        "b" : {
                            "type" : "string",
                            "enum" : [ $valuesB ]
                        }
                    },
                    "required" : [ "a", "b" ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: Total number of enum values (501) exceeds limit of 500.")
    }

    @Test
    fun schemaTest_maxObjectPropertiesAtLimit() {
        // This test creates two object schemas with a total of 100 object properties. OpenAI does
        // not support more than 100 properties total in the whole schema. Two objects are used to
        // ensure that counting is not done per object, but across all objects. Note that each
        // object schema is itself a property, so there are two properties at the top level and 49
        // properties each at the next level. No error is expected, as the limit is not exceeded.
        val propUses =
            (1..49).joinToString(", ") { "\"x%02d\" : { \"type\" : \"string\" }".format(it) }
        val propNames = (1..49).joinToString(", ") { "\"x%02d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "a" : {
                            "type" : "object",
                            "properties" : {
                                $propUses
                            },
                            "required" : [ $propNames ],
                            "additionalProperties" : false
                        },
                        "b" : {
                            "type" : "object",
                            "properties" : {
                                $propUses
                            },
                            "required" : [ $propNames ],
                            "additionalProperties" : false
                        }
                    },
                    "required" : [ "a", "b" ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_maxObjectPropertiesOverLimit() {
        // This test creates two object schemas with a total of 101 object properties. OpenAI does
        // not support more than 100 properties total in the whole schema. Expect an error.
        val propUses =
            (1..49).joinToString(", ") { "\"x_%02d\" : { \"type\" : \"string\" }".format(it) }
        val propNames = (1..49).joinToString(", ") { "\"x_%02d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "type" : "object",
                    "properties" : {
                        "a" : {
                            "type" : "object",
                            "properties" : {
                                $propUses
                            },
                            "required" : [ $propNames ],
                            "additionalProperties" : false
                        },
                        "b" : {
                            "type" : "object",
                            "properties" : {
                                $propUses,
                                "property_101" : { "type" : "string" }
                            },
                            "required" : [ $propNames, "property_101" ],
                            "additionalProperties" : false
                        }
                    },
                    "required" : [ "a", "b" ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: Total number of object properties (101) exceeds limit of 100.")
    }

    @Test
    fun schemaTest_maxStringLengthAtLimit() {
        // OpenAI specification: "In a schema, total string length of all property names, definition
        // names, enum values, and const values cannot exceed 15,000 characters."
        //
        // This test creates a schema with many property names, definition names, enum values, and
        // const values calculated to have a total string length of 15,000 characters. No error is
        // expected.
        //
        // The test creates a schema that looks like the following, with the numbers adjusted to
        // achieve a total of 15,000 characters for the relevant elements.
        //
        //    {
        //        "$schema" : "...",
        //        "$defs" : {
        //            "d_001" : {
        //                "type" : "string",
        //                "const" : "c_001"
        //            },
        //            ...,
        //            "d_nnn" : {
        //                "type" : "string",
        //                "const" : "c_nnn"
        //            }
        //        },
        //        "type" : "object",
        //        "properties" : {
        //            "p_001" : {
        //                "type" : "string",
        //                "enum" : [ "eeeee..._001", ..., "eeeee..._nnn" ]
        //            },
        //            ...,
        //            "p_nnn" : {
        //                "type" : "string",
        //                "enum" : [ "eeeee..._001", ..., "eeeee..._nnn" ]
        //            }
        //        },
        //        "required" : [ "p_001", ..., "p_nnn" ],
        //        "additionalProperties" : false
        //    }

        val numDefs = 65 // Each also has one "const" value.
        val numProps = 70 // Each also has "numEnumValues" enum values.
        val nameLen = 5 // Length of names of definitions, properties and const values.
        val numEnumValues = 5 // numProps * numEnumValues <= 500 limit (OpenAI)
        val enumValueLen = 40 // Length of enum values.
        val expectedTotalStringLength =
            nameLen * (numProps + numDefs * 2) + numProps * enumValueLen * numEnumValues

        val enumValues =
            (1..numEnumValues).joinToString(", ") { "\"%s_%03d\"".format("e".repeat(36), it) }
        val defs =
            (1..numDefs).joinToString(", ") {
                "\"d_%03d\" : { \"type\" : \"string\", \"const\" : \"c_%03d\" }".format(it, it)
            }
        val props =
            (1..numProps).joinToString(", ") {
                "\"p_%03d\" : { \"type\" : \"string\", \"enum\" : [ $enumValues ] }".format(it)
            }
        val propNames = (1..numProps).joinToString(", ") { "\"p_%03d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "$DEFS" : { $defs },
                    "type" : "object",
                    "properties" : { $props },
                    "required" : [ $propNames ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(expectedTotalStringLength).isEqualTo(15_000) // Exactly on the limit.
        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_maxStringLengthOverLimit() {
        // OpenAI specification: "In a schema, total string length of all property names, definition
        // names, enum values, and const values cannot exceed 15,000 characters."
        //
        // This test creates a schema with many property names, definition names, enum values, and
        // const values calculated to have a total string length of just over 15,000 characters. An
        // error is expected.

        val numDefs = 66 // Each also has one "const" value.
        val numProps = 70 // Each also has "numEnumValues" enum values.
        val numEnumValues = 5 // numProps * numEnumValues <= 500 limit (OpenAI)
        val nameLen = 5 // Length of names of definitions, properties and const values.
        val enumValueLen = 40 // Length of enum values.
        val expectedTotalStringLength =
            nameLen * (numProps + numDefs * 2) + numProps * enumValueLen * numEnumValues

        val enumValues =
            (1..numEnumValues).joinToString(", ") { "\"%s_%03d\"".format("e".repeat(36), it) }
        val defs =
            (1..numDefs).joinToString(", ") {
                "\"d_%03d\" : { \"type\" : \"string\", \"const\" : \"c_%03d\" }".format(it, it)
            }
        val props =
            (1..numProps).joinToString(", ") {
                "\"p_%03d\" : { \"type\" : \"string\", \"enum\" : [ $enumValues ] }".format(it)
            }
        val propNames = (1..numProps).joinToString(", ") { "\"p_%03d\"".format(it) }

        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "$DEFS" : { $defs },
                    "type" : "object",
                    "properties" : { $props },
                    "required" : [ $propNames ],
                    "additionalProperties" : false
                }
                """
            )
        validator.validate(schema)

        assertThat(expectedTotalStringLength).isGreaterThan(15_000)
        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#: Total string length of all values (15010) exceeds limit of 15000.")
    }

    @Test
    fun schemaTest_annotatedWithJsonClassDescription() {
        // Add a "description" to the root schema using an annotation.
        @Suppress("unused") @JsonClassDescription("A simple schema.") class X(val s: String)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Assume that the schema is well-formed.
        val desc = schema.get("description")

        assertThat(validator.isValid()).isTrue
        assertThat(desc).isNotNull
        assertThat(desc.isTextual).isTrue
        assertThat(desc.asText()).isEqualTo("A simple schema.")
    }

    @Test
    fun schemaTest_annotatedWithJsonPropertyDescription() {
        // Add a "description" to the property using an annotation.
        @Suppress("unused") class X(@get:JsonPropertyDescription("A string value.") val s: String)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Assume that the schema is well-formed.
        val properties = schema.get("properties")
        val stringProperty = properties.get("s")
        val desc = stringProperty.get("description")

        assertThat(validator.isValid()).isTrue
        assertThat(desc).isNotNull
        assertThat(desc.isTextual).isTrue
        assertThat(desc.asText()).isEqualTo("A string value.")
    }

    @Test
    fun schemaTest_annotatedWithJsonProperty() {
        // Override the default name of the property using the annotation.
        @Suppress("unused") class X(@get:JsonProperty("a_string") val s: String)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Assume that the schema is well-formed.
        val properties = schema.get("properties")
        val stringProperty = properties.get("a_string")

        assertThat(validator.isValid()).isTrue
        assertThat(stringProperty).isNotNull
    }

    @Test
    fun schemaTest_annotatedWithJsonPropertyRejectDefaultValue() {
        // Set a default value for the property. It should be ignored when the schema is generated,
        // as default property values are not supported in OpenAI JSON schemas. (The Victools docs
        // have examples of how to add support for this default values via annotations or initial
        // values, should support for default values be needed in the future.)
        //
        // Lack of support is not mentioned in the specification, but see the evidence at:
        // https://engineering.fractional.ai/openai-structured-output-fixes
        @Suppress("unused")
        class X(
            @get:JsonProperty(defaultValue = "default_value_1") val s: String = "default_value_2"
        )

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Assume that the schema is well-formed.
        val properties = schema.get("properties")
        val stringProperty = properties.get("s")

        assertThat(validator.isValid()).isTrue
        assertThat(stringProperty).isNotNull
        assertThat(stringProperty.get("default")).isNull()
    }

    @Test
    fun schemaTest_annotatedWithJsonIgnore() {
        // Override the default name of the property using the annotation.
        @Suppress("unused") class X(@get:JsonIgnore val s1: String, val s2: String)

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Assume that the schema is well-formed.
        val properties = schema.get("properties")
        val s1Property = properties.get("s1")
        val s2Property = properties.get("s2")

        assertThat(validator.isValid()).isTrue
        assertThat(s1Property).isNull()
        assertThat(s2Property).isNotNull
    }

    @Test
    fun schemaTest_emptyDefinitions() {
        // Be lenient about empty definitions.
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "$DEFS" : { },
                    "type" : "string"
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun schemaTest_referenceMissingReferent() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "$DEFS" : { },
                    "$REF" : "#/$DEFS/Person"
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0])
            .isEqualTo("#/$REF: Invalid or unsupported reference: '#/$DEFS/Person'.")
    }

    @Test
    fun schemaTest_referenceFieldIsNotTextual() {
        schema =
            parseJson(
                """
                {
                    "$SCHEMA" : "$SCHEMA_VER",
                    "$DEFS" : { },
                    "$REF" : 42
                }
                """
            )
        validator.validate(schema)

        assertThat(validator.errors()).hasSize(1)
        assertThat(validator.errors()[0]).isEqualTo("#/$REF: '$REF' field is not a text value.")
    }

    @Test
    fun validatorBeforeValidation() {
        assertThat(validator.errors()).isEmpty()
        assertThat(validator.isValid()).isFalse

        // Do this check of `toString()` once for an unused validator, but do not repeat it in other
        // tests.
        assertThat(validator.toString())
            .isEqualTo(
                "JsonSchemaValidator{isValidationComplete=false, totalStringLength=0, " +
                    "totalObjectProperties=0, totalEnumValues=0, errors=[]}"
            )
    }

    @Test
    fun validatorReused() {
        class X()

        schema = extractSchema(X::class.java)
        validator.validate(schema)

        // Should fail if an attempt is made to reuse the validator.
        assertThatThrownBy { validator.validate(schema) }
            .isExactlyInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Validation already complete.")
    }

    @Test
    @Suppress("unused")
    fun schemaTest_largeLaureatesSchema() {
        // This covers many cases: large and complex "$defs", resolution of references, recursive
        // references, etc. The output is assumed to be good (it has been checked by eye) and the
        // test just shows that the validator can handle the complexity without crashing or emitting
        // spurious errors.
        class Name(val givenName: String, val familyName: String)

        class Person(
            @get:JsonPropertyDescription("The name of the person.") val name: Name,
            @get:JsonProperty(value = "date_of_birth", defaultValue = "unknown_1")
            @get:JsonPropertyDescription("The date of birth of the person.")
            var dateOfBirth: String,
            @get:JsonPropertyDescription("The country of citizenship of the person.")
            var nationality: String,
            // A child being a `Person` results in a recursive schema.
            @get:JsonPropertyDescription("The children (if any) of the person.")
            val children: List<Person>,
        ) {
            @get:JsonPropertyDescription("The other name of the person.")
            var otherName: Name = Name("Bob", "Smith")
        }

        class Laureate(
            val laureate: Person,
            val majorContribution: String,
            val yearOfWinning: String,
            @get:JsonIgnore val favoriteColor: String,
        )

        class Laureates(
            // Two lists results in a `Laureate` definition that is referenced in the schema.
            var laureates1901to1950: List<Laureate>,
            var laureates1951to2025: List<Laureate>,
        )

        schema = extractSchema(Laureates::class.java)
        validator.validate(schema)

        assertThat(validator.isValid()).isTrue
    }

    @Test
    fun fromJsonSuccess() {
        @Suppress("unused") class X(val s: String)

        val x = responseTypeFromJson("{\"s\" : \"hello\"}", X::class.java)

        assertThat(x.s).isEqualTo("hello")
    }

    @Test
    fun fromJsonFailure1() {
        @Suppress("unused") class X(val s: String)

        // Well-formed JSON, but it does not match the schema of class `X`.
        assertThatThrownBy { responseTypeFromJson("{\"wrong\" : \"hello\"}", X::class.java) }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Error parsing JSON: {\"wrong\" : \"hello\"}")
    }

    @Test
    fun fromJsonFailure2() {
        @Suppress("unused") class X(val s: String)

        // Malformed JSON.
        assertThatThrownBy { responseTypeFromJson("{\"truncated", X::class.java) }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessage("Error parsing JSON: {\"truncated")
    }

    @Test
    fun responseFormatFromClassEnablesStrictAdherenceToSchema() {
        @Suppress("unused") class X(val s: String)

        val jsonSchema = responseFormatFromClass(X::class.java)

        // The "strict" flag _must_ be set to ensure that the model's output will _always_ conform
        // to the JSON schema.
        assertThat(jsonSchema.jsonSchema().strict()).isPresent
        assertThat(jsonSchema.jsonSchema().strict().get()).isTrue

        // The `schema()` accessor cannot be called successfully because of the way the field was
        // set to a schema. This is OK, as the serialization will still work. Just confirm the
        // expected failure, so if the conditions change, they will be noticed.
        assertThatThrownBy { jsonSchema.jsonSchema().schema() }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)

        // Use the `_schema()` accessor instead and check that the value is not null or missing.
        assertThat(jsonSchema.jsonSchema()._schema())
            .isNotInstanceOfAny(JsonMissing::class.java, JsonNull::class.java)
    }

    @Test
    @Suppress("unused")
    fun responseFormatFromClassSuccessWithoutValidation() {
        // Exceed the maximum nesting depth, but do not enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatNoException().isThrownBy {
            responseFormatFromClass(Z::class.java, JsonSchemaLocalValidation.NO)
        }
    }

    @Test
    fun responseFormatFromClassSuccessWithValidation() {
        @Suppress("unused") class X(val s: String)

        assertThatNoException().isThrownBy {
            responseFormatFromClass(X::class.java, JsonSchemaLocalValidation.YES)
        }
    }

    @Test
    @Suppress("unused")
    fun responseFormatFromClassFailureWithValidation() {
        // Exceed the maximum nesting depth and enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatThrownBy { responseFormatFromClass(Z::class.java, JsonSchemaLocalValidation.YES) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    @Suppress("unused")
    fun responseFormatFromClassFailureWithValidationDefault() {
        // Confirm that the default value of the `localValidation` argument is `YES` by expecting
        // a validation error when that argument is not given an explicit value.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        // Use default for `localValidation` flag.
        assertThatThrownBy { responseFormatFromClass(Z::class.java) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    fun textConfigFromClassEnablesStrictAdherenceToSchema() {
        @Suppress("unused") class X(val s: String)

        val textConfig = textConfigFromClass(X::class.java)
        val jsonSchema = textConfig.format().get().jsonSchema().get()

        // The "strict" flag _must_ be set to ensure that the model's output will _always_ conform
        // to the JSON schema.
        assertThat(jsonSchema.strict()).isPresent
        assertThat(jsonSchema.strict().get()).isTrue

        // The `schema()` accessor cannot be called successfully because of the way the field was
        // set to a schema. This is OK, as the serialization will still work. Just confirm the
        // expected failure, so if the conditions change, they will be noticed.
        assertThatThrownBy { jsonSchema.schema() }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)

        // Use the `_schema()` accessor instead and check that the value is not null or missing.
        assertThat(jsonSchema._schema())
            .isNotInstanceOfAny(JsonMissing::class.java, JsonNull::class.java)
    }

    @Test
    @Suppress("unused")
    fun textConfigFromClassSuccessWithoutValidation() {
        // Exceed the maximum nesting depth, but do not enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatNoException().isThrownBy {
            textConfigFromClass(Z::class.java, JsonSchemaLocalValidation.NO)
        }
    }

    @Test
    fun textConfigFromClassSuccessWithValidation() {
        @Suppress("unused") class X(val s: String)

        assertThatNoException().isThrownBy {
            textConfigFromClass(X::class.java, JsonSchemaLocalValidation.YES)
        }
    }

    @Test
    @Suppress("unused")
    fun textConfigFromClassFailureWithValidation() {
        // Exceed the maximum nesting depth and enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatThrownBy { textConfigFromClass(Z::class.java, JsonSchemaLocalValidation.YES) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    @Suppress("unused")
    fun textConfigFromClassFailureWithValidationDefault() {
        // Confirm that the default value of the `localValidation` argument is `YES` by expecting
        // a validation error when that argument is not given an explicit value.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        // Use default for `localValidation` flag.
        assertThatThrownBy { textConfigFromClass(Z::class.java) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    fun extractFunctionInfoUsingClassNameAndNoDescription() {
        @Suppress("unused") class X(val s: String)

        val info = extractFunctionInfo(X::class.java, JsonSchemaLocalValidation.NO)

        assertThat(info.name).isEqualTo("X")
        assertThat(info.description).isNull()
    }

    @Test
    fun extractFunctionInfoUsingAnnotationNameAndNoDescription() {
        @Suppress("unused") @JsonTypeName("fnX") class X(val s: String)

        val info = extractFunctionInfo(X::class.java, JsonSchemaLocalValidation.NO)

        assertThat(info.name).isEqualTo("fnX")
        assertThat(info.description).isNull()
    }

    @Test
    fun extractFunctionInfoUsingClassNameAndAnnotationDescription() {
        @Suppress("unused") @JsonClassDescription("Something about X") class X(val s: String)

        val info = extractFunctionInfo(X::class.java, JsonSchemaLocalValidation.NO)

        assertThat(info.name).isEqualTo("X")
        assertThat(info.description).isEqualTo("Something about X")
        // If the description annotation is set, it will be added to the schema by the generator,
        // but should them be moved out by `extractFunctionInfo` into the function info.
        assertThat(info.schema.get("description")).isNull()
    }

    @Test
    fun functionToolFromClassEnablesStrictAdherenceToSchema() {
        @Suppress("unused") @JsonClassDescription("Something about X") class X(val s: String)

        val functionTool = functionToolFromClass(X::class.java)
        val fnDef = functionTool.function()

        // The "strict" flag _must_ be set to ensure that the model's output will _always_ conform
        // to the JSON schema.
        assertThat(fnDef.strict()).isPresent
        assertThat(fnDef.strict().get()).isTrue
        // Test here that the name, description and parameters (schema) are applied. There is no
        // need to test these again for the other cases.
        assertThat(fnDef.name()).isEqualTo("X")
        assertThat(fnDef.description()).isPresent
        assertThat(fnDef.description().get()).isEqualTo("Something about X")

        // The `parameters()` accessor cannot be called successfully because of the way the field
        // was set to a schema. This is OK, as the serialization will still work. Just confirm the
        // expected failure, so if the conditions change, they will be noticed.
        assertThatThrownBy { fnDef.parameters() }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)

        // Use the `_parameters()` accessor instead and check that the value is not null or missing.
        assertThat(fnDef._parameters())
            .isNotInstanceOfAny(JsonMissing::class.java, JsonNull::class.java)
    }

    @Test
    @Suppress("unused")
    fun functionToolFromClassSuccessWithoutValidation() {
        // Exceed the maximum nesting depth, but do not enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatNoException().isThrownBy {
            functionToolFromClass(Z::class.java, JsonSchemaLocalValidation.NO)
        }
    }

    @Test
    fun functionToolFromClassSuccessWithValidation() {
        @Suppress("unused") class X(val s: String)

        assertThatNoException().isThrownBy {
            functionToolFromClass(X::class.java, JsonSchemaLocalValidation.YES)
        }
    }

    @Test
    @Suppress("unused")
    fun functionToolFromClassFailureWithValidation() {
        // Exceed the maximum nesting depth and enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatThrownBy { functionToolFromClass(Z::class.java, JsonSchemaLocalValidation.YES) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    @Suppress("unused")
    fun functionToolFromClassFailureWithValidationDefault() {
        // Confirm that the default value of the `localValidation` argument is `YES` by expecting a
        // validation error when that argument is not given an explicit value.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        // Use default for `localValidation` flag.
        assertThatThrownBy { functionToolFromClass(Z::class.java) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    fun responseFunctionToolFromClassEnablesStrictAdherenceToSchema() {
        @Suppress("unused") @JsonClassDescription("Something about X") class X(val s: String)

        val fnTool = responseFunctionToolFromClass(X::class.java)

        // The "strict" flag _must_ be set to ensure that the model's output will _always_ conform
        // to the JSON schema.
        assertThat(fnTool.strict()).isPresent
        assertThat(fnTool.strict().get()).isTrue
        // Test here that the name, description and parameters (schema) are applied. There is no
        // need to test these again for the other cases.
        assertThat(fnTool.name()).isEqualTo("X")
        assertThat(fnTool.description()).isPresent
        assertThat(fnTool.description().get()).isEqualTo("Something about X")

        // The `parameters()` accessor cannot be called successfully because of the way the field
        // was set to a schema. This is OK, as the serialization will still work. Just confirm the
        // expected failure, so if the conditions change, they will be noticed.
        assertThatThrownBy { fnTool.parameters() }
            .isExactlyInstanceOf(OpenAIInvalidDataException::class.java)

        // Use the `_parameters()` accessor instead and check that the value is not null or missing.
        assertThat(fnTool._parameters())
            .isNotInstanceOfAny(JsonMissing::class.java, JsonNull::class.java)
    }

    @Test
    @Suppress("unused")
    fun responseFunctionToolFromClassSuccessWithoutValidation() {
        // Exceed the maximum nesting depth, but do not enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatNoException().isThrownBy {
            responseFunctionToolFromClass(Z::class.java, JsonSchemaLocalValidation.NO)
        }
    }

    @Test
    fun responseFunctionToolFromClassSuccessWithValidation() {
        @Suppress("unused") class X(val s: String)

        assertThatNoException().isThrownBy {
            responseFunctionToolFromClass(X::class.java, JsonSchemaLocalValidation.YES)
        }
    }

    @Test
    @Suppress("unused")
    fun responseFunctionToolFromClassFailureWithValidation() {
        // Exceed the maximum nesting depth and enable validation.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        assertThatThrownBy {
                responseFunctionToolFromClass(Z::class.java, JsonSchemaLocalValidation.YES)
            }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    @Suppress("unused")
    fun responseFunctionToolFromClassFailureWithValidationDefault() {
        // Confirm that the default value of the `localValidation` argument is `YES` by expecting
        // a validation error when that argument is not given an explicit value.
        class U(val s: String)
        class V(val u: U)
        class W(val v: V)
        class X(val w: W)
        class Y(val x: X)
        class Z(val y: Y)

        // Use default for `localValidation` flag.
        assertThatThrownBy { responseFunctionToolFromClass(Z::class.java) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(
                "Local validation failed for JSON schema derived from ${Z::class.java}:\n" +
                    " - #/properties/y/properties/x/properties/w/properties/v/properties/u" +
                    "/properties/s: Current nesting depth is 6, but maximum is 5."
            )
    }

    @Test
    fun toJsonString() {
        val boolPrimitive = toJsonString(true)
        val boolObject = toJsonString(java.lang.Boolean.TRUE)
        val numberPrimitive = toJsonString(42)
        val numberObject = toJsonString(Integer.valueOf(42))
        val stringObject = toJsonString("Hello, World!")
        val optional = toJsonString(Optional.of("optional"))
        val optionalNullable = toJsonString(Optional.ofNullable(null))

        assertThat(boolPrimitive).isEqualTo("true")
        assertThat(boolObject).isEqualTo("true")
        assertThat(numberPrimitive).isEqualTo("42")
        assertThat(numberObject).isEqualTo("42")
        // String values should be in quotes.
        assertThat(stringObject).isEqualTo("\"Hello, World!\"")
        assertThat(optional).isEqualTo("\"optional\"")
        assertThat(optionalNullable).isEqualTo("null")
    }
}
