package pe.edu.upeu.infotelspringboot.util.dataLoaders;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import pe.edu.upeu.infotelspringboot.model.entity.Rol;
import pe.edu.upeu.infotelspringboot.repository.RolRepository;

@Order(1)
@Component
@RequiredArgsConstructor
public class RolDataLoader implements CommandLineRunner {

    private final RolRepository rolRepository;

    @Override
    @Transactional
    public void run(String... args) {
        boolean adminCreado = crearRolSiNoExiste("ROLE_ADMIN");
        boolean usuarioCreado = crearRolSiNoExiste("ROLE_USUARIO");

        if (!adminCreado && !usuarioCreado) {
            System.out.println("ℹ️ Los roles ya están cargados en la base de datos.");
        }
    }

    private boolean crearRolSiNoExiste(String nombreRol) {
        if (rolRepository.findByNombre(nombreRol).isEmpty()) {
            Rol nuevoRol = new Rol();
            nuevoRol.setNombre(nombreRol);
            rolRepository.save(nuevoRol);
            System.out.println("✅ Rol '" + nombreRol + "' creado.");
            return true;
        }
        return false;
    }
}