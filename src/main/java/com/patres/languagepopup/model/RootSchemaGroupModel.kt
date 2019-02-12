package com.patres.languagepopup.model

import com.patres.languagepopup.gui.controller.model.AutomationController
import com.patres.languagepopup.gui.controller.model.RootSchemaGroupController
import com.patres.languagepopup.util.LoaderFactory

class RootSchemaGroupModel(val controller: RootSchemaGroupController) {

    val schemaGroup = LoaderFactory.createSchemaGroupModel(this, null)

    var selectedModel: AutomationModel<out AutomationController>? = null
        set(value) {
            field = value
            controller.actionBarController.updateDisabledButtons()
        }

    var actionBlocks = ArrayList<AutomationModel<out AutomationController>>()
        get() = schemaGroup.actionBlocks

    var allChildrenActionBlocks = emptyList<AutomationModel<out AutomationController>>()
        get() = schemaGroup.allChildrenActionBlocks

    var allSchemaActionBlocks = emptyList<SchemaGroupModel>()
        get() = allChildrenActionBlocks.filterIsInstance<SchemaGroupModel>()

    var schemaGroups = emptyList<SchemaGroupModel>()
        get() = actionBlocks.filterIsInstance<SchemaGroupModel>()


    fun initAfterSetController() {
        controller.actionBarController.initAfterSetModel()
    }

    fun addNewSchemaGroup(name: String = "Group") {
        schemaGroup.addNewSchemaGroup(name)
    }

    fun addActionBlocks(actionBlock: AutomationModel<AutomationController>) {
        schemaGroup.addActionBlocks(actionBlock)
    }

    fun unselectAllButton() {
        allSchemaActionBlocks.forEach { it.unselectSecectActionButton() }
    }

    fun removeSelectedModel() {
        selectedModel?.let {
            it.parent?.removeNode(it)
        }
        selectedModel = null
    }


}