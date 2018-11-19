package com.lxisoft.snakeNladder.model;

public class Component{
	private int id;
	
	private Cell start;
	
	private Cell end;
	
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setStart(Cell start)
	{
		this.start=start;
	}
	public Cell getStart()
	{
		return start;
	}
	public void setEnd(Cell end)
	{
		this.end=end;
	}
	public Cell getEnd()
	{
		return end;
	}

}