package ec.edu.uce.application.service;

import java.util.List;

import ec.edu.uce.domain.model.Materia;
import ec.edu.uce.infraestrucure.repository.MateriaRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MateriaService {
    @Inject
    private MateriaRepositoryImpl mri;
    public void guardar(Materia materia){
        this.mri.insertar(materia);        
    }
    public Materia mostrarPorId(Integer id){
        System.out.println("Seleccionar por id: "+ id);
        return this.mri.seleccionarPorId(id);

    }
}
