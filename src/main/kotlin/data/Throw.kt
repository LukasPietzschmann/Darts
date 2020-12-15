package data

data class Throw(
	var first: UInt = 0u,
	var second: UInt = 0u,
	var third: UInt = 0u
) {
	fun toList(): List<UInt> {
		return listOf(first, second, third)
	}
}