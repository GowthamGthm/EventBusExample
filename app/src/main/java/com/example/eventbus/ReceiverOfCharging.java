package com.example.eventbus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Gowtham on 6/24/2016.
 */
public class ReceiverOfCharging extends BroadcastReceiver {

    private EventBus bus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        ChargingEvent event = null;

        // Get current time


        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

        String timeOfEvent = simpleDateFormat.format(calendar.getTime());


        String eventData = "@" + timeOfEvent + " this device started ";


        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            event = new ChargingEvent(eventData + "charging.");
        } else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            event = new ChargingEvent(eventData + "discharging.");
        }

        // Post the event
        bus.post(event);
    }





}

