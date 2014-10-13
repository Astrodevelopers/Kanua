package co.edu.uniandes.csw.astroDevelopers.usuario.persistence.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-10-13T07:34:29")
@StaticMetamodel(_UsuarioEntity.class)
public abstract class _UsuarioEntity_ { 

    public static volatile SingularAttribute<_UsuarioEntity, Long> id;
    public static volatile SingularAttribute<_UsuarioEntity, String> email;
    public static volatile SingularAttribute<_UsuarioEntity, String> name;
    public static volatile SingularAttribute<_UsuarioEntity, Integer> tipo;
    public static volatile SingularAttribute<_UsuarioEntity, String> password;

}