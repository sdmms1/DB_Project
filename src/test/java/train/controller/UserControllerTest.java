package train.controller;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import train.mapper.UserMapper;
import train.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUserTest() {
        User user = new User(
                "Monkey",
                "33010320000416161X",
                "13467839784",
                "6969");
        System.out.println(user);
        userMapper.insertUser(user);

        User myUser = userMapper.queryUserByUsername("Monkey");
        System.out.println(myUser);

    }
}


