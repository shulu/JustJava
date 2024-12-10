package autoc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import autoc.service.RegisterService;

@Configuration
@EnableConfigurationProperties(RegisterProperties.class)
public class RegisterAutoConfiguration {

    @Autowired
    private RegisterProperties registerProperties;

    @Bean
    @ConditionalOnMissingBean(RegisterService.class)
    public RegisterService createRegisterConfiguration() {
        RegisterService registerService = new RegisterService();
        registerService.setUsername(registerProperties.getUsername());
        registerService.setPassword(registerProperties.getPassword());
        registerService.setTelephone(registerProperties.getTelephone());
        return registerService;
    }
}
