Clase 2
========

Para servir contenidos estáticos:

> By default Spring Boot will serve static content from a directory called
/static (or /public or /resources or /META-INF/resources) in the classpath or from the root of the ServletContext. It uses the ResourceHttpRequestHandler from Spring MVC so you can modify that behavior by adding your own WebMvcConfigurerAdapter and overriding the addResourceHandlers method.

Si por algún motivo esto no les funciona (puede ser que jetty no tome como parte del classpath alguna de las carpetas que necesitan). Pueden configurar spring para que levante los recursos de las carpetas que quieran:

```
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }
}
```

Lo que pueden hacer es:

```
	private static final String RESOURCES_DIR = "/resources/";
	private static final String RESOURCES_PATH = "/**";

@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(RESOURCES_PATH).addResourceLocations(RESOURCES_DIR);
	}
```