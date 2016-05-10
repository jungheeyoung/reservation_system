package kr.hs.emirim.young24.reservationsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

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
        
    }
}
