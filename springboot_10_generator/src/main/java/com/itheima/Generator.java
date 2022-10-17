package com.itheima;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;

public class Generator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator;
        autoGenerator = new AutoGenerator();
// 1.配置
        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/javaweb?useUnicode=true;characterEncoding=UTF-8;GMT%2B8");
        dataSource.setUsername("root");
        dataSource.setPassword("missk72387");
        autoGenerator.setDataSource(dataSource);

        // 设置全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        // 设置模板生成的位置
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/springboot_10_generator/src/main/java");
        globalConfig.setOpen(false); // 设置生成完毕后是否打开生成代码所在的目录
        globalConfig.setAuthor("小龙"); // 设置作者
        globalConfig.setFileOverride(true); // 设置是否覆盖原始生成文件
        globalConfig.setMapperName("%sDao"); // 设置数据层接口名，%s作为占位符，指代模块名称
        globalConfig.setIdType(IdType.ASSIGN_ID); // 设置ID生成策略
        autoGenerator.setGlobalConfig(globalConfig); // 加载全局配置

        // 设置包名相关配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.itheima"); // 设置生成的包名，与代码所在位置不冲突，两者叠加使用
        packageConfig.setEntity("domain"); // 设置实体类包名
        packageConfig.setMapper("dao"); // 设置数据层包名
        autoGenerator.setPackageInfo(packageConfig);

        // 策略配置---核心
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("tb_user","tb_brand","tb_brand1","tb_book"); // 设置当前参与生成的表名
        strategyConfig.setTablePrefix("tb_"); // 设置数据库的前缀名称，模块名= 数据库表名 - 前缀名
        strategyConfig.setRestControllerStyle(true); // 设置是否启用Rest风格
        strategyConfig.setVersionFieldName("version"); // 设置乐观锁字段名
        strategyConfig.setLogicDeleteFieldName("deleted"); // 设置逻辑删除字段名
        strategyConfig.setEntityLombokModel(true); // 设置是否启用lombok
        autoGenerator.setStrategy(strategyConfig); // 加载策略配置

// 2.执行生成操作
        autoGenerator.execute(); // 执行代码生成器
    }
}
