package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw04.AbstractSolitaireModel;

/**
 * Represents an English Solitaire game object.
 */

public class EnglishSolitaireModel extends AbstractSolitaireModel {

  /**
   * Creates an EnglishSolitaireModel object.
   */
  public EnglishSolitaireModel() {
    this.armThickness = 3;
    this.initBoard(getBoardSize() / 2, getBoardSize() / 2);
  }

  /**
   * Creates an EnglishSolitaireModel object with the given parameters.
   * @param sRow Represents the row of the empty space.
   * @param sCol Represents the column of the empty space.
   */
  public EnglishSolitaireModel(int sRow, int sCol) {
    this.armThickness = 3;
    this.initBoard(sRow, sCol);
  }

  /**
   * Creates an EnglishSolitaireModel object with the given parameters.
   * @param armThickness The number of marbles in top, bottom, right, and left rows and collumns.
   * @throws IllegalArgumentException if the armThickness is negative or even.
   */
  public EnglishSolitaireModel(int armThickness) {
    if ((armThickness < 0) || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Must be a positive odd number!");
    }
    this.armThickness = armThickness;
    this.initBoard(getBoardSize() / 2, getBoardSize() / 2);
  }

  /**
   * Creates an EnglishSolitaireModel object with the given parameters.
   * @param armThickness The number of marbles in top, bottom, right, and left rows and collumns.
   * @param sRow Represents the row of the empty space.
   * @param sCol Represents the column of the empty space.
   */
  public EnglishSolitaireModel(int armThickness, int sRow, int sCol) {
    if ((armThickness < 0) || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Must be a positive odd number!");
    }

    this.armThickness = armThickness;
    this.initBoard(sRow, sCol);
  }

  protected void initBoard(int row, int col) {
    board = new SlotState[getBoardSize()][getBoardSize()];
    for (int i = 0; i < this.getBoardSize(); i++) {
      for (int j = 0; j < this.getBoardSize(); j++) {
        board[i][j] = SlotState.Marble;

        if ((i < armThickness - 1 || i >= ( 2 * armThickness) - 1)
                && (j < (armThickness - 1) || j >= ( 2 * armThickness) - 1)) {
          board[i][j] = SlotState.Invalid;
        }
      }
    }
    if ((row > this.getBoardSize()) || (row < 0) || (col > this.getBoardSize()) || (col < 0)
            || (board[row][col].equals(SlotState.Invalid))) {
      throw new IllegalArgumentException("Invalid Empty Position!");
    }
    board[row][col] = SlotState.Empty;
  }

  /**
   * Represents the size of the board.
   * @return the size of the board as an integer.
   */
  @Override
  public int getBoardSize() {
    return ((armThickness * 2) + (armThickness - 2));
  }


}
