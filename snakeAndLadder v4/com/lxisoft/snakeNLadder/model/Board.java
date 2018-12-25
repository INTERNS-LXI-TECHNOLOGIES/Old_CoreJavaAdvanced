package com.lxisoft.snakeNLadder.model;

public class Board{
	
	private Cells cell;
	private Snakes snake;
	private Ladders ladder;
	
	public Cells getCell() {
	return cell;
	}

	public void setCell(Cells cell) {
	this.cell = cell;
	}

	public Snakes getSnake() {
	return snake;
	}

	public void setSnake(Snakes snake) {
	this.snake= snake;
	}

	public Ladders getLadder() {
	return ladder;
	}

	public void setLadder(Ladders ladder) {
	this.ladder = ladder;
	}
}