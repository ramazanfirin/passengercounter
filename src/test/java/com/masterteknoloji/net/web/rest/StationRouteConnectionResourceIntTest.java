package com.masterteknoloji.net.web.rest;

import static com.masterteknoloji.net.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import javax.persistence.EntityManager;

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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterteknoloji.net.Passengercounter2App;
import com.masterteknoloji.net.domain.Route;
import com.masterteknoloji.net.domain.Station;
import com.masterteknoloji.net.domain.StationRouteConnection;
import com.masterteknoloji.net.repository.RouteRepository;
import com.masterteknoloji.net.repository.StationRepository;
import com.masterteknoloji.net.repository.StationRouteConnectionRepository;
import com.masterteknoloji.net.web.rest.errors.ExceptionTranslator;

/**
 * Test class for the StationRouteConnectionResource REST controller.
 *
 * @see StationRouteConnectionResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Passengercounter2App.class)
public class StationRouteConnectionResourceIntTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_INDEX = 1L;
    private static final Long UPDATED_INDEX = 2L;

    @Autowired
    private StationRouteConnectionRepository stationRouteConnectionRepository;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;
    
    @Autowired
    private RouteRepository routeRepository;
    
    @Autowired
    private StationRepository stationRepository;
    
    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc restStationRouteConnectionMockMvc;

    private StationRouteConnection stationRouteConnection;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final StationRouteConnectionResource stationRouteConnectionResource = new StationRouteConnectionResource(stationRouteConnectionRepository);
        this.restStationRouteConnectionMockMvc = MockMvcBuilders.standaloneSetup(stationRouteConnectionResource)
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
    public static StationRouteConnection createEntity(EntityManager em) {
        StationRouteConnection stationRouteConnection = new StationRouteConnection()
            .name(DEFAULT_NAME)
            .index(DEFAULT_INDEX);
        return stationRouteConnection;
    }

    @Before
    public void initTest() {
        stationRouteConnection = createEntity(em);
    }

    @Test
    @Transactional
    public void createStationRouteConnection() throws Exception {
        int databaseSizeBeforeCreate = stationRouteConnectionRepository.findAll().size();

        // Create the StationRouteConnection
        restStationRouteConnectionMockMvc.perform(post("/api/station-route-connections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stationRouteConnection)))
            .andExpect(status().isCreated());

        // Validate the StationRouteConnection in the database
        List<StationRouteConnection> stationRouteConnectionList = stationRouteConnectionRepository.findAll();
        assertThat(stationRouteConnectionList).hasSize(databaseSizeBeforeCreate + 1);
        StationRouteConnection testStationRouteConnection = stationRouteConnectionList.get(stationRouteConnectionList.size() - 1);
        assertThat(testStationRouteConnection.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testStationRouteConnection.getIndex()).isEqualTo(DEFAULT_INDEX);
    }

    @Test
    @Transactional
    public void createStationRouteConnectionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = stationRouteConnectionRepository.findAll().size();

        // Create the StationRouteConnection with an existing ID
        stationRouteConnection.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restStationRouteConnectionMockMvc.perform(post("/api/station-route-connections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stationRouteConnection)))
            .andExpect(status().isBadRequest());

        // Validate the StationRouteConnection in the database
        List<StationRouteConnection> stationRouteConnectionList = stationRouteConnectionRepository.findAll();
        assertThat(stationRouteConnectionList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllStationRouteConnections() throws Exception {
        // Initialize the database
        stationRouteConnectionRepository.saveAndFlush(stationRouteConnection);

        // Get all the stationRouteConnectionList
        restStationRouteConnectionMockMvc.perform(get("/api/station-route-connections?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(stationRouteConnection.getId().intValue())))
            .andExpect(jsonPath("$.[*].name").value(hasItem(DEFAULT_NAME.toString())))
            .andExpect(jsonPath("$.[*].index").value(hasItem(DEFAULT_INDEX.intValue())));
    }

    @Test
    @Transactional
    public void getStationRouteConnection() throws Exception {
        // Initialize the database
        stationRouteConnectionRepository.saveAndFlush(stationRouteConnection);

        // Get the stationRouteConnection
        restStationRouteConnectionMockMvc.perform(get("/api/station-route-connections/{id}", stationRouteConnection.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(stationRouteConnection.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()))
            .andExpect(jsonPath("$.index").value(DEFAULT_INDEX.intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingStationRouteConnection() throws Exception {
        // Get the stationRouteConnection
        restStationRouteConnectionMockMvc.perform(get("/api/station-route-connections/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateStationRouteConnection() throws Exception {
        // Initialize the database
        stationRouteConnectionRepository.saveAndFlush(stationRouteConnection);
        int databaseSizeBeforeUpdate = stationRouteConnectionRepository.findAll().size();

        // Update the stationRouteConnection
        StationRouteConnection updatedStationRouteConnection = stationRouteConnectionRepository.findOne(stationRouteConnection.getId());
        // Disconnect from session so that the updates on updatedStationRouteConnection are not directly saved in db
        em.detach(updatedStationRouteConnection);
        updatedStationRouteConnection
            .name(UPDATED_NAME)
            .index(UPDATED_INDEX);

        restStationRouteConnectionMockMvc.perform(put("/api/station-route-connections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedStationRouteConnection)))
            .andExpect(status().isOk());

        // Validate the StationRouteConnection in the database
        List<StationRouteConnection> stationRouteConnectionList = stationRouteConnectionRepository.findAll();
        assertThat(stationRouteConnectionList).hasSize(databaseSizeBeforeUpdate);
        StationRouteConnection testStationRouteConnection = stationRouteConnectionList.get(stationRouteConnectionList.size() - 1);
        assertThat(testStationRouteConnection.getName()).isEqualTo(UPDATED_NAME);
        assertThat(testStationRouteConnection.getIndex()).isEqualTo(UPDATED_INDEX);
    }

    @Test
    @Transactional
    public void updateNonExistingStationRouteConnection() throws Exception {
        int databaseSizeBeforeUpdate = stationRouteConnectionRepository.findAll().size();

        // Create the StationRouteConnection

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restStationRouteConnectionMockMvc.perform(put("/api/station-route-connections")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(stationRouteConnection)))
            .andExpect(status().isCreated());

        // Validate the StationRouteConnection in the database
        List<StationRouteConnection> stationRouteConnectionList = stationRouteConnectionRepository.findAll();
        assertThat(stationRouteConnectionList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteStationRouteConnection() throws Exception {
        // Initialize the database
        stationRouteConnectionRepository.saveAndFlush(stationRouteConnection);
        int databaseSizeBeforeDelete = stationRouteConnectionRepository.findAll().size();

        // Get the stationRouteConnection
        restStationRouteConnectionMockMvc.perform(delete("/api/station-route-connections/{id}", stationRouteConnection.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<StationRouteConnection> stationRouteConnectionList = stationRouteConnectionRepository.findAll();
        assertThat(stationRouteConnectionList).hasSize(databaseSizeBeforeDelete - 1);
    }
    
    @Test
    @Transactional
    public void findByRouteId() throws Exception {
    
    	Route route = new Route();
        route.setRouteCode("sdf");
        routeRepository.save(route);
        
        Station station = new Station();
        stationRepository.save(station);
        
        Station station2 = new Station();
        stationRepository.save(station2);
        
        StationRouteConnection stationRouteConnection = new StationRouteConnection();
        stationRouteConnection.setRoute(route);
        stationRouteConnection.setStation(station);
        stationRouteConnectionRepository.save(stationRouteConnection);
        
        StationRouteConnection stationRouteConnection2 = new StationRouteConnection();
        stationRouteConnection2.setRoute(route);
        stationRouteConnection2.setStation(station2);
        stationRouteConnectionRepository.save(stationRouteConnection2);
        
        
        MvcResult resultMvc=restStationRouteConnectionMockMvc.perform(get("/api/station-route-connections/getByRouteId?id="+route.getId()))
        .andExpect(status().isOk()).andReturn();
        
        List<StationRouteConnection> asList = objectMapper.readValue(resultMvc.getResponse().getContentAsString(), new TypeReference<List<StationRouteConnection>>() { });
        assertThat(asList.size()).isEqualTo(2);
        assertThat(asList.get(0).getRoute().getId()).isEqualTo(route.getId());
        assertThat(asList.get(0).getStation().getId()).isEqualTo(station.getId());

        assertThat(asList.get(1).getRoute().getId()).isEqualTo(route.getId());
        assertThat(asList.get(1).getStation().getId()).isEqualTo(station2.getId());

    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(StationRouteConnection.class);
        StationRouteConnection stationRouteConnection1 = new StationRouteConnection();
        stationRouteConnection1.setId(1L);
        StationRouteConnection stationRouteConnection2 = new StationRouteConnection();
        stationRouteConnection2.setId(stationRouteConnection1.getId());
        assertThat(stationRouteConnection1).isEqualTo(stationRouteConnection2);
        stationRouteConnection2.setId(2L);
        assertThat(stationRouteConnection1).isNotEqualTo(stationRouteConnection2);
        stationRouteConnection1.setId(null);
        assertThat(stationRouteConnection1).isNotEqualTo(stationRouteConnection2);
    }
}
