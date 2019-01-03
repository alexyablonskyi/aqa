package data;

import com.github.javafaker.Faker;

public class CandidateDataProvider {
    Faker faker =new Faker();


    public CandidateData generateCandidateData(){
        CandidateData data = new CandidateData();
        data.setFirstName(faker.name().firstName());
        data.setLastName(faker.name().lastName());
        return data;
    }
}
