package com.example.childheightpredictorbyakshai;

public class GetTheAge {
    double age;
    String fromAge;
    public GetTheAge(String aa){
        fromAge =aa;
    }

    public double getAgeValue(){
        switch (fromAge){
            case "2 years":
                age = 2.0; break;
            case "2.5 years":
                age = 2.5; break;
            case "3 years":
                age = 3.0; break;
            case "3.5 years":
                age = 3.5; break;
            case "4 years":
                age = 4.0; break;
            case "4.5 years":
                age = 4.5; break;
            case "5 years":
                age = 5.0; break;
            case "5.5 years":
                age = 5.5; break;
            case "6 years":
                age = 6.0; break;
            case "6.5 years":
                age = 6.5; break;
            case "7 years":
                age = 7.0; break;
            case "7.5 years":
                age = 7.5; break;
            case "8 years":
                age = 8.0; break;
            case "8.5 years":
                age = 8.5; break;
            case "9 years":
                age = 9.0; break;
            case "9.5 years":
                age = 9.5; break;
            case "10 years":
                age = 10.0; break;
            case "10.5 years":
                age = 10.5; break;
            case "11 years":
                age = 11.0; break;
            case "11.5 years":
                age = 11.5; break;
            case "12 years":
                age = 12.0; break;
            case "12.5 years":
                age = 12.5; break;
            case "13 years":
                age = 13.0; break;
            case "13.5 years":
                age = 13.5; break;
            case "14 years":
                age = 14.0; break;
            case "14.5 years":
                age = 14.5; break;
            case "15 years":
                age = 15.0; break;
            case "15.5 years":
                age = 15.5; break;
            case "16 years":
                age = 16.0; break;
            case "16.5 years":
                age = 16.5; break;
            case "17 years":
                age = 17.0; break;
            case "17.5 years":
                age = 17.5; break;
        }
        return age;
    }
}
