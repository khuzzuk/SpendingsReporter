package pl.spendings.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.spendings.conf.root.Mappings;
import pl.spendings.conf.servlet.BasicFilter;

public class ServerConfigurationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{Mappings.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{BasicFilter.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
