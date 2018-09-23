package com.lxisoft.balu.inventory.controller;
import com.lxisoft.balu.inventory.model.*;

public abstract class InventoryController {


// List<Products> inventory ;



public abstract void addStockToInventory( Product productToAdd, int quantitytoadd) ;



public abstract void removeStockFromInventory( Product productToRemove, int quantityToRemove) ;






}
