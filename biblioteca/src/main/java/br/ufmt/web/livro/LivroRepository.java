package br.ufmt.web.livro;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface LivroRepository extends JpaRepositoryImplementation<Livro, Integer> {
    
}
