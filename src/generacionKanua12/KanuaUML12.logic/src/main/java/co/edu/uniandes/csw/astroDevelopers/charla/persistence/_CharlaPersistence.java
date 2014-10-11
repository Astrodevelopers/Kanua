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

package co.edu.uniandes.csw.astroDevelopers.charla.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.astroDevelopers.charla.logic.dto.CharlaDTO;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.api._ICharlaPersistence;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.converter.CharlaConverter;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.entity.CharlaEntity;

public abstract class _CharlaPersistence implements _ICharlaPersistence {

  	@PersistenceContext(unitName="KanuaUML12PU")
 
	protected EntityManager entityManager;
	
	public CharlaDTO createCharla(CharlaDTO charla) {
		CharlaEntity entity=CharlaConverter.persistenceDTO2Entity(charla);
		entityManager.persist(entity);
		return CharlaConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<CharlaDTO> getCharlas() {
		Query q = entityManager.createQuery("select u from CharlaEntity u");
		return CharlaConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public CharlaDTO getCharla(Long id) {
		return CharlaConverter.entity2PersistenceDTO(entityManager.find(CharlaEntity.class, id));
	}

	public void deleteCharla(Long id) {
		CharlaEntity entity=entityManager.find(CharlaEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCharla(CharlaDTO detail) {
		CharlaEntity entity=entityManager.merge(CharlaConverter.persistenceDTO2Entity(detail));
		CharlaConverter.entity2PersistenceDTO(entity);
	}

}