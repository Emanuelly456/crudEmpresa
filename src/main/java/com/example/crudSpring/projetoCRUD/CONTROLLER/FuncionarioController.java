package com.example.crudSpring.projetoCRUD.CONTROLLER;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crudSpring.projetoCRUD.ENTITY.Funcionario;
import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;
import com.example.crudSpring.projetoCRUD.SERVICE.FuncionarioService;

@Controller
@RequestMapping("/funcionarioCTR")
public class FuncionarioController {

  @Autowired
  private FuncionarioService ligFuncionarioService;

  @Autowired
  private EmpresaService ligacaoEmpresaService;

  @GetMapping("/listarFunc")
  public String listarTodosFuncionarios(Model oModel) {
    oModel.addAttribute("funcionarios", ligFuncionarioService.listarTodosFuncionario());
    // oModel.addAttribute("empresa", ligacaoEmpresaService.findAll());

    return "listarFuncionario";
  }

  @GetMapping("/formFuncionario")
  public String mostrarFormCadastro(Model oModel) {
    oModel.addAttribute("funcionario", new Funcionario());
    oModel.addAttribute("empresas", ligacaoEmpresaService.findAll());
    return "cadastrarFuncionario";
  }

  @PostMapping("/salvarFuncionario")
  public String CadastrarFuncionario(@ModelAttribute Funcionario objFuncionario) {

    ligFuncionarioService.cadastarFuncionario(objFuncionario);
    return "redirect:/funcionarioCTR/listarFunc";
  }

  @GetMapping("/deletarFuncionario/{codigo}")
  public String apagarFuncionario(@PathVariable("codigo") long codigo) {
    ligFuncionarioService.deletarFuncionario(codigo);
    return "redirect:/funcionarioCTR/listarFunc";
  }

}
