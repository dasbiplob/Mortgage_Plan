package fi.codetest.mortgageplan.util;

import fi.codetest.mortgageplan.model.MortgageRequest;
import org.springframework.stereotype.Component;

@Component
public class MortgageUtil {

    public Double getMonthlyPaymentCalculation(MortgageRequest request){
        Double monthlyRate= (request.getRate()/100)/12;
        Double loan = request.getLoan();
        Integer noOfPayments= request.getYear()*12;
        System.out.println("p= "+noOfPayments);
        Double equation= powerOfValue(monthlyRate+1, noOfPayments);
        Double numerator = loan*monthlyRate*equation;
        Double denominator= equation-1;
        return roundNumber(numerator/denominator);
    }

    public Double powerOfValue(Double base, Integer power){
        Double result= Double.valueOf(1);
        for (int i= power; i!= 0; i--){
            result= result*base;
        }
        return result;
    }

    public Double roundNumber(Double number){
        double mult = number * 100.0;
        double add = mult + 0.5;
        Integer results = (int)add;
        return results / 100.0;
    }
}
