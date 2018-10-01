package com.leek.wars.client.util.nav.menus.impl;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.Menu;
import com.leek.wars.client.util.nav.menus.MenuProperties;

public class HomeMenu extends Menu {

	public HomeMenu() {
		super("Home menu");
	}

	@Override
	protected List<MenuProperties> getNeededProperties() {
		return new ArrayList<>();
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		// TODO Auto-generated method stub
		return null;
	}

}
