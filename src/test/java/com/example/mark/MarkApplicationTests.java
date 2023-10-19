package com.example.mark;

import com.example.mark.bean.Shopping;
import com.example.mark.bean.ShoppingCart;
import com.example.mark.bean.User;
import com.example.mark.mapper.ShoppingCartMapper;
import com.example.mark.mapper.ShoppingMapper;
import com.example.mark.mapper.UserMapper;
import com.example.mark.service.ShoppingService;
import com.example.mark.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MarkApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private ShoppingMapper shoppingMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Test
    void contextLoads() {
        User user = userMapper.selectById("1");
        System.out.println("user = " + user);
    }

    @Test
    void login() {
/*        User u=userMapper.selectByUnameAndPwd("zs","123");
        System.out.println("u = " + u);*/
        User user = userService.login("zs", "123");
        System.out.println("user = " + user);
    }

    @Test
    void slectAll() {
        System.out.println(shoppingService.queryAll());
    }

    @Test
    void selectById() {
        System.out.println(shoppingMapper.selectById("1"));
    }

    @Test
    void update() {
        User user = userMapper.selectById("1");
        user.setMoney(0.00);
        userMapper.updateById(user);
    }

    @Test
    void name() {
       // System.out.println(shoppingCartMapper.selectAllByUid("1"));
    }

    @Test
    void sww() {
        Shopping shopping = shoppingMapper.selectById("1");
        shopping.setSname("哈哈哈");
        shoppingMapper.updateById(shopping);
    }

    @Test
    void modify() {
        shoppingCartMapper.updateById("1","1");
    }

    @Test
    void om() {
        Shopping shopping=new Shopping();
        shopping.setId("32");
        shopping.setPrice(11.0);
        shopping.setSname("fsa");
        shoppingService.addShopping(shopping);
    }

    @Test
    void inset() {
        User user=new User();
        user.setPwd("123");
        user.setUname("ss");
        userService.register(user);
    }
}
