/* ========================================================================
 * Copyright 2014 astroDevelopers
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 astroDevelopers

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.astroDevelopers.proyecto.master.persistence;

import co.edu.uniandes.csw.astroDevelopers.proyecto.logic.dto.ProyectoDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.master.persistence.api.IProyectoMasterPersistence;
import co.edu.uniandes.csw.astroDevelopers.proyecto.persistence.converter.ProyectoConverter;
import co.edu.uniandes.csw.astroDevelopers.solicitud.logic.dto.SolicitudDTO;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.SolicitudPersistence;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.entity.SolicitudEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.Query;

@Default
@Stateless 
@LocalBean
public class ProyectoMasterPersistence extends _ProyectoMasterPersistence  implements IProyectoMasterPersistence {

    public String buscarProyectosPorTag(String tag) {
        // https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/5/html/RESTEasy_Reference_Guide/Using__Path_and__GET___POST__etc..html
        // Query q = entityManager.createQuery("select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s on s.proyectoId=u.id inner join TagEntity t on t.id=s.tag_proyectoId where t.name=:valortag");
        // q.setParameter("valortag",tag);
        String tags[]=tag.split("\\;");
        String condicion="";
        for (int i=0; i<tags.length; i++)
        {
            if (!condicion.isEmpty())
            {
                condicion+=" OR ";
            }
            condicion+="t.name=:valortag"+i;
        }
        Query q=null;
        if (tag.isEmpty())
        {
            q = entityManager.createQuery("select u from ProyectoEntity u");
        }
        else
        {
            q = entityManager.createQuery("select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s on s.proyectoId=u.id inner join TagEntity t on t.id=s.tag_proyectoId where "+condicion);
            for(int j=0; j<tags.length; j++)
            {
                q.setParameter("valortag"+j,tags[j]);
            }
        }
        List<ProyectoDTO> proyectos=ProyectoConverter.entity2PersistenceDTOList(q.getResultList());
        String ids="";
        for(ProyectoDTO proyecto:proyectos)
        {
            if(!ids.isEmpty())
            {
                ids+=",";
            }
            ids+=proyecto.getId();
        }
        return ids;
    }
    
    public String emailId(String id_equipo) {
        ArrayList<String> ans = new ArrayList<String>();
        Query q=null;
        q = entityManager.createQuery("select u.email from EquipoEntity u where u.id = :value").setParameter("value", Long.parseLong(id_equipo));
        return q.getSingleResult().toString();
    }
    
    public String realizarSolicitud(String name, String lname, String email, String link, String rol, 
            String comment, String id) {
       
        long range = 1234567L;
        Random r = new Random();
        long number1 = (long)(r.nextDouble()*range);
        return number1 + "";
    }
    
    public ArrayList<String> proyectoSearch(String tag) {
        
        ArrayList<String> toReturn = new ArrayList<String>();
        
        Query q = entityManager.createQuery("select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s "
                + "on s.proyectoId = u.id inner join TagEntity t "
                + "on t.id = s.tag_proyectoId"
                + " where t.name like :value or "
                + "u.descripcion like :value or u.name like :value");
        
        q.setParameter("value", "%"+tag+"%");
        
        List<ProyectoDTO> proyectos = ProyectoConverter.entity2PersistenceDTOList(q.getResultList());
        
        for(ProyectoDTO ne : proyectos) {
            String ans = "";
            ans += "{";
            
            ans += "\"descripcion\": ";
            String des = "\"" + ne.getDescripcion() + "\"";
            ans += des + ", "; 
            
            ans += "\"imagen\": ";
            String img = "\"" + ne.getImagen()+ "\"";
            ans += img + ", ";
            
            ans += "\"name\": ";
            String nme = "\"" + ne.getName()+ "\"";
            ans += nme;  
            
            ans += "}";
            
            toReturn.add(ans);            
        }
        return toReturn;
       
    }
    
    
    
    
    
}