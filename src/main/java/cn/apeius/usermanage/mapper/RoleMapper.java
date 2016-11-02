package cn.apeius.usermanage.mapper;

import cn.apeius.usermanage.domain.Role;
import cn.apeius.usermanage.domain.User;
import com.github.abel533.mapper.Mapper;

import java.util.List;

/**
 * Created by Asus on 2016/10/19.
 */
public interface RoleMapper extends Mapper<Role> {
    //获取某个用户的所有角色
    List<Role> queryRolesByUserId(Long id);

}
