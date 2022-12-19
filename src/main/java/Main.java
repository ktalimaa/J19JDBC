import controllers.Item;

import static controllers.Item.createNewItem;
import static controllers.Item.getAllItems;

public class Main {
    public static void main(String[] args) {
        // to get all items, we need to call Item class
        Item.getAllItems();
        // Item.createNewItem();
        // Item.getAllItems();
        Item.updateItem();
        Item.getAllItems();

    }
}



