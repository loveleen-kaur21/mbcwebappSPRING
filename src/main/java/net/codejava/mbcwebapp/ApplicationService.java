package net.codejava.mbcwebapp;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApplicationService {

    @Autowired
    private ApplicationRepository repo;

    public void save(Application application) {
        repo.save(application);
    }

}


