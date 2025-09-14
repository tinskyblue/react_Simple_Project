package com.interstage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") //모든 엔드포인트에 대해 CORS 정책 적용.
						.allowedOrigins("http://localhost:5173") //프론트엔드 도메인 허용 (Vite Dev 서버 기준).
						.allowedMethods("*") //모든 HTTP 메서드(GET, POST, PUT, DELETE 등) 허용.
						.allowCredentials(true); //쿠키, 인증 헤더 등 자격 증명 허용.
			}
		};
	}
}
