package dev.henryfebryan.androiddrinkshopserver.Utils;

import java.util.ArrayList;
import java.util.List;

import dev.henryfebryan.androiddrinkshopserver.Model.Category;
import dev.henryfebryan.androiddrinkshopserver.Model.Drink;
import dev.henryfebryan.androiddrinkshopserver.Retrofit.IDrinkShopAPI;
import dev.henryfebryan.androiddrinkshopserver.Retrofit.RetrofitClient;

public class Common {

    public static Category currentCategory;
    public static Drink currentDrink;

    public static List<Category> menuList = new ArrayList<>();

    public static final String BASE_URL = "http://10.0.2.2/drinkshop/";
    public static IDrinkShopAPI getAPI(){
        return RetrofitClient.getClient(BASE_URL).create(IDrinkShopAPI.class);
    }
    public static String convertCodeToStatus(int orderStatus) {
        switch (orderStatus){
            case 0:
                return "Placed";
            case 1:
                return "Processing";
            case 2:
                return "Shipping";
            case 3:
                return "Shipped";
            case -1:
                return "Cancelled";
            default:
                return "Order Error";
        }
    }
}
