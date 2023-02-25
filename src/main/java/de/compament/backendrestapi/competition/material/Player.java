package de.compament.backendrestapi.competition.material;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "player")
public class Player {
    @Id
    String id;
    String firstName;
    String lastName;
    String alias;
    boolean isCaptain;
    boolean isForward;
    boolean isBackward;
}
