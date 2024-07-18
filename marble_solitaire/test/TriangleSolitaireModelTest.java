import org.junit.Before;
import org.junit.Test;

import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;
import cs3500.marblesolitaire.model.hw04.TriangleSolitaireModel;

import static org.junit.Assert.assertEquals;

/**
 * Tests for TriangleSolitaireModel.
 */
public class TriangleSolitaireModelTest {

  private TriangleSolitaireModel model1;
  private TriangleSolitaireModel model2;
  private TriangleSolitaireModel model3;
  private TriangleSolitaireModel model4;


  @Before
  public void initData() {
    model1 = new TriangleSolitaireModel();
    model2 = new TriangleSolitaireModel(0, 0);
    model3 = new TriangleSolitaireModel(5);
    model4 = new TriangleSolitaireModel(5, 0, 0);
  }

  @Test
  public void testConstructor1() {
    assertEquals(5, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(14, model1.getScore());
  }

  @Test
  public void testConstructor2() {
    assertEquals(5, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(14, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    model2 = new TriangleSolitaireModel(3, -1);
  }

  @Test
  public void testConstructor3() {
    assertEquals(5, model1.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(14, model1.getScore());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor3() {
    model3 = new TriangleSolitaireModel(0);
  }

  @Test
  public void testConstructor4() {
    assertEquals(5, model4.getBoardSize());
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model4.getSlotAt(0, 0));
    assertEquals(14, model4.getScore());
  }

  // tests invalid constructor 3 (invalid empty position)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor4() {
    model4 = new TriangleSolitaireModel(5,
            0, 5);
  }

  // tests invalid constructor 3 (invalid armThickness)
  @Test(expected = IllegalArgumentException.class)
  public void testInvalid2Constructor4() {
    model4 = new TriangleSolitaireModel(-1,
            0, 5);
  }

  // tests getSlotAt
  @Test
  public void testGetSlotAt() {
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, model1.getSlotAt(0, 4));
  }

  // invalid move where middle slot is empty
  @Test(expected = IllegalArgumentException.class)
  public void testMiddleIsEmpty() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    model1.move(2, 2, 0, 0);
  }

  // invalid move where from slot is empty
  @Test(expected = IllegalArgumentException.class)
  public void testFromIsEmpty() {
    model1.move(0, 0, 2, 2);
  }

  // invalid move where to slot is not empty
  @Test(expected = IllegalArgumentException.class)
  public void testToIsMarble() {
    model1.move(2, 2, 4, 4);
  }

  // invalid move horizontally left MORE than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHorizMove() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    model1.move(4, 0, 2, 0);
    model1.move(4, 3, 4, 0);
  }

  // invalid move horizontally left LESS than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHorizMove2() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    model1.move(4, 0, 2, 0);
    model1.move(4, 1, 4, 0);
  }

  /// invalid move horizontally right MORE than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHorizMove3() {
    model1.move(2, 0, 0, 0);
    model1.move(5, 5, 2, 2);
    model1.move(4, 1, 5, 5);
  }

  /// invalid move horizontally right LESS than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidHorizMove4() {
    model1.move(2, 0, 0, 0);
    model1.move(5, 5, 2, 2);
    model1.move(4, 3, 4, 5);
  }

  // invalid move diagonally left (vertical) MORE than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidLeftDiagMove() {
    model1.move(3, 0, 0, 0);
  }

  // invalid move diagonally left (vertical) LESS than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidLeftDiagMove2() {
    model1.move(1, 0, 0, 0);
  }

  // invalid move diagonally right MORE than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRightDiagMove() {
    model1.move(3, 3, 0, 0);
  }

  // invalid move diagonally right LESS than two slots away
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRightDiagMove2() {
    model1.move(3, 1, 0, 0);
  }

  // valid move horizontally two spots to the right
  @Test
  public void testValidHorizRightMove() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 1));
  }

  // valid move horizontally two spots to the left
  @Test
  public void testValidHorizLeftMove() {
    model1.move(2, 0, 0, 0);
    model1.move(2, 2, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 1));
  }

  // valid move right diagonally up
  @Test
  public void testValidDiagRightUp() {
    model1.move(2, 0, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
  }

  // valid move right diagonally down
  @Test
  public void testValidDiagRightDown() {
    model1.move(2, 0, 0, 0);
    model1.move(2, 2, 2, 0);
    model1.move(3, 0, 1, 0);
    model1.move(0, 0, 2, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 0));
  }

  // valid move left diagonally up
  @Test
  public void testValidDiagLeftUp() {
    model1.move(2, 2, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 1));
  }

  // valid move right diagonally down
  @Test
  public void testValidDiagLeftDown() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    model1.move(3, 3, 1, 1);
    model1.move(0, 0, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, model1.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, model1.getSlotAt(1, 1));
  }

  // tests boardSize
  @Test
  public void testGetBoardSize() {
    assertEquals(5, model1.getBoardSize());
  }

  // tests getScore
  @Test
  public void testGetScore() {
    assertEquals(14, model1.getScore());
  }

  // test when game is not over
  @Test
  public void testGameIsNotOver() {
    assertEquals(false, model1.isGameOver());
  }

  // test when game is over
  @Test
  public void testGameIsOver() {
    model1.move(2, 2, 0, 0);
    model1.move(2, 0, 2, 2);
    model1.move(3, 3, 1, 1);
    model1.move(0, 0, 2, 2);
    model1.move(4, 2, 2, 0);
    model1.move(2, 0, 0, 0);
    model1.move(4, 0, 2, 0);
    model1.move(4, 4, 4, 2);
    model1.move(4, 2, 4, 0);
    model1.move(2, 2, 4, 2);
    assertEquals(true, model1.isGameOver());
  }
}
