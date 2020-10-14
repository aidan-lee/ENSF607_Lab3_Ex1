package BackEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * A class that reads the items.txt and suppliers.txt files and creates the appropriate objects.
 * Meant to simulate a database.
 */
public class FileManager {

    /**
     * A Singleton instance of the FileManager class
     */
    private static FileManager instance;

    /**
     * A list of Supplier objects
     */
    private ArrayList<Supplier> suppliers;

    /**
     * A list of Item objects
     */
    private ArrayList<Item> items;

    /**
     * FileManager constructor.
     */
    private FileManager() {
        suppliers = new ArrayList<>();
        items = new ArrayList<>();
    }

    /**
     * Retrieves or creates the single instance of the FileManager class
     * @return FileManager object
     */
    public static FileManager getFileManager() {
        if (instance == null) {
            instance = new FileManager();
        }

        return instance;
    }

    /**
     * Reads text files, creates objects from the files, and creates an Inventory object
     * @return
     */
    public Inventory generateInventory() {

        readSupplierFile();
        readItemsFile();
        linkItemsAndSuppliers();

        Order order = new Order(new Date(), new ArrayList<OrderLine>());
        Inventory inventory = new Inventory(items, order);

        return inventory;
    }

    /**
     * Creates the two-way association between Supplier and Item objects
     */
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

    /**
     * Reads suppliers.txt and creates a Supplier object from each line
     */
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

    /**
     * Reads items.txt and creates a Supplier object from each line
     */
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

    /**
     * Creates a SupplierList object from the list of Supplier objects
     * @return A SupplierList object
     */
    public SupplierList getSupplierList() {
        return new SupplierList(suppliers);
    }

    /**
     * Retrieves the list of Supplier objects
     * @return A list of Supplier objects
     */
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the 'supplier' class attribute to the specified parameter
     * @param suppliers A list of Supplier objects
     */
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    /**
     * Retrieves the list of Item objects
     * @return A list of Item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Sets the 'items' class attribute to the specified parameter
     * @param items A list of Item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

}
