package com.masterteknoloji.net.web.rest;

import com.masterteknoloji.net.Passengercounter2App;

import com.masterteknoloji.net.domain.ScheduledVoyage;
import com.masterteknoloji.net.repository.ScheduledVoyageRepository;
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
 * Test class for the ScheduledVoyageResource REST controller.
 *
 * @see ScheduledVoyageResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class ScheduledVoyageResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_SCHEDULED_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_SCHEDULED_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ScheduledVoyageRepository scheduledVoyageRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restScheduledVoyageMockMvc;

    private ScheduledVoyage scheduledVoyage;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ScheduledVoyageResource scheduledVoyageResource = new ScheduledVoyageResource(scheduledVoyageRepository);
        this.restScheduledVoyageMockMvc = MockMvcBuilders.standaloneSetup(scheduledVoyageResource)
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
    public static ScheduledVoyage createEntity(EntityManager em) {
        ScheduledVoyage scheduledVoyage = new ScheduledVoyage()
            .name(DEFAULT_NAME)
            .scheduledTime(DEFAULT_SCHEDULED_TIME);
        return scheduledVoyage;
    }

    @Before
    public void initTest() {
        scheduledVoyage = createEntity(em);
    }

    @Test
    @Transactional
    public void createScheduledVoyage() throws Exception {
        int databaseSizeBeforeCreate = scheduledVoyageRepository.findAll().size();

        // Create the ScheduledVoyage
        restScheduledVoyageMockMvc.perform(post("/api/scheduled-voyages")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(scheduledVoyage)))
            .andExpect(status().isCreated());

        // Validate the ScheduledVoyage in the database
        List<ScheduledVoyage> scheduledVoyageList = scheduledVoyageRepository.findAll();
        assertThat(scheduledVoyageList).hasSize(databaseSizeBeforeCreate + 1);
        ScheduledVoyage testScheduledVoyage = scheduledVoyageList.get(scheduledVoyageList.size() - 1);
        assertThat(testScheduledVoyage.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testScheduledVoyage.getScheduledTime()).isEqualTo(DEFAULT_SCHEDULED_TIME);
    }

    @Test
    @Transactional
    public void createScheduledVoyageWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = scheduledVoyageRepository.findAll().size();

        // Create the ScheduledVoyage with an existing ID
        scheduledVoyage.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restScheduledVoyageMockMvc.perform(post("/api/scheduled-voyages")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(scheduledVoyage)))
            .andExpect(status().isBadRequest());

        // Validate the ScheduledVoyage in the database
        List<ScheduledVoyage> scheduledVoyageList = scheduledVoyageRepository.findAll();
        assertThat(scheduledVoyageList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllScheduledVoyages() throws Exception {
        // Initialize the database
        scheduledVoyageRepository.saveAndFlush(scheduledVoyage);

        // Get all the scheduledVoyageList
        restScheduledVoyageMockMvc.perform(get("/api/scheduled-voyages?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(scheduledVoyage.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].scheduledTime").value(hasItem(DEFAULT_SCHEDULED_TIME.toString())));
    }

    @Test
    @Transactional
    public void getScheduledVoyage() throws Exception {
        // Initialize the database
        scheduledVoyageRepository.saveAndFlush(scheduledVoyage);

        // Get the scheduledVoyage
        restScheduledVoyageMockMvc.perform(get("/api/scheduled-voyages/{id}", scheduledVoyage.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(scheduledVoyage.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.scheduledTime").value(DEFAULT_SCHEDULED_TIME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingScheduledVoyage() throws Exception {
        // Get the scheduledVoyage
        restScheduledVoyageMockMvc.perform(get("/api/scheduled-voyages/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateScheduledVoyage() throws Exception {
        // Initialize the database
        scheduledVoyageRepository.saveAndFlush(scheduledVoyage);
        int databaseSizeBeforeUpdate = scheduledVoyageRepository.findAll().size();

        // Update the scheduledVoyage
        ScheduledVoyage updatedScheduledVoyage = scheduledVoyageRepository.findOne(scheduledVoyage.getId());
        // Disconnect from session so that the updates on updatedScheduledVoyage are not directly saved in db
        em.detach(updatedScheduledVoyage);
        updatedScheduledVoyage
            .name(UPDATED_NAME)
            .scheduledTime(UPDATED_SCHEDULED_TIME);

        restScheduledVoyageMockMvc.perform(put("/api/scheduled-voyages")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedScheduledVoyage)))
            .andExpect(status().isOk());

        // Validate the ScheduledVoyage in the database
        List<ScheduledVoyage> scheduledVoyageList = scheduledVoyageRepository.findAll();
        assertThat(scheduledVoyageList).hasSize(databaseSizeBeforeUpdate);
        ScheduledVoyage testScheduledVoyage = scheduledVoyageList.get(scheduledVoyageList.size() - 1);
        assertThat(testScheduledVoyage.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testScheduledVoyage.getScheduledTime()).isEqualTo(UPDATED_SCHEDULED_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingScheduledVoyage() throws Exception {
        int databaseSizeBeforeUpdate = scheduledVoyageRepository.findAll().size();

        // Create the ScheduledVoyage

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restScheduledVoyageMockMvc.perform(put("/api/scheduled-voyages")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(scheduledVoyage)))
            .andExpect(status().isCreated());

        // Validate the ScheduledVoyage in the database
        List<ScheduledVoyage> scheduledVoyageList = scheduledVoyageRepository.findAll();
        assertThat(scheduledVoyageList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteScheduledVoyage() throws Exception {
        // Initialize the database
        scheduledVoyageRepository.saveAndFlush(scheduledVoyage);
        int databaseSizeBeforeDelete = scheduledVoyageRepository.findAll().size();

        // Get the scheduledVoyage
        restScheduledVoyageMockMvc.perform(delete("/api/scheduled-voyages/{id}", scheduledVoyage.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<ScheduledVoyage> scheduledVoyageList = scheduledVoyageRepository.findAll();
        assertThat(scheduledVoyageList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ScheduledVoyage.class);
        ScheduledVoyage scheduledVoyage1 = new ScheduledVoyage();
        scheduledVoyage1.setId(1L);
        ScheduledVoyage scheduledVoyage2 = new ScheduledVoyage();
        scheduledVoyage2.setId(scheduledVoyage1.getId());
        assertThat(scheduledVoyage1).isEqualTo(scheduledVoyage2);
        scheduledVoyage2.setId(2L);
        assertThat(scheduledVoyage1).isNotEqualTo(scheduledVoyage2);
        scheduledVoyage1.setId(null);
        assertThat(scheduledVoyage1).isNotEqualTo(scheduledVoyage2);
    }
}
