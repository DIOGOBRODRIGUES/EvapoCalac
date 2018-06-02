package com.thunkable.android.diogo_borbar.EvapoCalc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCotinuar = (Button)findViewById(R.id.buttonContinue);
        btCotinuar.setOnClickListener(onClickContinuar());

    }
    public void proximaTela(View view){
        Intent intent = new Intent(getContext(), activityPoliticaPrivacidade.class);
        startActivity(intent);
    }

    private View.OnClickListener onClickContinuar(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chTemp = (CheckBox)findViewById(R.id.checkBoxTemp);
                CheckBox chIsol = (CheckBox)findViewById(R.id.checkBoxIso);
                CheckBox chRad = (CheckBox)findViewById(R.id.checkBoxRad);
                CheckBox chFlux = (CheckBox)findViewById(R.id.checkBoxFlux);
                CheckBox chHum = (CheckBox)findViewById(R.id.checkBoxHum);
                CheckBox chVel = (CheckBox)findViewById(R.id.checkBoxVel);
                Intent intent = new Intent(getContext(), VariableList.class);
                Bundle params = new Bundle();

                if (chTemp.isChecked()){
                    params.putInt("temp",1);
                    intent.putExtras(params);
                }
                if (chIsol.isChecked()){
                    params.putInt("Isol",1);
                    intent.putExtras(params);
                }
                if (chRad.isChecked()){
                    params.putInt("Rad",1);
                    intent.putExtras(params);
                }
                if (chFlux.isChecked()){
                    params.putInt("Flux",1);
                    intent.putExtras(params);
                }
                if (chHum.isChecked()){
                    params.putInt("Hum",1);
                    intent.putExtras(params);
                }
                if (chVel.isChecked()){
                    params.putInt("Vel",1);
                    intent.putExtras(params);
                }
                startActivity(intent);


            }
        };
    }

    private Context getContext(){
        return this;
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}
