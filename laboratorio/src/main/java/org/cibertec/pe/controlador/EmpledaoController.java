package org.cibertec.pe.controlador;

import java.util.List;

import org.cibertec.pe.modelo.Empleado;
import org.cibertec.pe.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmpledaoController {
	@Autowired
	private EmpleadoServicio empser;
	
	@GetMapping("/listar")
	public String listar (Model m) {
		List<Empleado> em = empser.listado();
		m.addAttribute("empleado", em);
		m.addAttribute("cantidad", em.size());
		return "listado";
	}
	@GetMapping("/agregar")
	public String agregar ( Model m) {
		return "agregar";
	}
	
	@PostMapping("/salvar")
	public String salvar ( Empleado e, Model m) {
		empser.Agregar(e);
		return "redirect:/listar";
	}
}
