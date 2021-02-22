import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

@ContextConfiguration(locations = "classpath:bean.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserBeanTest {

    @Autowired
    private User user;

    @Test
    public void test1() {
        HashMap map=new HashMap();
        map.put("123",333);


        String id = user.getId();
        String name = user.getUserName();
        System.out.println("id=" + id);
        System.out.println("name=" + name);
    }


}
