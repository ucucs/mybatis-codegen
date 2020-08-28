package com.ucucs.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.Properties;

public class CodeGenerator {

  public MybatisPlusConfig initConfig() throws Exception {
    Properties properties = new Properties();
    InputStream in =
        CodeGenerator.class.getClassLoader().getResourceAsStream("generator.properties");
    properties.load(in);
    return MybatisPlusConfig.loadConfig(properties);
  }

  @Test
  public void generateCode() throws Exception {
    MybatisPlusConfig config = initConfig();
    generateByTables(config);
  }

  private void generateByTables(MybatisPlusConfig config) {
    // 配置数据源
    DataSourceConfig dataSourceConfig = getDataSourceConfig(config);
    // 策略配置
    StrategyConfig strategyConfig = getStrategyConfig(config);
    // 全局变量配置
    GlobalConfig globalConfig = getGlobalConfig(config);
    // 包名配置
    PackageConfig packageConfig = getPackageConfig(config);
    // 生成模版配置
    TemplateConfig templateConfig = getTemplateConfig();
    // 自动生成
    autoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig, templateConfig);
  }

  private void autoGenerator(
      DataSourceConfig dataSourceConfig,
      StrategyConfig strategyConfig,
      GlobalConfig config,
      PackageConfig packageConfig,
      TemplateConfig templateConfig) {
    AutoGenerator generator =
        new AutoGenerator()
            .setGlobalConfig(config)
            .setDataSource(dataSourceConfig)
            .setStrategy(strategyConfig)
            .setPackageInfo(packageConfig)
            .setTemplateEngine(new VelocityTemplateEngine())
            .setTemplate(templateConfig);
    generator.execute();
  }

  private DataSourceConfig getDataSourceConfig(MybatisPlusConfig config) {
    return new DataSourceConfig()
        .setDbType(DbType.getDbType(config.getDbType()))
        .setUrl(config.getDbUrl())
        .setUsername(config.getUserName())
        .setPassword(config.getPassword())
        .setDriverName(config.getDriverClassName());
  }

  private PackageConfig getPackageConfig(MybatisPlusConfig config) {
    return new PackageConfig()
        .setParent(config.getPackageName())
        .setModuleName(config.getModuleName())
        .setController("controller")
        .setEntity("model")
        .setService("service")
        .setServiceImpl("service.impl")
        .setMapper("mapper")
        .setXml("mapper");
  }

  private GlobalConfig getGlobalConfig(MybatisPlusConfig config) {
    GlobalConfig globalConfig = new GlobalConfig();
    globalConfig
        .setBaseColumnList(true)
        .setBaseResultMap(true)
        .setActiveRecord(false)
        .setBaseColumnList(false)
        .setAuthor(config.getAuthor())
        .setOutputDir(getOutputDir(config))
        .setDateType(DateType.TIME_PACK)
        .setFileOverride(true);
    if (config.isUseServiceSuffix()) {
      globalConfig.setServiceName("%sService");
    }
    return globalConfig;
  }

  private TemplateConfig getTemplateConfig() {
    TemplateConfig templateConfig = new TemplateConfig();
    templateConfig.setController("");
    return templateConfig;
  }

  private String getOutputDir(MybatisPlusConfig config) {
    String fileSeparator = System.getProperty("file.separator");
    String path = String.format("%s/%s", config.getProjectPath(), config.getBasePath());
    return path.replace("/", fileSeparator).replace("\\", fileSeparator);
  }

  private StrategyConfig getStrategyConfig(MybatisPlusConfig config) {
    return new StrategyConfig()
        .setNaming(NamingStrategy.underline_to_camel)
        .setColumnNaming(NamingStrategy.underline_to_camel)
        .setEntityLombokModel(true)
        .setInclude(config.getTableNames());
  }
}
