package cn.apeius.usermanage.service;


import cn.apeius.usermanage.domain.EasyUIPage;
import cn.apeius.usermanage.mapper.UserMapper;
import cn.apeius.usermanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Asus on 2016/10/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public EasyUIPage queryAllUsers() {
        EasyUIPage easyUIPage = new EasyUIPage();
        easyUIPage.setTotal(100);
        easyUIPage.setRows(userMapper.queryAllUsers());
        return easyUIPage;
    }
}
