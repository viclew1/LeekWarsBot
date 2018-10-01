package com.leek.wars.client.util.nav.actions.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leek.wars.client.entities.responses.SessionResponse;
import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.nav.actions.Action;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.MenuProperties;
import com.leek.wars.client.util.rest.RequestProcessor;

public class FightAction extends Action {

	public FightAction() {
		super("Fight");
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller, Map<MenuProperties, Object> properties) throws ActionException {
		Long leek = (Long) properties.get(MenuProperties.LEEK);
		Long target = (Long) properties.get(MenuProperties.ENEMY_LEEK);
		SessionResponse session = (SessionResponse) properties.get(MenuProperties.SESSION);
		try {
			RequestProcessor.INSTANCE.startLeekFight(leek, target, session.getToken());
		} catch (ServerException | IOException e) {
			throw new ActionException(e);
		}
		return caller;
	}

	@Override
	protected List<MenuProperties> getNeededProperties() {
		List<MenuProperties> neededProperties = new ArrayList<>();
		neededProperties.add(MenuProperties.SESSION);
		neededProperties.add(MenuProperties.LEEK);
		neededProperties.add(MenuProperties.ENEMY_LEEK);
		return neededProperties;
	}
}
