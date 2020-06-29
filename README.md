# CAT 集成手册

## CAT server 部署启动

CAT 添加到项目的启动脚本中，可以通过项目脚本管理 CAT server 的启动与关闭。
CAT 也可以通过手动方式启动，cd ${project_root}/cat，通过 docker-compose 管理。

## CAT client 系统集成及埋点方式
根据子项目使用的编程语言不同，CAT client 的集成方式也不一致，以下提供三种语言集成方式：
### java 系统集成
1、 添加项目依赖
```xml
<dependency>
    <groupId>com.dianping.cat</groupId>
    <artifactId>cat-client</artifactId>
    <version>3.0.0</version>
</dependency>
```
如果存在 jar 包下载存在问题可以添加
```xml
<repository>
    <id>unidal.nexus</id>
    <url>http://unidal.org/nexus/content/repositories/releases/</url>
</repository>
```
2、 添加相关配置
添加注册服务名（向 CAT server 注册）：进入项目 ${project_root}/src/main/resources，
创建 META-INF/app.properties 文件并添加
```properties
app.name=you_project_name
```
添加 CAT 配置：进入项目 ${project_root}，创建 cat/conf/client.xml 并添加
```xml
<?xml version="1.0" encoding="utf-8"?>
<config mode="client">
    <servers>
        <server ip="cat" port="2280" http-port="8080"/>
    </servers>
</config>
```
3、添加 CatFilter 到项目中
对于 web项目，可添加 filter 到 web.xml
```xml
<filter>
    <filter-name>cat-filter</filter-name>
    <filter-class>com.dianping.cat.servlet.CatFilter</filter-class>
</filter>

<filter-mapping>
    <filter-name>cat-filter</filter-name>
    <url-pattern>/*</url-pattern>
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWARD</dispatcher>
</filter-mapping>
```
对于 spring boot 可通过注入添加 CatFilter
```java
@Configuration
public class CatFilterConfig {

    @Bean
    public FilterRegistrationBean<CatFilter> catFilter() {
        FilterRegistrationBean<CatFilter> frb = new FilterRegistrationBean<>();
        frb.setFilter(new CatFilter());
        frb.addUrlPatterns("/*");
        frb.setName("cat-filter");
        frb.setOrder(1);
        return frb;
    }
}
```
4、埋点方式
Cat 支持的埋点方式有四种 Transaction、Event、Heartbeat、Metric 详情参考：
https://github.com/dianping/cat/tree/master/lib/java
## CAT 平台基础操作指南

## Q/A

