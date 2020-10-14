package BackEnd;

import java.util.ArrayList;

/**
 * Defines all attributes and functionality for Suppliers
 */
public class Supplier {
    /**
     * The ID of the Supplier
     */
    private int id;

    /**
     * The Supplier's company name
     */
    private String companyName;

    /**
     * The Supplier's address
     */
    private String address;

    /**
     * The Supplier's sales contact
     */
    private String salesContact;

    /**
     * A list of Items that the Supplier produces
     */
    private ArrayList<Item> items;

    /**
     * Constructs Supplier objects
     * @param id An int
     * @param company A String
     * @param address A String
     * @param sales A String
     */
    public Supplier(int id, String company, String address, String sales) {
        this.id = id;
        this.companyName = company;
        this.address = address;
        this.salesContact = sales;
        items = new ArrayList<>();
    }

    /**
     * Retrieves the Supplier's ID
     * @return An int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the 'id' attribute to the parameter
     * @param id An int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the Supplier's company name
     * @return A string
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the 'companyName' attribute to the parameter
     * @param companyName A String
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * Retrieves the Supplier's sales contact
     * @return A String
     */
    public String getSalesContact() {
        return salesContact;
    }

    /**
     * Sets the 'salesContact' attribute to the parameter
     * @param salesContact A String
     */
    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

    /**
     * Retrieves the Supplier's address
     * @return A String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the 'address' attribute to the parameter
     * @param address A String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retrieves the Supplier's list of Items
     * @return A list of Item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Sets the 'items' attribute to the parameter
     * @param items A list of item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
