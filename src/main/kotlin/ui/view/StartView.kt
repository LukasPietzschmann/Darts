package ui.view

import NoCurrentMatchupException
import NoSelectedGameModeException
import data.gamemodes.GameMode
import javafx.beans.property.SimpleStringProperty
import javafx.util.Duration
import tornadofx.*
import ui.controller.Logic
import ui.controller.Store
import ui.controller.listener.GameStartListener

class StartView : View(), GameStartListener {
	private val store = find(Store::class)
	private val logic = find(Logic::class)

	init {
		logic.registerGameStartListener(this)
	}

	override val root = form {
		val gameName = SimpleStringProperty()
		fieldset("Game Settings") {
			field("Game Name") {
				textfield(gameName) {
					promptText = store.gameName
				}
			}

			field("Game Mode") {
				combobox(values = GameMode.getAll()) {
					setOnAction {
						store.gameMode = selectedItem
					}
				}
			}
		}

		button("Start Game") {
			setOnAction {
				gameName.value?.let { store.gameName = gameName.value }

				open class ErrorPopup(errorText: String) : View() {
					override val root = hbox {
						paddingAll = 15
						label(errorText)
					}
				}
				try {
					logic.startGame()
					logic.unregisterGameStartListener(this@StartView)
				} catch (e: NoCurrentMatchupException) {
					class NoCurrentMatchupErrorPopup :
						ErrorPopup("There is no current Matchup. You might not have setup at least two players!")
					openInternalWindow<NoCurrentMatchupErrorPopup>(movable = false, owner = find(MainView::class).root)
				} catch (e: NoSelectedGameModeException) {
					class NoSelectedGameModeErrorPopup : ErrorPopup("Please select a Game Mode first!")
					openInternalWindow<NoSelectedGameModeErrorPopup>(movable = false, owner = find(MainView::class).root)
				}
			}
		}
	}

	override fun onGameStart() {
		store.currMatchup?.let {
			find(MainView::class).title = "Darts - ${store.gameName}"
			replaceWith(GameView(it), ViewTransition.Fade(Duration(100.0)))
		}
	}
}