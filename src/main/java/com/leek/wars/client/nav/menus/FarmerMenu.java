package com.leek.wars.client.nav.menus;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.entities.Farmer;
import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.nav.actions.RegisterAllAction;
import com.leek.wars.client.nav.actions.SaveAisAction;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Menu;

public class FarmerMenu extends Menu {

	private String token;
	private Farmer farmer;
	
	public FarmerMenu(AbstractMenu containingMenu, String token, Farmer farmer) {
		super(containingMenu, "Farmer menu - " + farmer.getName(), null);
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
		menus.add(new SaveAisAction(this, farmer.getName(), token));
		return menus;
	}

}
