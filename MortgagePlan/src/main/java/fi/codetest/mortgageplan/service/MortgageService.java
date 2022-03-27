package fi.codetest.mortgageplan.service;

import fi.codetest.mortgageplan.model.MortgageRequest;
import fi.codetest.mortgageplan.model.MortgageResponse;

public interface MortgageService {
  MortgageResponse getMonthlyPayment(MortgageRequest request);
}
