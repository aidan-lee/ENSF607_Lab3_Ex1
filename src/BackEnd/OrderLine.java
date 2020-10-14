package BackEnd;

/**
 * Defines all attributes and functionality for OrderLines
 */
public class OrderLine {

    /**
     * The Item associated with the OrderLine
     */
    private Item item;

    /**
     * The quantity of the item
     */
    private int requiredQuantity;

    /**
     * Constructs an OrderLine object
     * @param item An Item object
     * @param requiredQuantity An int
     */
    public OrderLine(Item item, int requiredQuantity) {

        this.item = item;
        this.requiredQuantity = requiredQuantity;
    }

    /**
     * Retrieves the Item object of the OrderLine
     * @return An Item object
     */
    public Item getItem() {
        return item;
    }

    /**
     * Sets the 'item' attribute to the specified parameter
     * @param item An Item object
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Generates a String, containing information about the OrderLine
     * @return A String
     */
    @Override
    public String toString() {
        return ("Item description:\t" + item.getName() + "\nAmount ordered:\t\t" + requiredQuantity + "\nSupplier:\t\t\t" + item.getSupplier().getCompanyName());
    }
}
