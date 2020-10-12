package BackEnd;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop {

    private Inventory inventory;
    private SupplierList supplierList;
    private Scanner scanner;

    public Shop() {

        FileManager fileManager = FileManager.getFileManager();
        inventory = fileManager.generateInventory();
        this.supplierList = fileManager.getSupplierList();
        this.scanner = new Scanner(System.in);
    }

    public void printOrder() {
        Order order = inventory.getOrder();
        System.out.println(order.toString());
    }

    public void decreaseQuantityByName(String name) {
        try {
            ArrayList<Item> items = inventory.searchItemsByName(name);
            if (!items.isEmpty()) {
                Item item = items.get(0);
                decreaseQuantity(item);
            }
            else {
                System.out.println("Item not found.");
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());

        }
    }

    public void decreaseQuantityById(int id) {
        try {
            Item item = inventory.searchItemsById(id);
            if (item != null) {
                decreaseQuantity(item);
            }
            else {
                System.out.println("Item not found");
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private void decreaseQuantity(Item item) {
        System.out.println("Found item " + item.getName() + ".");
        System.out.println("Decrease quantity of this item by one? Enter y or n.");

        String response = scanner.nextLine();
        if (response.toLowerCase().equals("y")) {
            int oldQuantity = item.getQuantity();
            item.setQuantity(oldQuantity--);
            System.out.println("Item " + item.getName() + " quantity reduced to " + item.getQuantity() + ".");

            if (oldQuantity < 40) {
                Order order = inventory.getOrder();
                order.generateOrderLine(item, (oldQuantity + 40));
            }
        }
        else {
            System.out.println("No modifications to item " + item.getName() + ".");
        }
    }

    public void getQuantityByName(String input) {
        try {
            ArrayList<Item> items = inventory.searchItemsByName(input);
            if (!items.isEmpty()) {
                Item item = items.get(0);
                displayQuantity(item);
            }
            else {
                System.out.println("No tool with name matching " + input + " found. Please try again.");
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void getQuantityById(int id) {
        try {
            Item item = inventory.searchItemsById(id);
            if (item != null) {
                displayQuantity(item);
            }
            else {
                System.out.println("No tool with ID " + id + " found. Please try again.");
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void displayQuantity(Item item) {
        System.out.println("Item " + item.getName() + " has quantity " + item.getQuantity() + ".");
    }

    public void searchItemsByName(String name) {
        try {
            System.out.println("Searching for tool with name '" + name + "'...");

            ArrayList<Item> result = inventory.searchItemsByName(name);
            showSearchResults(result);
        }
        catch (Exception e) {
            System.out.println("Invalid search parameters. Please try again.");
        }
    }

    public void searchItemsById(int id) {
        try {
            System.out.println("Searching for tool with id '" + id + "'...");

            Item item = inventory.searchItemsById(id);
            ArrayList<Item> result = new ArrayList<>();
            if (item != null) {
                result.add(item);
            }
            showSearchResults(result);

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void listItems() {
        System.out.println("Listing all items:");
        ArrayList<Item> items = inventory.getItems();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    private void showSearchResults(ArrayList<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No results found.");
        }
        else {
            System.out.println(items.size() == 1 ? "Item found:" : "Items found:");
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(SupplierList supplierList) {
        this.supplierList = supplierList;
    }
}
