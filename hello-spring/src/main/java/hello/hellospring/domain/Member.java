package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    //자동으로 DB에서 ID(PK)값을 생성하는것(IDENTITY 전략)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
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
