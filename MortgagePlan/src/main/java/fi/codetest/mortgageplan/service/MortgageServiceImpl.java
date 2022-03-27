package fi.codetest.mortgageplan.service;

import fi.codetest.mortgageplan.model.MortgageRequest;
import fi.codetest.mortgageplan.model.MortgageResponse;
import fi.codetest.mortgageplan.util.MortgageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MortgageServiceImpl implements  MortgageService{

    @Autowired
    MortgageUtil mortgageUtil;

    @Override
    public MortgageResponse getMonthlyPayment(MortgageRequest request) {
        return MortgageResponse.builder()
                .monthlyPayment(mortgageUtil.getMonthlyPaymentCalculation(request))
                .build();
    }
}
