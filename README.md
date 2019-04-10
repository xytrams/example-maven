Template project for QVC 

Tests

We're supporting 2 flavours of tests: unit tests (junit5/moickito) and integration tests (wiremock)

To build application (will run all tests):

	mvn clean install

To run unit tests:

	mvn test -PUnitTests

To run integration tests:

	mvn test -PIntegrationTests
	
For now integration and unit tests live in the same source folder, we might change it in the future to make more clear 
separations, but until further notice it is the same location.

We utilise capabilities of junit5 to separate tests: unit tests should be tagged as: @Tag("unit")
integration tests as: @Tag("integration) respectively.

Alternatively, we could introduce own annotations:

```
@Retention(RetentionPolicy.RUNTIME)
@Tag("integration")
@Test
public @interface IntegrationTest {

}

@Retention(RetentionPolicy.RUNTIME)
@Tag("unit")
@Test
public @interface UnitTest {

}
```
and

and use custom annotations:

	@UnitTest
	@IntegrationTest

The Maven Surefire Plugin will scan for test classes whose fully qualified names match the following patterns.

	**/Test*.java
	**/*Test.java
	**/*Tests.java
	**/*TestCase.java

so please make sure test classes names have to follow this convention.