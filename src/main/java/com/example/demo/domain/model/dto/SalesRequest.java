package com.example.demo.domain.model.dto;

import com.example.demo.domain.model.entity.Sales;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalesRequest {
    private long id;
    private Date date;
    private int category;
    private int menu;
    private int price;
    private int quantity;
    private int device;
    private int deviceNum;
    private int orderNum;
    private int process;

    public Sales toEntity() {
        Sales sales = new Sales();

        sales.setId(id);
        sales.setDate(date);
        sales.setCategory(category);
        sales.setMenu(menu);
        sales.setPrice(price);
        sales.setQuantity(quantity);
        sales.setDevice(device);
        sales.setDevicenum(deviceNum);
        sales.setOrdernum(orderNum);
        sales.setProcess(process);

        return sales;
    }
}
