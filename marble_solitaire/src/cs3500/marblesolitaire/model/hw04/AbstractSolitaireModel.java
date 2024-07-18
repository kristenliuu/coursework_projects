package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the abstract class for the Marble Solitaire Model.
 */
public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected int armThickness;

  protected SlotState[][] board;


  protected boolean inBound(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromRow >= 0 && fromRow < this.getBoardSize()) && (toRow >= 0
            && toRow < this.getBoardSize()) && (fromCol >= 0 && fromCol < this.getBoardSize())
            && (toCol >= 0 && toCol < this.getBoardSize()));
  }

  protected boolean fromHasMarble(int fromRow, int fromCol) {
    return (board[fromRow][fromCol].equals(MarbleSolitaireModelState.SlotState.Marble));
  }

  protected boolean toIsEmpty(int toRow, int toCol) {
    return (board[toRow][toCol].equals(MarbleSolitaireModelState.SlotState.Empty));
  }

  protected boolean marbleBetween(int fromRow, int fromCol, int toRow, int toCol) {
    return (board[(fromRow + toRow) / 2][(fromCol + toCol) / 2].equals(MarbleSolitaireModelState.
            SlotState.Marble));
  }

  protected boolean movePosition(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromRow == toRow && (toCol == fromCol + 2 || toCol == fromCol - 2))
            || ((fromCol == toCol && (toRow == fromRow + 2 || toRow == fromRow - 2))));
  }

  protected void updateSlots(int fromRow, int fromCol, int toRow, int toCol) {
    board[fromRow][fromCol] = MarbleSolitaireModelState.SlotState.Empty;
    board[toRow][toCol] = MarbleSolitaireModelState.SlotState.Marble;
    board[(fromRow + toRow) / 2][(fromCol + toCol) / 2] = MarbleSolitaireModelState.SlotState.Empty;
  }

  protected boolean canMove(int fromRow, int fromCol, int toRow, int toCol) {
    return (inBound(fromRow, fromCol, toRow, toCol)
            && fromHasMarble(fromRow, fromCol) && toIsEmpty(toRow, toCol)
            && movePosition(fromRow, fromCol, toRow, toCol)
            && marbleBetween(fromRow, fromCol, toRow, toCol));
  }

  /**
   * Moves a marble piece after a single move from one position to another.
   * @param fromRow the row number of the position to be moved from
   *                (starts at 0)
   * @param fromCol the column number of the position to be moved from
   *                (starts at 0)
   * @param toRow   the row number of the position to be moved to
   *                (starts at 0)
   * @param toCol   the column number of the position to be moved to
   *                (starts at 0)
   * @throws IllegalArgumentException if the move is invalid.
   */

  public void move(int fromRow, int fromCol, int toRow, int toCol) throws IllegalArgumentException {
    if (canMove(fromRow, fromCol, toRow, toCol)) {
      updateSlots(fromRow, fromCol, toRow, toCol);
    } else {
      throw new IllegalArgumentException("Move is Invalid!");
    }
  }

  /**
   * Represents the state of a slot at a given position.
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at a given row and column.
   * @throws IllegalArgumentException if the slot position is invalid.
   */
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col)
          throws IllegalArgumentException {
    if (row < 0 && row > this.getBoardSize() && col < 0 && col > this.getBoardSize()) {
      throw new IllegalArgumentException("Invalid Slot Position!");
    } else {
      return board[row][col];
    }
  }


  /**
   * Determines whether the game is over or not.
   * @return true if the game is over and false if the game is not over.
   */
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (canMove(i, j, i + 2, j)
                || (canMove(i, j, i, j + 2)
                || (canMove(i, j, i - 2, j)
                || (canMove(i, j, i, j - 2))))) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the number of marbles that is currently on the board.
   * @return the number of marble on the board as an integer.
   */
  public int getScore() {
    int count = 0;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j].equals(MarbleSolitaireModelState.SlotState.Marble)) {
          count ++;
        }
      }
    }
    return count;
  }

}
