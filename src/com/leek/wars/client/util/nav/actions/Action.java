package com.leek.wars.client.util.nav.actions;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.nav.menus.AbstractMenu;
import com.leek.wars.client.util.nav.menus.MenuProperties;

public abstract class Action extends AbstractMenu {

	private static final Logger logger = LoggerFactory.getLogger(Action.class);
	
	public Action(String label) {
		super(label);
	}

	@Override
	public AbstractMenu run(AbstractMenu caller, Map<MenuProperties, Object> properties) {
		try {
			return processAction(caller, properties);
		} catch (ActionException e) {
			logger.error("Error in executing action : ", e);
			return caller;
		}
	}

	protected abstract AbstractMenu processAction(AbstractMenu caller, Map<MenuProperties, Object> properties) throws ActionException;

	
}
