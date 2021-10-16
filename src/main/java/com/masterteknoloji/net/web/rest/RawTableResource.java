package com.masterteknoloji.net.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.masterteknoloji.net.domain.RawTable;

import com.masterteknoloji.net.repository.RawTableRepository;
import com.masterteknoloji.net.web.rest.errors.BadRequestAlertException;
import com.masterteknoloji.net.web.rest.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing RawTable.
 */
@RestController
@RequestMapping("/api")
public class RawTableResource {

    private final Logger log = LoggerFactory.getLogger(RawTableResource.class);

    private static final String ENTITY_NAME = "rawTable";

    private final RawTableRepository rawTableRepository;

    public RawTableResource(RawTableRepository rawTableRepository) {
        this.rawTableRepository = rawTableRepository;
    }

    /**
     * POST  /raw-tables : Create a new rawTable.
     *
     * @param rawTable the rawTable to create
     * @return the ResponseEntity with status 201 (Created) and with body the new rawTable, or with status 400 (Bad Request) if the rawTable has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/raw-tables")
    @Timed
    public ResponseEntity<RawTable> createRawTable(@RequestBody RawTable rawTable) throws URISyntaxException {
        log.debug("REST request to save RawTable : {}", rawTable);
        if (rawTable.getId() != null) {
            throw new BadRequestAlertException("A new rawTable cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RawTable result = rawTableRepository.save(rawTable);
        return ResponseEntity.created(new URI("/api/raw-tables/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /raw-tables : Updates an existing rawTable.
     *
     * @param rawTable the rawTable to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated rawTable,
     * or with status 400 (Bad Request) if the rawTable is not valid,
     * or with status 500 (Internal Server Error) if the rawTable couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/raw-tables")
    @Timed
    public ResponseEntity<RawTable> updateRawTable(@RequestBody RawTable rawTable) throws URISyntaxException {
        log.debug("REST request to update RawTable : {}", rawTable);
        if (rawTable.getId() == null) {
            return createRawTable(rawTable);
        }
        RawTable result = rawTableRepository.save(rawTable);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, rawTable.getId().toString()))
            .body(result);
    }

    /**
     * GET  /raw-tables : get all the rawTables.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of rawTables in body
     */
    @GetMapping("/raw-tables")
    @Timed
    public List<RawTable> getAllRawTables() {
        log.debug("REST request to get all RawTables");
        return rawTableRepository.findAll();
        }

    /**
     * GET  /raw-tables/:id : get the "id" rawTable.
     *
     * @param id the id of the rawTable to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the rawTable, or with status 404 (Not Found)
     */
    @GetMapping("/raw-tables/{id}")
    @Timed
    public ResponseEntity<RawTable> getRawTable(@PathVariable Long id) {
        log.debug("REST request to get RawTable : {}", id);
        RawTable rawTable = rawTableRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(rawTable));
    }

    /**
     * DELETE  /raw-tables/:id : delete the "id" rawTable.
     *
     * @param id the id of the rawTable to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/raw-tables/{id}")
    @Timed
    public ResponseEntity<Void> deleteRawTable(@PathVariable Long id) {
        log.debug("REST request to delete RawTable : {}", id);
        rawTableRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
