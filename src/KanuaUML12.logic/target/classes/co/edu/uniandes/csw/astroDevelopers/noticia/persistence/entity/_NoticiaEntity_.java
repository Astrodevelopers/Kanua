package co.edu.uniandes.csw.astroDevelopers.noticia.persistence.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-10-10T20:10:02")
@StaticMetamodel(_NoticiaEntity.class)
public abstract class _NoticiaEntity_ { 

    public static volatile SingularAttribute<_NoticiaEntity, Long> id;
    public static volatile SingularAttribute<_NoticiaEntity, String> imagen;
    public static volatile SingularAttribute<_NoticiaEntity, String> titulo;
    public static volatile SingularAttribute<_NoticiaEntity, Date> fecha;
    public static volatile SingularAttribute<_NoticiaEntity, String> name;
    public static volatile SingularAttribute<_NoticiaEntity, String> descripcion;
    public static volatile SingularAttribute<_NoticiaEntity, String> tema;

}