package com.example.eventbus;

/**
 * Created by Gowtham on 6/24/2016.
 */
public class ChargingEvent {
    private String data;

    public ChargingEvent(String data){
        this.data = data;
    }

    public String getData(){
        return data;
    }
}