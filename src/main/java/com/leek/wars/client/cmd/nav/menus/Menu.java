package com.leek.wars.client.cmd.nav.menus;

import java.io.IOException;
import java.util.List;

import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.exceptions.ServerException;

public abstract class Menu extends AbstractMenu {

	private String description;
	
	public Menu(AbstractMenu containingMenu, String label, String description) {
		super(containingMenu, label);
		this.description = description;
	}

	@Override
	public AbstractMenu run(AbstractMenu caller) throws ServerException, IOException {
		System.out.println("##############");
		System.out.println(getLabel());

		List<AbstractMenu> menus = getMenuOptions();
		if (getContainingMenu() != null) {
			menus.add(getContainingMenu());
		}

		Object[] optionLabels = menus.stream()
				.map(AbstractMenu::getLabel)
				.toArray();
		int choice = UserInputUtil.INSTANCE.askChoice(description, true, optionLabels);

		if (choice == -1) {
			return null;
		}

		return menus.get(choice);
	}

	protected abstract List<AbstractMenu> getMenuOptions() throws ServerException, IOException;
}
