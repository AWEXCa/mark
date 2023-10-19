package com.example.mark.service.impl;

import com.example.mark.bean.PersonalCart;
import com.example.mark.mapper.ShoppingCartMapper;
import com.example.mark.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public List<PersonalCart> queryAllByUid(String uid,String isAfford) {
        return shoppingCartMapper.selectAllByUid(uid,isAfford);
    }

    @Override
    public int addCart (String uid, String sid,String isAfford) {
        return shoppingCartMapper.insert(UUID.randomUUID().toString(), uid, sid,isAfford);
    }

    @Override
    public int removeCart(String id) {
        return shoppingCartMapper.deleteById(id);
    }

    @Override
    public int modifyCart(String oid, String isAfford) {
        return shoppingCartMapper.updateById(oid,isAfford);
    }
}
