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

package org.workspace7.fuse.http.tracing.impl;

import brave.Tracing;
import brave.context.slf4j.MDCCurrentTraceContext;
import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.workspace7.fuse.http.tracing.api.HttpTracingService;
import zipkin.reporter.AsyncReporter;
import zipkin.reporter.okhttp3.OkHttpSender;

/**
 * @author kameshs
 */

public class HttpTracingServiceImpl implements HttpTracingService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpTracingServiceImpl.class);

    private String zipkinUrl;

    @Override
    public Tracing httpTracer() {
        return buildHttpTracer(Sampler.ALWAYS_SAMPLE);
    }

    @Override
    public Tracing httpTracer(Sampler sampler) {
        if (sampler == null) {
            return buildHttpTracer(Sampler.ALWAYS_SAMPLE);
        }
        return buildHttpTracer(sampler);
    }

    protected Tracing buildHttpTracer(Sampler sampler) {

        LOGGER.info("Building HTTP Tracing: Zipkin Url {}", getZipkinUrl());
        Tracing.Builder tracingBuilder = Tracing.newBuilder();

        //TODO this should be via config properties
        tracingBuilder.localServiceName("Camel-Http-Tracer");
        tracingBuilder.sampler(sampler);
        tracingBuilder.reporter(AsyncReporter.create(OkHttpSender.create(getZipkinUrl())));
        tracingBuilder.currentTraceContext(MDCCurrentTraceContext.create());

        return tracingBuilder.build();
    }

    public String getZipkinUrl() {
        return zipkinUrl;
    }

    public void setZipkinUrl(String zipkinUrl) {
        this.zipkinUrl = zipkinUrl;
    }
}
