package net.codejava.mbcwebapp;

import net.codejava.mbcwebapp.Tip;
import net.codejava.mbcwebapp.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface TipRepository extends JpaRepository<Tip, Long> {
    public List<Tip> findByUserId(Long id);
}



