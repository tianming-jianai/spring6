package com.atguigu.bean;

import com.atguigu.anno.Bean;
import com.atguigu.anno.DI;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.bean
 * @author: 张世罡
 * @CreateTime: 2023/3/26 9:38
 * @Description:
 */
public class AnnotationApplicationContext implements ApplicationContext {

    private String rootPath;
    // 创建map集合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 设置包扫描规则
    // 当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化

    public AnnotationApplicationContext(String basePackage) {
        // public static void path(String basePackage) {
        // com.atguigu
        // 获取包内class文件的绝对路径
        // 1. 把.替换成\
        String packagePath = basePackage.replaceAll("\\.", "\\\\");
        // 2. 获取包绝对路径
        try {
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), StandardCharsets.UTF_8);
                System.out.println(filePath);
                // 获取包前面路径部分，字符串截取
                this.rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                // 包扫描
                loadBean(new File(filePath));
            }
            loadDI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 属性注入
     */
    private void loadDI() {
        // 实例化对象在beanFactory的map集合里面
        // 1. 遍历beanFactory
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            // 2. 获取map集合每个对象（value），每个对象属性获取到
            Object obj = entry.getValue();
            // 获取对象Class
            Class clazz = obj.getClass();
            // 3. 遍历每个对象属性数组，得到每个属性
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 4. 判断属性上面是否有@DI注解
                DI di = field.getAnnotation(DI.class);
                if (di != null) {
                    // 如果是私有属性，设置可以访问
                    field.setAccessible(true);
                    // 5. 如果有@DI注解，把对象进行设置
                    try {
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    /**
     * 包扫描过程,实例化
     * @param file
     */
    private void loadBean(File file) throws Exception {
        // 1. 判断当前是否文件夹
        if (file.isDirectory()) {
            // 2. 获取文件夹里面所有内容
            File[] childrenFiles = file.listFiles();
            // 3. 判断文件夹里面为空，直接返回
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            // 4. 如果文件夹里面不为空，遍历文件夹所有内容
            for (File child : childrenFiles) {
                // 4.1 遍历得到每个File对象，继续判断，如果还是文件夹，递归
                if (child.isDirectory()) {
                    loadBean(child);
                } else {
                    // 4.2 遍历得到File对象不是文件夹，是文件
                    // 4.3 得到包路径+类名称部分 - 字符串截取
                    String pathWithClass = child.getAbsolutePath().substring(this.rootPath.length() - 1);
                    // 4.4 当前文件类型是否是.class
                    if (pathWithClass.endsWith(".class")) {
                        // 4.5 如果是.class类型，把路径\替换成. 把.class去掉
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        // com.atguigu.service.UserServiceImpl
                        // 4.6 判断类上面是否有注解@Bean，放到map集合beanFactory
                        // 4.6.1 获取类的Class
                        Class clazz = Class.forName(allName);
                        // 4.6.2 判断不是接口
                        if (!clazz.isInterface()) {
                            // 4.6.3 判断类上面是否有注解@Bean
                            Annotation annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                // 4.6.4 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.7 把对象实例化之后，放到map集合beanFactory
                                // 4.7.1 判断当前类如果有接口，让接口class作为map的key
                                if (clazz.getInterfaces().length > 0) {
                                    this.beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    this.beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
