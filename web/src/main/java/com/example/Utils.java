package com.example;

import java.util.Optional;

public class Utils {
	public static String getHtmlTemplate(String body, Optional<String> style) {
		return """
				<!DOCTYPE html>
				<html lang="en">
				<head>
					<meta charset="UTF-8">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<title>Product</title>

				""" + style.orElse("") + """
				</head>
				<body>
				<div class="root">
				"""
				+ body +
				"""
				</div>
				</body>
				</html>
			""";
	}
}
