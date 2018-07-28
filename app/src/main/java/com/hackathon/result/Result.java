package com.hackathon.result;

import com.hackathon.candidate.Candidate;

public class Result {
    private Candidate candidate;
    private int vote;

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
