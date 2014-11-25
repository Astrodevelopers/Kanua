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

package co.edu.uniandes.csw.astroDevelopers.noticia.master.persistence;

import javax.ejb.Stateless;

import co.edu.uniandes.csw.astroDevelopers.noticia.master.persistence.api.INoticiaMasterPersistence;
import javax.ejb.LocalBean;
import javax.enterprise.inject.Default;
import java.util.List;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.converter.NoticiaConverter;
import co.edu.uniandes.csw.astroDevelopers.noticia.logic.dto.NoticiaDTO;
import javax.persistence.Query;

@Default
@Stateless 
@LocalBean
public class NoticiaMasterPersistence extends _NoticiaMasterPersistence  implements INoticiaMasterPersistence {
    public String buscarNoticiasPorTitulo(String titulo) {
        // https://access.redhat.com/documentation/en-US/JBoss_Enterprise_Application_Platform/5/html/RESTEasy_Reference_Guide/Using__Path_and__GET___POST__etc..html
        // Query q = entityManager.createQuery("select u from ProyectoEntity u inner join Proyectotag_proyectoEntity s on s.proyectoId=u.id inner join TagEntity t on t.id=s.tag_proyectoId where t.name=:valortag");
        // q.setParameter("valortag",tag);
        String titulos[]=titulo.split("\\;");
        String condicion="";
        for (int i=0; i<titulos.length; i++)
        {
            if (!condicion.isEmpty())
            {
                condicion+=" OR ";
            }
            condicion+="u.name=:valortitulo"+i;
        }
        Query q=null;
        if (titulo.isEmpty())
        {
            q = entityManager.createQuery("select u from NoticiaEntity u");
        }
        else
        {
            q = entityManager.createQuery("select u from NoticiaEntity u  where "+condicion);
            for(int j=0; j<titulos.length; j++)
            {
                q.setParameter("valortitulo"+j,titulos[j]);
            }
        }
        List<NoticiaDTO> noticias=NoticiaConverter.entity2PersistenceDTOList(q.getResultList());
        String ids="";
        for(NoticiaDTO noticia:noticias)
        {
            if(!ids.isEmpty())
            {
                ids+=",";
            }
            ids+=noticia.getId();
        }
        return ids;
    }
}