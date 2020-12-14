package data

data class Matchup(
	val player1: Player,
	val player2: Player,
	val winner: Player? = null,
	val throws: Map<Player, List<Throw>> = HashMap()
)