package com.example.ejkim.mmsfucker;


import android.telephony.SmsManager;

import java.util.ArrayList;

public class MmsThread extends Thread {

    public String sendmessage = "Message";
    public String sendTo;
    public boolean check=false;


    public void run() {
        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> messagePart = smsManager.divideMessage(sendmessage);


        while(true) {
            while (check) {
                smsManager.sendMultipartTextMessage(sendTo, null, messagePart, null, null);

                try {
                    sleep(10);
                } catch (Exception e) {

                }
            }
        }
    }
}
