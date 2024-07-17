package learn.module1.domain.repository;

import learn.shared.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Module1UserDao {

    private final SqlSession sqlSession;

    public User selectByName(String name) {

        return sqlSession.selectOne("module1UserMapper.selectByName", name);
    }
}
