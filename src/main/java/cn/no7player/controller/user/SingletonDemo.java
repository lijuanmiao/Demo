package cn.no7player.controller.user;

/**单例模式
 * Created by lijm on 2018-03-07.
 */
public class SingletonDemo {

    private static SingletonDemo instance;

    private SingletonDemo() {

    }

    public static SingletonDemo getInstance() {

        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }
}
