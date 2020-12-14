package ui.app

import javafx.stage.Stage
import tornadofx.App
import ui.view.MainView

class MainApp : App(MainView::class, Styles::class) {
	override fun start(stage: Stage) {
		with(stage) {
			width = 1200.0
			height = 600.0
		}

		super.start(stage)
	}
}