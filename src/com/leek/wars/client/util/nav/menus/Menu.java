package com.leek.wars.client.util.nav.menus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.leek.wars.client.util.UserInputUtil;

public abstract class Menu extends AbstractMenu {

	public Menu(String label) {
		super(label);
	}
	
	@Override
	public AbstractMenu run(AbstractMenu caller, Map<MenuProperties, Object> properties) {
		System.out.println("##############");
		System.out.println(getLabel());
		
		List<AbstractMenu> menus = getMenuOptions();
		List<String> optionLabels = menus.stream()
				.map(AbstractMenu::getLabel)
				.collect(Collectors.toList());
		int choice = UserInputUtil.INSTANCE.askChoice(null, true, optionLabels);
		
		if (choice == -1) {
			return null;
		}
		
		return menus.get(choice);
	}
	
	protected abstract List<AbstractMenu> getMenuOptions();
}
