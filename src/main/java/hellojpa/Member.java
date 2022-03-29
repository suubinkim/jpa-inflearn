package hellojpa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

//jpa를 사용한다고 인식하게 해줌
@Entity
@Setter
@Getter
@NoArgsConstructor //기본생성자
@RequiredArgsConstructor //생성자
public class Member {
    @Id
    private Long id;
    private String name;
//Getter, Setter …
}
