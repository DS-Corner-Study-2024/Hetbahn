package Corner.Spring_Study.domain;

import jakarta.persistence.*;

// JPA가 관리하는 Entity
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //idnetity id 자동 생성
    private Long id;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}