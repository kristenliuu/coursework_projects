package cs3500.marblesolitaire.view;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the view of the Triangle Solitaire Board.
 */
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  /**
   * Represents the constructor for MarbleSolitaireTextView that takes in one parameter.
   *
   * @param model the argument as a MarbleSolitaireModelState type.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model) {
    super(model);
  }

  /**
   * Creates a MarbleSolitaireTextView with the given two parameters.
   *
   * @param model  A MarbleSolitaireModelState type.
   * @param output An appendable output.
   */
  public TriangleSolitaireTextView(MarbleSolitaireModelState model, Appendable output) {
    super(model, output);
  }

  /**
   * Represents the current state of the board as a string.
   *
   * @return the state of the game as a string.
   */
  public String toString() {
    StringBuilder s = new StringBuilder();

    int viewBoardWidth = model.getBoardSize() + (model.getBoardSize() - 1);
    int count = model.getBoardSize();
    for (int i = 0; i < model.getBoardSize(); i++) {
      //s.append("\n");
      int numMarbles = i + 1;
      count = count - 1;
      // where the marbles start in each row
      int j = count;

      // invalid (spaces) before the marbles start
      for (int k = 0; k < j; k++) {
        s.append(" ");
      }


      for (int k = 0; k < numMarbles; k++) {
        if (model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Invalid)
                && k < (int) (model.getBoardSize()) / 2) {
          s.append(" ");
        } else if (model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          s.append("_");
        } else if (model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          s.append("O");
        } else {
          s.append("");
        }

        if (k < model.getBoardSize() - 1) {
          if (!model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Invalid)
                  || k < (int) (model.getBoardSize()) / 2) {
            if (model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Marble)
                    && model.getSlotAt(i, k + 1).equals(
                            MarbleSolitaireModelState.SlotState.Invalid)) {
              s.append("");
            } else if (model.getSlotAt(i, k).equals(MarbleSolitaireModelState.SlotState.Empty)
                    && model.getSlotAt(i, k + 1).equals(
                            MarbleSolitaireModelState.SlotState.Invalid)) {
              s.append("");
            } else {
              s.append(" ");
            }
          }
        }
      }
      if (i < model.getBoardSize() - 1) {
        s.append("\n");
      }
    }
    return s.toString();
  }
}

