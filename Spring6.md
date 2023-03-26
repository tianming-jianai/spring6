# Spring6

![](C:\Users\shiga\AppData\Roaming\marktext\images\2023-03-24-20-07-35-image.png)

对象创建之后放在哪里？

org.springframework.beans.factory.support.DefaultListableBeanFactory#beanDefinitionMap

日志级别：

级别高的会自动屏蔽级别低的日志

IOC: 是Inversion of Control的简写，译为“控制反转”

Spring通过IOC容器来管理所有java对象的实例化和初始化，控制对象与对象之间的依赖关系。

我们将由IOC容器管理的Java对象称为SpringBean它与使用关键字new创建的Java对象没有任何区别

## IoC容器

- 控制反转是一种思想

- 控制反转是为了降低程度的耦合度，提高程序扩展力

- 控制反转，反转的是什么？
  
  - 将对象的创建权利交出去，交给第三方容器负责
  
  - 将对象和对象之间关系的维护权交出去，交给第三方容器负责

- 控制反转这种思想如何实现？
  
  - DI（Dependency Injection）：依赖注入

### 依赖注入

依赖注入实现了控制反转的思想

- 指Spring创建对象的过程中，将对象依赖属性通过配置进行注入

依赖注入常见的实现方式包括两种：

- set注入

- 构造注入

所以结论是：IOC是一种控制反转的思想，而DI是对IOC的一种具体实现

Bean管理：Bean对象的创建，以及Bean对象中属性的赋值（或者叫做Bean对象之间关系的维护）

### IOC容器在Spring的实现

## 基于XML管理Bean

获取bean的方式：id/类型/id和类型

如果组件类实现了接口，根据接口类型可以获取bean吗？

> 可以，前提是bean唯一

如果一个接口有多个实现类，这些实现类都配置了bean，根据接口类型可以获取bean吗？

> 不行，因为bean不行

结论：

根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：对象instance of指定的类型，的返回结果，只要返回的是true就可以认定为何类型匹配，能够获取到。

Java中，instanceof运算符用于判断前面的对象是否是后面的类、实现类的实例。如果返回true，否则返回false。也就是说：用instance of关键字做判断时，instance of操作符的左右操作必须有继承或实现关系。

## setter/constructor注入

```xml
<!-- 1. set注入 -->
<bean id="book" class="com.atguigu.di.Book">
    <property name="bname" value="vue"/>
    <property name="author" value="尚硅谷"/>
</bean>

<!-- 2. 构造器注入 -->
<bean id="bookCon" class="com.atguigu.di.Book">
    <constructor-arg name="bname" value="java开发"/>
    <constructor-arg name="author" value="尚硅谷"/>
</bean>
```

## 注入特殊值处理

- 字面量

- null

- xml实体

- CDATA

```xml
<property name="author" value="尚硅谷"/>
<!--<property name="others">
    <null/>
</property>-->
<!--<property name="others" value="<>"/>-->
<property name="others">
    <value><![CDATA[a < b]]></value>
</property>
```

## 特殊类型属性注入（对象）

- 方式一：引用外部bean

- 方式二：内部bean

- 方式三：级联属性赋值

```xml
<!--第一种方式：引入外部bean-->
<bean id="dept" class="com.atguigu.ditest.Dept">
    <property name="dname" value="安保部"/>
</bean>
<bean id="emp" class="com.atguigu.ditest.Emp">
    <!-- 普通属性注入 -->
    <property name="ename" value="lucy"/>
    <property name="age" value="50"/>
    <!-- 注入对象类属性
     private Dept dept; -->
    <property name="dept" ref="dept"/>
</bean>

<!--第二种方式：引入外部bean-->
<bean id="emp2" class="com.atguigu.ditest.Emp">
    <property name="ename" value="mary"/>
    <property name="age" value="20"/>
    <property name="dept">
        <bean id="dept2" class="com.atguigu.ditest.Dept">
            <property name="dname" value="财务部"/>
        </bean>
    </property>
</bean>

<!--第三种方式：级联赋值-->
<bean id="dept3" class="com.atguigu.ditest.Dept">
    <property name="dname" value="技术研发部"/>
</bean>
<bean id="emp3" class="com.atguigu.ditest.Emp">
    <property name="ename" value="tom"/>
    <property name="age" value="30"/>
    <property name="dept" ref="dept3"/>
    <property name="dept.dname" value="测试部"/>
</bean>
```

## 依赖注入-数组类型属性

## 依赖注入-集合属性

## 依赖注入-map属性

## 依赖注入-引入集合bean

## p命名空间

## 引入外部属性文件

# bean的作用域

scop: 

- singleton(默认)单实例, IOC容器初始化时创建

- prototype多实例，获取bean时创建

webApplicationContext环境中还会有另外几个作用域（但不常用）

- request/session

# bean生命周期

1. bean对象创建（调用无参构造）

2. 给bean对象设置相关属性

3. bean后置处理器（初始化之前）

4. bean对象初始化（调用指定初始化方法）

5. bean后置处理器（初始化之后）

6. bean对象创建完成了，可以使用了

7. bean对象销毁，配置指定销毁的方法

8. IOC容器关闭了

# FactoryBean

经常用于整合第三方框架

# 基于Xml自动装配

根据指定的策略，在IOC容器中匹配一个bean，自动为指定的bean中所依赖的类类型属性赋值

byType类型、byName名称

# 基于注解管理Bean

## 搭建子模块spring-ioc-annotation

## 开启组件扫描

Spring默认不使用注解装配Bean，因此我们需要在Spring的xml配置中，通过context:component-scan元素开启Spring Beans自动扫描功能。开启此功能之后，Spring会自动从扫描指定的包（base-package属性设置）及其子包下的所有类，如果类上使用了@Component注解，就将该类装配到容器中。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/b
eans http://www.springframework.org/schema/beans/spring-beans
.xsd http://www.springframework.org/schema/con
text http://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启组件扫描-->
    <context:component-scan base-package="com.atguigu"/>
</beans>
```

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans
        xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/b
eans http://www.springframework.org/schema/beans/spring-beans
.xsd http://www.springframework.org/schema/con
text http://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启组件扫描-->
    <!--情况一：最基本的扫描方式-->
    <context:component-scan base-package="com.atguigu"/>
    <!--情况二：指定要排除的组件-->
    <context:component-scan base-package="com.atguigu">
        <!--context:exclude-filter: 指定排除规则-->
        <!--
            type: 设置排除或包含的依据
            type="annotation"，根据注解排除，expression中设置要排除的注解的全类名
            type="assignable"，根据类型排除，expression中设置要排除的类型的全类名
        -->
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <!--<context:exclude-filter type="assignable" expression="com.atguigu.pojo.User"/>-->
    </context:component-scan>
    <!--情况三：只扫描指定组件-->
    <context:component-scan base-package="com.atguigu" use-default-filters="false">
        <!--context:include-filter标签：指定在原有扫描规则的基础上追加的规则-->
        <!--use-default-filters属性：取值false表示关闭默认扫描规则-->
        <!--此时必须设置use-default-filters="false",因为默认规则即扫描指定包下所有类-->
        <!--
            type: 设置排除或包含的依据
            type="annotation"，根据注解排除，expression中设置要排除的注解的全类名
            type="assignable"，根据类型排除，expression中设置要排除的类型的全类名
        -->
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
        <!--<context:include-filter type="assignable" expression="com.atguigu.pojo.User"/>-->
    </context:component-scan>
</beans>
```

## @Autowired注入

默认根据类型byType匹配

使用范围：属性、setter方法、构造方法、构造方法参数

```java
@Controller
public class UserController {

    // 注入service
    // 第一种方式：属性注入
    @Autowired
    private UserService userService;

    // 第二种：set方式注入
    private UserService userService;
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 第三种：构造方法注入
    private UserService userService;
    
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 第四种：形参上注入
    private UserService userService;
    
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    // 第五种：只有一个有参构造函数，无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
```

## @Resource注入

JDK扩展包中的，该注解是标准注解，更加具有通用性。@Autowired是Spring框架自己的

@Resource注解默认根据名称装配byName，未指定name时，使用属性作为name。通过name找不到的话会自动启动，通过类型byType装配。

@Autowired注解默认根据类型装配byType，如果想根据名称装配，需要配合@Qualifier注解一起用。

使用范围：属性、setter方法

@Resource属于JDK扩展包，所以不在JDK当中，需要额外引入一下依赖，【高于JDK11或低于JDK8需要引入一下依赖】

```xml
<dependency>
	<groupId>jakarta.annotation</groupId>
	<artifactId>jakarta.annotation-api</artifactId>
	<version>2.1.1</version>
</dependency>
```

## Spring全注解开发

```java
@Configuration
@ComponentScan("com.atguigu")
public class SpringConfig {
}

ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
UserController controller = ctx.getBean("userController", UserController.class);
controller.addUser();
```

# 手写IOC

## 步骤分析

- 第一步：创建子模块：guigu-spring

- 第二步：创建测试类：service,dao

- 第三步：创建两个注解：@Bean创建对象/@DI属性注入

- 第四步：创建bean容器接口ApplicationContext，定义方法，返回对象

- 第五步：实现bean容器接口
  
  1. 返回对象
  
  2. 根据包规则加载bean，比如com.atguigu，扫描com.atguigu这个包里面所有类，看类上面是否有@Bean注解，如果有，把这个类通过反射实例化



```java
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
```


