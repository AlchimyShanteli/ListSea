package com.example.alchimy.listsea.models;

public class SeaModel {
    private int order;
    private String nameCountry;
    private String nameCity;
    private String nameHotel;
    private String imageUrl;
    private int price;



    public SeaModel(String nameCity, String nameHotel, String imageUrl, int price, int order, String nameCountry) {
        this.nameCity = nameCity;
        this.nameHotel = nameHotel;
        this.imageUrl = imageUrl;
        this.price = price;
        this.order = order;
        this.nameCountry = nameCountry;
    }

    public String getNameCity() {
        return nameCity;
    }

    public String getNameHotel() {
        return nameHotel;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getPrice() {
        return price;
    }
    public int getOrder() {
        return order;
    }

    public String getNameCountry() {
        return nameCountry;
    }
}
