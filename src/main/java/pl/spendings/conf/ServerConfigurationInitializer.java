package pl.spendings.conf;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import pl.spendings.conf.servlet.Mappings;
import pl.spendings.conf.root.MainLogicContext;

public class ServerConfigurationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MainLogicContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{Mappings.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
