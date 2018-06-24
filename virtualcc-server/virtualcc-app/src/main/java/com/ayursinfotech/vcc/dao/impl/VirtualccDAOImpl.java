//CHECKSTYLE:OFF
package com.ayursinfotech.vcc.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayursinfotech.vcc.dao.VirtualccDAO;
import com.ayursinfotech.vcc.mongo.entity.Address;
import com.ayursinfotech.vcc.mongo.entity.Person;
import com.ayursinfotech.vcc.mongo.repository.AddressRepo;
import com.ayursinfotech.vcc.mongo.repository.PersonRepo;

@Repository
public class VirtualccDAOImpl implements VirtualccDAO {

	private static final Logger LOGGER = Logger.getLogger(VirtualccDAOImpl.class);

	@Autowired
	private PersonRepo personRepo;

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public Boolean ping() throws Exception {
		LOGGER.info("start Executing ping");
		Boolean result = true;

		// AddressRepo addressRepo = context.getBean(AddressRepo.class);
		Person personAchilles = new Person();
		personAchilles.setPersonId(1l);
		personAchilles.setName("Achilles");
		personRepo.save(personAchilles);
		Person personHektor = new Person();
		personHektor.setPersonId(2l);
		personHektor.setName("Hektor");
		Address address = new Address(1, "221b Baker Street", "London NW1", "London", 12345l);
		List<Address> addresses = personHektor.getAddresses();
		addresses.add(address);
		personAchilles.setAddresses(addresses);
		addressRepo.save(address);
		personRepo.save(personHektor);
		Iterable<Person> personList = personRepo.findAll();
		System.out.println("Person List : ");
		for (Person person : personList) {
			System.out.println(person);
		}
		/*
		 * System.out.println("Person Record with name Hektor is " +
		 * personRepo.searchByName("Hektor"));
		 */
		LOGGER.info("end executing ping");
		return result;
	}

}
