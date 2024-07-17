package learn.shared.domain.repository;

import learn.shared.domain.model.user.User;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {

    private final SqlSession sqlSession;

    public User selectById(long seq) {

        return sqlSession.selectOne("userMapper.selectById", seq);
    }
}
