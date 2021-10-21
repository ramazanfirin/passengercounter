package com.masterteknoloji.net.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.masterteknoloji.net.domain.ScheduledVoyage;

import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
import com.masterteknoloji.net.web.rest.errors.BadRequestAlertException;
import com.masterteknoloji.net.web.rest.util.HeaderUtil;
import com.masterteknoloji.net.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing ScheduledVoyage.
 */
@RestController
@RequestMapping("/api")
public class ScheduledVoyageResource {

    private final Logger log = LoggerFactory.getLogger(ScheduledVoyageResource.class);

    private static final String ENTITY_NAME = "scheduledVoyage";

    private final ScheduledVoyageRepository scheduledVoyageRepository;

    public ScheduledVoyageResource(ScheduledVoyageRepository scheduledVoyageRepository) {
        this.scheduledVoyageRepository = scheduledVoyageRepository;
    }

    /**
     * POST  /scheduled-voyages : Create a new scheduledVoyage.
     *
     * @param scheduledVoyage the scheduledVoyage to create
     * @return the ResponseEntity with status 201 (Created) and with body the new scheduledVoyage, or with status 400 (Bad Request) if the scheduledVoyage has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/scheduled-voyages")
    @Timed
    public ResponseEntity<ScheduledVoyage> createScheduledVoyage(@RequestBody ScheduledVoyage scheduledVoyage) throws URISyntaxException {
        log.debug("REST request to save ScheduledVoyage : {}", scheduledVoyage);
        if (scheduledVoyage.getId() != null) {
            throw new BadRequestAlertException("A new scheduledVoyage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ScheduledVoyage result = scheduledVoyageRepository.save(scheduledVoyage);
        return ResponseEntity.created(new URI("/api/scheduled-voyages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /scheduled-voyages : Updates an existing scheduledVoyage.
     *
     * @param scheduledVoyage the scheduledVoyage to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated scheduledVoyage,
     * or with status 400 (Bad Request) if the scheduledVoyage is not valid,
     * or with status 500 (Internal Server Error) if the scheduledVoyage couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/scheduled-voyages")
    @Timed
    public ResponseEntity<ScheduledVoyage> updateScheduledVoyage(@RequestBody ScheduledVoyage scheduledVoyage) throws URISyntaxException {
        log.debug("REST request to update ScheduledVoyage : {}", scheduledVoyage);
        if (scheduledVoyage.getId() == null) {
            return createScheduledVoyage(scheduledVoyage);
        }
        ScheduledVoyage result = scheduledVoyageRepository.save(scheduledVoyage);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, scheduledVoyage.getId().toString()))
            .body(result);
    }

    /**
     * GET  /scheduled-voyages : get all the scheduledVoyages.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of scheduledVoyages in body
     */
    @GetMapping("/scheduled-voyages")
    @Timed
    public ResponseEntity<List<ScheduledVoyage>> getAllScheduledVoyages(Pageable pageable) {
        log.debug("REST request to get a page of ScheduledVoyages");
        Page<ScheduledVoyage> page = scheduledVoyageRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/scheduled-voyages");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /scheduled-voyages/:id : get the "id" scheduledVoyage.
     *
     * @param id the id of the scheduledVoyage to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the scheduledVoyage, or with status 404 (Not Found)
     */
    @GetMapping("/scheduled-voyages/{id}")
    @Timed
    public ResponseEntity<ScheduledVoyage> getScheduledVoyage(@PathVariable Long id) {
        log.debug("REST request to get ScheduledVoyage : {}", id);
        ScheduledVoyage scheduledVoyage = scheduledVoyageRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(scheduledVoyage));
    }

    /**
     * DELETE  /scheduled-voyages/:id : delete the "id" scheduledVoyage.
     *
     * @param id the id of the scheduledVoyage to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/scheduled-voyages/{id}")
    @Timed
    public ResponseEntity<Void> deleteScheduledVoyage(@PathVariable Long id) {
        log.debug("REST request to delete ScheduledVoyage : {}", id);
        scheduledVoyageRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
