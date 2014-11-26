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

package co.edu.uniandes.csw.astroDevelopers.noticia.logic.ejb;

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


import co.edu.uniandes.csw.astroDevelopers.noticia.logic.dto.NoticiaDTO;
import co.edu.uniandes.csw.astroDevelopers.noticia.logic.api.INoticiaLogicService;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.NoticiaPersistence;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.api.INoticiaPersistence;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.entity.NoticiaEntity;
import co.edu.uniandes.csw.astroDevelopers.noticia.persistence.converter.NoticiaConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

@RunWith(Arquillian.class)
public class NoticiaLogicServiceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(NoticiaLogicService.class.getPackage())
				.addPackage(INoticiaLogicService.class.getPackage())
				.addPackage(NoticiaPersistence.class.getPackage())
				.addPackage(NoticiaEntity.class.getPackage())
				.addPackage(INoticiaPersistence.class.getPackage())
                .addPackage(NoticiaDTO.class.getPackage())
                .addPackage(NoticiaConverter.class.getPackage())
                .addPackage(NoticiaEntity.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private INoticiaLogicService noticiaLogicService;
	
	@Inject
	private INoticiaPersistence noticiaPersistence;	

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
		List<NoticiaDTO> dtos=noticiaPersistence.getNoticias();
		for(NoticiaDTO dto:dtos){
			noticiaPersistence.deleteNoticia(dto.getId());
		}
	}

	private List<NoticiaDTO> data=new ArrayList<NoticiaDTO>();

	private void insertData() {
		for(int i=0;i<3;i++){
			NoticiaDTO pdto=new NoticiaDTO();
			pdto.setName(generateRandom(String.class));
			pdto.setImagen(generateRandom(String.class));
			pdto.setTitulo(generateRandom(String.class));
			pdto.setFecha(generateRandomDate());
			pdto.setDescripcion(generateRandom(String.class));
			pdto.setTema(generateRandom(String.class));
			pdto=noticiaPersistence.createNoticia(pdto);
			data.add(pdto);
		}
	}
	
	@Test
	public void createNoticiaTest(){
		NoticiaDTO ldto=new NoticiaDTO();
		ldto.setName(generateRandom(String.class));
		ldto.setImagen(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setFecha(generateRandomDate());
		ldto.setDescripcion(generateRandom(String.class));
		ldto.setTema(generateRandom(String.class));
		
		
		NoticiaDTO result=noticiaLogicService.createNoticia(ldto);
		
		Assert.assertNotNull(result);
		
		NoticiaDTO pdto=noticiaPersistence.getNoticia(result.getId());
		
		Assert.assertEquals(ldto.getName(), pdto.getName());	
		Assert.assertEquals(ldto.getImagen(), pdto.getImagen());	
		Assert.assertEquals(ldto.getTitulo(), pdto.getTitulo());	
		Assert.assertEquals(ldto.getFecha(), pdto.getFecha());	
		Assert.assertEquals(ldto.getDescripcion(), pdto.getDescripcion());	
		Assert.assertEquals(ldto.getTema(), pdto.getTema());	
	}
	
	@Test
	public void getNoticiasTest(){
		List<NoticiaDTO> list=noticiaLogicService.getNoticias();
		Assert.assertEquals(list.size(), data.size());
        for(NoticiaDTO ldto:list){
        	boolean found=false;
            for(NoticiaDTO pdto:data){
            	if(ldto.getId()==pdto.getId()){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getNoticiaTest(){
		NoticiaDTO pdto=data.get(0);
		NoticiaDTO ldto=noticiaLogicService.getNoticia(pdto.getId());
        Assert.assertNotNull(ldto);
		Assert.assertEquals(pdto.getName(), ldto.getName());
		Assert.assertEquals(pdto.getImagen(), ldto.getImagen());
		Assert.assertEquals(pdto.getTitulo(), ldto.getTitulo());
		Assert.assertEquals(pdto.getFecha(), ldto.getFecha());
		Assert.assertEquals(pdto.getDescripcion(), ldto.getDescripcion());
		Assert.assertEquals(pdto.getTema(), ldto.getTema());
        
	}
	
	@Test
	public void deleteNoticiaTest(){
		NoticiaDTO pdto=data.get(0);
		noticiaLogicService.deleteNoticia(pdto.getId());
        NoticiaDTO deleted=noticiaPersistence.getNoticia(pdto.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateNoticiaTest(){
		NoticiaDTO pdto=data.get(0);
		
		NoticiaDTO ldto=new NoticiaDTO();
		ldto.setId(pdto.getId());
		ldto.setName(generateRandom(String.class));
		ldto.setImagen(generateRandom(String.class));
		ldto.setTitulo(generateRandom(String.class));
		ldto.setFecha(generateRandomDate());
		ldto.setDescripcion(generateRandom(String.class));
		ldto.setTema(generateRandom(String.class));
		
		
		noticiaLogicService.updateNoticia(ldto);
		
		
		NoticiaDTO resp=noticiaPersistence.getNoticia(pdto.getId());
		
		Assert.assertEquals(ldto.getName(), resp.getName());	
		Assert.assertEquals(ldto.getImagen(), resp.getImagen());	
		Assert.assertEquals(ldto.getTitulo(), resp.getTitulo());	
		Assert.assertEquals(ldto.getFecha(), resp.getFecha());	
		Assert.assertEquals(ldto.getDescripcion(), resp.getDescripcion());	
		Assert.assertEquals(ldto.getTema(), resp.getTema());	
	}
	
	
	
	
}