package services;

import static io.restassured.RestAssured.given;

import annotations.Path;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class AbsBaseApi {

  protected static final String BASE_URI = System.getProperty("base.url");

  protected RequestSpecification specification;

  private String getPath() {
    Class clazz = this.getClass();

    if (clazz.isAnnotationPresent(Path.class)) {
      Path path = (Path) clazz.getAnnotation(Path.class);
      return path.value();
    }
    return null;
  }

  public AbsBaseApi() {
    specification = given()
        .baseUri(BASE_URI)
        .basePath(getPath())
        .contentType(ContentType.JSON);
  }
}