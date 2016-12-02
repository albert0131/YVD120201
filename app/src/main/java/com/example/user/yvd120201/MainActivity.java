package com.example.user.yvd120201;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;                                   // 宣告SharedPreferences儲存方式
    EditText editText;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("mydata", MODE_PRIVATE);
        editText = (EditText) findViewById(R.id.editText);
        tv2 = (TextView) findViewById(R.id.textView);
    }
    // 寫入資料到手機
    public void clickWrite(View v)
    {
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("name", editText.getText().toString());
        ed.commit();
    }
    // 從手機讀取資料
    public void clickRead(View v)
    {
        String str = sp.getString("name", "Default");
        tv2.setText(str);
    }
}
