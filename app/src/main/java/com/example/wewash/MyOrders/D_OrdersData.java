package com.example.wewash.MyOrders;

public class D_OrdersData {

  private String orderId, name,address,phone,dateBooked,expectedDeliveryTime,noOfClothes,status;
  public D_OrdersData(String address,String dateBooked,String expectedDeliveryTime,String name,String noOfClothes,String orderId,String phone,String status)
  {
     this.orderId =orderId;
     this.name =name;
     this.address=address;
     this.phone =phone;
     this.dateBooked=dateBooked;
     this.expectedDeliveryTime=expectedDeliveryTime;
     this.noOfClothes=noOfClothes;
     this.status=status;
  }
  public D_OrdersData()
  {

  }


    public String getOrderId() {
        return orderId;
    }


    public String getName() {
        return name;
    }


    public String getAddress() {
        return address;
    }


    public String getPhone() {
        return phone;
    }


    public String getDateBooked() {
        return dateBooked;
    }


    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }



    public String getNoOfClothes() {
        return noOfClothes;
    }


    public String getStatus() {
        return status;
    }

}
