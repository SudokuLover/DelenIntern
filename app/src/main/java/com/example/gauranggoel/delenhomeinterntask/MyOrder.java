package com.example.gauranggoel.delenhomeinterntask;

public class MyOrder {

    String time;
    String id;
    String workType;
    String workerName;
    String cost;
    String status;
    String address;


    public MyOrder(String time, String id, String workType, String workerName, String cost, String status, String address) {
        this.time = time;
        this.id = id;
        this.workType = workType;
        this.workerName = workerName;
        this.cost = cost;
        this.status = status;
        this.address = address;
    }
}
