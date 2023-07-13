package hello.hello.spring.repository;

import hello.hello.spring.domain.Member;

import org.junit.jupiter.api.*;


import java.util.*;

import static org.assertj.core.api.Assertions.*;

// import org.junit.Test; <- 이 경우에는 afterEach, BeforeEach를 타지않음

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    void afterEach(){
        System.out.println("afterEach-----------------------------");
        repository.clearStore();
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("BeforeEach-----------------------------");
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Assertions.assertEquals(result, member);  -> JUnit
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // Shift + F6 : rename
        member2.setName("spring2");
        repository.save(member2);

       Member result = repository.findByName("spring1").get();
       assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }


}
