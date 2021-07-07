package com.example.androidproject.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;

import com.example.androidproject.Classes.Administrateur;
import com.example.androidproject.Classes.Cabine;
import com.example.androidproject.Classes.Centre;
import com.example.androidproject.Classes.Infermier;
import com.example.androidproject.Classes.Medecin;
import com.example.androidproject.Classes.Patient;
import com.example.androidproject.Classes.Reservation;
import com.example.androidproject.Classes.Status;
import com.example.androidproject.Classes.Vaccin;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Evax.db";


    /*  Tables list  */
    // PATIENT table name
    private static final String TABLE_PATIENT= "patient";
    // MEDECIN table name
    private static final String TABLE_MEDECIN= "medecin";
    // INFERMIER table name
    private static final String TABLE_INFERMIER= "infermier";
    // PATIENT table name
    private static final String TABLE_STATUS= "status";
    // ADMINISTRATEUR table name
    private static final String TABLE_ADMINISTRATEUR= "administrateur";
    // CABINE table name
    private static final String TABLE_CABINE= "cabine";
    // CENTRE table name
    private static final String TABLE_CENTRE= "centre";
    // RESERVATION table name
    private static final String TABLE_RESERVATION= "reservation";
    // VACCIN table name
    private static final String TABLE_VACCIN= "vaccin";


    //STATUS Table columns names
    private static final String COLUMN_STATUS_ID = "status_id";
    private static final String COLUMN_STATUS_NAME = "status_name";

    //CENTRE Table Columns names
    private static final String COLUMN_CENTRE_ID = "centre_id";
    private static final String COLUMN_CENTRE_NAME = "centre_name";
    private static final String COLUMN_CENTRE_EMPLACEMENT="centre_emplacement";


    //ADMIN Table Columns names
    private static final String COLUMN_ADMIN_ID = "admin_id";
    private static final String COLUMN_ADMIN_EMAIL = "admin_email";
    private static final String COLUMN_ADMIN_PASSWORD="admin_password";

    //CABINE Table Columns names
    private static final String COLUMN_CABINE_ID = "centre_id";
    private static final String COLUMN_CABINE_NAME = "centre_nom";
    private static final String COLUMN_CABINE_CENTRE="centre_cabine_id";


    //VACCIN Table Columns names
    private static final String COLUMN_VACCIN_ID="vaccin_id";
    private static final String COLUMN_VACCIN_REF="vaccin_ref";
    private  static final String COLUMN_VACCIN_NAME="vaccin_name";
    private static final String COLUMN_VACCIN_QTE ="vaccin_qte";


    // INFERMIER Table Columns names
    private static final String COLUMN_INFERMIER_ID = "infermier_id";
    private static final String COLUMN_INFERMIER_NOM = "infermier_nom";
    private static final String COLUMN_INFERMIER_PRENOM = "infermier_prenom";
    private  static final String COLUMN_INFERMIER_CIN = "infermier_cin";
    private static final String COLUMN_INFERMIER_EMAIL = "infermier_email";
    private static final String COLUMN_INFERMIER_DATENAISSANCE = "infermier_datenaissance";
    private static final String COLUMN_INFERMIER_PASSWORD = "infermier_password";
    private static final String COLUMN_INFERMIER_TELEPHONE = "infermier_telephone";
    private static final String COLUMN_INFERMIER_MATRICULE = "infermier_matricule";
    private static final String COLUMN_INFERMIER_CENTRE_ID = "infermier_centre_id";



    // PATIENT Table Columns names
    private static final String COLUMN_PATIENT_ID = "PATIENT_id";
    private static final String COLUMN_PATIENT_NOM = "PATIENT_nom";
    private static final String COLUMN_PATIENT_PRENOM = "PATIENT_preom";
    private static final String COLUMN_PATIENT_CIN="PATIENT_cin";
    private static final String COLUMN_PATIENT_PHONE = "PATIENT_phone";
    private static final String COLUMN_PATIENT_EMAIL = "PATIENT_email";
    private static final String COLUMN_PATIENT_BIRTHDAY = "PATIENT_birthday";
    private static final String COLUMN_PATIENT_PASSWORD = "PATIENT_password";
    private static final String COLUMN_PATIENT_STATUS = "PATIENT_status";
    private static final String COLUMN_PATIENT_NBRVCCN = "PATIENT_nbrvccn";
    private static final String COLUMN_PATIENT_VACCIN_ID = "PATIENT_vaccin_id";
    private static final String COLUMN_PATIENT_CENTRE_ID= "PATIENT_centre_id";




    // MEDECIN Table Columns names
    private static final String COLUMN_MEDECIN_ID = "MEDECIN_id";
    private static final String COLUMN_MEDECIN_MATRICULE = "MEDECIN_matricule";
    private static final String COLUMN_MEDECIN_cin = "MEDECIN_cin";
    private static final String COLUMN_MEDECIN_NOM = "MEDECIN_nom";
    private static final String COLUMN_MEDECIN_PRENOM = "MEDECIN_prenom";
    private static final String COLUMN_MEDECIN_PHONE = "MEDECIN_phone";
    private static final String COLUMN_MEDECIN_EMAIL = "MEDECIN_email";
    private static final String COLUMN_MEDECIN_BIRTHDAY = "MEDECIN_birthday";
    private static final String COLUMN_MEDECIN_PASSWORD = "MEDECIN_password";
    private static final String COLUMN_MEDECIN_SPECIALITE = "MEDECIN_specialite";
    private static final String COLUMN_MEDECIN_CENTRE_ID= "MEDECIN_centre_id";


    // RESERVATION Table Columns names
    private static final String COLUMN_RESERVATION_ID = "RESERVATION_id";
    private static final String COLUMN_RESERVATION_DATE = "RESERVATION_DATE";
    private static final String COLUMN_RESERVATION_PATIENT_ID = "RESERVATION_PATIENT_ID";
    private static final String COLUMN_RESERVATION_MEDECIN_ID = "RESERVATION_MEDECIN_ID";
    private static final String COLUMN_RESERVATION_INFERMIER_ID = "RESERVATION_INFERMIER_ID";
    private static final String COLUMN_RESERVATION_CENTRE_ID = "RESERVATION_CENTRE_ID";



    // create STATUS table sql query
    private String CREATE_STATUS_TABLE = "CREATE TABLE " + TABLE_STATUS+ "("
            + COLUMN_STATUS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_STATUS_NAME + " TEXT"  + ")";


    // create CENTRE table sql query
    private String CREATE_CENTRE_TABLE = "CREATE TABLE " + TABLE_CENTRE+ "("
            + COLUMN_CENTRE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CENTRE_NAME + " TEXT,"
            + COLUMN_CENTRE_EMPLACEMENT + " TEXT" + ")";


    // create ADMIN table sql query
    private String CREATE_ADMIN_TABLE = "CREATE TABLE " + TABLE_ADMINISTRATEUR+ "("
            + COLUMN_ADMIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_ADMIN_EMAIL + " TEXT,"
            + COLUMN_ADMIN_PASSWORD + " TEXT" + ")";



    // create Cabine table sql query
    private String CREATE_CABINE_TABLE = "CREATE TABLE " + TABLE_CABINE+ "("
            + COLUMN_CABINE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CABINE_NAME + " TEXT "+")";



    // create Vaccin sql query
    private String CREATE_VACCIN_TABLE = "CREATE TABLE " + TABLE_VACCIN+ "("
            + COLUMN_VACCIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_VACCIN_NAME + " TEXT,"
            + COLUMN_VACCIN_REF + " TEXT," + COLUMN_VACCIN_QTE + " INTEGER"+ ")";

    // create Medecin sql query

    private String CREATE_MEDECIN_TABLE = "CREATE TABLE " + TABLE_MEDECIN+ "("
            + COLUMN_MEDECIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_MEDECIN_MATRICULE + " TEXT,"
            + COLUMN_MEDECIN_cin + " TEXT," + COLUMN_MEDECIN_NOM + " TEXT,"  + COLUMN_MEDECIN_PRENOM + " TEXT,"
            + COLUMN_MEDECIN_PHONE + " TEXT," + COLUMN_MEDECIN_EMAIL + " TEXT,"  + COLUMN_MEDECIN_BIRTHDAY + " TEXT,"
            + COLUMN_MEDECIN_PASSWORD + " TEXT," + COLUMN_MEDECIN_SPECIALITE + " TEXT,"+ COLUMN_MEDECIN_CENTRE_ID + " INTEGER,"
            + "FOREIGN KEY ("+COLUMN_MEDECIN_CENTRE_ID+") REFERENCES " + TABLE_CENTRE + "("+COLUMN_CENTRE_ID+ ")" +
            ")";



    // create Infermier sql query

    private String CREATE_INFERMIER_TABLE = "CREATE TABLE " + TABLE_INFERMIER+ "("
            + COLUMN_INFERMIER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_INFERMIER_NOM + " TEXT,"+COLUMN_INFERMIER_CIN + " INTEGER,"
            + COLUMN_INFERMIER_PRENOM + " TEXT," + COLUMN_INFERMIER_EMAIL + " TEXT,"  + COLUMN_INFERMIER_DATENAISSANCE + " TEXT,"
            + COLUMN_INFERMIER_PASSWORD + " TEXT," + COLUMN_INFERMIER_TELEPHONE + " INTEGER,"  + COLUMN_INFERMIER_MATRICULE + " INTEGER,"
            + COLUMN_INFERMIER_CENTRE_ID + " INTEGER,"
            + "FOREIGN KEY ("+COLUMN_INFERMIER_CENTRE_ID+") REFERENCES " + TABLE_CENTRE + "("+COLUMN_CENTRE_ID+ ")" +
            ")";

    // create Patient sql query

    private String CREATE_PATIENT_TABLE = "CREATE TABLE " + TABLE_PATIENT+ "("
            + COLUMN_PATIENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_PATIENT_NOM + " TEXT,"+ COLUMN_PATIENT_PRENOM + " TEXT,"+ COLUMN_PATIENT_CIN + " TEXT,"
            + COLUMN_PATIENT_PHONE + " TEXT," + COLUMN_PATIENT_EMAIL + " TEXT,"  + COLUMN_PATIENT_BIRTHDAY + " TEXT,"
            + COLUMN_PATIENT_PASSWORD + " TEXT," + COLUMN_PATIENT_STATUS + " INTEGER,"  + COLUMN_PATIENT_NBRVCCN + " INTEGER,"
            + COLUMN_PATIENT_VACCIN_ID + " INTEGER," + COLUMN_PATIENT_CENTRE_ID + " INTEGER,"
            + "FOREIGN KEY ("+COLUMN_PATIENT_VACCIN_ID+") REFERENCES " + TABLE_VACCIN + "("+COLUMN_VACCIN_ID+"),"
            + "FOREIGN KEY ("+COLUMN_PATIENT_CENTRE_ID+") REFERENCES " + TABLE_CENTRE + "("+COLUMN_CENTRE_ID+")"+
            ")";





    // create Reservation sql query

    private String CREATE_RESERVATION_TABLE = "CREATE TABLE " + TABLE_RESERVATION+ "("
            + COLUMN_RESERVATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_RESERVATION_DATE + " TEXT,"
            + COLUMN_RESERVATION_INFERMIER_ID + " INTEGER," + COLUMN_RESERVATION_MEDECIN_ID + " INTEGER,"  + COLUMN_RESERVATION_PATIENT_ID + " INTEGER,"
            +COLUMN_RESERVATION_CENTRE_ID+ " INTEGER,"
            + "FOREIGN KEY ("+COLUMN_RESERVATION_INFERMIER_ID+") REFERENCES " + TABLE_INFERMIER + "("+COLUMN_INFERMIER_ID+") ,"
            + "FOREIGN KEY ("+COLUMN_RESERVATION_PATIENT_ID+") REFERENCES " + TABLE_PATIENT + "("+COLUMN_PATIENT_ID+") ,"
            + "FOREIGN KEY ("+COLUMN_RESERVATION_MEDECIN_ID+") REFERENCES " + TABLE_MEDECIN + "("+COLUMN_MEDECIN_ID+"),"
            + "FOREIGN KEY ("+COLUMN_RESERVATION_CENTRE_ID+") REFERENCES " + TABLE_CENTRE + "("+COLUMN_CENTRE_ID+")"+
            ")";



    // drop table sql query
    private String DROP_PATIENT_TABLE = "DROP TABLE IF EXISTS " + TABLE_PATIENT;
    private String DROP_MEDECIN_TABLE = "DROP TABLE IF EXISTS " + TABLE_MEDECIN;
    private String DROP_INFERMIER_TABLE = "DROP TABLE IF EXISTS " + TABLE_INFERMIER;
    private String DROP_RESERVATION_TABLE = "DROP TABLE IF EXISTS " + TABLE_RESERVATION;
    private String DROP_ADMINISTRATEUR_TABLE = "DROP TABLE IF EXISTS " + TABLE_ADMINISTRATEUR;
    private String DROP_CABINE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CABINE;
    private String DROP_CENTRE_TABLE = "DROP TABLE IF EXISTS " + TABLE_CENTRE;
    private String DROP_STATUS_TABLE = "DROP TABLE IF EXISTS " + TABLE_STATUS;
    private String DROP_VACCIN_TABLE = "DROP TABLE IF EXISTS " + TABLE_VACCIN;




    /**
     * Constructor
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Drop ALL Table if exist
        db.execSQL(DROP_PATIENT_TABLE);
        db.execSQL(DROP_ADMINISTRATEUR_TABLE);
        db.execSQL(DROP_CABINE_TABLE);
        db.execSQL(DROP_CENTRE_TABLE);
        db.execSQL(DROP_INFERMIER_TABLE);
        db.execSQL(DROP_RESERVATION_TABLE);
        db.execSQL(DROP_VACCIN_TABLE);
        db.execSQL(DROP_MEDECIN_TABLE);
        db.execSQL(DROP_STATUS_TABLE);

        db.execSQL(CREATE_STATUS_TABLE);
        db.execSQL(CREATE_CENTRE_TABLE);
        db.execSQL(CREATE_ADMIN_TABLE);
        db.execSQL(CREATE_CABINE_TABLE);
        db.execSQL(CREATE_INFERMIER_TABLE);
        db.execSQL(CREATE_PATIENT_TABLE);
        db.execSQL(CREATE_MEDECIN_TABLE);
        db.execSQL(CREATE_VACCIN_TABLE);
        db.execSQL(CREATE_RESERVATION_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop ALL Table if exist
        db.execSQL(DROP_PATIENT_TABLE);
        db.execSQL(DROP_ADMINISTRATEUR_TABLE);
        db.execSQL(DROP_CABINE_TABLE);
        db.execSQL(DROP_CENTRE_TABLE);
        db.execSQL(DROP_INFERMIER_TABLE);
        db.execSQL(DROP_RESERVATION_TABLE);
        db.execSQL(DROP_VACCIN_TABLE);
        db.execSQL(DROP_MEDECIN_TABLE);
        db.execSQL(DROP_STATUS_TABLE);

        // Create tables again
        onCreate(db);

    }



    /**
     * This method is to create PATIENTrecord
     *
     */

    public void addPATIENT(Patient PATIENT) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PATIENT_NOM, PATIENT.getNom());
        values.put(COLUMN_PATIENT_PRENOM, PATIENT.getPrenom());
        values.put(COLUMN_PATIENT_CIN, PATIENT.getCin());
        values.put(COLUMN_PATIENT_PASSWORD, PATIENT.getPassword());
        values.put(COLUMN_PATIENT_BIRTHDAY, PATIENT.getBirthday());
        values.put(COLUMN_PATIENT_EMAIL, PATIENT.getEmail());
        values.put(COLUMN_PATIENT_PHONE,PATIENT.getPhone());
        values.put(COLUMN_PATIENT_NBRVCCN,PATIENT.getNbr_vaccin());
        values.put(COLUMN_PATIENT_STATUS,PATIENT.getStatus());

        // Inserting Row
        db.insert(TABLE_PATIENT, null, values);
        //db.close();
    }


    public void addMedecin(Medecin Medecin) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MEDECIN_NOM, Medecin.getNom());
        values.put(COLUMN_MEDECIN_PRENOM, Medecin.getPrenom());
        values.put(COLUMN_MEDECIN_BIRTHDAY, Medecin.getDate_naissance());
        values.put(COLUMN_MEDECIN_cin, Medecin.getCin());
        values.put(COLUMN_MEDECIN_EMAIL, Medecin.getEmail());
        values.put(COLUMN_MEDECIN_MATRICULE, Medecin.getMatricule());
        values.put(COLUMN_MEDECIN_PASSWORD, Medecin.getPassword());
        values.put(COLUMN_MEDECIN_SPECIALITE,Medecin.getSpecialite());
        values.put(COLUMN_MEDECIN_PHONE,Medecin.getTelephone());
        values.put(COLUMN_MEDECIN_CENTRE_ID,Medecin.getId_centre());

        // Inserting Row
        db.insert(TABLE_MEDECIN, null, values);
        //db.close();
    }

    public void addCentre (Centre centre) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_CENTRE_NAME, centre.getNom());
        values.put(COLUMN_CENTRE_EMPLACEMENT, centre.getEmplacement());


        // Inserting Row
        db.insert(TABLE_CENTRE, null, values);
        //db.close();
    }

    public void addAdministrateur(Administrateur administrateur)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADMIN_EMAIL, administrateur.getEmail());
        values.put(COLUMN_ADMIN_PASSWORD,administrateur.getPassword());


        // Inserting Row
        db.insert(TABLE_ADMINISTRATEUR, null, values);
        //db.close();
    }


    public void addINFERMIER(Infermier INFERMIER) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_INFERMIER_MATRICULE, INFERMIER.getMatricule());
        values.put(COLUMN_INFERMIER_CIN, INFERMIER.getCin());
        values.put(COLUMN_INFERMIER_NOM, INFERMIER.getNom());
        values.put(COLUMN_INFERMIER_PRENOM, INFERMIER.getPrenom());
        values.put(COLUMN_INFERMIER_PASSWORD, INFERMIER.getPassword());
        values.put(COLUMN_INFERMIER_DATENAISSANCE, INFERMIER.getDate_naissance());
        values.put(COLUMN_INFERMIER_EMAIL, INFERMIER.getEmail());
        values.put(COLUMN_INFERMIER_TELEPHONE,INFERMIER.getTelephone());
        values.put(COLUMN_INFERMIER_CENTRE_ID,INFERMIER.getId_centre());
        // Inserting Row
        db.insert(TABLE_INFERMIER, null, values);
        //db.close();
    }


    public void addCabine(Cabine cabine)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CABINE_NAME,cabine.getNom());
        values.put(COLUMN_CABINE_CENTRE,cabine.getId_centre());
        // Inserting Row
        db.insert(TABLE_CENTRE, null, values);
        //db.close();
    }


    public void addVaccin(Vaccin vaccin)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_VACCIN_NAME,vaccin.getNom());
        values.put(COLUMN_VACCIN_REF,vaccin.getRef());
        values.put(COLUMN_VACCIN_QTE,vaccin.getQte());

        // Inserting Row
        db.insert(TABLE_VACCIN, null, values);
        //db.close();

    }


    public void addStatus(Status status)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_STATUS_NAME,status.getStatus());

        // Inserting Row
        db.insert(TABLE_STATUS, null, values);
        //db.close();

    }




    public void addReservation(Reservation reservation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_RESERVATION_DATE,reservation.getDate());
        values.put(COLUMN_RESERVATION_INFERMIER_ID,reservation.getId_infermier());
        values.put(COLUMN_RESERVATION_MEDECIN_ID,reservation.getId_medecin());
        values.put(COLUMN_RESERVATION_CENTRE_ID,reservation.getId_centre());
        values.put(COLUMN_RESERVATION_PATIENT_ID,reservation.getId_patient());

        // Inserting Row
        db.insert(TABLE_RESERVATION, null, values);
        //db.close();

    }


    /**
     * This method is to fetch all PATIENTand return the list of PATIENTrecords
     *
     * @return list
     */
    public List<Patient> getAllPATIENT() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID,
                COLUMN_PATIENT_NOM,
                COLUMN_PATIENT_PRENOM,
                COLUMN_PATIENT_CIN,
                COLUMN_PATIENT_EMAIL,
                COLUMN_PATIENT_PASSWORD,
                COLUMN_PATIENT_PHONE,
                COLUMN_PATIENT_STATUS,
                COLUMN_PATIENT_BIRTHDAY,
                COLUMN_PATIENT_NBRVCCN

        };
        // sorting orders
        String sortOrder =
                COLUMN_PATIENT_NOM + " ASC";
        List<Patient> PATIENTList = new ArrayList<Patient>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.query(TABLE_PATIENT, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient PATIENT = new Patient();
                PATIENT.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_ID))));
                PATIENT.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_NOM)));
                PATIENT.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PRENOM)));
                PATIENT.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_EMAIL)));
                PATIENT.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_CIN)));
                PATIENT.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PASSWORD)));
                PATIENT.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_BIRTHDAY)));
                PATIENT.setNbr_vaccin(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_NBRVCCN)));
                PATIENT.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PHONE)));
                // Adding PATIENT record to list
                PATIENTList.add(PATIENT);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        return PATIENTList;
    }


    public List<Infermier> getAllInfermier() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_INFERMIER_ID,
                COLUMN_INFERMIER_CIN,
                COLUMN_INFERMIER_EMAIL,
                COLUMN_INFERMIER_DATENAISSANCE,
                COLUMN_INFERMIER_MATRICULE,
                COLUMN_INFERMIER_NOM,
                COLUMN_INFERMIER_PRENOM,
                COLUMN_INFERMIER_PASSWORD,
                COLUMN_INFERMIER_TELEPHONE,
                COLUMN_INFERMIER_CENTRE_ID


        };
        // sorting orders
        String sortOrder =
                COLUMN_INFERMIER_NOM + " ASC";
        List<Infermier> infermiers = new ArrayList<Infermier>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.query(TABLE_INFERMIER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Infermier infermier = new Infermier();
                infermier.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_ID))));
                infermier.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_NOM)));
                infermier.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_PRENOM)));
                infermier.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_EMAIL)));
                infermier.setCin(cursor.getInt(cursor.getColumnIndex(COLUMN_INFERMIER_CIN)));
                infermier.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_PASSWORD)));
                infermier.setDate_naissance(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_DATENAISSANCE)));
                infermier.setTelephone(cursor.getString(cursor.getColumnIndex(COLUMN_INFERMIER_TELEPHONE)));
                infermier.setId_centre(cursor.getInt(cursor.getColumnIndex(COLUMN_INFERMIER_CENTRE_ID)));
                // Adding PATIENT record to list
                infermiers.add(infermier);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        return infermiers;
    }




    /**
     * This method is to fetch all PATIENTand return the list of PATIENTrecords
     *
     * @return list
     */
    public List<Medecin> getAllmedecin() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_MEDECIN_ID,
                COLUMN_MEDECIN_NOM,
                COLUMN_MEDECIN_PRENOM,
                COLUMN_MEDECIN_cin,
                COLUMN_MEDECIN_EMAIL,
                COLUMN_MEDECIN_PASSWORD,
                COLUMN_MEDECIN_BIRTHDAY,
                COLUMN_MEDECIN_CENTRE_ID,
                COLUMN_MEDECIN_MATRICULE,
                COLUMN_MEDECIN_PHONE,
                COLUMN_MEDECIN_SPECIALITE

        };
        // sorting orders
        String sortOrder =
                COLUMN_MEDECIN_NOM + " ASC";
        List<Medecin> MedList = new ArrayList<Medecin>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.query(TABLE_MEDECIN, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Medecin medecin = new Medecin();
                medecin.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_ID))));
                medecin.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_NOM)));
                medecin.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PRENOM)));
                medecin.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_EMAIL)));
                medecin.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_cin)));
                medecin.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PASSWORD)));
                medecin.setDate_naissance(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_BIRTHDAY)));
                medecin.setSpecialite(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_SPECIALITE)));
                medecin.setTelephone(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PHONE)));
                // Adding PATIENT record to list
                MedList.add(medecin);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        return MedList;
    }




    public List<Patient> getAllPatientByStatus(int s) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID,
                COLUMN_PATIENT_NOM,
                COLUMN_PATIENT_PRENOM,
                COLUMN_PATIENT_CIN,
                COLUMN_PATIENT_EMAIL,
                COLUMN_PATIENT_PASSWORD,
                COLUMN_PATIENT_PHONE,
                COLUMN_PATIENT_STATUS,
                COLUMN_PATIENT_BIRTHDAY,
                COLUMN_PATIENT_NBRVCCN

        };
        // sorting orders
        String sortOrder =
                COLUMN_PATIENT_NOM + " ASC";
        List<Patient> PATIENTList = new ArrayList<Patient>();
        String selection = COLUMN_PATIENT_STATUS + " = ?";
        String[] selectionArgs = {Integer.toString(s)};
        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor  = db.rawQuery("SELECT * FROM "+ TABLE_PATIENT +" WHERE "+ COLUMN_PATIENT_STATUS + " = ?",selectionArgs );

        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient PATIENT = new Patient();
                PATIENT.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_ID))));
                PATIENT.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_NOM)));
                PATIENT.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PRENOM)));
                PATIENT.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_EMAIL)));
                PATIENT.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_CIN)));
                PATIENT.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PASSWORD)));
                PATIENT.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_BIRTHDAY)));
                PATIENT.setNbr_vaccin(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_NBRVCCN)));
                PATIENT.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PHONE)));
                PATIENT.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_STATUS)));
                // Adding PATIENT record to list
                PATIENTList.add(PATIENT);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        return PATIENTList;
    }


    public Patient getPatientByID(String CIN) {
        Patient PATIENT = new Patient();

        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID,
                COLUMN_PATIENT_NOM,
                COLUMN_PATIENT_PRENOM,
                COLUMN_PATIENT_CIN,
                COLUMN_PATIENT_EMAIL,
                COLUMN_PATIENT_PASSWORD,
                COLUMN_PATIENT_PHONE,
                COLUMN_PATIENT_STATUS,
                COLUMN_PATIENT_BIRTHDAY,
                COLUMN_PATIENT_NBRVCCN

        };
        // sorting orders
        String sortOrder =
                COLUMN_PATIENT_CIN + " ASC";
        String selection = COLUMN_PATIENT_CIN + " = ?";
        String[] selectionArgs = {CIN};
        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT+" where "+ COLUMN_PATIENT_CIN +" =?", new String[]{CIN});

        // Traversing through all rows and adding to list
        if (cursor.moveToLast()) {
            PATIENT.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_ID))));
            PATIENT.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_NOM)));
            PATIENT.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PRENOM)));
            PATIENT.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_EMAIL)));
            PATIENT.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_CIN)));
            PATIENT.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PASSWORD)));
            PATIENT.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_BIRTHDAY)));
            PATIENT.setNbr_vaccin(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_NBRVCCN)));
            PATIENT.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PHONE)));
            PATIENT.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_STATUS)));
            cursor.close();
            // Adding PATIENT record to list
            return PATIENT;
        }
        else {
            Log.d("error","Patient not found ");
            return PATIENT;
        }

        // db.close();

    }




    public Medecin getMedecinByID(String CIN) {
        Medecin medecin = new Medecin();

        // array of columns to fetch
        String[] columns = {
                COLUMN_MEDECIN_ID,
                COLUMN_MEDECIN_MATRICULE,
                COLUMN_MEDECIN_PHONE,
                COLUMN_MEDECIN_SPECIALITE,
                COLUMN_MEDECIN_cin,
                COLUMN_MEDECIN_NOM,
                COLUMN_MEDECIN_PRENOM,
                COLUMN_MEDECIN_EMAIL,
                COLUMN_MEDECIN_BIRTHDAY,
                COLUMN_MEDECIN_PASSWORD,
                COLUMN_MEDECIN_CENTRE_ID


        };
        // sorting orders
        String sortOrder =
                COLUMN_MEDECIN_cin + " ASC";
        String selection = COLUMN_MEDECIN_cin + " = ?";
        String[] selectionArgs = {CIN};
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from " + TABLE_MEDECIN+" where "+ COLUMN_MEDECIN_cin +" =?", new String[]{CIN});

        // Traversing through all rows and adding to list
        if (cursor.moveToLast()) {
            medecin.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_ID))));
            medecin.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_NOM)));
            medecin.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PRENOM)));
            medecin.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_EMAIL)));
            medecin.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_cin)));
            medecin.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PASSWORD)));
            medecin.setDate_naissance(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_BIRTHDAY)));
            medecin.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_MEDECIN_CENTRE_ID)));
            medecin.setSpecialite(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_SPECIALITE)));
            medecin.setTelephone(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PHONE)));
            medecin.setMatricule(cursor.getInt(cursor.getColumnIndex(COLUMN_MEDECIN_MATRICULE)));
            cursor.close();
            // Adding PATIENT record to list
            return medecin;
        }
        else {
            Log.d("error","Patient not found ");
            return medecin;
        }

        // db.close();

    }

    /**
     * This method to update PATIENTrecord
     *
     */
    public void updatePATIENT(Patient PATIENT) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_PATIENT_NOM, PATIENT.getNom());
        values.put(COLUMN_PATIENT_EMAIL, PATIENT.getEmail());
        values.put(COLUMN_PATIENT_PASSWORD, PATIENT.getPassword());
        values.put(COLUMN_PATIENT_BIRTHDAY,PATIENT.getBirthday());
        values.put(COLUMN_PATIENT_PHONE,PATIENT.getPhone());
        values.put(COLUMN_PATIENT_NBRVCCN,PATIENT.getNbr_vaccin());
        values.put(COLUMN_PATIENT_STATUS,PATIENT.getStatus());


        // updating row
        db.update(TABLE_PATIENT, values, COLUMN_PATIENT_ID + " = ?",
                new String[]{String.valueOf(PATIENT.getId())});
        db.close();
    }



    /**
     * This method is to delete PATIENTrecord
     *
     * @param PATIENT
     */
    public void deletePATIENT(Patient PATIENT) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete PATIENTrecord by id
        db.delete(TABLE_PATIENT, COLUMN_PATIENT_ID + " = ?",
                new String[]{String.valueOf(PATIENT.getId())});
        db.close();
    }

    /**
     * This method to check PATIENTexist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkPatientExistance(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_PATIENT_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query PATIENT table with condition
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id FROM PATIENTWHERE PATIENT_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_PATIENT, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
    /*
        /**
         * This method to check PATIENT exist or not
         *
         * @param email
         * @param password
         * @return true/false
         */
    public boolean checkPATIENT(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_PATIENT_EMAIL + " = ?" + " AND " + COLUMN_PATIENT_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query PATIENTtable with conditions
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id FROM PATIENTWHERE PATIENT_email = 'jack@androidtutorialshub.com' AND PATIENT_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_PATIENT, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        //db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean checkMedecin(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_MEDECIN_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_MEDECIN_EMAIL + " = ?" + " AND " + COLUMN_MEDECIN_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query PATIENTtable with conditions
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id FROM PATIENTWHERE PATIENT_email = 'jack@androidtutorialshub.com' AND PATIENT_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_MEDECIN, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        //db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public void updateRDVDate(Reservation r) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_RESERVATION_DATE, r.getDate());
        values.put(COLUMN_RESERVATION_MEDECIN_ID, r.getId_medecin());
        values.put(COLUMN_RESERVATION_INFERMIER_ID, r.getId_infermier());
        values.put(COLUMN_RESERVATION_CENTRE_ID,r.getId_centre());
        values.put(COLUMN_RESERVATION_ID,r.getId());


        // updating row
        db.update(TABLE_RESERVATION, values, COLUMN_RESERVATION_ID + " = ?",
                new String[]{String.valueOf(r.getId())});
        db.close();
    }



    public Reservation getReservation(String id) {
        Reservation r = new Reservation();
        SQLiteDatabase db = this.getReadableDatabase();

        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.rawQuery("select * from " + TABLE_RESERVATION+" a INNER JOIN " + TABLE_PATIENT +" b  WHERE a."+ COLUMN_RESERVATION_PATIENT_ID  +" = b."+COLUMN_PATIENT_ID+" AND b."+ COLUMN_PATIENT_CIN +" = ?",new String[]{id});

        if (cursor.getCount() <= 0)
        {
            Log.d("problem ","i got nothing ");
        } else {
            // Traversing through all rows and adding to list
            if (cursor.moveToLast()) {
                r.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_ID))));
                r.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_DATE)));
                r.setId_centre(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_CENTRE_ID))));
                r.setId_infermier(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_INFERMIER_ID))));
                r.setId_medecin(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_MEDECIN_ID))));
                r.setId_patient(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_RESERVATION_PATIENT_ID))));
            }
        }
        System.out.println(r.getId());

        return r;


        // db.close();

    }



    public List<Patient> getAllPatientByMedecin(int s) {
        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID,
                COLUMN_PATIENT_NOM,
                COLUMN_PATIENT_PRENOM,
                COLUMN_PATIENT_CIN,
                COLUMN_PATIENT_EMAIL,
                COLUMN_PATIENT_PASSWORD,
                COLUMN_PATIENT_PHONE,
                COLUMN_PATIENT_STATUS,
                COLUMN_PATIENT_BIRTHDAY,
                COLUMN_PATIENT_NBRVCCN

        };
        // sorting orders
        String sortOrder = COLUMN_PATIENT_NOM + " ASC";
        List<Patient> PATIENTList = new ArrayList<Patient>();
        String selection = COLUMN_PATIENT_STATUS + " = ?";
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = {Integer.toString(s)};

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */

        Cursor cursor = db.rawQuery("select *  FROM " + TABLE_PATIENT+
                        " INNER JOIN " + TABLE_RESERVATION +" ON " + TABLE_PATIENT +"."+COLUMN_PATIENT_ID+ "=" + TABLE_RESERVATION + "." + COLUMN_RESERVATION_PATIENT_ID+
                        " INNER JOIN " + TABLE_MEDECIN +" ON " + TABLE_MEDECIN +"."+COLUMN_MEDECIN_ID +"=" + TABLE_RESERVATION + "." + COLUMN_RESERVATION_MEDECIN_ID +
                        " WHERE "+COLUMN_MEDECIN_ID +"=?"+
                        " AND "+COLUMN_PATIENT_STATUS +"=" + 2
                ,selectionArgs);


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Patient PATIENT = new Patient();
                PATIENT.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_ID))));
                PATIENT.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_NOM)));
                PATIENT.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PRENOM)));
                PATIENT.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_EMAIL)));
                PATIENT.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_CIN)));
                PATIENT.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PASSWORD)));
                PATIENT.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_BIRTHDAY)));
                PATIENT.setNbr_vaccin(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_NBRVCCN)));
                PATIENT.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PHONE)));
                PATIENT.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_STATUS)));
                // Adding PATIENT record to list
                PATIENTList.add(PATIENT);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        System.out.println(PATIENTList.toString());
        return PATIENTList;
    }




    public Medecin getMedecinByEmail(String email) {
        Medecin medecin = new Medecin();

        // array of columns to fetch
        String[] columns = {
                COLUMN_MEDECIN_ID,
                COLUMN_MEDECIN_MATRICULE,
                COLUMN_MEDECIN_PHONE,
                COLUMN_MEDECIN_SPECIALITE,
                COLUMN_MEDECIN_cin,
                COLUMN_MEDECIN_NOM,
                COLUMN_MEDECIN_PRENOM,
                COLUMN_MEDECIN_EMAIL,
                COLUMN_MEDECIN_BIRTHDAY,
                COLUMN_MEDECIN_PASSWORD,
                COLUMN_MEDECIN_CENTRE_ID


        };
        // sorting orders
        String sortOrder =
                COLUMN_MEDECIN_EMAIL + " ASC";
        String selection = COLUMN_MEDECIN_EMAIL + " = ?";
        String[] selectionArgs = {email};
        SQLiteDatabase db = this.getReadableDatabase();


        Cursor cursor = db.rawQuery("select * from " + TABLE_MEDECIN+" where "+ COLUMN_MEDECIN_EMAIL +" =?", new String[]{email});

        // Traversing through all rows and adding to list
        if (cursor.moveToLast()) {
            medecin.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_ID))));
            medecin.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_NOM)));
            medecin.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PRENOM)));
            medecin.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_EMAIL)));
            medecin.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_cin)));
            medecin.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PASSWORD)));
            medecin.setDate_naissance(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_BIRTHDAY)));
            medecin.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_MEDECIN_CENTRE_ID)));
            medecin.setSpecialite(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_SPECIALITE)));
            medecin.setTelephone(cursor.getString(cursor.getColumnIndex(COLUMN_MEDECIN_PHONE)));
            medecin.setMatricule(cursor.getInt(cursor.getColumnIndex(COLUMN_MEDECIN_MATRICULE)));
            cursor.close();
            // Adding PATIENT record to list
            return medecin;
        }
        else {
            Log.d("error","Patient not found ");
            return medecin;
        }

        // db.close();

    }


    public List<Centre> getAllCentre() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_CENTRE_ID,
                COLUMN_CENTRE_NAME,
                COLUMN_CENTRE_EMPLACEMENT,

        };
        // sorting orders
        String sortOrder =
                COLUMN_CENTRE_NAME + " ASC";
        List<Centre> centres = new ArrayList<Centre>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.query(TABLE_CENTRE, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Centre centre = new Centre ();
                centre.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_CENTRE_ID))));
                centre.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_CENTRE_NAME)));
                centre.setEmplacement(cursor.getString(cursor.getColumnIndex(COLUMN_CENTRE_EMPLACEMENT)));
                // Adding PATIENT record to list
                centres.add(centre);
            } while (cursor.moveToNext());
        }
        cursor.close();
        // db.close();

        // return PATIENTlist
        return centres;
    }



    public Patient getPatientByEmail(String email) {
        Patient PATIENT = new Patient();

        // array of columns to fetch
        String[] columns = {
                COLUMN_PATIENT_ID,
                COLUMN_PATIENT_NOM,
                COLUMN_PATIENT_PRENOM,
                COLUMN_PATIENT_CIN,
                COLUMN_PATIENT_EMAIL,
                COLUMN_PATIENT_PASSWORD,
                COLUMN_PATIENT_PHONE,
                COLUMN_PATIENT_STATUS,
                COLUMN_PATIENT_BIRTHDAY,
                COLUMN_PATIENT_NBRVCCN

        };
        // sorting orders
        String sortOrder =
                COLUMN_PATIENT_CIN + " ASC";
        String selection = COLUMN_PATIENT_EMAIL + " = ?";
        String[] selectionArgs = {email};
        SQLiteDatabase db = this.getReadableDatabase();

        // query the PATIENTtable
        /**
         * Here query function is used to fetch records from PATIENTtable this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT PATIENT_id,PATIENT_name,PATIENT_email,PATIENT_password FROM PATIENTORDER BY PATIENT_name;
         */
        Cursor cursor = db.rawQuery("select * from " + TABLE_PATIENT+" where "+ COLUMN_PATIENT_EMAIL +" =?", new String[]{email});

        // Traversing through all rows and adding to list
        if (cursor.moveToLast()) {
            PATIENT.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_ID))));
            PATIENT.setNom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_NOM)));
            PATIENT.setPrenom(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PRENOM)));
            PATIENT.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_EMAIL)));
            PATIENT.setCin(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_CIN)));
            PATIENT.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PASSWORD)));
            PATIENT.setBirthday(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_BIRTHDAY)));
            PATIENT.setNbr_vaccin(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_NBRVCCN)));
            PATIENT.setPhone(cursor.getString(cursor.getColumnIndex(COLUMN_PATIENT_PHONE)));
            PATIENT.setStatus(cursor.getInt(cursor.getColumnIndex(COLUMN_PATIENT_STATUS)));
            cursor.close();
            // Adding PATIENT record to list
            return PATIENT;
        }
        else {
            Log.d("error","Patient not found ");
            return PATIENT;
        }

        // db.close();

    }

}