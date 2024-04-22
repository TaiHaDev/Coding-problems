package interview_prep;

import java.util.Map;
import java.util.Set;
// a marketplace including buy and selling item and also a function on
// what to do if a buyer already bought the items but at the end of the day failed to pay
// all the buyers that buy with higher price should receive the lower price.
public class JSRound1 {
    public class Item {
        public Item(String sellerName, String buyerName, String itemName, double price) {}
    }
    public class DataStore {
        public void put(Item item){}
        public Iterable<Item> getAll() {return null;}
    }
    public class MarketPlace {
        DataStore datastore;

        public MarketPlace(DataStore datastore) {
            this.datastore = datastore;
        }
        public void addSellerItem(String sellerName, Map<String, Integer> items) {

        }
        public Map<String, Integer> buyItems(String buyerName, Map<String, Integer> items) {
            return null;
        }
        public Map<String, Integer> excludeBuyer(Set<String> buyerToExclude) {
            return null;
        }
    }
}
