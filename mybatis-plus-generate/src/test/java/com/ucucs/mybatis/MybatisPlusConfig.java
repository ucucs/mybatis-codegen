package com.ucucs.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.util.Properties;

@Getter
@Setter
public class MybatisPlusConfig {

  private String dbType;
  private String dbUrl;
  private String driverClassName;
  private String userName;
  private String password;
  private String projectName;
  private String packageName;
  private String moduleName;
  private String author;
  private String[] tableNames;
  private boolean useServiceSuffix;
  private String projectPath;
  private String basePath;
  private String mapperPath;

  public static MybatisPlusConfig loadConfig(Properties properties) {
    MybatisPlusConfig config = new MybatisPlusConfig();
    config.setDbType(properties.getProperty("dbtype"));
    config.setDbUrl(properties.getProperty("jdbc.connectionURL"));
    config.setDriverClassName(properties.getProperty("jdbc.driverClass"));
    config.setUserName(properties.getProperty("jdbc.userId"));
    config.setPassword(properties.getProperty("jdbc.password"));
    config.setProjectName(properties.getProperty("projectName"));
    config.setPackageName(properties.getProperty("packageBase"));
    config.setModuleName(properties.getProperty("moduleName"));
    config.setAuthor(properties.getProperty("author"));
    config.setUseServiceSuffix(properties.getProperty("useServiceSuffix").equalsIgnoreCase("true"));
    config.setTableNames(new String[] {properties.getProperty("tableName")});
    config.setProjectPath(System.getProperty("user.dir"));
    config.setBasePath(properties.getProperty("basePath"));
    config.setMapperPath(properties.getProperty("mapperPath"));
    return config;
  }
}
