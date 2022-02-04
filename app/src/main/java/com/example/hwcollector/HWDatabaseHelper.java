package com.example.hwcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HWDatabaseHelper extends SQLiteOpenHelper {
    public static final String HWTABLE = "HWTABLE";
    public static final String COLLECTION_NUMBER = "COLLECTION_NUMBER";
    public static final String MODEL_NAME = "MODEL_NAME";
    public static final String YEAR_OF_PRODUCTION = "YEAR_OF_PRODUCTION";
    public static final String IFZAMAC = "IFZAMAC";
    public static final String MAIN_COLOR = "MAIN_COLOR";
    public static final String SECOND_COLOR = "SECOND_COLOR";
    public static final String THIRD_COLOR = "THIRD_COLOR";
    public static final String TIRE_COLOR = "TIRE_COLOR";
    public static final String WHEEL_COLOR = "WHEEL_COLOR";
    public static final String RIM_COLOR = "RIM_COLOR";
    public static final String SERIES_TYPE = "SERIES_TYPE";
    public static final String SERIES_NAME = "SERIES_NAME";
    public static final String ID = "ID";
    public static final String WHEEL_TYPE = "WHEEL_TYPE";
    public static final String TAMPO_NAME = "TAMPO_NAME";

    public HWDatabaseHelper(@Nullable Context context) {
        super(context, "HWCollectorDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + HWTABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLLECTION_NUMBER + " TEXT, " + MODEL_NAME + " TEXT, " + YEAR_OF_PRODUCTION + " TEXT, " + IFZAMAC + " BOOL, " + MAIN_COLOR + " INT, " + SECOND_COLOR + " INT, " + THIRD_COLOR + " INT, " + WHEEL_TYPE + " TEXT, " + TIRE_COLOR + " INT, " + WHEEL_COLOR + " INT, " + RIM_COLOR + " INT, " + SERIES_TYPE + " TEXT, " + SERIES_NAME + " TEXT, " + TAMPO_NAME + " TEXT)";
        sqLiteDatabase.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


    }

    public boolean addOne(DataModel dataModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLLECTION_NUMBER, dataModel.getNumberInCollection());
        cv.put(MODEL_NAME, dataModel.getModelName());
        cv.put(YEAR_OF_PRODUCTION, dataModel.getYearOfProduction());
        cv.put(IFZAMAC, dataModel.getIfZamac());
        cv.put(MAIN_COLOR, dataModel.getMainColorInt());
        cv.put(SECOND_COLOR, dataModel.getSecondColorInt());
        cv.put(THIRD_COLOR, dataModel.getThirdColorInt());
        cv.put(WHEEL_TYPE, dataModel.getWheelType());
        cv.put(TIRE_COLOR, dataModel.getTireColorInt());
        cv.put(WHEEL_COLOR, dataModel.getWheelColorInt());
        cv.put(RIM_COLOR, dataModel.getRimColorInt());
        cv.put(SERIES_TYPE, dataModel.getTypeOfSeries());
        cv.put(SERIES_NAME, dataModel.getSeriesName());
        cv.put(TAMPO_NAME, dataModel.getTampoName());
        long insert = db.insert(HWTABLE, null, cv);
        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
/*
    public List<DataModel> getAllRecords()
    {
        List<DataModel> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM" + HWTABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString);
        if(cursor.moveToFirst())
        {
            do {
                int recordID = cursor.getInt(0);
                String collectionNumber = cursor.getString(1);
                String modelName = cursor.getString(2);
                String yearOfProduction = cursor.getString(3);
                boolean ifZamac = cursor.getInt(4) == 1 ? true: false;
                int mainColor = cursor.getInt(5);
                int secondColor = cursor.getInt(6);
                String wheelType = cursor.getString(7);
                int thirdColor = cursor.getInt(8);
                int tireColor = cursor.getInt(9);
                int wheelColor = cursor.getInt(10);
                int rimColor = cursor.getInt(11);
                String seriesType = cursor.getString(12);
                String seriesName = cursor.getString(13);
                byte [] photoByteArray = cursor.getBlob(14);

                DataModel newModel = new DataModel(recordID, collectionNumber, modelName, yearOfProduction, ifZamac, mainColor, secondColor, wheelType, thirdColor, tireColor, wheelColor, rimColor, seriesType, seriesName, photoByteArray);
            }while (cursor.moveToFirst());
        }
        else
        {

        }

        return returnList;
    }*/
}
