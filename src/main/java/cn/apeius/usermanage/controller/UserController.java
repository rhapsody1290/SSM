package cn.apeius.usermanage.controller;

import cn.apeius.usermanage.domain.EasyUIPage;
import cn.apeius.usermanage.domain.User;
import cn.apeius.usermanage.domain.UserForm;
import cn.apeius.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by Asus on 2016/10/7.
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //页面跳转合并
    @RequestMapping(value = "/page/{pageName}")
    public String toPage(@PathVariable("pageName") String pageName){
        return pageName;
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public EasyUIPage list(@RequestParam(value = "page", defaultValue = "1") Integer pageNow,
                           @RequestParam(value = "rows", defaultValue = "5") Integer pageSize){
        EasyUIPage easyUIPage = userService.queryAllUsers(pageNow,pageSize);
        return easyUIPage;
    }

    /**
     * 添加用户信息
     */
    @RequestMapping(value = "/save")
    @ResponseBody
    public Map<String, String> save(User user){
        Map<String,String> map = new HashMap<String, String>();
        try{
            Integer num = userService.addUser(user);
            if(num > 0){
                map.put("status","200");
            }else{
                map.put("status","500");
            }
        }catch (Exception e){
            map.put("status","500");
        }
        return map;
    }

    @RequestMapping(value = "export/excel")
    public ModelAndView export(@RequestParam(value = "page", defaultValue = "1") Integer pageNow,
                               @RequestParam(value = "rows", defaultValue = "5") Integer pageSize){
        //1、查询需要导出的数据
        EasyUIPage page = this.userService.queryAllUsers(pageNow,pageSize);
        //2、传递数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("userList",page.getRows());
        mv.setViewName("userExcel");//定义到自定义的excel视图
        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/delete")
    //springmvc会自动把逗号切割，变成一个数组
    public Map<String,String> deleteById(@RequestParam(value = "ids") List<Object> ids){
        Integer num = this.userService.deleteUserByIds(ids);
        Map<String,String> map = new HashMap<String, String>();
        if(num > 0){
            map.put("status","200");
        }else{
            map.put("status","208");
        }
        return map;
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public Map<String, String> test(HttpSession session){
        Map<String, String> map = new HashMap<String, String>();
        map.put("sid",session.getId());
        return map;
    }
}
