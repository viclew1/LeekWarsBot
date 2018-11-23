package com.leek.wars.client.cmd.nav.menus.impl;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.Menu;
import com.leek.wars.client.entities.responses.SessionResponse;

public class HomeMenu extends Menu {

	private SessionResponse session;
	
	public HomeMenu(AbstractMenu containingMenu, SessionResponse session) {
		super(containingMenu, "Home menu");
		this.session = session;
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		List<AbstractMenu> menus = new ArrayList<>();
		menus.add(new FarmerMenu(this, session.getToken(), session.getFarmer()));
		return menus;
	}

}
