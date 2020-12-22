package ui.controller

import NoCurrentMatchupException
import NoSelectedGameModeException
import tornadofx.Controller
import ui.controller.listener.GameStartListener

class Logic : Controller() {
	private val store = find(Store::class)
	private val gameStartListeners = ArrayList<GameStartListener>()

	//TODO implement as extension Funtion and extension Property
	fun registerGameStartListener(listener: GameStartListener) = gameStartListeners.add(listener)
	fun unregisterGameStartListener(listener: GameStartListener) = gameStartListeners.remove(listener)

	private inline fun <T> forAll(listener: List<T>, func: (elem: T) -> Unit) = listener.forEach(func)

	fun startGame() {
		if (store.currMatchup == null) throw NoCurrentMatchupException
		if (store.gameMode == null) throw NoSelectedGameModeException

		forAll(gameStartListeners) { it.onGameStart() }
	}
}
