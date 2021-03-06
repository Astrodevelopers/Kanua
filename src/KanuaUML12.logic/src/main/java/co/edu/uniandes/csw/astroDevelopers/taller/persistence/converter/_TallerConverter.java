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

package co.edu.uniandes.csw.astroDevelopers.taller.persistence.converter;

import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


import co.edu.uniandes.csw.astroDevelopers.taller.logic.dto.TallerDTO;
import co.edu.uniandes.csw.astroDevelopers.taller.persistence.entity.TallerEntity;

public abstract class _TallerConverter {

 
	private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static TallerDTO entity2PersistenceDTO(TallerEntity entity){
		if (entity != null) {
			TallerDTO dto = new TallerDTO();
					dto.setId(entity.getId());
					dto.setName(entity.getName());
					dto.setInformacion(entity.getInformacion());
					dto.setImagen(entity.getImagen());
					dto.setTitulo(entity.getTitulo());
					dto.setTema(entity.getTema());
 
			    if(entity.getFechaEvento() != null){
					dto.setFechaEvento(DATE_FORMAT.format(entity.getFechaEvento()));
				}	
 
			    if(entity.getPublicacion() != null){
					dto.setPublicacion(DATE_FORMAT.format(entity.getPublicacion()));
				}	
			return dto;
		}else{
			return null;
		}
	}
	
	public static TallerEntity persistenceDTO2Entity(TallerDTO dto){
		if(dto!=null){
			TallerEntity entity=new TallerEntity();
					entity.setId(dto.getId());
			
					entity.setName(dto.getName());
			
					entity.setInformacion(dto.getInformacion());
			
					entity.setImagen(dto.getImagen());
			
					entity.setTitulo(dto.getTitulo());
			
					entity.setTema(dto.getTema());
			
 
			      try{ 
			        if(dto.getFechaEvento() != null){
						entity.setFechaEvento(DATE_FORMAT.parse(dto.getFechaEvento()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_TallerConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
 
			      try{ 
			        if(dto.getPublicacion() != null){
						entity.setPublicacion(DATE_FORMAT.parse(dto.getPublicacion()));
					}
				  } catch (Exception ex) {
                        Logger.getLogger(_TallerConverter.class.getName()).log(Level.SEVERE, null, ex);
                  }	
			
			return entity;
		}else {
			return null;
		}
	}
	
	public static List<TallerDTO> entity2PersistenceDTOList(List<TallerEntity> entities){
		List<TallerDTO> dtos=new ArrayList<TallerDTO>();
		for(TallerEntity entity:entities){
			dtos.add(entity2PersistenceDTO(entity));
		}
		return dtos;
	}
	
	public static List<TallerEntity> persistenceDTO2EntityList(List<TallerDTO> dtos){
		List<TallerEntity> entities=new ArrayList<TallerEntity>();
		for(TallerDTO dto:dtos){
			entities.add(persistenceDTO2Entity(dto));
		}
		return entities;
	}
}