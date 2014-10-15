package co.edu.uniandes.csw.astroDevelopers.taller.persistence.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2014-10-14T23:39:20")
@StaticMetamodel(_TallerEntity.class)
public abstract class _TallerEntity_ { 

    public static volatile SingularAttribute<_TallerEntity, Long> id;
    public static volatile SingularAttribute<_TallerEntity, String> imagen;
    public static volatile SingularAttribute<_TallerEntity, String> titulo;
    public static volatile SingularAttribute<_TallerEntity, String> informacion;
    public static volatile SingularAttribute<_TallerEntity, String> name;
    public static volatile SingularAttribute<_TallerEntity, Date> publicacion;
    public static volatile SingularAttribute<_TallerEntity, String> tema;
    public static volatile SingularAttribute<_TallerEntity, Date> fechaEvento;

}