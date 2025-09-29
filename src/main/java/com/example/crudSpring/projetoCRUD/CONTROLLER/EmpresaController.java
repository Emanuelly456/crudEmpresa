package com.example.crudSpring.projetoCRUD.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.SERVICE.EmpresaService;


@Controller
@RequestMapping("/empresaCTR")
public class EmpresaController {
   
    private final EmpresaService empresaService;

    //processo de instaciação de classe
    public EmpresaController(EmpresaService ligacaoEmpresaService){
        this.empresaService = ligacaoEmpresaService;
    }
   @GetMapping("/viewCadEmpresa")
   public String mostrarFormCadastro(Model oModel){
   oModel.addAttribute("empresa", new Empresa());
   return "cadastroEmpresa";
   }

   //chamada para listar todas as empresas

   @PostMapping("/salvarEmpresa")
   public String salvarEmpresa(@ModelAttribute Empresa objEmpresa){
    //chamando o método cadastrar e passando
    //o objeto("pacotinho") com os dados que precisam ser salvos
    empresaService.cadastrarEmpresa(objEmpresa);
    return "redirect:/empresaCTR/viewCadEmpresa";
   

   }

}