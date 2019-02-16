package com.patres.languagepopup.gui.controller.model

import com.jfoenix.controls.JFXTextField
import com.patres.languagepopup.model.AutomationModel
import com.patres.languagepopup.model.SchemaGroupModel
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox


class SchemaGroupController : AutomationController() {

    @FXML
    lateinit var mainSchemaBox: BorderPane

    @FXML
    lateinit var outsideBox: StackPane

    @FXML
    lateinit var innerBox: VBox

    @FXML
    lateinit var groupNameTextField: JFXTextField

    @FXML
    lateinit var iterationsTextField: JFXTextField

    lateinit var model: SchemaGroupModel

    override fun getModel(): AutomationModel<out AutomationController> = model

    fun initialize() {
    }

    fun getMainOutsideNode(): Node = mainSchemaBox

    fun getMainInsideNode(): Pane = innerBox

}