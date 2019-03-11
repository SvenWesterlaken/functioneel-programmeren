import Player.Player

// Defines the board class and its constructor.
class Board(val rows: Int, val columns: Int) {

  // Initializes a two dimensional array that represents the board.
  // Each position either contains the checker of Player1, Player2 or nothing (NoPlayer).
  var board = Array.fill[Player](rows,columns) {Player.NoPlayer}

  // TODO: Returns the owner of the checker at position (row, column).
  // Tip: In the game rows and columns start at 1, but arrays start at 0.
  def getCheckerAtPosition(row: Int, column: Int): Player = {
    board(row - 1)(column - 1)
  }

  // TODO: Returns true of the row and column actually exist on the board.
  def isPositionInBoard(row: Int, column: Int): Boolean = {
    row > rows || row <= 0 || column > columns || column <= 0
  }

  // TODO: The player has placed a checker in a column. It has to sink until it reaches the bottom or another checker
  def sinkChecker(column: Int, player: Player): Unit = {
    var row = 1

    while (isPositionInBoard(row, column) && getCheckerAtPosition(row, column) == Player.NoPlayer ) {
      row += 1
    }

    board(row - 1)(column - 1) = player
  }
s
  // TODO: The toString() method returns a string that visually represents the board.
  // An example representation for a 4x4 board where the player1 has sinked a checker in column 2.
  //
  // 0000
  // 0000
  // 0000
  // 0100
  //
  // Feel free to choose a different visual representation. As long as its easy to understand.
  override def toString(): String = {
    return "" //TODO: The 'return' keyword is optional. You can simply remove it.
  }
}
