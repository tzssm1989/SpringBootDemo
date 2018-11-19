
import com.kaige.mapper.UserMapper;
import com.kaige.model.User;
import com.kaige.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testaddUser(){

        long time = System.currentTimeMillis();

        for (int i = 0; i <50 ; i++) {

            User user = new User();
            user.setLoginname("test"+i);
            user.setCreatedate(new Date());
            user.setStatus(i);
            user.setPassword("123456"+i);
            user.setUsername("lisi"+i);

            userService.addUser(user);

        }

        System.out.println(System.currentTimeMillis()-time);
    }
//    @Test
//    public void deleteuser(){
//
//        long time = System.currentTimeMillis();
//
//        for (int i = 5; i <55009 ; i++) {
//
//
//
//            userService.deleteUser(i);
//
//        }
//
//        System.out.println(System.currentTimeMillis()-time);
//
//
//    }
}
