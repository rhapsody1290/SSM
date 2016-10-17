package cn.apeius.usermanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Asus on 2016/10/12.
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping(value = "/test")
    public Map<String, String> test(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String, String> map = new HashMap<String, String>();
        map.put("status","200");
        map.put("msg",request.getSession().getServletContext().getAttribute("javax.servlet.context.tempdir").toString());
        return map;
    }
}
