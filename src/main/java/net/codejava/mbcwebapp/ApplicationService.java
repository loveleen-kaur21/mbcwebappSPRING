package net.codejava.mbcwebapp;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    public Application get(long id) { return repo.findById(id).get(); }

//
//    @Override
//    public UserDetails loadApplicationByName(String name) throws UsernameNotFoundException {
//        Application application = repo.findByEmail(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return new CustomUserDetails(user);
//    }
}


