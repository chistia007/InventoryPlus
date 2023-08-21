package chistia007.github.io.controller;

public class Item {
    private int plot_id;
    private String productName;
    private int pricePerKg;
    private String location;
    private String imageUrl;
    private int totalQuantity;
    private int quantitySold;
    private int quantityLeft;
    private String movedToWareHouse;
    private String productGrade;
    private String ploughingTime;
    private String reapingTime;
    private int wareHouseID;


    // Constructors, getters, and setters

    public Item() {
        // Default constructor
    }

    public Item(int plot_id, String productName,  int pricePerKg,String location,String imageUrl, int totalQuantity, int quantitySold,int quantityLeft, String movedToWareHouse,String productGrade,String ploughingTime,String reapingTime,int wareHouseID) {
        this.plot_id = plot_id;
        this.productName = productName;
        this.location = location;
        this.imageUrl = imageUrl;
        this.totalQuantity = totalQuantity;
        this.quantitySold = quantitySold;
        this.quantityLeft = quantityLeft;
        this.movedToWareHouse = movedToWareHouse;
        this.productGrade = productGrade;
        this.ploughingTime = ploughingTime;
        this.reapingTime = reapingTime;
        this.wareHouseID = wareHouseID;
    }

    public int getPlot_id() {
        return plot_id;
    }

    public void setPlot_id(int plot_id) {
        this.plot_id = plot_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public void setPricePerKg(int pricePerKg) {
        this.pricePerKg = pricePerKg;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

    public int getQuantityLeft() {
        return quantityLeft;
    }

    public void setQuantityLeft(int quantityLeft) {
        this.quantityLeft = quantityLeft;
    }

    public String getMovedToWareHouse() {
        return movedToWareHouse;
    }

    public void setMovedToWareHouse(String movedToWareHouse) {
        this.movedToWareHouse = movedToWareHouse;
    }

    public String getProductGrade() {
        return productGrade;
    }

    public void setProductGrade(String productGrade) {
        this.productGrade = productGrade;
    }

    public String getPloughingTime() {
        return ploughingTime;
    }

    public void setPloughingTime(String ploughingTime) {
        this.ploughingTime = ploughingTime;
    }

    public String getReapingTime() {
        return reapingTime;
    }

    public void setReapingTime(String reapingTime) {
        this.reapingTime = reapingTime;
    }

    public int getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(int wareHouseID) {
        this.wareHouseID = wareHouseID;
    }
}
