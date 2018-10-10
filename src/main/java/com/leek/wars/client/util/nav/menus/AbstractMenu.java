package com.leek.wars.client.util.nav.menus;

import java.io.IOException;

import com.leek.wars.client.util.exceptions.ServerException;

public abstract class AbstractMenu {

	private final String label;
	private final AbstractMenu containingMenu;
	
	public AbstractMenu(AbstractMenu containingMenu, String label) {
		this.containingMenu = containingMenu;
		this.label = label;
	}
	
	/**
	 * executes the treatment of an abstract menu
	 * @param caller calling abstract menu
	 * @return nextMenu
	 * @throws IOException 
	 * @throws ServerException 
	 */
	public abstract AbstractMenu run(AbstractMenu caller) throws ServerException, IOException;
	
	public String getLabel() {
		return label;
	}

	public AbstractMenu getContainingMenu() {
		return containingMenu;
	}
}
