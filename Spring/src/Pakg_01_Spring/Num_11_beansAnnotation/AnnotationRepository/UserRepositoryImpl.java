package Pakg_01_Spring.Num_11_beansAnnotation.AnnotationRepository;

import org.springframework.stereotype.Repository;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 18:15
 */

@Repository("UserRepository")
public class UserRepositoryImpl implements UserRepository{
    @Override
    public void save() {
        System.out.println("UserRepository Save...");
    }
}
