package class_loader;

import java.lang.reflect.Method;

/**
 * 测试自定义ClassLoader
 */
public class Main {

    public static void main(String[] args) {
        String path = "\\C:\\Users\\Administrator\\Desktop\\Hello\\";
        try {
//            URLClassLoader classLoader = (URLClassLoader)MyClassLoader.class.getClassLoader();
//            Method m = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
//            m.setAccessible(true);
//            m.invoke(classLoader,new File(path).toURL());
//
//            Class<?> hello = Class.forName("Hello", true, classLoader);
//            Method method = hello.getMethod("hello");
//            method.invoke(hello.newInstance());

            ClassLoader classLoader = new MyClassLoader(null,path);
            Method m = MyClassLoader.class.getDeclaredMethod("findClass", String.class);
            m.setAccessible(true);
            Class<?> hello = (Class<?>)m.invoke(classLoader, "Hello");
            Method method = hello.getMethod("hello");
            method.invoke(hello.newInstance());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
