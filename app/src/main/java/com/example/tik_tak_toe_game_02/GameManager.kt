package com.example.tik_tak_toe_game_02

class GameManager {

    private var currentPlayer = 1
    var player1Points = 0
    var player2Points = 0

    val currentPlayerMark: String
        get() {
            return if (currentPlayer == 1) "X" else "O"
        }

    private var state = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    fun makeMove(position: Position): WinningLine? {
        state[position.row][position.column] = currentPlayer
        val winningLine = hasGameEnded()

        if (winningLine == null) {
            currentPlayer = 3 - currentPlayer
        } else {
            when (currentPlayer) {
                1 -> player1Points++
                2 -> player2Points++
            }
        }

        return winningLine
    }

    fun reset() {
        state = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        currentPlayer = 1
    }

    private fun hasGameEnded(): WinningLine? {
        if (state[0][0] == currentPlayer && state[0][1] == currentPlayer && state[0][2] == currentPlayer) {
            return WinningLine.ROW_0
        } else if (state[1][0] == currentPlayer && state[1][1] == currentPlayer && state[1][2] == currentPlayer) {
            return WinningLine.ROW_1
        } else if (state[2][0] == currentPlayer && state[2][1] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.ROW_2
        } else if (state[0][0] == currentPlayer && state[1][0] == currentPlayer && state[2][0] == currentPlayer) {
            return WinningLine.COLUMN_0
        } else if (state[0][1] == currentPlayer && state[1][1] == currentPlayer && state[2][1] == currentPlayer) {
            return WinningLine.COLUMN_1
        } else if (state[0][2] == currentPlayer && state[1][2] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.COLUMN_2
        } else if (state[0][0] == currentPlayer && state[1][1] == currentPlayer && state[2][2] == currentPlayer) {
            return WinningLine.DIAGONAL_LEFT
        } else if (state[0][2] == currentPlayer && state[1][1] == currentPlayer && state[2][0] == currentPlayer) {
            return WinningLine.DIAGONAL_RIGHT
        }
        return null
    }

    private fun hasGameEndedV2(): Boolean {
        state.forEach { row ->
            val hasWon = row.all { player -> player == currentPlayer }
            if (hasWon) return true
        }

        for (i: Int in state.indices) {
            val hasWon = state[i].all { player -> player == currentPlayer }
            if (hasWon) return true
        }

        for (i in state.indices) {
            if (state[i][i] != currentPlayer) return false
        }

        for (i in state.size until 0) {
            if (state[i][i] != currentPlayer) return false
        }

        return true
    }
}