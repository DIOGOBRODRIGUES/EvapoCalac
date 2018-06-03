package com.thunkable.android.diogo_borbar.EvapoCalc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import com.thunkable.android.diogo_borbar.EvapoCalc.equations.AllEquations;

import java.text.DecimalFormat;

public class VariableList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_list);


        Button btCotinuar = (Button)findViewById(R.id.buttonCalcular);
        btCotinuar.setOnClickListener(onClickCalcular());

               //recebe o nome do arquivo como parametro
        Bundle args = getIntent().getExtras();
        if(args.getInt("temp") == 1){
            TableRow tableRowTemp = (TableRow) findViewById(R.id.tbTempMed);
            tableRowTemp.setVisibility(View.VISIBLE);
            TableRow tableRowTempOrv = (TableRow) findViewById(R.id.tbTempOrv);
            tableRowTempOrv.setVisibility(View.VISIBLE);
            TableRow tableRowTempMax = (TableRow) findViewById(R.id.tbTempMax);
            tableRowTempMax.setVisibility(View.VISIBLE);
            TableRow tableRowTempMin = (TableRow) findViewById(R.id.tbTempMin);
            tableRowTempMin.setVisibility(View.VISIBLE);
            TableRow tableRowTempNorm = (TableRow) findViewById(R.id.tbTempNormal);
            tableRowTempNorm.setVisibility(View.VISIBLE);
        }
        if(args.getInt("Isol") == 1){
            TableRow tableRowIsol = (TableRow) findViewById(R.id.tbIsolacao);
            tableRowIsol.setVisibility(View.VISIBLE);

        }

        if(args.getInt("Rad") == 1){
            TableRow tableRowRn = (TableRow) findViewById(R.id.tbRn);
            tableRowRn.setVisibility(View.VISIBLE);
            TableRow tableRowQo = (TableRow) findViewById(R.id.tbQo);
            tableRowQo.setVisibility(View.VISIBLE);

        }
        if(args.getInt("Flux") == 1){
            TableRow tableRowG = (TableRow) findViewById(R.id.tbG);
            tableRowG.setVisibility(View.VISIBLE);

        }

        if(args.getInt("Hum") == 1){
            TableRow tableRowHum = (TableRow) findViewById(R.id.tbUmidadeRelativa);
            tableRowHum.setVisibility(View.VISIBLE);

        }

        if(args.getInt("Vel") == 1){
            TableRow tableRowVel = (TableRow) findViewById(R.id.tbVelocidaVento);
            tableRowVel.setVisibility(View.VISIBLE);

        }


        }
    private View.OnClickListener onClickCalcular(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ResultActivity.class);
                Bundle params2 = new Bundle();

                EditText edAltitude = (EditText) findViewById(R.id.editTextAltitude);
                double altitude = verificarCampoNulo(edAltitude);

                EditText edLatitude = (EditText) findViewById(R.id.editTextLatitude);
                double latitude = verificarCampoNulo(edLatitude);

                EditText edFotoperiodo = (EditText) findViewById(R.id.editTextFotoperiodo);
                double fotoperiodo = verificarCampoNulo(edFotoperiodo);

                EditText edTempMed = (EditText) findViewById(R.id.editTextTempMed);
                double tempMed = verificarCampoNulo(edTempMed);

                EditText edTempOrva = (EditText) findViewById(R.id.editTextTemOrvalho);
                double tempOrva = verificarCampoNulo(edTempOrva);

                EditText edTempMax = (EditText) findViewById(R.id.editTexTempMaxima);
                double tempMax = verificarCampoNulo(edTempMax);

                EditText edTempMin = (EditText) findViewById(R.id.editTexTempMinima);
                double tempMin = verificarCampoNulo(edTempMin);

                EditText edTempNorma = (EditText) findViewById(R.id.editTexTempNormal);
                double tempNorma = verificarCampoNulo(edTempNorma);

                EditText edIsolacao = (EditText) findViewById(R.id.editTextisolacao);
                double isolacao = verificarCampoNulo(edIsolacao);

                EditText edQo = (EditText) findViewById(R.id.editTextQo);
                double qo = verificarCampoNulo(edQo);

                EditText edRn = (EditText) findViewById(R.id.editTextRn);
                double rn = verificarCampoNulo(edRn);

                EditText edG = (EditText) findViewById(R.id.editTextG);
                double g = verificarCampoNulo(edG);

                EditText edUmidadeRelativa = (EditText) findViewById(R.id.editTextUmidadeRelativa);
                double umidadeRelativa = verificarCampoNulo(edUmidadeRelativa);

                EditText edVelocidadeVento = (EditText) findViewById(R.id.editTextVelocidaVendo);
                double velocidadeVento = verificarCampoNulo(edVelocidadeVento);

                AllEquations allEquations = new AllEquations();
                DecimalFormat df = new DecimalFormat("0.00");

                //calcular os modelos com base nas variaveis fornecidas
                String hs = String.valueOf(df.format(allEquations.hargreavesSamani(tempMax, tempMin,tempMed, qo)));
                params2.putString("Hargreaves",hs);

                String linacre = String.valueOf(df.format(allEquations.linacre(tempOrva, altitude, latitude,tempMed)));
                params2.putString("Linacre", linacre);
                intent.putExtras(params2);
                startActivity(intent);
            }
        };
    }

    private Context getContext(){
        return this;
    }
    //Verificar se o edit text está vazaio
    private double verificarCampoNulo(EditText editText){
        double valor =0;
        if(editText.getText().length()>=1){
            valor = Double.parseDouble(editText.getText().toString());
        }
        return valor;
    }
    }


