package br.ufmt.web.usuario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario, Integer> {
    
}

//https://github.com/thesivis/mibanca/blob/con-tipo-ata/mibanca/src/main/java/br/ufmt/mibanca/tipoata/TipoAtaController.java