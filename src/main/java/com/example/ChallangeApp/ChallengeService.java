package com.example.ChallangeApp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;
    public ChallengeService(){
    }
    public List<Challenge> getChallenges(){return challenges;}

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }
        return false;
    }
    public Challenge getMonth(String month){
        for (int i = 0; i < challenges.size(); i++) {
            Challenge challenge1 = challenges.get(i);
            if (challenge1.getMonth().equalsIgnoreCase(month)){
                return challenge1;
            }
        }
        return null;
    }

    public boolean updateCh1(Long id, Challenge challenge1) {
        for (int i = 0; i < challenges.size(); i++) {
            Challenge nChallenge1 = challenges.get(i);
            if (nChallenge1.getId().equals(id)){
                nChallenge1.setMonth(challenge1.getMonth());
                nChallenge1.setDescription(challenge1.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}
