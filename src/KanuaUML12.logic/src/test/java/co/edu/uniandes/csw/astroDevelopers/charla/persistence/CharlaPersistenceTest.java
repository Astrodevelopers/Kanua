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

package co.edu.uniandes.csw.astroDevelopers.charla.persistence;

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


import co.edu.uniandes.csw.astroDevelopers.charla.logic.dto.CharlaDTO;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.api.ICharlaPersistence;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.entity.CharlaEntity;
import co.edu.uniandes.csw.astroDevelopers.charla.persistence.converter.CharlaConverter;
import static co.edu.uniandes.csw.astroDevelopers.util._TestUtil.*;

@RunWith(Arquillian.class)
public class CharlaPersistenceTest {

	public static final String DEPLOY = "Prueba";

	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
				.addPackage(CharlaPersistence.class.getPackage())
				.addPackage(CharlaEntity.class.getPackage())
				.addPackage(ICharlaPersistence.class.getPackage())
                .addPackage(CharlaDTO.class.getPackage())
                .addPackage(CharlaConverter.class.getPackage())
				.addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
	}

	@Inject
	private ICharlaPersistence charlaPersistence;

	@PersistenceContext
	private EntityManager em;

	@Inject
	UserTransaction utx;

	@Before
	public void configTest() {
		System.out.println("em: " + em);
		try {
			utx.begin();
			clearData();
			insertData();
			utx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				utx.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	private void clearData() {
		em.createQuery("delete from CharlaEntity").executeUpdate();
	}

	private List<CharlaEntity> data=new ArrayList<CharlaEntity>();

	private void insertData() {
		for(int i=0;i<3;i++){
			CharlaEntity entity=new CharlaEntity();
			entity.setName(generateRandom(String.class));
			entity.setTitulo(generateRandom(String.class));
			entity.setInformacion(generateRandom(String.class));
			entity.setLink(generateRandom(String.class));
			entity.setFechaEvento(generateRandom(Date.class));
			entity.setImagen(generateRandom(String.class));
			entity.setPublicacion(generateRandom(Date.class));
			em.persist(entity);
			data.add(entity);
		}
	}
	
	@Test
	public void createCharlaTest(){
		CharlaDTO dto=new CharlaDTO();
		dto.setName(generateRandom(String.class));
		dto.setTitulo(generateRandom(String.class));
		dto.setInformacion(generateRandom(String.class));
		dto.setLink(generateRandom(String.class));
dto.setFechaEvento(generateRandomDate());
		dto.setImagen(generateRandom(String.class));
dto.setPublicacion(generateRandomDate());
		
		CharlaDTO result=charlaPersistence.createCharla(dto);
		
		Assert.assertNotNull(result);
		
		CharlaEntity entity=em.find(CharlaEntity.class, result.getId());
		
		Assert.assertEquals(dto.getName(), entity.getName());
		Assert.assertEquals(dto.getTitulo(), entity.getTitulo());
		Assert.assertEquals(dto.getInformacion(), entity.getInformacion());
		Assert.assertEquals(dto.getLink(), entity.getLink());
Assert.assertEquals(parseDate(dto.getFechaEvento()), entity.getFechaEvento());	
		Assert.assertEquals(dto.getImagen(), entity.getImagen());
Assert.assertEquals(parseDate(dto.getPublicacion()), entity.getPublicacion());	
	}
	
	@Test
	public void getCharlasTest(){
		List<CharlaDTO> list=charlaPersistence.getCharlas();
		Assert.assertEquals(list.size(), data.size());
        for(CharlaDTO dto:list){
        	boolean found=false;
            for(CharlaEntity entity:data){
            	if(dto.getId().equals(entity.getId())){
                	found=true;
                }
            }
            Assert.assertTrue(found);
        }
	}
	
	@Test
	public void getCharlaTest(){
		CharlaEntity entity=data.get(0);
		CharlaDTO dto=charlaPersistence.getCharla(entity.getId());
        Assert.assertNotNull(dto);
		Assert.assertEquals(entity.getName(), dto.getName());
		Assert.assertEquals(entity.getTitulo(), dto.getTitulo());
		Assert.assertEquals(entity.getInformacion(), dto.getInformacion());
		Assert.assertEquals(entity.getLink(), dto.getLink());
		Assert.assertEquals(entity.getImagen(), dto.getImagen());
        
	}
	
	@Test
	public void deleteCharlaTest(){
		CharlaEntity entity=data.get(0);
		charlaPersistence.deleteCharla(entity.getId());
        CharlaEntity deleted=em.find(CharlaEntity.class, entity.getId());
        Assert.assertNull(deleted);
	}
	
	@Test
	public void updateCharlaTest(){
		CharlaEntity entity=data.get(0);
		
		CharlaDTO dto=new CharlaDTO();
		dto.setId(entity.getId());
		dto.setName(generateRandom(String.class));
		dto.setTitulo(generateRandom(String.class));
		dto.setInformacion(generateRandom(String.class));
		dto.setLink(generateRandom(String.class));
dto.setFechaEvento(generateRandomDate());
		dto.setImagen(generateRandom(String.class));
dto.setPublicacion(generateRandomDate());
		
		
		charlaPersistence.updateCharla(dto);
		
		
		CharlaEntity resp=em.find(CharlaEntity.class, entity.getId());
		
		Assert.assertEquals(dto.getName(), resp.getName());	
		Assert.assertEquals(dto.getTitulo(), resp.getTitulo());	
		Assert.assertEquals(dto.getInformacion(), resp.getInformacion());	
		Assert.assertEquals(dto.getLink(), resp.getLink());	
Assert.assertEquals(parseDate(dto.getFechaEvento()), resp.getFechaEvento());
		Assert.assertEquals(dto.getImagen(), resp.getImagen());	
Assert.assertEquals(parseDate(dto.getPublicacion()), resp.getPublicacion());
	}
	
	
	
}