package net.codejava.mbcwebapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestimonialsService {

    @Autowired
    private TestimonialRepository repo;

    public List<Testimonials> findAll() {
        return repo.findAll();
    }

    public void save(Testimonials testimonials) {
        repo.save(testimonials);
    }

//
//
//    public Testimonials get(long id) {
//        return repo.findById(id).get();
//    }
//
//    public void delete(long id) {
//        repo.deleteById(id);
//    }
}