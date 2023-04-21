package com.animee.rf_week02.db;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {
    public DBOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBOpenHelper(@Nullable Context context) {
        super(context, "heartgo.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "create table addresstb(" +
                        "id integer primary key autoincrement," +
                        "name varchar(30) not null," +
                        "tel varchar(20) not null," +
                        "city varchar(50)," +
                        "street varchar(255)" +
                        ")";
        db.execSQL(sql);

        // 测试添加一条记录
        sql = "insert into addresstb values (1, '张三', '12345678912', '四川', '天府新区1号楼')";
        db.execSQL(sql);

        sql = "insert into addresstb values (2, '李四', '13549846515', '重庆', '阳关小区1号楼')";
        db.execSQL(sql);

        sql = "insert into addresstb values (3, '王五', '15916549163', '杭州', '翻斗花园1号楼')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
