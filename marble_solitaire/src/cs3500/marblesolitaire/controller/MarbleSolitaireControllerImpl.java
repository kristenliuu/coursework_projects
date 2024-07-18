package cs3500.marblesolitaire.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

/**
 * The controller object for the game.
 */
public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  private MarbleSolitaireModel model;
  private MarbleSolitaireView view;
  private Scanner input;

  /**
   * Creates a MarbleSolitaireControllerImpl with the given parameters.
   * @param model An instance of a MarbleSolitaireModel.
   * @param view An instance of a MarbleSolitaireView.
   * @param readable A readable.
   */
  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model, MarbleSolitaireView view,
                                       Readable readable) throws IllegalArgumentException {
    if (model == null) {
      throw new IllegalArgumentException("Model is null!");
    }
    this.model = model;

    if (view == null) {
      throw new IllegalArgumentException("View is null!");
    }
    this.view = view;

    if (readable == null) {
      throw new IllegalArgumentException("Input is null!");
    }
    this.input = new Scanner(readable);
  }


  private void quitGame() {
    try {
      view.renderMessage("Game quit!\n");
      view.renderMessage("State of game when quit:\n");
      view.renderBoard();
      view.renderMessage("Score: " + model.getScore() + "\n");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * Plays a new game of MarbleSolitaire.
   */
  @Override
  public void playGame() {

    while (!model.isGameOver()) {
      try {
        view.renderBoard();
        view.renderMessage("Score: " + model.getScore() + "\n");

        if (input.hasNext("[qQ]")) {
          quitGame();
          break;
        }

        if (!input.hasNext()) {
          throw new IllegalStateException("Input is Empty!");
        }

        String errorMessage = "";
        int[] movement = new int[4];
        for (int i = 0; i < 4;) {
          try {
            movement[i] = input.nextInt() - 1;
            i++;
          } catch (InputMismatchException e) {
            view.renderMessage("Please enter value again.\n");
            // catching if it's not an int
            // if it's not an int, skip the token
            input.next();
          }
        }

        try {
          model.move(movement[0], movement[1], movement[2], movement[3]);
        } catch (IllegalArgumentException e) {
          view.renderMessage("Invalid move. Play again. " + e.getMessage() + "\n");
        }


      } catch (IOException e) {
        // render board and render message throws the IOException
        throw new IllegalStateException(e);

      } catch (NoSuchElementException e) {
        // catching if the input is empty
        // scanner throws the noSuchElementException
        throw new IllegalStateException(e);
      }
    }

    if (model.isGameOver()) {
      try {
        view.renderMessage("Game over!\n");
        view.renderBoard();
        view.renderMessage("Score: " + model.getScore() + "\n");
      } catch (IOException e) {
        throw new IllegalStateException(e);
      }
    }
  }
}

