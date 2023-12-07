package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Optional;


//JPA를 이용한 쿼리 문 포함 소스
public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {this.em = em;}


    @Override
    public Member save(Member member) {
        em.persist(member); //persist: 영구 저장 -> 인서트 쿼리 만들어서 넣어줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList(); // select m from Member m where m.name = :name 파라미터로 받아온 name과 객체안에있는 name이 같은지 확인

        return result.stream().findAny();//리스트로 받아왔기 때문에 옵셔널로 변경
    }

    @Override
    public List<Member> findAll() {
        List<Member> result = em.createQuery("select m from Member m", Member.class)
                .getResultList();//select m from Member m 객체 자체를 가져옴
        return result;
    }
}
