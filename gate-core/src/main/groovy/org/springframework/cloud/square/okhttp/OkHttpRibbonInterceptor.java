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

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.io.IOException;
import java.net.URL;

/**
 * @author Spencer Gibb
 */
public class OkHttpRibbonInterceptor implements Interceptor {

  private LoadBalancerClient client;

  public OkHttpRibbonInterceptor(LoadBalancerClient client) {
    this.client = client;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request original = chain.request();

    URL originalUrl = original.url();
    String serviceId = originalUrl.getHost();
    ServiceInstance service = client.choose(serviceId);

    // Not a registered service?
    if (service == null) {
      return chain.proceed(original);
    }

    URL url = new URL(service.isSecure() ? "https://" : "http://" +
        service.getHost() + ":" + service.getPort() +
        originalUrl.getPath());

    Request request = original.newBuilder()
        .url(url)
        .build();

    return chain.proceed(request);
  }
}