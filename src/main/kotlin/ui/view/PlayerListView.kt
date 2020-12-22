package ui.view

import javafx.geometry.Pos
import javafx.scene.control.SelectionMode
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import javafx.scene.layout.Priority
import javafx.scene.text.FontWeight
import tornadofx.*
import ui.controller.Store

class PlayerListView : View() {
	private val store: Store = find(Store::class)

	override val root = vbox {
		vboxConstraints {
			alignment = Pos.CENTER
		}

		label("Players")

		listview(store.players) {
			cellFormat {
				graphic = vbox {
					label(it.name) {
						style {
							fontWeight = FontWeight.BOLD
						}
					}
					label("${it.score} Points")

					contextmenu {
						item("Delete Player").action {
							selectedItem?.let { store.removePlayer(it) }
						}
					}
				}
			}

			addEventFilter(KeyEvent.KEY_PRESSED) { event ->
				if (event.code == KeyCode.DELETE || event.code == KeyCode.BACK_SPACE) selectedItem?.let { store.removePlayer(it) }
			}

			isEditable = false
			selectionModel.selectionMode = SelectionMode.SINGLE
			vgrow = Priority.ALWAYS
		}

		textfield {
			promptText = "New Player..."

			addEventFilter(KeyEvent.KEY_PRESSED) {
				if (it.code == KeyCode.ENTER && text != "") {
					store.addPlayer(text.trim())
					text = ""
				}
			}
		}
	}
}