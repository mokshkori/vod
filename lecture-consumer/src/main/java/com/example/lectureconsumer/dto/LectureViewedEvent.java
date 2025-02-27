package com.example.lectureconsumer.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class LectureViewedEvent {
    private final String userId;
    private final String lectureId;
    private final String millisecondsWatched;
    private long timestamp;
}
