package com.github.uglyog.springbootjunit5test;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Provider("Animal Profile Service")
@PactBroker(url = "https://test.pact.dius.com.au",
  authentication = @PactBrokerAuth(username = "dXfltyFMgNOFZAxr8io9wJ37iUpY42M", password = "O5AIZWxelWbLvqMd8PkAVycBJh2Psyg1"))
class ApplicationPactTest {

  @BeforeEach
  public void setupTestTarget(PactVerificationContext context) {
    context.setTarget(new HttpTestTarget("localhost", 8080));

//    System.setProperty("pact.provider.tag", "dev");
//    System.setProperty("pact.provider.version", "0.0.0");
//    System.setProperty("pact.verifier.publishResults", "true");
  }

  @TestTemplate
  @ExtendWith(PactVerificationInvocationContextProvider.class)
  public void pactVerificationTestTemplate(PactVerificationContext context) {
    context.verifyInteraction();
  }

  @State("is not authenticated")
  public void isNotAuthenticated() {

  }

  @State("Has some animals")
  public void hasSomeAnimals() {

  }

  @State("Has an animal with ID 1")
  public void hasAnAnimalWithID1() {

  }

  @State("Has no animals")
  public void hasNoAnimals() {

  }
}
