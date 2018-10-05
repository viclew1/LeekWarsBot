package com.leek.wars.client.util.nav.menus.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.actions.impl.AutoFightAction;
import com.leek.wars.client.util.nav.actions.impl.ManualFightAction;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.Menu;

public class LeekMenu extends Menu {

	private Leek leek;
	private String token;
	
	public LeekMenu(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu, "Leek menu : " + leek.toSimpleString());
		this.leek = leek;
		this.token = token;
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() throws ServerException, IOException {
		List<AbstractMenu> menus = new ArrayList<>();
		menus.add(new AutoFightAction(this, token, leek, 5));
		menus.add(new ManualFightAction(this, token, leek));
		return menus;
	}

}
