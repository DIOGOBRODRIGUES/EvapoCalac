package com.thunkable.android.diogo_borbar.EvapoCalc.equations;

public class AllEquations {

    public double hargreavesSamani(double tmax, double tmin, double tmed, double qo){
            double hS= 0.0023*qo*Math.pow((tmax-tmin),0.5)*(17.8+tmed);
        return hS;
    }

}
