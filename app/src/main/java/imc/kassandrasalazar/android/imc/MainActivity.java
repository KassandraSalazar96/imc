package imc.kassandrasalazar.android.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText mCampoPeso ;
    private EditText mCampoEstatura;
    private Button mBotonCalcular;
    private Button mBotonLimpiar;
    private TextView mEtiquetaimc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCampoPeso = (EditText) v.findViewById(R.id.campo_peso);
        mCampoEstatura = (EditText) v.findViewById(R.id.campo_estatura);
        mBotonCalcular = (Button) v.findViewById(R.id.boton_calcular);
        mBotonLimpiar = (Button) v.findViewById(R.id.boton_limpiar);
        mEtiquetaimc = (TextView) v.findViewById(R.id.etiqueta_imc);

        mBotonCalcular.setOnContextClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               String s = mCampoPeso.getText().toString();
               double peso = Double.parseDouble(s);
               s = mCampoEstatura.getText().toString();
               double estatura = Double.parseDouble(s);
               double imc = peso / (estatura * estatura);
               s = String.format("%2.2f", imc);
               mEtiquetaimc.setText(s);
           }
             });
        mBotonLimpiar.setOnContextClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mCampoPeso.setText("");
                mCampoEstatura.setText("");
                mEtiquetaimc.setText("0.0");
            }
        });



     }
}
