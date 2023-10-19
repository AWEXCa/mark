package com.example.mark.Controller;

import com.example.mark.bean.PersonalCart;
import com.example.mark.bean.RespResult;
import com.example.mark.mapper.ShoppingCartMapper;
import com.example.mark.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @GetMapping("/cart/get")
    public RespResult get(String uid,String isAfford){
        RespResult respResult = RespResult.fail();
        List<PersonalCart> personalCarts = shoppingCartService.queryAllByUid(uid,isAfford);
        if (personalCarts != null) {
            respResult=RespResult.ok();
            respResult.setList(personalCarts);
        }
        return respResult;
    }
    @PostMapping("/cart/insert")
    public RespResult addCart(String uid,String sid){
        RespResult respResult = RespResult.fail();
        int i = shoppingCartService.addCart(uid, sid,"0");
        if (i==1){
            respResult=RespResult.ok();
        }
        return respResult;
    }
    @GetMapping("/cart/remove")
    public RespResult removeCart(String id){
        RespResult respResult = RespResult.fail();
        int i = shoppingCartService.removeCart(id);
        if (i==1){
            respResult=RespResult.ok();
        }
        return respResult;
    }
}
