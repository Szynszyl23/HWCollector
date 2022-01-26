package com.example.hwcollector;

public class DataModel {

    private int id, mainColorInt, secondColorInt, thirdColorInt, tireColorInt, wheelColorInt, rimColorInt;
    private String numberInCollection;
    private String modelName;
    private String yearOfProduction;
    private String wheelType;
    private String typeOfSeries;
    private String seriesName;
    private Boolean ifZamac;
    private byte[] chosenPicture;

    //constructor


    public DataModel(int id, int mainColorInt, int secondColorInt, int thirdColorInt, String wheelType, int tireColorInt, int wheelColorInt, int rimColorInt, String numberInCollection, String modelName, String yearOfProduction, String typeOfSeries, String seriesName, Boolean ifZamac, byte[] chosenPicture) {
        this.id = id;
        this.mainColorInt = mainColorInt;
        this.secondColorInt = secondColorInt;
        this.thirdColorInt = thirdColorInt;
        this.tireColorInt = tireColorInt;
        this.wheelColorInt = wheelColorInt;
        this.rimColorInt = rimColorInt;
        this.numberInCollection = numberInCollection;
        this.modelName = modelName;
        this.yearOfProduction = yearOfProduction;
        this.wheelType = wheelType;
        this.typeOfSeries = typeOfSeries;
        this.seriesName = seriesName;
        this.ifZamac = ifZamac;
        this.chosenPicture = chosenPicture;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getIfZamac() {
        return ifZamac;
    }

    public void setIfZamac(Boolean ifZamac) {
        this.ifZamac = ifZamac;
    }

    public byte[] getChosenPicture() {
        return chosenPicture;
    }

    public void setChosenPicture(byte[] chosenPicture) {
        this.chosenPicture = chosenPicture;
    }

    public String getWheelType() {
        return wheelType;
    }

    public void setWheelType(String wheelType) {
        this.wheelType = wheelType;
    }
}
