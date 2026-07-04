package com.abikumar.portfoliobackend.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.abikumar.portfoliobackend.util.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String path = request.getServletPath();

		if (path.startsWith("/auth") || path.startsWith("/otp") || path.startsWith("/visitor")
				|| path.startsWith("/project") || path.startsWith("/experience") || path.startsWith("/skill") || path.equals("/resume/download")
				|| path.equals("/hr/save")) {

			filterChain.doFilter(request, response);
			return;
		}
		String authHeader = request.getHeader("Authorization");

		if (authHeader != null && authHeader.startsWith("Bearer ")) {

			String token = authHeader.substring(7);

			if (jwtUtil.validateToken(token)) {

				String role = jwtUtil.extractRole(token);

				if (request.getRequestURI().startsWith("/admin")) {

					if (!"ADMIN".equals(role)) {

						response.setStatus(403);

						response.getWriter().write("Access Denied");

						return;
					}
				}

				filterChain.doFilter(request, response);

				return;
			}
		}

		response.setStatus(401);

		response.getWriter().write("Invalid JWT Token");
	}
}