package com.thunkable.android.diogo_borbar.EvapoCalc.equations;

public class AllEquations {


    public double hargreavesSamani(double tmax, double tmin, double tmed, double qo){
            double hS= 0.0023*qo*Math.pow((tmax-tmin),0.5)*(17.8+tmed);
        return hS;
    }

    public double linacre(double tempOrv, double altitude, double latitude, double tmed){
            double ln = ((500*(tmed+0.006*altitude)/(100-latitude))+15*(tmed-tempOrv))/(80-tmed);
        return ln;
    }


}
