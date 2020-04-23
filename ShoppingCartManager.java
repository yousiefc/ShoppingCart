/*
Author: C Yousief
*/
import java.util.Scanner;

public class ShoppingCartManager {

  public static void main(String args[]) {
    Scanner scnr = new Scanner(System.in);
    String name;
    String date;

    System.out.println("Enter Customer's Name:");
    name = scnr.nextLine();
    System.out.println("Enter Today's Date:");
    date = scnr.nextLine();
    System.out.println();

    ShoppingCart cart = new ShoppingCart(name, date);
    System.out.println("Customer Name: " + cart.getCustomerName());
    System.out.println("Today's Date: " + cart.getDate());
    System.out.println();

    printMenu(cart, scnr);
  }

  public static void printMenu(ShoppingCart cart, Scanner scnr) {
    final String QUIT = "q";
    String input = "";
    boolean validOption;

    do{
      validOption = false;
      System.out.println("MENU");
      System.out.println("a - Add item to cart");
      System.out.println("d - Remove item from cart");
      System.out.println("c - Change item quantity");
      System.out.println("i - Output items' descriptions");
      System.out.println("o - Output shopping cart");
      System.out.println("q - Quit");
      System.out.println();
      //System.out.println("Choose an option:");

      //input = scnr.nextLine();

      do{
        System.out.println("Choose an option:");
        input = scnr.nextLine();
        switch(input) {
          case "a":
            addItemToCart(cart, scnr);
            validOption = true;
            break;
          case "d":
            removeItemFromCart(cart,scnr);
            validOption = true;
            break;
          case "c":
            changeItemQuantity(cart,scnr);
            validOption = true;
            break;
          case "i":
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            cart.printDescriptions();
            validOption = true;
            break;
          case "o":
            System.out.println("OUTPUT SHOPPING CART");
            cart.printTotal();
            validOption = true;
            break;
          case QUIT:
            validOption = true;
            break;
          default:
            validOption = false;
            break;
          }
        }while(!validOption);
      
    }while(!input.equals(QUIT));
  }

  public static void addItemToCart(ShoppingCart cart, Scanner scnr) {
    System.out.println("ADD ITEM TO CART");
    System.out.println("Enter the item name:");
    String name = scnr.nextLine();
    System.out.println("Enter the item description:");
    String desc = scnr.nextLine();
    System.out.println("Enter the item price:");
    int price = scnr.nextInt();
    System.out.println("Enter the item quantity:");
    int quantity = scnr.nextInt();
    scnr.nextLine();
    System.out.println();

    ItemToPurchase item = new ItemToPurchase(name,desc,price,quantity);
    cart.addItem(item);
  }

  public static void removeItemFromCart(ShoppingCart cart, Scanner scnr) {
    System.out.println("REMOVE ITEM FROM CART");
    System.out.println("Enter name of item to remove:");
    String name = scnr.nextLine();
    cart.removeItem(name);
  }

  public static void changeItemQuantity(ShoppingCart cart, Scanner scnr) {
    System.out.println("CHANGE ITEM QUANTITY");
    System.out.println("Enter the item name:");
    String name = scnr.nextLine();
    System.out.println("Enter the new quantity:");
    int quantity = scnr.nextInt();
    scnr.nextLine();

    ItemToPurchase item = new ItemToPurchase();
    item.setName(name);
    item.setQuantity(quantity);

    cart.modifyItem(item);
  }

}
