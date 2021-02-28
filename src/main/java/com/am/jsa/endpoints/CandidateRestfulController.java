package com.am.jsa.endpoints;

import com.am.jsa.candidate.entity.*;
import com.am.jsa.candidate.service.CandidateResumeService;
import com.am.jsa.candidate.service.CandidateService;
import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.job.entity.Job;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.CANDIDATE_SERVICE_URL)
public class CandidateRestfulController {
	
	@Autowired
    private CandidateService candidateService;

	@Autowired
	private CandidateResumeService candidateResumeService;

//	@GetMapping("")
//	public ResponseEntity getAllCandidate(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
//		AmLogger.info(this.getClass(), "getAllCandidate");
//		searchCriteria=new SearchCriteria();
//		searchCriteria.setSortAscending(true);
//		searchCriteria.setPageNumber(page);
//		searchCriteria.setSize(size);
//		return AmResponse.successResponse(candidateService.getCandidate(searchCriteria));
//	}

	@PostMapping("")
	public ResponseEntity addCandidate(@RequestBody Candidate candidate) {
		AmLogger.info(this.getClass(), "addCandidate");
		return AmResponse.successResponse(candidateService.saveCandidate(candidate));
	}

	@PutMapping("")
	public ResponseEntity updateCandidate(@RequestBody Candidate candidate) {
		AmLogger.info(this.getClass(), "updateCandidate");
		return AmResponse.successResponse(candidateService.updateCandidate(candidate));
	}

	@GetMapping("count")
	public ResponseEntity getCandidateCount() {
		AmLogger.info(this.getClass(), "getCandidateCount");
		return AmResponse.successResponse(candidateService.getCandidateCount());
	}

	@GetMapping("user-id/{id}")
	public ResponseEntity getCandidateByUserId(@PathVariable("id") Integer userId) {
		AmLogger.info(this.getClass(), "getCandidateByUserId");
		return AmResponse.successResponse(candidateService.getCandidateByUserId(userId));
	}

	@GetMapping("{id}")
	public ResponseEntity getCandidateById(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getCandidateById");
		return AmResponse.successResponse(candidateService.getCandidateById(candidateId));
	}

	@GetMapping("resume/{id}")
	public ResponseEntity getResumeById(@PathVariable("id") Long resumeId) {
		AmLogger.info(this.getClass(), "getResumeById");
		return AmResponse.successResponse(candidateResumeService.getResumeById(resumeId));
	}

	@GetMapping("resume/candidate-id/{id}")
	public ResponseEntity getResumeByCandidateId(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getResumeByCandidateId");
		return AmResponse.successResponse(candidateResumeService.getCandidateResumeByCandidateId(candidateId));
	}

	@PostMapping("resume/{id}")
	public ResponseEntity addResume(@PathVariable("id") Long candidateId, @RequestBody CandidateResume candidateResume) {
		AmLogger.info(this.getClass(), "addResume");
		return AmResponse.successResponse(candidateResumeService.saveCandidateResume(candidateResume,candidateId));
	}

	@PutMapping("resume/{id}")
	public ResponseEntity updateResume(@PathVariable("id") Long candidateId, @RequestBody CandidateResume candidateResume) {
		AmLogger.info(this.getClass(), "updateResume");
		return AmResponse.successResponse(candidateResumeService.updateCandidateResume(candidateResume,candidateId));
	}

	@PostMapping("awards")
	public ResponseEntity addAwards(@RequestBody CandidateAwards candidateAwards) {
		AmLogger.info(this.getClass(), "addAwards");
		return AmResponse.successResponse(candidateResumeService.saveCandidateAwards(candidateAwards));
	}

	@PutMapping("awards")
	public ResponseEntity updateAwards(CandidateAwards candidateAwards) {
		AmLogger.info(this.getClass(), "updateAwards");
		return AmResponse.successResponse(candidateResumeService.updateCandidateAwards(candidateAwards));
	}

	@PostMapping("education")
	public ResponseEntity addEducation(@RequestBody CandidateEducation candidateEducation) {
		AmLogger.info(this.getClass(), "addEducation");
		return AmResponse.successResponse(candidateResumeService.saveCandidateEducation(candidateEducation));
	}

	@PutMapping("education")
	public ResponseEntity updateEducation(@RequestBody CandidateEducation candidateEducation) {
		AmLogger.info(this.getClass(), "updateEducation");
		return AmResponse.successResponse(candidateResumeService.updateCandidateEducation(candidateEducation));
	}

	@PostMapping("portfolio")
	public ResponseEntity addPortfolio(@RequestBody CandidatePortFolio candidatePortFolio) {
		AmLogger.info(this.getClass(), "addPortfolio");
		return AmResponse.successResponse(candidateResumeService.saveCandidatePortFolio(candidatePortFolio));
	}

	@PutMapping("portfolio")
	public ResponseEntity updatePortfolio(@RequestBody CandidatePortFolio candidatePortFolio) {
		AmLogger.info(this.getClass(), "updatePortfolio");
		return AmResponse.successResponse(candidateResumeService.updateCandidatePortFolio(candidatePortFolio));
	}

	@PostMapping("professional-skills")
	public ResponseEntity addProfessionalSkills(@RequestBody CandidateProfessionalSkills candidateProfessionalSkills) {
		AmLogger.info(this.getClass(), "addProfessionalSkills");
		return AmResponse.successResponse(candidateResumeService.saveCandidateProfessionalSkills(candidateProfessionalSkills));
	}

	@PutMapping("professional-skills")
	public ResponseEntity updateProfessionalSkills(@RequestBody CandidateProfessionalSkills candidateProfessionalSkills) {
		AmLogger.info(this.getClass(), "updateProfessionalSkills");
		return AmResponse.successResponse(candidateResumeService.updateCandidateProfessionalSkills(candidateProfessionalSkills));
	}

	@PostMapping("work-experience/{id}")
	public ResponseEntity addWorkExperience(@PathVariable("id") Long resumeId, @RequestBody CandidateWorkExperience candidateWorkExperience) {
		AmLogger.info(this.getClass(), "addWorkExperience");
		return AmResponse.successResponse(candidateResumeService.saveCandidateWorkExperience(candidateWorkExperience, resumeId));
	}

	@PutMapping("work-experience/{id}")
	public ResponseEntity updateWorkExperience(@PathVariable("id") Long resumeId,CandidateWorkExperience candidateWorkExperience) {
		AmLogger.info(this.getClass(), "updateWorkExperience");
		return AmResponse.successResponse(candidateResumeService.updateCandidateWorkExperience(candidateWorkExperience,resumeId));
	}

	@GetMapping("applied-job/{id}")
	public ResponseEntity getAppliedJobs(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getAppliedJobs");
		return AmResponse.successResponse(candidateService.getAppliedJobs(candidateId));
	}

	@GetMapping("applied-job-count/{id}")
	public ResponseEntity getAppliedJobsCount(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getAppliedJobsCount");
		return AmResponse.successResponse(candidateService.getAppliedJobsCount(candidateId));
	}

	@GetMapping("followed-company/{id}")
	public ResponseEntity getFollowedCompany(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getFollowedCompany");
		return AmResponse.successResponse(candidateService.getFollowedCompany(candidateId));
	}

	@GetMapping("followed-company-count/{id}")
	public ResponseEntity getFollowedCompanyCount(@PathVariable("id") Long candidateId) {
		AmLogger.info(this.getClass(), "getFollowedCompanyCount");
		return AmResponse.successResponse(candidateService.getFollowedCompanyCount(candidateId));
	}

	@PostMapping("favourite/{id}")
	public ResponseEntity favouriteJob(@PathVariable("id") Long id, @RequestBody Job job) {
		AmLogger.info(this.getClass(), "favouriteJob");
		return AmResponse.successResponse(candidateService.favouriteJob(id,job));
	}

	@PostMapping("unfavourite/{id}")
	public ResponseEntity unfavouriteJob(@PathVariable("id") Long id, @RequestBody Job job) {
		AmLogger.info(this.getClass(), "favouriteJob");
		return AmResponse.successResponse(candidateService.unfavouriteJob(id,job));
	}
}
