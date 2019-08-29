package com.emily.conways.service;

import com.emily.conways.model.CellGrid;
import com.emily.conways.model.Coordinates;

import java.util.ArrayList;

public interface GameRules {
    ArrayList<Coordinates> decideCellFate(CellGrid cellGrid);
}
