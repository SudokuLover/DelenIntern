package com.example.gauranggoel.delenhomeinterntask;

public class MyOrder {

    String time;
    String id;
    String workType;
    String workerName;
    String cost;
    String status;
    String address;
    String url;


    public MyOrder() {
    }

    public MyOrder(String time, String id, String workType, String workerName, String cost, String status, String address, String url) {
        this.time = time;
        this.id = id;
        this.workType = workType;
        this.workerName = workerName;
        this.cost = cost;
        this.status = status;
        this.address = address;

        this.url=url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
