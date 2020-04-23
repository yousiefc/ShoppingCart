/*
Author: C Yousief
*/
public class ItemToPurchase {

  private String itemName;
  private String itemDesc;
  private int itemPrice;
  private int itemQuantity;

  //Default constructor
  public ItemToPurchase() {
    setName("none");
    setDescription("none");
    setPrice(0);
    setQuantity(0);
  }

  //Parameterized constructor
  public ItemToPurchase(String name, String desc, int price, int quantity) {
    setName(name);
    setDescription(desc);
    setPrice(price);
    setQuantity(quantity);
  }

  //itemName mutator and accessor
  public void setName(String name) {
    this.itemName = name;
  }

  public String getName() {
    return this.itemName;
  }

  //itemPrice mutator and accessor
  public void setPrice(int price) {
    this.itemPrice = price;
  }

  public int getPrice() {
    return this.itemPrice;
  }

  //itemQuantity mutator and accessor
  public void setQuantity(int quantity) {
    this.itemQuantity = quantity;
  }

  public int getQuantity() {
    return this.itemQuantity;
  }

  //itemDesc mutator and accessor
  public void setDescription(String desc) {
    this.itemDesc = desc;
  }

  public String getDescription() {
    return this.itemDesc;
  }


  //Print the name, quantity, price and subtotal of an item
  public void printItemCost() {
    System.out.println(getName() + " " + getQuantity() + " @ $" + getPrice() + " = $" + (getPrice() * getQuantity()));
  }

  //Print the name and description of an item
  public void printItemDesc() {
    System.out.println(getName() + ": " + getDescription());
  }

}
