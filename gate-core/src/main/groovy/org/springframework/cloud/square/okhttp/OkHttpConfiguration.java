/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.cloud.square.okhttp;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
@Component
@ConfigurationProperties("okhttp")
public class OkHttpConfiguration {

  Long connectTimeout;
  Long readTimeout;

  public Long getConnectTimeout() {
    return connectTimeout;
  }

  public void setConnectTimeout(Long connectTimeout) {
    this.connectTimeout = connectTimeout;
  }

  public Long getReadTimeout() {
    return readTimeout;
  }

  public void setReadTimeout(Long readTimeout) {
    this.readTimeout = readTimeout;
  }
}
