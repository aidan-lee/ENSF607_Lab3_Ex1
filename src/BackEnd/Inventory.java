package BackEnd;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private Order order;

    public Inventory(ArrayList<Item> items, Order order) {
        this.items = items;
        this.order = order;
    }

    public ArrayList<Item> searchItemsByName(String name) throws Exception {
        if (name != null && !name.isEmpty()) {
            ArrayList<Item> result = new ArrayList<>();

            for (Item item : items) {
                String itemName = item.getName();
                if (itemName.equals(name) || name.contains(itemName) ){
                    result.add(item);
                }
            }
            return result;
        }
        else {
            throw new Exception("Invalid search parameter.");
        }
    }

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

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
