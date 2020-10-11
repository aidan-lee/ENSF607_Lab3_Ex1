package BackEnd;

import java.util.ArrayList;
import java.util.UUID;

public class Supplier {
    private int id;
    private String companyName;
    private String address;
    private String salesContact;
    private ArrayList<Item> items;

    public Supplier(int id, String company, String address, String sales) {
        this.id = id;
        this.companyName = company;
        this.address = address;
        this.salesContact = sales;
        items = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getSalesContact() {
        return salesContact;
    }

    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
