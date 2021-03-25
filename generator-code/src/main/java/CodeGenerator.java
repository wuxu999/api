import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wuxu
 * @date 2021-03-22
 */
public class CodeGenerator {

    private static final String CLASS_PATH = "src/main/java";
    private static final String RESOURCE_PATH = "src/main/resources";

    public static void main(String[] args) {
        generator("wuxu",
                "jdbc:mysql://localhost:3306/api?useUnicode=true&useSSL=false&characterEncoding=utf8",
                "com.mysql.jdbc.Driver",
                "root",
                "password",
                "com.wx.api",
                "api-service",
                "api_definition", "api_group", "api_instance", "api_instance_template", "api_template_definition");
    }

    /**
     * Mybatis一键生成entity,mapper,mapper.xml,service,serviceImpl,controller
     *
     * @param author         开发人员
     * @param url            驱动连接的URL
     * @param driverName     驱动名称
     * @param username       数据库连接用户名
     * @param password       数据库连接密码
     * @param parent         父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @param projectModule  项目模块包名
     * @param functionModule 功能模块包名
     * @param tableName      表名
     */
    public static void generator(String author,
                                 String url,
                                 String driverName,
                                 String username,
                                 String password,
                                 String parent,
                                 String projectModule,
                                 String... tableName) {
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(globalConfig(author, projectModule));
        mpg.setDataSource(dataSourceConfig(url, driverName, username, password));
        mpg.setPackageInfo(packageConfig(parent));
        mpg.setTemplate(templateConfig());
        mpg.setStrategy(strategyConfig(tableName));
        mpg.setTemplateEngine(new BeetlTemplateEngine());
        mpg.execute();
    }

    /**
     * 全局配置
     *
     * @param author        开发人员
     * @param projectModule 项目模块包名
     * @return GlobalConfig
     */
    private static GlobalConfig globalConfig(String author, String projectModule) {
        String projectPath = System.getProperty("user.dir");
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath + "/" + projectModule + "/src/main/java");
        globalConfig.setFileOverride(true);
        globalConfig.setAuthor(author);
        globalConfig.setOpen(false);
        globalConfig.setBaseResultMap(true);
        globalConfig.setBaseColumnList(true);
        globalConfig.setEntityName("%s");
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");
        globalConfig.setServiceName("%sService");
        globalConfig.setServiceImplName("%sServiceImpl");
        globalConfig.setControllerName("%sController");
        return globalConfig;
    }

    /**
     * 数据源设置
     *
     * @param url        驱动连接的URL
     * @param driverName 驱动名称
     * @param username   数据库连接用户名
     * @param password   数据库连接密码
     * @return DataSourceConfig
     */
    private static DataSourceConfig dataSourceConfig(String url,
                                                     String driverName,
                                                     String username,
                                                     String password) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl(url);
        dataSourceConfig.setDriverName(driverName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        return dataSourceConfig;
    }

    /**
     * 包配置
     *
     * @param parent         父包名。如果为空，将下面子包名必须写全部， 否则就只需写子包名
     * @return PackageConfig
     */
    private static PackageConfig packageConfig(String parent) {
        String projectPath = System.getProperty("user.dir");
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(parent);
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("service.mapper");
        packageConfig.setXml("Mapper");
        packageConfig.setController("controller");

        String entityPath = joinClassPath(projectPath, "api-bean");
        String servicePath = joinClassPath(projectPath, "api-service");
        String xmlPath = joinResourcePath(projectPath, "api-service");
        String webPath = joinClassPath(projectPath, "api-web");

        // 自定义生成路径信息
        Map<String, String> pathInfo = new HashMap<>(10);
        pathInfo.put(ConstVal.ENTITY_PATH, joinPath(entityPath, joinPackage(parent, packageConfig.getEntity())));
        pathInfo.put(ConstVal.MAPPER_PATH, joinPath(servicePath, joinPackage(parent, packageConfig.getMapper())));
        pathInfo.put(ConstVal.XML_PATH, joinPath(xmlPath, packageConfig.getXml()));
        pathInfo.put(ConstVal.SERVICE_PATH, joinPath(servicePath, joinPackage(parent, packageConfig.getService())));
        pathInfo.put(ConstVal.SERVICE_IMPL_PATH, joinPath(servicePath, joinPackage(parent, packageConfig.getServiceImpl())));
        pathInfo.put(ConstVal.CONTROLLER_PATH, joinPath(webPath, joinPackage(parent, packageConfig.getController())));
        packageConfig.setPathInfo(pathInfo);

        return packageConfig;
    }

    /**
     * 模板路径配置项
     *
     * @return TemplateConfig
     */
    private static TemplateConfig templateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(ConstVal.TEMPLATE_CONTROLLER);
        templateConfig.setEntity(ConstVal.TEMPLATE_ENTITY_JAVA);
        templateConfig.setMapper(ConstVal.TEMPLATE_MAPPER);
        templateConfig.setService(ConstVal.TEMPLATE_SERVICE);
        templateConfig.setServiceImpl(ConstVal.TEMPLATE_SERVICE_IMPL);
        templateConfig.setXml(ConstVal.TEMPLATE_XML);
        return templateConfig;
    }

    /**
     * 策略配置
     *
     * @param tableName 数据库表名称，多个用英文逗号隔开
     * @return StrategyConfig
     */
    private static StrategyConfig strategyConfig(String... tableName) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setChainModel(true);
        strategyConfig.setEntityColumnConstant(true);
        strategyConfig.setLogicDeleteFieldName("is_deleted");
        List<TableFill> tableFillList = new ArrayList<>();
        tableFillList.add(new TableFill("create_time", FieldFill.INSERT));
        tableFillList.add(new TableFill("update_time", FieldFill.INSERT_UPDATE));
        strategyConfig.setTableFillList(tableFillList);
        return strategyConfig;
    }

    /**
     * 连接路径字符串
     *
     * @param parentDir   路径常量字符串
     * @param packageName 包名
     * @return 连接后的路径
     */
    private static String joinPath(String parentDir, String packageName) {
        if (StringUtils.isBlank(parentDir)) {
            parentDir = System.getProperty(ConstVal.JAVA_TMPDIR);
        }
        if (!StringUtils.endsWith(parentDir, File.separator)) {
            parentDir += File.separator;
        }
        packageName = packageName.replaceAll("\\.", StringPool.BACK_SLASH + File.separator);
        return parentDir + packageName;
    }


    private static String joinClassPath(String projectPath, String moduleName) {
        return projectPath + StringPool.SLASH + moduleName + StringPool.SLASH + CLASS_PATH;
    }

    private static String joinResourcePath(String projectPath, String moduleName) {
        return projectPath + StringPool.SLASH + moduleName + StringPool.SLASH + RESOURCE_PATH;
    }


    /**
     * 连接父子包名
     *
     * @param parent     父包名
     * @param subPackage 子包名
     * @return 连接后的包名
     */
    private static String joinPackage(String parent, String subPackage) {
        if (StringUtils.isBlank(parent)) {
            return subPackage;
        }
        return parent + StringPool.DOT + subPackage;
    }
}
