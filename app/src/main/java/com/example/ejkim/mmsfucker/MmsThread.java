package com.example.ejkim.mmsfucker;


import android.content.Intent;
import android.net.Uri;

import static android.R.id.message;

public class MmsThread extends Thread {

    public String sendTo;
    public boolean check;


    public void run() {
//        SmsManager smsManager = SmsManager.getDefault();
//        ArrayList<String> partMessage = smsManager.divideMessage("Test");
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + sendTo));
        intent.putExtra("sms_body", "message");
        startActivity(intent);


        while(true) {
            while (check) {
//                smsManager.sendMultipartTextMessage(sendTo, null, partMessage, null, null);

                try {
                    sleep(10);
                }
                catch (Exception e) {

                }
            }
        }
        //
    }
}
