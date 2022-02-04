package com.example.hwcollector;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.CursorWindow;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Calendar;

import yuku.ambilwarna.AmbilWarnaDialog;

public class AddInformation extends AppCompatActivity {

   TextView letterCounter, letterCounter2, letterCounter3, letterCounter4;
   EditText addName, addWheelType, addSeriesName, addTampo;
   Spinner yearSpinner, seriesNumberSpinner, seriesTypeSpinner;
   ImageButton backButton, mainColorButton, secondColorButton, thirdColorButton, tireColorButton, wheelsColorButton, rimColorButton, selectFromGalleryButton;
   Button finishAndSave;
   String[] arrayYearList, arraySeriesList, arraySeriesTypeList;
   CheckBox isZamac;
   int mainDefaultColor, secondDefaultColor, thirdDefaultColor, tireDefaultColor, wheelDefaultColor, rimDefaultColor, SELECT_PICTURE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_information);

        GetComponents();
        LetterCounters();
        CreateArrayLists();
        CreateYearArrayAdapter();
        CreateSeriesArrayAdapter();
        CreateSeriesTypeArrayAdapter();
        AssignColors();
        ButtonListeners();
    }


    //This part of code assigns white color as starting color of all ImageButtons responsible for color selecting
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
        finishAndSave.setOnClickListener(view -> FinishAndSave());
    }

    private void GetComponents() {
        letterCounter = findViewById(R.id.lettersCounter);
        letterCounter2 = findViewById(R.id.lettersCounter2);
        letterCounter3 = findViewById(R.id.lettersCounter3);
        letterCounter4 = findViewById(R.id.lettersCounter4);
        addName = findViewById(R.id.nameEditText);
        addWheelType = findViewById(R.id.wheelTypeEditText);
        addSeriesName = findViewById(R.id.seriesNameEditText);
        addTampo = findViewById(R.id.tampoEditText);
        yearSpinner = findViewById(R.id.yearSpinner);
        seriesNumberSpinner = findViewById(R.id.seriesNumberSpinner);
        seriesTypeSpinner = findViewById(R.id.seriesTypeSpinner);
        backButton = findViewById(R.id.backBT);
        mainColorButton= findViewById(R.id.mainColor);
        secondColorButton= findViewById(R.id.secondColor);
        thirdColorButton= findViewById(R.id.thirdColor);
        tireColorButton= findViewById(R.id.tireColor);
        wheelsColorButton= findViewById(R.id.wheelColor);
        rimColorButton= findViewById(R.id.rimColor);
        finishAndSave = findViewById(R.id.finishBT);
        isZamac = findViewById(R.id.isZamac);
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
                mainDefaultColor = color;                                                           //This part assigns selected color in place of previous one
                mainColorButton.setBackgroundColor(mainDefaultColor);                               //This part changes background color of ImageButton to previously assigned one
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
                secondDefaultColor = color;                                                         //This part assigns selected color in place of previous one
                secondColorButton.setBackgroundColor(secondDefaultColor);                           //This part changes background color of ImageButton to previously assigned one
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
                thirdDefaultColor = color;                                                          //This part assigns selected color in place of previous one
                thirdColorButton.setBackgroundColor(thirdDefaultColor);                             //This part changes background color of ImageButton to previously assigned one
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
                tireDefaultColor = color;                                                           //This part assigns selected color in place of previous one
                tireColorButton.setBackgroundColor(tireDefaultColor);                               //This part changes background color of ImageButton to previously assigned one
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
                wheelDefaultColor = color;                                                          //This part assigns selected color in place of previous one
                wheelsColorButton.setBackgroundColor(wheelDefaultColor);                            //This part changes background color of ImageButton to previously assigned one
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
                rimDefaultColor = color;                                                            //This part assigns selected color in place of previous one
                rimColorButton.setBackgroundColor(rimDefaultColor);                                 //This part changes background color of ImageButton to previously assigned one
            }
        });
        colorPicker.show();
    }

    //This part of code manages letter counting bellow all EditTexts that have limit on possible characters
    private void LetterCounters() {
        letterCounter.setText("50/50");
        letterCounter2.setText("50/50");
        letterCounter3.setText("50/50");
        letterCounter4.setText("50/50");
        addName.addTextChangedListener(editTextWatcherForName);
        addWheelType.addTextChangedListener(editTextWatcherForWheelType);
        addSeriesName.addTextChangedListener(editTextWatcherForSeriesName);
        addTampo.addTextChangedListener(editTextWatcherForTampo);
    }

    //This function creates ArrayAdapter that allows to populate yearSpinner with records from arrayYearList
    private void CreateYearArrayAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arrayYearList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        yearSpinner.setAdapter(adapter);
    }

    //This function creates ArrayAdapter that allows to populate seriesNumberSpinner with records from arraySeriesList
    private void CreateSeriesArrayAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySeriesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seriesNumberSpinner.setAdapter(adapter);
    }

    //This function creates ArrayAdapter that allows to populate seriesTypeSpinner with records from arraySeriesTypeList
    private void CreateSeriesTypeArrayAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, arraySeriesTypeList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        seriesTypeSpinner.setAdapter(adapter);
    }

    //This function allows to go back to previous activity after user's confirmation
    public void alertDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to exit without saving?")
                .setTitle("Closing")
                .setPositiveButton("Yes", (dialog, id) -> {
                    Intent intent = new Intent(AddInformation.this, ListView.class);
                    startActivity(intent);
                })
                .setNegativeButton("No", (dialog, id) -> {
                    // CANCEL
                });

        builder.create().show();
    }

    //This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter.setText(50 - editable.toString().length() + "/50");                       //This part shows numbers from 50 to 0 updating after every character typed or deleted
        }
    };

    //This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForWheelType = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter2.setText(50 - editable.toString().length() + "/50");                      //This part shows numbers from 50 to 0 updating after every character typed or deleted
        }
    };

    //This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForSeriesName = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter3.setText(50 - editable.toString().length() + "/50");                      //This part shows numbers from 50 to 0 updating after every character typed or deleted
        }
    };

    //This part of code enables letter counting from assigned EditText and displaying results in assigned TextView to show user how many character can be still used
    private final TextWatcher editTextWatcherForTampo = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            letterCounter4.setText(50 - editable.toString().length() + "/50");                      //This part shows numbers from 50 to 0 updating after every character typed or deleted
        }
    };

    /*
    This function creates list of strings and populate it with years from 1968 to the current one
    This function creates list of strings and populate it with numbers from 1 to 250
    This function creates list of strings and populate it with Series types
    */
    private void CreateArrayLists()
    {
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);                                   //This part gets actual year from phone's calendar
        int firstYear = 1968;                                                                       //This part puts 1968 as first year in list
        int howManyYears = thisYear - 1967;                                                         //This part determines how many years will be in list
        arraySeriesList = new String[250];
        arrayYearList = new String[howManyYears];
        arraySeriesTypeList = new String[5];
        arraySeriesTypeList[0] = "Mainline";
        arraySeriesTypeList[1] = "Special";
        arraySeriesTypeList[2] = "TH";
        arraySeriesTypeList[3] = "STH";
        arraySeriesTypeList[4] = "RLC";
            for( int i = 0; i < howManyYears; i++)                                                  //This loop populates list arrayYearList
            {
                arrayYearList[i] = String.valueOf(firstYear + i);
            }
            for( int i = 0; i<250; i++)                                                             //This loop populates list arraySeriesList
            {
                arraySeriesList[i] = String.valueOf(i + 1);
            }
        }

    //This part of code brings user back to previous activity and shows dialog confirming adding record to database (no database for now)
    //User can't save information while any of EditTexts is empty
    private void FinishAndSave()
    {
        DataModel dataModel;
        if(addName.length() > 0)                                                                    //This if statement checks if there are more letters than 0 in addName
        {
            if(addWheelType.length() > 0)                                                           //This if statement checks if there are more letters than 0 in addWheelType
            {
                if(addSeriesName.length() > 0)                                                     //This if statement checks if there are more letters than 0 in addSeriesName
                {
                    if (addTampo.length() > 0)
                    {
                        Intent intent = new Intent(AddInformation.this, ListView.class);
                        startActivity(intent);
                        try {
                            dataModel = new DataModel(0, seriesNumberSpinner.getSelectedItem().toString(), addName.getText().toString(), yearSpinner.getSelectedItem().toString(), isZamac.isActivated(), mainDefaultColor, secondDefaultColor, thirdDefaultColor, addWheelType.getText().toString(), tireDefaultColor, wheelDefaultColor, rimDefaultColor, seriesTypeSpinner.getSelectedItem().toString(), addSeriesName.getText().toString(), addTampo.getText().toString());
                            Toast.makeText(AddInformation.this, "Added model: " + addName.getText().toString(), Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
                            dataModel = new DataModel(0, "error", "error", "error", false, -1, -1, -1, "error", -1, -1, -1, "error", "error", "error");
                            Toast.makeText(AddInformation.this, "Model couldn't be added", Toast.LENGTH_SHORT).show();
                        }
                        HWDatabaseHelper dataBaseHelper = new HWDatabaseHelper(AddInformation.this);
                        boolean success = dataBaseHelper.addOne(dataModel);
                        Toast.makeText(AddInformation.this, "Success " + success, Toast.LENGTH_SHORT).show();

                    }
                    else {addTampo.setError("Space empty"); Toast.makeText(AddInformation.this, "Tampo name is empty", Toast.LENGTH_SHORT).show();}
                }
                else {addSeriesName.setError("Space empty"); Toast.makeText(AddInformation.this, "Series name is empty", Toast.LENGTH_SHORT).show();}
            }
            else {addWheelType.setError("Space empty"); Toast.makeText(AddInformation.this, "Wheel type is empty", Toast.LENGTH_SHORT).show();}
        }
        else {addName.setError("Space empty"); Toast.makeText(AddInformation.this, "Model name is empty", Toast.LENGTH_SHORT).show();}
    }

    }

