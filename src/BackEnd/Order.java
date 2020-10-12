package BackEnd;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class Order {

    private String id;
    private Date date;
    private ArrayList<OrderLine> orderLines;

    public Order(Date date, ArrayList<OrderLine> orderLines) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.orderLines = orderLines;
    }

    public void generateOrderLine(Item item, int requiredQuantity) {
        OrderLine ol = new OrderLine(item, requiredQuantity);
        orderLines.add(ol);
    }

    @Override
    public String toString() {
        String orderString = "";
        orderString += "***********************************\n";
        orderString += ("ORDER ID:\t" + id + "\n");
        orderString += ("Date Ordered:\t" + date.toString() + "\n\n");

        for (OrderLine ol : orderLines) {
            orderString += (ol.toString() + "\n\n");

        }

        orderString += "***********************************";

        return orderString;

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
