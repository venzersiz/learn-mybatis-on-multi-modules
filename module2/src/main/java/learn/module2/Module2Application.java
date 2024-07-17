package learn.module2;

import learn.module2.domain.repository.Module2UserDao;
import learn.shared.domain.model.user.User;
import learn.shared.domain.repository.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Module2Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/application-context.xml");

        SqlSession sqlSession = applicationContext.getBean(SqlSession.class);
        System.out.println("# Mapped statement names");
        sqlSession.getConfiguration().getMappedStatementNames().forEach(System.out::println);
        /*
        module2UserMapper.selectByEmail
        selectByEmail
        userMapper.selectById
        selectById
        원래 네임스페이스 없는 ID도 등록되는 걸까?
        */
        System.out.println();

        System.out.println("# Type aliases");
        sqlSession.getConfiguration().getTypeAliasRegistry().getTypeAliases().forEach((type, aClass) -> System.out.println(type + ": " + aClass));
        /*
        ..
        user: class learn.shared.domain.model.user.User
        ..
        */
        System.out.println();

        System.out.println("# Result");
        UserDao userDao = applicationContext.getBean(UserDao.class);
        User user1 = userDao.selectById(1);
        System.out.println(user1);

        Module2UserDao module2UserDao = applicationContext.getBean(Module2UserDao.class);
        User user3 = module2UserDao.selectByEmail("user3@some.com");
        System.out.println(user3);
    }
}
