package com.example.sistemavotacion.Model;

import java.time.LocalDateTime;

public class Vote {
    private int candidateId;
    private int voterId;
    private LocalDateTime date;

    public Vote(int candidateId, int voterId, LocalDateTime date) {
        this.candidateId = candidateId;
        this.voterId = voterId;
        this.date = date;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

