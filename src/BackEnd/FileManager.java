package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FileManager {

    private static FileManager instance;
    private ArrayList<Supplier> suppliers;
    private ArrayList<Item> items;

    private FileManager() {
        suppliers = new ArrayList<>();
        items = new ArrayList<>();
    }

    public static FileManager getFileManager() {
        if (instance == null) {
            instance = new FileManager();
        }

        return instance;
    }

    public Inventory generateInventory() {

        readSupplierFile();
        readItemsFile();
        linkItemsAndSuppliers();

        Order order = new Order(new Date(), new ArrayList<OrderLine>());
        Inventory inventory = new Inventory(items, order);

        return inventory;
    }

    private void linkItemsAndSuppliers() {
        for (Supplier supplier : suppliers) {
            for (Item item : items) {
                if (item.getSupplierId() == supplier.getId()) {
                    item.setSupplier(supplier);
                    supplier.getItems().add(item);
                }
            }
        }
    }

    private void readSupplierFile() {
        try {
            File supplierFile = new File("src/BackEnd/suppliers.txt");
            Scanner supplierReader = new Scanner(supplierFile);

            while (supplierReader.hasNextLine()) {
                String supplierData = supplierReader.nextLine();
                String[] data = supplierData.split(";");

                if (data.length == 4) {
                    int id = Integer.parseInt(data[0]);
                    String companyName = data[1];
                    String address = data[2];
                    String contact = data[3];

                    suppliers.add(new Supplier(id, companyName, address, contact));
                }
            }
            supplierReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readItemsFile() {
        try {
            File itemFile = new File("src/BackEnd/items.txt");
            Scanner itemReader = new Scanner(itemFile);

            while (itemReader.hasNextLine()) {
                String itemData = itemReader.nextLine();
                String[] data = itemData.split(";");

                if (data.length == 5) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    int quantity = Integer.parseInt(data[2]);
                    double price = Double.parseDouble(data[3]);
                    int supplierId = Integer.parseInt(data[4]);

                    items.add(new Item(id, name, quantity, price, supplierId));
                }
            }
            itemReader.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
