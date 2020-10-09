package BackEnd;

import java.util.ArrayList;

public class SupplierList {
    ArrayList<Supplier> suppliers;

    public SupplierList(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public ArrayList<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(ArrayList<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
}
