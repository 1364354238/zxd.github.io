# java中反射机制

- [概述](#概述)

- [原理](#原理)

- [使用](#使用)

- [作用](#作用)

## <a name='概述'>概述</a>
> 可以在运行时不通过创建类对象，而直接获取未知 类的所有方法和属性，增加java的动态性。

## <a name='原理'>原理</a>
 java程序包含编译和运行两个阶段：

 1.编译阶段：java文件通过jdk编译为.class字节码文件
 
 2.运行阶段：jre里的类加载器加载.class文件（可从网络上读取class文件，也可以从本地磁盘上读取class文件），然后校验，准备，解析，
 最后JVM将字节码解释为机器语言。

 我们new一个对象时，jvm会自动为该类创建一个（仅一个）class。反射是从该class开始的。
 
 获得字节码文件的方式有：
 
 1.Class.forName("classname");
 
 2.object.getClass()
 
 3.类名.class;

## <a name='使用'>使用</a>
1.获取类的构造函数，创建类对象
```java
Class <?> book=Class.forName("test.Book");
//无参和有参都能获取
Constructor<?> []constructorBook=book.getDeclaredConstructors();
for(Constructor con:constructorBook){
 //判断有参，无参
 if(con.getParamenterCount()>0){
   //有参
   
 }else{
   //无参
   //创建类对象
   Book obj=(Book) con.newInstance();
 }
}
```
2.获取类的方法,调用方法,(先递归查找父类的方法，在获取自身的方法)
```java
Class <?> book=Class.forName("test.Book");
//获取所有public函数，包括父类的public函数
Method []pm=book.getMethods();
//获取所有函数，包括私有函数，包括父类
Method []prm=book.getDeclaredMethods();
//获取指定方法
Method m=book.getDeclaredMethods("方法名",参数的类(例如String.class));

//调用方法
m.invoke(对象,参数)
//调用静态方法
m.invoke(null，参数)
//调用私有方法
m.setAccessible(true);
m.invoke(对象,参数)
//调用main方法(参数是数组时)
m.invoke(null,new Object[]{数组参数};

```
3.获取类的属性
``` java
Class <?> book=Class.forName("test.Book");
//获取所有public属性
Field [] puf=book.getFields();
//获取所有属性
Field []prf=book.getDeclaredFields();
//获取指定类的属性
Field f=book.getDeclaredFields("属性名");

//查看属性值
f.get(类对象);
//查看私有属性
f.setAccessible(true);
f.get(类对象);
//修改属性
f.set(类对象,新属性值);
//修改静态属性
f.set(null,新的属性值);
```
## <a name='作用'>作用</a>
提高代码的灵活性，扩展性。

> 反射效率低的原因
> 1.Method#invoke 方法会对参数做封装和解封操作。
> 2.需要检查方法可见性
> 3.反射方法难以内联
> 4.JIT(Just In Time)无法优化，

