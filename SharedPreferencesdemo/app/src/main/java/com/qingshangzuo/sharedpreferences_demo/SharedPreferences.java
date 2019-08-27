package com.qingshangzuo.sharedpreferences_demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SharedPreferences extends AppCompatActivity {

    private Switch switch1, switch2;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);


        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        save = (Button) findViewById(R.id.save);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.content.SharedPreferences sp1 = getSharedPreferences("switch", MODE_PRIVATE);
                android.content.SharedPreferences.Editor editor = sp1.edit();
                editor.putBoolean("switch1", switch1.isChecked());
                editor.putBoolean("switch2", switch2.isChecked());
                editor.commit();
                Intent intent = new Intent(SharedPreferences.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
        @Override
        protected void onStart() {
            super.onStart();
            android.content.SharedPreferences sp = getSharedPreferences("userInfo", MODE_PRIVATE);
            final boolean cb1 = sp.getBoolean("cb1", false);
            final boolean cb2 = sp.getBoolean("cb2", false);
            switch1.setChecked(cb1);
            switch2.setChecked(cb2);
        }

}
