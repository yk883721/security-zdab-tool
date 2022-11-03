package genetator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.util.Collections;

public class Generator {

    public static void main(String[] args) {

        String url = "jdbc:mysql://10.81.73.15:8084/ciie_2022_db?characterEncoding=utf8&useSSL=false";
        String username = "dfmzadminuser";
        String password = "OPGcitybrain123456";

        String path = System.getProperty("user.dir") + "\\src\\main";
        String javaPath = path + "\\java";
        String resourcePath = path + "\\resources\\mapper";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("yangk") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .outputDir(javaPath); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.yk") // 设置父包名
                            .entity("model.entity")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, resourcePath)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("abtdxlc_detail")
                            .controllerBuilder()
                                .enableRestStyle()
                            .serviceBuilder()
                                .formatServiceFileName("%sService")
                            .mapperBuilder()
                                .enableBaseResultMap()
                                .enableMapperAnnotation()
                                .enableBaseColumnList()
                            .entityBuilder()
                                .enableLombok()
                                .disableSerialVersionUID()
                    ;// 设置需要生成的表名
                })
                .execute();
    }

}
