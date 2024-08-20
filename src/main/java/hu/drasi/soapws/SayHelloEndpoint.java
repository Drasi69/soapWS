package hu.drasi.soapws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import hu.drasi.test.GetTestRequest;
import hu.drasi.test.GetTestResponse;

@Endpoint
public class SayHelloEndpoint {
  private static final String NAMESPACE_URI = "http://drasi.hu/test";
  private SayHelloRepository sayHelloRepository;

  @Autowired
  public SayHelloEndpoint(SayHelloRepository sayHelloRepository) {
    this.sayHelloRepository = sayHelloRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getTestRequest")
  @ResponsePayload
  public GetTestResponse sayHello(@RequestPayload GetTestRequest request) {
    GetTestResponse response = new GetTestResponse();
    response.setResponse(this.sayHelloRepository.sayHello(request.getName()));

    return response;
  }
}
