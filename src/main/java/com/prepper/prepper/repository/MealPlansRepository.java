package com.prepper.prepper.repository;

import com.prepper.prepper.model.MealPlans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealPlansRepository extends JpaRepository<MealPlans, Integer> {
    // function to get meal plan by a specific date
    List<MealPlans> getByDate(LocalDate date);
}
