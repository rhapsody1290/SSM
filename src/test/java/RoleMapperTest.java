import cn.apeius.usermanage.domain.Role;
import cn.apeius.usermanage.mapper.RoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        List<Role> roles = mapper.select(null);

        for(Role r : roles){
            System.out.println(r);
        }
    }

}
