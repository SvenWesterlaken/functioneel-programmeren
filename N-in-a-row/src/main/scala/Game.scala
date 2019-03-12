import Player.Player

import scala.collection.mutable.ListBuffer

class Game() {

  // We define the gameState and nInRowToWin variables with 'var' so we can change their value
  // In contrast, 'val' defines a constant.
  // Class variables are public by default
  var gameState: GameState.Value = GameState.Uninitialized
  var nInRowToWin: Int = 0
  private var board: Board = _

  // Start a new game with the given parameters
  def startNewGame(rows: Int, columns: Int, nInRowToWin: Int): Unit ={
    board = new Board(rows, columns)
    gameState = GameState.Player1Turn
    this.nInRowToWin = nInRowToWin
  }


  // In Java and C# you used void. Scala uses Unit.
  def sinkChecker(column: Int, player: Player): Unit ={

    // Check if it is indeed this player's turn, otherwise throw IllegalArgumentException
    if ((player == Player.Player1 && gameState != GameState.Player1Turn) ||
        (player == Player.Player2 && gameState != GameState.Player2Turn)) {

      throw new IllegalArgumentException("Not the players turn")
    }

    // Tell the board to sink the checker
    board.sinkChecker(column, player)

    // Winning condition
    var nInARowFound = false


    // Loop through board until winning condition is found
    for (row: Int <- 1 to board.rows; column: Int <- 1 to board.columns if !nInARowFound) {

      // Only check for checkers of the current player
      if (board.getCheckerAtPosition(row, column) == player) {
        var checkersInARow = 1

        // Horizontal check
        if (column + nInRowToWin - 1 <= board.columns) {

          while (checkersInARow < nInRowToWin && checkersInARow >= 1) {
            if (board.getCheckerAtPosition(row, column + checkersInARow) == player) {
              checkersInARow += 1
            } else {
              checkersInARow = 0
            }
          }
        }

        // Vertical check
        if (checkersInARow < nInRowToWin && row + nInRowToWin - 1 <= board.rows) {
          checkersInARow = 1

          while (checkersInARow < nInRowToWin && checkersInARow >= 1) {
            if (board.getCheckerAtPosition(row + checkersInARow, column) == player) {
              checkersInARow += 1
            } else {
              checkersInARow = 0
            }
          }

        }

        // Diagonal check
        if (checkersInARow < nInRowToWin && row + nInRowToWin - 1 <= board.rows && column + nInRowToWin - 1 <= board.columns) {

          checkersInARow = 1

          while (checkersInARow < nInRowToWin && checkersInARow >= 1) {
            if (board.getCheckerAtPosition(row + checkersInARow, column + checkersInARow) == player) {
              checkersInARow += 1
            } else {
              checkersInARow = 0
            }
          }

        }

        if (checkersInARow == nInRowToWin) {
          nInARowFound = true
        }

      }
    }

    // Change the game state to the appropriate GameState.
    if (nInARowFound) {
      gameState = if (player == Player.Player1) GameState.Player1Won else GameState.Player2Won
    } else {
      gameState = if (player == Player.Player1) GameState.Player2Turn else GameState.Player1Turn
    }

  }

  def isGameOver: Boolean ={
    gameState == GameState.Player1Won || gameState == GameState.Player2Won
  }

  override def toString: String = {
    board.toString()
  }
}
