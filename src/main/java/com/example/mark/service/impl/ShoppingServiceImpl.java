package com.example.mark.service.impl;

import com.example.mark.bean.Shopping;
import com.example.mark.bean.User;
import com.example.mark.mapper.ShoppingCartMapper;
import com.example.mark.mapper.ShoppingMapper;
import com.example.mark.mapper.UserMapper;
import com.example.mark.service.ShoppingCartService;
import com.example.mark.service.ShoppingService;
import com.example.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Override
    public List<Shopping> queryAll() {
        return shoppingMapper.selectAll();
    }

    /**
     * @param uid
     * @param sid
     * @return 1表示成功 -1表示用户余额不足 其它表示失败
     */
    @Override
    @Transactional
    public int buyShop(String uid, String sid,String oid) {
        Shopping shopping = shoppingMapper.selectById(sid);
        User user = userMapper.selectById(uid);
        Double left=user.getMoney()-shopping.getPrice();
        int i=0;
        if (left<0) {
            return -1;
        }
        user.setMoney(left);
        i += userMapper.updateById(user);
        if (oid==null) {
            i += shoppingCartService.addCart(uid, sid,"1");
        }else {
            i+= shoppingCartService.modifyCart(oid,"1");
        }
        return i;
    }

    @Override
    public Shopping queryById(String id) {
        return shoppingMapper.selectById(id);
    }

    @Override
    public int modify(Shopping shopping) {
        return shoppingMapper.updateById(shopping);
    }

    @Override
    public int addShopping(Shopping shopping) {
        return shoppingMapper.insert(shopping);
    }

    public int addShoppingCart(String uid, String sid){
    return 0;
    }
}
