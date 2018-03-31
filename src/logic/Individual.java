package logic;

import canteencomponents.*;
import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class Individual {

    private ArrayList<Table> tablesCoordinates;//lista współrzędnych stołów 
    private ArrayList<Seat> seatsCoordinates;//lista współrzędnych krzeseł 
    private ArrayList<Window> windowsCoordinates;//lista współrzędnych okien 
    private ArrayList<Lamp> lampsCoordinates;//lista współrzędnych lamp 
    private Door door;
    private Shop shop;

    private int sittingPlacesComfort;
    private int costComfort;
    private int tablesComfort;
    private int lightningComfort;
    private int windowsComfort;
    private int shopComfort;

    private int comfortPoints;

    private double costSum;

    private double distanceBetweenWindows;
    private double distanceBetweenLampsX;
    private double distanceBetweenLampsY;
    private double windowsSize;

    private int numberOfWindows;
    private int numberOfLamps;
    private int numberOfTables;
    private int numberOfSittingPlaces;

    private int fitness;

    public Individual() {
        tablesCoordinates = new ArrayList<>();
        seatsCoordinates = new ArrayList<>();
        windowsCoordinates = new ArrayList<>();
        lampsCoordinates = new ArrayList<>();
    }

    public ArrayList<Table> getTablesCoordinates() {
        return tablesCoordinates;
    }

    public void setTablesCoordinates(ArrayList<Table> tablesCoordinates) {
        this.tablesCoordinates = tablesCoordinates;
    }

    public ArrayList<Seat> getSeatsCoordinates() {
        return seatsCoordinates;
    }

    public void setSeatsCoordinates(ArrayList<Seat> seatsCoordinates) {
        this.seatsCoordinates = seatsCoordinates;
    }

    public ArrayList<Window> getWindowsCoordinates() {
        return windowsCoordinates;
    }

    public void setWindowsCoordinates(ArrayList<Window> windowsCoordinates) {
        this.windowsCoordinates = windowsCoordinates;
    }

    public ArrayList<Lamp> getLampsCoordinates() {
        return lampsCoordinates;
    }

    public void setLampsCoordinates(ArrayList<Lamp> lampsCoordinates) {
        this.lampsCoordinates = lampsCoordinates;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public int getSittingPlacesComfort() {
        return sittingPlacesComfort;
    }

    public void setSittingPlacesComfort(int sittingPlacesComfort) {
        this.sittingPlacesComfort = sittingPlacesComfort;
    }

    public int getCostComfort() {
        return costComfort;
    }

    public void setCostComfort(int costComfort) {
        this.costComfort = costComfort;
    }

    public int getTablesComfort() {
        return tablesComfort;
    }

    public void setTablesComfort(int tablesComfort) {
        this.tablesComfort = tablesComfort;
    }

    public int getLightningComfort() {
        return lightningComfort;
    }

    public void setLightningComfort(int lightningComfort) {
        this.lightningComfort = lightningComfort;
    }

    public int getWindowsComfort() {
        return windowsComfort;
    }

    public void setWindowsComfort(int windowsComfort) {
        this.windowsComfort = windowsComfort;
    }

    public int getShopComfort() {
        return shopComfort;
    }

    public void setShopComfort(int shopComfort) {
        this.shopComfort = shopComfort;
    }

    public double getCostSum() {
        return costSum;
    }

    public void setCostSum(double costSum) {
        this.costSum = costSum;
    }

    public int getComfortPoints() {
        return comfortPoints;
    }

    public void setComfortPoints(int comfortPoints) {
        this.comfortPoints = comfortPoints;
    }

    public int getFitness() {
        return fitness;
    }

    public void setFitness(int fitness) {
        this.fitness = fitness;
    }

    public double getDistanceBetweenWindows() {
        return distanceBetweenWindows;
    }

    public void setDistanceBetweenWindows(double distanceBetweenWindows) {
        this.distanceBetweenWindows = distanceBetweenWindows;
    }

    public double getDistanceBetweenLampsX() {
        return distanceBetweenLampsX;
    }

    public void setDistanceBetweenLampsX(double distanceBetweenLampsX) {
        this.distanceBetweenLampsX = distanceBetweenLampsX;
    }

    public double getDistanceBetweenLampsY() {
        return distanceBetweenLampsY;
    }

    public void setDistanceBetweenLampsY(double distanceBetweenLampsY) {
        this.distanceBetweenLampsY = distanceBetweenLampsY;
    }

    public double getWindowsSize() {
        return windowsSize;
    }

    public void setWindowsSize(double windowsSize) {
        this.windowsSize = windowsSize;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public void setNumberOfLamps(int numberOfLamps) {
        this.numberOfLamps = numberOfLamps;
    }

    public void setNumberOfTables(int numberOfTables) {
        this.numberOfTables = numberOfTables;
    }

    public void setNumberOfSittingPlaces(int numberOfSittingPlaces) {
        this.numberOfSittingPlaces = numberOfSittingPlaces;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public int getNumberOfLamps() {
        return numberOfLamps;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public int getNumberOfSittingPlaces() {
        return numberOfSittingPlaces;
    }

    @Override
    public String toString() {
        return "Individual{" + "costSum=" + costSum + ", comfortPoints=" + comfortPoints + ", fitness=" + fitness + '}';
    }

}
