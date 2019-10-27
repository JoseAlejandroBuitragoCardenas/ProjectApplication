package uan.edu.co.projectapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nombreEvento, ubicacion, fechadesde, horadesde, fechahasta, horahasta;
    private EditText descripcion;
    private Button guardar, cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nombreEvento = (EditText) findViewById(R.id.edtNombreEvento);
        ubicacion = (EditText) findViewById(R.id.edtUbicacion);
        fechadesde = (EditText) findViewById(R.id.edtFechaDesde);
        horadesde = (EditText) findViewById(R.id.edtHoraInicio);
        fechahasta = (EditText) findViewById(R.id.edtFechaHasta);
        horahasta = (EditText) findViewById(R.id.edtHoraHasta);
        descripcion = (EditText) findViewById(R.id.edtDescripcion);

        Bundle bundle = getIntent().getExtras();
        int dia=0, mes=0, anio=0;
        dia=bundle.getInt("dia");
        mes=bundle.getInt("mes");
        anio=bundle.getInt("anio");

        fechadesde.setText(dia+"/"+mes+"/"+anio);
        fechahasta.setText(dia+"/"+mes+"/"+anio);

        guardar = (Button) findViewById(R.id.btnGuardar);
        cancelar = (Button) findViewById(R.id.btnCancelar);

        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == guardar.getId()){
            //Guardar los datos de las cajas de Texto
            DBSQLite db = new DBSQLite(getApplication(), "Historico",null,1 );
            SQLiteDatabase bd = db.getWritableDatabase();

            String sql ="insert into eventos" +
                    "(nombreEvento, ubicacion, fechadesde, horadesde, fechahasta, horahasta," +
                    "desscripcion) values('"+
                    nombreEvento.getText()+
                    "','"+ubicacion.getText()+
                    "','"+fechadesde.getText()+
                    "','"+horadesde.getText()+
                    "','"+fechahasta.getText()+
                    "','"+horahasta.getText()+
                    "','"+descripcion.getText()+ ")";

            try {
                bd.execSQL(sql);

                nombreEvento.setText("");
                ubicacion.setText("");
                fechadesde.setText("");
                horadesde.setText("");
                fechahasta.setText("");
                horahasta.setText("");
                descripcion.setText("");

            }catch (Exception e){
                Toast.makeText(getApplication(),"Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }else {
            this.finish();
            return;
        }
    }
}
