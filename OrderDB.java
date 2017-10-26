package com.example.rocky_pc.projectglobsyn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by subhash on 7/28/2016.
 */

public class OrderDB extends SQLiteOpenHelper {
    public OrderDB(Context context) {
        super(context, "AndroidOrderDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tablecode="Create Table Orders(OrderId varchar(20) primary key," +
                "CustomerName varchar(20),Phone String)";
        db.execSQL(tablecode);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists Orders");
        onCreate(db);

    }

    public ArrayList<Order> GetOrders(){
        ArrayList<Order> orders=new ArrayList<Order>();
        SQLiteDatabase db=getReadableDatabase();
        String[]columns={"OrderID","CustomerName","Phone"};
        Cursor rows= db.query("Orders",columns,null,null,null,null,"OrderID DESC");
        if (rows!=null){
            while (rows.moveToNext()){
                Order ord=new Order();
                ord.Id=rows.getString(0);
                ord.CustomerName=rows.getString(1);
                ord.no=rows.getString(2);
                orders.add(ord);
            }
        }
        db.close();
        return orders;
    }
    public long AddOrder(Order ord){
        ContentValues values=new ContentValues();
        values.put("OrderId",ord.Id);
        values.put("CustomerName",ord.CustomerName);
        values.put("Phone",ord.no);
        SQLiteDatabase db=getWritableDatabase();
        long rowid=db.insert("Orders",null,values);
        db.close();
        return rowid;
    }
    public  int UpdateOrder(Order ord){
        ContentValues values=new ContentValues();
        values.put("CustomerName",ord.CustomerName);
        values.put("Phone",ord.no);
        SQLiteDatabase db=getWritableDatabase();
        String[]para={ord.Id};
        int count=db.update("Orders",values,"OrderId=?",para);
        db.close();
        return count;



    }

    public Order Getorder(String oid){
        String[]columns={"OrderID","CustomerName","Phone"};
        String[]para={oid};
        SQLiteDatabase db=getReadableDatabase();
        Cursor rows=db.query("Orders",columns,"OrderID=?",para,null,null,null);
        if (rows!=null) {

            if (rows.moveToNext()) {
                Order ord = new Order();
                ord.Id = rows.getString(0);
                ord.CustomerName = rows.getString(1);
                ord.no=rows.getString(2);

                return ord;
            }
        }
        return null;

    }
}

