package BackEnd;

import java.util.ArrayList;

/**
 * Defines all attributes and functionality for SupplierLists
 */
public class SupplierList {
    /**
     * A list of Supplier objects
     */
    ArrayList<Supplier> suppliers;

    /**
     * Constructs a SupplierList object
     * @param suppliers A list of Supplier objects
     */
    public SupplierList(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    /**
     * Retrieves SupplierList's list of Suppliers
     * @return A list of Supplier objects
     */
    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    /**
     * Sets the 'suppliers' attribute to the parameter
     * @param suppliers A list of Supplier objects
     */
    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
