package ui.view

import tornadofx.View
import tornadofx.label

class MainView : View(title = "Darts") {
	override val root = label("Hello World")
}