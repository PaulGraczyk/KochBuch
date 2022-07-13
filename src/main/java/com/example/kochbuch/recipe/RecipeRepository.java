package com.example.kochbuch.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("select r from Recipe r order by r.numberOfLikes desc")
    List<Recipe> findTopByNumberOfLikes(Pageable pageable);
}
