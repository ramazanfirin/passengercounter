package com.masterteknoloji.net.web.rest;

import com.masterteknoloji.net.Passengercounter2App;

import com.masterteknoloji.net.domain.RawTable;
import com.masterteknoloji.net.repository.RawTableRepository;
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
 * Test class for the RawTableResource REST controller.
 *
 * @see RawTableResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class RawTableResourceIntTest {

    private static final String DEFAULT_DEVICE_ID_ORIGINAL = "AAAAAAAAAA";
    private static final String UPDATED_DEVICE_ID_ORIGINAL = "BBBBBBBBBB";

    private static final Long DEFAULT_UP_PEOPLE_1 = 1L;
    private static final Long UPDATED_UP_PEOPLE_1 = 2L;

    private static final Long DEFAULT_DOWN_PEOPLE_1 = 1L;
    private static final Long UPDATED_DOWN_PEOPLE_1 = 2L;

    private static final Long DEFAULT_UP_PEOPLE_2 = 1L;
    private static final Long UPDATED_UP_PEOPLE_2 = 2L;

    private static final Long DEFAULT_DOWN_PEOPLE_2 = 1L;
    private static final Long UPDATED_DOWN_PEOPLE_2 = 2L;

    private static final Long DEFAULT_UP_PEOPLE_3 = 1L;
    private static final Long UPDATED_UP_PEOPLE_3 = 2L;

    private static final Long DEFAULT_DOWN_PEOPLE_3 = 1L;
    private static final Long UPDATED_DOWN_PEOPLE_3 = 2L;

    private static final Long DEFAULT_UP_PEOPLE_4 = 1L;
    private static final Long UPDATED_UP_PEOPLE_4 = 2L;

    private static final Long DEFAULT_DOWN_PEOPLE_4 = 1L;
    private static final Long UPDATED_DOWN_PEOPLE_4 = 2L;

    private static final Long DEFAULT_CUR_PEOPLE = 1L;
    private static final Long UPDATED_CUR_PEOPLE = 2L;

    private static final Long DEFAULT_INCR_PEOPLE = 1L;
    private static final Long UPDATED_INCR_PEOPLE = 2L;

    private static final String DEFAULT_LAT = "AAAAAAAAAA";
    private static final String UPDATED_LAT = "BBBBBBBBBB";

    private static final String DEFAULT_LNG = "AAAAAAAAAA";
    private static final String UPDATED_LNG = "BBBBBBBBBB";

    private static final Instant DEFAULT_INSERT_DATE = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_INSERT_DATE = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final Boolean DEFAULT_PROCESSED = false;
    private static final Boolean UPDATED_PROCESSED = true;

    private static final Boolean DEFAULT_IS_SUCCESS = false;
    private static final Boolean UPDATED_IS_SUCCESS = true;

    private static final String DEFAULT_ERROR_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_ERROR_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENT_ROUTE_CODE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENT_ROUTE_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENT_STATION_ID = "AAAAAAAAAA";
    private static final String UPDATED_CURRENT_STATION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CURRENT_VOYAGE = "AAAAAAAAAA";
    private static final String UPDATED_CURRENT_VOYAGE = "BBBBBBBBBB";

    @Autowired
    private RawTableRepository rawTableRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restRawTableMockMvc;

    private RawTable rawTable;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RawTableResource rawTableResource = new RawTableResource(rawTableRepository);
        this.restRawTableMockMvc = MockMvcBuilders.standaloneSetup(rawTableResource)
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
    public static RawTable createEntity(EntityManager em) {
        RawTable rawTable = new RawTable()
            .deviceIdOriginal(DEFAULT_DEVICE_ID_ORIGINAL)
            .upPeople1(DEFAULT_UP_PEOPLE_1)
            .downPeople1(DEFAULT_DOWN_PEOPLE_1)
            .upPeople2(DEFAULT_UP_PEOPLE_2)
            .downPeople2(DEFAULT_DOWN_PEOPLE_2)
            .upPeople3(DEFAULT_UP_PEOPLE_3)
            .downPeople3(DEFAULT_DOWN_PEOPLE_3)
            .upPeople4(DEFAULT_UP_PEOPLE_4)
            .downPeople4(DEFAULT_DOWN_PEOPLE_4)
            .curPeople(DEFAULT_CUR_PEOPLE)
            .incrPeople(DEFAULT_INCR_PEOPLE)
            .lat(DEFAULT_LAT)
            .lng(DEFAULT_LNG)
            .insertDate(DEFAULT_INSERT_DATE)
            .processed(DEFAULT_PROCESSED)
            .isSuccess(DEFAULT_IS_SUCCESS)
            .errorMessage(DEFAULT_ERROR_MESSAGE)
            .currentRouteCode(DEFAULT_CURRENT_ROUTE_CODE)
            .currentStationId(DEFAULT_CURRENT_STATION_ID)
            .currentVoyage(DEFAULT_CURRENT_VOYAGE);
        return rawTable;
    }

    @Before
    public void initTest() {
        rawTable = createEntity(em);
    }

    @Test
    @Transactional
    public void createRawTable() throws Exception {
        int databaseSizeBeforeCreate = rawTableRepository.findAll().size();

        // Create the RawTable
        restRawTableMockMvc.perform(post("/api/raw-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rawTable)))
            .andExpect(status().isCreated());

        // Validate the RawTable in the database
        List<RawTable> rawTableList = rawTableRepository.findAll();
        assertThat(rawTableList).hasSize(databaseSizeBeforeCreate + 1);
        RawTable testRawTable = rawTableList.get(rawTableList.size() - 1);
        assertThat(testRawTable.getDeviceIdOriginal()).isEqualTo(DEFAULT_DEVICE_ID_ORIGINAL);
        assertThat(testRawTable.getUpPeople1()).isEqualTo(DEFAULT_UP_PEOPLE_1);
        assertThat(testRawTable.getDownPeople1()).isEqualTo(DEFAULT_DOWN_PEOPLE_1);
        assertThat(testRawTable.getUpPeople2()).isEqualTo(DEFAULT_UP_PEOPLE_2);
        assertThat(testRawTable.getDownPeople2()).isEqualTo(DEFAULT_DOWN_PEOPLE_2);
        assertThat(testRawTable.getUpPeople3()).isEqualTo(DEFAULT_UP_PEOPLE_3);
        assertThat(testRawTable.getDownPeople3()).isEqualTo(DEFAULT_DOWN_PEOPLE_3);
        assertThat(testRawTable.getUpPeople4()).isEqualTo(DEFAULT_UP_PEOPLE_4);
        assertThat(testRawTable.getDownPeople4()).isEqualTo(DEFAULT_DOWN_PEOPLE_4);
        assertThat(testRawTable.getCurPeople()).isEqualTo(DEFAULT_CUR_PEOPLE);
        assertThat(testRawTable.getIncrPeople()).isEqualTo(DEFAULT_INCR_PEOPLE);
        assertThat(testRawTable.getLat()).isEqualTo(DEFAULT_LAT);
        assertThat(testRawTable.getLng()).isEqualTo(DEFAULT_LNG);
        assertThat(testRawTable.getInsertDate()).isEqualTo(DEFAULT_INSERT_DATE);
        assertThat(testRawTable.isProcessed()).isEqualTo(DEFAULT_PROCESSED);
        assertThat(testRawTable.isIsSuccess()).isEqualTo(DEFAULT_IS_SUCCESS);
        assertThat(testRawTable.getErrorMessage()).isEqualTo(DEFAULT_ERROR_MESSAGE);
        assertThat(testRawTable.getCurrentRouteCode()).isEqualTo(DEFAULT_CURRENT_ROUTE_CODE);
        assertThat(testRawTable.getCurrentStationId()).isEqualTo(DEFAULT_CURRENT_STATION_ID);
        assertThat(testRawTable.getCurrentVoyage()).isEqualTo(DEFAULT_CURRENT_VOYAGE);
    }

    @Test
    @Transactional
    public void createRawTableWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = rawTableRepository.findAll().size();

        // Create the RawTable with an existing ID
        rawTable.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRawTableMockMvc.perform(post("/api/raw-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rawTable)))
            .andExpect(status().isBadRequest());

        // Validate the RawTable in the database
        List<RawTable> rawTableList = rawTableRepository.findAll();
        assertThat(rawTableList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllRawTables() throws Exception {
        // Initialize the database
        rawTableRepository.saveAndFlush(rawTable);

        // Get all the rawTableList
        restRawTableMockMvc.perform(get("/api/raw-tables?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(rawTable.getId().intValue())))
            .andExpect(jsonPath("$.[*].deviceIdOriginal").value(hasItem(DEFAULT_DEVICE_ID_ORIGINAL.toString())))
            .andExpect(jsonPath("$.[*].upPeople1").value(hasItem(DEFAULT_UP_PEOPLE_1.intValue())))
            .andExpect(jsonPath("$.[*].downPeople1").value(hasItem(DEFAULT_DOWN_PEOPLE_1.intValue())))
            .andExpect(jsonPath("$.[*].upPeople2").value(hasItem(DEFAULT_UP_PEOPLE_2.intValue())))
            .andExpect(jsonPath("$.[*].downPeople2").value(hasItem(DEFAULT_DOWN_PEOPLE_2.intValue())))
            .andExpect(jsonPath("$.[*].upPeople3").value(hasItem(DEFAULT_UP_PEOPLE_3.intValue())))
            .andExpect(jsonPath("$.[*].downPeople3").value(hasItem(DEFAULT_DOWN_PEOPLE_3.intValue())))
            .andExpect(jsonPath("$.[*].upPeople4").value(hasItem(DEFAULT_UP_PEOPLE_4.intValue())))
            .andExpect(jsonPath("$.[*].downPeople4").value(hasItem(DEFAULT_DOWN_PEOPLE_4.intValue())))
            .andExpect(jsonPath("$.[*].curPeople").value(hasItem(DEFAULT_CUR_PEOPLE.intValue())))
            .andExpect(jsonPath("$.[*].incrPeople").value(hasItem(DEFAULT_INCR_PEOPLE.intValue())))
            .andExpect(jsonPath("$.[*].lat").value(hasItem(DEFAULT_LAT.toString())))
            .andExpect(jsonPath("$.[*].lng").value(hasItem(DEFAULT_LNG.toString())))
            .andExpect(jsonPath("$.[*].insertDate").value(hasItem(DEFAULT_INSERT_DATE.toString())))
            .andExpect(jsonPath("$.[*].processed").value(hasItem(DEFAULT_PROCESSED.booleanValue())))
            .andExpect(jsonPath("$.[*].isSuccess").value(hasItem(DEFAULT_IS_SUCCESS.booleanValue())))
            .andExpect(jsonPath("$.[*].errorMessage").value(hasItem(DEFAULT_ERROR_MESSAGE.toString())))
            .andExpect(jsonPath("$.[*].currentRouteCode").value(hasItem(DEFAULT_CURRENT_ROUTE_CODE.toString())))
            .andExpect(jsonPath("$.[*].currentStationId").value(hasItem(DEFAULT_CURRENT_STATION_ID.toString())))
            .andExpect(jsonPath("$.[*].currentVoyage").value(hasItem(DEFAULT_CURRENT_VOYAGE.toString())));
    }

    @Test
    @Transactional
    public void getRawTable() throws Exception {
        // Initialize the database
        rawTableRepository.saveAndFlush(rawTable);

        // Get the rawTable
        restRawTableMockMvc.perform(get("/api/raw-tables/{id}", rawTable.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(rawTable.getId().intValue()))
            .andExpect(jsonPath("$.deviceIdOriginal").value(DEFAULT_DEVICE_ID_ORIGINAL.toString()))
            .andExpect(jsonPath("$.upPeople1").value(DEFAULT_UP_PEOPLE_1.intValue()))
            .andExpect(jsonPath("$.downPeople1").value(DEFAULT_DOWN_PEOPLE_1.intValue()))
            .andExpect(jsonPath("$.upPeople2").value(DEFAULT_UP_PEOPLE_2.intValue()))
            .andExpect(jsonPath("$.downPeople2").value(DEFAULT_DOWN_PEOPLE_2.intValue()))
            .andExpect(jsonPath("$.upPeople3").value(DEFAULT_UP_PEOPLE_3.intValue()))
            .andExpect(jsonPath("$.downPeople3").value(DEFAULT_DOWN_PEOPLE_3.intValue()))
            .andExpect(jsonPath("$.upPeople4").value(DEFAULT_UP_PEOPLE_4.intValue()))
            .andExpect(jsonPath("$.downPeople4").value(DEFAULT_DOWN_PEOPLE_4.intValue()))
            .andExpect(jsonPath("$.curPeople").value(DEFAULT_CUR_PEOPLE.intValue()))
            .andExpect(jsonPath("$.incrPeople").value(DEFAULT_INCR_PEOPLE.intValue()))
            .andExpect(jsonPath("$.lat").value(DEFAULT_LAT.toString()))
            .andExpect(jsonPath("$.lng").value(DEFAULT_LNG.toString()))
            .andExpect(jsonPath("$.insertDate").value(DEFAULT_INSERT_DATE.toString()))
            .andExpect(jsonPath("$.processed").value(DEFAULT_PROCESSED.booleanValue()))
            .andExpect(jsonPath("$.isSuccess").value(DEFAULT_IS_SUCCESS.booleanValue()))
            .andExpect(jsonPath("$.errorMessage").value(DEFAULT_ERROR_MESSAGE.toString()))
            .andExpect(jsonPath("$.currentRouteCode").value(DEFAULT_CURRENT_ROUTE_CODE.toString()))
            .andExpect(jsonPath("$.currentStationId").value(DEFAULT_CURRENT_STATION_ID.toString()))
            .andExpect(jsonPath("$.currentVoyage").value(DEFAULT_CURRENT_VOYAGE.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingRawTable() throws Exception {
        // Get the rawTable
        restRawTableMockMvc.perform(get("/api/raw-tables/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRawTable() throws Exception {
        // Initialize the database
        rawTableRepository.saveAndFlush(rawTable);
        int databaseSizeBeforeUpdate = rawTableRepository.findAll().size();

        // Update the rawTable
        RawTable updatedRawTable = rawTableRepository.findOne(rawTable.getId());
        // Disconnect from session so that the updates on updatedRawTable are not directly saved in db
        em.detach(updatedRawTable);
        updatedRawTable
            .deviceIdOriginal(UPDATED_DEVICE_ID_ORIGINAL)
            .upPeople1(UPDATED_UP_PEOPLE_1)
            .downPeople1(UPDATED_DOWN_PEOPLE_1)
            .upPeople2(UPDATED_UP_PEOPLE_2)
            .downPeople2(UPDATED_DOWN_PEOPLE_2)
            .upPeople3(UPDATED_UP_PEOPLE_3)
            .downPeople3(UPDATED_DOWN_PEOPLE_3)
            .upPeople4(UPDATED_UP_PEOPLE_4)
            .downPeople4(UPDATED_DOWN_PEOPLE_4)
            .curPeople(UPDATED_CUR_PEOPLE)
            .incrPeople(UPDATED_INCR_PEOPLE)
            .lat(UPDATED_LAT)
            .lng(UPDATED_LNG)
            .insertDate(UPDATED_INSERT_DATE)
            .processed(UPDATED_PROCESSED)
            .isSuccess(UPDATED_IS_SUCCESS)
            .errorMessage(UPDATED_ERROR_MESSAGE)
            .currentRouteCode(UPDATED_CURRENT_ROUTE_CODE)
            .currentStationId(UPDATED_CURRENT_STATION_ID)
            .currentVoyage(UPDATED_CURRENT_VOYAGE);

        restRawTableMockMvc.perform(put("/api/raw-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedRawTable)))
            .andExpect(status().isOk());

        // Validate the RawTable in the database
        List<RawTable> rawTableList = rawTableRepository.findAll();
        assertThat(rawTableList).hasSize(databaseSizeBeforeUpdate);
        RawTable testRawTable = rawTableList.get(rawTableList.size() - 1);
        assertThat(testRawTable.getDeviceIdOriginal()).isEqualTo(UPDATED_DEVICE_ID_ORIGINAL);
        assertThat(testRawTable.getUpPeople1()).isEqualTo(UPDATED_UP_PEOPLE_1);
        assertThat(testRawTable.getDownPeople1()).isEqualTo(UPDATED_DOWN_PEOPLE_1);
        assertThat(testRawTable.getUpPeople2()).isEqualTo(UPDATED_UP_PEOPLE_2);
        assertThat(testRawTable.getDownPeople2()).isEqualTo(UPDATED_DOWN_PEOPLE_2);
        assertThat(testRawTable.getUpPeople3()).isEqualTo(UPDATED_UP_PEOPLE_3);
        assertThat(testRawTable.getDownPeople3()).isEqualTo(UPDATED_DOWN_PEOPLE_3);
        assertThat(testRawTable.getUpPeople4()).isEqualTo(UPDATED_UP_PEOPLE_4);
        assertThat(testRawTable.getDownPeople4()).isEqualTo(UPDATED_DOWN_PEOPLE_4);
        assertThat(testRawTable.getCurPeople()).isEqualTo(UPDATED_CUR_PEOPLE);
        assertThat(testRawTable.getIncrPeople()).isEqualTo(UPDATED_INCR_PEOPLE);
        assertThat(testRawTable.getLat()).isEqualTo(UPDATED_LAT);
        assertThat(testRawTable.getLng()).isEqualTo(UPDATED_LNG);
        assertThat(testRawTable.getInsertDate()).isEqualTo(UPDATED_INSERT_DATE);
        assertThat(testRawTable.isProcessed()).isEqualTo(UPDATED_PROCESSED);
        assertThat(testRawTable.isIsSuccess()).isEqualTo(UPDATED_IS_SUCCESS);
        assertThat(testRawTable.getErrorMessage()).isEqualTo(UPDATED_ERROR_MESSAGE);
        assertThat(testRawTable.getCurrentRouteCode()).isEqualTo(UPDATED_CURRENT_ROUTE_CODE);
        assertThat(testRawTable.getCurrentStationId()).isEqualTo(UPDATED_CURRENT_STATION_ID);
        assertThat(testRawTable.getCurrentVoyage()).isEqualTo(UPDATED_CURRENT_VOYAGE);
    }

    @Test
    @Transactional
    public void updateNonExistingRawTable() throws Exception {
        int databaseSizeBeforeUpdate = rawTableRepository.findAll().size();

        // Create the RawTable

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restRawTableMockMvc.perform(put("/api/raw-tables")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(rawTable)))
            .andExpect(status().isCreated());

        // Validate the RawTable in the database
        List<RawTable> rawTableList = rawTableRepository.findAll();
        assertThat(rawTableList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteRawTable() throws Exception {
        // Initialize the database
        rawTableRepository.saveAndFlush(rawTable);
        int databaseSizeBeforeDelete = rawTableRepository.findAll().size();

        // Get the rawTable
        restRawTableMockMvc.perform(delete("/api/raw-tables/{id}", rawTable.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<RawTable> rawTableList = rawTableRepository.findAll();
        assertThat(rawTableList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RawTable.class);
        RawTable rawTable1 = new RawTable();
        rawTable1.setId(1L);
        RawTable rawTable2 = new RawTable();
        rawTable2.setId(rawTable1.getId());
        assertThat(rawTable1).isEqualTo(rawTable2);
        rawTable2.setId(2L);
        assertThat(rawTable1).isNotEqualTo(rawTable2);
        rawTable1.setId(null);
        assertThat(rawTable1).isNotEqualTo(rawTable2);
    }
}
