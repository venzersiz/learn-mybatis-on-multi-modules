package learn.module2.domain.repository;

import learn.shared.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class Module2UserDao {

    private final SqlSession sqlSession;

    public User selectByEmail(String email) {

        return sqlSession.selectOne("module2UserMapper.selectByEmail", email);
    }
}
