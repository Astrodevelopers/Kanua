package co.edu.uniandes.csw.astroDevelopers.proyecto.persistence.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-10-14T23:39:20")
@StaticMetamodel(_ProyectoEntity.class)
public abstract class _ProyectoEntity_ { 

    public static volatile SingularAttribute<_ProyectoEntity, Long> id;
    public static volatile SingularAttribute<_ProyectoEntity, String> demo;
    public static volatile SingularAttribute<_ProyectoEntity, String> imagen;
    public static volatile SingularAttribute<_ProyectoEntity, Integer> estado;
    public static volatile SingularAttribute<_ProyectoEntity, String> name;
    public static volatile SingularAttribute<_ProyectoEntity, String> descripcion;
    public static volatile SingularAttribute<_ProyectoEntity, Long> equipo_proyectoId;
    public static volatile SingularAttribute<_ProyectoEntity, String> tema;
    public static volatile SingularAttribute<_ProyectoEntity, String> lema;

}