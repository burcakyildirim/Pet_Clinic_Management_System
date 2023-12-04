package dev.patika.clinic.api;

import dev.patika.clinic.business.abstracts.IAvailableDateService;
import dev.patika.clinic.dto.AvailableDateRespond;
import dev.patika.clinic.dto.AvailableDateSaveRequest;
import dev.patika.clinic.dto.AvailableDateUpdateRequest;
import dev.patika.clinic.entities.AvailableDate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class AvailableDateController {

    @Autowired
    private final IAvailableDateService availableDateService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public AvailableDateController(IAvailableDateService availableDateService) {
        this.availableDateService = availableDateService;
    }

    @GetMapping("/availabledates")
    @ResponseStatus(HttpStatus.OK)
    public List<AvailableDateRespond> findAll() {
        List<AvailableDateRespond> availableDateRespondList = this.availableDateService.findAll().stream().map(
                availableDate -> this.modelMapper.map(availableDate,AvailableDateRespond.class)
        ).collect(Collectors.toList());
        return availableDateRespondList;
    }

    @PostMapping("/availabledates")
    @ResponseStatus(HttpStatus.CREATED)
    public AvailableDate save(@RequestBody AvailableDateSaveRequest availableDateSaveRequest) {
        AvailableDate newAvailableDate = this.modelMapper.map(availableDateSaveRequest,AvailableDate.class);
        return this.availableDateService.save(newAvailableDate);
    }

    @PutMapping("/availabledates")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate update(@RequestBody AvailableDateUpdateRequest availableDateUpdateRequest) {
        AvailableDate updatedAvailableDate = this.availableDateService.getById(availableDateUpdateRequest.getId());
        updatedAvailableDate.setDate(availableDateUpdateRequest.getDate());
        return this.availableDateService.update(updatedAvailableDate);
    }

    @DeleteMapping("/availabledates/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.availableDateService.delete(id);
    }

    @GetMapping("/availabledates/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AvailableDate getById(@PathVariable("id") Long id) {
        return this.availableDateService.getById(id);
    }
}
