package com.example.hgmovil.intramovil.view;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.os.Build;
import android.os.Bundle;

import com.example.hgmovil.intramovil.R;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.TimePickerDialog;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by pablo on 18-12-2016.
 */

public class MenuAlarma2 extends AppCompatActivity implements View.OnClickListener
{
    private TextView hora;
    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    private int mHour, mMinute;


    Context context;
    PendingIntent pending_intent;
    int choose_whale_sound;
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_alarma);
        hora = (TextView) findViewById(R.id.txth);
        Calendar calendar = Calendar.getInstance();



        this.context = this;
        // initialize our alarm manager
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);

        //initialize our timepicker
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);

        //initialize our text update box
        //update_text = (TextView) findViewById(R.id.update_text);

        // create an instance of a calendar


        // initialize start button
        Button alarm_on = (Button) findViewById(R.id.alarm_on);

        alarm_on.setOnClickListener(this);
        // create an onClick listener to start the alarm
        
        
            
           


        


    }
    public void onClick(View v)
    {
        final Calendar c = Calendar.getInstance();
        // setting calendar instance with the hour and minute that we picked
        // on the time picker

        c.get(Calendar.HOUR);
        c.get(Calendar.MINUTE);

        // get the int values of the hour and minute
       // int hour = alarm_timepicker.getHour();
        //int minute = alarm_timepicker.getHour();

        // convert the int values to strings
        //String hour_string = String.valueOf(hour);
        //String minute_string = String.valueOf(minute);


        // convert 24-hour time to 12-hour time
        //if (hour > 12) {
          //  hour_string = String.valueOf(hour - 12);
        //}

        //if (minute < 10) {
            //10:7 --> 10:07
          //  minute_string = "0" + String.valueOf(minute);
    //    }


      //  hora.setText(hour_string+":"+minute_string);

    }


}