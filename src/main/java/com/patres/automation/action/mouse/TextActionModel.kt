package com.patres.automation.action.mouse

import com.patres.automation.gui.controller.model.TextFieldActionController
import com.patres.automation.model.ActionNodeModel
import com.patres.automation.model.RootSchemaGroupModel
import com.patres.automation.model.SchemaGroupModel
import javafx.scene.Node

abstract class TextActionModel(
        root: RootSchemaGroupModel,
        parent: SchemaGroupModel
) : ActionNodeModel<TextFieldActionController>(root, parent) {

    fun getActionValue() = controller.value

    fun setActionValue(actionValue: String) {
        controller.value = actionValue
    }

    override fun getMainNode(): Node = controller.getMainNode()

    override fun getMainInsideNode(): Node = controller.getMainInsideNode()

}