package com.backbase.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Experimental annotation.
 *
 * Created by ton on 18-3-15.
 */
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Catalog {

    String page() default "n/a";

    String container() default "n/a";

}
