package com.hfad.mykeyoardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Map;

//1. Implement an interface (View.OnClickListener) for handling calendar click events
//7.0 Implement an interface (AdapterView.onItemSelectedListener)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{
//2. declare a varaible to hold the editText Input
    private EditText birthday;
    //5. Declare the variable to hold the selected date(YEAR, MONTH, DAY)
    private int mYear;
    private int mMonth;
    private int mDay;

    //7.6 Declare a variable for holding the item selected on the spinner
    private String mSpinnerLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3. Connect the edittext variable with the one in the layout
        birthday = findViewById(R.id.birthday);
        //4. Add on CLickListener to this edittext so as to handle click events
        birthday.setOnClickListener(this);

        //7.1 Declare a spinner variable and connect it with a spinner view in the layout
        Spinner phoneSpinner = findViewById(R.id.phone_spinner);

        //7.2 Set an onItenSelectedListener on the spinner/varaible you have created
        if (phoneSpinner!=null) {
            phoneSpinner.setOnItemSelectedListener(this);
        }
        //7.3 Create an array adapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_label, android.R.layout.simple_spinner_item);
        //7.4 Specify the layout for dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //7.5 Attach the spinner to the adapter
        if (phoneSpinner!=null) {
            phoneSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v){
        //6. to get the instance of the current date
        //6.2 Ensure that focus is on the Edit variable birthday
        if (v==birthday){
            //declare a calendar to get current selected date
          final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);
            //6.3 Lets declare a date picker dialogue to pick selected date
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //6.4 Set the date on the editText variable
                    birthday.setText(dayOfMonth + "-"+ month + 1 + "-" + year);
                }
            }, mYear,mMonth,mDay);
            //6.5 Show the date picker dialog
            datePickerDialog.show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //7.6 Declare a variable for holding the item selected on the spinner
        //7.7 Use the method getItemAtPostion() to get the label selected
        mSpinnerLabel = adapterView.getItemAtPosition(i).toString();
        //7.8 Something to do with item selected
        Toast myToast = Toast.makeText(this, "Selected phone as:" + mSpinnerLabel, Toast.LENGTH_SHORT);
        myToast.show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //7.9 Something to do
        Toast toast = Toast.makeText(this, "Nothing selected", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this, "Please Accept Terms and Conditions", Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        //Compare passwords
        //Throw error exceptions
        //get the data entered on edit text and save it on a database
        //Add an intent and open main Activity/login Activity
        //Throw a toast
        Toast toastSubmit = Toast.makeText(this, "Account Creation Successful", Toast.LENGTH_SHORT);
        toastSubmit.show();
    }
}
