package cs3500.marblesolitaire.model.hw04;


/**
 * Represents a European Solitaire game object.
 */
public class EuropeanSolitaireModel extends AbstractSolitaireModel {

  /**
   * Default Constructor for the EuropeanSolitaireModel class that takes in no parameters.
   */
  public EuropeanSolitaireModel() {
    this(3);
  }

  /**
   * Constructor for the EuropeanSolitaireModel class that takes in one parameter.
   * @param armThickness The armThickness or side length of the board.
   */
  public EuropeanSolitaireModel(int armThickness) {
    this(armThickness,((armThickness * 3) - 2) / 2 , ((armThickness * 3) - 2) / 2);
  }

  /**
   * Constructor for the EuropeanSolitaireModel class that takes in two parameters.
   * @param sRow The row of the empty slot on the board.
   * @param sCol The column of the empty slot on the board.
   */
  public EuropeanSolitaireModel(int sRow, int sCol) {
    this(3, sRow, sCol);
  }

  /**
   * Constructor for the EuropeanSolitaireModel class that takes in three parameters.
   * @param armThickness The armThickness or side length of the board.
   * @param row The row of the empty slot on the board.
   * @param col The column of the empty slot on the board.
   * @throws IllegalArgumentException If the armThickness is not a positive odd number.
   */
  public EuropeanSolitaireModel(int armThickness, int row, int col)
          throws IllegalArgumentException {

    if ((armThickness < 0) || (armThickness % 2 == 0)) {
      throw new IllegalArgumentException("Must be a positive odd number!");
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
      int numMarbles = 0;
      if (i < armThickness) {
        numMarbles = (2 * i) + armThickness;
      } else if (i >= armThickness && i < (2 * armThickness - 1)) {
        numMarbles = getBoardSize();
      } else {
        numMarbles = (2 * (getBoardSize() - 1 - i)) + armThickness;
      }

      int j = 0;
      int k = (this.getBoardSize() - numMarbles) / 2;
      for (; j < k; j++) {
        board[i][j] = SlotState.Invalid;
      }

      for (; j < (k + numMarbles); j++) {
        board[i][j] = SlotState.Marble;
      }

      for (; j < getBoardSize(); j++) {
        board[i][j] = SlotState.Invalid;
      }
    }

    if ((row > this.getBoardSize()) || (row < 0) || (col > this.getBoardSize()) || (col < 0)
            || (board[row][col].equals(SlotState.Invalid))) {
      throw new IllegalArgumentException("Invalid Empty Position!");
    }
    board[row][col] = SlotState.Empty;
  }

  @Override
  public int getBoardSize() {
    return ((armThickness * 3) - 2);
  }
}
