package com.am.jsa.endpoints;

import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.company.entity.Company;
import com.am.jsa.company.entity.CompanyPayments;
import com.am.jsa.company.service.CompanyService;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.COMPANY_SERVICE_URL)
public class CompanyRestfulController {
	
	@Autowired
    private CompanyService companyService;

//	@GetMapping("")	
//	public ResponseEntity getAllCompanies(@QueryParam("page") Long page, @QueryParam("size") Long size) {
//		AmLogger.info(this.getClass(), "getAllCompanies");
//		searchCriteria=new SearchCriteria();
//		searchCriteria.setSortAscending(true);
//		searchCriteria.setPageNumber(page);
//		searchCriteria.setSize(size);
//		return AmResponse.successResponse(companyService.getCompanies(searchCriteria));
//	}

	@PostMapping("")	
	public ResponseEntity addCompany(@RequestBody  Company company) {
		AmLogger.info(this.getClass(), "addCompany");
		return AmResponse.successResponse(companyService.saveCompany(company));
	}

	@PutMapping("")	
	public ResponseEntity updateCompany(@RequestBody Company company) {
		AmLogger.info(this.getClass(), "updateCompany");
		return AmResponse.successResponse(companyService.updateCompany(company));
	}
	@GetMapping("/{id}")	
	public ResponseEntity getCompanyById(@PathVariable("id") Long userId) {
		AmLogger.info(this.getClass(), "getCompanyById");
		return AmResponse.successResponse(companyService.getCompanyById(userId));
	}

	@GetMapping("user-id/{id}")	
	public ResponseEntity getCompanyByUserId(@PathVariable("id") Long userId) {
		AmLogger.info(this.getClass(), "getCompanyByUserId");
		return AmResponse.successResponse(companyService.getCompanyByUserId(userId));
	}

	@GetMapping("job-id/{id}")
	public ResponseEntity getCompanyByJobId(@PathVariable("id") Long jobId) {
		AmLogger.info(this.getClass(), "getCompanyByJobId");
		return AmResponse.successResponse(companyService.getCompanyByJobId(jobId));
	}

	@GetMapping("count")
	public ResponseEntity getCompanyCount() {
		AmLogger.info(this.getClass(), "getCompanyCount");
		return AmResponse.successResponse(companyService.getCompanyCount());
	}

	@PostMapping("/follow/{id}")
	public ResponseEntity followCompany(@PathVariable("id") Long id, @RequestBody Candidate candidate) {
		AmLogger.info(this.getClass(), "followCompany");
		return AmResponse.successResponse(companyService.followCompany(id,candidate));
	}

	@PostMapping("/view/{id}")
	public ResponseEntity viewCompany(@PathVariable("id") Long id,Candidate candidate) {
		AmLogger.info(this.getClass(), "viewCompany");
		return AmResponse.successResponse(companyService.viewCompany(id,candidate));
	}

	@PostMapping("/pay")
	public ResponseEntity makePayment(@RequestBody CompanyPayments companyPayments) {
		AmLogger.info(this.getClass(), "makePayment");
		return AmResponse.successResponse(companyService.makePayment(companyPayments));
	}

    @GetMapping("latest-payment/{id}")
    public ResponseEntity getLatestCompanyPaymentsByCompanyId(@PathVariable("id") Long companyId) {
        AmLogger.info(this.getClass(), "getLatestCompanyPaymentsByCompanyId");
        return AmResponse.successResponse(companyService.getLatestCompanyPaymentByCompanyId(companyId));
    }

}
