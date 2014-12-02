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


Source generated by CrudMaker version 1.0.0.201410261249

*/

package co.edu.uniandes.csw.astroDevelopers.solicitud.logic.ejb;

import co.edu.uniandes.csw.astroDevelopers.equipo.logic.api.IEquipoLogicService;
import co.edu.uniandes.csw.astroDevelopers.equipo.logic.dto.EquipoDTO;
import co.edu.uniandes.csw.astroDevelopers.equipo.master.logic.api.IEquipoMasterLogicService;
import co.edu.uniandes.csw.astroDevelopers.equipo.persistence.api.IEquipoPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.*;


import co.edu.uniandes.csw.astroDevelopers.solicitud.logic.dto.SolicitudDTO;
import co.edu.uniandes.csw.astroDevelopers.solicitud.logic.api.ISolicitudLogicService;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.SolicitudPersistence;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.api.ISolicitudPersistence;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.entity.SolicitudEntity;
import co.edu.uniandes.csw.astroDevelopers.solicitud.persistence.converter.SolicitudConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

@RunWith(Arquillian.class)
public class SolicitudLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(SolicitudLogicService.class.getPackage())
				.addPackage(ISolicitudLogicService.class.getPackage())
				.addPackage(SolicitudPersistence.class.getPackage())
				.addPackage(SolicitudEntity.class.getPackage())
				.addPackage(ISolicitudPersistence.class.getPackage())
                .addPackage(SolicitudDTO.class.getPackage())
                .addPackage(SolicitudConverter.class.getPackage())
                .addPackage(SolicitudEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private ISolicitudLogicService solicitudLogicService;
	
	@Inject
	private ISolicitudPersistence solicitudPersistence;
        
        @Inject
        IEquipoLogicService equipoLogicService;
        
        @Inject
        IEquipoMasterLogicService equipoMasterLogicService;
        
        @Inject
        IEquipoPersistence equipoPersistence;

	@Before
	public void configTest() {
		try {
			clearData();
			insertData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void clearData() {
		List<SolicitudDTO> dtos=solicitudPersistence.getSolicituds();
		for(SolicitudDTO dto:dtos){
			solicitudPersistence.deleteSolicitud(dto.getId());
		}
	}

	private List<SolicitudDTO> data=new ArrayList<SolicitudDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			SolicitudDTO pdto=new SolicitudDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setEmailPersona(generateRandom(String.class));
			pdto.setHojaDeVida(generateRandom(String.class));
			pdto.setComentario(generateRandom(String.class));
			pdto.setNombreApellido(generateRandom(String.class));
			pdto.setRol_solicitudId(generateRandom(Long.class));
			pdto=solicitudPersistence.createSolicitud(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createSolicitudTest(){
		SolicitudDTO ldto=new SolicitudDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setEmailPersona(generateRandom(String.class));
		ldto.setHojaDeVida(generateRandom(String.class));
		ldto.setComentario(generateRandom(String.class));
		ldto.setNombreApellido(generateRandom(String.class));
		ldto.setRol_solicitudId(generateRandom(Long.class));
		
		
		SolicitudDTO result=solicitudLogicService.createSolicitud(ldto);
		
		Assert.assertNotNull(result);
		
		SolicitudDTO pdto=solicitudPersistence.getSolicitud(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getEmailPersona(), pdto.getEmailPersona());	
		Assert.assertEquals(ldto.getHojaDeVida(), pdto.getHojaDeVida());	
		Assert.assertEquals(ldto.getComentario(), pdto.getComentario());	
		Assert.assertEquals(ldto.getNombreApellido(), pdto.getNombreApellido());	
		Assert.assertEquals(ldto.getRol_solicitudId(), pdto.getRol_solicitudId());	
	}
	
	@Test
	public void getSolicitudsTest(){
		List<SolicitudDTO> list=solicitudLogicService.getSolicituds();
		Assert.assertEquals(list.size(), data.size());
        for(SolicitudDTO ldto:list){
        	boolean found=false;
            for(SolicitudDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getSolicitudTest(){
		SolicitudDTO pdto=data.get(0);
		SolicitudDTO ldto=solicitudLogicService.getSolicitud(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getEmailPersona(), ldto.getEmailPersona());
		Assert.assertEquals(pdto.getHojaDeVida(), ldto.getHojaDeVida());
		Assert.assertEquals(pdto.getComentario(), ldto.getComentario());
		Assert.assertEquals(pdto.getNombreApellido(), ldto.getNombreApellido());
		Assert.assertEquals(pdto.getRol_solicitudId(), ldto.getRol_solicitudId());
        
	}
	
	@Test
	public void deleteSolicitudTest(){
		SolicitudDTO pdto=data.get(0);
		solicitudLogicService.deleteSolicitud(pdto.getId());
        SolicitudDTO deleted=solicitudPersistence.getSolicitud(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateSolicitudTest(){
		SolicitudDTO pdto=data.get(0);
		
		SolicitudDTO ldto=new SolicitudDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setEmailPersona(generateRandom(String.class));
		ldto.setHojaDeVida(generateRandom(String.class));
		ldto.setComentario(generateRandom(String.class));
		ldto.setNombreApellido(generateRandom(String.class));
		ldto.setRol_solicitudId(generateRandom(Long.class));
		
		
		solicitudLogicService.updateSolicitud(ldto);
		
		
		SolicitudDTO resp=solicitudPersistence.getSolicitud(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getEmailPersona(), resp.getEmailPersona());	
		Assert.assertEquals(ldto.getHojaDeVida(), resp.getHojaDeVida());	
		Assert.assertEquals(ldto.getComentario(), resp.getComentario());	
		Assert.assertEquals(ldto.getNombreApellido(), resp.getNombreApellido());	
		Assert.assertEquals(ldto.getRol_solicitudId(), resp.getRol_solicitudId());	
	}
        
        @Test
	public void enviarSolicitudTest1(){
		
		String id = solicitudLogicService.crearSolicitud("Anita", "Loaiza", 
                        "sc.dfgfsg@adsfsd.com", "www.youtube.com", "1", "Wirth");
                
                Assert.assertTrue(id != null);
	}
        
        @Test
	public void enviarSolicitudTest2(){
		
		String id = solicitudLogicService.crearSolicitud("Anita", "Loaiza", 
                        "sc.dfgfsg@adsfsd.com", "www.youtube.com", "1", "Wirth");
                
                EquipoDTO dto=new EquipoDTO();
		dto.setName(generateRandom(String.class));
		dto.setEmail(generateRandom(String.class));
                equipoPersistence.createEquipo(dto);
                
                String ans = equipoMasterLogicService.registrarSolicitud(id, dto.getId() + "");
                Assert.assertEquals("Solicitud enviada", ans);
                
                
                
	}
	
	
	
}