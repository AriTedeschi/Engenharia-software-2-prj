package com.facens.facens_learn.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/usuarios")
public class AlunoController {
	@RequestMapping("/test")
	@ResponseBody
	public String hello() {
		return "Teste";
	}
}
