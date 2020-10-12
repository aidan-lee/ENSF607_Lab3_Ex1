package BackEnd;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Item> items;
    private SupplierList supplierList;

    public Shop() {

        FileManager fileManager = FileManager.getFileManager();
        fileManager.generateInventory();

        this.items = fileManager.getItems();
        this.supplierList = fileManager.getSupplierList();
    }

    public void listItems() {
        System.out.println("Listing all items:");
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public SupplierList getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(SupplierList supplierList) {
        this.supplierList = supplierList;
    }
}
