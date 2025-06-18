package br.csi.CommitStream;

import br.csi.CommitStream.model.Filme.Filme;
import br.csi.CommitStream.model.Filme.FilmeRepository;
import br.csi.CommitStream.model.Genero.Genero;
import br.csi.CommitStream.model.Genero.GeneroRepository;
import br.csi.CommitStream.model.Usuario.Usuario;
import br.csi.CommitStream.model.Usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@OpenAPIDefinition(
		info = @Info(
				title = "CommitStream",
				version = "Testes",
				description = "Site de avaliação de filmes",
				contact = @Contact(name = "Fabricio", email = "fabrodrigues237@gmail.com")

		)
)
@SpringBootApplication
public class CommitStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommitStreamApplication.class, args);
	}

}
