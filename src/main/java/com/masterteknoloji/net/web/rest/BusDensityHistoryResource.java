package com.masterteknoloji.net.web.rest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.masterteknoloji.net.domain.BusDensityHistory;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.service.DensityCalculaterService;
import com.masterteknoloji.net.service.IntegrationService;
import com.masterteknoloji.net.web.rest.errors.BadRequestAlertException;
import com.masterteknoloji.net.web.rest.util.HeaderUtil;
import com.masterteknoloji.net.web.rest.util.PaginationUtil;

import io.github.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing BusDensityHistory.
 */
@RestController
@RequestMapping("/api")
public class BusDensityHistoryResource {

    private final Logger log = LoggerFactory.getLogger(BusDensityHistoryResource.class);

    private static final String ENTITY_NAME = "busDensityHistory";

    private final BusDensityHistoryRepository busDensityHistoryRepository;
    
    private final StationRepository stationRepository;
    
    private final DensityCalculaterService densityCalculaterService;
    
    private final IntegrationService integrationService;

    public BusDensityHistoryResource(BusDensityHistoryRepository busDensityHistoryRepository, StationRepository stationRepository, DensityCalculaterService densityCalculaterService,IntegrationService integrationService) {
        this.busDensityHistoryRepository = busDensityHistoryRepository;
        this.stationRepository = stationRepository;
        this.densityCalculaterService = densityCalculaterService;
        this.integrationService = integrationService;
    }

    /**
     * POST  /bus-density-histories : Create a new busDensityHistory.
     *
     * @param busDensityHistory the busDensityHistory to create
     * @return the ResponseEntity with status 201 (Created) and with body the new busDensityHistory, or with status 400 (Bad Request) if the busDensityHistory has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/bus-density-histories")
    @Timed
    public ResponseEntity<BusDensityHistory> createBusDensityHistory(@RequestBody BusDensityHistory busDensityHistory) throws URISyntaxException {
        log.debug("REST request to save BusDensityHistory : {}", busDensityHistory);
        if (busDensityHistory.getId() != null) {
            throw new BadRequestAlertException("A new busDensityHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BusDensityHistory result = busDensityHistoryRepository.save(busDensityHistory);
        return ResponseEntity.created(new URI("/api/bus-density-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /bus-density-histories : Updates an existing busDensityHistory.
     *
     * @param busDensityHistory the busDensityHistory to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated busDensityHistory,
     * or with status 400 (Bad Request) if the busDensityHistory is not valid,
     * or with status 500 (Internal Server Error) if the busDensityHistory couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/bus-density-histories")
    @Timed
    public ResponseEntity<BusDensityHistory> updateBusDensityHistory(@RequestBody BusDensityHistory busDensityHistory) throws URISyntaxException {
        log.debug("REST request to update BusDensityHistory : {}", busDensityHistory);
        if (busDensityHistory.getId() == null) {
            return createBusDensityHistory(busDensityHistory);
        }
        BusDensityHistory result = busDensityHistoryRepository.save(busDensityHistory);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, busDensityHistory.getId().toString()))
            .body(result);
    }

    /**
     * GET  /bus-density-histories : get all the busDensityHistories.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of busDensityHistories in body
     */
    @GetMapping("/bus-density-histories")
    @Timed
    public ResponseEntity<List<BusDensityHistory>> getAllBusDensityHistories(@PageableDefault(page = 0, size = 500) Pageable pageable) {
        log.debug("REST request to get a page of BusDensityHistories");
        Pageable pageable2 = new PageRequest(0, 2000);
        Page<BusDensityHistory> page = busDensityHistoryRepository.findAll(pageable2);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/bus-density-histories");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /bus-density-histories/:id : get the "id" busDensityHistory.
     *
     * @param id the id of the busDensityHistory to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the busDensityHistory, or with status 404 (Not Found)
     */
    @GetMapping("/bus-density-histories/{id}")
    @Timed
    public ResponseEntity<BusDensityHistory> getBusDensityHistory(@PathVariable Long id) {
        log.debug("REST request to get BusDensityHistory : {}", id);
        BusDensityHistory busDensityHistory = busDensityHistoryRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(busDensityHistory));
    }

    /**
     * DELETE  /bus-density-histories/:id : delete the "id" busDensityHistory.
     *
     * @param id the id of the busDensityHistory to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/bus-density-histories/{id}")
    @Timed
    public ResponseEntity<Void> deleteBusDensityHistory(@PathVariable Long id) {
        log.debug("REST request to delete BusDensityHistory : {}", id);
        busDensityHistoryRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
    
    @GetMapping("/bus-density-histories/analyze")
    @Timed
    public void analyze(HttpServletRequest httpServletRequest) {
    	String tempStationId = httpServletRequest.getParameter("tempStationId");
    	Station tempStation = stationRepository.findByStationId(new Long(tempStationId));
    	densityCalculaterService.setTempStation(tempStation);
    	densityCalculaterService.calculateDensity();
    	System.out.println("");
    }
    

    @GetMapping("/bus-density-histories/migrateData")
    @Timed
    public void migrateData(HttpServletRequest httpServletRequest) throws JsonProcessingException, IOException {
    	integrationService.getRouteListFromMersin();
    }
    
    @GetMapping("/bus-density-histories/migrateStation")
    @Timed
    public void migrateStation(HttpServletRequest httpServletRequest) throws JsonProcessingException, IOException {
    	integrationService.getStationListFromMersin();
    }

}
