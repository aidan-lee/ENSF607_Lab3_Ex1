package BackEnd;

import java.util.UUID;

public class Supplier {
    private String id;
    private String companyName;
    private String salesContact;
    private Item item;

    public Supplier(String company, String sales, Item item) {
        this.id = UUID.randomUUID().toString();
        this.companyName = company;
        this.salesContact = sales;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
