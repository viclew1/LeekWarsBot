package com.leek.wars.client.util.nav.actions.impl;

import java.util.List;
import java.util.Map;

import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.nav.actions.Action;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.MenuProperties;

public class RegisterAllAction extends Action {

	public RegisterAllAction() {
		super("Register all");
	}

	@Override
	protected AbstractMenu processAction(AbstractMenu caller, Map<MenuProperties, Object> properties) throws ActionException {
		//TODO impl
		return caller;
	}

	@Override
	protected List<MenuProperties> getNeededProperties() {
		// TODO Auto-generated method stub
		return null;
	}

}
