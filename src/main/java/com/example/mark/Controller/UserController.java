package com.example.mark.Controller;

import com.example.mark.bean.RCode;
import com.example.mark.bean.RespResult;
import com.example.mark.bean.User;
import com.example.mark.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/login")

    public RespResult login(String uname,String pwd){
        RespResult respResult = RespResult.fail();
        User user = userService.login(uname, pwd);
        if (user!=null) {
            respResult=RespResult.ok();
            respResult.setData(user);
        } else{
            respResult.setRCode(RCode.REQUEST_PARAM_ERR);
        }
        return respResult;
    }
    @PostMapping("/user/register")
    public RespResult register(String name,String pwd){
        RespResult respResult = RespResult.fail();
        User user = new User();
        user.setUname(name);
        user.setPwd(pwd);
        int i = userService.register(user);
        if (i==1) {
            respResult=RespResult.ok();
        }
        return respResult;
    }
}
