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

package co.edu.uniandes.csw.astroDevelopers.charla.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.astroDevelopers.charla.master.persistence.api.ICharlaMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;
import javax.persistence.Query;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.converter.CharlaConverter;
import co.edu.uniandes.csw.astroDevelopers.charla.logic.dto.CharlaDTO;
import java.util.ArrayList;
import java.util.List;

@Default
@Stateless 
@LocalBean
public class CharlaMasterPersistence extends _CharlaMasterPersistence  implements ICharlaMasterPersistence {

        public String buscarCharlaPorTag(String tag) {
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
            q = entityManager.createQuery("select u from CharlaEntity u");
        }
        else
        {
            q = entityManager.createQuery("select u from CharlaEntity u inner join Charlatag_charlaEntity s on s.charlaId=u.id inner join TagEntity t on t.id=s.tag_charlaId where "+condicion);
            for(int j=0; j<tags.length; j++)
            {
                q.setParameter("valortag"+j,tags[j]);
            }
        }
        List<CharlaDTO> charlas=CharlaConverter.entity2PersistenceDTOList(q.getResultList());
        String ids="";
        for(CharlaDTO charla:charlas)
        {
            if(!ids.isEmpty())
            {
                ids+=",";
            }
            ids+=charla.getId();
        }
        return ids;
    }

    public ArrayList<String> charlaSearch(String tag) {
        ArrayList<String> toReturn = new ArrayList<String>();
        
        Query q = entityManager.createQuery("select u from CharlaEntity u "
                + "where u.informacion like :value "
                + "or u.name like :value "
                + "or u.titulo like :value");
        
        q.setParameter("value", "%"+tag+"%");
        
        List<CharlaDTO> charlas = CharlaConverter.entity2PersistenceDTOList(q.getResultList());
        for(int i = 0; i < 10; i++)
            System.out.println(charlas.size());
        
        for(CharlaDTO ne : charlas) {
            String ans = "";
            ans += "{";
            
            ans += "\"descripcion\": ";
            String des = "\"" + ne.getInformacion() + "\"";
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