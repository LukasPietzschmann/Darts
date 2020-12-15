package data

data class Matchup(
	val player1: Player,
	val player2: Player,
	var winner: Player? = null,
	val throws: MutableMap<Player, List<Throw>> = mutableMapOf()
)