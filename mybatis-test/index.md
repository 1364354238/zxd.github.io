#Mybatis
>持久层框架，支持定制化SQL，存储过程以及高级映射，提供xml支持编写动态SQL,避免JDBC

# 持久层
> 数据持久化，就是将程序的数据在持久状态和瞬时状态转化的过程，

#流程
- 编写配置文件.xml，连接数据库
- sqlSessionFactory,加载配置文件
- Dao接口实现有接口实现类转换为.xml

# 万能Map
> 如果数据库参数过多，可以使用map

# 模糊查询
> 不要再SQL语句当中使用通配符，直接在输入的参数中加通配符
>
# mybatis核心配置文件
- environment：可以配置多个，但每个SQLSessionFactory实例只能选择一种环境（environments default）
- properties：引用外部配置文件
- typeAliases:
    - typeAlias：别名，作用范围是该语句下面所有语句
    - package: 将包下的所有类取别名，默认别名是小写类名
- @Alias：注解别名
- settings: mybatis中一些默认设置
    - CacheEnable：缓存是否开启，默认true
    - LazyLoadingEnable：延迟加载，默认false
    - useGeneratedKeys：允许JDBC自动生成主键，需要驱动支持，默认false
    - mapUnderscoreToCamelCase：自动驼峰命名规则映射，默认false
    - logImpl：指定mybatis所用日志的具体实现，默认未指定，未指定时自动查找
- mappers：绑定配置文件
    - resource：资源引用，xml相对路径
    - class：类，要求对应的xml必须同名，且在同一包下
    - package：扫描包下的类
    
# 生命周期和作用域
> 错误的使用会导致并发问题
- SqlSessionFactoryBuilder: 一旦创建就丢弃，作用域最好是方法作用域（也就是局部方法变量）
- SqlSessionFactory：一旦创建就一直存在，应用运行期间最好不要重复创建，最佳作用域是应用作用域
- SqlSession：每个线程都有自己的SqlSession实例，，不是线程安全的，不能被共享，返回响应就应该关闭它，
最佳作用域是请求或方法作用域
  
# 解决属性名与数据库字段名不一致的问题
> 例如属性名为password，字段名为psw,mybatis会在幕后创建一个resultMap，将字段名映射到JavaBean的属性上
- 方法1：SQL语句上起别名
- 方法2：resultMap，
```xml
<mapper namespace="com.example.dao.StudentMapper">
  <resultMap id="UserMap" type="com.example.pojo.User">
  <!--        column数据库中的字段，property实体类中的字段，相同的可以不写-->
  <!--        <result column="id" property="id"/>-->
  <!--        <result column="name" property="name"/>-->
          <result column="pwd" property="password"/>
    <!--如果实体类字段为对象，用association,集合用collection-->
  <association property="student1" column="tid" javaType="teacher" />
  </resultMap>
    <select id="get" resultMap="UserMap">
        select * from mybatis.user;
    </select>
</mapper>
```

# 日志工厂
> 如果一个数据库操作出现异常，我们需要排错，就需要日志.在mybatis的settings中设定
- settings，logImpl
    - LOG4j:可以控制日志信息的输出目的地，每一条日志的输出格式，定义每一条日志信息的级别，我们能够更加细致的
      控制日志的生成过程，可以通过配置文件来灵活配置
    - STDOUT_LOGGING
  
# 分页
- SQL实现分页：
```xml
<select id="getUserByLimit" parameterType="map" resultType="User">
        select *
        from mybatis.user limit #{startIndex},#{endIndex};
</select>
```
- java代码层实现分页：RowBounds
```java
class A{
public void test8(){
        SqlSession session=MybatisUtils.getSqlSession();
        RowBounds rowBound = new RowBounds(1, 2);
        List<User> userList = session.selectList("com.example.dao.UserDao.userList", null, rowBound);
        for (User user : userList) {
            System.out.println(user);
        }
        session.commit();
        session.close();
    }
}
```
- 第三方插件：pageHelper

# 注解
```java
public interface TestDao {
    @Select("select * from user where id=#{id}")
    public List<User> selectById(@Param("id")int id);
    
    @Insert("insert into user(id,name,psw) VALUES (#{id},#{name},#{psw})")
    public void insertUser(User user);
}
```

# Lombok
>pojo的注解支持
- @Data
- @AllArgsConstructor
- @NoArgsConstructor

# 查询嵌套
> 实质是数据库先查，然后将结果赋予resultMap
### 方式一
```xml
<mapper namespace="com.example.dao.StudentMapper">
  <resultMap id="result1" type="com.example.pojo.Student1">
<!--    column是子查询的输入参数-->
    <association property="teacher" column="tid" javaType="teacher" select="getTeacher"/>
  </resultMap>
  <select id="selectAll" resultMap="result1">
    select *
    from student1;
  </select>
  <select id="getTeacher" resultType="teacher">
    select *
    from teacher
    where id = ${id};
  </select>
</mapper>
```
### 方式二
```xml
<mapper namespace="com.example.dao.StudentMapper">
    <resultMap id="result2" type="student1">
      <result column="id" property="id"/>
      <result column="SName" property="name"/>
<!--      javaType 是字段名的属性，字段如果是集合，使用ofType-->
      <association property="teacher" javaType="teacher">
        <result property="name" column="TName"/>
      </association>
    </resultMap>
    <select id="selectSAndT" resultMap="result2">
      select s.id as id,s.name as SName,t.name as TName
      from student1 s,
      teacher t
      where s.tid = t.id;
    </select>
</mapper>
```

### 方式三
```xml
<mapper namespace="com.example.dao.TeacherMapper">
    <resultMap id="resultTeacher" type="teacher">
        <result column="tid" property="id"/>
        <result column="tname" property="name"/>
      <!--      javaType 是字段名的属性，字段如果是集合，使用ofType-->
        <collection property="student1s" ofType="student1">
            <result column="sid" property="id"/>
            <result column="sname" property="name"/>
        </collection>
    </resultMap>
    <select id="getStudents" resultMap="resultTeacher">
        select t.id as tid,t.name as tname,s.id as sid,s.name as sname
        from student1 s,teacher t
        where s.tid = t.id;
    </select>
</mapper>
```

# 动态SQL标签
> 根据不同的条件生成不同的SQL语句,使用jstl
### where（会删掉无关的and，or）
```xml
<mapper namespace="com.example.dao.BlogMapper">
    <select id="queryBlogIF" parameterType="map" resultType="com.example.pojo.Blog">
        select *
        from blog
      <where>
        <if test="title!=null">
          and title=#{title}
        </if>
        <if test="author!=null">
          and author=#{author}
        </if>
      </where>;
    </select>
</mapper>
```
### choose(只满足一个)
```xml
<mapper namespace="com.example.dao.BlogMapper">
  <select id="queryBlogChoose" parameterType="map" resultType="com.example.pojo.Blog">
    select *
    from blog
    <where>
      <choose>
        <when test="title!=null">
          and title=#{title}
        </when>
        <when test="author!=null">
          and author=#{author}
        </when>
        <otherwise>
          views=9676
        </otherwise>
      </choose>
    </where>
    ;
  </select>
</mapper>
```
### set(自动删除无关,)
```xml
<mapper namespace="com.example.dao.BlogMapper">
  <select id="queryBlogChoose" parameterType="map" resultType="com.example.pojo.Blog">
    select *
    from blog
    <update id="updateBlog" parameterType="map">
      update blog
      <set>
        <if test="title!=null">
          title=#{title},
        </if>
        <if test="author!=null">
          author=#{author}
        </if>
      </set>
      where id=#{id};
    </update>
  </select>
</mapper>
```
### where和set实质是trim
```xml
<update id="updateBlog" parameterType="map">
        update blog
<!--  前缀自动添加，后缀覆盖-->
        <trim prefix="set" suffixOverrides=",">
            <if test="title!=null">
                title=#{title},
            </if>
            <if test="author!=null">
                author=#{author}
            </if>
        </trim>
        where id=#{id};
    </update>
```
### include
> 直接插入SQL片段(最好基于单表,不要包含where标签)，实现代码的复用
### foreach
```xml
<!--    open：开始符号，close：结束符号，index：list的序号，map的key;separator:遍历元素之间的分隔符，item：遍历元素的别名-->
    <select id="queryBlogIn" parameterType="map" resultType="blog">
        select * from blog
        where id in
        <foreach collection="ids" open="(" close=")" separator="," item="ID">
            #{ID}
        </foreach>
    </select>
```
# 缓存
> 经常查询但不经常改变的数据可以使用缓存，mybatis定义了两级缓存，默认开启一级缓存，
> 增删改会刷新缓存
- 一级缓存：SqlSession级别的缓存，也称为本地缓存，session.close后失效
- 二级缓存：namespace级别的缓存，在Mapper.xml中加\<cache>,mybatis.xml中显式开启缓存，实体类implements Serializable
工作时，先将数据存在一级缓存，如果一级缓存关闭，将一级缓存中的数据放入二级缓存
  
### 缓存原理
> 每个SqlSession自带一个缓存，也就是一级缓存，每个Mapper.xml自带一个二级缓存，SqlSession与Mapper.xml是多对一的
> 关系，当SqlSession关闭时，一级缓存传给二级缓存。

### 缓存顺序
> 先查二级缓存，再查一级缓存

### 自定义缓存
> <catch type=" "