package com.example.hwcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
    public static final String PHOTO = "PHOTO";
    public static final String ID = "ID";
    public static final String WHEEL_TYPE = "WHEEL_TYPE";

    public HWDatabaseHelper(@Nullable Context context) {
        super(context, "HWCollectorDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + HWTABLE + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLLECTION_NUMBER + " TEXT, " + MODEL_NAME + " TEXT, " + YEAR_OF_PRODUCTION + " TEXT, " + IFZAMAC + " BOOL, " + MAIN_COLOR + " INT, " + SECOND_COLOR + " INT, " + WHEEL_TYPE + " TEXT, " + THIRD_COLOR + " INT, " + TIRE_COLOR + " INT, " + WHEEL_COLOR + " INT, " + RIM_COLOR + " INT, " + SERIES_TYPE + " TEXT, " + SERIES_NAME + " TEXT, " + PHOTO + " BLOB)";
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
        cv.put(PHOTO, dataModel.getChosenPicture());
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
}
