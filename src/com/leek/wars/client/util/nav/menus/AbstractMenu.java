package com.leek.wars.client.util.nav.menus;

import java.util.List;
import java.util.Map;

public abstract class AbstractMenu {

	private String label;
	
	public AbstractMenu(String label) {
		this.label = label;
	}
	
	/**
	 * executes the treatment of an abstract menu
	 * @param caller calling abstract menu
	 * @param properties properties used by the treatment
	 * @return nextMenu
	 */
	public abstract AbstractMenu run(AbstractMenu caller, Map<MenuProperties, Object> properties);
	
	protected abstract List<MenuProperties> getNeededProperties();
	
	public String getLabel() {
		return label;
	}
}
