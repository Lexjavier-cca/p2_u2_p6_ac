package ec.edu.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import ec.edu.uce.domain.model.Equipo;
import ec.edu.uce.infraestrucure.repository.EquipoRepositoryImpl;
import jakarta.inject.Inject;

@ApplicationScoped
@Transactional
public class EquipoService {
    @Inject
    private EquipoRepositoryImpl eri;
    public void guardar(Equipo equipo){
        this.eri.insertar(equipo);

    }
}
