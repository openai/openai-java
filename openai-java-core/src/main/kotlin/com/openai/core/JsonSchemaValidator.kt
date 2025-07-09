package com.openai.core

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.JsonSchemaValidator.Companion.MAX_ENUM_TOTAL_STRING_LENGTH
import com.openai.core.JsonSchemaValidator.Companion.UNRESTRICTED_ENUM_VALUES_LIMIT

/**
 * A validator that ensures that a JSON schema complies with the rules and restrictions imposed by
 * the OpenAI API specification for the input schemas used to define structured outputs. Only a
 * subset of the JSON Schema language is supported. The purpose of this validator is to perform a
 * quick check of a schema so that it can be determined to be likely to be accepted when passed in
 * the request for an AI inference.
 *
 * This validator assumes that the JSON schema represents the structure of Java/Kotlin classes; it
 * is not a general-purpose JSON schema validator. Assumptions are also made that the generator will
 * be well-behaved, so the validation is not a check for strict conformance to the JSON Schema
 * specification, but to the OpenAI API specification's restrictions on JSON schemas.
 */
internal class JsonSchemaValidator private constructor() {

    companion object {
        private const val NO_PROPERTIES_DOC =
            "https://github.com/openai/openai-java#defining-json-schema-properties"

        // The names of the supported schema keywords. All other keywords will be rejected.
        private const val SCHEMA = "\$schema"
        private const val ID = "\$id"
        private const val DEFS = "\$defs"
        private const val REF = "\$ref"
        private const val PROPS = "properties"
        private const val ANY_OF = "anyOf"
        private const val TYPE = "type"
        private const val REQUIRED = "required"
        private const val DESC = "description"
        private const val TITLE = "title"
        private const val ITEMS = "items"
        private const val CONST = "const"
        private const val ENUM = "enum"
        private const val ADDITIONAL_PROPS = "additionalProperties"

        private const val PATTERN = "pattern"
        private const val FORMAT = "format"
        private const val MULTIPLE_OF = "multipleOf"
        private const val MINIMUM = "minimum"
        private const val EXCLUSIVE_MINIMUM = "exclusiveMinimum"
        private const val MAXIMUM = "maximum"
        private const val EXCLUSIVE_MAXIMUM = "exclusiveMaximum"
        private const val MIN_ITEMS = "minItems"
        private const val MAX_ITEMS = "maxItems"

        // The names of the supported schema data types.
        //
        // JSON Schema does not define an "integer" type, only a "number" type, but it allows any
        // schema to define its own "vocabulary" of type names. "integer" is supported by OpenAI.
        private const val TYPE_ARRAY = "array"
        private const val TYPE_OBJECT = "object"
        private const val TYPE_BOOLEAN = "boolean"
        private const val TYPE_STRING = "string"
        private const val TYPE_NUMBER = "number"
        private const val TYPE_INTEGER = "integer"
        private const val TYPE_NULL = "null"

        // The following sets define the allowed keywords in different contexts and all others are
        // rejected.

        /**
         * The set of allowed keywords in the root schema only, not including the keywords that are
         * also allowed in a sub-schema.
         */
        private val ALLOWED_KEYWORDS_ROOT_SCHEMA_ONLY = setOf(SCHEMA, ID, DEFS)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"anyOf"` field is
         * present. OpenAI allows the `"anyOf"` field in sub-schemas, but not in the root schema.
         */
        private val ALLOWED_KEYWORDS_ANY_OF_SUB_SCHEMA = setOf(ANY_OF, TITLE, DESC)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"$ref"` field is present.
         */
        private val ALLOWED_KEYWORDS_REF_SUB_SCHEMA = setOf(REF, TITLE, DESC)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"type"` field is set to
         * `"object"`.
         */
        private val ALLOWED_KEYWORDS_OBJECT_SUB_SCHEMA =
            setOf(TYPE, REQUIRED, ADDITIONAL_PROPS, TITLE, DESC, PROPS)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"type"` field is set to
         * `"array"`.
         */
        private val ALLOWED_KEYWORDS_ARRAY_SUB_SCHEMA =
            setOf(TYPE, TITLE, DESC, ITEMS, MIN_ITEMS, MAX_ITEMS)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"type"` field is set to
         * `"boolean"`, or any other simple type not handled separately.
         */
        private val ALLOWED_KEYWORDS_SIMPLE_SUB_SCHEMA = setOf(TYPE, TITLE, DESC, ENUM, CONST)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"type"` field is set to
         * `"string"`.
         */
        private val ALLOWED_KEYWORDS_STRING_SUB_SCHEMA =
            setOf(TYPE, TITLE, DESC, ENUM, CONST, PATTERN, FORMAT)

        /**
         * The set of allowed keywords when defining sub-schemas when the `"type"` field is set to
         * `"integer"` or `"number"`.
         */
        private val ALLOWED_KEYWORDS_NUMBER_SUB_SCHEMA =
            setOf(
                TYPE,
                TITLE,
                DESC,
                ENUM,
                CONST,
                MINIMUM,
                EXCLUSIVE_MINIMUM,
                MAXIMUM,
                EXCLUSIVE_MAXIMUM,
                MULTIPLE_OF,
            )

        /**
         * The maximum total length of all strings used in the schema for property names, definition
         * names, enum values and const values. The OpenAI specification states:
         * > In a schema, total string length of all property names, definition names, enum values,
         * > and const values cannot exceed 15,000 characters.
         */
        private const val MAX_TOTAL_STRING_LENGTH = 15_000

        /** The maximum number of object properties allowed in a schema. */
        private const val MAX_OBJECT_PROPERTIES = 100

        /** The maximum number of enum values across all enums in the schema. */
        private const val MAX_ENUM_VALUES = 500

        /**
         * The number of enum values in any one enum with string values beyond which a limit of
         * [MAX_ENUM_TOTAL_STRING_LENGTH] is imposed on the total length of all the string values of
         * that one enum.
         */
        private const val UNRESTRICTED_ENUM_VALUES_LIMIT = 250

        /**
         * The maximum total length of all string values of a single enum where the number of values
         * exceeds [UNRESTRICTED_ENUM_VALUES_LIMIT].
         */
        private const val MAX_ENUM_TOTAL_STRING_LENGTH = 7_500

        /** The maximum depth (number of levels) of nesting allowed in a schema. */
        private const val MAX_NESTING_DEPTH = 5

        /** The depth value that corresponds to the root level of the schema. */
        private const val ROOT_DEPTH = 0

        /**
         * The path string that identifies the root node in the schema when appearing in error
         * messages or references.
         */
        private const val ROOT_PATH = "#"

        /**
         * Creates a new [JsonSchemaValidator]. After calling [validate], the validator instance
         * holds information about the errors that occurred during validation (if any). A validator
         * instance can be used only once to validate a schema; to validate another schema, create
         * another validator.
         */
        fun create() = JsonSchemaValidator()
    }

    /**
     * The total length of all strings used in the schema for property names, definition names, enum
     * values and const values.
     */
    private var totalStringLength: Int = 0

    /** The total number of values across all enums in the schema. */
    private var totalEnumValues: Int = 0

    /** The total number of object properties found in the schema, including in definitions. */
    private var totalObjectProperties: Int = 0

    /**
     * The set of valid references that may appear in the schema. This set includes the root schema
     * and any definitions within the root schema. This is used to verify that references elsewhere
     * in the schema are valid. This will always contain the root schema, but that may be the only
     * member.
     */
    private var validReferences: MutableSet<String> = mutableSetOf(ROOT_PATH)

    /** The list of error messages accumulated during the validation process. */
    private val errors: MutableList<String> = mutableListOf()

    /**
     * Indicates if this validator has validated a schema or not. If a schema has been validated,
     * this validator cannot be used again.
     */
    private var isValidationComplete = false

    /**
     * Gets the list of errors that were recorded during the validation pass.
     *
     * @return The list of errors. The list may be empty if no errors were recorded. In that case,
     *   the schema was found to be valid, or has not yet been validated by calling [validate].
     */
    fun errors(): List<String> = errors.toImmutable()

    /**
     * Indicates if a validated schema is valid or not.
     *
     * @return `true` if a schema has been validated by calling [validate] and no errors were
     *   reported; or `false` if errors were reported or if a schema has not yet been validated.
     */
    fun isValid(): Boolean = isValidationComplete && errors.isEmpty()

    /**
     * Validates a schema with respect to the OpenAI API specifications.
     *
     * @param rootSchema The root node of the tree representing the JSON schema definition.
     * @return This schema validator for convenience, such as when chaining calls.
     * @throws IllegalStateException If called a second time. Create a new validator to validate
     *   each new schema.
     */
    fun validate(rootSchema: JsonNode): JsonSchemaValidator {
        check(!isValidationComplete) { "Validation already complete." }
        isValidationComplete = true

        validateSchema(rootSchema, ROOT_PATH, ROOT_DEPTH)

        // Verify total counts/lengths. These are not localized to a specific element in the schema,
        // as no one element is the cause of the error; it is the combination of all elements that
        // exceed the limits. Therefore, the root path is used in the error messages.
        verify(totalEnumValues <= MAX_ENUM_VALUES, ROOT_PATH) {
            "Total number of enum values ($totalEnumValues) exceeds limit of $MAX_ENUM_VALUES."
        }
        verify(totalStringLength <= MAX_TOTAL_STRING_LENGTH, ROOT_PATH) {
            "Total string length of all values ($totalStringLength) exceeds " +
                "limit of $MAX_TOTAL_STRING_LENGTH."
        }
        verify(totalObjectProperties <= MAX_OBJECT_PROPERTIES, ROOT_PATH) {
            "Total number of object properties ($totalObjectProperties) exceeds " +
                "limit of $MAX_OBJECT_PROPERTIES."
        }

        return this
    }

    /**
     * Validates a schema. This may be the root schema or a sub-schema. Some validations are
     * specific to the root schema, which is identified by the [depth] being equal to zero.
     *
     * This method is recursive: it will validate the given schema and any sub-schemas that it
     * contains at any depth. References to other schemas (either the root schema or definition
     * sub-schemas) do not increase the depth of nesting, as those references are not followed
     * recursively, only checked to be valid internal schema references.
     *
     * @param schema The schema to be validated. This may be the root schema or any sub-schema.
     * @param path The path that identifies the location of this schema within the JSON schema. For
     *   example, for the root schema, this will be `"#"`; for a definition sub-schema of a `Person`
     *   object, this will be `"#/$defs/Person"`.
     * @param depth The current depth of nesting. The OpenAI API specification places a maximum
     *   limit on the depth of nesting, which will result in an error if it is exceeded. The nesting
     *   depth increases with each recursion into a nested sub-schema. For the root schema, the
     *   nesting depth is zero; all other sub-schemas will have a nesting depth greater than zero.
     */
    private fun validateSchema(schema: JsonNode, path: String, depth: Int) {
        verify(depth <= MAX_NESTING_DEPTH, path) {
            "Current nesting depth is $depth, but maximum is $MAX_NESTING_DEPTH."
        }

        verify(schema.isObject, path, { "Schema or sub-schema is not an object." }) {
            // If the schema is not an object, perform no further validations.
            return
        }

        verify(!schema.isEmpty, path) { "Schema or sub-schema is empty." }

        if (depth == ROOT_DEPTH) {
            // Sanity check for the presence of the "$schema" field, as this makes it more likely
            // that the schema with `depth == 0` is actually the root node of a JSON schema, not
            // just a generic JSON document that is being validated in error.
            verify(schema.get(SCHEMA) != null, path) { "Root schema missing '$SCHEMA' field." }
        }

        // Before sub-schemas can be validated, the list of definitions must be recorded to ensure
        // that "$ref" references can be checked for validity. Definitions are optional and only
        // appear in the root schema.
        validateDefinitions(schema.get(DEFS), "$path/$DEFS", depth)

        val anyOf = schema.get(ANY_OF)
        val type = schema.get(TYPE)
        val ref = schema.get(REF)

        verify(
            (anyOf != null).xor(type != null).xor(ref != null),
            path,
            { "Expected exactly one of '$TYPE' or '$ANY_OF' or '$REF'." },
        ) {
            // Validation cannot continue if none are set, or if more than one is set.
            return
        }

        validateAnyOfSchema(schema, path, depth)
        validateTypeSchema(schema, path, depth)
        validateRefSchema(schema, path, depth)
    }

    /**
     * Validates a schema if it has an `"anyOf"` field. OpenAI does not support the use of `"anyOf"`
     * at the root of a JSON schema. The value is the field is expected to be an array of valid
     * sub-schemas. If the schema has no `"anyOf"` field, no action is taken.
     */
    private fun validateAnyOfSchema(schema: JsonNode, path: String, depth: Int) {
        val anyOf = schema.get(ANY_OF)

        if (anyOf == null) return

        validateKeywords(schema, ALLOWED_KEYWORDS_ANY_OF_SUB_SCHEMA, path, depth)

        verify(
            anyOf.isArray && !anyOf.isEmpty,
            path,
            { "'$ANY_OF' field is not a non-empty array." },
        ) {
            return
        }

        // Validates that the root schema does not contain an `anyOf` field. This is a restriction
        // imposed by the OpenAI API specification. `anyOf` fields _can_ appear at other depths.
        verify(depth != ROOT_DEPTH, path) { "Root schema contains '$ANY_OF' field." }

        // Each entry must be a valid sub-schema.
        anyOf.forEachIndexed { index, subSchema ->
            validateSchema(subSchema, "$path/$ANY_OF[$index]", depth + 1)
        }
    }

    /**
     * Validates a schema if it has a `"$ref"` field. The reference is checked to ensure it
     * corresponds to a valid definition, or is a reference to the root schema. Recursive references
     * are allowed. If no `"$ref"` field is found in the schema, no action is taken.
     */
    private fun validateRefSchema(schema: JsonNode, path: String, depth: Int) {
        val ref = schema.get(REF)

        if (ref == null) return

        validateKeywords(schema, ALLOWED_KEYWORDS_REF_SUB_SCHEMA, path, depth)

        val refPath = "$path/$REF"

        verify(ref.isTextual, refPath, { "'$REF' field is not a text value." }) {
            // No point checking the reference has a referent if it is definitely malformed.
            return
        }
        verify(ref.asText() in validReferences, refPath) {
            "Invalid or unsupported reference: '${ref.asText()}'."
        }
    }

    /**
     * Validates a schema if it has a `"type"` field. This includes most sub-schemas, except those
     * that have a `"$ref"` or `"anyOf"` field instead. The `"type"` field may be set to a text
     * value that is the name of the type (e.g., `"object"`, `"array"`, `"number"`), or it may be
     * set to an array that contains two text values: the name of the type and `"null"`. The OpenAI
     * API specification explains that this is how a property can be both required (i.e., it must
     * appear in the JSON document), but its value can be optional (i.e., it can be set explicitly
     * to `"null"`). If the schema has no `"type"` field, no action is taken.
     */
    private fun validateTypeSchema(schema: JsonNode, path: String, depth: Int) {
        val type = schema.get(TYPE)

        if (type == null) return

        val typeName =
            if (type.isTextual) {
                // Type will be something like `"type" : "string"`
                type.asText()
            } else if (type.isArray) {
                // Type will be something like `"type" : [ "string", "null" ]`. This corresponds to
                // the use of "Optional<String>" in Java/Kotlin.
                getTypeNameFromTypeArray(type, "$path/$TYPE")
            } else {
                error(path) { "'$TYPE' field is not a type name or array of type names." }
                return
            }

        when (typeName) {
            TYPE_ARRAY -> validateArraySchema(schema, path, depth)
            TYPE_OBJECT -> validateObjectSchema(schema, path, depth)

            TYPE_BOOLEAN,
            TYPE_INTEGER,
            TYPE_NUMBER,
            TYPE_STRING -> validateSimpleSchema(schema, typeName, path, depth)

            // The type name could not be determined from a type name array. An error will already
            // have been logged by `getTypeNameFromTypeArray`, so no need to do anything more here.
            null -> return

            else -> error("$path/$TYPE") { "Unsupported '$TYPE' value: '$typeName'." }
        }
    }

    /**
     * Validates a schema whose `"type"` is `"object"`. It is the responsibility of the caller to
     * ensure that [schema] contains that type definition. If no type, or a different type is
     * present, the behavior is not defined.
     */
    private fun validateObjectSchema(schema: JsonNode, path: String, depth: Int) {
        validateKeywords(schema, ALLOWED_KEYWORDS_OBJECT_SUB_SCHEMA, path, depth)

        // The schema must declare that additional properties are not allowed. For this check, it
        // does not matter if there are no "properties" in the schema.
        verify(
            schema.get(ADDITIONAL_PROPS) != null && !schema.get(ADDITIONAL_PROPS).asBoolean(),
            path,
        ) {
            "'$ADDITIONAL_PROPS' field is missing or is not set to 'false'."
        }

        val properties = schema.get(PROPS)

        // An object schema _must_ have a `"properties"` field, and it must contain at least one
        // property. The AI model will report an error relating to a missing or empty `"required"`
        // array if the "properties" field is missing or empty (and therefore the `"required"` array
        // will also be missing or empty). This condition can arise if a `Map` is used as the field
        // type: it will cause the generation of an object schema with no defined properties. If not
        // present or empty, validation cannot continue.
        verify(
            properties != null && properties.isObject && !properties.isEmpty,
            path,
            {
                "'$PROPS' field is missing, empty or not an object. " +
                    "At least one named property must be defined. See: $NO_PROPERTIES_DOC"
            },
        ) {
            return
        }

        // Similarly, insist that the `"required"` array is present or stop validation.
        val required = schema.get(REQUIRED)

        verify(
            required != null && required.isArray && !required.isEmpty,
            path,
            { "'$REQUIRED' field is missing, empty or not an array." },
        ) {
            return
        }

        validatePropertiesRequired(
            properties.fieldNames().asSequence().toSet(),
            required,
            "$path/$REQUIRED",
        )
        validateProperties(properties, "$path/$PROPS", depth)
    }

    /**
     * Validates a schema whose `"type"` is `"array"`. It is the responsibility of the caller to
     * ensure that [schema] contains that type definition. If no type, or a different type is
     * present, the behavior is not defined.
     *
     * An array schema must have an `"items"` field whose value is an object representing a valid
     * sub-schema.
     */
    private fun validateArraySchema(schema: JsonNode, path: String, depth: Int) {
        validateKeywords(schema, ALLOWED_KEYWORDS_ARRAY_SUB_SCHEMA, path, depth)

        val items = schema.get(ITEMS)

        verify(
            items != null && items.isObject,
            path,
            { "'$ITEMS' field is missing or is not an object." },
        ) {
            return
        }

        validateSchema(items, "$path/$ITEMS", depth + 1)
    }

    /**
     * Validates a schema whose `"type"` is one of the supported simple type names other than
     * `"object"` and `"array"`. It is the responsibility of the caller to ensure that [schema]
     * contains the correct type definition. If no type, or a different type is present, the
     * behavior is not defined.
     *
     * @param typeName The name of the specific type of the schema. Where the field value is
     *   optional and the type is defined as an array of a type name and a `"null"`, this is the
     *   value of the non-`"null"` type name. For example `"string"`, or `"number"`.
     */
    private fun validateSimpleSchema(schema: JsonNode, typeName: String, path: String, depth: Int) {
        val allowedKeywords =
            when (typeName) {
                TYPE_NUMBER,
                TYPE_INTEGER -> ALLOWED_KEYWORDS_NUMBER_SUB_SCHEMA
                TYPE_STRING -> ALLOWED_KEYWORDS_STRING_SUB_SCHEMA
                else -> ALLOWED_KEYWORDS_SIMPLE_SUB_SCHEMA
            }

        validateKeywords(schema, allowedKeywords, path, depth)

        val enumField = schema.get(ENUM)

        // OpenAI API specification: "For a single enum property with string values, the total
        // string length of all enum values cannot exceed 7,500 characters when there are more than
        // 250 enum values."
        val isString = typeName == TYPE_STRING
        var numEnumValues = 0
        var stringLength = 0

        enumField?.forEach { value ->
            // OpenAI places limits on the total string length of all enum values across all enums
            // without being specific about the type of those enums (unlike for enums with string
            // values, which have their own restrictions noted above). The specification does not
            // indicate how to count the string length for boolean or number values. Here it is
            // assumed that their simple string representations should be counted.
            val length = value.asText().length

            totalStringLength += length
            totalEnumValues++

            if (isString) {
                numEnumValues++
                stringLength += length
            }
        }

        verify(
            !isString ||
                numEnumValues <= UNRESTRICTED_ENUM_VALUES_LIMIT ||
                stringLength <= MAX_ENUM_TOTAL_STRING_LENGTH,
            "$path/$ENUM",
        ) {
            "Total string length ($stringLength) of values of an enum with $numEnumValues " +
                "values exceeds limit of $MAX_ENUM_TOTAL_STRING_LENGTH."
        }

        schema.get(CONST)?.let { constValue -> totalStringLength += constValue.asText().length }
    }

    /**
     * Validates that the definitions (if present) contain fields that each define a valid schema.
     * Records the names of any definitions to construct the set of possible valid references to
     * those definitions. This set will be used to validate any references from within definition
     * sub-schemas, or any other sub-schemas validated at a later time.
     *
     * @param defs The node containing the definitions. Definitions are optional, so this node may
     *   be `null`. Definitions may appear in the root schema, but will not appear in any
     *   sub-schemas. If no definitions are present, the list of valid references will not be
     *   changed and no errors will be recorded.
     * @param path The path that identifies the location within the schema of the `"$defs"` node.
     * @param depth The current depth of nesting. If definitions are present, this will be zero, as
     *   that is the depth of the root schema.
     */
    private fun validateDefinitions(defs: JsonNode?, path: String, depth: Int) {
        // Definitions are optional. If present, expect an object whose fields are named from the
        // classes the definitions were extracted from. If not present, do not continue.
        verify(defs == null || defs.isObject, path, { "'$DEFS' must be an object." }) {
            return
        }

        // First, record the valid references to definitions, as any definition sub-schema may
        // contain a reference to any other definitions sub-schema (including itself) and those
        // references need to be validated.
        defs?.fieldNames()?.asSequence()?.forEach { defName ->
            val reference = "$path/$defName"

            // Consider that there might be duplicate definition names if two different classes
            // (from different packages) have the same simple name. That would be an error, but
            // there is no need to stop the validations.
            // TODO: How should duplicate names be handled? Will the generator use longer names?
            verify(reference !in validReferences, path) { "Duplicate definition of '$defName'." }
            validReferences += reference
        }

        // Second, recursively validate the definition sub-schemas.
        defs?.fieldNames()?.asSequence()?.forEach { defName ->
            totalStringLength += defName.length
            validateSchema(defs.get(defName), "$path/$DEFS/$defName", depth + 1)
        }
    }

    /**
     * Validates that every property in a collection of property names appears in the array of
     * property names in a `"required"` field.
     *
     * @param propertyNames The collection of property names to check in the array of required
     *   properties. This collection will not be empty.
     * @param required The `"required"` field. This is expected to be a non-`null` array field with
     *   a set of property names.
     * @param path The path identifying the location of the `"required"` field within the schema.
     */
    private fun validatePropertiesRequired(
        propertyNames: Collection<String>,
        required: JsonNode,
        path: String,
    ) {
        val requiredNames = required.map { it.asText() }.toSet()

        propertyNames.forEach { propertyName ->
            verify(propertyName in requiredNames, path) {
                "'$PROPS' field '$propertyName' is not listed as '$REQUIRED'."
            }
        }
    }

    /**
     * Validates that each named entry in the `"properties"` field of an object schema has a value
     * that is a valid sub-schema.
     *
     * @param properties The `"properties"` field node of an object schema.
     * @param path The path identifying the location of the `"properties"` field within the schema.
     */
    private fun validateProperties(properties: JsonNode, path: String, depth: Int) {
        val propertyNames = properties.fieldNames().asSequence().toList()

        propertyNames.forEach { propertyName ->
            totalObjectProperties++
            totalStringLength += propertyName.length
            validateSchema(properties.get(propertyName), "$path/$propertyName", depth + 1)
        }
    }

    /**
     * Validates that the names of all fields in the given schema node are present in a collection
     * of allowed keywords. The values associated with the keywords are _not_ validated.
     *
     * @param depth The nesting depth of the [schema] node. If this depth is zero, an additional set
     *   of allowed keywords will be included automatically for keywords that are allowed to appear
     *   only at the root level of the schema (e.g., `"$schema"`, `"$defs"`).
     */
    private fun validateKeywords(
        schema: JsonNode,
        allowedKeywords: Collection<String>,
        path: String,
        depth: Int,
    ) {
        schema.fieldNames().forEach { keyword ->
            verify(
                keyword in allowedKeywords ||
                    (depth == ROOT_DEPTH && keyword in ALLOWED_KEYWORDS_ROOT_SCHEMA_ONLY),
                path,
            ) {
                "Use of '$keyword' is not supported here."
            }
        }
    }

    /**
     * Gets the name of a type from the given `"type"` field, where the field is an array that
     * contains exactly two string values: a type name and a `"null"` (in any order).
     *
     * @param type The type node. This must be a field with an array value. If this is not an array
     *   field, the behavior is undefined. It is the responsibility of the caller to ensure that
     *   this function is only called for array fields.
     * @return The type name in the array that is not the `"null"` type; or `null` if no such type
     *   name was found, or if the array does not contain exactly two expected values: the type name
     *   and a `"null"` type. If `null`, one or more validation errors will be recorded.
     */
    private fun getTypeNameFromTypeArray(type: JsonNode, path: String): String? {
        val types = type.asSequence().toList()

        if (types.size == 2 && types.all { it.isTextual }) {
            // Allow one type name and one "null". Be lenient about the order. Assume that there are
            // no oddities like type names that are empty strings, etc., as the schemas are expected
            // to be generated.
            if (types[1].asText() == TYPE_NULL && types[0].asText() != TYPE_NULL) {
                return types[0].asText()
            } else if (types[0].asText() == TYPE_NULL && types[1].asText() != TYPE_NULL) {
                return types[1].asText()
            } else {
                error(path) { "Expected one type name and one \"$TYPE_NULL\"." }
            }
        } else {
            error(path) { "Expected exactly two types, both strings." }
        }

        return null
    }

    private inline fun verify(value: Boolean, path: String, lazyMessage: () -> Any) {
        verify(value, path, lazyMessage) {}
    }

    private inline fun verify(
        value: Boolean,
        path: String,
        lazyMessage: () -> Any,
        onFalse: () -> Unit,
    ) {
        if (!value) {
            error(path, lazyMessage)
            onFalse()
        }
    }

    private inline fun error(path: String, lazyMessage: () -> Any) {
        errors.add("$path: ${lazyMessage()}")
    }

    override fun toString(): String =
        "${javaClass.simpleName}{isValidationComplete=$isValidationComplete, " +
            "totalStringLength=$totalStringLength, " +
            "totalObjectProperties=$totalObjectProperties, " +
            "totalEnumValues=$totalEnumValues, errors=$errors}"
}
