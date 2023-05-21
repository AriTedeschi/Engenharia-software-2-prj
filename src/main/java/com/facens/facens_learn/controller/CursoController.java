package com.facens.facens_learn.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.facens.facens_learn.controller.DTO.CursoDTO;
import com.facens.facens_learn.controller.forms.NovoCursoForm;
import com.facens.facens_learn.service.CursoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags="Endpoitns Curso")
@RestController
@RequestMapping("/cursos")
public class CursoController {
	@Autowired private CursoService service;
	
	@ApiOperation(value = "Registrar novo Curso", notes = "Endpoint publico")
	@ApiResponses(value = {
	    @ApiResponse(code = 201, message = "Curso was registred Successfully"),
	    @ApiResponse(code = 400, message = "Input data error"),
	    @ApiResponse(code = 403, message = "Invalid Authentication Token"),
	    @ApiResponse(code = 405, message = "Token can't access resource"),
	    @ApiResponse(code = 500, message = "Server-side Exception"),
	})
	@PostMapping("")
	public ResponseEntity<CursoDTO> insert(@Valid @RequestBody NovoCursoForm dto) {
		CursoDTO curso = service.inserir(dto);
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(curso.getId()).toUri();
		
		return ResponseEntity.created(uri).body(curso);
	}
	
	@ApiOperation(value = "Buscar curso por id")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Returns Curso by provided id"),
	    @ApiResponse(code = 404, message = "There is no Curso with informed id"),
	    @ApiResponse(code = 403, message = "Invalid Authentication Token"),
	    @ApiResponse(code = 405, message = "Token can't access resource"),
	    @ApiResponse(code = 500, message = "Server-side Exception"),
	})
	@GetMapping("/{id}")
	public ResponseEntity<CursoDTO> getById(@ApiParam(value="ID do Curso") @PathVariable Long id) {
		try {
			CursoDTO client = service.obterCursoPorId(id);

			return ResponseEntity.ok().body(client);
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ApiOperation(value = "Listar Cursos")
	@ApiResponses(value = {
	    @ApiResponse(code = 200, message = "Returns list containing all Cursos"),
	    @ApiResponse(code = 403, message = "Invalid Authentication Token"),
	    @ApiResponse(code = 405, message = "Token can't access resource"),
	    @ApiResponse(code = 500, message = "Server-side Exception"),
	})
	@GetMapping("/todos")
	public ResponseEntity<List<CursoDTO>> getAll() {
		List<CursoDTO> clients = service.obterTodos();

		return ResponseEntity.ok().body(clients);
	}

}
