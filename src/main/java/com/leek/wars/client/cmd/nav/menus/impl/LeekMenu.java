package com.leek.wars.client.cmd.nav.menus.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.leek.wars.client.cmd.nav.actions.impl.AutoFightAction;
import com.leek.wars.client.cmd.nav.actions.impl.ManualFightAction;
import com.leek.wars.client.cmd.nav.menus.AbstractMenu;
import com.leek.wars.client.cmd.nav.menus.Menu;
import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.util.exceptions.ServerException;

public class LeekMenu extends Menu {

	private Leek leek;
	private String token;
	
	public LeekMenu(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu, "Leek menu : " + leek.toSimpleString(), null);
		this.leek = leek;
		this.token = token;
	}

	@Override
	protected List<AbstractMenu> getMenuOptions() throws ServerException, IOException {
		List<AbstractMenu> menus = new ArrayList<>();
		menus.add(new AutoFightAction(this, token, leek));
		menus.add(new ManualFightAction(this, token, leek));
		return menus;
	}

}
