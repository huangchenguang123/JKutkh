package com.sharepower.JKutkh.classloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

import lombok.SneakyThrows;

/**
 * @date 2020/12/22
 * @author chenguang
 * @desc JkutkhClassLoader is used to load class/jar from web or local
 */
public class JkutkhClassLoader extends ClassLoader {

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc load one class
     */
    @SneakyThrows
    public void loadClass(String url, String className) {
        // read byte array from url
        String path = classNameToPath(url, className);
        URL classUrl = new URL(path);
        InputStream ins = classUrl.openStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int bytesNumRead = 0;
        // read bytes
        while ((bytesNumRead = ins.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesNumRead);
        }
        byte[] classData = byteArrayOutputStream.toByteArray();
        // load class
        defineClass(className, classData, 0, classData.length);
    }

    /**
     * @date 2020/12/22
     * @author chenguang
     * @desc className to classPath
     */
    private String classNameToPath(String url, String className) {
        return url + "/" + className.replace('.', '/') + ".class";
    }

}
