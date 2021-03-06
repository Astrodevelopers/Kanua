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
import co.edu.uniandes.csw.astroDevelopers.tag.logic.dto.TagDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.master.persistence.entity.Proyectotag_proyectoEntity;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.converter.TagConverter;
import co.edu.uniandes.csw.astroDevelopers.objetivo.logic.dto.ObjetivoDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.master.persistence.entity.Proyectoobjetivo_proyectoEntity;
import co.edu.uniandes.csw.astroDevelopers.objetivo.persistence.converter.ObjetivoConverter;
import co.edu.uniandes.csw.astroDevelopers.proyecto.logic.dto.ProyectoDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.master.logic.dto.ProyectoMasterDTO;
import co.edu.uniandes.csw.astroDevelopers.proyecto.master.persistence.api._IProyectoMasterPersistence;
import co.edu.uniandes.csw.astroDevelopers.proyecto.persistence.api.IProyectoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _ProyectoMasterPersistence implements _IProyectoMasterPersistence {

  	@PersistenceContext(unitName="KanuaUML12PU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected IProyectoPersistence proyectoPersistence;  

    public ProyectoMasterDTO getProyecto(Long proyectoId) {
        ProyectoMasterDTO proyectoMasterDTO = new ProyectoMasterDTO();
        ProyectoDTO proyecto = proyectoPersistence.getProyecto(proyectoId);
        proyectoMasterDTO.setProyectoEntity(proyecto);
        proyectoMasterDTO.setListtag_proyecto(getProyectotag_proyectoEntityList(proyectoId));
        proyectoMasterDTO.setListobjetivo_proyecto(getProyectoobjetivo_proyectoEntityList(proyectoId));
        return proyectoMasterDTO;
    }

    public Proyectotag_proyectoEntity createProyectotag_proyectoEntity(Proyectotag_proyectoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteProyectotag_proyectoEntity(Long proyectoId, Long tag_proyectoId) {
        Query q = entityManager.createNamedQuery("Proyectotag_proyectoEntity.deleteProyectotag_proyectoEntity");
        q.setParameter("proyectoId", proyectoId);
        q.setParameter("tag_proyectoId", tag_proyectoId);
        q.executeUpdate();
    }

    public List<TagDTO> getProyectotag_proyectoEntityList(Long proyectoId) {
        ArrayList<TagDTO> resp = new ArrayList<TagDTO>();
        Query q = entityManager.createNamedQuery("Proyectotag_proyectoEntity.getByMasterId");
        q.setParameter("proyectoId",proyectoId);
        List<Proyectotag_proyectoEntity> qResult =  q.getResultList();
        for (Proyectotag_proyectoEntity entity : qResult) { 
            if(entity.getTag_proyectoIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(TagConverter.entity2PersistenceDTO(entity.getTag_proyectoIdEntity()));
        }
        return resp;
    }
    public Proyectoobjetivo_proyectoEntity createProyectoobjetivo_proyectoEntity(Proyectoobjetivo_proyectoEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteProyectoobjetivo_proyectoEntity(Long proyectoId, Long objetivo_proyectoId) {
        Query q = entityManager.createNamedQuery("Proyectoobjetivo_proyectoEntity.deleteProyectoobjetivo_proyectoEntity");
        q.setParameter("proyectoId", proyectoId);
        q.setParameter("objetivo_proyectoId", objetivo_proyectoId);
        q.executeUpdate();
    }

    public List<ObjetivoDTO> getProyectoobjetivo_proyectoEntityList(Long proyectoId) {
        ArrayList<ObjetivoDTO> resp = new ArrayList<ObjetivoDTO>();
        Query q = entityManager.createNamedQuery("Proyectoobjetivo_proyectoEntity.getByMasterId");
        q.setParameter("proyectoId",proyectoId);
        List<Proyectoobjetivo_proyectoEntity> qResult =  q.getResultList();
        for (Proyectoobjetivo_proyectoEntity entity : qResult) { 
            if(entity.getObjetivo_proyectoIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(ObjetivoConverter.entity2PersistenceDTO(entity.getObjetivo_proyectoIdEntity()));
        }
        return resp;
    }

}
