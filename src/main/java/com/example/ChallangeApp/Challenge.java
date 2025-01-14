package com.example.ChallangeApp;

public class Challenge {
    private Long id;
    private String month;
    private String description;

    public Challenge(Long id, String month, String description) {
        this.id = id;
        this.month = month;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    // this is a comment to show the diff.
    public void dummy(){
        for (int i = 0; i < 6; i++) {
            System.out.println("nothing");
        }
    }
    public void dummy2(){
        for (int i = 0; i < 6; i++) {
            System.out.println("nothing");
        }
    }
}
