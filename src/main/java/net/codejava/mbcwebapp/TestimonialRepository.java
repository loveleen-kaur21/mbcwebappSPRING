package net.codejava.mbcwebapp;

import net.codejava.mbcwebapp.Testimonials;
import net.codejava.mbcwebapp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface TestimonialRepository extends JpaRepository<Testimonials, Long> {
    public List<Testimonials> findByUserId(Long id);
}



