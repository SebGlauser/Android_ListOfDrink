package com.example.seg.listofdrink;

import java.util.Dictionary;

/**
 * Created by seg on 24.10.17.
 */

public class Drink {

    private Double volume;
    private Double alcoholContent;
    private String  name;

    public Drink(String name, Double volume, Double alcoholContent){
        this.volume = volume;
        this.alcoholContent = alcoholContent;
        this.name = name;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getAlcoholContent() {
        return alcoholContent;
    }

    public void setAlcoholContent(Double alcoholContent) {
        this.alcoholContent = alcoholContent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
