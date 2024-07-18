import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.EuropeanSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests the EuropeanSolitaireModel.
 */
public class EuropeanSolitaireModelTest {

  private EuropeanSolitaireModel model1;
  private EuropeanSolitaireModel model2;
  private EuropeanSolitaireModel model3;
  private EuropeanSolitaireModel model4;

  /**
   * Initializes the Data.
   */
  @Before
  public void initData() {
    model1 = new EuropeanSolitaireModel();
    model2 = new EuropeanSolitaireModel(3, 3);
    model3 = new EuropeanSolitaireModel(3);
    model4 = new EuropeanSolitaireModel(3, 3, 3);
  }

  @Test
  public void testConstructor1() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(36, model1.getScore());
  }

  @Test
  public void testConstructor2() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(36, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    model2 = new EuropeanSolitaireModel(3, -1);
  }

  @Test
  public void testConstructor3() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(36, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    model3 = new EuropeanSolitaireModel(0);
  }

  @Test
  public void testConstructor4() {
    assertEquals(7, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(36, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    model4 = new EuropeanSolitaireModel(-1,
            3, 3);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalid2Constructor4() {
    model4 = new EuropeanSolitaireModel(3,
            -1, 3);
  }

  // tests getSlotAt
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 4));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(6, 6));
  }

  // INVALID MOVES:

  // invalid move over an empty slot
  @Test(expected = IllegalArgumentException.class)
  public void invalidOverEmptyMove() {
    model1.move(3, 2, 3, 4);
  }

  // invalid move from an empty slot
  @Test(expected = IllegalArgumentException.class)
  public void invalidFromEmptyMove() {
    model1.move(3, 1, 3, 3);
    model1.move(3, 4, 3, 2);
    model1.move(3, 1, 3, 3);
  }

  // invalid move to a marble slot
  @Test(expected = IllegalArgumentException.class)
  public void invalidToMarbleMove() {
    model1.move(0, 2, 0, 4);
  }

  // invalid move vertically up MORE than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidVertUpMove() {
    model1.move(6, 3, 3, 3);
  }

  // invalid move vertically up LESS than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidVertUpMove2() {
    model1.move(4, 3, 3, 3);
  }

  // invalid move vertically down MORE than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidVertDownMove() {
    model1.move(0, 3, 3, 3);
  }

  // invalid move vertically down LESS than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidVertDownMove2() {
    model1.move(2, 3, 3, 3);
  }

  // invalid move horizontally right MORE than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidHorizRightMove() {
    model1.move(3, 0, 3, 3);
  }

  // invalid move horizontally right LESS than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidHorizRightMove2() {
    model1.move(3, 2, 3, 3);
  }

  // invalid move horizontally left MORE than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidHorizLeftMove() {
    model1.move(3, 6, 3, 3);
  }

  // invalid move horizontally left LESS than two slots
  @Test(expected = IllegalArgumentException.class)
  public void invalidHorizLeftMove2() {
    model1.move(3, 4, 3, 3);
  }

  // tests the size of the board
  @Test
  public void testGetBoardSize() {
    assertEquals(7, model1.getBoardSize());
  }

  // tests getScore
  @Test
  public void testGetScore() {
    assertEquals(36, model1.getScore());
  }

  // VALID MOVES:
  // valid move horizontally right two slots away
  @Test
  public void validHorizRightMove() {
    model1.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 2));

  }

  // valid move horizontally left two slots away
  @Test
  public void validHorizLeftMove() {
    model1.move(3, 5, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 5));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(3, 4));
  }

  // valid move vertically up two slots away
  @Test
  public void validVertUpMove() {
    model1.move(5, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(5, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(4, 3));
  }

  // valid move vertically down two slots away
  @Test
  public void validVertDownMove() {
    model1.move(1, 3, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 3));
  }

  // GAME OVER
  // test when game is NOT over
  @Test
  public void testGameIsNotOver() {
    assertEquals(false, model1.isGameOver());
  }

  // test when game IS over
  @Test
  public void testGameIsOver() {
    model1.move(3, 1, 3, 3);
    model1.move(5, 1, 3, 1);
    model1.move(3, 0, 3, 2);
    model1.move(1, 1, 3, 1);
    model1.move(1, 3, 1, 1);
    model1.move(3, 2, 3, 0);
    model1.move(5, 3, 5, 1);
    model1.move(3, 3, 5, 3);
    model1.move(1, 5, 1, 3);
    model1.move(1, 3, 3, 3);
    model1.move(3, 5, 1, 5);
    model1.move(6, 3, 4, 3);
    model1.move(4, 3, 2, 3);
    model1.move(5, 5, 3, 5);
    model1.move(3, 5, 3, 3);
    model1.move(2, 3, 4, 3);
    model1.move(4, 3, 4, 5);
    model1.move(4, 6, 4, 4);
    model1.move(5, 4, 3, 4);
    model1.move(2, 4, 4, 4);
    model1.move(2, 6, 4, 6);
    assertEquals(true, model1.isGameOver());
  }
}
