package com.masterteknoloji.net.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.masterteknoloji.net.domain.StationRouteConnection;

import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
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
 * REST controller for managing StationRouteConnection.
 */
@RestController
@RequestMapping("/api")
public class StationRouteConnectionResource {

    private final Logger log = LoggerFactory.getLogger(StationRouteConnectionResource.class);

    private static final String ENTITY_NAME = "stationRouteConnection";

    private final StationRouteConnectionRepository stationRouteConnectionRepository;

    public StationRouteConnectionResource(StationRouteConnectionRepository stationRouteConnectionRepository) {
        this.stationRouteConnectionRepository = stationRouteConnectionRepository;
    }

    /**
     * POST  /station-route-connections : Create a new stationRouteConnection.
     *
     * @param stationRouteConnection the stationRouteConnection to create
     * @return the ResponseEntity with status 201 (Created) and with body the new stationRouteConnection, or with status 400 (Bad Request) if the stationRouteConnection has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/station-route-connections")
    @Timed
    public ResponseEntity<StationRouteConnection> createStationRouteConnection(@RequestBody StationRouteConnection stationRouteConnection) throws URISyntaxException {
        log.debug("REST request to save StationRouteConnection : {}", stationRouteConnection);
        if (stationRouteConnection.getId() != null) {
            throw new BadRequestAlertException("A new stationRouteConnection cannot already have an ID", ENTITY_NAME, "idexists");
        }
        StationRouteConnection result = stationRouteConnectionRepository.save(stationRouteConnection);
        return ResponseEntity.created(new URI("/api/station-route-connections/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /station-route-connections : Updates an existing stationRouteConnection.
     *
     * @param stationRouteConnection the stationRouteConnection to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated stationRouteConnection,
     * or with status 400 (Bad Request) if the stationRouteConnection is not valid,
     * or with status 500 (Internal Server Error) if the stationRouteConnection couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/station-route-connections")
    @Timed
    public ResponseEntity<StationRouteConnection> updateStationRouteConnection(@RequestBody StationRouteConnection stationRouteConnection) throws URISyntaxException {
        log.debug("REST request to update StationRouteConnection : {}", stationRouteConnection);
        if (stationRouteConnection.getId() == null) {
            return createStationRouteConnection(stationRouteConnection);
        }
        StationRouteConnection result = stationRouteConnectionRepository.save(stationRouteConnection);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, stationRouteConnection.getId().toString()))
            .body(result);
    }

    /**
     * GET  /station-route-connections : get all the stationRouteConnections.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of stationRouteConnections in body
     */
    @GetMapping("/station-route-connections")
    @Timed
    public ResponseEntity<List<StationRouteConnection>> getAllStationRouteConnections(Pageable pageable) {
        log.debug("REST request to get a page of StationRouteConnections");
        Page<StationRouteConnection> page = stationRouteConnectionRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/station-route-connections");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /station-route-connections/:id : get the "id" stationRouteConnection.
     *
     * @param id the id of the stationRouteConnection to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the stationRouteConnection, or with status 404 (Not Found)
     */
    @GetMapping("/station-route-connections/{id}")
    @Timed
    public ResponseEntity<StationRouteConnection> getStationRouteConnection(@PathVariable Long id) {
        log.debug("REST request to get StationRouteConnection : {}", id);
        StationRouteConnection stationRouteConnection = stationRouteConnectionRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(stationRouteConnection));
    }

    /**
     * DELETE  /station-route-connections/:id : delete the "id" stationRouteConnection.
     *
     * @param id the id of the stationRouteConnection to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/station-route-connections/{id}")
    @Timed
    public ResponseEntity<Void> deleteStationRouteConnection(@PathVariable Long id) {
        log.debug("REST request to delete StationRouteConnection : {}", id);
        stationRouteConnectionRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
