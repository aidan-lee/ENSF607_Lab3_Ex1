package BackEnd;

/**
 * Defines all attributes and functionality for Items
 */
public class Item {
    /**
     * The ID of the Item
     */
    private int id;

    /**
     * The name of the Item
     */
    private String name;

    /**
     * The quantity of Items in the inventory
     */
    private int quantity;

    /**
     * The price of the Item
     */
    private double price;

    /**
     * The ID of the Supplier object
     * (Used only when reading Items from the text file)
     */
    private int supplierId;

    /**
     * The Supplier object
     */
    private Supplier supplier;

    /**
     * Constructs an Item object
     * @param id An int
     * @param name A String
     * @param quantity An int
     * @param price A double
     * @param supplierId An int
     */
    public Item(int id, String name, int quantity, double price, int supplierId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
    }

    /**
     * Creates a String containing Item data
     * @return A String
     */
    @Override
    public String toString() {
        return ("- " + this.name + "\n\tQuantity: " + this.quantity + ", Price: " + this.price + ", From supplier " + this.supplier.getCompanyName());
    }

    /**
     * Retrieves the ID of the Item
     * @return An int, the ID of the Item
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the 'id' attribute to the specified parameter
     * @param id An int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the Item
     * @return A String, the name of the Item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the 'name' attribute to the specified parameter
     * @param name A String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the quantity of the Item
     * @return An int, quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the 'quantity' attribute to the specified parameter
     * @param quantity An int
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the price of the Item
     * @return A double, the Item's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the 'price' attribute to the specified parameter
     * @param price A double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the supplier of the Item
     * @return A Supplier object
     */
    public Supplier getSupplier() {
        return supplier;
    }

    /**
     * Sets the 'supplier' attribute of the Item
     * @param supplier A Supplier object
     */
    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    /**
     * Retrieves the supplierId of the Item
     * @return An int
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * Sets the 'supplierID' attribute of the Item
     * @param supplierId An int
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
}
