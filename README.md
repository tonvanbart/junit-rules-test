## Custom JUnit annotations
This is a quick experiment with using a JUnit @Rule to add our own custom annotations to test methods. This would give you similar funstionality as @Before, but with the added benefit of being able to parameterize exactly what each test method needs to have done (or not done).
In this simple example the annotation just takes some strings, which can later be retrieved inside the test, but the idea would be to have potentially complex object trees created (like a Backbase catalog structure).
