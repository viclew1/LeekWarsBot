package com.leek.wars.client.util.nav.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.util.exceptions.ActionException;
import com.leek.wars.client.util.nav.menus.AbstractMenu;

public abstract class Action extends AbstractMenu {

	private static final Logger logger = LoggerFactory.getLogger(Action.class);
	
	public Action(AbstractMenu containingMenu, String label) {
		super(containingMenu, label);
	}

	@Override
	public AbstractMenu run(AbstractMenu caller) {
		try {
			return processAction(caller);
		} catch (ActionException e) {
			logger.error("Error in executing action : ", e);
			return caller;
		}
	}

	protected abstract AbstractMenu processAction(AbstractMenu caller) throws ActionException;

}
