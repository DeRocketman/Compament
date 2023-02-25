package de.compament.backendrestapi.competition.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "competition_match")
public class CompetitionMatch {
    @Id
    String id;
    @DBRef
    Team homeTeam;
    @DBRef
    Team guestTeam;
    int goalsHomeTeam;
    int goalsGuestTeam;
    MatchType matchType;

}
