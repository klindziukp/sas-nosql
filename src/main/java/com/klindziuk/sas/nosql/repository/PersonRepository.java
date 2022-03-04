//package com.klindziuk.sas.nosql.repository;
//
//import com.klindziuk.sas.nosql.model.Movie;
//import com.klindziuk.sas.nosql.model.Person;
//import java.util.List;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//import org.springframework.data.neo4j.repository.query.Query;
//
//public interface PersonRepository extends Neo4jRepository<Person, Long> {
//
//    Person getPersonByName(String name);
//
//    Iterable<Person> findPersonByNameLike(String name);
//
//@Query("MATCH (am:Movie)<-[ai:ACTED_IN]-(p:Person)-[d:DIRECTED]->(dm:Movie) return p, collect(ai), collect(d), collect(am), collect(dm)")
//List<Person> getPersonsWhoActAndDirect();
//
//}
