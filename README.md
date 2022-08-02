# 2_SWAGGER 

swagger 페이지 접속 URL 👉️ http://localhost:8080/swagger-ui/index.html

### 구현된 내용

**① API 별 그룹핑** 
![https://user-images.githubusercontent.com/39696812/182423759-b037538c-0a4b-4e0f-9240-c8ea8f014a66.png](https://user-images.githubusercontent.com/39696812/182423759-b037538c-0a4b-4e0f-9240-c8ea8f014a66.png)
SwaggerConfig.java 

```java
@Bean
public GroupedOpenApi customTestOpenApi() { ... }

@Bean
public GroupedOpenApi customExampleOpenApi() { ... }
```
**② Authorize 공통 값 설정**
![https://user-images.githubusercontent.com/39696812/182423856-f4de570c-a733-4d32-b240-e1367d29ac78.png](https://user-images.githubusercontent.com/39696812/182423856-f4de570c-a733-4d32-b240-e1367d29ac78.png)
SwaggerConfig.java

```java
public OpenApiCustomiser buildSecurityOpenApi() { ... }
```

**③ API 설정 추가** 
![https://user-images.githubusercontent.com/39696812/182424362-77792111-5fe7-4060-89a6-adb1d93a25d7.png](https://user-images.githubusercontent.com/39696812/182424362-77792111-5fe7-4060-89a6-adb1d93a25d7.png)
![https://user-images.githubusercontent.com/39696812/182424475-9b904312-97f5-4c00-a7c0-8085ce26f638.png](https://user-images.githubusercontent.com/39696812/182424475-9b904312-97f5-4c00-a7c0-8085ce26f638.png)
               
```java
@GetMapping("/first")
@Operation(summary = "example first API", description = "example first API 입니다.")
@ApiResponses({
       @ApiResponse(responseCode = "200", description = "성공"),
       @ApiResponse(responseCode = "404", description = "API 찾기 실패", content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
})
public String first(
       @Parameter(description = "이름", required = true, example = "박소연") String name) {
return name;
}
```












