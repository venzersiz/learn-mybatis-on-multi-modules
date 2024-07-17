package learn.shared.domain.model.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private Long seq;

    private String name;

    private String email;
}
