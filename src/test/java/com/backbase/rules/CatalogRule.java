package com.backbase.rules;

import com.backbase.annotations.Catalog;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

import java.lang.reflect.Field;

/**
 * Created by ton on 18-3-15.
 */
public class CatalogRule implements MethodRule {

    String pagename;

    String containername;

    @Override
    public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before(target, method);
                try {
                    base.evaluate();
                } finally {
                    after();
                }
            }
        };
    }

    private void before(Object target, FrameworkMethod method) {
        Catalog requestedCatalog = method.getAnnotation(Catalog.class);
        System.out.println("asking for page = " + requestedCatalog.page());
        System.out.println("asking for container = " + requestedCatalog.container());
        pagename = requestedCatalog.page();
        containername = requestedCatalog.container();

        try {
            Field containerField = target.getClass().getDeclaredField("container");
            containerField.set(target, containername);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            System.out.println("Failed to set field 'container', test may fail!");
        }
    }

    private void after() {
    }

    public String getPagename() {
        return pagename;
    }

    public String getContainername() {
        return containername;
    }
}
