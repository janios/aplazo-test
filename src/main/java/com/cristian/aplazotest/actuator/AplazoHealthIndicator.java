package com.cristian.aplazotest.actuator;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class AplazoHealthIndicator extends AbstractHealthIndicator {

  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    builder.up().withDetail("app", "Aplazo Code Challenge");
  }
}
