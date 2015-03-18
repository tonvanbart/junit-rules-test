## Custom JUnit annotations
This is a quick experiment with using a JUnit @Rule to add our own custom annotations to test methods. This would give you similar funstionality as @Before, but with the added benefit of being able to parameterize exactly what each test method needs to have done (or not done).
In this simple example the annotation just takes some strings, which can later be retrieved inside the test, but the idea would be to have potentially complex object trees created (like a Backbase catalog structure).


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
