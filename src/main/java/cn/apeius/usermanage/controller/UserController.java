package cn.apeius.usermanage.controller;

import cn.apeius.usermanage.domain.EasyUIPage;
import cn.apeius.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by Asus on 2016/10/7.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value =  "/toList")
    public String toList(){
        return "users";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public EasyUIPage list(){
        EasyUIPage easyUIPage = userService.queryAllUsers();
        return easyUIPage;
    }

}
