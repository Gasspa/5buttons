package com.example.myapplication1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;
import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.button).setOnClickListener(v-> showAlertDialog());
        findViewById(R.id.button2).setOnClickListener(v-> showListDialog());
        findViewById(R.id.button3).setOnClickListener(v-> showDatePickerDialog());
        findViewById(R.id.button3).setOnClickListener(v-> showtimePickerDialogue());
    }
        private void showAlertDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Porsty alert");
            builder.setMessage("wiadomosc");

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(MainActivity.this,"Kliknieto ok", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("ANuluj", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(MainActivity.this,"Kliknieto anuluj", Toast.LENGTH_SHORT).show();
                }
            });
            builder.create().show();
        }
   private void showListDialog(){
        final String[] items = {"opcja 1","opcja 2","opcja 3","opcja 4","opcja 5","opcja 6"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("WYbierz opcje: ");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(MainActivity.this, "Wybrano" + items[which], Toast.LENGTH_SHORT).show();
            }
        });
       builder.create().show();
    }
    private void showDatePickerDialog(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfmonth) {
                        Toast.makeText(MainActivity.this,"Wybrana data" + dayOfmonth+ "/" +(month + 1)+ "/" + year, Toast.LENGTH_SHORT).show();
                    }
        }, year, month, day);
        datePickerDialog.show();
    }
    private void showtimePickerDialogue(){
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this,"Wybrana godzina" + hourOfDay+ ":" + minute, Toast.LENGTH_SHORT).show();
            }
        },hour, minute, true);
        timePickerDialog.show();
    }
}