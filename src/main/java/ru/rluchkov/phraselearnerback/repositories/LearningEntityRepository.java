package ru.rluchkov.phraselearnerback.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.rluchkov.phraselearnerback.entities.LearningEntity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LearningEntityRepository extends WithUUIDRepository<LearningEntity> {

    @Query("select le from LearningEntity le where le.lastReviewed <= :lastReviewed and le.reviewsCount = (:reviewsCount - 1)")
    List<LearningEntity> findByReviewsCountAndLastReviewedIsLessThanEqual(Integer reviewsCount, LocalDate lastReviewed);

    @Query("select le from LearningEntity le where le.learningPassage ilike %:searchingString%")
    Page<LearningEntity> findByLearningPassageSortedPageable(String searchingString, Pageable pageable);
}
