package FrontEnd;

import BackEnd.Order;
import BackEnd.Shop;

public class Menu {

    public static void main(String [] args) {
        System.out.println("Hello");

        Shop shop = new Shop();

        //shop.listItems();
//
//        shop.searchItemsByName("Thingies");
//        shop.searchItemsByName("");
//        shop.searchItemsByName("bleh");

//
//        shop.searchItemsById(8015);
//        shop.searchItemsById(1000);
//        shop.searchItemsById(-1);

//        shop.getItemQuantity("Widgets");
//        shop.getItemQuantity("1004");
//        shop.getItemQuantity("");
//        shop.getItemQuantity("-10");

        shop.decreaseItemQuantity("");
        shop.decreaseItemQuantity("Widgets");
        shop.decreaseItemQuantity("-1");
        shop.decreaseItemQuantity("1004");

        Order o = shop.getInventory().getOrder();
        System.out.println(o.toString());

    }
}
