package co.edu.uniandes.csw.astroDevelopers.charla.persistence.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-10-13T07:34:29")
@StaticMetamodel(_CharlaEntity.class)
public abstract class _CharlaEntity_ { 

    public static volatile SingularAttribute<_CharlaEntity, Long> id;
    public static volatile SingularAttribute<_CharlaEntity, String> titulo;
    public static volatile SingularAttribute<_CharlaEntity, String> imagen;
    public static volatile SingularAttribute<_CharlaEntity, String> informacion;
    public static volatile SingularAttribute<_CharlaEntity, String> name;
    public static volatile SingularAttribute<_CharlaEntity, String> link;
    public static volatile SingularAttribute<_CharlaEntity, Date> publicacion;
    public static volatile SingularAttribute<_CharlaEntity, Date> fechaEvento;

}