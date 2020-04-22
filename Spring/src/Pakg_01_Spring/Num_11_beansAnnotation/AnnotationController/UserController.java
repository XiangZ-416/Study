package Pakg_01_Spring.Num_11_beansAnnotation.AnnotationController;

import Pakg_01_Spring.Num_11_beansAnnotation.AnnotationService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 18:27
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute() {
        userService.add();
        System.out.println("UserController execute");
    }

}
