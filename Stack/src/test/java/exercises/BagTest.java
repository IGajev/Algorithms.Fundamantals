package exercises;

import org.junit.Assert;
import org.junit.Test;

public class BagTest {

  @Test
  public void testMaxLinkedList() {
    Bag bag = new Bag();
    bag.add(1);
    bag.add(10);
    bag.add(2);
    bag.add(3);
    bag.add(0);

    int computed = bag.max(bag.getFirst());

    Assert.assertEquals(10, computed);
  }

  @Test
  public void maxRecursive_EmptyLinkedList_returns0() {
    Bag bag = new Bag();

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(0, computed);
  }

  @Test
  public void maxRecursive_LinkedListWithOneElement_returnsItsKey() {
    Bag bag = new Bag();
    bag.add(1);

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(1, computed);
  }

  @Test
  public void maxRecursive_LinkedListWithTwoElements_returnsTheLargerElementOfTheTwo() {
    Bag bag = new Bag();
    bag.add(2);
    bag.add(1);

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(2, computed);
  }

  @Test
  public void maxRecursive_LinkedListIsRandomlyPopularized_ReturnsTheLargestElement() {
    Bag bag = new Bag();
    bag.add(1);
    bag.add(10);
    bag.add(5);
    bag.add(7);
    bag.add(9);
    bag.add(8);
    bag.add(2);
    bag.add(3);
    bag.add(0);

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(10, computed);
  }

  @Test
  public void maxRecursive_LinkedListIsRandomlyPopularizedPartTwo_ReturnsTheLargestElement() {
    Bag bag = new Bag();
    bag.add(1);
    bag.add(5);
    bag.add(7);
    bag.add(9);
    bag.add(8);
    bag.add(2);
    bag.add(3);
    bag.add(10);
    bag.add(0);

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(10, computed);
  }

  @Test
  public void maxRecursive_LinkedListIsRandomlyPopularizedPartThree_ReturnsTheLargestElement() {
    Bag bag = new Bag();
    bag.add(1);
    bag.add(5);
    bag.add(7);
    bag.add(9);
    bag.add(8);
    bag.add(2);
    bag.add(3);
    bag.add(0);
    bag.add(10);

    int computed = bag.maxRecursive(bag.getFirst());

    Assert.assertEquals(10, computed);
  }
}

