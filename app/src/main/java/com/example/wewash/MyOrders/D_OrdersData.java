package com.example.wewash.MyOrders;

public class D_OrdersData {

  public String orderId, name,address,phone,dateBooked,expectedDeliveryTime,noOfClothes,status;
  public D_OrdersData(String name,String address,String phone,String dateBooked,String expectedDeliveryTime,String noOfClothes)
  {
     orderId =""+System.currentTimeMillis()+phone;
     this.name =name;
     this.address=address;
     this.phone =phone;
     this.dateBooked=dateBooked;
     this.expectedDeliveryTime=expectedDeliveryTime;
     this.noOfClothes=noOfClothes;
     this.status="Order Placed";
  }
  public D_OrdersData()
  {

  }
    public D_OrdersData(String name,String address,String phone,String dateBooked,String expectedDeliveryTime,String noOfClothes,String status)
    {
        orderId =""+System.currentTimeMillis()+phone;
        this.name =name;
        this.address=address;
        this.phone=phone;
        this.dateBooked=dateBooked;
        this.expectedDeliveryTime=expectedDeliveryTime;
        this.noOfClothes=noOfClothes;
        this.status=status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDateBooked() {
        return dateBooked;
    }

    public void setDateBooked(String dateBooked) {
        this.dateBooked = dateBooked;
    }

    public String getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(String expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public String getNoOfClothes() {
        return noOfClothes;
    }

    public void setNoOfClothes(String noOfClothes) {
        this.noOfClothes = noOfClothes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
