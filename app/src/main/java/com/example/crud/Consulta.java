package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.crud.Procesos.SQLiteConexion;
import com.example.crud.Procesos.TransaccionesContactos;
import com.example.crud.tablas.Contactar;

public class Consulta extends AppCompatActivity {
    TextView codigo;
    EditText pais, nombre, apellido,edad,correo,direccion, nota, num, nom;
    Button btnActualiza;
    Button btnElimi;
    Button btnLLamar;
    Button btnRegres;
    Button btnCompartirAC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        codigo = (TextView) findViewById(R.id.AClId);
        nombre = (EditText) findViewById(R.id.ACNommm);
        apellido = (EditText) findViewById(R.id.ACApellido);
        edad = (EditText) findViewById(R.id.ACEdad);
        correo = (EditText) findViewById(R.id.ACCorreo);
        direccion = (EditText) findViewById(R.id.ACDireccion);

        btnActualiza = (Button) findViewById(R.id.ACtnRegresar);
        Bundle obj = getIntent().getExtras();

        Contactar conta = null;

        if (obj != null) {
            conta = (Contactar) obj.getSerializable("contacto");

            codigo.setText(conta.getId().toString());
            nombre.setText(conta.getNombres().toString());
            apellido.setText(conta.getApellido().toString());
            edad.setText(conta.getEdad().toString());
            correo.setText(conta.getCorreo().toString());
            direccion.setText(conta.getDireccion().toString());
        }

        btnActualiza = (Button) findViewById(R.id.ACbtnActualizar2);
        btnActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModificarPersonas();
            }
        });

        btnElimi = (Button) findViewById(R.id.ACbtnEliminar);
        btnElimi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EliminarContactos();
            }
        });

        btnRegres = (Button) findViewById(R.id.ACtnRegresar);
        btnRegres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Consulta.this, RegistrosActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    private void ModificarPersonas() {
        SQLiteConexion conexion = new SQLiteConexion(this, TransaccionesContactos.NameDatabase,null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String cod = codigo.getText().toString();

        ContentValues valores = new ContentValues();

        valores.put(TransaccionesContactos.nombres, nombre.getText().toString());
        valores.put(TransaccionesContactos.apellido, apellido.getText().toString());
        valores.put(TransaccionesContactos.edad, edad.getText().toString());
        valores.put(TransaccionesContactos.correo, correo.getText().toString());
        valores.put(TransaccionesContactos.direccion, direccion.getText().toString());

        if (!codigo.getText().toString().isEmpty()){
            db.update("contactos", valores, "id=" + cod, null);
            Toast.makeText(this, "Se Actualizo el Registro: " +cod, Toast.LENGTH_LONG).show();
        }
    }

    private void EliminarContactos() {

        SQLiteConexion conexion = new SQLiteConexion(this, TransaccionesContactos.NameDatabase,null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        String cod = codigo.getText().toString();

        db.delete("contactos", "id=" + cod, null);
        Toast.makeText(this, "Regristo " + cod + " Eliminado Correctamente", Toast.LENGTH_LONG).show();

        db.close();
        LimpiarPantalla();

        Intent intent = new Intent(Consulta.this, RegistrosActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();

    }

    private void LimpiarPantalla() {
        codigo.setText("");
        nombre.setText("");
        apellido.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}