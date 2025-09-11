package com.example.crudSpring.projetoCRUD.SERVICE;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.ENTITY.Empresa;
import com.example.crudSpring.projetoCRUD.REPOSITORY.EmpresaRepository;

@Service
public class EmpresaService {
    
private final EmpresaRepository empresaRepository;

 //método construtor da Classe EmpresaService
 //criando uma ligção com a Classe EmpresaRepository

    public EmpresaService(EmpresaRepository ligacaoEmpresaRepository){
        empresaRepository = ligacaoEmpresaRepository;
    }
    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }//select * from empresa(LISTAR)

      //OBJECT-CRIAR ALGO NO BANCO
   public Empresa cadastrarEmpresa(Empresa dadoEmpresa){
        return empresaRepository.save(dadoEmpresa);
   
   }
     // deletar alguma parte de banco
   public void deletarEmpresa(Empresa dadoEmpresa){
    empresaRepository.delete(dadoEmpresa);
   }

}
//SELECTS OU INSERTS OU ALTER TABLE OU DELETE
 //SELECT * FROM EMPRESA(SELECT REALIZA LISTAGEM DE DADOS)
 //where nome_empresa = ?
 //(1-SELECT   2-Quais os dados deseja listar 3-Onde deseja executar o comando)
 //retorna todos os dados da empresa (* - tudo da tabela)