package com.patres.automation.mapper.model

import com.patres.automation.settings.LocalSettings

data class RootSchemaGroupSerialized(
        val schemaGroupSerialized: SchemaGroupSerialized,
        val localSettings: LocalSettings,
        val orgFile: String?
)