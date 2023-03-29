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

# 面向切面AOP

## 代理模式

二十三种设计模式中的一种，属于结构型模式。它的作用就是通过提供一个代理类，让我们再调用目标方法的时候，不再是直接对目标方法进行调用，而是通过代理类间接调用。让不属于目标方法核心逻辑的代码从目标方法中剥离出来 -- **解耦**。调用目标方法时先调用代理对象的方法，减少对目标方法的调用和打扰，同时让附加功能能够集中在一起也有利于统一维护。

### 静态代理

静态代理确实实现了解耦，但是由于代码都写死了，完全不具备任何灵活性。就拿日志功能来说，将其他地方也需要附加日志，那还得再声明更多个静态代理类，那就产生了大量重复的代码，日志功能还是分散的，没有统一管理。

提出进一步的需求，将日志功能集中到一个代理类中，将来有任何日志需求，都通过这一个代理类来实现，这就需要使用动态代理技术了。

### 动态代理

```java
/**
 * @BelongsProject: spring6
 * @BelongsPackage: com.atguigu.aop
 * @author: 张世罡
 * @CreateTime: 2023/3/26 23:35
 * @Description:
 */
public class ProxyFactory {

    // 目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回代理对象
    public Object getProxy() {
        /**
         * Proxy.newProxyInstance()
         * 有是三个参数：
         * 1. ClassLoader：加载动态生成代理类的加载器
         * 2. Class[] interfaces：目标对象实现的所有接口的class类型数组
         * 3. InvocationHandler：设置代理对象实现目标对象方法的过程
         */
        ClassLoader classLoader = this.target.getClass().getClassLoader();
        Class<?>[] interfaces = this.target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // 方法调用前输出
                System.out.println("【动态代理】【日志】" + method.getName() + "方法开始了，参数是：" + Arrays.toString(args));
                // 调用目标方法
                Object result = method.invoke(target, args);
                // 方法调用后输出
                System.out.println("【动态代理】【日志】" + method.getName() + "方法结束了，结果是：" + result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
```

## AO概念及相关术语

AOP（Aspect Oriented Programming）是一种设计思想，是软件设计领域中的面向切面编程，它是面向对象编程的一种补充和完善，它以通过预编译方式和运行期动态代理方式实现，在不修改源代码的情况下，给程序动态统一添加额外功能的一种技术。利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。

### 相关术语

- 横切关注点
  
  - 分散在各个模块中解决同一样的问题，如用户验证、日志管理、事务管理、数据缓存都属于横切关注点
  
  - 从每个方法中抽取出来的同一类非核心业务。在同一个项目中，我们可以使用多个横切关注点对相关方法进行多个不同方面的增强。
  
  - 这个概念不是语法层面的，而是根据附加功能的逻辑上的需要：有十个附加功能，就有十个横切关注点。

- 通知（增强）
  
  - 增强，通俗说，就是你想要增强的功能，比如安全，事务，日志等。
  
  - 前置通知
  
  - 返回通知
  
  - 异常通知
  
  - 后置通知
  
  - 环绕通知

- 切面
  
  - 通知方法的类

- 目标
  
  - 被代理的目标对象

- 代理
  
  - 向目标对象应用通知之后创建的代理对象

- 连接点
  
  - 这也是一个纯逻辑概念，不是语法定义的
  
  - 把方法排成一排，每一个横切位置看成x轴方向，把方法从上到下执行的顺序看成y轴，x轴和y轴的交叉点就是连接点。通俗说，就是spring允许你使用通知的地方。

- 切入点
  
  - 定位连接点的方式

### 作用

- 简化代码：把方法中固定位置的重复的代码抽取出来，让被抽取的方法更专注于自己的核心功能。

- 代码增强：把特定功能封装到切面类中，看哪里有需要，就往上套，被套用了切面逻辑的方法就被切面给增强了。

### 动态代理分类：JDK动态代理和cglib动态代理

- 当目标类有接口的情况使用JDK动态代理，没有接口时，只能使用cglib动态代理

- JDK动态代理动态生成的代理会和目标在com.sum.proxy包下，类名为$proxy，和目标类实现相同的接口

- cglib动态代理生成的代理类会和目标在相同的包下，会继承目标类

- 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因为这个技术要求**代理对象和目标对象实现相同的接口** （两个兄弟拜把子模式）

- cglib：通过**继承被代理的目标类**（认干爹模式）实现原理，所以不需要目标类实现接口。

- AspectJ：是AOP设计思想的一种实现。本质上是静态代理，**将代理逻辑“织入”被代理目标类编译得到字节码文件**，所以最终效果是动态的。weave就是织入器。Spring只是借用了AspectJ注解。

### 基于注解的AOP

![](C:\Users\shiga\AppData\Roaming\marktext\images\2023-03-28-19-10-51-image.png)

### 基于XML的AOP

# 单元测试Junit

- 整合JUnit5

```java
// @ExtendWith(SpringExtension.class)
// @ContextConfiguration("classpath:bean.xml")
// 相当于上面2个注解
@SpringJUnitConfig(locations = "classpath:bean.xml")
class UserTest {

    @Autowired
    User user;

    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }
}
```

- 整合JUnit4

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringJunitTest4 {
    @Autowired
    private User user;

    @Test
    public void test() {
        System.out.println(user);
        user.run();
    }
}
```

# 事务

什么是事务：数据库事务（transaction）是访问并可能操作各种数据项的一个数据库操作序列，这些操作要么全部执行，要么全部不执行，是一个不可分割的工作单位。事务由事务开始与事务结束之间执行的全部数据库操作组成。

- 事务的特性：ACID、原子性、一致性、隔离性、持久性

编程式事务

## JdbcTemplate



## 声明式事务



## 基于注解的声明式事务

#### 准备工作

#### 测试无事务情况

### 加入事务

- 添加事务配置

```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	<property name="dataSource" ref="druidDataSource"/>
</bean>

<!--开启事务的注解驱动
	通过注解@Transactional所标识的方法或标识的类中所有的方法，都会事务被管理器管理事务
-->
<!--transaction-manage属性的默认值是transactionManager，如果事务管理器bean的id正好就是这个默认值，则可以省略这个属性-->
<tx:annotation-driven transaction-manager="transactionManager"/>
```

- 添加事务注解

- 观察结果

### @Transaction注解标识的位置

### 事务属性：只读

只能查询，不能修改、添加、删除

### 事务属性：超时

在设置超时之内没有完成，抛出异常回滚

### 事务属性：回滚策略

设置哪些异常不回滚

### 事务属性：隔离级别

读问题

### 事务属性：传播行为

事务方法之间调用，事务如何使用

### 全注解配置事务



## 基于MXL的声明式事务



# 资源操作：Resource

Java标准java.net.URL类和各种URL前缀的标准处理程序无法满足所有对low-level资源的访问，比如：没有标准化的URL实现可用于访问需要从类路径或相对于ServletContext获取的资源。并且缺少某些Spring所需要的功能，例如检测某资源是否存在等。而Spring的Resource声明了访问low-level资源的能力。

## Resource接口

## Resource的实现类

### UrlResource访问网络资源

### ClassPathResource访问类路径下资源

### FileSystemResource访问文件系统

### ServletContextResource

### InputStreamResource

### ByteArrayResource

## Resource类图

## ResourceLoader接口

## ResourceLoaderAware接口

## 使用Resource作为属性

## 应用程序上下文和资源路径



# 国际化：i18n

# 数据校验：Validation
