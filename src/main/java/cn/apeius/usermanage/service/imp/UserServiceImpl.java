package cn.apeius.usermanage.service.imp;


import cn.apeius.usermanage.domain.EasyUIPage;
import cn.apeius.usermanage.domain.RBAC.User;
import cn.apeius.usermanage.mapper.RBAC.UserMapper;
import cn.apeius.usermanage.service.UserService;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Asus on 2016/10/7.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public EasyUIPage queryAllUsers(Integer pageNow, Integer pageSize) {
        PageHelper.startPage(pageNow, pageSize);
        //紧接着的第一个查询会被执行分页
        List<User> list = userMapper.select(null);

        PageInfo<User> pageInfo = new PageInfo<User>(list);

        EasyUIPage easyUIPage = new EasyUIPage();
        easyUIPage.setTotal(pageInfo.getTotal());
        easyUIPage.setRows(pageInfo.getList());
        return easyUIPage;
    }

    public Integer addUser(User user) {
       return userMapper.insertSelective(user);
    }

    public Integer deleteUserByIds(List<Object> ids) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id",ids);
        return userMapper.deleteByExample(example);
    }
}
