package com.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/** The main configuration class,
 * which initialize two Dispatcher Servlets
 * @author vlad-dvlad
 * @version 1.0
 * @since 2021-02-04
 */
public class ToDoAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /** getRootConfigClasses load firs DS.
     * @return RootConfig.class
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /** getServletConfigClasses load second DS.
     * @return WebConfig.class
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    /**
     * getServletMappings identifies path that
     * DS will be mapped to. In this case "/" is
     * application default servlet. It will handle
     * all request coming into the application
     * @return path of DS
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
