package com.example.crud;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.crud.Procesos.SQLiteConexion;
import com.example.crud.Procesos.TransaccionesContactos;

import java.util.ArrayList;

public class NuevoRegistro extends AppCompatActivity {
    EditText id, txtNombre,txtApellido,txtEdad,txtCorreo,txtDireccion;
    Button btnGuardarContactos;
    Button btnContactosSalvados;
    Button btnAgregarPais;
    ImageView ivFoto;
    Button btnTomarFoto, btnSeleccionarImagen,btnGuardar;
    Uri imagenUri;
    int TOMAR_FOTO = 100;
    int SELEC_IMAGEN = 200;
    String CARPETA_RAIZ = "MisFotosApp";
    String CARPETAS_IMAGENES = "imagenes";
    String RUTA_IMAGEN = CARPETA_RAIZ + CARPETAS_IMAGENES;
    String path;
    //
    SQLiteConexion conexion;
    Spinner spPaises;
    ArrayList<String> lista_paises;
    String spin; //Contenido del pais seleccionado en el Spinner.
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_registro);

        /* CASTEO DE ELEMENTOS DE LA INTERFAZ GRAFICA*/
        init();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AgregarEmpleado();
            }
        });
    }
    public void Regresar(View view){
        Intent i = new Intent(this,RegistrosActivity.class);
        startActivity(i);
    }
    private void init(){
        txtNombre = (EditText) findViewById(R.id.txtnom);
        txtApellido = (EditText) findViewById(R.id.txtnape);
        txtEdad = (EditText) findViewById(R.id.txted);
        txtCorreo = (EditText) findViewById(R.id.txtcorre);
        txtDireccion = (EditText) findViewById(R.id.txtdirec);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
    }
    private void AgregarEmpleado()
    {
        /*CONEXION A INSERCION A LA BASE DE DATOS*/
        SQLiteConexion conexion = new SQLiteConexion(this, TransaccionesContactos.NameDatabase,null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(TransaccionesContactos.nombres,txtNombre.getText().toString());
        valores.put(TransaccionesContactos.apellido,txtApellido.getText().toString());
        valores.put(TransaccionesContactos.edad,txtEdad.getText().toString());
        valores.put(TransaccionesContactos.correo,txtCorreo.getText().toString());
        valores.put(TransaccionesContactos.direccion,txtDireccion.getText().toString());
        Long RESULTADO = db.insert(TransaccionesContactos.tablacontactos,TransaccionesContactos.id, valores);
        Toast.makeText(getApplicationContext(), "REGISTRO INGRESADO", Toast.LENGTH_LONG).show();
        db.close();
        ClearScreen();
    }
    private void ClearScreen(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
    }
}