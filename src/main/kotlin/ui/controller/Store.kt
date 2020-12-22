package ui.controller

import data.Matchup
import data.Player
import data.gamemodes.GameMode
import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller
import tornadofx.SortedFilteredList
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Store : Controller() {
	var gameName = "Game-${LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmm"))}"
	var gameMode: GameMode? = null
	val players = SortedFilteredList<Player>()
	var currMatchup: Matchup? = Matchup(Player("Lukas", 10), Player("Debby", 270)) //FIXME only for testing Purposes

	fun removePlayer(player: Player) = players.remove(player)

	fun addPlayer(name: String) {
		players.add(Player(name))
	}
}