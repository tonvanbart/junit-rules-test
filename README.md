## Custom JUnit annotations

[![Build Status](https://travis-ci.com/tonvanbart/junit-rules-test.svg?branch=master)](https://travis-ci.com/tonvanbart/junit-rules-test)

This is a quick experiment with using a JUnit @Rule to add our own custom annotations to test methods. This would give you similar functionality as @Before,
but with the added benefit of being able to parameterize exactly what each test method needs to have done (or not done).

In this simple example the annotation just takes some strings, which can later be retrieved inside the test, but the idea would be to have
potentially complex object trees created (like a Backbase catalog structure). In this scenario in the code snippet below, one could ask
`catalog.getPage()` and get a fully configured page, including any needed extension items, just by annotating the test method with the items you need.

Sample annotated test method (see src/test/java/cpm/ackbase/annotations/tests/AnnotationsTest):
```java
    @Rule
    public CatalogRule catalog = new CatalogRule();

    @Test
    @Catalog(page="mypage")
    public void testMe() {
        System.out.println("bla");
        assertThat(catalog.getPagename(), is("mypage"));
    }
```

Sample output of running `mvn test`:

```
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.backbase.tests.AnnotationsTest
asking for page = mypage
asking for container = n/a
bla
asking for page = my-second-page
asking for container = somecont
bla
asking for page = n/a
asking for container = cont3
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.043 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0

```
