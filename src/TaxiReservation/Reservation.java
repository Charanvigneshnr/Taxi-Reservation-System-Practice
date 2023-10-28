package TaxiReservation;

import java.util.ArrayList;
import java.util.HashMap;

public class Reservation {
    public static int numberOfTaxis;
    public static int[] places = new int[6];
    public static char[] placesId = {'A','B','C','D','E','F'};
    public static ArrayList<Integer> taxiIdData = new ArrayList<>();
    public static ArrayList<String> bookings = new ArrayList<>();
    public static HashMap<Integer, Integer> earnings = new HashMap<>();

    public Reservation(int numberOfTaxis){
        this.numberOfTaxis = numberOfTaxis;
        for (int i=0;i<numberOfTaxis;i++){
            taxiIdData.add(i);
            earnings.put(i+1,0);
        }
        places[0] = 6;
    }

    public void bookTaxi(Customer c){
        int custId = c.getCustomerId();
        int taxiId = taxiIdData.get(custId);
        char pickPlace = c.getPickUpPoint();
        char dropPlace = c.getDropPoint();
        int pickTime = c.getTime();
        char actualPickPlace = findNearestPickupPoint(pickPlace);
        int price = calculateCost(actualPickPlace,dropPlace);
        int dropTime = dropPlace+Math.abs(actualPickPlace-pickPlace)-62;
        earnings.put(taxiId, earnings.get(taxiId)+price);
        String str = "      "+custId+"      |    "+taxiId+"    |       "+actualPickPlace+"      |      "+dropPlace+"     |      "+pickTime+"      |     "+dropTime+"     |  "+price;
        bookings.add(str);
    }
    public int calculateCost(char pickUp, char drop){
        int distance = (drop-pickUp)*15;
        return distance*10+50;
    }
    public char findNearestPickupPoint(char c){
        switch (c){
            case 'A':{
                for (int i=0;i<=4;i++){
                    if (places[i]>0 && placesId[i]!='A'){
                        return placesId[i];
                    }
                }
                break;
            }
            case 'B':{
                for (int i=0;i<=4;i++){
                    if (places[i]>0 && placesId[i]!='B'){
                        return placesId[i];
                    }
                }
                break;
            }
            case 'C':{
                for (int i=0;i<=4;i++){
                    if (places[i]>0 && placesId[i]!='C'){
                        return placesId[i];
                    }
                }
                break;
            }
            case 'D':{
                for (int i=0;i<=4;i++){
                    if (places[i]>0 && placesId[i]!='D'){
                        return placesId[i];
                    }
                }
                break;
            }
            case 'E':{
                for (int i=0;i<=4;i++){
                    if (places[i]>0 && placesId[i]!='E'){
                        return placesId[i];
                    }
                }
                break;
            }
        }
        return c;
    }

    public void printDetials(){
        for (String s : bookings){
            System.out.println(s);
        }
    }

}
