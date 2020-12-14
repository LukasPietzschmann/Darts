package data

data class Throw(
	val first: UInt = 0u,
	val second: UInt = 0u, val third: UInt = 0u
) {
	fun toList(): List<UInt> {
		return listOf(first, second, third)
	}
}