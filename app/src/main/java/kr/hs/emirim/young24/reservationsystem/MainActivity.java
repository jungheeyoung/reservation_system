package kr.hs.emirim.young24.reservationsystem;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart, butDone;
    RadioButton radioDate, radioTime;
    CalendarView calView;
    TimePicker timePicker;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //xml에 있는 요소를 주기억장치에 올려줌, implation해줌

        chrono = (Chronometer)findViewById(R.id.chrono);
        butStart = (Button)findViewById(R.id.but_start);
        butDone= (Button)findViewById(R.id.but_done);
        radioDate = (RadioButton)findViewById(R.id.radio_date);
        radioTime = (RadioButton)findViewById(R.id.radio_time);
        calView = (CalendarView)findViewById(R.id.calendar);
        timePicker = (TimePicker)findViewById(R.id.time_pick);
        textResult = (TextView)findViewById(R.id.text_result);
        timePicker.setVisibility(View.INVISIBLE); //캘린더를 처음에 보이지 않게 해줌
        calView.setVisibility(View.INVISIBLE); //캘린더를 처음에 보이지 않게 해줌 , radio버튼을 클릭하면 보이게 해줌

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timePicker.setVisibility(View.INVISIBLE);
            }//추상메소드
        });//익명클래스로 구현
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE);
                timePicker.setVisibility(View.VISIBLE);
            }//추상메소드
        });//익명클래스로 구현
        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED); //색상을 빨간색으로 변경한다.

            }//추상메소드
        });//익명클래스로 구현
        butDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE); //색상을 빨간색으로 변경한다.
                Calendar cal = Calendar.getInstance(); //참조값을 반환하여 저장
                cal.setTimeInMillis(calView.getDate());
                int year = cal.get(Calendar.YEAR); //캘린더뷰에 상속된 년도를 받을 수 있음
                int month = cal.get(Calendar.MONTH)+1; // 0부터 시작되어 1을 더해준다.
                int date = cal.get(Calendar.DATE);
               // int hour = timePicker.getHour();
                //int minute = timePicker.getMinute(); //+hour+"시 "+minute+"분 "
                String dateAndTime = year+"년 "+month+"월 "+date+"일 ";
                textResult.setText(dateAndTime);
            }//추상메소드
        });//익명클래스로 구현
    }
}
