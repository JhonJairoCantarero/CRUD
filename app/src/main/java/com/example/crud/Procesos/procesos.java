package com.example.crud.Procesos;


public class procesos {
    /* Tablas */
    public static final String tablaContactos = "contactos";

    /*tabla contactos */
    public static final String idContacto = "idContacto";
    public static final String nombreContacto = "nombreContacto";
    public static final String apellidoContacto = "apellidoContacto";
    public static final String edadContacto = "edadContacto";
    public static final String correoContacto = "correoContacto";
    public static final String direccionContacto = "direccionContacto";


    /* CRUD */

    public static final String CreateTableContactos =
            "CREATE TABLE contactos( idContacto INTEGER PRIMARY KEY AUTOINCREMENT, nombreContacto TEXT," +
                    " apellidoContacto TEXT," +
                    " edadContacto INTEGER, " +
                    "correoContacto TEXT," +
                    "direccionContacto TEXT)";

    public static final String DropTableContactos =
            "DROP TABLE IF EXITS contactos";

    /* Base de Datos */
    public static final String NameDataBase = "CRUD";
}
