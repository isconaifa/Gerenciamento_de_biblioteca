package br.ufmt.web.funcionario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface FuncionarioRepository extends JpaRepositoryImplementation<Funcionario, Integer> {
    
}
