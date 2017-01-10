package com.chamoapp.viewpagerwithedgeexample.model;

/**
 * Created by Koo on 2017. 1. 6..
 */

public class BestSellingProduct {
    private String name;
    private String coverImgUrl;
    private String shopUrl;
    private boolean isSoldOut = false;

    public BestSellingProduct(String name, String coverImgUrl, String shopUrl) {
        this.name = name;
        this.coverImgUrl = coverImgUrl;
        this.shopUrl = shopUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getShopUrl() {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl) {
        this.shopUrl = shopUrl;
    }
}
