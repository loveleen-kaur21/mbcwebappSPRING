package net.codejava.mbcwebapp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipService {

    @Autowired
    private TipRepository repo;

    public List<Tip> findAll() {
        return repo.findAll();
    }

    public void save(Tip tip) {
        repo.save(tip);
    }

}