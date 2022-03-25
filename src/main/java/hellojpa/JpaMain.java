package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        //로딩시점에 하나만 만든다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        //트랜잭션 실행시 만듦
        EntityManager em = emf.createEntityManager();

        //트랜잭션 시작
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");
            //멤버 저장
            em.persist(member);

            //멤버 수정
            Member member1 = em.find(Member.class, 1L);
            member1.setName("bye");

            //멤버 삭제
            em.remove(member1);

            //트랜잭션 커밋 ( 끝 )
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
