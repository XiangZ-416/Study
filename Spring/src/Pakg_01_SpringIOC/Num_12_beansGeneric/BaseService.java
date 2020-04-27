package Pakg_01_SpringIOC.Num_12_beansGeneric;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create£º 2020/4/21 21:35
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add...");
        System.out.println(repository);
    }

}
