package com.netflix.spinnaker.gate.config
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.context.annotation.Configuration
/**
 * @author Greg Turnquist
 */
@Configuration
@ConditionalOnProperty('spring.cloud.eureka.enabled')
class SpringCloudEurekaConfig {

  @EnableDiscoveryClient
  static class EurekaClient {}

}