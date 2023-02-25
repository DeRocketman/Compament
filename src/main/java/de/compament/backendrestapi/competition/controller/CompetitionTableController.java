package de.compament.backendrestapi.competition.controller;

import de.compament.backendrestapi.competition.dto.CompetitionTableRowDto;
import de.compament.backendrestapi.competition.service.CompetitionApplicationTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competition/table")
public class CompetitionTableController {

    CompetitionApplicationTableService service;
    @GetMapping("")
    public ResponseEntity<CompetitionTableRowDto> getCompetitionTableDto() {
        return ResponseEntity.ok(service.getCompetitionTableDto());
    }
}
