import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;
import cs3500.marblesolitaire.view.MarbleSolitaireView;
import cs3500.marblesolitaire.view.TriangleSolitaireTextView;

import static org.junit.Assert.assertEquals;

/**
 * Tests TriangleSolitaireTextView.
 */
public class TriangleSolitaireTextViewTest {

  MarbleSolitaireModel model1;
  MarbleSolitaireModel model2;
  MarbleSolitaireView viewboard1;
  MarbleSolitaireView viewboard2;
  MarbleSolitaireView viewboard3;
  private Appendable sb;

  @Before
  public void initData() {
    model1 = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(5);
    viewboard1 = new TriangleSolitaireTextView(model1);
    sb = new StringBuilder();
    viewboard2 = new TriangleSolitaireTextView(this.model1, sb);
    viewboard3 = new TriangleSolitaireTextView(this.model2);
  }

  // test null constructor 1
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor() {
    viewboard1 = new TriangleSolitaireTextView(null);
  }

  // test null constructor 2
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor1() {
    viewboard2 = new TriangleSolitaireTextView(null, sb);
  }

  // test null constructor 2
  @Test(expected = IllegalArgumentException.class)
  public void invalidConstructor2() {
    viewboard2 = new TriangleSolitaireTextView(model1,
            null);
  }


  @Test
  public void testTriangleToString() {
    model1 = new TriangleSolitaireModel();
    viewboard1 = new TriangleSolitaireTextView(model1);
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O", viewboard1.toString());
  }

  // Tests toString after one move
  @Test
  public void testToStringMove() {
    model1 = new TriangleSolitaireModel();
    model1.move(2, 2, 0, 0);
    viewboard1 = new TriangleSolitaireTextView(this.model1);
    assertEquals("    O\n" +
            "   O _\n" +
            "  O O _\n" +
            " O O O O\n" +
            "O O O O O", viewboard1.toString());
  }

  // tests renderBoard
  @Test
  public void testRenderBoard() throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            out);
    view.renderBoard();
    assertEquals("    _\n" +
            "   O O\n" +
            "  O O O\n" +
            " O O O O\n" +
            "O O O O O\n", bytes.toString());
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

    TriangleSolitaireTextView view = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            out);
    view.renderBoard();
  }

  // tests renderMessage
  @Test
  public void testRenderMessage() throws IOException {
    model1 = new TriangleSolitaireModel();
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    PrintStream out = new PrintStream(bytes);
    TriangleSolitaireTextView view = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            out);
    view.renderMessage("Score: " + model1.getScore() + "\n");
    assertEquals("Score: 14\n", bytes.toString());
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

    TriangleSolitaireTextView view = new TriangleSolitaireTextView(new TriangleSolitaireModel(),
            out);
    view.renderMessage("Score: " + model1.getScore() + "\n");
  }
}
