package com.patres.languagepopup.gui.controller.model

import com.patres.languagepopup.gui.controller.ActionBarController
import com.patres.languagepopup.model.RootSchemaGroupModel
import com.patres.languagepopup.model.SchemaGroupModel
import javafx.fxml.FXML
import javafx.scene.control.ScrollPane
import javafx.scene.layout.StackPane
import javafx.scene.layout.VBox


open class RootSchemaGroupController {

    @FXML
    lateinit var rootStackPane: StackPane

    @FXML
    lateinit var insidePane: ScrollPane

    @FXML
    lateinit var actionBox: VBox

    lateinit var actionBarController: ActionBarController

    lateinit var model: RootSchemaGroupModel

    fun initialize() {
        actionBarController = ActionBarController(this)
    }

}