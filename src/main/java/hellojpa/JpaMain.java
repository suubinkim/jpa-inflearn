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
            //비영속
            Member member = new Member();
            member.setId(1L);
            member.setName("hello");

            //멤버 저장 - 영속상태 (db저장이 아닌 영속성 컨텍스트에 저장)
            em.persist(member);

            //영속성 컨텍스트에서 분리
            em.detach(member);

            //트랜잭션 커밋 ( 끝 ) 이때 쿼리가 날라가면서 db에 저장됨
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
