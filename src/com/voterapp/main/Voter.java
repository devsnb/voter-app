package com.voterapp.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.voterapp.service.ElectionBooth;
import com.voterapp.exceptions.LocalityNotFoundException;
import com.voterapp.exceptions.NoVoterIDException;
import com.voterapp.exceptions.NotEligibleException;
import com.voterapp.exceptions.UnderAgeException;

public class Voter {

    public static void main(String[] args) throws IOException {

        int voterAge = 0, voterId = 0;
        String locality = "";

        ElectionBooth booth = new ElectionBooth();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Voter age :");

        try {
            voterAge = Integer.parseInt(reader.readLine());
            booth.checkAge(voterAge);
        } catch (UnderAgeException e) {
            System.out.println(e.getMessage());
            System.exit(0);

        }
        System.out.println("Locality : ");

        try {
            locality = reader.readLine();
            booth.checkLocality(locality);
        } catch (LocalityNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(0);

        }

        System.out.println("VoterId :");
        try {
            voterId = Integer.parseInt(reader.readLine());
            booth.checkVoterId(voterId);
        } catch (NoVoterIDException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        try {
            booth.checkEligibility(voterAge, locality, voterId);
        } catch (NotEligibleException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }

}