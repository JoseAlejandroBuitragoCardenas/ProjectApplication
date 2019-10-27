package uan.edu.co.projectapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBSQLite extends SQLiteOpenHelper {

    private String sql = "create table eventos(" +
            "idEvento int," +
            "nombreEvento varchar(40)," +
            "ubicacion varchar(60)," +
            "fechadesde date," +
            "horadesde time," +
            "fechahasta date," +
            "horahasta time," +
            "descripcion varchar(60))";

    public DBSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
