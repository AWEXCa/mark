package com.example.mark.service;

import com.example.mark.bean.Shopping;

import java.util.List;

public interface ShoppingService {
    List<Shopping> queryAll();
    int buyShop(String uid,String sid,String oid);
    Shopping queryById(String id);
    int modify(Shopping shopping);
    int addShopping(Shopping shopping);
}
