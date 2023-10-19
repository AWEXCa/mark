package com.example.mark.service;

import com.example.mark.bean.PersonalCart;

import java.util.List;

public interface ShoppingCartService {
    List<PersonalCart> queryAllByUid(String uid,String isAfford);
    int addCart(String uid,String sid,String isAfford);
    int removeCart(String id);
    int modifyCart(String oid,String isAfford);
}
