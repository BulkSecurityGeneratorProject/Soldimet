package soldimet.web.rest;

import com.codahale.metrics.annotation.Timed;
import soldimet.domain.Persona;
import soldimet.service.PersonaService;
import soldimet.web.rest.errors.BadRequestAlertException;
import soldimet.web.rest.util.HeaderUtil;
import soldimet.web.rest.util.PaginationUtil;
import soldimet.service.dto.PersonaCriteria;
import soldimet.service.PersonaQueryService;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Persona.
 */
@RestController
@RequestMapping("/api")
public class PersonaResource {

    private final Logger log = LoggerFactory.getLogger(PersonaResource.class);

    private static final String ENTITY_NAME = "persona";

    private final PersonaService personaService;

    private final PersonaQueryService personaQueryService;

    public PersonaResource(PersonaService personaService, PersonaQueryService personaQueryService) {
        this.personaService = personaService;
        this.personaQueryService = personaQueryService;
    }

    /**
     * POST  /personas : Create a new persona.
     *
     * @param persona the persona to create
     * @return the ResponseEntity with status 201 (Created) and with body the new persona, or with status 400 (Bad Request) if the persona has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/personas")
    @Timed
    public ResponseEntity<Persona> createPersona(@Valid @RequestBody Persona persona) throws URISyntaxException {
        log.debug("REST request to save Persona : {}", persona);
        if (persona.getId() != null) {
            throw new BadRequestAlertException("A new persona cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Persona result = personaService.save(persona);
        return ResponseEntity.created(new URI("/api/personas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /personas : Updates an existing persona.
     *
     * @param persona the persona to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated persona,
     * or with status 400 (Bad Request) if the persona is not valid,
     * or with status 500 (Internal Server Error) if the persona couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/personas")
    @Timed
    public ResponseEntity<Persona> updatePersona(@Valid @RequestBody Persona persona) throws URISyntaxException {
        log.debug("REST request to update Persona : {}", persona);
        if (persona.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Persona result = personaService.save(persona);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, persona.getId().toString()))
            .body(result);
    }

    /**
     * GET  /personas : get all the personas.
     *
     * @param pageable the pagination information
     * @param criteria the criterias which the requested entities should match
     * @return the ResponseEntity with status 200 (OK) and the list of personas in body
     */
    @GetMapping("/personas")
    @Timed
    public ResponseEntity<List<Persona>> getAllPersonas(PersonaCriteria criteria, Pageable pageable) {
        log.debug("REST request to get Personas by criteria: {}", criteria);
        Page<Persona> page = personaQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/personas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /personas/:id : get the "id" persona.
     *
     * @param id the id of the persona to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the persona, or with status 404 (Not Found)
     */
    @GetMapping("/personas/{id}")
    @Timed
    public ResponseEntity<Persona> getPersona(@PathVariable Long id) {
        log.debug("REST request to get Persona : {}", id);
        Optional<Persona> persona = personaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(persona);
    }

    /**
     * DELETE  /personas/:id : delete the "id" persona.
     *
     * @param id the id of the persona to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/personas/{id}")
    @Timed
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        log.debug("REST request to delete Persona : {}", id);
        personaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
