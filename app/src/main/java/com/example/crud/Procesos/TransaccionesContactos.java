package com.example.crud.Procesos;


public class TransaccionesContactos {

    //Nombre de la base de datos
    public static final String NameDatabase = "EXAMEN_MOVIL";

    //Creación de las Tabla Contactos de la base de datos
    public static final String tablacontactos = "contactos";

    //Campos especificos de la  tabla contacto
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellido = "apellido";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    //Transacciones DDL (data definition lenguage)
    public static final String CreateTableContactos = "CREATE TABLE " + tablacontactos +
            "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "nombres TEXT, apellido TEXT, edad INTEGER, correo TEXT, direccion TEXT)";

    public static final String DropTableContactos = "DROP TABLE IF EXISTS " + tablacontactos;





}
