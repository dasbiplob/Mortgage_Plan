package fi.codetest.mortgageplan.restcontroller;

import fi.codetest.mortgageplan.model.MortgageRequest;
import fi.codetest.mortgageplan.model.MortgageResponse;
import fi.codetest.mortgageplan.service.MortgageService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;
import javax.ws.rs.core.MediaType;


@RestController
@RequestMapping("/mortgage-plan-management/mortgage/v1")
public class MortgageController {

    @Autowired
    MortgageService mortgageService;


    @ApiOperation(
            value = "double",
            response = MortgageResponse.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response retrieved successfully"),
            @ApiResponse(code = 500, message = "Response has not been retrieved correctly")
    })
    @GetMapping(value = "/get-mortgage", produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<MortgageResponse>getMortgage(@RequestParam("loan") @NotEmpty String loan,
                                                       @RequestParam("rate") @NotEmpty String rate,
                                                       @RequestParam("year") @NotEmpty String year){
        MortgageRequest mortgageRequest= MortgageRequest.builder()
                .rate(Double.valueOf(rate))
                .loan(Double.valueOf(loan))
                .year(Integer.valueOf(year))
                .build();
        return new ResponseEntity<>(mortgageService.getMonthlyPayment(mortgageRequest), HttpStatus.OK);
    }
}
