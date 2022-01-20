package com.example.hwcollector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddInformation extends AppCompatActivity {

   TextView letterCounter, letterCounter2;
   EditText addName, addWheelType;
   Spinner yearSpinner;
   ImageButton backButton, mainColorButton, secondColorButton, thirdColorButton, tireColorButton, wheelsColorButton, rimColorButton;
   String[] arrayList;
   int mainDefaultColor, secondDefaultColor, thirdDefaultColor, tireDefaultColor, wheelDefaultColor, rimDefaultColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);
        GetComponents();
        LetterCounters();
        CreateList();
        CreateArrayAdapter();
        AssignColors();
        ButtonListeners();
    }

    private void AssignColors() {
        mainDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
        secondDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
        thirdDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
        tireDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
        wheelDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
        rimDefaultColor = ContextCompat.getColor(AddInformation.this, R.color.white);
    }

    //This part of code brings together all button listeners
    private void ButtonListeners() {
        backButton.setOnClickListener(v -> alertDialog());
        mainColorButton.setOnClickListener(view -> ShowMainColorPicker());
        secondColorButton.setOnClickListener(view -> ShowSecondColorPicker());
        thirdColorButton.setOnClickListener(view -> ShowThirdColorPicker());
        tireColorButton.setOnClickListener(view -> ShowTireColorPicker());
        wheelsColorButton.setOnClickListener(view -> ShowWheelColorPicker());
        rimColorButton.setOnClickListener(view -> ShowRimColorPicker());
    }

    private void GetComponents() {
        letterCounter = findViewById(R.id.lettersCounter);
        letterCounter2 = findViewById(R.id.lettersCounter2);
        addName = findViewById(R.id.nameEditText);
        addWheelType = findViewById(R.id.wheelTypeEditText);
        yearSpinner = findViewById(R.id.yearSpinner);
        backButton = findViewById(R.id.backBT);
        mainColorButton= findViewById(R.id.mainColor);
        secondColorButton= findViewById(R.id.secondColor);
        thirdColorButton= findViewById(R.id.thirdColor);
        tireColorButton= findViewById(R.id.tireColor);
        wheelsColorButton= findViewById(R.id.wheelColor);
        rimColorButton= findViewById(R.id.rimColor);
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowMainColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, mainDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                mainDefaultColor = color;
                mainColorButton.setBackgroundColor(mainDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowSecondColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, secondDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                secondDefaultColor = color;
                secondColorButton.setBackgroundColor(secondDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowThirdColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, thirdDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                thirdDefaultColor = color;
                thirdColorButton.setBackgroundColor(thirdDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowTireColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, tireDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                tireDefaultColor = color;
                tireColorButton.setBackgroundColor(tireDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowWheelColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, wheelDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                wheelDefaultColor = color;
                wheelsColorButton.setBackgroundColor(wheelDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code allows to show dialog window with color picker in it, after accepting, color of assigned ImageButton or Button changes to one chosen in color picker
    private void ShowRimColorPicker()
    {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, rimDefaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                rimDefaultColor = color;
                rimColorButton.setBackgroundColor(rimDefaultColor);
            }
        });
        colorPicker.show();
    }

    //This part of code manages letter counting bellow all EditTexts that have limit on possible characters
    private void LetterCounters() {
        letterCounter.setText("50/50");
        letterCounter2.setText("50/50");
        addName.addTextChangedListener(editTextWatcherForName);
        addWheelType.addTextChangedListener(editTextWatcherForWheelType);
    }

    //This function creates ArrayAdapter that allows to populate assigned Spinner with records from arrayList
    private void CreateArrayAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);
    }

    //This function allows to go back to previous activity after user's confirmation
    public void alertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Closing")
                .setTitle("Are you sure you want to exit without saving?")
                .setPositiveButton("Yes", (dialog, id) -> {
                    Intent intent = new Intent(AddInformation.this, ListView.class);
                    startActivity(intent);
                })
                .setNegativeButton("No", (dialog, id) -> {
                    // CANCEL
                });

        builder.create().show();
    }

    // This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter.setText(50 - editable.toString().length() + "/50");
        }
    };

    // This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForWheelType = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter2.setText(50 - editable.toString().length() + "/50");
        }
    };

    // This function creates list of strings and populate it with years from 1968 to the current one
    private void CreateList()
    {
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        int howManyYears = thisYear - 1967;
        int actualYear = 1968;
        arrayList = new String[howManyYears];
            for( int i = 0; i < howManyYears; i++)
            {
                arrayList[i] = String.valueOf(actualYear + i);
            }
        }
    }

