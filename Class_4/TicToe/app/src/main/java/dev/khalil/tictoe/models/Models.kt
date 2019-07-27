package dev.khalil.tictoe.models

data class Player(var name: String, var value: String)

data class Cell(var player: Player) {
    val isEmpty: Boolean
        get() = player.value.isEmpty()
}