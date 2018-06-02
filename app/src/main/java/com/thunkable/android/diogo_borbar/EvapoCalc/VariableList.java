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

public class VariableList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_variable_list);

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
                Bundle params = new Bundle();

                EditText edAltitude = (EditText) findViewById(R.id.editTextAltitude);
                EditText edLatitude = (EditText) findViewById(R.id.editTextLatitude);
                EditText edFotoperiodo = (EditText) findViewById(R.id.editTextFotoperiodo);
                EditText edtTempMed = (EditText) findViewById(R.id.editTextTempMed);
                EditText edTempOrva = (EditText) findViewById(R.id.editTextTemOrvalho);
                EditText edTempMax = (EditText) findViewById(R.id.editTexTempMaxima);
                EditText edTempMin = (EditText) findViewById(R.id.editTexTempMinima);
                EditText edTempNorma = (EditText) findViewById(R.id.editTexTempNormal);
                EditText edIsolacao = (EditText) findViewById(R.id.editTextisolacao);
                EditText edQo = (EditText) findViewById(R.id.editTextQo);
                EditText edRn = (EditText) findViewById(R.id.editTextRn);
                EditText edG = (EditText) findViewById(R.id.editTextG);
                EditText edUmidadeRelativa = (EditText) findViewById(R.id.editTextUmidadeRelativa);
                EditText edVelocidadeVento = (EditText) findViewById(R.id.editTextVelocidaVendo);

                AllEquations hargreaves = new AllEquations();
                //hargreaves.hargreavesSamani(edTempMax., edTempMin,edtTempMed, edQo);

                startActivity(intent);
            }
        };
    }

    private Context getContext(){
        return this;
    }

    }


