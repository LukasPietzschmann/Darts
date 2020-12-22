package ui.app

import javafx.stage.Stage
import tornadofx.App
import tornadofx.addStageIcon
import ui.view.MainView

class MainApp : App(MainView::class, Styles::class) {
	override fun start(stage: Stage) {
		addStageIcon(resources.image("/logo.png"))
		with(stage) {
			width = 1200.0
			height = 600.0
		}

		super.start(stage)
	}
}