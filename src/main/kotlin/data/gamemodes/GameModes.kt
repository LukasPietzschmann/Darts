package data.gamemodes

import kotlin.reflect.full.primaryConstructor

sealed class GameMode {
	abstract val maxScore: Int

	companion object {
		fun getAll(): List<GameMode> {
			val classes = ArrayList<GameMode>()

			GameMode::class.sealedSubclasses.forEach { kclass ->
				kclass.primaryConstructor?.let { classes.add(it.call()) }
			}

			return classes
		}
	}
}

class ThreeHundredOne : GameMode() {
	override val maxScore = 301

	override fun toString(): String {
		return "301"
	}
}

class FiveHundredOne : GameMode() {
	override val maxScore = 501

	override fun toString(): String {
		return "501"
	}
}