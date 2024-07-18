import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Tests for the EnglishSolitaireModel class.
 */
public class EnglishSolitaireModelTest {
  private EnglishSolitaireModel model1;
  private EnglishSolitaireModel model2;
  private EnglishSolitaireModel model3;
  private EnglishSolitaireModel model4;

  /**
   * Initializes the Data.
   */
  @Before
  public void initData() {
    model1 = new EnglishSolitaireModel();
    model2 = new EnglishSolitaireModel(3, 3);
    model3 = new EnglishSolitaireModel(3);
    model4 = new EnglishSolitaireModel(3, 3, 3);
  }

  // tests constructor 1
  @Test
  public void testFirstConstructor() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(32, model1.getScore());
  }

  // tests constructor 2
  @Test
  public void testSecConstructor() {
    assertEquals(7, model2.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model2.getSlotAt(3, 3));
    assertEquals(32, model2.getScore());
  }

  // tests invalid constructor 2
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidSecConstructor() {
    model2 = new EnglishSolitaireModel(3, -1);
  }

  // tests constructor 3
  @Test
  public void testThirdConstructor() {
    assertEquals(7, model3.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model3.getSlotAt(3, 3));
    assertEquals(32, model3.getScore());
  }

  // tests invalid constructor 3
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidThirdConstructor() {
    model3 = new EnglishSolitaireModel(0);
  }

  // tests constructor 4
  @Test
  public void testFourthConstructor() {
    assertEquals(7, model4.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model4.getSlotAt(3, 3));
    assertEquals(32, model4.getScore());
  }

  // tests invalid constructor 3 (invalid arm thickness)
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor() {
    model4 = new EnglishSolitaireModel(-1,
            3, 3);
  }

  // tests invalid constructor 3 (invalid empty position)
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidFourthConstructor1() {
    model4 = new EnglishSolitaireModel(3,
            -1, 3);
  }

  // tests getSlotAt
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(6, 6));
  }

  // tests for invalid moves
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove1() {
    model1.move(3, 1, 3, 0);
  }

  @Test (expected = IllegalArgumentException.class)
    public void testInvalidMove2() {
    model1.move(3, 1, 0, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove3() {
    model1.move(3, 0, 0, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove4() {
    model1.move(0, 1, 0, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove5() {
    model1.move(-1, 1, 0, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove6() {
    model1.move(3, -1, 0, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove7() {
    model1.move(3, 1, 7, 3);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove8() {
    model1.move(3, 1, 3, 8);
  }

  // jumps over an empty slot
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove9() {
    model1.move(3, 2, 3, 4);
  }

  // jumps diagonally 2 spots away
  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMove10() {
    model1.move(3, 2, 1, 4);
  }

  // tests the size of the board
  @Test
  public void testGetBoardSize() {
    assertEquals(7, model1.getBoardSize());
  }

  // tests getScore
  @Test
  public void testGetScore() {
    assertEquals(32, model1.getScore());
  }

  // move vertical down
  @Test
  public void testMove1() {
    model1.move(1,3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 3));
  }

  // move vertical up
  @Test
  public void testMove2() {
    model1.move(5,3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 3));
  }

  // move horizontal right
  @Test
  public void testMove3() {
    model1.move(3,1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 2));
  }

  // move horizontal left
  @Test
  public void testMove4() {
    model1.move(3,5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 4));
  }

  // test when game is not over
  @Test
  public void testIsGameOver() {
    assertEquals(false, model1.isGameOver());
  }

  // test when game is over
  @Test
  public void testIsGameOver2() {
    model1.move(3,1, 3, 3);
    model1.move(1,2, 3, 2);
    model1.move(4,2, 2, 2);
    model1.move(6,2, 4, 2);
    model1.move(1,4, 1, 2);
    model1.move(3,4, 1, 4);
    model1.move(2,2, 2, 4);
    model1.move(2,5, 2, 3);
    model1.move(5,4, 3, 4);
    model1.move(0,2, 2, 2);
    model1.move(2,2, 2, 4);
    model1.move(2,0, 2, 2);
    model1.move(6,4, 6, 2);
    model1.move(4,0, 2, 0);
    model1.move(2,4, 4, 4);
    model1.move(0,4, 2, 4);
    model1.move(4,3, 2, 3);
    model1.move(4,2, 4, 0);
    model1.move(4,5, 2, 5);
    model1.move(2,3, 2, 1);
    model1.move(2,0, 2, 2);
    model1.move(2,5, 2, 3);
    model1.move(2,3, 2, 1);
    assertEquals(true, model1.isGameOver());
  }
}

