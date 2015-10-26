package com.netflix.spinnaker.gate.config
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.Configuration
/**
 * Create an embedded Spring Cloud Config server
 *
 * @author Greg Turnquist
 */
@Configuration
@ConditionalOnProperty('spring.cloud.config.server.bootstrap')
class SpringCloudConfigServerConfig {

  @EnableConfigServer
  static class SpringCloudEmbeddedConfigServer {}

}
