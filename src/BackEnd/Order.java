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
