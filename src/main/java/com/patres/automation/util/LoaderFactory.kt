package com.patres.automation.util

import com.patres.automation.Main
import com.patres.automation.action.mouse.MouseAction
import com.patres.automation.gui.controller.model.*
import com.patres.automation.model.RootSchemaGroupModel
import com.patres.automation.model.SchemaGroupModel
import com.patres.automation.model.ActionNodeModel
import javafx.fxml.FXMLLoader
import javafx.scene.control.Tab
import javafx.scene.control.TabPane

object LoaderFactory {

    fun createLabelActionController(model: MouseAction<LabelActionController>): LabelActionController {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("/fxml/LabelAction.fxml")
        loader.resources = Main.bundle
        loader.load<LabelActionController>()
        return loader.getController<LabelActionController>().also {
            it.model = model
        }
    }

    fun createTextFieldActionController(model: ActionNodeModel<TextFieldActionController>): TextFieldActionController {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("/fxml/TextFieldAction.fxml")
        loader.resources = Main.bundle
        loader.load<TextFieldActionController>()
        return loader.getController<TextFieldActionController>().also {
            it.model = model
        }
    }

    fun createMousePointActionController(model: ActionNodeModel<MousePointActionController>): MousePointActionController {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("/fxml/MousePointAction.fxml")
        loader.resources = Main.bundle
        loader.load<MousePointActionController>()
        return loader.getController<MousePointActionController>().also {
            it.model = model
        }
    }

    fun createSchemaGroupController(model: SchemaGroupModel): SchemaGroupController {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("/fxml/SchemaGroup.fxml")
        loader.resources = Main.bundle
        loader.load<SchemaGroupController>()
        return loader.getController<SchemaGroupController>().also {
            it.model = model
        }
    }

    fun createRootSchemaGroupController(model: RootSchemaGroupModel): RootSchemaGroupController {
        val loader = FXMLLoader()
        loader.location = javaClass.getResource("/fxml/RootSchemaGroup.fxml")
        loader.resources = Main.bundle
        loader.load<RootSchemaGroupController>()
        return loader.getController<RootSchemaGroupController>().also {
            it.model = model
        }
    }

    fun createRootSchemaGroup(tabPane: TabPane?): RootSchemaGroupModel {
        val rootSchemaGroup = RootSchemaGroupModel().apply {
            controller.insidePane.content = schemaGroup.controller.getMainNode()
        }

        val newTab = Tab("New Tab", rootSchemaGroup.controller.rootStackPane)
        tabPane?.apply {
            tabs?.add(newTab)
            selectionModel?.select(newTab)
        }

        return rootSchemaGroup
    }
}