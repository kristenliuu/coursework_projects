package cs3500.marblesolitaire.model.hw04;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Represents a Triangle Solitaire game object.
 */
public class TriangleSolitaireModel extends AbstractSolitaireModel {

  /**
   * Default Constructor for the TriangleSolitaireModel class that takes in no parameters.
   */
  public TriangleSolitaireModel() {
    this(5, 0, 0);
  }

  /**
   * Constructor for the TriangleSolitaireModel class that takes in one parameter.
   * @param armThickness The armThickness or dimension of the board.
   */
  public TriangleSolitaireModel(int armThickness) {
    this(armThickness, 0, 0);
  }

  /**
   * Constructor for the TriangleSolitaireModel class that takes in two parameters.
   * @param row The row of the empty slot on the board.
   * @param col The column of the empty slot on the board.
   */
  public TriangleSolitaireModel(int row, int col) {
    this(5, row, col);
  }

  /**
   * Constructor for the TriangleSolitaireModel class that takes in three parameters.
   * @param armThickness The armThickness or dimensions of the board.
   * @param row The row of the empty slot on the board as an int.
   * @param col The column of the empty slot on the board as an int.
   * @throws IllegalArgumentException If the dimensions of the board is not positive.
   */

  public TriangleSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {
    if (armThickness < 1) {
      throw new IllegalArgumentException("Dimension is non-positive!");
    }

    this.armThickness = armThickness;
    this.initBoard(row, col);
  }

  protected void initBoard(int row, int col) {

    if ((row > this.getBoardSize()) || (row < 0) || (col > this.getBoardSize()) || (col < 0)) {
      throw new IllegalArgumentException("Invalid Empty Position!");
    }

    board = new SlotState[getBoardSize()][getBoardSize()];

    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        if (j > i) {
          board[i][j] = SlotState.Invalid;
        } else {
          board[i][j] = SlotState.Marble;
        }
      }
    }

    if ((row > (this.getBoardSize() - 1) || (row < 0) || (col > (this.getBoardSize() - 1) ||
            (col < 0) || (board[row][col].equals(SlotState.Invalid))))) {
      throw new IllegalArgumentException("Invalid Empty Position!");
    }
    board[row][col] = SlotState.Empty;
  }

  //can move horizontally two spots away or diagonally
  @Override
  protected boolean movePosition(int fromRow, int fromCol, int toRow, int toCol) {
    return ((fromRow == toRow && (toCol == fromCol + 2 || toCol == fromCol - 2))
            || (fromCol == toCol && (fromRow == toRow + 2 || fromRow == toRow - 2))
            || ((fromRow == toRow + 2 && fromCol == toCol + 2)
            || (fromRow == toRow - 2 && fromCol == toCol - 2)));
  }

  /**
   * Determines whether the game is over or not.
   * @return true if the game is over and false if the game is not over.
   */
  /// CHANGE
  @Override
  public boolean isGameOver() {
    for (int i = 0; i < getBoardSize(); i++) {
      for (int j = 0; j < getBoardSize(); j++) {
        if (canMove(i, j, i + 2, j)
                || (canMove(i, j, i, j + 2)
                || (canMove(i, j, i - 2, j)
                || (canMove(i, j, i, j - 2)
                || (canMove(i, j, i + 2, j + 2)
                || (canMove(i, j, i - 2, j - 2))))))) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int getBoardSize() {
    return armThickness;
  }
}
