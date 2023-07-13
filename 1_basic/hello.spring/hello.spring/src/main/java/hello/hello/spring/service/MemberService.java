package hello.hello.spring.service;

import hello.hello.spring.domain.Member;
import hello.hello.spring.repository.MemberRepository;
import hello.hello.spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

//@Component  -> Service 안에 있다.
//@Service
@Transactional
public class MemberService {
    private final MemberRepository memberReposotory;

    //@Autowired
    public MemberService(MemberRepository memberReposotory) {
        this.memberReposotory = memberReposotory;
    }

    /*
     *  회원가입
     */
    public Long join(Member member){
        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member); // 중복회원 검증
            memberReposotory.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member){
        memberReposotory.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /*
    * 전체 회원조회
    */
    public List<Member> findMembers(){
        return memberReposotory.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberReposotory.findById(memberId);
    }
}
