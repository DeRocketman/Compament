package de.compament.backendrestapi.competition.material;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "team")
public class Team {
    @Id
    String id;
    String name;
    int playerCount;
    @DBRef
    Player teamCaptain;
    @DBRef
    List<Player> squadList = new ArrayList<>();


}
