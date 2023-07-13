package hello.hello.spring.domain;

import javax.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    //@Id @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    // @Column (name="username") <- 이 경우는 컬럼명이 username
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
