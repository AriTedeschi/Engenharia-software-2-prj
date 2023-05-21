package com.facens.facens_learn.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags="Endpoint Alunos")
@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
}
