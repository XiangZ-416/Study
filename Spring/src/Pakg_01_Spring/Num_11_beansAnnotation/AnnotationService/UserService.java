package Pakg_01_Spring.Num_11_beansAnnotation.AnnotationService;

import Pakg_01_Spring.Num_11_beansAnnotation.AnnotationRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 18:16
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add() {
        userRepository.save();
        System.out.println("UserService add...");
    }

}
