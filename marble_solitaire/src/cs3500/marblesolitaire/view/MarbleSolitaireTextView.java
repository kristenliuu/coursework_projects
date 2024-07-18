package cs3500.marblesolitaire.view;


import java.io.IOException;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

/**
 * Represents the view for the Marble Solitaire Game.
 */
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  MarbleSolitaireModelState model;
  Appendable output;

  /**
   * Represents the constructor for MarbleSolitaireTextView.
   * @param model the argument as a MarbleSolitaireModelState type.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model) {
    // calls the other constructor
    this(model, System.out);
  }

  /**
   * Creates a MarbleSolitaireTextView with the given parameters.
   * @param model A MarbleSolitaireModelState type.
   * @param output An appendable output.
   */
  public MarbleSolitaireTextView(MarbleSolitaireModelState model, Appendable output) {
    if (model == null) {
      throw new IllegalArgumentException("Model is Null!");
    }
    this.model = model;

    if (output == null) {
      throw new IllegalArgumentException("Output is Null!");
    }
    this.output = output;
  }

  /**
   * Represents the current state of the board as a string.
   * @return the state of the game as a string.
   */
  public String toString() {
    StringBuilder s = new StringBuilder();

    for (int i = 0; i < model.getBoardSize(); i++) {
      for (int j = 0; j < model.getBoardSize(); j++) {
        if (model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Invalid)
                && j < (int) (model.getBoardSize()) / 2) {
          s.append(" ");
        } else if (model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Empty)) {
          s.append("_");
        } else if (model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Marble)) {
          s.append("O");
        } else {
          s.append("");
        }

        if (j < model.getBoardSize() - 1) {
          if (!model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Invalid)
                  || j < (int) (model.getBoardSize()) / 2) {
            if (model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Marble)
                    && model.getSlotAt(i, j + 1).equals(
                            MarbleSolitaireModelState.SlotState.Invalid)) {
              s.append("");
            } else
              if (model.getSlotAt(i, j).equals(MarbleSolitaireModelState.SlotState.Empty)
                      && model.getSlotAt(i, j + 1).equals(
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

  @Override
  public void renderBoard() throws IOException {
    output.append(toString() + "\n");
  }

  @Override
  public void renderMessage(String message) throws IOException {
    output.append(message);
  }
}
