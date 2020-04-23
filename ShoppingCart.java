/*
Author: C Yousief
*/
import java.util.ArrayList;

public class ShoppingCart {
  
  private String customerName;
  private String currentDate;
  private ArrayList<ItemToPurchase> cartArray = new ArrayList<ItemToPurchase>();
  
  //Default constructor
  public ShoppingCart() {
    this.customerName = "none";
    this.currentDate = "January 1, 2016";
  }

  //Parameterized constructor
  public ShoppingCart(String name, String date) {
    this.customerName = name;
    this.currentDate = date;
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public String getDate() {
    return this.currentDate;
  }


  public void addItem(ItemToPurchase item) {
    cartArray.add(item);
  }


  public void removeItem(String itemName) {
    boolean removed = false;
    int index = 0;

    for(ItemToPurchase item : cartArray) {
      if(item.getName().equals(itemName)) {
        index = cartArray.indexOf(item);
        removed = true;
      }
    }
    if(!removed){
      System.out.println("Item not found in cart. Nothing removed.");
    }else{
      cartArray.remove(index);
    }
    System.out.println();
  }

  public void modifyItem(ItemToPurchase item) {
    String itemName = item.getName();
    boolean found = false;

    for(ItemToPurchase a : cartArray) {
      if(a.getName().equals(itemName)){
        found = true;
        if (!item.getDescription().equals("none")){
          a.setDescription(item.getDescription());
        }
        if (item.getPrice() != 0) {
          a.setPrice(item.getPrice());
        }
        if (item.getQuantity() != 0) {
          a.setQuantity(item.getQuantity());
        }
      }
    }
    if(!found) {
      System.out.println("Item not found in cart. Nothing modified.");
    }
    System.out.println();
  }

  public int getNumItemsInCart() {
    int total = 0;
    for (ItemToPurchase item : cartArray) {
      total += item.getQuantity();
    }
    return total;
  }

  public int getCostOfCart() {
    int total = 0;
    for(ItemToPurchase item : cartArray) {
      total += item.getPrice() * item.getQuantity();
    }
    return total;
  }

  public void printTotal() {

    System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate());
    System.out.println("Number of Items: " + getNumItemsInCart() + "\n");

    if (cartArray.isEmpty()){
      System.out.println("SHOPPING CART IS EMPTY");
      System.out.println();
    }else{
      for(ItemToPurchase item : cartArray) {
        item.printItemCost();
      }
      System.out.println();
    }

      System.out.println("Total: $" + getCostOfCart());
      System.out.println();  
    
  }

  public void printDescriptions() {
    System.out.println(getCustomerName() + "'s Shopping Cart - " + getDate() + "\n");
    System.out.println("Item Descriptions");

    for (ItemToPurchase item : cartArray) {
      item.printItemDesc();
    }
    System.out.println();
  }
  

}
