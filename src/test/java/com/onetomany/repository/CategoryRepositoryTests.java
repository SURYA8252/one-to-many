package com.onetomany.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.onetomany.entity.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {
	@Autowired
   private CategoryRepository categoryRepository;
   @Test
   public void testCreateCategory()
   {
	   Category savedCategory=categoryRepository.save(new Category("Automobile"));
	   assertThat(savedCategory.getId()).isGreaterThan(0);
   }
}
