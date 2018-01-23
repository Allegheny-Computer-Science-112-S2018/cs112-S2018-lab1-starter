/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package labone;

/**
 * A simple model for a consumer credit card.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CreditCard {

  private String customer;      // name of the customer (e.g., "John Bowman")
  private String bank;          // name of the bank (e.g., "California Savings")
  private String account;       // account identifier (e.g., "5391 0375 9387 5309")
  private int limit;            // credit limit (measured in dollars)
  protected double balance;     // current balance (measured in dollars)

  /**
   * Constructs a new credit card instance.
   * @param cust        the name of the customer (e.g., "John Bowman")
   * @param bk          the name of the bank (e.g., "California Savings")
   * @param acnt        the account identifier (e.g., "5391 0375 9387 5309")
   * @param lim         the credit limit (measured in dollars)
   * @param initialBal  the initial balance (measured in dollars)
   */
  public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
    customer = cust;
    bank = bk;
    account = acnt;
    limit = lim;
    balance = initialBal;
  }

  /**
   * Constructs a new credit card instance with default balance of zero.
   * @param cust    the name of the customer (e.g., "John Bowman")
   * @param bk      the name of the bank (e.g., "California Savings")
   * @param acnt    the account identifier (e.g., "5391 0375 9387 5309")
   * @param lim     the credit limit (measured in dollars)
   */
  public CreditCard(String cust, String bk, String acnt, int lim) {
    // use a balance of zero as default
    this(cust, bk, acnt, lim, 0.0);
  }

  /** Returns the name of the customer. */
  public String getCustomer() {
    return customer;
  }

  /** Returns the name of the bank. */
  public String getBank() {
    return bank;
  }

  /** Return the account identifier. */
  public String getAccount() {
    return account;
  }

  /** Return the credit limit. */
  public int getLimit() {
    return limit;
  }

  /** Return the current balance. */
  public double getBalance() {
    return balance;
  }

  /**
   * Charges the given price to the card, assuming sufficient credit limit.
   * @param price  the amount to be charged
   * @return true  if charge was accepted; false if charge was denied
   */
  public boolean charge(double price) {
    balance += price;
    return true;
  }

  /**
   * Processes customer payment that reduces balance.
   * @param amount  the amount of payment made
   */
  public void makePayment(double amount) {
  }

  /**
   * Display the information about a CreditCard.
   * @param card the credit card that will be displayed
   */
  public static void printSummary(CreditCard card) {
    System.out.println("Customer = " + card.customer);
    System.out.println("Bank = " + card.bank);
    System.out.println("Account = " + card.account);
    System.out.println("Balance = " + card.balance);
    System.out.println("Limit = " + card.limit);
  }

  /**
   * Create, display, and manipulate credit cards.
   */
  public static void main(String[] args) {
    CreditCard[] wallet = new CreditCard[3];
    wallet[0] = new CreditCard("John Bowman", "California Savings",
                               "5391 0375 9387 5309", 5000);
    wallet[1] = new CreditCard("John Bowman", "California Federal",
                               "3485 0399 3395 1954", 3500);
    wallet[2] = new CreditCard("John Bowman", "California Finance",
                               "5391 0375 9387 5309", 2500, 300);

    for (int val = 1; val <= 16; val++) {
      wallet[0].charge(3 * val);
      wallet[1].charge(2 * val);
      wallet[2].charge(val);
    }
  }
}
