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

package co.edu.uniandes.csw.astroDevelopers.objetivo.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.astroDevelopers.objetivo.logic.dto.ObjetivoDTO;
import co.edu.uniandes.csw.astroDevelopers.objetivo.persistence.entity.ObjetivoEntity;

public abstract class _ObjetivoConverter {

	public static ObjetivoDTO entity2PersistenceDTO(ObjetivoEntity entity){
		if (entity != null) {
			ObjetivoDTO dto = new ObjetivoDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setDescripcion(entity.getDescripcion());
			return dto;
		}else{
			return null;
		}
	}
	
	public static ObjetivoEntity persistenceDTO2Entity(ObjetivoDTO dto){
		if(dto!=null){
			ObjetivoEntity entity=new ObjetivoEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setDescripcion(dto.getDescripcion());
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<ObjetivoDTO> entity2PersistenceDTOList(List<ObjetivoEntity> entities){
		List<ObjetivoDTO> dtos=new ArrayList<ObjetivoDTO>();
		for(ObjetivoEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<ObjetivoEntity> persistenceDTO2EntityList(List<ObjetivoDTO> dtos){
		List<ObjetivoEntity> entities=new ArrayList<ObjetivoEntity>();
		for(ObjetivoDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}