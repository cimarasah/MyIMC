package com.cimarasah.myimc;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText peso;
    EditText altura;
    TextView txtIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso =  findViewById(R.id.idPeso);
        altura =  findViewById(R.id.idAltura);



    }


    public void calculaIMC(View view) {

        if(peso.getText().toString()!=null&&peso.getText().toString()!=""&&
                altura.getText().toString()!=null&&altura.getText().toString()!=""){
            double vlrPes = Double.parseDouble(peso.getText().toString()) ;
            double vlrAlt = Double.parseDouble(altura.getText().toString()) ;
            double total = vlrPes/(vlrAlt*vlrAlt);
            ImageView myImgView = (ImageView) findViewById(R.id.imgIMC);
            txtIMC = (TextView) findViewById(R.id.txtIMC);
            if(total<18.5){
                txtIMC.setText("Resultado: Abaixo do peso ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.abaixopeso));
            }else if (total<24.9){
                txtIMC.setText("Resultado: Normal ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.normal));
            }else if (total<29.9){
                txtIMC.setText("Resultado: Sebrepeso ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.sobrepeso));
            }else if (total<34.9){
                txtIMC.setText("Resultado: Obesidade 1 ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.obesidade1));
            }else if (total<39.9){
                txtIMC.setText("Resultado: Obesidade 1 ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.obesidade2));
            }else if (total>=40){
                txtIMC.setText("Resultado: Obesidade 1 ("+String.format("%.2f", total)+")");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.obesidade3));
            }else{
                txtIMC.setText("Descubra seu IMC");
                myImgView.setImageDrawable(getResources().getDrawable(R.drawable.perfil));
            }
            peso.setText("");
            altura.setText("");
        }else{
            txtIMC.setText("Digite Peso e Altura para descobrir seu IMC");
        }

    }
}
