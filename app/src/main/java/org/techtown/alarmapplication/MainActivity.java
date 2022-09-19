package org.techtown.alarmapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TimePicker;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<AlarmItem> mAlarmItems;
    private DBHelper mDBHelper;
    public int duration;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInit();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setInit() {
        

        mAlarmItems = new ArrayList<>();
        mDBHelper = new DBHelper(this);

        Button Btn_save = findViewById(R.id.button);
        Button Btn_cancel = findViewById(R.id.button2);
        Button Btn_delete = findViewById(R.id.button3);


        //제목
        EditText editText1 = findViewById(R.id.editTextTextPersonName);
        String title = editText1.getText().toString();

        //날짜
        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int dayOfMonth = datePicker.getDayOfMonth();
        String date = String.format("%d-%d-%d", year, month, dayOfMonth);

        //시간
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();
        String time = String.format("%d-%d", hour, minute);

        //지속시간
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
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
            }
        });


        //전화번호
        EditText editText2 = findViewById(R.id.editTextTextPersonName3);
        String receiver = editText2.getText().toString();

        //보낼 문자 내용
        EditText editText3 = findViewById(R.id.editTextTextPersonName2);
        String content = editText3.getText().toString();


        //추가하기 버튼을 누르고 저장 버튼 눌렀을 때
        Btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insert Database
                mDBHelper.InsertAlarm(title, date, time, duration, receiver, content);


            }
        });


        //원래 있던 리사이클뷰에서 데이터를 선택한 후 수정한 뒤 저장 버튼을 눌렀을 때



        //취소 버튼 눌렀을 때
        Btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //!!!!!!!!!!!!!!메인 화면으로 돌아가는 코드 자리!!!!!!!!!!!!!1
            }
        });


        //삭제 버튼 눌렀을 때
        Btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Delete Database

            }
        });



    }


}







