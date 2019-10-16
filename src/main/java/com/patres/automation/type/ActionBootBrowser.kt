package com.patres.automation.type

import com.patres.automation.ActionBootControllerType
import com.patres.automation.FileType
import com.patres.automation.action.AbstractAction
import com.patres.automation.action.script.OpenFileOrDirectoryAction
import com.patres.automation.action.script.WindowsRunAndWaitScriptAction
import com.patres.automation.action.script.WindowsRunScriptAction
import com.patres.automation.action.text.PasteTextFromFileAction
import com.patres.automation.action.text.TypeTextFromFileAction
import com.patres.automation.gui.controller.model.BrowseFileActionController
import com.patres.automation.model.RootSchemaGroupModel
import com.patres.automation.validation.FileExistValidation
import com.patres.automation.validation.FileExtensionValidation
import com.patres.automation.validation.FileOrDirectoryExistValidation
import com.patres.automation.validation.Validationable


enum class ActionBootBrowser(
        val bundleName: String,
        val validation: Validationable? = null,
        val controllerType: ActionBootControllerType,
        val createModel: (String) -> AbstractAction,
        val fileType: FileType? = null
) : ActionBootable {

    PASTE_TEXT_FROM_FILE("robot.action.keyboard.paste.file", FileExistValidation(), ActionBootControllerType.BROWSE_FILE, { value: String -> PasteTextFromFileAction(value) }),
    TYPE_TEXT_FROM_FILE("robot.action.keyboard.type.file", FileExistValidation(), ActionBootControllerType.BROWSE_FILE, { value: String -> TypeTextFromFileAction(value) }),

    OPEN_FILE_OR_DIRECTORY("robot.action.open.fileOrDirectory", FileOrDirectoryExistValidation(), ActionBootControllerType.BROWSE_FILE, { value: String -> OpenFileOrDirectoryAction(value) }),

    WINDOWS_SCRIPT_RUN("robot.action.script.windows.run", FileExtensionValidation(FileType.BAT), ActionBootControllerType.BROWSE_FILE_BAT, { value: String -> WindowsRunScriptAction(value) }),
    WINDOWS_SCRIPT_RUN_AND_WAITE("robot.action.script.windows.runAndWait", FileExtensionValidation(FileType.BAT), ActionBootControllerType.BROWSE_FILE_BAT, { value: String -> WindowsRunAndWaitScriptAction(value) });

    override fun validation(): Validationable? {
        return this.validation
    }

    override fun bundleName(): String {
        return this.bundleName
    }

    override fun controllerType(): ActionBootControllerType {
        return this.controllerType
    }


    fun createModel(): (String) -> AbstractAction {
        return this.createModel
    }

    override fun createController() = { root: RootSchemaGroupModel -> BrowseFileActionController(root, root.getSelectedSchemaGroupModel()!!, this) }

}