package com.comet.serverapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ModelResult {
    public List<List<Double>> boxes;
    public List<Integer> classes;
    public List<Double> probs;
}
