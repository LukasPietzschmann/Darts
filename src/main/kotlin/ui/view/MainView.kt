package ui.view

import tornadofx.View
import tornadofx.borderpane

class MainView : View(title = "Darts") {
	override val root = borderpane {
		left<PlayerListView>()
		center<StartView>()
	}
}