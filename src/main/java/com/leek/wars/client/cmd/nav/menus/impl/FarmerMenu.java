package com.leek.wars.client.cmd.nav.menus.impl;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.actions.impl.RegisterAllAction;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.Menu;
import com.leek.wars.client.entities.Farmer;
import com.leek.wars.client.entities.Leek;

public class FarmerMenu extends Menu {

	private String token;
	private Farmer farmer;
	
	public FarmerMenu(AbstractMenu containingMenu, String token, Farmer farmer) {
		super(containingMenu, "Farmer menu - " + farmer.getName());
		this.farmer = farmer;
		this.token = token;
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		List<AbstractMenu> menus = new ArrayList<>();
		menus.add(new RegisterAllAction(this, token, farmer.getLeeks()));
		for (Leek l : farmer.getLeeks().values()) {
			menus.add(new LeekMenu(this, token, l));
		}
		return menus;
	}

}
