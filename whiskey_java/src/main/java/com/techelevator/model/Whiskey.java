package com.techelevator.model;

import java.math.BigDecimal;

public class Whiskey {
    private int id;
    private String name;
    private String distiller;
    private String type;
    private String region;
    private int volume;
    private int proof;
    private int aged;
    private BigDecimal price;


    public Whiskey(int id, String name, String region, String type, String distiller, int volume, int alcohol_content, int aged, BigDecimal price) {
        this.id = id;
        this.region = region;
        this.name = name;
        this.type = type;
        this.distiller = distiller;
        this.volume = volume;
        this.proof = alcohol_content;
        this.aged = aged;
        this.price = price;
    }

    public Whiskey() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistiller() {
        return distiller;
    }

    public void setDistiller(String distiller) {
        this.distiller = distiller;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getProof() {
        return proof;
    }

    public void setProof(int proof) {
        this.proof = proof;
    }

    public int getAged() {
        return aged;
    }

    public void setAged(int aged) {
        this.aged = aged;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Whiskey{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "region='" + region + '\'' +
                "type='" + type + '\'' +
                ", distiller='" + distiller + '\'' +
                ", volume=" + volume +
                ", proof=" + proof +
                ", aged=" + aged +
                ", price=" + price +
                '}';
    }

}
