package com.lxisoft.snakeNladder.model;

public class Board{
	
	private Cell cell;
	private Snake snake;
	private Ladder ladder;
	
	public Cell getCell() {
	return cell;
	}

	public void setCell(Cell cell) {
	this.cell = cell;
	}

	public Snake getSnake() {
	return snake;
	}

	public void setSnake(Snake snake) {
	this.snake= snake;
	}

	public Ladder getLadder() {
	return ladder;
	}

	public void setLadder(Ladder ladder) {
	this.ladder = ladder;
	}
}