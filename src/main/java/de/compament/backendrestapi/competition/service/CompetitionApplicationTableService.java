package de.compament.backendrestapi.competition.service;

import de.compament.backendrestapi.competition.dto.CompetitionTableRowDto;
import de.compament.backendrestapi.competition.material.Competition;
import de.compament.backendrestapi.competition.repository.CompetitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompetitionApplicationTableService {
    CompetitionRepository competitionRepository;

    public CompetitionTableRowDto getCompetitionTableDto() {
        List<Competition> competitionList = competitionRepository.findAll();

        return new CompetitionTableRowDto();
    }

    private CompetitionTableRowDto mapCompetitionToCompetitionTableRowDto(Competition competition) {
        CompetitionTableRowDto competitionTableRowDto = new CompetitionTableRowDto();
        competitionTableRowDto.setId(competition.getId());
        competitionTableRowDto.setName(competitionTableRowDto.getName());
        competitionTableRowDto.setMeetingDate(competitionTableRowDto.getMeetingDate());
        competitionTableRowDto.setTeamSlots(competition.getTeamSlots());
        competitionTableRowDto.setJoinedTeams(competition.getTeamList().size());
        competitionTableRowDto.setLeagueOnly(competitionTableRowDto.isLeagueOnly());
        competitionTableRowDto.setMatchesInGroupsNumber(competition.getMatchesInGroupsNumber());
        competitionTableRowDto.setMatchesInKoNumber(competition.getMatchesInKoNumber());

        return competitionTableRowDto;
    }
}
