package com.backbase.tests;

import com.backbase.annotations.Catalog;
import com.backbase.rules.CatalogRule;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by ton on 18-3-15.
 */
public class AnnotationsTest {

    public String acontainer;

    @Rule
    public CatalogRule catalogMagic = new CatalogRule();

    @Test
    @Catalog(page="mypage")
    public void testMe() {
        System.out.println("bla");
        assertThat(catalogMagic.getPagename(), is("mypage"));
    }

    @Test
    @Catalog(page="my-second-page", container = "somecont")
    public void testMeAGain() {
        System.out.println("bla");
        String thePage = catalogMagic.getPagename();
        assertThat(thePage, is("my-second-page"));
        assertThat(catalogMagic.getContainername(), is("somecont"));
    }

    @Test
    @Catalog(container = "cont3")
    public void testThree() {
        assertTrue(true);
    }

}
