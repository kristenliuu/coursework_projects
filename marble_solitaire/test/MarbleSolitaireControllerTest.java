import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.nio.CharBuffer;

import cs3500.marblesolitaire.controller.MarbleSolitaireControllerImpl;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;
import cs3500.marblesolitaire.view.MarbleSolitaireView;

import static org.junit.Assert.assertEquals;

/**
 * Test class for MarbleSolitaireController.
 */
public class MarbleSolitaireControllerTest {

  private MarbleSolitaireControllerImpl controller;

  private MarbleSolitaireModel model;

  private MarbleSolitaireView view;



  @Before
  public void initData() {
    model = new EnglishSolitaireModel();
    view = new MarbleSolitaireTextView(new EnglishSolitaireModel());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor() {
    StringReader readable = new StringReader("q");
    controller = new MarbleSolitaireControllerImpl(null, view, readable);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor1() {
    StringReader readable = new StringReader("q");
    controller = new MarbleSolitaireControllerImpl(model, view, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructor2() {
    StringReader readable = new StringReader("q");
    controller = new MarbleSolitaireControllerImpl(model, null, readable);
  }

  // tests "q"
  @Test
  public void testQuit1() throws Exception {
    StringReader reader = new StringReader("q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests "Q"
  @Test
  public void testQuit2() throws Exception {
    StringReader reader = new StringReader("Q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }


  // tests one move down
  @Test
  public void testMove1Quit() throws Exception {
    StringReader reader = new StringReader("2 4 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests one move down and "Q"
  @Test
  public void testMove1Quit2() throws Exception {
    StringReader reader = new StringReader("2 4 4 4 Q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests one move up
  @Test
  public void testMove2Quit() throws Exception {
    StringReader reader = new StringReader("6 4 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "    O _ O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests one move left
  @Test
  public void testMove3Quit() throws Exception {
    StringReader reader = new StringReader("4 6 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests one move right
  @Test
  public void testMove4Quit() throws Exception {
    StringReader reader = new StringReader("4 2 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests multiple valid moves
  @Test
  public void testMultipleMoves() throws Exception {
    StringReader reader = new StringReader("2 4 4 4 3 2 3 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", bytes.toString());
  }

  // tests bad input in a valid move
  @Test
  public void testBadInput1Move() throws Exception {
    StringReader reader = new StringReader("4 6 j 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Please enter value again.\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O O _ _ O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // tests bad input in multiple valid moves
  @Test
  public void testBadInputMoves() throws Exception {
    StringReader reader = new StringReader("2 4 4 4 3 k 2 3 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Please enter value again.\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n", bytes.toString());
  }

  // test with only one input that is bad (not "q" or "Q")
  @Test(expected = IllegalStateException.class)
  public void testBadInput() {
    StringReader reader = new StringReader("j");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
  }

  // test with only one input that is bad (neg int)
  @Test(expected = IllegalStateException.class)
  public void testBadInput1() {
    StringReader reader = new StringReader("-4");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
  }

  // ran out of input
  @Test(expected = IllegalStateException.class)
  public void testBadInput2() {
    StringReader reader = new StringReader("6 4");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
  }

  // tests when the move is invalid (middle is not empty)
  @Test
  public void testInvalidMove() throws Exception {
    StringReader reader = new StringReader("1 3 4 3 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests an invalid move (out of bound)
  @Test
  public void testInvalidMove2() throws Exception {
    StringReader reader = new StringReader("2 4 -3 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests an invalid move (from is empty)
  @Test
  public void testInvalidMove3() throws Exception {
    StringReader reader = new StringReader("3 3 1 3 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests an invalid move (to is not empty)
  @Test
  public void testInvalidMove4() throws Exception {
    StringReader reader = new StringReader("0 2 0 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests an invalid move (diagonal)
  @Test
  public void testInvalidMove5() throws Exception {
    StringReader reader = new StringReader("0 2 2 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n", bytes.toString());
  }

  // tests when one move is valid but the next move is invalid
  @Test
  public void testValidInvalidMove() throws Exception {
    StringReader reader = new StringReader("2 4 4 4 5 2 3 1 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Invalid move. Play again. Move is Invalid!\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "Game quit!\n" +
            "State of game when quit:\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n", bytes.toString());
  }

  // test game is over
  @Test
  public void testGameOver() throws Exception {
    StringReader reader = new StringReader("4 2 4 4 2 3 4 3 5 3 3 3 7 3 5 3 2 5 2 3 4 5 " +
            "2 5 3 3 3 5 3 6 3 4 6 5 4 5 1 3 3 3 3 3 3 5 3 1 3 3 7 5 7 3 5 1 3 1 3 5 5 5 1 " +
            "5 3 5 5 4 3 4 5 3 5 1 5 6 3 6 3 4 3 2 3 1 3 3 3 6 3 4 3 4 3 2");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = new EnglishSolitaireModel();
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 32\n" +
            "    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 31\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O _ O O O O\n" +
            "O _ O O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 30\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O _ O O O O\n" +
            "    O O O\n" +
            "    O O O\n" +
            "Score: 29\n" +
            "    O O O\n" +
            "    _ O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "Score: 28\n" +
            "    O O O\n" +
            "    O _ _\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "Score: 27\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O O O _ O O\n" +
            "O _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "Score: 26\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O _ _ O O O\n" +
            "O _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "Score: 25\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ O _ O O\n" +
            "O O O O O O O\n" +
            "    _ O O\n" +
            "    _ O O\n" +
            "Score: 24\n" +
            "    O O O\n" +
            "    O _ O\n" +
            "O O _ O _ _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O _ O O\n" +
            "    _ O _\n" +
            "    _ O O\n" +
            "Score: 23\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O O O O _ _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O _ O O\n" +
            "    _ O _\n" +
            "    _ O O\n" +
            "Score: 22\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O O _ _ O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O _ O O\n" +
            "    _ O _\n" +
            "    _ O O\n" +
            "Score: 21\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O _ O O\n" +
            "    _ O _\n" +
            "    _ O O\n" +
            "Score: 20\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "_ _ O _ O _ O\n" +
            "O _ _ O O O O\n" +
            "O O O O _ O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 19\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O _ O _ O\n" +
            "_ _ _ O O O O\n" +
            "_ O O O _ O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 18\n" +
            "    _ O O\n" +
            "    _ _ O\n" +
            "O _ O _ _ _ O\n" +
            "_ _ _ O _ O O\n" +
            "_ O O O O O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 17\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O _ O _ O\n" +
            "_ _ _ O _ O O\n" +
            "_ O O O O O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 16\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O O O _ O\n" +
            "_ _ _ _ _ O O\n" +
            "_ O O _ O O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 15\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O O O _ O\n" +
            "_ _ _ _ _ O O\n" +
            "O _ _ _ O O O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 14\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O _ O O O O O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 13\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "O O _ _ O O O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 12\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "_ _ O _ O O O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 11\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "_ _ O O _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 10\n" +
            "Game over!\n" +
            "    _ O _\n" +
            "    _ _ _\n" +
            "_ O _ _ _ _ O\n" +
            "_ _ _ _ _ _ O\n" +
            "O _ _ _ O _ O\n" +
            "    _ O _\n" +
            "    O _ _\n" +
            "Score: 9\n", bytes.toString());
  }

  // tests null model (constructor)
  @Test(expected = IllegalArgumentException.class)
  public void testNull() {
    StringReader reader = new StringReader("2 4 4 4 q");
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    EnglishSolitaireModel model = null;
    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(model, new
            MarbleSolitaireTextView(model, out), reader);
    controller.playGame();
    System.out.println(bytes.toString());
  }

  //playGame throws an illegalStateException
  @Test(expected = IllegalStateException.class)
  public void testplayGameIO() throws IllegalStateException {

    Readable in = new Readable() {
      @Override
      public int read(CharBuffer cb) throws IOException {
        throw new IOException();
      }
    };

    Appendable out = new Appendable() {
      public Appendable append(CharSequence csq) throws IOException {
        throw new IOException();
      }

      public Appendable append(CharSequence csq, int start, int end) throws IOException {
        throw new IOException();
      }

      public Appendable append(char out) throws IOException {
        throw new IOException();
      }
    };

    MarbleSolitaireControllerImpl controller = new MarbleSolitaireControllerImpl(new
            EnglishSolitaireModel(), new MarbleSolitaireTextView(new EnglishSolitaireModel(), out),
            in);
    controller.playGame();
  }


}
