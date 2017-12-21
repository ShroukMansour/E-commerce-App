package models;

import java.util.ArrayList;

public class PremiumStoreowner extends StoreOwner {

    public PremiumStoreowner(String name, String email, String password, Integer id, Integer type) {
        super(name, email, password, id);
    }
    
    public PremiumStoreowner() {
        type =1;
    }

//    public PremiumStoreowner(Integer type) {
//        super(type);
//    }

}
