package com.redhat.developers;

import io.smallrye.health.checks.UrlHealthCheck;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;

@ApplicationScoped
public class CustomHealthCheck {

  @ConfigProperty(name = "quarkus.rest-client.\"com.redhat.developers.FruityViceService\".url")
  String externalURL;

  @Readiness
  HealthCheck checkURL() {
    return new UrlHealthCheck(externalURL+"/api/fruit/all")
      .name("external-url-check").requestMethod(HttpMethod.GET).statusCode(200);
  }

}