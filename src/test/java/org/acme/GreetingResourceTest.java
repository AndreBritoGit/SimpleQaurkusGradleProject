package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class GreetingResourceTest {

  @InjectMock
  GreetingResource resource;

  @BeforeAll
  public static void bla() {
    GreetingResource mock = Mockito.mock(GreetingResource.class);
    QuarkusMock.installMockForType(mock, GreetingResource.class);

  }
    @Test
    public void testHelloEndpoint() {

        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));

    }

}