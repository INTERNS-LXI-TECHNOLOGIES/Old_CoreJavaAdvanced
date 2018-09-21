package com.lxisoft.balu.inventory.controlle;


public abstract class InventoryControll {


// List<Products> inventory ;


@override
public abstract void addStockToInventory( Product productToAdd, size quantitytoadd) ;


@override
public abstract void removeStockFromInventory( Product productToRemove, size quantityToRemove) ;






}
