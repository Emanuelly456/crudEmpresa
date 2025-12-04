package com.example.crudSpring.projetoCRUD.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudSpring.projetoCRUD.ENTITY.Funcionario;
import com.example.crudSpring.projetoCRUD.REPOSITORY.FuncionarioRepository;

import jakarta.transaction.Transactional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository ligacaoFuncionarioRepository;

    public List<Funcionario> listarTodosFuncionario() {
        return ligacaoFuncionarioRepository.findAll();
    }

    public Funcionario cadastarFuncionario(Funcionario dadosFuncionario) {
        return ligacaoFuncionarioRepository.save(dadosFuncionario);
    }

    public Optional<Funcionario> buscarFuncionarioPorId(Long id) {
        return ligacaoFuncionarioRepository.findById(id);
    }

    public void deletarFuncionario(Long id) {
        ligacaoFuncionarioRepository.deleteById(id);
    }

    @Transactional
    public void atualizarFuncionario(
            Long id, Funcionario dadosAtualizados) {
        Funcionario objtFuncionario = buscarFuncionarioPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Funcionario nao encontrado"));

        objtFuncionario.setNome(dadosAtualizados.getNome());
        objtFuncionario.setSalario(dadosAtualizados.getSalario());
        objtFuncionario.setCargo(dadosAtualizados.getCargo());
        objtFuncionario.setIdentificadorEmpresa(dadosAtualizados.getIdentificadorEmpresa());

    }
   
    public List<Funcionario> buscarFuncionarioPorNome(String nome_funcionario){
        return ligacaoFuncionarioRepository.findByNomeContainingIgnoreCase(nome_funcionario);
      }
   
}


