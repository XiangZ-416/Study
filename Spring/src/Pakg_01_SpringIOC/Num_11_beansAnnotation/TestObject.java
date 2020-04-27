package Pakg_01_SpringIOC.Num_11_beansAnnotation;

import org.springframework.stereotype.Component;

/**
 * @Description: //TODO 组件扫描(component scanning): Spring 能够从 classpath 下自动扫描, 侦测和实例化具有特定注解的组件.
 *                      特定组件包括:
 *                           @Component: 基本注解, 标识了一个受 Spring 管理的组件
 *                           @Respository: 标识持久层组件
 *                           @Service: 标识服务层(业务层)组件
 *                           @Controller: 标识表现层组件
 *                      对于扫描到的组件, Spring 有默认的命名策略: 使用非限定类名, 第一个字母小写. 也可以在注解中通过 value 属性值标识组件的名称
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/4/21 18:04
 */

@Component
public class TestObject {

}
