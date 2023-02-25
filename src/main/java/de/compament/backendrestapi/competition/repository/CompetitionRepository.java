package de.compament.backendrestapi.competition.repository;

import de.compament.backendrestapi.competition.material.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
