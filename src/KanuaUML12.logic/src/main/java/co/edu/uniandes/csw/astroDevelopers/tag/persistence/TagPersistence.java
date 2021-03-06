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

package co.edu.uniandes.csw.astroDevelopers.tag.persistence;

import co.edu.uniandes.csw.astroDevelopers.noticia.logic.dto.NoticiaDTO;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.converter.NoticiaConverter;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.converter._NoticiaConverter;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.entity.NoticiaEntity;
import co.edu.uniandes.csw.astroDevelopers.proyecto.logic.dto.ProyectoDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.persistence.converter.ProyectoConverter;
import co.edu.uniandes.csw.astroDevelopers.tag.logic.dto.TagDTO;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.api.ITagPersistence;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.persistence.Query;

@Default
@Stateless 
@LocalBean
public class TagPersistence extends _TagPersistence  implements ITagPersistence {
    
    public String generalSearch(String value) {
        
        String ans = "";
        
        ans += noticiaSearch(value);
        ans += proyectoSearch(value);
        
        return ans;        
    }
    
    public String noticiaSearch(String value) {
        
        String ans = "[";
        
        Query q = entityManager.createQuery("SELECT u FROM NoticiaEntity u WHERE "
                + "u.descripcion like :value OR u.name like :value OR u.titulo like :value");
        q.setParameter("value", "%"+value+"%");
        
        List<NoticiaEntity> list = NoticiaConverter.persistenceDTO2EntityList(q.getResultList());
        
        for(NoticiaEntity ne : list) {
            
            ans += "{";
            
            ans += "\"Description\": ";
            String des = ne.getDescripcion();
            ans += des + ", ";            
            
            ans += "\"Date\": ";
            String dte = ne.getFecha().toString();
            ans += dte + ", ";
            
            ans += "\"Image\": ";
            String img = ne.getImagen();
            ans += img + ", ";
            
            ans += "\"Name\": ";
            String nme = ne.getName();
            ans += nme + ", ";
            
            ans += "\"Topic\": ";
            String tma = ne.getTema();
            ans += tma + ", ";
            
            ans += "\"Title\": ";
            String tlo = ne.getTitulo();
            ans += tlo + ", ";
            
            ans += "}, "; 
            
        }
        
        ans += "], ";
        return ans;
    }
    
    public String proyectoSearch(String value) {
        
        String ans = "[";
        
        //"select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s 
        // on s.proyectoId=u.id inner join TagEntity t on t.id=s.tag_proyectoId
        
        Query q = entityManager.createQuery("select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s "
                + "on s.proyectoId = u.id inner join TagEntity t "
                + "on t.id = s.tag_proyectoId"
                + " where t.name like :value or "
                + "u.descripcion like :value or u.name like :value or u.titulo like :value");
        
        q.setParameter("value", "%"+value+"%");
        
        List<ProyectoDTO> proyectos = ProyectoConverter.entity2PersistenceDTOList(q.getResultList());
        
        for(ProyectoDTO ne : proyectos) {
            
            ans += "{";
            
            ans += "\"Demo\": ";
            String des = ne.getDemo();
            ans += des + ", ";            
            
            ans += "\"Description\": ";
            String dte = ne.getDescripcion();
            ans += dte + ", ";
            
            ans += "\"Estado\": ";
            String img = ne.getEstado().toString();
            ans += img + ", ";
            
            ans += "\"Image\": ";
            String nme = ne.getImagen();
            ans += nme + ", ";
            
            ans += "\"Name\": ";
            String tma = ne.getName();
            ans += tma + ", ";
            
            ans += "\"Topic\": ";
            String tlo = ne.getTema();
            ans += tlo + ", ";
            
            ans += "}, "; 
            
        }
        
        ans += "], ";
        return ans;
       
    }

}