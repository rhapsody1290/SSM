import cn.apeius.usermanage.domain.RBAC.Role;
import cn.apeius.usermanage.mapper.RBAC.RoleMapper;
import cn.apeius.usermanage.mapper.RBAC.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.java2d.opengl.WGLSurfaceData;

import java.util.List;

/**
 * Created by Asus on 2016/10/19.
 */
public class RoleMapperTest {

    private RoleMapper mapper;

    @Before
    public void setUp() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml","applicationContext-mybatis.xml","applicationContext-tx.xml"});
        mapper = ac.getBean(RoleMapper.class);
    }

    @Test
    public void testSelect(){
        Role record = new Role();
        List<Role> roles = mapper.select(record);

        for(Role r : roles){
            System.out.println(r);
        }
    }

}
