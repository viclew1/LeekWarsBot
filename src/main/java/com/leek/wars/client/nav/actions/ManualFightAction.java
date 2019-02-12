package com.leek.wars.client.nav.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.leek.wars.client.entities.Leek;
import com.leek.wars.client.entities.responses.OpponentLeeksResponse;
import com.leek.wars.client.util.UserInputUtil;
import com.leek.wars.client.util.exceptions.ServerException;
import com.leek.wars.client.util.rest.RequestProcessor;

import fr.lewon.client.menus.AbstractMenu;
import fr.lewon.client.menus.Action;

public class ManualFightAction extends Action {

	private static final Logger logger = LoggerFactory.getLogger(ManualFightAction.class);
	
	private Leek leek;
	private String token;
	
	public ManualFightAction(AbstractMenu containingMenu, String token, Leek leek) {
		super(containingMenu, "Manual Fight");
		this.leek = leek;
		this.token = token;
	}

	@Override
	public AbstractMenu processAction(AbstractMenu caller) {
		try {
			OpponentLeeksResponse olr = RequestProcessor.INSTANCE.getLeekOpponents(leek.getId(), token);
			Object[] choices = olr.getOpponents().stream()
					.map(Leek::toSimpleString)
					.toArray();
			int choice = UserInputUtil.INSTANCE.askChoice("Opponents : ", true, choices);
			
			if (choice == -1) {
				return caller;
			}
			
			RequestProcessor.INSTANCE.startLeekFight(leek.getId(), olr.getOpponents().get(choice).getId(), token);
		} catch (ServerException | IOException e) {
			logger.error("", e);
		}
		return caller;
	}

}
