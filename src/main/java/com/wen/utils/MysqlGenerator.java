package com.wen.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator; 
import com.baomidou.mybatisplus.generator.config.DataSourceConfig; 
import com.baomidou.mybatisplus.generator.config.GlobalConfig; 
import com.baomidou.mybatisplus.generator.config.PackageConfig; 
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType; 
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/** 
 * mybatis-plus 自动生成代码 
 * 
 * 
 */ 
public class MysqlGenerator { 
  @Test
  public void generateCode() { 
    //指定包名 
    String packageName = "com.wen"; 
    //user -> UserService, 设置成true: user -> IUserService 
    boolean serviceNameStartWithI = false; 
    //指定生成的表名 
    String[] tableNames = new String[]{"news"}; 
    generateByTables(serviceNameStartWithI, packageName, tableNames); 
  } 
  /** 
   * 根据表自动生成 
   * 
   * @param serviceNameStartWithI 默认为false 
   * @param packageName      包名 
   * @param tableNames      表名 
   */ 
  private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) { 
    //配置数据源 
    DataSourceConfig dataSourceConfig = getDataSourceConfig(); 
    // 策略配置 
    StrategyConfig strategyConfig = getStrategyConfig(tableNames); 
    //全局变量配置 
    GlobalConfig globalConfig = getGlobalConfig(serviceNameStartWithI); 
    //包名配置 
    PackageConfig packageConfig = getPackageConfig(packageName); 
    //自动生成 
    atuoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig); 
  } 
  /** 
   * 集成 
   * 
   * @param dataSourceConfig 配置数据源 
   * @param strategyConfig  策略配置 
   * @param config      全局变量配置 
   * @param packageConfig  包名配置 
   */ 
  private void atuoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) { 
    new AutoGenerator() 
        .setGlobalConfig(config) 
        .setDataSource(dataSourceConfig) 
        .setStrategy(strategyConfig) 
        .setPackageInfo(packageConfig) 
        .execute(); 
  } 
  /** 
   * 设置包名 
   * 
   * @param packageName 父路径包名 
   * @return PackageConfig 包名配置 
   */ 
  private PackageConfig getPackageConfig(String packageName) { 
    return new PackageConfig() 
        .setParent(packageName) 
        .setXml("mapper") 
        .setMapper("dao.repository") 
        .setController("controller") 
        .setEntity("dao.entity")
        //.setServiceImpl("service.serviceImpl")
        .setService("service"); 
  } 
  /** 
   * 全局配置 
   * 
   * @param serviceNameStartWithI false 
   * @return GlobalConfig 
   */ 
  private GlobalConfig getGlobalConfig(boolean serviceNameStartWithI) { 
    GlobalConfig globalConfig = new GlobalConfig(); 
    globalConfig 
        .setBaseColumnList(true) 
        .setBaseResultMap(true) 
        .setActiveRecord(false) 
        .setAuthor("Alex.wen") 
        //设置输出路径 
        .setOutputDir(getOutputDir("springboot_webPro")) 
        .setFileOverride(true); 
    if (!serviceNameStartWithI) { 
      //设置service名 
      globalConfig.setServiceName("%sService"); 
    } 
    return globalConfig; 
  } 
  /** 
   * 返回项目路径 
   * 
   * @param projectName 项目名 
   * @return 项目路径 
   */ 
  private String getOutputDir(String projectName) { 
    String path = this.getClass().getClassLoader().getResource("").getPath(); 
    int index = path.indexOf(projectName); 
    return path.substring(1, index) + projectName + "/src/main/java/"; 
  } 
  /** 
   * 策略配置 
   * 
   * @param tableNames 表名 
   * @return StrategyConfig 
   */ 
  private StrategyConfig getStrategyConfig(String... tableNames) { 
    return new StrategyConfig() 
        // 全局大写命名 ORACLE 注意 
        .setCapitalMode(true) 
        .setEntityLombokModel(false) 
        // 表名、字段名、是否使用下划线命名（默认 false） 
        .setDbColumnUnderline(true) 
        //从数据库表到文件的命名策略 
        .setNaming(NamingStrategy.underline_to_camel) 
        //需要生成的的表名，多个表名传数组 
        .setInclude(tableNames)
        // 此处可以修改为您的表前缀 
        .setTablePrefix(new String[] { "t_"});
  } 
  /** 
   * 配置数据源 
   * 
   * @return 数据源配置 DataSourceConfig 
   */ 
  private DataSourceConfig getDataSourceConfig() { 
    String dbUrl = "jdbc:mysql://localhost:3306/pos?serverTimezone=UTC&useSSL=false&autoReconnect=true&tinyInt1isBit=false&useUnicode=true&characterEncoding=utf8"; 
    return new DataSourceConfig().setDbType(DbType.MYSQL).setTypeConvert(new MySqlTypeConvert() {		
		@Override
		public DbColumnType processTypeConvert(String fieldType) {
			 String t = fieldType.toLowerCase();
		        if (t.contains("bigint")) {
		            return DbColumnType.BIG_INTEGER;
		        }
			return super.processTypeConvert(fieldType);
		}    	    	
    })
        .setUrl(dbUrl) 
        .setUsername("root") 
        .setPassword("123") 
        .setDriverName("com.mysql.cj.jdbc.Driver"); 
  } 
  /** 
   * 根据表自动生成 
   * 
   * @param packageName 包名 
   * @param tableNames 表名 
   */ 
  @SuppressWarnings("unused") 
  private void generateByTables(String packageName, String... tableNames) { 
    generateByTables(true, packageName, tableNames); 
  } 
} 