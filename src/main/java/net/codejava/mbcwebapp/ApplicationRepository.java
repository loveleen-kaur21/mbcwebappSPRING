package net.codejava.mbcwebapp;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    public List<Application> findByUserId(Long id);
}