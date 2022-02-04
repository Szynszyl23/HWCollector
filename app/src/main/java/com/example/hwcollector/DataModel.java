package com.example.hwcollector;

public class DataModel {

    private int id;
    private String numberInCollection;
    private String modelName;
    private String yearOfProduction;
    private Boolean ifZamac;
    private int mainColorInt, secondColorInt, thirdColorInt;
    private String wheelType;
    private int tireColorInt, wheelColorInt, rimColorInt;
    private String typeOfSeries;
    private String seriesName;
    private String tampoName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberInCollection() {
        return numberInCollection;
    }

    public void setNumberInCollection(String numberInCollection) {
        this.numberInCollection = numberInCollection;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public Boolean getIfZamac() {
        return ifZamac;
    }

    public void setIfZamac(Boolean ifZamac) {
        this.ifZamac = ifZamac;
    }

    public int getMainColorInt() {
        return mainColorInt;
    }

    public void setMainColorInt(int mainColorInt) {
        this.mainColorInt = mainColorInt;
    }

    public int getSecondColorInt() {
        return secondColorInt;
    }

    public void setSecondColorInt(int secondColorInt) {
        this.secondColorInt = secondColorInt;
    }

    public int getThirdColorInt() {
        return thirdColorInt;
    }

    public void setThirdColorInt(int thirdColorInt) {
        this.thirdColorInt = thirdColorInt;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }

    public int getTireColorInt() {
        return tireColorInt;
    }

    public void setTireColorInt(int tireColorInt) {
        this.tireColorInt = tireColorInt;
    }

    public int getWheelColorInt() {
        return wheelColorInt;
    }

    public void setWheelColorInt(int wheelColorInt) {
        this.wheelColorInt = wheelColorInt;
    }

    public int getRimColorInt() {
        return rimColorInt;
    }

    public void setRimColorInt(int rimColorInt) {
        this.rimColorInt = rimColorInt;
    }

    public String getTypeOfSeries() {
        return typeOfSeries;
    }

    public void setTypeOfSeries(String typeOfSeries) {
        this.typeOfSeries = typeOfSeries;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getTampoName() {
        return tampoName;
    }

    public void setTampoName(String tampoName) {
        this.tampoName = tampoName;
    }

    public DataModel(int id, String numberInCollection, String modelName, String yearOfProduction, Boolean ifZamac, int mainColorInt, int secondColorInt, int thirdColorInt, String wheelType, int tireColorInt, int wheelColorInt, int rimColorInt, String typeOfSeries, String seriesName, String tampoName) {
        this.id = id;
        this.numberInCollection = numberInCollection;
        this.modelName = modelName;
        this.yearOfProduction = yearOfProduction;
        this.ifZamac = ifZamac;
        this.mainColorInt = mainColorInt;
        this.secondColorInt = secondColorInt;
        this.thirdColorInt = thirdColorInt;
        this.wheelType = wheelType;
        this.tireColorInt = tireColorInt;
        this.wheelColorInt = wheelColorInt;
        this.rimColorInt = rimColorInt;
        this.typeOfSeries = typeOfSeries;
        this.seriesName = seriesName;
        this.tampoName = tampoName;
    }




}



