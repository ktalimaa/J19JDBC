package objects;

public class OrderObj {

    //private int saleId;
    private int itemId;
    private int qty_purchased;
    private float totalOnItem;

    // constructor
    public OrderObj(int itemId, int qty_purchased, float totalOnItem) {
        this.itemId = itemId;
        this.qty_purchased = qty_purchased;
        this.totalOnItem = totalOnItem;
    }

    // getters
    public int getItemId() {
        return itemId;
    }

    public int getQty_purchased() {
        return qty_purchased;
    }

    public float getTotalOnItem() {
        return totalOnItem;
    }
}
