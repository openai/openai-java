package com.openai.models.chat.completions

import com.openai.core.JsonSchemaLocalValidation
import com.openai.core.functionToolFromClass as coreFunctionToolFromClass

@JvmSynthetic
internal fun functionToolFromClass(
    parametersType: Class<*>,
    localValidation: JsonSchemaLocalValidation = JsonSchemaLocalValidation.YES,
): ChatCompletionTool = coreFunctionToolFromClass(parametersType, localValidation)
