package com.am.jsa.endpoints;

import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.job.entity.Job;
import com.am.jsa.job.entity.JobCandidateApplication;
import com.am.jsa.job.service.JobService;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.JOB_SERVICE_URL)
@CrossOrigin
public class JobRestfulController {

	
	@Autowired
    private JobService jobService;

	@GetMapping("")
	public ResponseEntity getAllJob(@RequestParam("page") int page,@RequestParam("size") int size) {
		AmLogger.info(this.getClass(), "getAllJob");
		return AmResponse.successResponse(jobService.getJobs(page,size));
	}

    @GetMapping("{id}")    
    public ResponseEntity getJobById(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getJobById");
        return AmResponse.successResponse(jobService.getJobById(id));
    }

	@PostMapping("")
	public ResponseEntity addJob(@RequestBody Job job) {
		AmLogger.info(this.getClass(), "addJob");
		return AmResponse.successResponse(jobService.saveJob(job));
	}

	@PutMapping("")
	public ResponseEntity updateJob(@RequestBody Job job) {
		AmLogger.info(this.getClass(), "updateJob");
		return AmResponse.successResponse(jobService.updateJob(job));
	}

	@GetMapping("count")
	public ResponseEntity getJobCount() {
		AmLogger.info(this.getClass(), "getAllJob");
		return AmResponse.successResponse(jobService.getJobCount());
	}

	@GetMapping("count/{id}")
	public ResponseEntity getJobCountByCategory(@PathVariable("id") Integer id) {
		AmLogger.info(this.getClass(), "getJobCountByCategory");
		List<Integer> ids=new ArrayList<>();
		ids.add(id);
		return AmResponse.successResponse(jobService.getJobCountByCategory(ids));
	}

	@PostMapping("/apply/{id}")
	public ResponseEntity applyJob(@PathVariable("id") Integer id, @RequestBody Candidate candidate) {
		AmLogger.info(this.getClass(), "applyJob");
		return AmResponse.successResponse(jobService.applyForJob(id,candidate));
	}

	@PostMapping("/view/{id}")
	public ResponseEntity jobView(@PathVariable("id") Integer id, @RequestBody Candidate candidate) {
		AmLogger.info(this.getClass(), "jobView");
		return AmResponse.successResponse(jobService.viewJob(id,candidate));
	}

	@GetMapping("applied-candidates/{id}")
	public ResponseEntity getAppliedCandidate(@PathVariable("id") Integer companyId) {
		AmLogger.info(this.getClass(), "getAppliedCandidate");
		return AmResponse.successResponse(jobService.getAppliedCandidates(companyId));
	}

	@PutMapping("shortlist")
	public ResponseEntity shortListCandidate(@RequestBody JobCandidateApplication jobCandidateApplication) {
		AmLogger.info(this.getClass(), "shortListCandidate");
		return AmResponse.successResponse(jobService.shortlistCandidate(jobCandidateApplication));
	}

	@GetMapping("job-by-category")
	public ResponseEntity getJobByCategory(@RequestParam("id") List<Integer> categoryIds) {
		AmLogger.info(this.getClass(), "getJobByCategory");
		return AmResponse.successResponse(jobService.getJobByCategory(categoryIds));
	}

}
