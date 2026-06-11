package ec.edu.uce.application.service;

import ec.edu.uce.domain.model.Ciudadano;
import ec.edu.uce.infraestrucure.repository.CiudadanoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CiudadanoService {
    @Inject
    private CiudadanoRepositoryImpl ciu;
    public void guardar(Ciudadano ciudadano){
        this.ciu.crear(ciudadano);
    }

}
