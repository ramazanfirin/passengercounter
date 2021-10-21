package com.masterteknoloji.net.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.masterteknoloji.net.domain.Bus;

import com.masterteknoloji.net.repository.BusRepository;
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
 * REST controller for managing Bus.
 */
@RestController
@RequestMapping("/api")
public class BusResource {

    private final Logger log = LoggerFactory.getLogger(BusResource.class);

    private static final String ENTITY_NAME = "bus";

    private final BusRepository busRepository;

    public BusResource(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    /**
     * POST  /buses : Create a new bus.
     *
     * @param bus the bus to create
     * @return the ResponseEntity with status 201 (Created) and with body the new bus, or with status 400 (Bad Request) if the bus has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/buses")
    @Timed
    public ResponseEntity<Bus> createBus(@RequestBody Bus bus) throws URISyntaxException {
        log.debug("REST request to save Bus : {}", bus);
        if (bus.getId() != null) {
            throw new BadRequestAlertException("A new bus cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Bus result = busRepository.save(bus);
        return ResponseEntity.created(new URI("/api/buses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /buses : Updates an existing bus.
     *
     * @param bus the bus to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated bus,
     * or with status 400 (Bad Request) if the bus is not valid,
     * or with status 500 (Internal Server Error) if the bus couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/buses")
    @Timed
    public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) throws URISyntaxException {
        log.debug("REST request to update Bus : {}", bus);
        if (bus.getId() == null) {
            return createBus(bus);
        }
        Bus result = busRepository.save(bus);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, bus.getId().toString()))
            .body(result);
    }

    /**
     * GET  /buses : get all the buses.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of buses in body
     */
    @GetMapping("/buses")
    @Timed
    public ResponseEntity<List<Bus>> getAllBuses(Pageable pageable) {
        log.debug("REST request to get a page of Buses");
        Page<Bus> page = busRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/buses");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /buses/:id : get the "id" bus.
     *
     * @param id the id of the bus to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the bus, or with status 404 (Not Found)
     */
    @GetMapping("/buses/{id}")
    @Timed
    public ResponseEntity<Bus> getBus(@PathVariable Long id) {
        log.debug("REST request to get Bus : {}", id);
        Bus bus = busRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(bus));
    }

    /**
     * DELETE  /buses/:id : delete the "id" bus.
     *
     * @param id the id of the bus to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/buses/{id}")
    @Timed
    public ResponseEntity<Void> deleteBus(@PathVariable Long id) {
        log.debug("REST request to delete Bus : {}", id);
        busRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
