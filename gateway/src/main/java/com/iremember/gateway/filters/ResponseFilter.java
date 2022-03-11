package com.iremember.gateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class ResponseFilter {
	@Autowired
	Tracer tracer;

	@Bean
	public GlobalFilter postGlobalFilter() {
		return (exchange, chain) -> {
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				String traceId = tracer.currentSpan().context().traceId();
				log.debug("Adding the correlation id to the outbound headers. {}", traceId);
				exchange.getResponse().getHeaders().add("traceId", traceId);
				log.debug("Completing outgoing request for {}.", exchange.getRequest().getURI());
			}));
		};
	}
}
