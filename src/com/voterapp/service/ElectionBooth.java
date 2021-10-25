package com.voterapp.service;


import com.voterapp.exceptions.*;

public class ElectionBooth {
    String[] localities= {"Hanskhali", "Nadia", "Ranaghat", "Krishnanagar"};

    // if age is less than 18 throw exception
    public boolean checkAge(int age) throws UnderAgeException {
        if (age < 18) {
            throw new UnderAgeException("Not Eligable - Age is Below 18");
        } else {
            return true;
        }
    }

    // check if the locality matches with the array
    public boolean checkLocality(String locality) throws LocalityNotFoundException {
        for (String local : localities) {
            if (local.equalsIgnoreCase(locality)) {
                return true;
            } else {
                throw new LocalityNotFoundException("Please Check your Locality");
            }
        }
        return false;
    }

    // check if id is within 1 - 500
    public boolean checkVoterId(int voterId) throws NoVoterIDException {

        if (voterId >= 1 && voterId <= 500) {
            return true;
        } else {
            throw new NoVoterIDException("Your Voter ID is Suspenced - Please contact authorities ");
        }
    }

    public boolean checkEligibility(int age, String locality, int voterId) throws NotEligibleException {
        if (checkAge(age) && checkLocality(locality) && checkVoterId(voterId)) {

            System.out.println("Successful - You can Vote");
        } else {
            throw new NotEligibleException("Not Eligible to vote");
        }

        return true;
    }

}
