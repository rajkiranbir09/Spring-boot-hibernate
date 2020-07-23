package com.project.hibernate.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.project.hibernate.entity.Tutorial;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class TutorialDao {

    @PersistenceContext
    private EntityManager entityManager;

    // get tutorial by id
    public Tutorial getTutorialById(int tutorialId) {
        return entityManager.find(Tutorial.class, tutorialId);
    }

    @SuppressWarnings("unchecked")
    public List<Tutorial> getAllTutorials() {
        String hql = "FROM Tutorial as atcl ORDER BY atcl.tutorialId DESC";
        return (List<Tutorial>) entityManager.createQuery(hql).getResultList();
    }

    public void createTutorial(Tutorial tutorial) {
        entityManager.persist(tutorial);
    }

    public void updateTutorial(Tutorial tutorial) {
        Tutorial artcl = getTutorialById(tutorial.getTutorialId());
        artcl.setTitle(tutorial.getTitle());
        artcl.setCategory(tutorial.getCategory());
        entityManager.flush();
    }

    public void deleteTutorial(int tutorialId) {
        entityManager.remove(getTutorialById(tutorialId));
    }

    public boolean tutorialExists(String title, String category) {
        String hql = "FROM Tutorial as atcl WHERE atcl.title = ? and atcl.category = ?";
        int count = entityManager.createQuery(hql).setParameter(1, title)
                .setParameter(2, category).getResultList().size(); // size
        return count > 0 ? true : false;
    }
}