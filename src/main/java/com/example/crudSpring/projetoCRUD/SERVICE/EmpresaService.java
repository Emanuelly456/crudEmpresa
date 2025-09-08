package com.example.crudSpring.projetoCRUD.SERVICE;

import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.REPOSITORY.EmpresaRepository;

@Service
public class EmpresaService {
    
    private final EmpresaRepository empresaRepository;

   //método construtor da Classe EmpresaService
   //criando uma ligção com a Classe EmpresaRepository
    public EmpresaService(EmpresaRepository ligacaoEmpresaRepository){
        empresaRepository = ligacaoEmpresaRepository;
    }
}
