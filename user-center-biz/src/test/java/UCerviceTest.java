

import com.pop.uc.dto.UserDto;
import com.pop.uc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * OauthServiceTest
 *
 * @author nizhicheng
 * @date 16/4/14
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class UCerviceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        UserDto userDto = new UserDto();
        userDto.setAccount("1111");
        userDto.setPassword("ssss");
        userDto.setName("aa");
        userService.regist(userDto);


    }


}
