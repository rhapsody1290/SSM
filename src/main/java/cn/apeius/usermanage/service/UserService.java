package cn.apeius.usermanage.service;

import cn.apeius.usermanage.domain.EasyUIPage;
import cn.apeius.usermanage.domain.User;

import java.util.List;

/**
 * Created by Asus on 2016/10/7.
 */
public interface UserService {

    EasyUIPage queryAllUsers(Integer pageNow, Integer pageSize);

    Integer addUser(User user);

    Integer deleteUserByIds(List<Object> ids);
}
