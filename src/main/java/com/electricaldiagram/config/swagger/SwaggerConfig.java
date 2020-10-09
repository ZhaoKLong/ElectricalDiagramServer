package com.electricaldiagram.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description: SwaggerConfig
 * <p>
 * Swagger注解说明：
 * <p>
 * API 将类标记为Swagger资源
 * ApiImplicitParam 表示API操作中的单个参数
 * ApiImplicitParams 一个允许多个ApiImplicitParam对象列表的包装器
 * ApiModel 提供有关Swagger模型的其他信息
 * ApiModelProperty 添加和操作模型属性的数据
 * ApiOperation 描述一个操作或通常针对特定路径的HTTP方法
 * ApiParam 为操作参数添加额外的元数据
 * ApiResponse 描述操作的可能响应
 * ApiResponses 一个允许多个ApiResponse对象列表的包装器
 * Authorization 声明要在资源或操作上使用的授权方案
 * AuthorizationScope 描述OAuth2授权范围
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * swagger api访问地址： http://localhost:xxxx/apidocs/index.html
     *
     * @return
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //api路径
                .apis(RequestHandlerSelectors.basePackage("com.electricaldiagram.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //构建api文档详细函数信息
        return new ApiInfoBuilder()
                //页面标题
                .title("线路图服务-API文档")
                //作者信息
                .contact(new Contact("zkl", "https://github.com/ZhaoKLong", ""))
                //api文档描述信息
                .description("zkl apidocs")
                //版本信息
                .version("1.0")
                .build();
    }
}
