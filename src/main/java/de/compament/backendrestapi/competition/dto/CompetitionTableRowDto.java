package de.compament.backendrestapi.competition.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionTableRowDto {
    String id;
    String name;
    String meetingDate;
    int teamSlots;
    int joinedTeams;
    boolean leagueOnly;
    int matchesInGroupsNumber;
    int matchesInKoNumber;
}
