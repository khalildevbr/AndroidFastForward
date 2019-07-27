package dev.khalil.tictoe

import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import dev.khalil.tictoe.models.Player
import dev.khalil.tictoe.views.game.GameActivity
import org.junit.Rule
import org.junit.Test

class GameActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<GameActivity> = ActivityTestRule(GameActivity::class.java)
    private val player1 = Player("Heider", "x")
    private val player2 = Player("William", "o")

    @Test
    fun end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name)
        writeTo(R.id.et_player2, player2.name)
        clickDialogPositiveButton()
        clickOn(R.id.cell_00)
        clickOn(R.id.cell_10)
        clickOn(R.id.cell_01)
        clickOn(R.id.cell_11)
        clickOn(R.id.cell_02)
        assertDisplayed(R.id.tvWinner)
        assertDisplayed(player1.name)
    }

    @Test
    @Throws(Exception::class)
    fun display_same_names_message_if_names_same() {
        writeTo(R.id.et_player1, "Heider")
        writeTo(R.id.et_player2, "Heider")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_same_names)
    }

    @Test
    @Throws(Exception::class)
    fun display_empty_name_message_if_one_name_empty() {
        writeTo(R.id.et_player1, "")
        writeTo(R.id.et_player2, "William")
        clickDialogPositiveButton()
        assertDisplayed(R.string.game_dialog_empty_name)
    }

    @Test
    @Throws(Exception::class)
    fun close_dialog_after_names_valid() {
        writeTo(R.id.et_player1, "Heider 1")
        writeTo(R.id.et_player2, "William")
        clickDialogPositiveButton()
        assertNotExist(R.id.player1Layout)
    }
}