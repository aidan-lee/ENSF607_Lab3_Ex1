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

    public void decreaseItemQuantity(String input) {
        Item target = null;
        try {
            int id = Integer.parseInt(input);
            Item item = inventory.searchItemsById(id);
            if (item != null) {
                decreaseQuantity(item);
            }
            else {
                System.out.println("Item not found");
            }
        }
        catch (NumberFormatException e){
            try {
                ArrayList<Item> items = inventory.searchItemsByName(input);
                if (!items.isEmpty()) {
                    Item item = items.get(0);
                    decreaseQuantity(item);
                }
                else {
                    System.out.println("Item not found.");
                }
            }
            catch (Exception ex){
                System.out.println("Invalid input. Please try again.");

            }

        }
        catch (Exception ex) {
            System.out.println("Invalid input. Please try again.");

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

    public void getItemQuantity(String input) {
        try {
            getQuantityById(input);
        }
        // If Integer.parseInt throws an exception, the input was not an ID
        catch (NumberFormatException e) {
            try {
                getQuantityByName(input);
            }
            catch(Exception ex) {
                System.out.println("Invalid input. Please try again.");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please try again.");
        }

    }

    private void getQuantityByName(String input) throws Exception {
        ArrayList<Item> items = inventory.searchItemsByName(input);
        if (!items.isEmpty()) {
            Item item = items.get(0);
            displayQuantity(item);
        }
        else {
            System.out.println("No tool with name matching " + input + " found. Please try again.");
        }
    }

    private void getQuantityById(String input) throws Exception {
        int id = Integer.parseInt(input);
        Item item = inventory.searchItemsById(id);
        if (item != null) {
            displayQuantity(item);
        }
        else {
            System.out.println("No tool with ID " + id + " found. Please try again.");
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
            result.add(item);
            showSearchResults(result);

        }
        catch (Exception e) {
            System.out.println("Invalid search parameters. Please try again.");
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
