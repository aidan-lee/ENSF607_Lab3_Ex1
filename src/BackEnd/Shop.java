package BackEnd;

import java.util.ArrayList;

public class Shop {

    private Inventory inventory;
    private SupplierList supplierList;

    public Shop() {

        FileManager fileManager = FileManager.getFileManager();
        inventory = fileManager.generateInventory();

        this.supplierList = fileManager.getSupplierList();
    }

    public void searchItemsByName(String name) {
        try {
            System.out.println("Searching for tool with name '" + name + "'...");

            ArrayList<Item> result = inventory.searchItemsByName(name);
            if (result.isEmpty()) {
                System.out.println("No results found.");
            }
            else {
                System.out.println("Item(s) found:");
                for (Item item : result) {
                    System.out.println(item.toString());
                }
            }
        }
        catch (Exception e) {
            System.out.println("Invalid search parameters. Please try again.");
        }
    }

    public void searchItemsById(int id) {
        try {
            System.out.println("Searching for tool with id '" + id + "'...");

            ArrayList<Item> result = inventory.searchItemsById(id);
            if (result.isEmpty()) {
                System.out.println("No results found.");
            }
            else {
                System.out.println("Item(s) found:");
                for (Item item : result) {
                    System.out.println(item.toString());
                }
            }
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
