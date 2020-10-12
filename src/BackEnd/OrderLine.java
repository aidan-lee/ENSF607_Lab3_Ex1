package BackEnd;


public class OrderLine {
    private Item item;
    private int requiredQuantity;

    public OrderLine(Item item, int requiredQuantity) {

        this.item = item;
        this.requiredQuantity = requiredQuantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return ("Item description:\t" + item.getName() + "\nAmount ordered:\t" + requiredQuantity + "\nSupplier:\t" + item.getSupplier().getCompanyName());
    }
}
