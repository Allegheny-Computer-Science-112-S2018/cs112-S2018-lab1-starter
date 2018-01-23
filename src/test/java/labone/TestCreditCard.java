package testone;

import static org.junit.Assert.assertEquals;

import labone.CreditCard;
import org.junit.Test;

/**
 * A JUnit test suite for the CreditCard class.
 *
 * @author Gregory M. Kapfhammer
 */

public class TestCreditCard {

  /** All double values in assertions much be very close to each other.
   *  Please see the following web site for more details:
   *  http://junit.org/junit4/javadoc/latest/allclasses-frame.html */
  private static final double DELTA = 1e-15;

  @Test
  public void testConstructCreditCardWithDefaultBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000);
    assertEquals(card.getBalance(), 0.0, DELTA);
  }

  @Test
  public void testConstructCreditCardWithSpecifiedBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000, 200.0);
    assertEquals(card.getBalance(), 200.0, DELTA);
  }

  @Test
  public void testChargeWhenLimitSurpassedDefaultBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000);
    assertEquals(card.getBalance(), 0.0, DELTA);
    card.charge(6000);
    assertEquals(card.getBalance(), 0.0, DELTA);
  }

  @Test
  public void testChargeWhenLimitNotSurpassedDefaultBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000);
    assertEquals(card.getBalance(), 0.0, DELTA);
    card.charge(1000);
    assertEquals(card.getBalance(), 1000.0, DELTA);
  }

  @Test
  public void testChargeWhenLimitSurpassedSetBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000, 1000.0);
    assertEquals(card.getBalance(), 1000.0, DELTA);
    card.charge(4050);
    assertEquals(card.getBalance(), 1000.0, DELTA);
  }

  @Test
  public void testChargeWhenLimitNotSurpassedSetBalance() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000, 1000.0);
    assertEquals(card.getBalance(), 1000.0, DELTA);
    card.charge(1000);
    assertEquals(card.getBalance(), 2000.0, DELTA);
  }

  @Test
  public void testPaymentDecreasesAmount() {
    CreditCard card =
        new CreditCard("John Bowman",
          "California Savings",
          "5391 0375 9387 5309",
          5000, 1000.0);
    assertEquals(card.getBalance(), 1000.0, DELTA);
    card.charge(1000);
    assertEquals(card.getBalance(), 2000.0, DELTA);
    card.makePayment(1000.0);
    assertEquals(card.getBalance(), 1000.0, DELTA);
  }

}
