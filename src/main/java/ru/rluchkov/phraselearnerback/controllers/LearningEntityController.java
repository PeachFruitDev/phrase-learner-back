package ru.rluchkov.phraselearnerback.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rluchkov.phraselearnerback.dto.LearningEntitiesTodayDto;
import ru.rluchkov.phraselearnerback.dto.LearningEntityDto;
import ru.rluchkov.phraselearnerback.services.LearningEntityService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class LearningEntityController {

    private final LearningEntityService learningEntityService;

    @PostMapping("/add")
    public void add(@RequestBody LearningEntityDto learningEntityDto) {
        learningEntityService.add(learningEntityDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        learningEntityService.delete(id);
    }

    @GetMapping("/today")
    public LearningEntitiesTodayDto today() {
        return learningEntityService.today();
    }

    @PutMapping("/{id}/review")
    public void review(@PathVariable UUID id) {
        // learningEntityService.review(id);
    }

    @GetMapping("/paginated-all")
    public Page<LearningEntityDto> paginatedAll(@RequestParam String searchingString, @RequestParam Integer page, @RequestParam Integer size) {
        return learningEntityService.paginatedAll(searchingString, page, size);
    }
}
