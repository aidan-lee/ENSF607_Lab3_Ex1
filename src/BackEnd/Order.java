package BackEnd;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Defines all attributes and functionality for Orders
 */
public class Order {

    /**
     * The ID of the Order
     */
    private String id;

    /**
     * The date the Order was created
     */
    private Date date;

    /**
     * A list of OrderLine objects
     */
    private ArrayList<OrderLine> orderLines;

    /**
     * Constructs an Order object
     * @param date
     * @param orderLines
     */
    public Order(Date date, ArrayList<OrderLine> orderLines) {
        this.id = UUID.randomUUID().toString();
        this.date = date;
        this.orderLines = orderLines;
    }

    /**
     * Generates an OrderLine object for the specified Item, with the specified quantity
     * @param item An Item object, the Item required
     * @param requiredQuantity An int, the quantity of the Item required
     */
    public void generateOrderLine(Item item, int requiredQuantity) {
        OrderLine ol = new OrderLine(item, requiredQuantity);
        orderLines.add(ol);
    }

    /**
     * Generates a String containing the Order information
     * @return
     */
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

    /**
     * Retrieves the ID of the Order
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the 'id' attribute to the specified parameters
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the date of the Order
     * @return A Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the 'date' attribute of the Order
     * @param date A Date object
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Retrieves the OrderLines of the Order
     * @return A list of OrderLines
     */
    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }

    /**
     * Sets the 'orderLines' attribute of the Order
     * @param orderLines A list of OrderLines
     */
    public void setOrderLines(ArrayList<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }
}
