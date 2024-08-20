package hu.drasi.soapws;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class SayHelloRepository {
  public String sayHello(String name) {
    Assert.notNull(name, "The name must not be null");
    return "Hello " + name;
  }
}
