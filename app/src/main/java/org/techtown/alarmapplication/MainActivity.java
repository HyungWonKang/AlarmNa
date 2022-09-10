package org.techtown.alarmapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import DBHelper;

public class MainActivity extends AppCompatActivity {
    private ArrayList<AlarmItem> mAlarmItems;
    private DBHelper mDBHelper;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //제목
        EditText editText1 = findViewById(R.id.editTextTextPersonName);
        String title = editText1.getText().toString();

        //날짜
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int dayOfMonth = datePicker.getDayOfMonth();
        String date = String.format("%d-%d-%d",year,month,dayOfMonth);

        //시간
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String time = String.format("%d-%d",hour,minute);

        //지속시간
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int checkedId = radioGroup.getCheckedRadioButtonId();
        int duration;
        switch (checkedId){
                case R.id.radioButton2:
                    duration = 15000;
                    break;
                case R.id.radioButton3:
                    duration = 30000;
                    break;
                case R.id.radioButton4:
                    duration = 60000;
                    break;
                case R.id.radioButton5:
                    duration = 120000;
                    break;
        };

        //전화번호
        EditText editText2 = findViewById(R.id.editTextTextPersonName3);
        String receiver = editText2.getText().toString();

        //보낼 문자 내용
        EditText editText3 = findViewById(R.id.editTextTextPersonName2);
        String content = editText3.getText().toString();

        mDBHelper.up


    }

}







