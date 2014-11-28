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

package co.edu.uniandes.csw.astroDevelopers.taller.logic.ejb;

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


import co.edu.uniandes.csw.astroDevelopers.taller.logic.dto.TallerDTO;
import co.edu.uniandes.csw.astroDevelopers.taller.logic.api.ITallerLogicService;
import co.edu.uniandes.csw.astroDevelopers.taller.persistence.TallerPersistence;
import co.edu.uniandes.csw.astroDevelopers.taller.persistence.api.ITallerPersistence;
import co.edu.uniandes.csw.astroDevelopers.taller.persistence.entity.TallerEntity;
import co.edu.uniandes.csw.astroDevelopers.taller.persistence.converter.TallerConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

import co.edu.uniandes.csw.astroDevelopers.taller.master.logic.api.ITallerMasterLogicService;
import co.edu.uniandes.csw.astroDevelopers.taller.master.persistence.api.ITallerMasterPersistence;
import co.edu.uniandes.csw.astroDevelopers.taller.master.persistence.TallerMasterPersistence;
import co.edu.uniandes.csw.astroDevelopers.taller.master.logic.ejb.TallerMasterLogicService;
import co.edu.uniandes.csw.astroDevelopers.taller.master.logic.dto.TallerMasterDTO;

import co.edu.uniandes.csw.astroDevelopers.tag.logic.api.ITagLogicService;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.TagPersistence;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.api.ITagPersistence;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.entity.TagEntity;
import co.edu.uniandes.csw.astroDevelopers.tag.persistence.converter.TagConverter;
import co.edu.uniandes.csw.astroDevelopers.tag.logic.dto.TagDTO;
import co.edu.uniandes.csw.astroDevelopers.tag.logic.ejb.TagLogicService;
import co.edu.uniandes.csw.astroDevelopers.taller.master.persistence.entity.Tallertag_tallerEntity;
import co.edu.uniandes.csw.astroDevelopers.usuario.logic.api.IUsuarioLogicService;
import co.edu.uniandes.csw.astroDevelopers.usuario.logic.dto.UsuarioDTO;
import co.edu.uniandes.csw.astroDevelopers.usuario.logic.ejb.UsuarioLogicService;
import co.edu.uniandes.csw.astroDevelopers.usuario.persistence.UsuarioPersistence;
import co.edu.uniandes.csw.astroDevelopers.usuario.persistence.api.IUsuarioPersistence;
import co.edu.uniandes.csw.astroDevelopers.usuario.persistence.converter.UsuarioConverter;
import co.edu.uniandes.csw.astroDevelopers.usuario.persistence.entity.UsuarioEntity;
import co.edu.uniandes.csw.astroDevelopers.taller.master.persistence.entity.TallerusuarioEntity;
@RunWith(Arquillian.class)
public class TallerLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(TallerLogicService.class.getPackage())
				.addPackage(ITallerLogicService.class.getPackage())
				.addPackage(TallerPersistence.class.getPackage())
				.addPackage(TallerEntity.class.getPackage())
				.addPackage(ITallerPersistence.class.getPackage())
                                .addPackage(ITallerMasterLogicService.class.getPackage())
                                .addPackage(ITallerMasterPersistence.class.getPackage())
                                .addPackage(TallerMasterPersistence.class.getPackage())
                                .addPackage(TallerMasterLogicService.class.getPackage())
                                .addPackage(TagLogicService.class.getPackage())
				.addPackage(ITagLogicService.class.getPackage())
				.addPackage(TagPersistence.class.getPackage())
				.addPackage(TagEntity.class.getPackage())
				.addPackage(ITagPersistence.class.getPackage())
                                .addPackage(UsuarioLogicService.class.getPackage())
				.addPackage(IUsuarioLogicService.class.getPackage())
				.addPackage(UsuarioPersistence.class.getPackage())
				.addPackage(UsuarioEntity.class.getPackage())
				.addPackage(IUsuarioPersistence.class.getPackage())
                .addPackage(UsuarioDTO.class.getPackage())
                .addPackage(UsuarioConverter.class.getPackage())
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(TagDTO.class.getPackage())
                .addPackage(Tallertag_tallerEntity.class.getPackage())
                .addPackage(TagConverter.class.getPackage())
                .addPackage(TagEntity.class.getPackage())
                .addPackage(TallerusuarioEntity.class.getPackage())
                .addPackage(TallerDTO.class.getPackage())
                .addPackage(TallerMasterDTO.class.getPackage())
                .addPackage(TallerConverter.class.getPackage())
                .addPackage(TallerEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private ITallerLogicService tallerLogicService;
	
	@Inject
	private ITallerPersistence tallerPersistence;	
        
        	@Inject
	private ITagLogicService tagLogicService;
        
        @PersistenceContext
	private EntityManager em;
        
        @Inject
	private ITallerMasterPersistence tallerMasterPersistence;
        
        @Inject
        protected ITallerMasterLogicService tallerMasterLogicService;
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
		List<TallerDTO> dtos=tallerPersistence.getTallers();
		for(TallerDTO dto:dtos){
			tallerPersistence.deleteTaller(dto.getId());
		}
	}

	private List<TallerDTO> data=new ArrayList<TallerDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			TallerDTO pdto=new TallerDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setInformacion(generateRandom(String.class));
			pdto.setImagen(generateRandom(String.class));
			pdto.setTitulo(generateRandom(String.class));
			pdto.setTema(generateRandom(String.class));
			pdto.setFechaEvento(generateRandomDate());
			pdto.setPublicacion(generateRandomDate());
			pdto=tallerPersistence.createTaller(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createTallerTest(){
		TallerDTO ldto=new TallerDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setInformacion(generateRandom(String.class));
		ldto.setImagen(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setTema(generateRandom(String.class));
		ldto.setFechaEvento(generateRandomDate());
		ldto.setPublicacion(generateRandomDate());
		
		
		TallerDTO result=tallerLogicService.createTaller(ldto);
		
		Assert.assertNotNull(result);
		
		TallerDTO pdto=tallerPersistence.getTaller(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getInformacion(), pdto.getInformacion());	
		Assert.assertEquals(ldto.getImagen(), pdto.getImagen());	
		Assert.assertEquals(ldto.getTitulo(), pdto.getTitulo());	
		Assert.assertEquals(ldto.getTema(), pdto.getTema());	
		Assert.assertEquals(ldto.getFechaEvento(), pdto.getFechaEvento());	
		Assert.assertEquals(ldto.getPublicacion(), pdto.getPublicacion());	
	}
	
	@Test
	public void getTallersTest(){
		List<TallerDTO> list=tallerLogicService.getTallers();
		Assert.assertEquals(list.size(), data.size());
        for(TallerDTO ldto:list){
        	boolean found=false;
            for(TallerDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getTallerTest(){
		TallerDTO pdto=data.get(0);
		TallerDTO ldto=tallerLogicService.getTaller(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getInformacion(), ldto.getInformacion());
		Assert.assertEquals(pdto.getImagen(), ldto.getImagen());
		Assert.assertEquals(pdto.getTitulo(), ldto.getTitulo());
		Assert.assertEquals(pdto.getTema(), ldto.getTema());
		Assert.assertEquals(pdto.getFechaEvento(), ldto.getFechaEvento());
		Assert.assertEquals(pdto.getPublicacion(), ldto.getPublicacion());
        
	}
	
	@Test
	public void deleteTallerTest(){
		TallerDTO pdto=data.get(0);
		tallerLogicService.deleteTaller(pdto.getId());
        TallerDTO deleted=tallerPersistence.getTaller(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateTallerTest(){
		TallerDTO pdto=data.get(0);
		
		TallerDTO ldto=new TallerDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setInformacion(generateRandom(String.class));
		ldto.setImagen(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setTema(generateRandom(String.class));
		ldto.setFechaEvento(generateRandomDate());
		ldto.setPublicacion(generateRandomDate());
		
		
		tallerLogicService.updateTaller(ldto);
		
		
		TallerDTO resp=tallerPersistence.getTaller(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getInformacion(), resp.getInformacion());	
		Assert.assertEquals(ldto.getImagen(), resp.getImagen());	
		Assert.assertEquals(ldto.getTitulo(), resp.getTitulo());	
		Assert.assertEquals(ldto.getTema(), resp.getTema());	
		Assert.assertEquals(ldto.getFechaEvento(), resp.getFechaEvento());	
		Assert.assertEquals(ldto.getPublicacion(), resp.getPublicacion());	
	}
	
	 @Test
	public void buscarCharlaTest(){
            
                TallerDTO ldto=new TallerDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setInformacion(generateRandom(String.class));
		ldto.setFechaEvento(generateRandomDate());
		ldto.setImagen(generateRandom(String.class));
		ldto.setPublicacion(generateRandomDate());
		TallerDTO result=tallerLogicService.createTaller(ldto);
                
		TagDTO tag1=new TagDTO();
                tag1.setName("clau");
                TagDTO resultag=tagLogicService.createTag(tag1);
                
		Assert.assertNotNull(result);
                Assert.assertNotNull(resultag);
                
		String resultado1=tallerMasterLogicService.buscarTallersPorTag("blublublublu");
                Assert.assertEquals("",resultado1);
                Tallertag_tallerEntity chtag=new Tallertag_tallerEntity(result.getId(),resultag.getId());
                System.out.println("000***********************************  ");
                tallerMasterPersistence.createTallertag_tallerEntity(chtag);
		System.out.println("111***********************************  "+chtag.getTallerId());
                
                String resultado=tallerMasterLogicService.buscarTallersPorTag("clau");
               // Assert.assertEquals("",resultado);
                System.out.println("222***********************************  "+resultado);
                Assert.assertEquals(resultado, chtag.getTallerId()+"");
                
        
        
	}
        
	@Test
        public void buscarCharlaForTest(){
            for(int i=0; i<20; i++)
            {
               TallerDTO ldto=new TallerDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setInformacion(generateRandom(String.class));
		ldto.setFechaEvento(generateRandomDate());
		ldto.setImagen(generateRandom(String.class));
		ldto.setPublicacion(generateRandomDate());
		TallerDTO result=tallerLogicService.createTaller(ldto);
                
		TagDTO tag1=new TagDTO();
                tag1.setName("clau"+i);
                TagDTO resultag=tagLogicService.createTag(tag1);
                
		Assert.assertNotNull(result);
                Assert.assertNotNull(resultag);
                
		String resultado1=tallerMasterLogicService.buscarTallersPorTag("holaholaholahola"+i);
                Assert.assertEquals("",resultado1);
                Tallertag_tallerEntity chtag=new Tallertag_tallerEntity(result.getId(),resultag.getId());
                System.out.println("000***********************************  ");
                tallerMasterPersistence.createTallertag_tallerEntity(chtag);
		
                String resultado=tallerMasterLogicService.buscarTallersPorTag("clau"+i);
                Assert.assertEquals(resultado, chtag.getTallerId()+"");
            }
        }
        
        @Test
        public void buscarCharlasTest(){
            
                TallerDTO ldto=new TallerDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setInformacion(generateRandom(String.class));
		ldto.setFechaEvento(generateRandomDate());
		ldto.setImagen(generateRandom(String.class));
		ldto.setPublicacion(generateRandomDate());
                TallerDTO ldto2=new TallerDTO();
		ldto2.setName(generateRandom(String.class));
		ldto2.setTitulo(generateRandom(String.class));
		ldto2.setInformacion(generateRandom(String.class));
		ldto2.setFechaEvento(generateRandomDate());
		ldto2.setImagen(generateRandom(String.class));
		ldto2.setPublicacion(generateRandomDate());
		TallerDTO result1=tallerLogicService.createTaller(ldto);
                TallerDTO result2=tallerLogicService.createTaller(ldto2);
            
		TagDTO tag1=new TagDTO();
                TagDTO tag2=new TagDTO();
                
                tag1.setName("clau");
                tag2.setName("dani");
                TagDTO resultag1=tagLogicService.createTag(tag1);
                TagDTO resultag2=tagLogicService.createTag(tag2);
		Assert.assertNotNull(result1);
                Assert.assertNotNull(result2);
                Assert.assertNotNull(resultag1);
                Assert.assertNotNull(resultag2);
            
		String resultado1=tallerMasterLogicService.buscarTallersPorTag("holahola");
                Assert.assertEquals("",resultado1);
                Tallertag_tallerEntity chtag1=new Tallertag_tallerEntity(result1.getId(),resultag1.getId());
                Tallertag_tallerEntity chtag2=new Tallertag_tallerEntity(result2.getId(),resultag2.getId());
                //System.out.println("000***********************************  ");
                tallerMasterPersistence.createTallertag_tallerEntity(chtag1);
                tallerMasterPersistence.createTallertag_tallerEntity(chtag2);
                
                String resultado=tallerMasterLogicService.buscarTallersPorTag("clau;dani");
                //System.out.println("222222222***********************************  "+resultado+"+++++++ "+result1.getId()+""+result2.getId());
                
                Assert.assertEquals(result1.getId()+","+result2.getId(),resultado);
                //System.out.println("222222222***********************************  "+resultado+"+++++++ "+result1.getId()+""+result2.getId());
                
            
            
        }
	
}