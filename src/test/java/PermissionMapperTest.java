import cn.apeius.usermanage.domain.RBAC.Permission;
import cn.apeius.usermanage.domain.RBAC.Role;
import cn.apeius.usermanage.mapper.RBAC.PermissionMapper;
import cn.apeius.usermanage.mapper.RBAC.RoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Asus on 2016/10/19.
 */
public class PermissionMapperTest {

    private PermissionMapper mapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml","applicationContext-mybatis.xml","applicationContext-tx.xml"});
        mapper = ac.getBean(PermissionMapper.class);
    }

    @Test
    public void testSelect(){
        Permission record = new Permission();
        List<Permission> permissions = mapper.select(record);

        for(Permission p : permissions){
            System.out.println(p);
        }
    }
}
