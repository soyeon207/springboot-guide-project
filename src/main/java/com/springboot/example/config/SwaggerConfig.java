package com.springboot.example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "API 명세서",
                description = "API 명세서 입니다.",
                version = "v1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi customTestOpenApi() {
        String[] paths = {"/api/v1/test/**"};

        return GroupedOpenApi
                .builder()
                .group("테스트 API 그룹")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi()).build();
    }

    @Bean
    public GroupedOpenApi customExampleOpenApi() {
        String[] paths = {"/api/v1/example/**"};

        return GroupedOpenApi
                .builder()
                .group("예시 API 그룹")
                .pathsToMatch(paths)
                .addOpenApiCustomiser(buildSecurityOpenApi()).build();
    }

    public OpenApiCustomiser buildSecurityOpenApi() {
        return OpenApi -> OpenApi.addSecurityItem(new SecurityRequirement().addList("jwt token"))
                .getComponents().addSecuritySchemes("jwt token", new SecurityScheme()
                        .name("Authorization")
                        .type(SecurityScheme.Type.HTTP)
                        .in(SecurityScheme.In.HEADER)
                        .bearerFormat("JWT")
                        .scheme("Bearer"));
    }

}


