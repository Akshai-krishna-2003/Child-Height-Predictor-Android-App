package com.example.childheightpredictorbyakshai;

import java.util.Map;
import java.util.LinkedHashMap;

public class HeightPredictor {

    double fatherHeight, motherHeight,childHeight,childAge;
    String unit,gender;
    double predictedHeight,kvalue=0.0;
    Map<Double,Double> a1 = new LinkedHashMap<>();
    Map<Double,Double> a2 = new LinkedHashMap<>();
    Map<Double,Double> b1 = new LinkedHashMap<>();
    Map<Double,Double> b2 = new LinkedHashMap<>();

    public HeightPredictor(double fheight,double mheight,double cheight,double cage,String u,String g){
        fatherHeight = fheight;
        motherHeight = mheight;
        childHeight = cheight;
        childAge = cage;
        unit = u;
        gender = g;
        initialiseMapForBoysCM();
        initialiseMapForGirlsCM();
        initialiseMapForBoysFeet();
        initialiseMapForGirlsFeet();
    }
    //K - values for boys
    public void initialiseMapForBoysCM()
    {
        a1.put(2.0, 52.0);
        a1.put(2.5, 48.75);
        a1.put(3.0, 45.5);
        a1.put(3.5, 43.5);
        a1.put(4.0, 41.5);
        a1.put(4.5, 40.25);
        a1.put(5.0, 39.0);
        a1.put(5.5, 38.0);
        a1.put(6.0, 37.0);
        a1.put(6.5, 36.25);
        a1.put(7.0, 35.5);
        a1.put(7.5, 35.0);
        a1.put(8.0, 34.5);
        a1.put(8.5, 34.25);
        a1.put(9.0, 34.0);
        a1.put(9.5, 33.75);
        a1.put(10.0, 33.5);
        a1.put(10.5, 33.5);
        a1.put(11.0, 33.5);
        a1.put(11.5, 33.75);
        a1.put(12.0, 34.0);
        a1.put(12.5, 34.0);
        a1.put(13.0, 34.0);
        a1.put(13.5, 34.0);
        a1.put(14.0, 34.0);
        a1.put(14.5, 34.0);
        a1.put(15.0, 34.0);
        a1.put(15.5, 34.0);
        a1.put(16.0, 34.0);
        a1.put(16.5, 34.0);
        a1.put(17.0, 34.0);
        a1.put(17.5, 34.0);
    }
    public void initialiseMapForGirlsCM(){
        a2.put(2.0, 50.5);
        a2.put(2.5, 47.25);
        a2.put(3.0, 44.0);
        a2.put(3.5, 42.0);
        a2.put(4.0, 40.0);
        a2.put(4.5, 38.75);
        a2.put(5.0, 37.5);
        a2.put(5.5, 36.5);
        a2.put(6.0, 35.5);
        a2.put(6.5, 35.0);
        a2.put(7.0, 34.5);
        a2.put(7.5, 34.25);
        a2.put(8.0, 34.0);
        a2.put(8.5, 33.75);
        a2.put(9.0, 33.5);
        a2.put(9.5, 33.5);
        a2.put(10.0, 33.5);
        a2.put(10.5, 33.75);
        a2.put(11.0, 34.0);
        a2.put(11.5, 34.0);
        a2.put(12.0, 34.0);
        a2.put(12.5, 34.0);
        a2.put(13.0, 34.0);
        a2.put(13.5, 34.0);
        a2.put(14.0, 34.0);
        a2.put(14.5, 34.0);
        a2.put(15.0, 34.0);
        a2.put(15.5, 34.0);
        a2.put(16.0, 34.0);
        a2.put(16.5, 34.0);
        a2.put(17.0, 34.0);
        a2.put(17.5, 34.0);
    }

    void initialiseMapForBoysFeet(){
        b1.put(2.0, 1.71);
        b1.put(2.5, 1.60);
        b1.put(3.0, 1.49);
        b1.put(3.5, 1.42);
        b1.put(4.0, 1.36);
        b1.put(4.5, 1.32);
        b1.put(5.0, 1.28);
        b1.put(5.5, 1.25);
        b1.put(6.0, 1.21);
        b1.put(6.5, 1.19);
        b1.put(7.0, 1.17);
        b1.put(7.5, 1.15);
        b1.put(8.0, 1.13);
        b1.put(8.5, 1.12);
        b1.put(9.0, 1.12);
        b1.put(9.5, 1.11);
        b1.put(10.0, 1.10);
        b1.put(10.5, 1.10);
        b1.put(11.0, 1.10);
        b1.put(11.5, 1.11);
        b1.put(12.0, 1.12);
        b1.put(12.5, 1.12);
        b1.put(13.0, 1.12);
        b1.put(13.5, 1.12);
        b1.put(14.0, 1.12);
        b1.put(14.5, 1.12);
        b1.put(15.0, 1.12);
        b1.put(15.5, 1.12);
        b1.put(16.0, 1.12);
        b1.put(16.5, 1.12);
        b1.put(17.0, 1.12);
        b1.put(17.5, 1.12);
    }

    void initialiseMapForGirlsFeet(){
        b2.put(2.0, 1.66);
        b2.put(2.5, 1.55);
        b2.put(3.0, 1.44);
        b2.put(3.5, 1.38);
        b2.put(4.0, 1.31);
        b2.put(4.5, 1.27);
        b2.put(5.0, 1.23);
        b2.put(5.5, 1.20);
        b2.put(6.0, 1.17);
        b2.put(6.5, 1.15);
        b2.put(7.0, 1.13);
        b2.put(7.5, 1.12);
        b2.put(8.0, 1.12);
        b2.put(8.5, 1.11);
        b2.put(9.0, 1.10);
        b2.put(9.5, 1.10);
        b2.put(10.0, 1.10);
        b2.put(10.5, 1.11);
        b2.put(11.0, 1.12);
        b2.put(11.5, 1.12);
        b2.put(12.0, 1.12);
        b2.put(12.5, 1.12);
        b2.put(13.0, 1.12);
        b2.put(13.5, 1.12);
        b2.put(14.0, 1.12);
        b2.put(14.5, 1.12);
        b2.put(15.0, 1.12);
        b2.put(15.5, 1.12);
        b2.put(16.0, 1.12);
        b2.put(16.5, 1.12);
        b2.put(17.0, 1.12);
        b2.put(17.5, 1.12);
    }

    public double ifInCentiMeters()
    {
        double midParentalHeight,adjustmentHeight;
        if (gender.equals("Male")) {
            midParentalHeight = (fatherHeight + motherHeight + 13) / 2;
            adjustmentHeight = midParentalHeight - childHeight;
            kvalue = a1.get(childAge);
        }
        else{
            midParentalHeight = (fatherHeight+motherHeight-13)/2;
            adjustmentHeight = midParentalHeight - childHeight;
            kvalue =a2.get(childAge);
        }
        predictedHeight = childHeight + (kvalue+adjustmentHeight);

        return predictedHeight;
    }

    public double IfInFeet(){
        double midParentalHeight,adjustmentHeight;
        if (gender.equals("Male")) {
            midParentalHeight = (fatherHeight + motherHeight + 0.43) / 2;
            adjustmentHeight = midParentalHeight - childHeight;
            kvalue = b1.get(childAge);
        }
        else{
            midParentalHeight = (fatherHeight+motherHeight-0.43)/2;
            adjustmentHeight = midParentalHeight - childHeight;
            kvalue =b2.get(childAge);
        }
        predictedHeight = childHeight + (kvalue+adjustmentHeight);

        return predictedHeight;

    }

}
