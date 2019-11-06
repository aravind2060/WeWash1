package com.example.wewash.MyOrders;

import android.provider.ContactsContract;

import com.google.firebase.database.DataSnapshot;

import java.sql.Time;

public class D_OrdersData {

  public String OrderId,Name,Address,phone,DateBooked,ExpectedDeliveryTime,NoOfClothes,Status;
  public D_OrdersData(String name,String address,String phone,String dateBooked,String expectedDeliveryTime,String noOfClothes)
  {
     OrderId=""+System.currentTimeMillis()+phone;
     Name=name;
     Address=address;
     this.phone=phone;
     DateBooked=dateBooked;
     ExpectedDeliveryTime=expectedDeliveryTime;
     NoOfClothes=noOfClothes;
     Status=null;
  }
  public D_OrdersData()
  {

  }
}
