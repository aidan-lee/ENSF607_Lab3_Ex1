package FrontEnd;

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


        shop.searchItemsById(8015);
        shop.searchItemsById(1000);
        shop.searchItemsById(-1);
    }
}
