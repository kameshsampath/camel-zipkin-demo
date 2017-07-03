/*
 * Copyright 2017 Kamesh Sampath<kamesh.sampath@hotmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.workspace7.fuse.http.tracing.blueprint.demo;

import brave.httpclient.TracingHttpClientBuilder;
import org.apache.camel.BeanInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpEndpoint;
import org.apache.http.client.HttpClient;
import org.workspace7.fuse.http.tracing.api.HttpTracingService;

/**
 * @author kameshs
 */
public class BraveTraceRouteBuilder extends RouteBuilder {

    @BeanInject
    HttpTracingService httpTracingService;

    @Override
    public void configure() throws Exception {

        HttpClient httpClient = TracingHttpClientBuilder.create(httpTracingService.httpTracer()).build();

        HttpEndpoint httpEndpoint = (HttpEndpoint) getContext()
                .getEndpoint("http4://localhost:9090/service1");
        httpEndpoint.setBridgeEndpoint(true);
        //TODO Check with : setting the client this way will not disturb anything ??
        httpEndpoint.setHttpClient(httpClient);

        from("jetty:http://0.0.0.0:8085")
                .to(httpEndpoint)
                .setBody(simple("${body}"))
                .log("${body}");
    }
}
