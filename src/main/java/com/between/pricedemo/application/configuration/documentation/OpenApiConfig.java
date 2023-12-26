package com.between.pricedemo.application.configuration.documentation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileReader;
import java.io.IOException;

@Configuration
@PropertySource("classpath:${openapi.language}")
class OpenApiConfig {

    @Bean
    @ConfigurationProperties(prefix = "openapi")
    public OpenAPI openAPI() throws IOException, XmlPullParserException {
        MavenXpp3Reader reader = new MavenXpp3Reader();
        Model model = reader.read(new FileReader("pom.xml"));

        return new OpenAPI().info(new Info().version(model.getVersion()));
    }

}