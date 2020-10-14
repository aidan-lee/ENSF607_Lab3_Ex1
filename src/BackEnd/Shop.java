package BackEnd;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Defines all atrributes and functionality of Shops
 */
public class Shop {

    /**
     * The Inventory of a Shop
     */
    private Inventory inventory;

    /**
     * A list of Supplier objects
     */
    private SupplierList supplierList;

    /**
     * A Scanner object, used for reading user input
     */
    private Scanner scanner;

    /**
     * Constructs Shop objects
     */
    public Shop() {

        FileManager fileManager = FileManager.getFileManager();
        inventory = fileManager.generateInventory();
        this.supplierList = fileManager.getSupplierList();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints the Shop's Inventory's Order object
     */
    public void printOrder() {
        Order order = inventory.getOrder();
        System.out.println(order.toString());
    }

    /**
     * Finds the Item with a name matching the parameter, and decreases its quantity by one
     * @param name A String, the name to match
     */
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

    /**
     * Finds the Item with an ID matching the parameter, and decreases its quantity by one
     * @param id An int, the ID to match
     */
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

    /**
     * Checks for user confirmation before decreasing quantity.  If quantity falls below 40, generates an OrderLine
     * for the Item.
     * @param item
     */
    private void decreaseQuantity(Item item) {
        System.out.println("Found item " + item.getName() + ".");

        boolean validResponse = false;

        while (!validResponse) {
            System.out.println("Decrease quantity of this item by one? Enter y or n.");

            String response = scanner.nextLine();
            if (response.toLowerCase().equals("y")) {
                int oldQuantity = item.getQuantity();
                item.setQuantity(oldQuantity--);
                System.out.println("Item " + item.getName() + " quantity reduced to " + item.getQuantity() + ".");

                if (oldQuantity < 40) {
                    System.out.println("Quantity of " + item.getName() + " is less than 40. Generating an order line...");
                    Order order = inventory.getOrder();
                    order.generateOrderLine(item, (oldQuantity + 40));
                }
                validResponse = true;
            }
            else if (response.toLowerCase().equals("n")){
                System.out.println("No modifications to item " + item.getName() + ".");
                validResponse = true;
            }
            else {
                System.out.println("Invalid response. Please enter y or n.");
            }
        }

    }

    /**
     * Finds the Item with a matching name, and returns the Item's quantity
     * @param input A String
     */
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

    /**
     * Finds the Item with a matching ID, and returns the Item's quantity
     * @param id An int
     */
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

    /**
     * Prints the Item quantity to the console
     * @param item
     */
    private void displayQuantity(Item item) {
        System.out.println("Item " + item.getName() + " has quantity " + item.getQuantity() + ".");
    }

    /**
     * Searches the Inventory's Items list for an Item with a name matching the parameter. Displays the found Item.
     * @param name A String
     */
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

    /**
     * Searches the Inventory's Items list for an Item with an ID matching the parameter. Displays the found item.
     * @param id A String
     */
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

    /**
     * Displays all Items in the Shop's Inventory
     */
    public void listItems() {
        System.out.println("Listing all items:");
        ArrayList<Item> items = inventory.getItems();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    /**
     * Displays the results of a search for an Item
     * @param items A list of Items to display
     */
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

    /**
     * Retrieves the Shop's Inventory object
     * @return
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Sets the 'inventory' attribute to the parameter
     * @param inventory An Inventory object
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Retrives the Shop's list of Suppliers
     * @return A list of Supplier objects
     */
    public SupplierList getSupplierList() {
        return supplierList;
    }

    /**
     * Set the 'supplierList' attribute to the parameter
     * @param supplierList A list of Supplier objects
     */
    public void setSupplierList(SupplierList supplierList) {
        this.supplierList = supplierList;
    }
}
