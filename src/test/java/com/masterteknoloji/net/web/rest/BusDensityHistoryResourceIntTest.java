package com.masterteknoloji.net.web.rest;

import com.masterteknoloji.net.Passengercounter2App;

import com.masterteknoloji.net.domain.BusDensityHistory;
import com.masterteknoloji.net.repository.BusDensityHistoryRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.service.DensityCalculaterService;
import com.masterteknoloji.net.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.masterteknoloji.net.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the BusDensityHistoryResource REST controller.
 *
 * @see BusDensityHistoryResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class BusDensityHistoryResourceIntTest {

    private static final Instant DEFAULT_RECORD_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_RECORD_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Long DEFAULT_TOTAL_PASSENGER_COUNT = 1L;
    private static final Long UPDATED_TOTAL_PASSENGER_COUNT = 2L;

    private static final Long DEFAULT_GET_IN_PASSENGER_COUNT = 1L;
    private static final Long UPDATED_GET_IN_PASSENGER_COUNT = 2L;

    private static final Long DEFAULT_GET_OUT_PASSENGER_COUNT = 1L;
    private static final Long UPDATED_GET_OUT_PASSENGER_COUNT = 2L;

    private static final Long DEFAULT_DENSITY = 1L;
    private static final Long UPDATED_DENSITY = 2L;

    @Autowired
    private BusDensityHistoryRepository busDensityHistoryRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;
    
    @Autowired
    private StationRepository stationRepository;
    
    @Autowired
    private DensityCalculaterService densityCalculaterService;

    @Autowired
    private EntityManager em;

    private MockMvc restBusDensityHistoryMockMvc;

    private BusDensityHistory busDensityHistory;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BusDensityHistoryResource busDensityHistoryResource = new BusDensityHistoryResource(busDensityHistoryRepository, stationRepository, densityCalculaterService);
        this.restBusDensityHistoryMockMvc = MockMvcBuilders.standaloneSetup(busDensityHistoryResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static BusDensityHistory createEntity(EntityManager em) {
        BusDensityHistory busDensityHistory = new BusDensityHistory()
            .recordDate(DEFAULT_RECORD_DATE)
            .totalPassengerCount(DEFAULT_TOTAL_PASSENGER_COUNT)
            .getInPassengerCount(DEFAULT_GET_IN_PASSENGER_COUNT)
            .getOutPassengerCount(DEFAULT_GET_OUT_PASSENGER_COUNT)
            .density(DEFAULT_DENSITY);
        return busDensityHistory;
    }

    @Before
    public void initTest() {
        busDensityHistory = createEntity(em);
    }

    @Test
    @Transactional
    public void createBusDensityHistory() throws Exception {
        int databaseSizeBeforeCreate = busDensityHistoryRepository.findAll().size();

        // Create the BusDensityHistory
        restBusDensityHistoryMockMvc.perform(post("/api/bus-density-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(busDensityHistory)))
            .andExpect(status().isCreated());

        // Validate the BusDensityHistory in the database
        List<BusDensityHistory> busDensityHistoryList = busDensityHistoryRepository.findAll();
        assertThat(busDensityHistoryList).hasSize(databaseSizeBeforeCreate + 1);
        BusDensityHistory testBusDensityHistory = busDensityHistoryList.get(busDensityHistoryList.size() - 1);
        assertThat(testBusDensityHistory.getRecordDate()).isEqualTo(DEFAULT_RECORD_DATE);
        assertThat(testBusDensityHistory.getTotalPassengerCount()).isEqualTo(DEFAULT_TOTAL_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getGetInPassengerCount()).isEqualTo(DEFAULT_GET_IN_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getGetOutPassengerCount()).isEqualTo(DEFAULT_GET_OUT_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getDensity()).isEqualTo(DEFAULT_DENSITY);
    }

    @Test
    @Transactional
    public void createBusDensityHistoryWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = busDensityHistoryRepository.findAll().size();

        // Create the BusDensityHistory with an existing ID
        busDensityHistory.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBusDensityHistoryMockMvc.perform(post("/api/bus-density-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(busDensityHistory)))
            .andExpect(status().isBadRequest());

        // Validate the BusDensityHistory in the database
        List<BusDensityHistory> busDensityHistoryList = busDensityHistoryRepository.findAll();
        assertThat(busDensityHistoryList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBusDensityHistories() throws Exception {
        // Initialize the database
        busDensityHistoryRepository.saveAndFlush(busDensityHistory);

        // Get all the busDensityHistoryList
        restBusDensityHistoryMockMvc.perform(get("/api/bus-density-histories?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(busDensityHistory.getId().intValue())))
            .andExpect(jsonPath("$.[*].recordDate").value(hasItem(DEFAULT_RECORD_DATE.toString())))
            .andExpect(jsonPath("$.[*].totalPassengerCount").value(hasItem(DEFAULT_TOTAL_PASSENGER_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].getInPassengerCount").value(hasItem(DEFAULT_GET_IN_PASSENGER_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].getOutPassengerCount").value(hasItem(DEFAULT_GET_OUT_PASSENGER_COUNT.intValue())))
            .andExpect(jsonPath("$.[*].density").value(hasItem(DEFAULT_DENSITY.intValue())));
    }

    @Test
    @Transactional
    public void getBusDensityHistory() throws Exception {
        // Initialize the database
        busDensityHistoryRepository.saveAndFlush(busDensityHistory);

        // Get the busDensityHistory
        restBusDensityHistoryMockMvc.perform(get("/api/bus-density-histories/{id}", busDensityHistory.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(busDensityHistory.getId().intValue()))
            .andExpect(jsonPath("$.recordDate").value(DEFAULT_RECORD_DATE.toString()))
            .andExpect(jsonPath("$.totalPassengerCount").value(DEFAULT_TOTAL_PASSENGER_COUNT.intValue()))
            .andExpect(jsonPath("$.getInPassengerCount").value(DEFAULT_GET_IN_PASSENGER_COUNT.intValue()))
            .andExpect(jsonPath("$.getOutPassengerCount").value(DEFAULT_GET_OUT_PASSENGER_COUNT.intValue()))
            .andExpect(jsonPath("$.density").value(DEFAULT_DENSITY.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingBusDensityHistory() throws Exception {
        // Get the busDensityHistory
        restBusDensityHistoryMockMvc.perform(get("/api/bus-density-histories/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBusDensityHistory() throws Exception {
        // Initialize the database
        busDensityHistoryRepository.saveAndFlush(busDensityHistory);
        int databaseSizeBeforeUpdate = busDensityHistoryRepository.findAll().size();

        // Update the busDensityHistory
        BusDensityHistory updatedBusDensityHistory = busDensityHistoryRepository.findOne(busDensityHistory.getId());
        // Disconnect from session so that the updates on updatedBusDensityHistory are not directly saved in db
        em.detach(updatedBusDensityHistory);
        updatedBusDensityHistory
            .recordDate(UPDATED_RECORD_DATE)
            .totalPassengerCount(UPDATED_TOTAL_PASSENGER_COUNT)
            .getInPassengerCount(UPDATED_GET_IN_PASSENGER_COUNT)
            .getOutPassengerCount(UPDATED_GET_OUT_PASSENGER_COUNT)
            .density(UPDATED_DENSITY);

        restBusDensityHistoryMockMvc.perform(put("/api/bus-density-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedBusDensityHistory)))
            .andExpect(status().isOk());

        // Validate the BusDensityHistory in the database
        List<BusDensityHistory> busDensityHistoryList = busDensityHistoryRepository.findAll();
        assertThat(busDensityHistoryList).hasSize(databaseSizeBeforeUpdate);
        BusDensityHistory testBusDensityHistory = busDensityHistoryList.get(busDensityHistoryList.size() - 1);
        assertThat(testBusDensityHistory.getRecordDate()).isEqualTo(UPDATED_RECORD_DATE);
        assertThat(testBusDensityHistory.getTotalPassengerCount()).isEqualTo(UPDATED_TOTAL_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getGetInPassengerCount()).isEqualTo(UPDATED_GET_IN_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getGetOutPassengerCount()).isEqualTo(UPDATED_GET_OUT_PASSENGER_COUNT);
        assertThat(testBusDensityHistory.getDensity()).isEqualTo(UPDATED_DENSITY);
    }

    @Test
    @Transactional
    public void updateNonExistingBusDensityHistory() throws Exception {
        int databaseSizeBeforeUpdate = busDensityHistoryRepository.findAll().size();

        // Create the BusDensityHistory

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restBusDensityHistoryMockMvc.perform(put("/api/bus-density-histories")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(busDensityHistory)))
            .andExpect(status().isCreated());

        // Validate the BusDensityHistory in the database
        List<BusDensityHistory> busDensityHistoryList = busDensityHistoryRepository.findAll();
        assertThat(busDensityHistoryList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteBusDensityHistory() throws Exception {
        // Initialize the database
        busDensityHistoryRepository.saveAndFlush(busDensityHistory);
        int databaseSizeBeforeDelete = busDensityHistoryRepository.findAll().size();

        // Get the busDensityHistory
        restBusDensityHistoryMockMvc.perform(delete("/api/bus-density-histories/{id}", busDensityHistory.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BusDensityHistory> busDensityHistoryList = busDensityHistoryRepository.findAll();
        assertThat(busDensityHistoryList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BusDensityHistory.class);
        BusDensityHistory busDensityHistory1 = new BusDensityHistory();
        busDensityHistory1.setId(1L);
        BusDensityHistory busDensityHistory2 = new BusDensityHistory();
        busDensityHistory2.setId(busDensityHistory1.getId());
        assertThat(busDensityHistory1).isEqualTo(busDensityHistory2);
        busDensityHistory2.setId(2L);
        assertThat(busDensityHistory1).isNotEqualTo(busDensityHistory2);
        busDensityHistory1.setId(null);
        assertThat(busDensityHistory1).isNotEqualTo(busDensityHistory2);
    }
}
