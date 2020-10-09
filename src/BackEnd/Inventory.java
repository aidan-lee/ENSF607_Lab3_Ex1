package BackEnd;

import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items;
    private Order order;

    public Inventory(ArrayList<Item> items, Order order) {
        this.items = items;
        this.order = order;
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
