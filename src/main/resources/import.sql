INSERT INTO estudiante (
    estu_id,
    estu_apellido,
    estu_fecha_nacimiento,
    estu_genero,
    estu_nombre
)
VALUES (
    nextval('seq_estudiante'),
    'Pérez',
    '2002-05-14',
    'Masculino',
    'Juan'
);