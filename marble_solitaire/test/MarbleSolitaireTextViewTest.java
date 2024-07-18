import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireTextView;

/**
 * Tests for the MarbleSolitaireTextViewTest class.
 */
public class MarbleSolitaireTextViewTest {

  private EnglishSolitaireModel board1;
  private EuropeanSolitaireModel board2;
  private EuropeanSolitaireModel board3;
  private TriangleSolitaireModel board4;
  private MarbleSolitaireTextView viewBoard1;
  private MarbleSolitaireTextView viewBoard2;
  private MarbleSolitaireTextView viewBoard3;
  private MarbleSolitaireTextView viewBoard4;
  private Appendable sb;

  /**
   * Initializes the Data.
   */
  @Before
  public void initData() {
    board1 = new EnglishSolitaireModel();
    board2 = new EuropeanSolitaireModel();
    board3 = new EuropeanSolitaireModel(5);
    sb = new StringBuilder();
    viewBoard1 = new MarbleSolitaireTextView(this.board1);
    viewBoard2 = new MarbleSolitaireTextView(this.board1, sb);
    viewBoard4 = new MarbleSolitaireTextView(this.board3);
  }

  // test null constructor 1
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor() {
    viewBoard1 = new MarbleSolitaireTextView(null);
  }

  // test null constructor 2
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor1() {
    viewBoard2 = new MarbleSolitaireTextView(null, sb);
  }

  // test null constructor 2
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor2() {
    viewBoard2 = new MarbleSolitaireTextView(board1, null);
  }

  // tests toString at the start of the game
  @Test
  public void testToString() {
    board1 = new EnglishSolitaireModel();
    viewBoard1 = new MarbleSolitaireTextView(this.board1);
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", this.viewBoard1.toString());
  }

  // Tests toString after one move
  @Test
  public void testToStringMove() {
    board1 = new EnglishSolitaireModel();
    board1.move(3, 1, 3, 3);
    viewBoard1 = new MarbleSolitaireTextView(this.board1);
    System.out.println(viewBoard1.toString());
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O", viewBoard1.toString());
  }

  // tests renderBoard
  @Test
  public void testRenderBoard() throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), out);
    view.renderBoard();
    assertEquals("    O O O\n" +
            "    O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "    O O O\n" +
            "    O O O\n", bytes.toString());
  }

  //throws IOException
  @Test(expected = IOException.class)
  public void testRenderBoard1() throws IOException {

    // anonymous class implements Appendable()
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

    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), out);
    view.renderBoard();
  }

  // tests renderMessage
  @Test
  public void testRenderMessage() throws IOException {
    board1 = new EnglishSolitaireModel();
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), out);
    view.renderMessage("Score: " + board1.getScore() + "\n");
    System.out.println(bytes.toString());
    assertEquals("Score: 32\n", bytes.toString());
  }

  //throws IOException
  @Test(expected = IOException.class)
  public void testRenderMessage1() throws IOException {

    // anonymous class implements Appendable()
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

    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EnglishSolitaireModel(), out);
    view.renderMessage("Score: " + board1.getScore() + "\n");
  }

  //////////////////////////////////////////////////////////////////////////////////////////////

  // tests toString for EuropeanSolitaireModel at the start of the game
  @Test
  public void testEuropeanToString() {
    board2 = new EuropeanSolitaireModel();
    viewBoard3 = new MarbleSolitaireTextView(this.board2);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", viewBoard3.toString());
  }

  // tests toString for EuropeanSolitaireModel with a larger board at the start of the game
  @Test
  public void testEuropeanToString2() {
    board3 = new EuropeanSolitaireModel(5);
    viewBoard4 = new MarbleSolitaireTextView(this.board3);
    assertEquals("        O O O O O\n" +
            "      O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O _ O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "O O O O O O O O O O O O O\n" +
            "  O O O O O O O O O O O\n" +
            "    O O O O O O O O O\n" +
            "      O O O O O O O\n" +
            "        O O O O O", viewBoard3.toString());
  }

  // tests toString for EuropeanSolitaireModel after one move.
  @Test
  public void testEuropeanToStringMove() {
    board2 = new EuropeanSolitaireModel();
    viewBoard3 = new MarbleSolitaireTextView(this.board2);
    board2.move(3, 1, 3, 3);
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O _ _ O O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O", viewBoard3.toString());
  }

  // tests renderBoard
  @Test
  public void testRenderEuropeanBoard() throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EuropeanSolitaireModel(), out);
    view.renderBoard();
    assertEquals("    O O O\n" +
            "  O O O O O\n" +
            "O O O O O O O\n" +
            "O O O _ O O O\n" +
            "O O O O O O O\n" +
            "  O O O O O\n" +
            "    O O O\n", bytes.toString());
  }

  //throws IOException
  @Test(expected = IOException.class)
  public void testRenderEuropeanBoard1() throws IOException {

    // anonymous class implements Appendable()
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

    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EuropeanSolitaireModel(), out);
    view.renderBoard();
  }

  // tests renderMessage
  @Test
  public void testEuropeanRenderMessage() throws IOException {
    board2 = new EuropeanSolitaireModel();
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EuropeanSolitaireModel(), out);
    view.renderMessage("Score: " + board2.getScore() + "\n");
    assertEquals("Score: 36\n", bytes.toString());
  }

  //throws IOException
  @Test(expected = IOException.class)
  public void testEuropeanRenderMessage1() throws IOException {

    // anonymous class implements Appendable()
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

    MarbleSolitaireTextView view = new MarbleSolitaireTextView(new EuropeanSolitaireModel(), out);
    view.renderMessage("Score: " + board2.getScore() + "\n");
  }
}

