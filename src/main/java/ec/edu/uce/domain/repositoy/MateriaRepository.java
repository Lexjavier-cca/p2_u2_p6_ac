package ec.edu.uce.domain.repositoy;

import java.util.List;

import ec.edu.uce.domain.model.Materia;

public interface MateriaRepository {
    public void insertar(Materia materia);
    public Materia seleccionarPorId(Integer id);
}
