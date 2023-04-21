package com.animee.rf_week02.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库管理工具
 */
public class DBManager {

    private static SQLiteDatabase db;

    public static void initDB(Context context) {
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
    }

    /**
     * 查询用户地址信息表全部内容
     */
    @SuppressLint({"Recycle", "Range"})
    public static List<AddressDao> queryAllAddressFromDB() {
        List<AddressDao> list = new ArrayList<>();
        String sql = "select * from addresstb";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String tel = cursor.getString(cursor.getColumnIndex("tel"));
            String city = cursor.getString(cursor.getColumnIndex("city"));
            String street = cursor.getString(cursor.getColumnIndex("street"));
            AddressDao dao = new AddressDao(id, name, tel, city, street);
            list.add(dao);
        }
        return list;
    }

    /**
     * 查询address是否存在
     *
     * @param dao
     * @return
     */
    public static boolean existAddressInDB(AddressDao dao) {
        String sql = "select * from addresstb" +
                " where name = '" + dao.getName() + "'" +
                " and tel = '" + dao.getTel() + "'" +
                " and city = '" + dao.getCity() + "'" +
                " and street = '" + dao.getStreet() + "'";
        Cursor cursor = db.rawQuery(sql, null);
        int count = cursor.getCount();
        return count > 0;
    }

    /**
     * 插入地址到数据库当中
     */
    public static long insertAddressToDB(AddressDao dao) {
        ContentValues values = new ContentValues();
        values.put("name", dao.getName());
        values.put("tel", dao.getTel());
        values.put("city", dao.getCity());
        values.put("street", dao.getStreet());

        return db.insert("addresstb", null, values);
    }

    /**
     * 通过id修改该数据库内容
     * @param dao
     */
    public static int modifyAddressById(AddressDao dao) {
        ContentValues values = new ContentValues();
        values.put("name", dao.getName());
        values.put("tel", dao.getTel());
        values.put("city", dao.getCity());
        values.put("street", dao.getStreet());

        return db.update("addresstb", values, "id = " + dao.getId(), null);
    }

    /**
     * 通过id删除数据库的地址
     * @param id
     */
    public static int deleteAddressById(int id) {
        int i = db.delete("addresstb", "id = " + id, null);
        return i;
    }

    @SuppressLint("Range")
    public static AddressDao queryAddressById(int defaultId) {
        Cursor cursor= db.query("addresstb", null, "id = " + defaultId, null, null, null, null);
        if (cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String tel = cursor.getString(cursor.getColumnIndex("tel"));
            String city = cursor.getString(cursor.getColumnIndex("city"));
            String street = cursor.getString(cursor.getColumnIndex("street"));
            return new AddressDao(id, name, tel, city, street);
        }
        return null;
    }

}
