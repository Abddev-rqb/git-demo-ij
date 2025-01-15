package com.example.ChallangeApp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChallengeController {
    private ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService1){
        this.challengeService = challengeService1;
    }
    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
        return new ResponseEntity<>(challengeService.getChallenges(), HttpStatus.OK);
    }
    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean addResult = challengeService.addChallenge(challenge);
        if (addResult){
            return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not Created", HttpStatus.OK);
        }
    }
    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getMonth(@PathVariable String month){
        Challenge monthResult = challengeService.getMonth(month);
        if (monthResult != null){
            return new ResponseEntity<>(monthResult, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(monthResult, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/challenges/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge challenge1){
        boolean updateResult = challengeService.updateCh1(id, challenge1);
        if (updateResult){
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Not Updated", HttpStatus.NO_CONTENT);
        }

    }
    @DeleteMapping("challenges/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean delResult = challengeService.deleteChallenge(id);
        if (delResult){
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Cannot Delete", HttpStatus.NOT_FOUND);
        }

    }
}
