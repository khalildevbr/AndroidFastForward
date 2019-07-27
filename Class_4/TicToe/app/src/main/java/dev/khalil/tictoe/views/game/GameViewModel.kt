package dev.khalil.tictoe.views.game

import androidx.databinding.ObservableArrayMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dev.khalil.tictoe.models.Cell
import dev.khalil.tictoe.models.Game
import dev.khalil.tictoe.models.Player
import dev.khalil.tictoe.utils.StringUtility.stringFromNumbers

class GameViewModel : ViewModel() {

    lateinit var cells: ObservableArrayMap<String, String>

    private lateinit var game: Game
    val winner: LiveData<Player>
        get() = game.winner

    fun init(player1: String, player2: String) {
        game = Game(player1, player2)
        cells = ObservableArrayMap()
    }

    fun onClickedCellAt(row: Int, column: Int) {
        if (game.cells[row][column] == null) {
            game.cells[row][column] = Cell(game.currentPlayer)
            cells[stringFromNumbers(row, column)] = game.currentPlayer.value
            if (game.hasGameEnded())
                game.reset()
            else
                game.switchPlayer()
        }
    }
}