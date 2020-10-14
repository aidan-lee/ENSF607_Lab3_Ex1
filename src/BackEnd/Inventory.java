package BackEnd;

import java.util.ArrayList;

/**
 * Contains a list of Items and an Order.
 * Defines methods to operate on these attributes.
 */
public class Inventory {
    /**
     * A list of Item objects
     */
    private ArrayList<Item> items;

    /**
     * An Order object
     */
    private Order order;

    /**
     * A constructor for Inventory objects
     * @param items A list of Item objects
     * @param order An Order object
     */
    public Inventory(ArrayList<Item> items, Order order) {
        this.items = items;
        this.order = order;
    }

    /**
     * Searches the list of Items for an Item object with a name matching the parameter
     * @param name A String, the name of the Item to find
     * @return A list of matching Item objects
     * @throws Exception Thrown when passed an empty or null String
     */
    public ArrayList<Item> searchItemsByName(String name) throws Exception {
        if (name != null && !name.isEmpty()) {
            ArrayList<Item> result = new ArrayList<>();

            for (Item item : items) {
                String itemName = item.getName().toLowerCase();
                if (itemName.equals(name.toLowerCase()) || itemName.contains(name.toLowerCase()) ){
                    result.add(item);
                }
            }
            return result;
        }
        else {
            throw new Exception("Invalid search parameter.");
        }
    }

    /**
     * Searches the list of Items for an Item with an ID matching the parameter
     * @param id An int, the ID of the Item to find
     * @return An Item object with a matching ID
     * @throws Exception Thrown when passed a negative ID parameter
     */
    public Item searchItemsById(int id) throws Exception {
        if (id >= 0) {
            for (Item item : items) {
                if (item.getId() == id) {
                    return item;
                }
            }
            return null;
        }
        else {
            throw new Exception("Invalid search parameter.");
        }
    }

    /**
     * Retrieves the list of Item objects
     * @return A list of Item objects
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Sets the 'items' attribute to the specified parameter
     * @param items A list of Item objects
     */
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    /**
     * Retrieves the Order object
     * @return An Order object
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Sets the 'order; attribute to the specified parameter
     * @param order A list of Order objects
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
