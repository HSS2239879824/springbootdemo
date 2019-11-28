##链接
[GIt 的东西](https://github.com/HSS2239879824/springbootdemo)
[flaway学习的一个网站](https://flywaydb.org/getstarted/firststeps/maven)
[授权登录Api](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)
[lombok](https://projectlombok.org/)
##工具
UML类图 工具
##Mysql时区问题
set global time_zone='+8:00';
##依赖
<!--OKHttp的maven依赖-->
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>3.3.0</version>
</dependency>
<!--H2数据库-->
<!-- https://mvnrepository.com/artifact/com.h2database/h2 -->
<dependency>
    <groupId>com.h2database</groupId>
     <artifactId>h2</artifactId>
     <version>1.4.200</version>
     <scope>test</scope>
</dependency>

<!--flyway数据库版本控制工具-->
<!--flyway的插件配置以及他的依赖-->
<plugin>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-maven-plugin</artifactId>
    <version>6.0.8</version>
    <configuration>
        <url>jdbc:mysql://localhost:3306/allknow?serverTimezone=GMT </url>
        <user>root</user>
        <password>123456</password>
    </configuration>
    <dependencies>
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <version>1.4.197</version>
        </dependency>
    </dependencies>
</plugin>


