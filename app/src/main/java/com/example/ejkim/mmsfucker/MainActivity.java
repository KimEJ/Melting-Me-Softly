package com.example.ejkim.mmsfucker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText phonnum;
    private ToggleButton send;
    private ArrayList<MmsThread> threads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        threads = new ArrayList<>();

        threads.add(new MmsThread());
        threads.add(new MmsThread());
        threads.add(new MmsThread());
        threads.add(new MmsThread());

        for(MmsThread mms : threads) {
            mms = new MmsThread();
            mms.start();
        }

        phonnum = (EditText) findViewById(R.id.editText);
        send = (ToggleButton) findViewById(R.id.toggleButton);
        send.setOnClickListener(onClickListener);
}

    private ToggleButton.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(send.isChecked()) {
                for(MmsThread mms : threads) {
                    mms.sendTo = phonnum.getText().toString();
                    mms.check = true;
                }
            }
            else{
                for(MmsThread mms : threads) {
                    mms.check = false;
                }
            }
        }
    };
}
