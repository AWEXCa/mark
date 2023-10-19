package com.example.mark.Controller;

import com.example.mark.bean.RCode;
import com.example.mark.bean.RespResult;
import com.example.mark.bean.Shopping;
import com.example.mark.service.ShoppingService;
import com.example.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private UserService userService;
    @GetMapping("/shop/getAll")
    public RespResult queryAllShopping(){
        RespResult respResult = RespResult.fail();
        List<Shopping> shoppingList = shoppingService.queryAll();
        if (shoppingList!=null) {
            respResult=RespResult.ok();
            respResult.setList(shoppingList);
        }
        return respResult;
    }
    @PostMapping("/shop/buy")
    public RespResult buyShopping(@RequestParam String uid,
                                  @RequestParam String sid,
                                  @RequestParam(required = false) String oid){
        RespResult respResult = RespResult.fail();
        int i = shoppingService.buyShop(uid, sid,oid);
        if (i==-1) {
            respResult.setRCode(RCode.MONEY_NOT);
        }else if (i==2){
            respResult=RespResult.ok();
        }
        return  respResult;
    }
    @GetMapping("/shop/query")
    public RespResult queryById(String sid){
        RespResult respResult = RespResult.fail();
        Shopping shopping = shoppingService.queryById(sid);
        if (shopping!=null) {
            respResult=RespResult.ok();
            respResult.setData(shopping);
        }
        return respResult;
    }
    @PostMapping("/shop/modfy")
    public RespResult modfy(@RequestBody Shopping msg){
        RespResult respResult=RespResult.fail();
        int i=shoppingService.modify(msg);
        if (i==1) {
            respResult=RespResult.ok();
        }
        return respResult;
    }
    @PostMapping("/shop/add")
    public RespResult addShopping(@RequestBody Shopping msg){
        msg.setId(UUID.randomUUID().toString());
        RespResult respResult = RespResult.fail();
        int i=shoppingService.addShopping(msg);
        if (i==1) {
            respResult = RespResult.ok();
        }
        return respResult;
    }
}
