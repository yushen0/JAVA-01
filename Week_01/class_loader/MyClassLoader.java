package class_loader;

import java.io.*;

/**
 * 自定义ClassLoader
 */
public class MyClassLoader extends ClassLoader {

    private static String path;

    public MyClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] classBytes = readClass(name);
        return defineClass(name, classBytes, 0, classBytes.length);
    }

    /**
     * 读取文件字节码
     * @param name
     * @return
     */
    private byte[] readClass(String name) {
        String classPath = new StringBuffer(path).append(name).append(".class").toString();
        File file = new File(classPath);

        if (!file.exists()) {
            return new byte[0];
        }

        InputStream fis = null;
        ByteArrayOutputStream bos = null;
        byte[] bytes = new byte[1024];

        byte[] readBytes = null;
        try {
            bos = new ByteArrayOutputStream();
            fis = new FileInputStream(file);
            int length;
            while((length = fis.read(bytes)) != -1){
                bos.write(bytes,0,length);
            }
            readBytes = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return readBytes;
    }
}
