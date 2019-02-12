package com.leek.wars.client.nav.menus;

import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.nav.actions.AutoFightAction;
import com.leek.wars.client.nav.actions.ManualFightAction;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Menu;

public class LeekMenu extends Menu {

	private Leek leek;
	private String token;
	
	public LeekMenu(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu, "Leek menu : " + leek.toSimpleString(), null);
		this.leek = leek;
		this.token = token;
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() {
		List<AbstractMenu> menus = new ArrayList<>();
		menus.add(new AutoFightAction(this, token, leek));
		menus.add(new ManualFightAction(this, token, leek));
		return menus;
	}

}
