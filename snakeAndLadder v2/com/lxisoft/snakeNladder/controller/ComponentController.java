package com.lxisoft.snakeNladder.controller;
import java.util.*;
import com.lxisoft.snakeNladder.model.*;

public class ComponentController{
ArrayList<Component> components=new ArrayList<Component>();

	public void setComponents(Component... addComponents) { 
		for(Component addComponent:addComponents){
		
			components.add(addComponent);
		}
	}
	public ArrayList<Component> getComponents(){
		
		return components;		
	}
	
}