package pl.spendings.database;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class EntitiesConfiguration {
    @Bean
    public LocalSessionFactoryBean configureHibernate(){
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        factoryBean.setPackagesToScan("pl.spendings.users");
        return factoryBean;
    }
}
