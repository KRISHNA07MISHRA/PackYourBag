package com.example.packyourbag.Data;

import android.app.Application;
import android.content.Context;

import com.example.packyourbag.Database.RoomDB;
import com.example.packyourbag.constant.MyConstant;
import com.example.packyourbag.models.Items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppData extends Application {

    RoomDB database;
    String category;

    Context context;

    public static final String LAST_VERSION = "LAST_VERSION";
    public static final int NEW_VERSION = 3;

    public AppData(RoomDB database) {
        this.database = database;
    }

    public AppData(RoomDB database, Context context) {
        this.database = database;

        this.context = context;
    }
    public List<Items> getBasicData(){
        category = "Basic Needs";
        List<Items> basicItem = new ArrayList<>();
        basicItem.add(new Items("Visa",category,false));
        basicItem.add(new Items("passport",category,false));
        basicItem.add(new Items("wallet",category,false));
        basicItem.add(new Items("driving license",category,false));
        basicItem.add(new Items("house key",category,false));
        basicItem.add(new Items("book",category,false));
        basicItem.add(new Items("travel pillow",category,false));
        basicItem.add(new Items("umbrella",category,false));
        basicItem.add(new Items("note book",category,false));
        return basicItem;

    }

    public List<Items> getPersonalCareData(){
        String[] data = {"Tooth-brush","towel","shoes","MOUTHWASH","SHAVING CREAM","RAZOR"
        ,"SOAP","FIBER","SHAMPOO","HAIR CONDITIONER","BRUSH","COMB","HAIR DRYER",
        "MAKEUP REMOVER","PAD","EAR STICK","COTTON","NAIL FILES"};
        return prepareItemsList(MyConstant.PERSONAL_CARE_CAMEL_CASE,data);
    }
    public List<Items> getNeedsData(){
        String[] data = {"backpack","DAILY BAGS","LAUNDRY BAG","SEWING KIT","TRAVEL LOCK" ,
                "LUGGAGE TAG","MAGAZINE","SPORTS EQUIPMENT"};
        return prepareItemsList(MyConstant.BASIC_NEEDS_CAMEL_CASE,data);
    }
    public List<Items> getCarSuppliesData(){
        String[] data = {"PUMP","CAR","JACK","SPARE CAR KEY", "ACCIDENT RECORD SET",
        "AUTO REFRIGERATOR","CAR COVER","IMPORTANT PAPER"};
        return prepareItemsList(MyConstant.CAR_SUPPLIES_CAMEL_CASE,data);
    }
    public List<Items> getBeachSuppliesData(){
        String[] data = {"SEA GLASS","SEA BED","SUNTAN CREAM","BEACH UMBRALLA",
        "SWIM FINS","BEACH BAG","BEACH TOWEL","BEACH SLOPPERS","SUNBED","SNORKEL","WATERPROOF CLOCK"};
        return prepareItemsList(MyConstant.BEACH_SUPPLIES_CAMEL_CASE,data);
    }
    public List<Items> getClothingData(){
        String[] data = {"stockings", "UNDERWEAR", "PAJAMAS",
                "T-SHIRTS", "pants", "dresses", "skirts", "sweaters",
                "hoodies", "jackets", "coats", "blouses", "shirts", "shorts",
                "jeans", "socks", "leggings", "cardigans", "vests", "tank tops",
                "scarves", "gloves", "hats", "belts", "ties", "suits", "blazers",
                "overalls", "rompers", "jumpsuits", "swimwear", "activewear", "lingerie",
                "nightwear", "hosiery", "raincoats", "sleepwear", "workwear", "formalwear",
                "casualwear", "sportswear"};

        return prepareItemsList(MyConstant.CLOTHING_CAMEL_CASE,data);
    }
    public List<Items> getBabyNeedsData(){
        String[] data = {"SNAPSUIT", "OUTFIT", "JUMPSUIT", "diapers",
                "bottles", "pacifiers", "baby wipes", "baby lotion",
                "baby shampoo", "baby powder", "baby food", "baby bibs",
                "baby blankets", "baby toys", "baby monitor", "baby carrier",
                "baby stroller", "baby bathtub", "baby thermometer",
                "baby nail clippers", "baby hairbrush", "baby comb",
                "baby mittens", "baby socks", "baby shoes", "baby hats",
                "baby sunscreen", "baby teether"};
        return prepareItemsList(MyConstant.BABY_NEEDS_CAMEL_CASE, data);
    }
    public List<Items> getFoodData(){
        String[] data = {"bread", "milk", "eggs", "cheese", "yogurt",
                "butter", "fruit", "vegetables", "meat", "fish", "poultry",
                "rice", "pasta", "cereal", "snacks", "cookies", "chips",
                "nuts", "chocolate", "candy", "ice cream", "cake", "pie",
                "pizza", "sandwiches", "salad", "soup", "stew", "sushi",
                "curry", "tacos", "burritos", "noodles", "smoothies",
                "juice", "coffee", "tea", "water", "soda", "energy drinks",
                "alcohol"};
        return prepareItemsList(MyConstant.FOOD_CAMEL_CASE, data);
    }
    public List<Items> getTechnologyData(){
        String[] data = {"Mobile phone", "phone cover", "laptop", "tablet", "smartwatch",
                "headphones", "earphones", "speaker", "camera", "smart TV",
                "gaming console", "router", "modem", "external hard drive",
                "USB flash drive", "keyboard", "mouse", "printer", "scanner",
                "monitor", "VR headset", "fitness tracker", "action camera",
                "drone", "smart home devices", "power bank", "charging cable",
                "memory card", "software", "video game", "digital assistant",
                "microphone", "webcam", "projector"};
        return prepareItemsList(MyConstant.TECHNOLOGY_CAMEL_CASE, data);
    }
    public List<Items> getHealthData(){
        String[] data = {"ASPIRIN","DRUNGS USED","VITAMINS USED","LENS SOLUTIONS","HOT WATER BAG","TINCTURE OF LODINE"
        ,"FIRST AID KIT","REPLACEMENT LENS","PAIN RELIEVER","FEVER REDUCER","DIARRHEA STOPPER","PAIN RELIEVE SPRAY"};
        return prepareItemsList(MyConstant.HEALTH_CAMEL_CASE, data);
    }


    public List<Items> prepareItemsList(String category, String[]data){
        List<String> list = Arrays.asList(data);
        List<Items>dataList = new ArrayList<>();
        dataList.clear();

        for(int i = 0; i<list.size(); i++){
            dataList.add(new Items(list.get(i),category,false));
        }
        return dataList;
    }

    public List<List<Items>> getAllData(){
        List<List<Items>> listOFAllItems = new ArrayList<>();

        listOFAllItems.clear();

        listOFAllItems.add(getBasicData());
        listOFAllItems.add(getClothingData());
        listOFAllItems.add(getPersonalCareData());
        listOFAllItems.add(getBabyNeedsData());
        listOFAllItems.add(getHealthData());
        listOFAllItems.add(getTechnologyData());
        listOFAllItems.add(getFoodData());
        listOFAllItems.add(getBeachSuppliesData());
        listOFAllItems.add(getCarSuppliesData());
        listOFAllItems.add(getNeedsData());
        return listOFAllItems;


    }
    public void persistAllData(){
        List<List<Items>> listOfAllItems = getAllData();

        for(List<Items> list : listOfAllItems){
            for(Items items:list){
                database.mainDao().saveItem(items);
            }
        }
        System.out.println("Data Added");
    }

}
