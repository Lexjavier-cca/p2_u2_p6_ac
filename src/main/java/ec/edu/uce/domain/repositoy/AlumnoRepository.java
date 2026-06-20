package ec.edu.uce.domain.repositoy;

import ec.edu.uce.domain.model.Alumno;

public interface AlumnoRepository {
    public void insertar(Alumno alumno);
    public Alumno consultarPorId(Integer id);
}
