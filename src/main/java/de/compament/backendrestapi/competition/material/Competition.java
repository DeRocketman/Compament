package de.compament.backendrestapi.competition.material;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "competition")
public class Competition {
    @Id
    String id;
    String name;
    String meetingDate;
    int teamSlots;
    boolean leagueOnly;
    int matchesInGroupsNumber;
    int matchesInKoNumber;
    @DBRef
    List<CompetitionGroup> competitionGroupList = new ArrayList<>();
    @DBRef
    List<Team> teamList = new ArrayList<>();
    @DBRef
    List<CompetitionMatch> matchList = new ArrayList<>();
}
